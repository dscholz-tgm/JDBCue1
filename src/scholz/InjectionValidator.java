package scholz;

/**
 * Validiert den SQL Befehl
 * 
 * @author Dominik
 * @version 0.2
 */
public class InjectionValidator {
    
    private static String[] unallowedText = {"INSERT", "DROP", "CREATE", "GRANT", "UPDATE", "ALTER", "USE", "DELETE"};
    private static String[] allowedText = {"SELECT", "DESCRIBE", "SHOW", "DESC"};

    /**
     * Validiert einen SQL Befehl
     * @param inputSql der SQL Befehö
     * @return ob der Befehl valid ist
     */
    public static boolean validate(String inputSql) {
        String sql = inputSql.toUpperCase();
        
        if(sql.indexOf(';') != sql.length()-1) return false;
        
        for (String s : unallowedText) {
            if (sql.contains(s)) return false;
        }
        
        int i = 0;
        for (String s : allowedText) {
            if (sql.startsWith(s)) break;
            if (i++ == allowedText.length) return false;
        }
        
        return true;
    }

}
