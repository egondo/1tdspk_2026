public class Exemplo {


    public static void main() {

        CanalYoutube arjunCode = new CanalYoutube("Arjun Code");

        Assinante edu = new Assinante("Eduardo");
        Assinante joao = new Assinante("Joao Kleber");
        Assinante linus = new Assinante("Linus Torvald");

        arjunCode.subscribe(edu);
        arjunCode.subscribe(joao);
        arjunCode.subscribe(linus);

        CanalYoutube outroCanal = new CanalYoutube("Hashtag Programação");
        arjunCode.subscribe(outroCanal);

        arjunCode.addVideo("Classes ABC no Python");





    }


}
