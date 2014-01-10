package scholz;

/**
 * Beinhaltet die Verbindungsdaten
 *
 * @author Dominik
 * @version 0.5
 */
public class ConnectData {
    
    private String host, user, password, database;
    private Database dbType;
    
    private static ConnectData i = new ConnectData();
    public static ConnectData get() { return i; };
    
    private ConnectData() {
        host = "";
        user = "";
        password = "";
        database = "";
        dbType = Database.MYSQL; //Default Datenbank
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public Database getDatabaseType() {
        return dbType;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
    
    public void setDatabaseType(Database dbType) {
        this.dbType = dbType;
    }

    /**
     * Parsed die CommandLine Argumente
     * @param args Die CommandLine Argumente
     * @return Ob das Parsen Erfolgreich war
     */
    public boolean parse(String[] args) {
        if (args == null) return false;
        
        for(int i = 0; i < (args.length % 2 == 0 ? args.length : args.length-1); i++) {
            if(args[i].equals("-h") && host.equals("")) host = args[++i];
            else if (args[i].equals("-u") && user.equals("")) user = args[++i];
            else if (args[i].equals("-p") && password.equals("")) password = args[++i];
            else if (args[i].equals("-d") && database.equals("")) database = args[++i];
            else if (args[i].equals("-s") && dbType == Database.MYSQL) dbType = Database.valueOf(args[++i]);
        }
        
        return true;
    }

}
