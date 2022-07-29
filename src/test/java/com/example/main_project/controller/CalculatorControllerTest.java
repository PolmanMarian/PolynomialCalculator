package com.example.main_project.controller;

import com.example.main_project.model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    @Test
    void onIntegrateClickTest1() {

        Polynomial p1= Polynomial.valueOf("3x^2+2");

        assertEquals("2.00X+X^3",p1.integrate().toString());
    }

    @Test
    void onIntegrateClickTest2() {

        Polynomial p1 = Polynomial.valueOf("3x^2+2");

        assertEquals("2.00X+X^3", p1.integrate().toString());
    }

    @Test
    void onDerivativeClickTest1() {

        Polynomial p1= Polynomial.valueOf("3x^2+2");

        assertEquals("6.00X",p1.derivative().toString());

    }

    @Test
    void onDerivativeClickTest2() {

        Polynomial p1= Polynomial.valueOf("3x^2+3x^5+2+x^7");

        assertEquals("6.00X+15.00X^4+7.00X^6",p1.derivative().toString());

    }

    @Test
    void onMultiplyClickTest1() {
        Polynomial p1= Polynomial.valueOf("x^2+2");
        Polynomial p2= Polynomial.valueOf("x^2-2");

        assertEquals("-4.00+X^4",p1.multiply(p2).toString());
    }

    @Test
    void onMultiplyClickTest2() {
        Polynomial p1= Polynomial.valueOf("7+x+2x^2-x^3");
        Polynomial p2= Polynomial.valueOf("5-3.1x^2+6x^4");

        assertEquals("35.00+5.00X-11.70X^2-8.10X^3+35.80X^4+9.10X^5+12.00X^6-6.00X^7",p1.multiply(p2).toString());
    }

    @Test
    void onAddClickTest1() {
        Polynomial p1= Polynomial.valueOf("x^2+2");
        Polynomial p2= Polynomial.valueOf("x^2-2");

        assertEquals("2.00X^2",p1.add(p2).toString());
    }

    @Test
    void onAddClickTest2() {
        Polynomial p1= Polynomial.valueOf("7+x+2x^2-x^3");
        Polynomial p2= Polynomial.valueOf("5-3.1x^2+6x^4");

        assertEquals("12.00+X-1.10X^2-1.00X^3+6.00X^4", p1.add(p2).toString());
    }

    @Test
    void onSubtractClickTest1() {
        Polynomial p1= Polynomial.valueOf("x^2+2");
        Polynomial p2= Polynomial.valueOf("x^2+2");

        assertEquals("0", p1.subtract(p2).toString());
    }

    @Test
    void onSubtractClickTest2() {
        Polynomial p1= Polynomial.valueOf("7+x+2x^2-x^3");
        Polynomial p2= Polynomial.valueOf("5-3.1x^2+6x^4");

        assertEquals("2.00+X+5.10X^2-1.00X^3-6.00X^4",p1.subtract(p2).toString());
    }

    @Test
    void onDivideClickTest1() {
        Polynomial p1= Polynomial.valueOf("5-3.1x^2+6x^4");
        Polynomial p2= Polynomial.valueOf("7+x+2x^2-x^3");

        assertEquals("-12.00-6.00X", p1.divide(p2).get(0).toString());
    }

    @Test
    void onDivideClickTest2() {
        Polynomial p1= Polynomial.valueOf("7+x+2x^2-x^3");
        Polynomial p2= Polynomial.valueOf("1");

        assertEquals("7.00+X+2.00X^2-1.00X^3", p1.divide(p2).get(0).toString());
    }

    @Test
    void onDivideClickTest3() {
        Polynomial p1= Polynomial.valueOf("7+x+2x^2-x^3");
        Polynomial p2= Polynomial.valueOf("0");

        assertEquals("Can't divide by 0", p1.divide(p2).get(0).toString());
    }

    @Test
    void onModuloClickTest1() {
        Polynomial p1= Polynomial.valueOf("5-3.1x^2+6x^4");
        Polynomial p2= Polynomial.valueOf("7+x+2x^2-x^3");

        assertEquals("89.00+54.00X+26.90X^2", p1.divide(p2).get(1).toString());
    }

    @Test
    void onModuloClickTest2() {
        Polynomial p1= Polynomial.valueOf("7+x+2x^2-x^3");
        Polynomial p2= Polynomial.valueOf("1");

        assertEquals("0", p1.divide(p2).get(1).toString());
    }

}