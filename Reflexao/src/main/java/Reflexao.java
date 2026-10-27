import model.Trabalhador;

import java.lang.reflect.Field;

public class Reflexao {

    public static void main(String[] args) {

        Class classe = Trabalhador.class;

        System.out.println("CLASSE: " + classe.getCanonicalName());
        System.out.println("CLASSE: " + classe.getSimpleName());

        Field[] atributos = classe.getDeclaredFields();

        for (int i = 0; i < atributos.length; i++) {
            Field f = atributos[i];
            System.out.println(f.getName() + " " + f.getType().toString());
        }
    }

    public static String getCreateTable(Class classe) {
        Field[] atributos = classe.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append("CREATE TABLE ");
        sb.append(classe.getSimpleName().toLowerCase());
        sb.append("(");
        for (int i = 0; i < atributos.length; i++) {
            Field f = atributos[i];
            sb.append(f.getName());
            sb.append(" ");
            sb.append(Reflexao.converteParaTipoSQL(f.getType().toString()));

            if (i < atributos.length - 1) //se nao chegou no ultimo item da lista
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    private static String converteParaTipoSQL(String tipo) {
        if (tipo.contains("String"))
            return "varchar(255)";
        else if (tipo.contains("LocalDate"))
            return "date";
        else if (tipo.equals("int"))
            return "number(6, 0)";
        else if (tipo.equals("long"))
            return "number";
        else
            return "number(8, 2)";
    }
}
