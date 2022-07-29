package com.example.main_project;

import com.example.main_project.model.Monomial;
import com.example.main_project.model.Polynomial;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);

        stage.setTitle("Polynomial Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {

        String a="2x^2+x^3-23x^5+7";
        Polynomial x1=new Polynomial();
        Polynomial x2=new Polynomial();

        Monomial m1=new Monomial(2,2);
        Monomial m2=new Monomial(3,-1);
        Monomial m3=new Monomial(1,1);
        Monomial m4=new Monomial(0,7);

        //7+X+2X^2-1X^3
        x1.addIntoList(m1);
        x1.addIntoList(m2);
        x1.addIntoList(m3);
        x1.addIntoList(m4);

        //5-3.1X^2+6X^4
        Monomial n1=new Monomial(0,5);
        Monomial n2=new Monomial(4,6);
        Monomial n3=new Monomial(2,-3.1);

        x2.addIntoList(n1);
        x2.addIntoList(n2);
        x2.addIntoList(n3);

        //Trebuie vazuta afisarea si facuta ca oamenii

        System.out.println("P1-||"+x1);
        System.out.println("P2-||"+x2);

        //System.out.println(x1.add(x2)+"->Addition P1+P2");
        //System.out.println(x1.subtract(x2)+"->Subtraction P1-P2");
        //System.out.println(x1.multiply(x2)+"->Multiply P1-P2");
        //System.out.println(x1.divide(x2).get(0)+"->Catul");

        Monomial q1=new Monomial (4,3);
        Monomial q2=new Monomial (3,2);
        Monomial q3=new Monomial (2,5);
        Monomial q4=new Monomial (1,1);
        Monomial q5=new Monomial (0,4);

        Monomial r1=new Monomial(2,1);
        Monomial r2=new Monomial(0,2);

        Polynomial P1=new Polynomial();
        P1.addIntoList(q1);
        P1.addIntoList(q2);
        P1.addIntoList(q3);
        P1.addIntoList(q4);
        P1.addIntoList(q5);

        Polynomial P2=new Polynomial();
        P2.addIntoList(r1);
        P2.addIntoList(r2);

        System.out.println(P1);
        System.out.println(P2);

        //System.out.println(x2.divide(x1).get(1)+"->Restul");
        //System.out.println(P1.divide(P2).get(1)+"->Restul");
        //System.out.println(P1.divide(P2).get(0)+"->Catul");
        //System.out.println(x1.derivative()+"->Derivative");
        //System.out.println(x1.integrate()+"->Integrate");
        //x1.valueOf(a);

        launch();
    }
}