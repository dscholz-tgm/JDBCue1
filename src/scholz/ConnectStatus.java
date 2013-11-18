package scholz;

import java.awt.Color;

/**
 * Verbindungsstatus
 * 
 * @author Dominik
 * @version 0.2
 */
public enum ConnectStatus {
    CONNECTED("Verbunden",new Color(0,127,0)),
    NOT_CONNECTED("Nicht Verbunden",new Color(200,0,0));
    
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
