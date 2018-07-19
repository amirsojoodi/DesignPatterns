package interpreter;

import interpreter.expressions.*;

import java.util.Arrays;
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        Torrent t = new Torrent();

        t.put(new StringExpression("name"), new StringExpression("Design Patterns"));  // put <str,str> element

        t.put(new StringExpression("magic-number"), new IntegerExpression(0xdeadbeef));

        t.put(new StringExpression("trackers"), new ListExpression(
                Arrays.asList(
                        new StringExpression("udp://good-tracker.com:1234"),
                        new StringExpression("udp://happy-tracker.fun:4312"),
                        new StringExpression("udp://tracker-sailors.sea:9381")
                )));  // put <str, list> element

        HashMap<StringExpression, BencodeExpression> hashesMap = new HashMap<>();
        hashesMap.put(new StringExpression("0"), new StringExpression("3f7868"));
        hashesMap.put(new StringExpression("16"), new StringExpression("89e6c9"));
        hashesMap.put(new StringExpression("32"), new StringExpression("2b66fd"));
        DictExpression hashes = new DictExpression(hashesMap);
        t.put(new StringExpression("hashes"), hashes); // put <str, map> element

        System.out.println(t);
    }
}
