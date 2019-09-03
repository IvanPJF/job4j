package ru.job4j.calculate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Storage operators.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.08.2019
 *@version 0.1
 */
public class StorageOperators {

    private Map<String, IOperation> operators = new HashMap<>();

    public IOperation getOperation(String operator) {
        return this.operators.get(operator);
    }

    public void addOperator(IOperation newOperator) {
        this.operators.put(newOperator.getSign(), newOperator);
    }

    public Set<String> allOperators() {
        return this.operators.keySet();
    }

    /**
     * Internal class for storage.
     * Class for addition operation.
     */
    public static class AddOperation extends BaseOperation {

        public AddOperation(Calculator calc, String sign) {
            super(calc, sign);
        }

        @Override
        public Double execute(Double... operands) {
            getCalc().add(operands[0], operands[1]);
            return getCalc().getResult();
        }
    }

    /**
     * Internal class for storage.
     * Class for subtraction operation.
     */
    public static class SubOperation extends BaseOperation {

        public SubOperation(Calculator calc, String sign) {
            super(calc, sign);
        }

        @Override
        public Double execute(Double... operands) {
            getCalc().subtract(operands[0], operands[1]);
            return getCalc().getResult();
        }
    }

    /**
     * Internal class for storage.
     * Class for multiplication operation.
     */
    public static class MultOperation extends BaseOperation {

        public MultOperation(Calculator calc, String sign) {
            super(calc, sign);
        }

        @Override
        public Double execute(Double... operands) {
            getCalc().multiple(operands[0], operands[1]);
            return getCalc().getResult();
        }
    }

    /**
     * Internal class for storage.
     * Class for division operation.
     */
    public static class DivOperation extends BaseOperation {

        public DivOperation(Calculator calc, String sign) {
            super(calc, sign);
        }

        @Override
        public Double execute(Double... operands) {
            getCalc().div(operands[0], operands[1]);
            return getCalc().getResult();
        }
    }
}
