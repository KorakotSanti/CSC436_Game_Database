package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 */
public final class App {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    //localhost connection, note 'game_database' is the database name in mysql
    private static final String URL = "jdbc:mysql://localhost:3306/game_database";

    private App() {
    }

    public static void main(String[] args) {

        // to store connection of mysql database
        Connection conn = null;
        try {
            //gotta register to the driver for mysql connector
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            //establish the connection to your db
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            System.err.println("ERROR ERROR ERROR");
            System.err.println(e.getMessage());

        }

        // statement is the query gonna create
        Statement stmt = null;

        // added random values, for example insert
        String values = "(4, 'Historic')";
        values = values + ",(5,'Shooter')";
        values = values + ",(6,'YEET')";

        // use sql statement to add all values
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO genre (genre_id, genre_name) "+
                                "VALUES" +
                                values);
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }
    }
}
