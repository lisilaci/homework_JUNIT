package org.example;

import java.util.ArrayList;
import java.util.List;

public class Calculator {


    public void calculate(String expression){

        boolean addition = true;
        int checkPoint = 0;
        List<String> operationAdd = new ArrayList<>();
        List<String> operationMinus = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            String expChar = expression.substring(i, i + 1);

            if ("+".equals(expChar)) {
                checkOperator(operationAdd, operationMinus, addition, expression.substring(checkPoint, i).trim());
                checkPoint = i + 1;
                addition = true;
            }

            if ("-".equals(expChar)) {
                checkOperator(operationAdd, operationMinus, addition, expression.substring(checkPoint, i).trim());
                checkPoint = i + 1;
                addition = false;
            }
        }
        checkOperator(operationAdd, operationMinus, addition, expression.substring(checkPoint).trim());


        int sumAdd = sumList(operationAdd);
        int sumMinus = sumList(operationMinus);


        int result =  sumAdd - sumMinus;

        System.out.println("Result: " + result + " mm");
    }

    private int sumList(List<String> operationAdd) {
        int sum = 0;
        for (String exp: operationAdd) {
            String[] arr = exp.split(" ");
            int value = Integer.parseInt(arr[0]);
            int scale = Metrics.valueOf(arr[1]).getScale();
            sum = sum + value * scale;
        }
        return sum;
    }

    private void checkOperator(List<String> operationAdd, List<String> operationMinus, boolean op, String substring) {
        if (op) {
            operationAdd.add(substring);
        } else {
            operationMinus.add(substring);
        }
    }
}


