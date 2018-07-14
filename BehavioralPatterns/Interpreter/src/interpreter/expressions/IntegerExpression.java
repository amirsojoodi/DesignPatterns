package interpreter.expressions;

import interpreter.Context;

public class IntegerExpression implements BencodeExpression {
    private int value;

    public IntegerExpression(int value) {
        this.value = value;
    }

    @Override
    public String interpret(Context ctx) {
        return "i" + value + "e";
    }
}
