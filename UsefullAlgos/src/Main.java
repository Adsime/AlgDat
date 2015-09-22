import Hjelpeklasser.Tabell;

import java.util.Arrays;

/**
 * Created by Adrian on 18/08/2015.
 */
public class Main {


    public static void main(String... args){

        String[] s = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(s);
        System.out.println(Arrays.toString(s));


    }


}
