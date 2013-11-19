package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import scholz.Connector;
import scholz.GUI.GUI;
import scholz.GUI.InsertPanel;

/**
 * Listener für die ComboBox
 * 
 * @author Dominik
 * @version 0.1
 */
public class ComboBoxListener implements ActionListener {
    
    private InsertPanel ip;

    public ComboBoxListener(InsertPanel ip) {
        this.ip = ip;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if(((JComboBox) ae.getSource()).getSelectedIndex() == 0) return;
            String table = ((JComboBox) ae.getSource()).getSelectedItem().toString();
            Statement stmnt = Connector.get().con().createStatement();
            ResultSet rs = stmnt.executeQuery("DESCRIBE " + table + ";");
            List<JLabel> labels = new LinkedList<>();
            while(rs.next()) {
                labels.add(new JLabel(rs.getString(1)));
            }
            GUI.get().getInsertPanel().updateInsertFields(labels);
            rs.close();
            stmnt.close();
        } catch (SQLException ex) {
        }
    }

}
