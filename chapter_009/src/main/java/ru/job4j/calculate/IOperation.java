package ru.job4j.calculate;

public interface IOperation {

    Double execute(Double... operands);

    String getSign();
}
