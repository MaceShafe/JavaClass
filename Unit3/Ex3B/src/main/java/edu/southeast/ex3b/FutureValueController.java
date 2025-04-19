package edu.southeast.ex3b;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;


public class FutureValueController {

    @FXML
    private TextField InvestmentField;
    @FXML
    private TextField InterestRateField;
    @FXML
    private TextField YearsField;
    @FXML
    private TextField FutureValueField;
    @FXML
    protected void calculateFutureValue() {
        double futureValue = 0.0;
        double yearlyInterestRate = Double.parseDouble(InterestRateField.getText());
        double monthlyInvestment = Double.parseDouble(InvestmentField.getText());
        int years = Integer.parseInt(YearsField.getText());



        double monthlyInterestRate = yearlyInterestRate / 12 / 100;
        int numberOfMonths = years *12;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();


        for (int i = 0; i < numberOfMonths; i++) {
            futureValue =(futureValue + monthlyInvestment) * (1 + monthlyInterestRate);

            System.out.println("\t Month " + i + " value: " + numberFormat.format( futureValue));
        }

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        FutureValueField.setText(currency.format(futureValue));
    }


}