package scholz;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * Stellt die Verbindung mit der Datenbank her
 * 
 * @author Dominik
 * @version 0.2
 */
public class Connector {

    private ConnectData cd = ConnectData.get();
    private Connection con;
    private ConnectStatus status = ConnectStatus.NOT_CONNECTED;
        
    private static Connector i = new Connector();
    public static Connector get() { return i; };
    
    public ConnectStatus getStatus() {
        return status;
    }
    
    public Connection con() {
        return con;
    }
    
    /**
     * stellt eine Verbindung zu Datenbank her
     * @throws java.sql.SQLException
     */
    public void connect() throws SQLException {
        DataSource ds = DataSourceFactory.create(cd.getDatabaseType(),cd.getHost(),cd.getDatabase());
        if (con != null) con.close();
        con = ds.getConnection(cd.getUser(), cd.getPassword());

        
        con = ds.getConnection();
        status = ConnectStatus.CONNECTED;
    }
    
    /**
     * trennt die Verbindung zur Datenbank
     */
    public void disconnect() {
        if(con == null) return;
        try {
            con.close();
        } catch (SQLException ex) {
        }
        status = ConnectStatus.NOT_CONNECTED;
    }
}
