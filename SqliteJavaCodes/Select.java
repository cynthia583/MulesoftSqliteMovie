package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Select {

    /**
     * Connect to the newmovie.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Sqlite/db/newmovie.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * select all rows in the Movies table
     */
    public void selectAll(){
        String sql = "SELECT id, name,actor,acteress,director,year_of_release FROM Movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
				rs.getString("actor") + "\t" +
				rs.getString("acteress") + "\t" +
				rs.getString("director") + "\t" +
                                   rs.getDouble("year_of_release"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Select app = new Select();
        app.selectAll();
    }

}