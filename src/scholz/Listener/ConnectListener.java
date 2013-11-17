package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scholz.ConnectData;
import scholz.GUI.ConnectPanel;

/**
 * Listener für den ConnectButton
 * 
 * @author Dominik
 * @version 0.1
 */
public class ConnectListener implements ActionListener {
    
    private ConnectPanel cp;

    public ConnectListener(ConnectPanel cp) {
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ConnectData.get().setHost(cp.getHost());
        ConnectData.get().setUser(cp.getUser());
        ConnectData.get().setPassword(cp.getPassword());
        ConnectData.get().setDatabase(cp.getDatabase());
        //Connector aufrufen und versuchen zu verbinden
        //Status aktualisieren
    }
    
}
