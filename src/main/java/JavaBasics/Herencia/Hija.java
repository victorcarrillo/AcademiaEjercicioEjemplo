package JavaBasics.Herencia;

public class Hija extends Padre{

    public static void main(String[] args){
        //Escenario 1 :
        Hija obj = new Hija();
        obj.suma();
        obj.resta();
        obj.multiplica();
        obj.division();

        //Escenario 2 :
        Padre obj2 = new Padre();
        obj2.suma();

        //Escenario 3 :
        Padre obj3 = new Hija();
        obj3.suma();
        obj3.multiplica();

        //Escenario 4 :
        //Hija obj4 = new Padre();
    }

    public void division(){
        System.out.println("Este metodo divide numeros");
    }
}
