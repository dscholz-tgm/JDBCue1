package scholz.GUI;

import scholz.Listener.SendListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Panel zur Darstellung der Datentabellen
 * 
 * @author Dominik
 * @version 0.2
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
        centerPanel.add(new JScrollPane(table),BorderLayout.CENTER);
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        
        this.setLayout(new FlowLayout());
        this.add(centerPanel);
    }
    
    public String getSql() {
        return sqlField.getText();
    }

    /**
     * updated die Tabelle
     * @param tm Das neue TableModel
     */
    public void updateTable(TableModel tm) {
        table.setModel(tm);
    }

}
