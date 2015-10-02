import Arbeidsklasser.Person;
import Hjelpeklasser.Komparator;
import Hjelpeklasser.Tabell;

import java.util.Arrays;
import java.util.Comparator;

import static Hjelpeklasser.Tabell.*;

/**
 * Created by Adrian on 18/08/2015.
 */
public class Main {


    public static void main(String... args) {

        Integer[] i = Tabell.randPermInteger(10);
        Tabell.flettesortering(i, Comparator.comparing(Integer::intValue));
        System.out.println(Arrays.toString(i));

    }


    /* 1.4.7)
        String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Tabell.innsettingssortering(s, Komparator.orden(x -> -x.length()));
        System.out.println(Arrays.toString(s));
     */

    /* 1.4.8)
        String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        //s = {"21","18","8","13","20","6","16","25","3","10"};
        Komparator<String> c = Komparator.orden((String::length)).deretter(x -> x);
        Tabell.innsettingssortering(s, c);
        System.out.println(Arrays.toString(s));
     */

    /* 1.4.9)
     1)
        String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
        Comparator<String> c =  Comparator.comparing(String::length);  // etter lengde
        int t = Tabell.maks(s, c.thenComparing(x -> x));       // vanlig orden
        System.out.println(Arrays.toString(s));
        System.out.println(s[t]);

        2)
        b)
        Integer[] a = Tabell.randPermInteger(10);
        Integer i = 5;
        int f = binarySearch(a, i, Comparator.comparing(Integer::intValue));
        System.out.println(a[f]);

        c)
     */

}
