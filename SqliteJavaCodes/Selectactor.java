   package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Selectactor {

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
    public void selectAll(double year_of_release){
        String sql = "SELECT id,name,actor,acteress,director,year_of_release"+"FROM Movies WHERE year_of_release = ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
             
		pstmt.setDouble(1,year_of_release);
		ResultSet rs    = pstmt.executeQuery(sql);
            
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
        Selectactor app = new Selectactor();
        app.selectAll(2013);
    }

}