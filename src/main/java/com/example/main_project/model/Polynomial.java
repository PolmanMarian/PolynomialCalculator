package com.example.main_project.model;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial{

    static final double epsilon=0.001;
    private ArrayList<Monomial> monomials = new ArrayList<Monomial>();

    public Polynomial() {}

    public static Polynomial valueOf(String input){

        if(input.equals(""))
            throw new IllegalArgumentException();

        int sizeOfFindings=0;
        input = input.replaceAll("\\s+", "");

        Polynomial value = new Polynomial();
        Monomial a;

        if(input.charAt(0)!='-' && input.charAt(0)!='+')
            input="+"+input;

        final String regex = "([\\+|\\-])(\\d+(\\.\\d+)?)?((\\*)?x)?(\\^(\\d+))?";

        final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            a = Monomial.valueOf(matcher);
            value.addIntoList(a);
            sizeOfFindings+=matcher.group(0).length();
        }

        if(sizeOfFindings!=input.length())
            throw new IllegalArgumentException();

        return value;
    }

    public Polynomial(Polynomial input) {

        for(Monomial entry:input.getMonomials()) {
            this.monomials.add(
                    new Monomial(entry.getDegree(),entry.getCoefficient())
            );
        }
    }

    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    private void sort(){
        Collections.sort(this.getMonomials(), new Comparator<Monomial>() {
            @Override
            public int compare(Monomial o1, Monomial o2) {
                return o1.getDegree()-o2.getDegree();
            }
        });
    }

    public void addIntoList(Monomial a){
        boolean inserted = false;
        Monomial toRemove= null;

        for(Monomial entry: this.getMonomials()){
            if(entry.getDegree() == a.getDegree()){
                entry.add(a);
                if(Math.abs(entry.getCoefficient())<epsilon){
                    toRemove=entry;
                }
                inserted = true;
                break;
            }
        }

        if(!inserted && Math.abs(a.getCoefficient())>epsilon){
            this.getMonomials().add(a);
        }

        if(toRemove!=null)
            this.monomials.remove(toRemove);

    }

    public String toString(){

        if(this.monomials.isEmpty())
            return "0";

        if(this.monomials.get(0).getDegree()==-2)
            return "Can't divide by 0";

        this.sort();
        String a="";
        for(Monomial entry: this.getMonomials()){
            a=a + entry.toString();
        }

        if(a.charAt(0)=='+')
            return a.substring(1);
        return a;
    }

    public Polynomial add(Polynomial a){

        Polynomial result = new Polynomial(this);

        for(Monomial entry: a.getMonomials())
            result.addIntoList(entry);
        result.sort();

        return result;

    }

    public Polynomial subtract(Polynomial a) {

        return this.add(a.multiply(new Monomial(0,-1)));

    }

    public Polynomial multiply(Monomial a) {
        Polynomial result = new Polynomial(this);

        for(Monomial i : result.getMonomials()){
                i.setDegree(i.getDegree()+a.getDegree());
                i.setCoefficient(i.getCoefficient()*a.getCoefficient());
        }

        result.sort();
        return result;
    }

    public Polynomial multiply (Polynomial a){

        Polynomial result = new Polynomial();

        for(Monomial i : a.getMonomials()){
            for(Monomial j: this.getMonomials()){
                result.addIntoList(j.multiply(i));
            }
        }

        result.sort();
        return result;

    }

    public int getDegree(){
        int maxD = -1;
        for(Monomial entry: this.getMonomials()){
            if(entry.getDegree()>maxD){
                maxD=entry.getDegree();
            }
        }

        return maxD;
    }

    public ArrayList<Polynomial> divide (Polynomial divisor){
        ArrayList<Polynomial> result=new ArrayList<Polynomial>();

        Polynomial quotient= new Polynomial();
        Polynomial modulo= new Polynomial(this);

        if(divisor.getMonomials().isEmpty()){
                quotient.addIntoList(new Monomial(-2,1));
                result.add(quotient);
                result.add(quotient);
                return result;
            }

        Monomial complement;
        modulo.sort();
        divisor.sort();

        Monomial leadD=divisor.getMonomials().get(divisor.monomials.size()-1);

        while(!modulo.getMonomials().isEmpty() && modulo.getDegree()>=divisor.getDegree()){
            complement = modulo.getMonomials().get(modulo.monomials.size()-1);
            complement = complement.divide(leadD);
            quotient.addIntoList(complement);
            modulo=modulo.subtract(divisor.multiply(complement));
        }
        result.add(quotient);
        result.add(modulo);
        return result;
    }

    public Polynomial derivative(){

        Polynomial result=new Polynomial(this);

        for(Monomial entry: result.getMonomials()){

            entry.derivative();
            if(entry.getDegree() ==-1)
                entry.setCoefficient(0);
        }

        result.sort();
        return result;

    }

    public Polynomial integrate(){

        Polynomial result=new Polynomial(this);

        for(Monomial entry: result.getMonomials())
            entry.integrate();

        result.sort();
        return result;

    }

}
