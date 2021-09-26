package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Table {

    /**
     * Create a new table in the newmovie database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Sqlite/db/newmovie.db";
        
        // SQL statement for creating a new table
String sql = "CREATE TABLE IF NOT EXISTS Movies "
                + "(id integer PRIMARY KEY NOT NULL,"
                + "name text NOT NULL,"
		+ "	actor text NOT NULL,"
		+ "	acteress text NOT NULL,"
		+ "	director text NOT NULL,"
		+ "	year_of_release real NOT NULL)";
            

        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}


