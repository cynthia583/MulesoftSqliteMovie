package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Insert {

    /**
     * Connect to the test.db database
     *
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
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String name,String actor,String acteress,String director,double year_of_release) {
        String sql = "INSERT INTO Movies(name,actor,acteress,director,year_of_release) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
		pstmt.setString(2, actor);
		pstmt.setString(3, acteress);
		pstmt.setString(4, director);
            pstmt.setDouble(5, year_of_release);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Insert app = new Insert();
        // insert three new rows
        app.insert("Bangalore Days", "Dulqur","Nazriya","Anjali Menon",2014);
        app.insert("Dhrishyam","Mohanlal","Meena","Jeetu Joseph", 2013);
     app.insert("Priest","Mammuty","Nithya","Jophine",2020);

   
    }

}
