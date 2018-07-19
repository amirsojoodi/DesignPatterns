package interpreter.expressions;

import interpreter.Context;

public interface BencodeExpression {
    String interpret(Context ctx);
}
