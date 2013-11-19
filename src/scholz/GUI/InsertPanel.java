package scholz.GUI;

import scholz.Listener.ComboBoxListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scholz.Listener.InsertListener;

/**
 * Panel zum Einsetzen der Datensätze
 * 
 * @author Dominik
 * @version 0.2
 */
public class InsertPanel extends JPanel {
    
    private JComboBox comboBox;
    private JButton insert;
    private JPanel insertFields,headerPanel,northPanel;
    private List<JTextField> textFields;
    private List<JLabel> labelList;

    public InsertPanel() {

        insertFields = new JPanel(new GridLayout(2,1));
        headerPanel = new JPanel(new GridLayout(1,2));
                
        insert = new JButton("einfügen");
        insert.addActionListener(new InsertListener(this));
        
        headerPanel.add(new JLabel("Datensätze einfügen:"));
        comboBox = new JComboBox();
        comboBox.addActionListener(new ComboBoxListener(this));
        headerPanel.add(comboBox);

        northPanel = new JPanel(new BorderLayout());
        northPanel.add(headerPanel,BorderLayout.NORTH);
        northPanel.add(Box.createVerticalStrut(24));
        northPanel.add(insertFields,BorderLayout.SOUTH);
        
        this.setLayout(new BorderLayout());
        this.add(northPanel,BorderLayout.NORTH);
        this.add(insert,BorderLayout.SOUTH);
    }

    /**
     * updated die ComboBox
     * @param cbm das neue ComboBoxModel
     */
    public void updateCombobox(ComboBoxModel cbm) {
        comboBox.setModel(cbm);
    }
    
    /**
     * updated die InsertFields
     * @param labelList 
     */
    public void updateInsertFields(List<JLabel> labelList) {
        northPanel.remove(insertFields);
        insertFields.removeAll();
        insertFields = new JPanel(new GridLayout(labelList.size(),2));
        this.labelList = labelList;
        textFields = new LinkedList<>();
        for (JLabel label : labelList) {
            insertFields.add(label);
            JTextField tempField = new JTextField();
            textFields.add(tempField);
            insertFields.add(tempField);
        }
        northPanel.add(insertFields,BorderLayout.SOUTH);
        northPanel.updateUI();
    }

}
