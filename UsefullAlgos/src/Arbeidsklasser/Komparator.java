package Arbeidsklasser;

/**
 * Created by Adrian on 25/09/2015.
 */
@FunctionalInterface                // legges i mappen hjelpeklasser
public interface Komparator<T>      // et funksjonsgrensesnitt
{
    int compare(T x, T y);            // en abstrakt metode
}
