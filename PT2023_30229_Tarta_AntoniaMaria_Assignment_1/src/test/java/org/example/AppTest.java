package org.example;

import BusinessLogic.Operation;
import DataModels.Polynomial;
import org.junit.*;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

public class AppTest {
    public static Polynomial p1;
    public static Polynomial p2;
    @BeforeClass
    public static void setUpBefore() {
        p1 = new Polynomial();
        p1.addTerm(3, 2.0);
        p1.addTerm(2, 3.0);
        p1.addTerm(1, -4.0);
        p1.addTerm(0, 1.0);
        p1.addTerm(1, 3.0);
        p1.addTerm(9, 0.0);

        p2 = new Polynomial();
        p2.addTerm(3, 7.0);
        p2.addTerm(3,-2.0);
        p2.addTerm(2, 3.0);
        p2.addTerm(5, -4.0);
        p2.addTerm(0, 8.0);
        p2.addTerm(9, 3.0);
    }

    @Test
    public void testAdd() {
        Polynomial p3= Operation.add(p1,p2);
        Polynomial res=new Polynomial();
        res.addTerm(0, 9.0);
        res.addTerm(1, -1.0);
        res.addTerm(2, 6.0);
        res.addTerm(3, 7.0);
        res.addTerm(5, -4.0);
        res.addTerm(9, 3.0);
        assertEquals((p3.getPolynomial()).equals(res.getPolynomial()),true);
    }
    @Test
    public void testSub() {
        Polynomial p3= Operation.sub(p1,p2);
        Polynomial res=new Polynomial();
        res.addTerm(0, -7.0);
        res.addTerm(1, -1.0);
        res.addTerm(3, -3.0);
        res.addTerm(5, 4.0);
        res.addTerm(9, -3.0);
        Polynomial aux=new Polynomial();
        for (Map.Entry<Integer, Double> p : p3.getPolynomial().entrySet()) {
            int degree=p.getKey();
            double coef = p.getValue();
            if(coef!=0) {
                aux.addTerm(degree,coef);
            }
        }
        assertEquals((aux.getPolynomial()).equals(res.getPolynomial()),true);
    }

    @Test
    public void testMul() {
        Polynomial pol1=new Polynomial();
        Polynomial pol2=new Polynomial();
        pol1.addTerm(0, 8.0);
        pol1.addTerm(1, -8.0);
        pol1.addTerm(2, 27.0);
        pol2.addTerm(0,0);
        Polynomial p3= Operation.multiply(pol1,pol2);
        assertEquals(p3.toString(),"0");
    }

    @Test
    public void testDeriv() {

        Polynomial p3= Operation.deriv(p1);
        Polynomial res=new Polynomial();
        res.addTerm(0, -1.0);
        assertEquals((p3.getPolynomial()).equals(res.getPolynomial()),false);
    }

    @Test
    public void testIntegr() {

        Polynomial p3= Operation.integrat(p1);
        Polynomial res=new Polynomial();
        res.addTerm(1, 1.0);
        res.addTerm(2, -0.5);
        res.addTerm(3, 1.0);
        res.addTerm(4, 0.5);
        Polynomial aux=new Polynomial();
        for (Map.Entry<Integer, Double> p : p3.getPolynomial().entrySet()) {
            int degree=p.getKey();
            double coef = p.getValue();
            if(coef!=0) {
                aux.addTerm(degree,coef);
            }
        }
        assertEquals((aux.getPolynomial()).equals(res.getPolynomial()),true);
    }

    @Test
    public void testTransform(){
        Polynomial p=Operation.transform("6y^2");
        int res;
        if(p.getPolynomial().containsKey(-1)==true ) {
            res=0;
        }
        else {
            res = 1;
        }
        assertEquals(res,0);
    }

    @Test
    public void testDivide(){
        Polynomial p1=Operation.transform("6x^2");
        Polynomial p2=Operation.transform("0");
        ArrayList<Polynomial>res=Operation.divide(p1,p2);
        assertEquals(res.get(0).getPolynomial().containsKey(-1),true);
    }
}
