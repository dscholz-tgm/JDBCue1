package scholz;

import java.awt.Color;

/**
 * Verbindungsstatus
 * 
 * @author Dominik
 * @version 0.1
 */
public enum ConnectStatus {
    CONNECTED("Verbunden",Color.GREEN),
    NOT_CONNECTED_AUTH_FAIL("Nicht Verbunden, Fehlerhafte Benutzername-Passwort Kombination",Color.RED),
    NOT_CONNECTED_NO_DATABASE("Nicht Verbunden, Angegebene Datenbank existiert nicht",Color.RED),
    NOT_CONNECTED_NO_SERVER("Nicht Verbunden, Server kann nicht gefunden werden",Color.RED),
    NOT_CONNETED("Nicht Verbunden",Color.RED);
    
    private String text;
    private Color color;
    
    private ConnectStatus(String text, Color color) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
    
    public Color getColor() {
        return color;
    }
}
