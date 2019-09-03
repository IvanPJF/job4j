package ru.job4j.calculate;

import java.io.InputStream;

public class EngineerCalc {

    private InteractCalc iCalc;

    public EngineerCalc(InteractCalc ic) {
        this.iCalc = ic;
    }

    public void run(InputStream input) {
        this.iCalc.run(input);
    }

    public static class SinOperation extends BaseOperation {

        public SinOperation(String sign) {
            super(sign);
        }

        @Override
        public Double execute(Double... operands) {
            return Math.sin(operands[0]);
        }
    }
}
