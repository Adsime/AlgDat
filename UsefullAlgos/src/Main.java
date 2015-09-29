import Arbeidsklasser.Person;
import Hjelpeklasser.Komparator;
import Hjelpeklasser.Tabell;

import java.util.Arrays;

/**
 * Created by Adrian on 18/08/2015.
 */
public class Main {


    public static void main(String... args) {

        

    }


    /* 1.4.7)
        String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Tabell.innsettingssortering(s, Komparator.orden(x -> -x.length()));
        System.out.println(Arrays.toString(s));
     */

    /* 1.4.8
        String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        //s = {"21","18","8","13","20","6","16","25","3","10"};
        Komparator<String> c = Komparator.orden((String::length)).deretter(x -> x);
        Tabell.innsettingssortering(s, c);
        System.out.println(Arrays.toString(s));
     */

}
