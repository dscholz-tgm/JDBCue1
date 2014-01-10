package scholz.GUI;

import javax.swing.JOptionPane;

/**
 * @author Dominik
 * @version 0.1
 */
public class MessageDisplay {
    
    /**
     * Gibt eine Fehlernachricht aus
     * @param msg die Fehlernachricht
     */
    public static void error(String msg) {
        JOptionPane.showMessageDialog(null, msg, "ERROR !", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Gibt eine Nachricht aus
     * @param msg die Nachricht
     */
    public static void info(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
