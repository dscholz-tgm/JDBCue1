package scholz.GUI;

/**
 * Tabgrößen
 * 
 * @author Dominik
 * @version 0.1
 */
public enum TabSize {
    CONNECT(320,320),
    SHOW(800,400),
    INSERT(600,400);
    
    private int width, height;
    
    private TabSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}
