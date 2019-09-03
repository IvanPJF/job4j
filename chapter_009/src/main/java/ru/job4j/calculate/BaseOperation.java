package ru.job4j.calculate;

public abstract class BaseOperation implements IOperation {

    private Calculator calc;
    private String sign;

    public BaseOperation(final Calculator calc, final String sign) {
        this.calc = calc;
        this.sign = sign;
    }

    public BaseOperation(String sign) {
        this.sign = sign;
    }

    public abstract Double execute(Double... operands);

    public Calculator getCalc() {
        return this.calc;
    }

    @Override
    public String getSign() {
        return this.sign;
    }
}
