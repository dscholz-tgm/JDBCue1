package scholz.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import scholz.ConnectData;
import scholz.ConnectStatus;
import scholz.Listener.ConnectListener;
import scholz.Listener.DisConnectListener;

/**
 * Panel zur Darstellung der Verbindungsinformationen
 * 
 * @author Dominik
 * @version 0.5
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
        connectData.setPreferredSize(new Dimension(240,84));
        centerPanel.add(connectData,BorderLayout.NORTH);
        
        connectInfo = new JLabel(ConnectStatus.NOT_CONNECTED.getText(),JLabel.CENTER);
        connectInfo.setPreferredSize(new Dimension(100,40));
        connectInfo.setForeground(ConnectStatus.NOT_CONNECTED.getColor());
        
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
     * @param status der Status auf den Upgedated werden soll
     */
    public void updateStatus(ConnectStatus status) {
        connectInfo.setText(status.getText());
        connectInfo.setForeground(status.getColor());
    }
    
}
