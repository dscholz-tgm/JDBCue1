package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scholz.GUI.ConnectPanel;
import scholz.GUI.GUI;

/**
 * Listener für den ConnectButton
 * 
 * @author Dominik
 * @version 0.2
 */
public class DisConnectListener implements ActionListener {
    
    private ConnectPanel cp;

    public DisConnectListener(ConnectPanel cp) {
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Connector aufrufen und verbindung trennen
        //Status aktualisieren
        GUI.get().disableTabs();
    }
    
}
