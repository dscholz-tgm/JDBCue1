package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import scholz.Connector;
import scholz.GUI.ShowPanel;

/**
 * Listener für den SendButton
 * 
 * @author Dominik
 * @version 0.1
 */
public class SendListener implements ActionListener {
    
    private ShowPanel sp;

    public SendListener(ShowPanel sp) {
        this.sp = sp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sql = sp.getSql();
        //WARNING SQL umbedingt parsen ansonsten SQL Injection
        try {
            Statement stmnt = Connector.get().con().createStatement();
            ResultSet rs = stmnt.executeQuery(sql);
            sp.updateTable(rs);
            rs.close();
            stmnt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fehler beim Ausführen der Query:\n\nQuery: " + sql + "\nError:"+ ex.getMessage(), "ERROR !", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
