package bridgePattern;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(), 10, 10, 100);
        Shape greenCircle = new Circle(new GreenCircle(), 12, 12, 120);
        
        redCircle.draw();
        greenCircle.draw();
    }
}
