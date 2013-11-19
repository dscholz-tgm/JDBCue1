package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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
            populateComboBox();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verbindung zur Datenbank konnte nicht hergestellt werden\nGrund: " + ex.getMessage(), "ERROR !", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * füllt die ComboBox
     */
    private void populateComboBox() throws SQLException {
        Statement stmnt = Connector.get().con().createStatement();
        ResultSet rs = stmnt.executeQuery("SHOW tables");
        List<String> tables = new LinkedList<>();
        tables.add("--- Tabelle auswählen ---");
        while(rs.next()) {
            tables.add(rs.getString(1));
        }
        GUI.get().getInsertPanel().updateCombobox(new DefaultComboBoxModel(tables.toArray()));
        rs.close();
        stmnt.close();
    }
    
}
