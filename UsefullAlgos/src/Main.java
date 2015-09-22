import Hjelpeklasser.Tabell;

import java.util.Arrays;

/**
 * Created by Adrian on 18/08/2015.
 */
public class Main {


    public static void main(String... args) {

        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        String[] b = {"Hei", "på", "deg", "dette", "er", "en", "test"};

        Tabell.bytt(b, 1, 2);
        System.out.println(Arrays.toString(b));

    }

}
