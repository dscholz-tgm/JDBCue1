package scholz;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Stellt die Verbindung mit der Datenbank her
 * 
 * @author Dominik
 * @version 0.1
 */
public class Connector {

    private MysqlDataSource ds = new MysqlDataSource();
    private ConnectData cd = ConnectData.get();
    private Connection con;
    private ConnectStatus status = ConnectStatus.NOT_CONNECTED;
        
    private static Connector i = new Connector();
    public static Connector get() { return i; };
    
    public ConnectStatus getStatus() {
        return status;
    }
    
    /**
     * stellt eine Verbindung zu Datenbank her
     */
    public void connect() {
        ds.setServerName(cd.getHost());
        ds.setUser(cd.getUser());
        ds.setPassword(cd.getPassword());
        ds.setDatabaseName(cd.getDatabase());
        
        try {
            con = ds.getConnection();
            status = ConnectStatus.CONNECTED;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verbindung zur Datenbank konnte nicht hergestellt werden\nGrund: " + ex.getMessage(), "ERROR !", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * trennt die Verbindung zur Datenbank
     */
    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
        }
        status = ConnectStatus.NOT_CONNECTED;
    }
}
