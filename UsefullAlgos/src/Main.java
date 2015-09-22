import Hjelpeklasser.Tabell;
import javafx.scene.control.Tab;
import week1.SimpleAlgorithms;

import java.util.Arrays;

/**
 * Created by Adrian on 18/08/2015.
 */
public class Main {

    public static void main(String[] args) {

        int[] a = Tabell.randPerm(10000000);
        int[] b = Arrays.copyOf(a, a.length);

        long tid = System.currentTimeMillis();
        Tabell.flettesortering(b);
        System.out.println(System.currentTimeMillis() - tid);

        b = Arrays.copyOf(a, a.length);
        tid = System.currentTimeMillis();
        Tabell.kvikksortering(b);
        System.out.println(System.currentTimeMillis() - tid);

        b = Arrays.copyOf(a, a.length);
        tid = System.currentTimeMillis();
        Arrays.sort(b);
        System.out.println(System.currentTimeMillis() - tid);
    }

}
