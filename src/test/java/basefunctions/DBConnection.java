package basefunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**

 * @author : Alim Hamut
 * @created : 2023-10-20,7:25 p.m.
 * @Email : alimhamut.job@gmail.com
 **/

public class DBConnection {
    // creat a method to connect to data base
    public Connection connectToDataBaseServer(
            String dbUrl,
            String dbPort,
            String username,
            String password,
            String defaultDB,
            ConnectionType connectionType) {
        String JTDS_Driver = "net.sourceforge.jtds.jdbc.Driver"; //MSSQL
        String MYSQL_Driver = "com.mysql.cj.jdbc.Driver"; //MYSQL
        Connection connection = null;
        switch (connectionType) {
            case MSSQL:
                try {
                    Class.forName(JTDS_Driver); //load the driver
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String msSqlConnectionUrl = "jdbc:jtds:sqlserver://" + dbUrl + ":" + dbPort + ";DataBaseName=" + defaultDB;
                try {
                    connection = DriverManager.getConnection(msSqlConnectionUrl, username, password);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (!connection.isClosed()) {
                        System.out.println("Connection is established!!!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case MYSQL:
                try {
                    Class.forName(MYSQL_Driver);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String mySqlConnectionUrl = "jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + defaultDB + "?useSSL=TRUE";

                String mySqlConnectionUrl = "jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + defaultDB + "?useSSL=FALSE";
                try {
                    connection = DriverManager.getConnection(mySqlConnectionUrl, username, password);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (!connection.isClosed()) {
                        System.out.println("Connection is established!!!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("You need to specify a Database Connection type MSSQL or MYSQL!!!");
                try {
                    if (!connection.isClosed()) {
                        System.out.println("Connection is established!!!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        return connection;
    }

    public void closeDataBaseConnection(Connection connection) {
        try {
            if (connection.isClosed()) {
                System.out.println("Connection is already closed!");
            } else {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
