/**
 * Created by nallgood on 2/16/17.
 */

import java.lang.*;
import java.util.*;
import java.io.*;


// So this works by making
public class Fraction implements Comparable<Fraction> {

    private String fracInput;
    private int numerator;
    private int denominator;

    // Accepts String input and then converts to where we need
    public Fraction(String fracInput) {

        this.fracInput = fracInput;

        convertFrac(fracInput);
    }

    // We'll need to split the string on the "/"
    // it's actually ok to do this because we add the "/" back later
    private void convertFrac(String frac) throws NumberFormatException {

        // Split on the forward slash into string array
        String[] splitter = frac.split("/");

        // We're only creating a single fraction with this object
        // So our outside loop needs to handle that
        // With that said this should never be more than two
        if(splitter.length > 2) {

            throw new NumberFormatException();
        }

        // String[0] = numerator
        // String[1] = denominator

        // Pulls integer out of string of 1st element of array we split
        int num = Integer.parseInt(splitter[0]);

        // Sets it as numerator in our object
        setNumerator(num);

        // Pulls integer out of 2nd element of array we split
        int den = Integer.parseInt(splitter[1]);

        // Sets object denominator
        setDenominator(den);

        //System.out.println(splitter.length);

    }

    private int getNumerator() {

        return numerator;
    }

    private void setNumerator(int num) {

        numerator = num;
    }

    private int getDenominator() {

        return denominator;
    }

    private void setDenominator(int den) {

        denominator = den;
    }

    // Similar to how we do it in TreeNode, we compare the fractions
    public int compareTo(Fraction f) {

        // Cross multiplying fractions
        int num1 = numerator * f.getDenominator();
        int num2 = f.getNumerator() * denominator;

        // We then subtract them to get the result
        // If num1 is larger, then a positive int means it's true
        // We're looping 0 into this since we can have duplicate elements
        // if num1 isn't larger, then it's negative

        return num1 - num2;
    }

    // Builds string with numerator and denominator
    public String toString() {

        String buff = numerator + "/" + denominator;
        return buff;

    }

}

