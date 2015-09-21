package week1;

import java.util.*;

/**
 * Created by Adrian on 18/08/2015.
 */
public class SimpleAlgorithms {


    //MAKSMETODER
    //VERSJON 1

    public static int maksTreg(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("a er tom");
        }

        int m = 0;

        for(int i = 1; i < a.length; i++) {
            if(a[i] > a[m]) {
                m = i;
            }
        }
        return m;
    }

    //VERSJON 2

    public static int maksv2(int[] a) {
        int m = 0;
        int maksVerdi = a[0];

        for(int i = 1; i < a.length; i++) {
            if(a[i] > maksVerdi) {
                maksVerdi = a[i];
                m = i;
            }
        }
        return m;
    }

    //VERSJON 3

    public static int maks(int[] a) {

        if(a.length < 1) {
            throw new NoSuchElementException("a er tom");
        }
        int sist = a.length-1;
        int m = 0;
        int maksverdi = a[0];
        int temp = a[sist];
        a[sist] = maksverdi;

        for(int i = 0; ;i++) {
            if(a[i] >= maksverdi) {
                if(i == sist) {
                    a[sist] = temp;
                    return temp >= maksverdi ? sist : m;
                }
                else {
                    maksverdi = a[i];
                    a[sist] = maksverdi;
                    m = i;
                }
            }
        }
    }

    //END MAKSMETODER


    //START MINMETODER

    public static int min(int[] a) {
        if(a.length < 1) {
            throw new NoSuchElementException("a er tom");
        }

        int m = 0;

        for(int i = 1; i < a.length; i++) {
            if(a[i] < a[m]) {
                m = i;
            }
        }

        return m;
    }

    //END MINMETODER


    //START MINMAKSMETODER

    public static int[] minmaks(int[] a) {
        if(a.length < 1) {
            throw new NoSuchElementException("a er tom");
        }

        int minIndex, maxIndex;
        minIndex = maxIndex = 0;

        for(int i = 0; i < a.length; i++) {
            if(a[i] > a[maxIndex]) {
                maxIndex = i;
            }
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        int[] returnValue = {minIndex, maxIndex};
        return returnValue;
    }

    //END MINMAKSMETODER

    //START FAKULTETSMETODER

    public static long fak(int n) {
        if(n == 0) {
            throw new NumberFormatException("Kan ikke regnes ut");
        }
        int returnValue = n;
        for(int i = n-1; i > 0; i--) {
            returnValue *= i;
        }
        return returnValue;
    }

    //END FAKULTETSMETODER

    //START HARMONISKETALL

    public static double harmonisk(int n) {
        double returnValue = 0.0;

        for(int i = n; i > 0; i--) {
            returnValue += 1.0/i;
        }

        return returnValue;
    }

    //END HARMONISKE TALL

    public static void makstest()
    {
        int[] a = {8,3,5,7,9,6,10,2,1,4};  // maksverdien 10 er i posisjon 6
        int antallfeil = 0;

        if (maksv2(a) != 6) {  // kaller maks-metoden
            System.out.println("Kodefeil: Gir feil posisjon for maksverdien!");
            antallfeil++;
        }

        a = new int[] {10,8,9,4,5,2,3,7,1,6};

        if(maks(a) != 0) {
            System.out.println("Feil posisjon i nr 1");
            antallfeil++;
        }

        a = new int[] {1,10,3,4,5,2,7,6,8,9};

        if(maksv2(a) != 1) {
            System.out.println("Feil i posisjon i nr 2");
            antallfeil++;
        }

        a = new int[] {1};

        if(maks(a) != 0) {
            System.out.println("Feil i posisjon i nr 3");
            antallfeil++;
        }

        a = new int[] {1,1};

        if(maks(a) != 0) {
            System.out.println("Feil i posisjon i nr 4");
            antallfeil++;
        }

        if(maks(a) != 1) {
            System.out.println("Feil i posisjon i nr 5");
            antallfeil++;
        }

        a = new int[0];  // en tom tabell, lengde lik 0
        boolean unntak = false;

        try
        {
            maks(a);  // kaller maks-metoden
        }
        catch (Exception e)
        {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException)) {
                System.out.println("Kodefeil: Feil unntak for en tom tabell!");
                antallfeil++;
            }
        }

        if (!unntak) {
            System.out.println("Kodefeil: Mangler unntak for en tom tabell!");
            antallfeil++;
        }

        System.out.println(antallfeil);
    }

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPermArray(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int[] randPermTreg(int n)  // virker, men er ineffektiv
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall
        //boolean[] har = new boolean[n];  // en boolsk tabell

        for (int i = 1; i <= n; )         // vi skal legge inn n tall
        {
            int k = r.nextInt(n);          // trekker en indeks k
            if (a[k] == 0)           // sjekker
            {
                a[k] = i;               // oppdaterer den boolske tabellen
                i++;              // legger inn k + 1 i a
            }
        }
        return a;                        // tabellen returneres
    }

    public static int[] randPerm1(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static int[] shuffleArray(int n) {
        int[] a = new int[n];

        ArrayList arrayList = new ArrayList();

        for(int i = 0; i < n; i++) {
            arrayList.add(i+1);
        }

        Collections.shuffle(arrayList);

        System.out.println(Arrays.toString(arrayList.toArray()));

        return a;
    }
}
