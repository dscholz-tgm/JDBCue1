package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import scholz.ConnectData;
import scholz.Connector;
import scholz.GUI.ConnectPanel;
import scholz.GUI.GUI;

/**
 * Listener für den ConnectButton
 * 
 * @author Dominik
 * @version 0.3
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
        try {
            Connector.get().connect();
            cp.updateStatus(Connector.get().getStatus());
            GUI.get().enableTabs();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verbindung zur Datenbank konnte nicht hergestellt werden\nGrund: " + ex.getMessage(), "ERROR !", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
