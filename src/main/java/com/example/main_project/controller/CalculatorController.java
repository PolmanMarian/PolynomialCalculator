package com.example.main_project.controller;

import com.example.main_project.model.Polynomial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CalculatorController {

    Polynomial p1;
    Polynomial p2;

    @FXML
    private TextField resultPolynomialField;
    @FXML
    private TextField firstPolynomialField;
    @FXML
    private TextField secondPolynomialField;

    public boolean parseInput(boolean needAll){
        try {
            p1 = Polynomial.valueOf(firstPolynomialField.getText());
            if(needAll)
                p2 = Polynomial.valueOf(secondPolynomialField.getText());
            return true;
        } catch (IllegalArgumentException e) {
            resultPolynomialField.setText("Invalid input, Try again -_-");
            return false;
        }
    }

    @FXML
    public void onExitClick(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onIntegrateClick(ActionEvent actionEvent) {
        if(parseInput(false)){
            resultPolynomialField.setText(p1.integrate().toString());
        }
    }

    public void onDerivativeClick(ActionEvent actionEvent) {
        if(parseInput(false)){
            resultPolynomialField.setText(p1.derivative().toString());
        }
    }

    public void onDivideClick(ActionEvent actionEvent){
        if(parseInput(true)){
            ArrayList<Polynomial> result = p1.divide(p2);
            if(result==null)
                resultPolynomialField.setText("Can't divide by 0");
            else
                resultPolynomialField.setText(result.get(0).toString());
        }
    }

    public void onMultiplyClick(ActionEvent actionEvent) {
        if(parseInput(true)){
            resultPolynomialField.setText(p1.multiply(p2).toString());
        }
    }

    public void onModuloClick(ActionEvent actionEvent) {
        if(parseInput(true)){
            resultPolynomialField.setText(p1.divide(p2).get(1).toString());
        }
    }

    public void onAddClick(ActionEvent actionEvent) {
        if(parseInput(true)){
            resultPolynomialField.setText(p1.add(p2).toString());
        }
    }

    public void onSubtractClick(ActionEvent actionEvent) {
        if(parseInput(true)){
            resultPolynomialField.setText(p1.subtract(p2).toString());
        }
    }
    
}