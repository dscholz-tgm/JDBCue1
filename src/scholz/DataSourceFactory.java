package scholz;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;
import org.sqlite.SQLiteDataSource;
import org.sqlite.SQLiteJDBCLoader;

/**
 * @author Dominik
 * @version 0.1
 */
public class DataSourceFactory {

    public static DataSource create(Database db, String host, String database) {
        if(db == Database.MYSQL) {
            MysqlDataSource mds = new MysqlDataSource();
            mds.setServerName(host);
            mds.setDatabaseName(database);
            return mds;
        }
        else if(db == Database.POSTGRESQL) {
            PGSimpleDataSource sdm = new PGSimpleDataSource();
            sdm.setServerName(host);
            sdm.setDatabaseName(database);
            return sdm;
        }
        else if (db == Database.SQLITE) {
             SQLiteJDBCLoader.initialize();
             SQLiteDataSource sqs = new SQLiteDataSource();
             sqs.setUrl("jdbc:sqlite:/" + host + "/" + database);
             return sqs;
        }
        
        return null;
    }
}
