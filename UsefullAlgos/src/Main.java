import Arbeidsklasser.Heltall;
import Arbeidsklasser.Komparator;
import Arbeidsklasser.Person;
import Arbeidsklasser.Student;
import Hjelpeklasser.Tabell;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Adrian on 18/08/2015.
 */
public class Main {


    public static void main(String... args) {

        Student[] s = new Student[6];                       // en studenttabell
        s[0] = new Student("Kari","Svendsen","2AA");        // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic","2IA");      // Boris Zukanovic
        s[2] = new Student("Tiss", "Tass", "2CA");
        s[3] = new Student("Ali","Kahn","2IA");             // Ali Kahn
        s[4] = new Student("Azra","Zukanovic","2IA");       // Azra Zukanovic
        s[5] = new Student("Kari","Pettersen","2AA");       // Kari Pettersen


        Komparator<Student> c = (s1,s2) -> {
            String t1 = s1.klasse(), t2 = s2.klasse();
            int k = t1.charAt(0) - t2.charAt(0);
            if(k != 0) return k;
            k = t1.charAt(1) - t2.charAt(1);
            if(k != 0) return k;
            return t1.charAt(2) - t2.charAt(2);
        };

        Tabell.innsettingssortering(s, c);
        System.out.println(Arrays.toString(s));

    }

}
