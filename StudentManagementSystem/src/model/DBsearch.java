
 //* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 //* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package model;

//import com.sun.jdi.connect.spi.Connection;
//import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Statement;

public class DBsearch {
    
    
    public boolean check(String userName, String password) {
        Connection conn = DBconnection.connect();
        if (conn != null) {
            String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, userName);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    
    
    
    
    Statement stmt;
    ResultSet rs;
    
    public ResultSet searchLoggin(String usname){
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            stmt = dbconnection.getStatementConnection();
            
            String name = usname;
            
            rs = stmt.executeQuery("SELECT * FROM login WHERE usname = '"+name+"'");
        } catch (Exception e) {
            
            //Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return rs;
}


}

