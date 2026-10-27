import model.Trabalhador;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class Reflexao {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class classe = Trabalhador.class;

        System.out.println("CLASSE: " + classe.getCanonicalName());
        System.out.println("CLASSE: " + classe.getSimpleName());

        Field[] atributos = classe.getDeclaredFields();

        for (int i = 0; i < atributos.length; i++) {
            Field f = atributos[i];
            System.out.println(f.getName() + " " + f.getType().toString());
        }

        Trabalhador t = new Trabalhador(34234, 1, LocalDate.of(1980, 12, 15), "Kevin Arnold", 4500, "(11) 343242");

        Trabalhador s = new Trabalhador(732423, 2, LocalDate.of(1982, 7, 15), "Winnie Cooper", 6500, "(11) 7282323");


        //Quero transformar esses objetos em JSON:
        Method[] metodos = classe.getDeclaredMethods();

        StringBuffer sb = new StringBuffer("{");

        for(Method m : metodos) {
            System.out.println(m.getName() + " " + m.getReturnType().toString());
            if (m.getName().startsWith("get")) {
                sb.append("'");
                sb.append(m.getName().toLowerCase().replace("get", ""));

                String tipoRetorno = m.getReturnType().toString();
                if (tipoRetorno.contains("String") || tipoRetorno.contains("Date")) {
                    sb.append("': '");
                    sb.append(m.invoke(t).toString());
                    sb.append("', ");
                }
                else {
                    sb.append("': ");
                    sb.append(m.invoke(t).toString());
                    sb.append(", ");
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        System.out.println(sb);
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
