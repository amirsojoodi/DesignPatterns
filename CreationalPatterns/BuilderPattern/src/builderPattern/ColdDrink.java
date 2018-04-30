package builderPattern;

public abstract class ColdDrink implements Item {

    @Override
    public Packing getPacking() {
        return new Bottle();
    }

}
