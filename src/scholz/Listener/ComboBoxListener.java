package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
 * @version 0.4
 */
public class ComboBoxListener implements ActionListener {
    
    private InsertPanel ip;
    private InsertListener il;

    public ComboBoxListener(InsertPanel ip, InsertListener il) {
        this.ip = ip;
        this.il = il;
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
            
            rs = stmnt.executeQuery("SELECT * FROM " + table + " LIMIT 0;");
            ResultSetMetaData md = rs.getMetaData();
            List<Integer> typeList = new LinkedList<>();
            for (int i = 1; i <= md.getColumnCount(); i++) {
                typeList.add(md.getColumnType(i));
            }
            prepareStatement(table,labels.size(),typeList);
            rs.close();
            stmnt.close();
            ip.updateInsertFields(labels);
        } catch (SQLException ex) {
        }
    }
    
    public void prepareStatement(String table, int valueCount, List<Integer> typeList) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT INTO " + table + " VALUES (");
        for (int i = 0; i < valueCount; i++) {
            sql.append("?");
            if (i != valueCount-1) sql.append(" ,");
        }
        sql.append(");");
        il.setPreparedStatement(Connector.get().con().prepareStatement(sql.toString()),typeList);
    }

}
