package scholz.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scholz.Listener.InsertListener;

/**
 * Panel zum Einsetzen der Datensätze
 * 
 * @author Dominik
 * @version 0.1
 */
public class InsertPanel extends JPanel {
    
    private JComboBox comboBox;
    private JButton insert;
    private JPanel insertFields,headerPanel,flowWrapper1;

    public InsertPanel() {

        insertFields = new JPanel(new GridLayout(2,1));
        headerPanel = new JPanel(new GridLayout(1,2));
                
        insert = new JButton("einfügen");
        insert.addActionListener(new InsertListener(this));
        
        headerPanel.add(new JLabel("Datensätze einfügen:"));
        comboBox = new JComboBox();
        headerPanel.add(comboBox);

        this.setLayout(new BorderLayout());
        this.add(headerPanel,BorderLayout.NORTH);
        this.add(insertFields,BorderLayout.CENTER);
        this.add(insert,BorderLayout.SOUTH);
    }

    /**
     * updated die ComboBox
     * @param cbm das neue ComboBoxModel
     */
    public void updateCombobox(ComboBoxModel cbm) {
        comboBox.setModel(cbm);
    }
    
    public void updateInsertFields(List<Component> componentList) {
        insertFields.removeAll();
        insertFields.setLayout(new GridLayout(componentList.size()/2,2));
        for (Component c : componentList) insertFields.add(c);
    }

}
