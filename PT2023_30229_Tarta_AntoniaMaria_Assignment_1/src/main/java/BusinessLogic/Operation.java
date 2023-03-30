package BusinessLogic;

import DataModels.Polynomial;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.*;

public class Operation {

    public Operation() {
    }
    public static Polynomial add(Polynomial pol1, Polynomial pol2) {
        Polynomial res = new Polynomial();
        int degree;
        double coef;
        for (Map.Entry<Integer, Double> p : pol1.getPolynomial().entrySet()) {
            degree = p.getKey();
            coef = p.getValue();
            res.addTerm(degree, coef);
        }

        for (Map.Entry<Integer, Double> p : pol2.getPolynomial().entrySet()) {
            degree = p.getKey();
            coef = p.getValue();
            res.addTerm(degree, coef);
        }
        return res;
    }

    public static Polynomial sub(Polynomial pol1, Polynomial pol2) {
        Polynomial res = new Polynomial();
        int degree;
        double coef;
        for (Map.Entry<Integer, Double> p : pol1.getPolynomial().entrySet()) {
            degree = p.getKey();
            coef = p.getValue();
            res.addTerm(degree, coef);
        }

        for (Map.Entry<Integer, Double> p : pol2.getPolynomial().entrySet()) {
            degree = p.getKey();
            coef = p.getValue();
            res.addTerm(degree, -coef);
        }
        return res;
    }

    public static Polynomial multiply(Polynomial pol1, Polynomial pol2) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> p1 : pol1.getPolynomial().entrySet()) {
            int degree1 = p1.getKey();
            double coef1 = p1.getValue();
            for (Map.Entry<Integer, Double> p2 : pol2.getPolynomial().entrySet()) {
                int degree2 = p2.getKey();
                double coef2 = p2.getValue();
                res.addTerm(degree1 + degree2, coef1 * coef2);
            }
        }
        return res;
    }

    public static Polynomial deriv(Polynomial pol) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> p : pol.getPolynomial().entrySet()) {
            int degree = p.getKey();
            double coef = p.getValue();
            res.addTerm(degree - 1, degree * coef);
        }
        return res;
    }

    public static Polynomial integrat(Polynomial pol) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> p : pol.getPolynomial().entrySet()) {
            int degree = p.getKey();
            double coef = p.getValue();
            res.addTerm(degree + 1, coef / (degree + 1));
        }
        return res;
    }

    public static ArrayList<Polynomial> divide(Polynomial p1, Polynomial p2){
        ArrayList<Polynomial> p=new ArrayList<>();
        Polynomial q=new Polynomial();
        if(p2.getPolynomial().size()==1 && p2.getPolynomial().containsValue(0.0)){
            q.getPolynomial().put(-1,-1.0);       // 'if' for divide by 0
            p.add(q);
            p.add(q);
            return p;
        }
        int i=p1.getPolynomial().lastEntry().getKey();
        int j=p2.getPolynomial().lastEntry().getKey();
        while(i>=j){
            int difDegree=i-j;
            double difCoef=p1.getPolynomial().get(i)/p2.getPolynomial().get(j);
            q.addTerm(difDegree,difCoef);
            Polynomial aux=new Polynomial();
            aux.getPolynomial().clear();
            aux.addTerm(difDegree,difCoef);
            p1=sub(p1,multiply(p2,aux));
            i=-1;
            for (Map.Entry<Integer, Double> pol : p1.getPolynomial().entrySet()) {
                int degree = pol.getKey();
                double coef = pol.getValue();
                if (coef != 0) {i=degree;}
            }
            if(i==-1) {break;}
        }
        p.add(q);
        p.add(p1);
        return p;
    }

    public static int verify(String s){
        Pattern pattern = Pattern.compile("([+-]?(?:(?:[0-9]?+x\\^[0-9]+)|(?:[0-9]+x)|(?:[0-9]+)|(?:x)))");
        Matcher matcher = pattern.matcher(s);
        String aux="";
        while (matcher.find()) {
             aux += matcher.group(1);
        }

        if (!aux.equals(s)) {
            return 0;
        }
        return 1;
    }
    public static Polynomial transform(String exp){
        Polynomial p=new Polynomial();
        Pattern pattern = Pattern.compile("([+-]?(?:(?:[0-9]?+x\\^[0-9]+)|(?:[0-9]+x)|(?:[0-9]+)|(?:x)))");
        Matcher matcher = pattern.matcher(exp);
        if (verify(exp)==0) {
            p.getPolynomial().put(-1,-1.0);
            return p;
        }
        while (matcher.find()) {
            String coef="";
            String degree="";
            int findX=0, index=0;
            String aux= matcher.group(1);
            while(index<aux.length() && findX==0) {
                if(aux.charAt(index)=='x') {findX=1;}
                else {coef+=aux.charAt(index);}
                index++;
            }
            if(findX==1) {index++;}
            while(index<aux.length()) {
                degree += aux.charAt(index);
                index++;
            }
            if(degree.equals("")) {
                if(findX==1) {degree+="1";}
                else {degree+="0";}
            }
            if(coef.equals("") || (coef.length()==1 && !Character.isDigit(coef.charAt(0)))) {coef+="1";}
            p.addTerm(Integer.parseInt(degree),Integer.parseInt(coef));
        }
        return p;
    }

}

