package abstractFactoryPattern;

public class ColorFactory extends AbstractFactory {

    @Override
    Color getColor(String type) {
        if (type == null)
            return null;
        if (type.equalsIgnoreCase("Red")) {
            return new Red();
        } else if (type.equalsIgnoreCase("Green")) {
            return new Green();
        } else if (type.equalsIgnoreCase("Blue")) {
            return new Blue();
        }
        return null;
    }

    @Override
    Shape getShape(String type) {
        return null;
    }

}
