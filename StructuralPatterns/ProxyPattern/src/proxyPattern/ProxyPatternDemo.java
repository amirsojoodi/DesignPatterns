package proxyPattern;

public class ProxyPatternDemo {
    
    public static void main(String[] args) {
        Image image = new ProxyImage("kalam.jpg");
        
        // image will be loaded from disk
        image.display();
        
        
        // image will not be loaded from disk (it has been already loaded)
        image.display();
    }
}
