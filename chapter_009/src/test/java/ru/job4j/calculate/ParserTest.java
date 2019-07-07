package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParserTest {

    @Test
    public void whenParseFullExpressionThenFilledAllFields() {
        Parser parser = new Parser();
        String expression = "1.0 + 2.0";
        parser.parse(expression);
        assertThat(parser.firstOperand(), is(1.0));
        assertThat(parser.secondOperand(), is(2.0));
        assertThat(parser.operator(), is("+"));
    }

    @Test
    public void whenParseExpressionWithoutOperatorThenOperatorIsNull() {
        Parser parser = new Parser();
        String expression = "1.0 2.0";
        parser.parse(expression);
        assertThat(parser.firstOperand(), is(1.0));
        assertThat(parser.secondOperand(), is(2.0));
        assertThat(parser.operator(), is((String) null));
        assertThat(parser.isNotOperator(), is(true));
    }

    @Test
    public void whenParseExpressionFirstOperandIsRThenFirstOperandIsNull() {
        Parser parser = new Parser();
        String expression = "r + 2.0";
        parser.parse(expression);
        assertThat(parser.firstOperand(), is((Double) null));
        assertThat(parser.secondOperand(), is(2.0));
        assertThat(parser.operator(), is("+"));
        assertThat(parser.isNotFirst(), is(true));
    }

    @Test
    public void whenParseExpressionSecondOperandIsRThenSecondOperandIsNull() {
        Parser parser = new Parser();
        String expression = "1.0 + r";
        parser.parse(expression);
        assertThat(parser.firstOperand(), is(1.0));
        assertThat(parser.secondOperand(), is((Double) null));
        assertThat(parser.operator(), is("+"));
        assertThat(parser.isNotSecond(), is(true));
    }

    @Test
    public void whenParseExpressionFirstAndSecondOperandsIsRThenFirstAndSecondOperandsIsNull() {
        Parser parser = new Parser();
        String expression = "r + r";
        parser.parse(expression);
        assertThat(parser.firstOperand(), is((Double) null));
        assertThat(parser.secondOperand(), is((Double) null));
        assertThat(parser.operator(), is("+"));
        assertThat(parser.isNotFirst(), is(true));
        assertThat(parser.isNotSecond(), is(true));
    }

    @Test
    public void whenClearFieldsThenAllFieldsIsNull() {
        Parser parser = new Parser();
        String expression = "1.0 + 2.0";
        parser.parse(expression);
        parser.clearFields();
        assertThat(parser.firstOperand(), is((Double) null));
        assertThat(parser.secondOperand(), is((Double) null));
        assertThat(parser.operator(), is((String) null));
    }
}