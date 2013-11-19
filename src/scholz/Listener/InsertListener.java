package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import scholz.GUI.InsertPanel;

/**
 * Listener für den Insert Button
 * 
 * @author Dominik
 * @version 0.2
 */
public class InsertListener implements ActionListener {
    
    private InsertPanel ip;
    private PreparedStatement stmnt;
    private List<Integer> typeList;

    public InsertListener(InsertPanel ip) {
        this.ip = ip;
    }
    
    public void setPreparedStatement(PreparedStatement stmnt, List<Integer> typeList) {
        this.stmnt = stmnt;
        this.typeList = typeList;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            int i = 1;
            for (JTextField textField : ip.getTextFields()) {
                stmnt.setObject(i, textField.getText(), typeList.get(i - 1));
                i++;
            }
            stmnt.execute();
            stmnt.clearParameters();
            JOptionPane.showMessageDialog(null, "Datensatz erfolgreich eingefügt!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fehler beim Einfügen des Datensatzes:\nError:"+ ex.getMessage(), "ERROR !", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
