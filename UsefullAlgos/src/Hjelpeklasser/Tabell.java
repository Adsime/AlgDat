package Hjelpeklasser;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by Adrian on 25/08/2015.
 */
public class Tabell {

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void bytt(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    //SKRIVMETODER

    public static void skriv(int[] a, int fra, int til) {

        if(a == null) {
            throw new NullPointerException("a er ikke et objekt");
        }

        fratilKontroll(a.length, fra, til);

        fratilKontroll(a.length, fra, til);
        for(int i = fra; i < til; i++) {
            System.out.print(" " + a[i]);
        }
    }

    public static void skriv(int[] a) {
        skriv(a, 0, a.length);
    }

    public static void skrivln(int[] a, int fra, int til) {
        skriv(a, fra, til);
        System.out.println();
    }

    public static void skrivln(int[] a) {
        skrivln(a, 0, a.length);
    }

    // END SKRIVMETODER

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    public static int[] randPerm(int n)  // virker, men er ineffektiv
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

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

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

    public static int min(int[] a) {

        if(a.length < 1) {
            throw new NoSuchElementException("a er tom");
        }
        int sist = a.length-1;
        int m = 0;
        int minverdi = a[0];
        int temp = a[sist];
        a[sist] = minverdi;

        for(int i = 0; ; i++) {
            if(a[i] <= minverdi) {
                if(i == sist) {
                    a[sist] = temp;
                    return temp <= minverdi ? sist : m;
                } else {
                    minverdi = a[i];
                    a[sist] = minverdi;
                    m = i;
                }
            }
        }
    }

    public static int maks(int[] a, int fra, int til)
    {
        if(a == null) {
            throw new NullPointerException("Tomt array-objekt");
        }

        if (fra < 0 || til > a.length || fra > til)
            throw new IllegalArgumentException("Illegalt intervall!");

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;
        int maksverdi = a[fra];

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;
                maksverdi = a[m];
            }
        }
        return m;
    }

    public static int[] snu(int[] a, int v, int h) {

        vhKontroll(a.length, v, h);
        int j = 0;

        int[] returnArray = new int[a.length];
        for(int i = h; i >= v; i--) {
            returnArray[j++] = a[i];
        }
        return returnArray;
    }

    /*public static int[] nestMaks(int[] a)
    {
        int n = a.length;

        if (n < 2) throw
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);

        int nm;

        if (m == 0)
        {
            nm = maks(a,1,n);
        }
        else if (m == n-1)
        {
            nm = maks(a,0,n-1);
        }
        else
        {
            int mv = maks(a,0,m);
            int mh = maks(a,m+1,n);
            nm = a[mh] > a[mv] ? mh : mv;
        }

        return new int[] {m,nm};

    }*/

   /* public static int[] nestmaks(int[] a) {
        if(a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom");
        }

        int maksindeks = maks(a);
        int maks = a[maksindeks];
        a[maksindeks] = 0;
        int nestmaks = maks(a);
        a[maksindeks] = maks;
        return new int[] {maksindeks, nestmaks};
    }

    public static void snu(int[] a) {
        snu(a, 0, a.length);
    }*/

    public static int[] nestMaks(int[] a) {
        int n = a.length;     // tabellens lengde
        if (n < 2) throw      // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = 0;      // m er posisjonen til største verdi
        int nm = 1;     // nm er posisjonen til nest største verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[1] > a[0]) {
            m = 1; nm = 0;
        }

        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];           // nest største verdi

        for (int i = 2; i < n; i++) {
            if (a[i] > nestmaksverdi) {
                if (a[i] > maksverdi) {
                    nm = m;
                    nestmaksverdi = maksverdi;     // ny nest størst

                    m = i;
                    maksverdi = a[m];              // ny størst
                }
                else {
                    nm = i;
                    nestmaksverdi = a[nm];         // ny nest størst
                }
            }
        } // for

        return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1

    } // nestMaks

    public static int[] nestMin(int[] a) {
        int n = a.length;
        if(n < 2) {
            throw new NoSuchElementException("Tabellen kan ikke jobbes med");
        }
        int m = 0;
        int nm = 1;

        if(a[nm] < a[m]) {
            m = 1; nm = 0;
        }

        int minverdi = a[m];
        int nestminstverdi = a[nm];

        for(int i = 2; i < n; i++) {
            if(a[i] < nestminstverdi) {
                if(a[i] < minverdi) {
                    nm = m;
                    nestminstverdi = minverdi;
                    m = i;
                    minverdi = a[i];
                } else {
                    nm = i;
                    nestminstverdi = a[i];
                }
            }
        } return new int[] {m, nm};
    }

    // Parter

    public static int parter(int[] a, int v, int h, int skilleverdi)
    {
        while (v <= h && a[v] < skilleverdi) v++;     // h er stoppverdi for v
        while (v <= h && a[h] >= skilleverdi) h--;    // v er stoppverdi for h

        while (true)                                  // stopper når v >= h
        {
            if (v < h) Tabell.bytt(a,v++,h--);          // bytter om a[v] og a[h]
            else  return v;                             // partisjoneringen er ferdig
            while (a[v] < skilleverdi) v++;             // flytter v mot høyre
            while (a[h] >= skilleverdi) h--;            // flytter h mot venstre
        }
    }
}
