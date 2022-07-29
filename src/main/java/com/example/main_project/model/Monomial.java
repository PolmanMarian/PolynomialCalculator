package com.example.main_project.model;
import java.util.regex.Matcher;

public class Monomial {

    private int degree;
    private double coefficient = 1;
    static final double epsilon=0.001;

    public Monomial(int degree, double coeficient) {
        this.degree = degree;
        this.coefficient = coeficient;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public double getCoefficient() {
        return coefficient;
    }

    static Monomial valueOf(Matcher match){

        Monomial result=new Monomial(0,1);

        if(match.group(1).equals("-"))
            result.coefficient *= -1;

        if(match.group(2)!=null)
            result.coefficient *= Double.parseDouble(match.group(2));

        if(match.group(4)!=null)
            result.degree=1;

        if(match.group(7)!=null)
            result.degree=Integer.parseInt(match.group(7));

        return result;
    }

    public String toString() {
        String a = "";//coefficient mannageing
        if(Math.abs(coefficient) < epsilon)///0 case
            return a;
        else if((Math.abs(coefficient-1) < epsilon)){//1 case
            if(degree == 0)
                a = a + "1";
            else
                a = a + "+";}
        else
            a = a + String.format("%+.2f",coefficient);
        if(degree == 1)
            a=a+"X";
        else if(degree!= 0)
            a=a+"X^"+degree;

        return a;
    }

    void add(Monomial term){
        this.coefficient +=term.getCoefficient();
    }

    void derivative(){

        if(this.degree==0){
            this.setCoefficient(0);
            this.setCoefficient(0);
        }

        else{
            this.setCoefficient(this.getCoefficient()*this.getDegree());
            this.setDegree(this.getDegree()-1);
        }

    }

    void integrate(){

        if(this.degree>0.0001)
            this.setCoefficient(this.getCoefficient()/(this.getDegree()+1));

        this.setDegree(this.getDegree()+1);
    }

    Monomial multiply(Monomial a) {
        return new Monomial(this.getDegree()+a.getDegree(),this.getCoefficient()*a.getCoefficient());
    }

    Monomial divide(Monomial a){
        return new Monomial(this.degree-a.degree,this.coefficient/a.getCoefficient());
    }

}

