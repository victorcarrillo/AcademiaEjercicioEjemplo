package JavaBasics.Polimorfismo;

public class Polimorfismo {


    public static void main(String[] args){

        Polimorfismo obj = new Polimorfismo();
        obj.sumaNumeros();
        obj.sumaNumeros(3);
        obj.sumaNumeros("Victor");
        obj.sumaNumeros(10,"Hola");
        obj.sumaNumeros("mundo",20);

    }

    public void sumaNumeros(){
        System.out.println("Metodo que suma Numeros");
    }

    public void sumaNumeros(int a){
        System.out.println("Metodo suma numero " + a);
    }

    public void sumaNumeros(String x){
        System.out.println("Metodo que suma variable " + x);
    }

    public void sumaNumeros(int b , String y){
        System.out.println("Metodo que tiene numero " + b +" y tiene variable :" + y);
    }

    public void sumaNumeros(String y ,int b ){
        System.out.println("Metodo 2 que tiene numero " + b +" y tiene variable 2 :" + y);
    }
}
