package scholz.GUI;

import scholz.Listener.ConnectListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import scholz.ConnectData;
import scholz.ConnectStatus;
import scholz.Listener.DisConnectListener;

/**
 * Panel zur Darstellung der Verbindungsinformationen
 * 
 * @author Dominik
 * @version 0.4
 */
public class ConnectPanel extends JPanel {
    
    private JTextField hostField, userField, databaseField;
    private JPasswordField passwordField;
    private JButton connect,disconnect;
    private JPanel centerPanel,connectData,buttonPanel;
    private JLabel connectInfo;

    public ConnectPanel() {
        ConnectData cd = ConnectData.get();
        
        hostField = new JTextField(cd.getHost());
        userField = new JTextField(cd.getUser());
        databaseField = new JTextField(cd.getDatabase());
        passwordField = new JPasswordField(cd.getPassword());
        
        connectData = new JPanel(new GridLayout(4,2)); //Ev. in GridBagLayout ändern
        
        connectData.add(new JLabel("Host:"));
        connectData.add(hostField);
        connectData.add(new JLabel("User:"));
        connectData.add(userField);
        connectData.add(new JLabel("Password:"));
        connectData.add(passwordField);
        connectData.add(new JLabel("Database:"));
        connectData.add(databaseField);
        
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(connectData,BorderLayout.NORTH);
        
        connectInfo = new JLabel(ConnectStatus.NOT_CONNETED.getText(),JLabel.CENTER); //Auswechseln durch Variablen Zustand
        connectInfo.setForeground(Color.RED); //Auswechseln durch Variablen Zustand
        
        centerPanel.add(connectInfo,BorderLayout.CENTER);
        
        connect = new JButton("verbinden");
        connect.addActionListener(new ConnectListener(this));
        
        disconnect = new JButton("trennen");
        disconnect.addActionListener(new DisConnectListener(this));
        
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(connect);
        buttonPanel.add(disconnect);
        
        centerPanel.add(buttonPanel,BorderLayout.SOUTH);
        
        this.setLayout(new FlowLayout());
        this.add(centerPanel);
    }
    
    public String getHost() {
        return hostField.getText();
    }

    public String getUser() {
        return userField.getText();
    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }
    
    public String getDatabase() {
        return databaseField.getText();
    }
    
    /**
     * Updated den Statustext
     */
    public void updateStatus() {
        connectInfo.setText(ConnectStatus.CONNECTED.getText());
        connectInfo.setForeground(ConnectStatus.CONNECTED.getColor());
    }
    
}
