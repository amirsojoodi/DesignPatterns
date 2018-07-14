package interpreter.expressions;

import interpreter.Context;

import java.util.List;

public class ListExpression implements BencodeExpression {
    private List<? extends BencodeExpression> elemList;

    public ListExpression(List<? extends BencodeExpression> elemList) {
        this.elemList = elemList;
    }

    @Override
    public String interpret(Context ctx) {
        StringBuilder sb = new StringBuilder("l");
        for (BencodeExpression elem : elemList)
            sb.append(elem.interpret(ctx));
        sb.append("e");  //  "l" + value + "e"
        return sb.toString();
    }

    public List<? extends BencodeExpression> getElemList() {
        return elemList;
    }

    public void setElemList(List<? extends BencodeExpression> elemList) {
        this.elemList = elemList;
    }
}
