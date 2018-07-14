package interpreter.expressions;

import interpreter.Context;

import java.util.Map;

public class DictExpression implements BencodeExpression {
    private Map<StringExpression, BencodeExpression> map;

    public DictExpression(Map<StringExpression, BencodeExpression> map) {
        this.map = map;
    }

    @Override
    public String interpret(Context ctx) {
        StringBuilder sb = new StringBuilder("d");
        for (Map.Entry<StringExpression, BencodeExpression> kv : map.entrySet()) {
            sb.append(kv.getKey().interpret(ctx));
            sb.append(kv.getValue().interpret(ctx));
        }
        sb.append("e");  //  "d" + value + "e
        return sb.toString();
    }
}
