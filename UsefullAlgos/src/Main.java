import Hjelpeklasser.Tabell;

import java.util.Arrays;

/**
 * Created by Adrian on 18/08/2015.
 */
public class Main {

    public static void main(String[] args) {


        int[] a = {13,2,8,10,16,9,15,4,18,14,12,11,7,5,3,6,17,1,20,19};
        Tabell.parter(a,0,a.length-1,11);    // bruker 11 som skilleverdi
        System.out.println(Arrays.toString(a));
    }

}
