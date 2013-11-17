package scholz;

/**
 * Beinhaltet die Verbindungsdaten
 *
 * @author Dominik
 * @version 0.1
 */
public class ConnectData {

    private static ConnectData i = new ConnectData();
    public static ConnectData get() { return i; };
    
    private String host = "";
    private String user = "";
    private String password = "";
    private String database = "";

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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * Parsed die CommandLine Argumente
     * @param args Die CommandLine Argumente
     * @return Ob das Parsen Erfolgreich war
     */
    public boolean parse(String[] args) {
        if (args == null || args.length != 8) return false;
        
        int i = 0;
        
        if (args[i++].equals("-h")) host = args[i++];
        else return false;
        
        if (args[i++].equals("-u")) user = args[i++];
        else return false;
        
        if (args[i++].equals("-p")) password = args[i++];
        else return false;
        
        if (args[i++].equals("-d")) database = args[i++];
        else return false;
        
        return true;
    }

}
