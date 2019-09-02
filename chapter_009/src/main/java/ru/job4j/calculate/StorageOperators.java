package ru.job4j.calculate;

import java.util.HashMap;
import java.util.Map;

/**
 * Storage operators.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.08.2019
 *@version 0.1
 */
public class StorageOperators {

    private Map<String, IOperation> operators = new HashMap<>();
    private Calculator calculator;

    public StorageOperators(final Calculator calculator) {
        this.calculator = calculator;
        this.fillOperators();
    }

    /**
     * The filling of storage operators.
     */
    private void fillOperators() {
        this.operators.put("+", new AddOperation());
        this.operators.put("-", new SubOperation());
        this.operators.put("*", new MultOperation());
        this.operators.put("/", new DivOperation());
    }

    public IOperation getOperation(String operator) {
        return this.operators.get(operator);
    }

    /**
     * Internal class for storage.
     * Class for addition operation.
     */
    private class AddOperation implements IOperation {

        @Override
        public Double execute(Double... operands) {
            calculator.add(operands[0], operands[1]);
            return calculator.getResult();
        }
    }

    /**
     * Internal class for storage.
     * Class for subtraction operation.
     */
    private class SubOperation implements IOperation {

        @Override
        public Double execute(Double... operands) {
            calculator.subtract(operands[0], operands[1]);
            return calculator.getResult();
        }
    }

    /**
     * Internal class for storage.
     * Class for multiplication operation.
     */
    private class MultOperation implements IOperation {

        @Override
        public Double execute(Double... operands) {
            calculator.multiple(operands[0], operands[1]);
            return calculator.getResult();
        }
    }

    /**
     * Internal class for storage.
     * Class for division operation.
     */
    private class DivOperation implements IOperation {

        @Override
        public Double execute(Double... operands) {
            calculator.div(operands[0], operands[1]);
            return calculator.getResult();
        }
    }
}
