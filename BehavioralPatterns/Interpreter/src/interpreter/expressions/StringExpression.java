package interpreter.expressions;

import interpreter.Context;

public class StringExpression implements BencodeExpression {
    private String value;

    public StringExpression(String value) {
        this.value = value;
    }

    @Override
    public String interpret(Context ctx) {
        return value.length() + ":" + value;
    }
}
