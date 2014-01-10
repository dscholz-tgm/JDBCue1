package scholz.Listener;

import scholz.InjectionValidator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import scholz.Connector;
import scholz.GUI.MessageDisplay;
import scholz.GUI.ShowPanel;

/**
 * Listener für den SendButton
 * 
 * @author Dominik
 * @version 0.2
 */
public class SendListener implements ActionListener {
    
    private ShowPanel sp;

    public SendListener(ShowPanel sp) {
        this.sp = sp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sql = sp.getSql();
        if(!sql.endsWith(";")) sql += ";";
        if(!InjectionValidator.validate(sql)) {
            MessageDisplay.error("Verbotener SQL Befehl: " + sql);
            return;
        }
        try {
            Statement stmnt = Connector.get().con().createStatement();
            ResultSet rs = stmnt.executeQuery(sql);
            sp.updateTable(generateModel(rs));
            rs.close();
            stmnt.close();
        } catch (SQLException ex) {
            MessageDisplay.error("Fehler beim Ausführen der Query:\n\nQuery: " + sql + "\nError:"+ ex.getMessage());
        }
    }

    /**
     * generiert die neue Tabelle
     * @param rs das ResultSet
     * @return die neue Tabelle
     * @throws SQLException 
     */
    private TableModel generateModel(ResultSet rs) throws SQLException {
        DefaultTableModel newTable = new DefaultTableModel();
        
        //Spaltennamen
        ResultSetMetaData mdata = rs.getMetaData();
        int columnCount = mdata.getColumnCount();
        String[] colNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            colNames[i-1] = mdata.getColumnName(i);
        }
        newTable.setColumnIdentifiers(colNames);
 
        //Werte
        while (rs.next()) {
            String[] rowData = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getString(i);
            }
            newTable.addRow(rowData);
        }

        return newTable;
    }
    
}
