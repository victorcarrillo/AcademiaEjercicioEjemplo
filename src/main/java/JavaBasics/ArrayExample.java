package JavaBasics;

import java.util.ArrayList;

public class ArrayExample {

    public static void main(String[] args){

        ArrayList obj = new ArrayList();
        obj.add("Victor");
        obj.add(33);
        obj.add(12.34);
        obj.add('M');

        System.out.println(obj.get(1));

        obj.size();

        for(int i=0; i<obj.size();i++)
        {
            System.out.println("Valor del indice "+i+" es igual a "  +obj.get(i));
        }

    }
}
