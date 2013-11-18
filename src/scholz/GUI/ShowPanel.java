package scholz.GUI;

import scholz.Listener.SendListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

/**
 * Panel zur Darstellung der Datentabellen
 * 
 * @author Dominik
 * @version 0.4
 */
public class ShowPanel extends JPanel {
    
    private JTextField sqlField;
    private JButton send;
    private JPanel centerPanel,headerPanel,sendPanel;
    private JTable table;

    public ShowPanel() {

        centerPanel = new JPanel(new GridLayout(2,1));
        headerPanel = new JPanel(new FlowLayout());
        sendPanel = new JPanel(new FlowLayout());
                
        sqlField = new JTextField();
                
        send = new JButton("senden");
        send.addActionListener(new SendListener(this));
        
        headerPanel.add(new JLabel("SQL Befehl:                       "));
        JLabel zusatzInfo = new JLabel("(nur SELECT, SHOW und DESCRIBE)");
        zusatzInfo.setForeground(Color.GRAY);
        headerPanel.add(zusatzInfo);
        sqlField.setPreferredSize(new Dimension(480,24));
        sendPanel.add(sqlField);
        sendPanel.add(send);
        centerPanel.add(headerPanel);
        centerPanel.add(sendPanel);
        
        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        this.setLayout(new BorderLayout());
        this.add(centerPanel,BorderLayout.NORTH);
        this.add(new JScrollPane(table),BorderLayout.CENTER);
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
