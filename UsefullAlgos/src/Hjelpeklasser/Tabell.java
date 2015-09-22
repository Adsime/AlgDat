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

        if (fra > til)                                // fra er stï¿½rre enn til
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

    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static int maks(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }

    public static int maks(char[] a) {

        int m = 0;
        char maksverdi = a[0];

        for(int i = 1; i < a.length; i++) {
            if(a[i] > maksverdi) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int maks(Integer[] a) {
        int m = 0;
        Integer maksverdi = a[m];

        for(int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int compareTo(Integer a, Integer b) {
        return (a == b) ? 0 : (a > b) ? 1 : -1;
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
        if (n < 2) throw      // mï¿½ ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = 0;      // m er posisjonen til stï¿½rste verdi
        int nm = 1;     // nm er posisjonen til nest stï¿½rste verdi

        // bytter om m og nm hvis a[1] er stï¿½rre enn a[0]
        if (a[1] > a[0]) {
            m = 1; nm = 0;
        }

        int maksverdi = a[m];                // stï¿½rste verdi
        int nestmaksverdi = a[nm];           // nest stï¿½rste verdi

        for (int i = 2; i < n; i++) {
            if (a[i] > nestmaksverdi) {
                if (a[i] > maksverdi) {
                    nm = m;
                    nestmaksverdi = maksverdi;     // ny nest stï¿½rst

                    m = i;
                    maksverdi = a[m];              // ny stï¿½rst
                }
                else {
                    nm = i;
                    nestmaksverdi = a[nm];         // ny nest stï¿½rst
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

    // PARTER

    public static int parter(int[] a, int v, int h, int skilleverdi)
    {
        while (v <= h && a[v] < skilleverdi) v++;     // h er stoppverdi for v
        while (v <= h && a[h] >= skilleverdi) h--;    // v er stoppverdi for h

        while (true)                                  // stopper nÃ¥r v >= h
        {
            if (v < h) Tabell.bytt(a,v++,h--);          // bytter om a[v] og a[h]
            else  return v;                             // partisjoneringen er ferdig
            while (a[v] < skilleverdi) v++;             // flytter v mot hÃ¸yre
            while (a[h] >= skilleverdi) h--;            // flytter h mot venstre
        }
    }

    public static int sParter(int[] a, int v, int h, int indeks)
    {
        Tabell.bytt(a, indeks, h);   // skilleverdi a[indeks] flyttes bakerst
        int k = Tabell.parter(a, v, h - 1, a[h]);  // partisjonerer a[v:h âˆ’ 1]
        Tabell.bytt(a, k, h);       // bytter for Ã¥ fÃ¥ skilleverdien pÃ¥ rett plass
        return k;                   // returnerer posisjonen til skilleverdien
    }

    // END PARTER

    // FLETTESORTERING

    public static void flettesortering(int[] a)
    {
        int[] b = Arrays.copyOf(a, a.length/2);   // en hjelpetabell for flettingen
        flettesortering(a,b,0,a.length);          // kaller metoden over
    }

    private static void flettesortering(int[] a, int[] b, int fra, int til)
    {
        if (til - fra <= 1) return;   // a[fra:til> har maks ett element
        int m = (fra + til)/2;        // midt mellom fra og til

        flettesortering(a,b,fra,m);   // sorterer a[fra:m>
        flettesortering(a,b,m,til);   // sorterer a[m:til>

        if (a[m-1] > a[m]) flett(a,b,fra,m,til);  // fletter a[fra:m> og a[m:til>
    }

    private static void flett(int[] a, int[] b, int fra, int m, int til)
    {
        int n = m - fra;                // antall elementer i a[fra:m>
        System.arraycopy(a, fra, b, 0, n);  // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;      // lÃ¸kkeST0r og indekser

        while (i < n && j < til)        // fletter b[0:n> og a[m:til> og
        {                               // legger resultatet i a[fra:til>
            a[k++] = b[i] <= a[j] ? b[i++] : a[j++];
        }

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    // END FLETTESORTERING

    //KVIKKSORTERING

    private static void kvikksortering1(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = Tabell.sParter(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering1(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering1(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) // fra/til i sortering
    {
        Tabell.fratilKontroll(a.length, fra, til);  // sjekker nÃ¥r metoden er offentlig
        kvikksortering1(a, fra, til - 1);  // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a)   // sorterer hele tabellen
    {
        kvikksortering1(a, 0, a.length - 1);
    }

    //END KVIKKSORTERING

    // INNSETTINGSSORTERING

    public static void innsettingssortering(int[] a)
    {
        for (int i = 1, j = 0; i < a.length; j = i++)  // starter med i = 1
        {
            int verdi = a[i];        // flytter a[i] til en hjelpevariabel

            while (verdi < a[j])     // sammenligner
            {
                a[j + 1] = a[j];       // forskyver mot hÃ¸yre
                if (j-- == 0) break;   // venstre ende av tabellen
            }

            a[j + 1] = verdi;        // verdien inn pÃ¥ rett sortert plass
        }
    }

    // END INSETTINGSSORTERING.

    // FLETTING

    public static int[] enkelFletting(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];  // en tabell av rett stÃ¸rrelse
        int k = Math.min(a.length, b.length);    // lengden pÃ¥ den korteste

        for (int i = 0; i < k; i++)
        {
            c[2*i] = a[i];        // fÃ¸rst en verdi fra a
            c[2*i + 1] = b[i];    // sÃ¥ en verdi fra b
        }
        // vi mÃ¥ ta med resten

        System.arraycopy(a, k, c, 2*k, a.length-k);
        System.arraycopy(b, k , c, 2*k, b.length-k);

        System.out.println(Arrays.toString(c));
        return c;
    }

    public static String enkelFletting(String a, String b)
    {
        StringBuilder sb = new StringBuilder();  // en tabell av rett stÃ¸rrelse
        int k = Math.min(a.length(), b.length());    // lengden pÃ¥ den korteste

        for (int i = 0; i < k; i++)
        {
            sb.append(a.charAt(i));        // fÃ¸rst en verdi fra a
            sb.append(b.charAt(i));    // sÃ¥ en verdi fra b
        }

        sb.append(a.substring(k));
        sb.append(b.substring(k));
        // vi mÃ¥ ta med resten



        System.out.println(sb.toString());
        return sb.toString();
    }

    public static int differens(int[] a, int m, int[] b, int n, int[] c) {

        if(a.length < m || m < 0) {
            throw new IllegalArgumentException("a[0:m] er ulovlig");
        } if(b.length < n || n < 0) {
            throw new IllegalArgumentException("b[0:n] er ulovlig");
        }

        int j = 0, i = 0, k = 0;

        while(j < m && i < n) {
            if(a[j] < b[i]) {
                c[k++] = a[j++];
            } else if(a[j] == b[i]) {
                i++; j++;
            } else {
                i++;
            }
        }
        while(j < m) {
            c[k++] = a[j];
        }
        return k;
    }

    public static int differens(int[] a, int[] b, int[] c) {
        return differens(a, a.length, b, b.length, c);
    }

    // END FLETTING

    public static boolean inklusjon(int[] a, int m, int[] b, int n) {

        if(m < 0 || a.length < m || n < 0 || b.length < 0) {
            throw new IllegalArgumentException("Ulovlig input");
        }

        int j = 0, i = 0;

        while(j < m && i < n) {
            if(a[j] < b[i]) {
                i++;
            } else if(b[i] == a[j]) {
                i++; j++;
            } else {
                return false;
            }
        }
        return j == m;
    }

    public static boolean inklusjon(int[] a, int[] b) {
        return inklusjon(a, a.length, b, b.length);
    }

    public static int xunion(int[] a, int m, int[] b, int n, int[] c) {


        int i = 0; int j = 0; int k = 0;

        while(i < m && j < n) {
            if(a[i] < b[j]) {
                c[k++] = a[i++];
            } else if(a[i] > b[j]) {
                c[k++] = b[j++];
            } else if(a[i] == b[j]) {
                i++; j++;
            }
        }

        while(i < m) {
            c[k++] = a[i++];
        } while(j < n) {
            c[k++] = b[j++];
        }

        return k;
    }

    public static int xunion(int[] a, int[] b, int[] c) {
        return xunion(a, a.length, b, b.length, c);
    }

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1, j = 0; i < a.length; j = i++)  // starter med i = 1
        {
            T verdi = a[i];          // flytter a[i] til en hjelpevariabel
            while (verdi.compareTo(a[j]) < 0)  // sammenligner
            {
                a[j + 1] = a[j];       // forskyver mot høyre
                if (j-- == 0) break;   // venstre ende av tabellen
            }
            a[j + 1] = verdi;        // verdien inn på rett sortert plass
        }
    }



}



