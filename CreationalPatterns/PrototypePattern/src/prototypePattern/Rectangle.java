package prototypePattern;

public class Rectangle extends Shape {

    
    public  Rectangle() {
        type = "Rectangel";
    }
    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");        
    }

}
