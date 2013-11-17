package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scholz.Connector;
import scholz.GUI.ConnectPanel;
import scholz.GUI.GUI;

/**
 * Listener für den DisConnectButton
 * 
 * @author Dominik
 * @version 0.3
 */
public class DisConnectListener implements ActionListener {
    
    private ConnectPanel cp;

    public DisConnectListener(ConnectPanel cp) {
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Connector.get().disconnect();
        cp.updateStatus(Connector.get().getStatus());
        GUI.get().disableTabs();
    }
    
}
