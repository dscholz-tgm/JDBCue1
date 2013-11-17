package scholz.GUI;

import scholz.Listener.SendListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Panel zur Darstellung der Datentabellen
 * 
 * @author Dominik
 * @version 0.1
 */
public class ShowPanel extends JPanel {
    
    private JTextField sqlField;
    private JButton send;
    private JPanel centerPanel,headerPanel;
    private JTable table;

    public ShowPanel() {

        centerPanel = new JPanel(new BorderLayout());
        headerPanel = new JPanel(new GridLayout(3,1));
                
        sqlField = new JTextField();
                
        send = new JButton("senden");
        send.addActionListener(new SendListener(this));
        
        headerPanel.add(new JLabel("SQL Befehl:                                     (nur SELECT, SHOW und DESCRIBE)"));
        headerPanel.add(sqlField);
        headerPanel.add(send);
        centerPanel.add(headerPanel,BorderLayout.NORTH);
        
        table = new JTable();
        
        centerPanel.add(table,BorderLayout.CENTER);
        
        this.setLayout(new FlowLayout());
        this.add(centerPanel);
    }
    
    public String getSql() {
        return sqlField.getText();
    }

    /**
     * updated die Tabelle
     * @param rs das ResultSet mit dem die Tabelle befüllt wird
     */
    public void updateTable(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        table = new JTable(new DefaultTableModel(data, columnNames));
    }

}
