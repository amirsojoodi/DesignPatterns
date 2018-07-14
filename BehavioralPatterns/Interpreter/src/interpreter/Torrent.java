package interpreter;

import interpreter.expressions.BencodeExpression;
import interpreter.expressions.DictExpression;
import interpreter.expressions.StringExpression;

import java.util.HashMap;
import java.util.Map;

// Torrent files are encoded in Bencode
public class Torrent {
    private Map<StringExpression, BencodeExpression> map = new HashMap<>();

    public void put(StringExpression stringElement, BencodeExpression bencodeExpression) {
        map.put(stringElement, bencodeExpression);
    }

    // create torrent file content
    @Override
    public String toString() {
        return new DictExpression(map).interpret(null);
    }
}
