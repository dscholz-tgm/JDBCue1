package scholz;

import scholz.GUI.GUI;

/**
 * Startklasse zum Ausführen des JDBC Programmes
 *
 * @author Dominik
 * @version 0.2
 */
public class JDBCue1 {

    /**
     * Main Methode - Wird beim starten ausgeführt
     * @param args Die Command-Line Argumente
     */
    public static void main(String[] args) {
        ConnectData.get().parse(args);
        GUI.get();
    }

}
