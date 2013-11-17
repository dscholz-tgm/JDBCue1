package scholz;

import java.awt.Color;

/**
 * Verbindungsstatus
 * 
 * @author Dominik
 * @version 0.2
 */
public enum ConnectStatus {
    CONNECTED("Verbunden",Color.GREEN),
    NOT_CONNECTED("Nicht Verbunden",Color.RED);
    
    private String text;
    private Color color;
    
    private ConnectStatus(String text, Color color) {
        this.text = text;
        this.color = color;
    }
    
    public String getText() {
        return text;
    }
    
    public Color getColor() {
        return color;
    }
}
