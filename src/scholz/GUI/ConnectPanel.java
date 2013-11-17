package scholz.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import scholz.ConnectData;
import scholz.ConnectStatus;

/**
 * Panel zur Darstellung der Verbindungsinformationen
 * 
 * @author Dominik
 * @version 0.1
 */
public class ConnectPanel extends JPanel {
    
    private JTextField hostField, userField, databaseField;
    private JPasswordField passwordField;
    private JButton connect;
    private JPanel connectData;
    private JLabel connectInfo;

    public ConnectPanel() {
        ConnectData cd = ConnectData.get();
        
        hostField = new JTextField(cd.getHost());
        userField = new JTextField(cd.getUser());
        databaseField = new JTextField(cd.getDatabase());
        passwordField = new JPasswordField(cd.getPassword());
        connect = new JButton("connect");
        
        this.setLayout(new BorderLayout());
        
        connectData = new JPanel(new GridLayout(4,2)); //Ev. in GridBagLayout ändern
        
        connectData.add(new JLabel("Host:"));
        connectData.add(hostField);
        connectData.add(new JLabel("User:"));
        connectData.add(userField);
        connectData.add(new JLabel("Password:"));
        connectData.add(passwordField);
        connectData.add(new JLabel("Database:"));
        connectData.add(databaseField);
        
        this.add(connectData,BorderLayout.NORTH);
        
        connectInfo = new JLabel(ConnectStatus.NOT_CONNETED.getText());
        connectInfo.setForeground(Color.RED);
        this.add(connectInfo,BorderLayout.CENTER);
        
        connect = new JButton("connect");
        this.add(connect,BorderLayout.SOUTH);
    }
    
}
