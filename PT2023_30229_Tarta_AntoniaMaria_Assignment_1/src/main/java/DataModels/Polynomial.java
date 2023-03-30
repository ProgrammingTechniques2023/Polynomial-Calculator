package DataModels;

import java.util.*;

public class Polynomial {
    private TreeMap<Integer, Double> polynomial;

    public Polynomial() {
        this.polynomial = new TreeMap<>();
    }

    public TreeMap<Integer, Double> getPolynomial() {
        return polynomial;
    }

    public String toStringCoefNotZero(int degree, double coef, String s) {
        if(s.length() != 0) {
            s += " ";
            if (coef > 0)
                s += "+";
        }
        if(degree==0)
            s += coef;
        else
        {
            if(coef==-1)
                s += "-";
            else if(coef!=1)
                s += coef;
        }
        if (degree != 0) {
            s += "x";
            if (degree != 1)
                s += "^";
            if (degree > 1) {
                s+=degree;
            }
        }
        return s;
    }

    public String toStringCoefZero(double coef, String s) {
        if(s.length()==0) {
            int zero = 0;
            for (Map.Entry<Integer, Double> pol : polynomial.entrySet()) {
                coef = pol.getValue();
                if (coef != 0) {
                    zero = 1;
                    break;
                }
            }
            if (zero == 0)
                s = "0";
        }
        return s;
    }
    public String toString() {
        String s = "";
        for (Map.Entry<Integer, Double> p : polynomial.entrySet()) {
            int degree = p.getKey();
            double coef = p.getValue();
            if (coef != 0) {
                s=toStringCoefNotZero(degree,coef,s);
            }
            else{
                s=toStringCoefZero(coef,s);
            }
        }
        return s;
    }

    public void addTerm(int degree, double coef) {
        if(degree>=0) {
            if (polynomial.containsKey(degree)) {
                polynomial.put(degree, polynomial.get(degree) + coef);
            } else {
                polynomial.put(degree, coef);
            }
        }
    }

}
