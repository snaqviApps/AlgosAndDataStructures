package ghar.learn.java.misc;

import ghar.learn.java.misc.patterns.fluentInterface.CalculatorWithBuilderPattern;

public class JavaMain {

    public static void main(String[] args) {
        System.out.println("Hi, Java, how is going!");

        var builder = new CalculatorWithBuilderPattern.Builder();

        var calculator = builder.build();           // Basic Calculator
        var trigCalculator = builder
                .withCaseColor("Silver")
                .withButtonColor("Black")
                .withTrigFunctions()
                .build();

        trigCalculator.describe();
        calculator.describe();


    }
}
