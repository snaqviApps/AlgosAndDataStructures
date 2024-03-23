package ghar.learn.java.misc.patterns.fluentInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This pattern is used to generate Builder()
 * patterns whereby a chain of actions is taken to create object,
 * using fluent interface-pattern
 */
public class CalculatorWithBuilderPattern {

    public static class Builder {
        protected String caseColor = "Blue";
        protected String buttonColor = "Yellow";
        protected List<String> buttons = new ArrayList<>();
        protected boolean isTrig;
        protected boolean isProgrammable;

        public Builder withCaseColor(String color) {
            this.caseColor = color;
            return this;
        }

        public Builder withButtonColor(String color) {
            this.buttonColor = color;
            return this;
        }

        public Builder withTrigFunctions() {
            this.isTrig = true;
            return this;
        }

        public Builder withProgrammingFunctions() {
            this.isProgrammable = true;
            return this;
        }

        public CalculatorWithBuilderPattern build() {
            return new CalculatorWithBuilderPattern(caseColor, buttonColor, isTrig, isProgrammable);
        }

    }

    protected String caseColor;
    protected String buttonColor;
    protected List<String> buttons = new ArrayList<>();

    public CalculatorWithBuilderPattern(String caseColor, String buttonColor, boolean isTrig, boolean isProgrammable) {
        this.caseColor = caseColor;
        this.buttonColor = buttonColor;

        //            Arrays.asList("add", "subtract", "multiply", "divide").forEach(buttons::add);
        buttons.addAll(Arrays.asList("add", "subtract", "multiply", "divide"));
        if (isTrig) {
            buttons.addAll(Arrays.asList("sin", "coa", "tan"));
        }
        if (isProgrammable) {
                buttons.addAll(Arrays.asList("prgm", "vars", "sto", "rcl"));
        }
    }

    public void describe() {
        System.out.printf("This is a %s and %s calculator. It has the following " +
                "buttons:%n", caseColor, buttonColor);
        buttons.forEach(System.out::println);
    }
}
