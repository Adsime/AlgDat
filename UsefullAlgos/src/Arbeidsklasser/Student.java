package Arbeidsklasser;

/**
 * Created by Adrian on 25/09/2015.
 */
public class Student extends Person  // Student blir subklasse til Person
{
    private final String klasse;       // tre tegn - et siffer og to bokstaver

    public Student(String fornavn, String etternavn, String klasse)
    {
        super(fornavn,etternavn);        // kaller konstrukt�ren til Person
        this.klasse = klasse;
    }

    public String klasse() { return klasse; }   // aksessor

    public String toString() { return super.toString() + " " + klasse; }

}
