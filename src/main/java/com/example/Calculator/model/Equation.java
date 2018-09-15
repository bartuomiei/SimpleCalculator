package com.example.Calculator.model;

import org.springframework.stereotype.Component;


@Component
public class Equation {
    private double value1;
    private double value2;
    private double result;
    private String operationType = " ? ";


    public Equation() {
    }



    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public double getResult() {
        return result;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }


////////////////////////
    public void add(){
        result = value1 + value2;
    }

    public void substract(){
        result = value1 - value2;
    }

    public void multiply(){
        result = value1 * value2;
    }

    public void devide(){
        result = value1 / value2;
    }

    public void exponent(){
        result = Math.pow(value1, value2);
    }

    public void root(){
        result = Math.pow(value1, 1/value2);
    }

}
