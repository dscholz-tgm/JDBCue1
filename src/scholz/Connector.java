package scholz;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Stellt die Verbindung mit der Datenbank her
 * 
 * @author Dominik
 * @version 0.2
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
    
    public Connection con() {
        return con;
    }
    
    /**
     * stellt eine Verbindung zu Datenbank her
     * @throws java.sql.SQLException
     */
    public void connect() throws SQLException {
        if (con != null) con.close();
        ds.setServerName(cd.getHost());
        ds.setUser(cd.getUser());
        ds.setPassword(cd.getPassword());
        ds.setDatabaseName(cd.getDatabase());
        
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
