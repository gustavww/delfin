
package Database;

import Model.Medlem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MedlemMapper {
    
    public void InsertMedlem (Medlem medlem, String db) {
        String sql = "INSERT INTO " + db + " (name, age, tlf, address, status) VALUES (?,?,?,?,?)";
        try {
            Connection con = DatabaseConnector.getConnector();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, medlem.getName());
            ps.setInt(2, medlem.getAge());
            ps.setInt(3, medlem.getTlf());
            ps.setString(4, medlem.getAddress());
            ps.setInt(5, medlem.getStatus());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MedlemMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void RemoveMedlem (int id, String db) {
            String sql = "DELETE FROM " + db + " WHERE id = ?";
        try {
            Connection con = DatabaseConnector.getConnector();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);          
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MedlemMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void InsertKonkurrence (int id, String db) {
        String sql = 
                "INSERT INTO " + db + " (id, name, age)"
                + "SELECT id, name, age "
                + "FROM medlem "
                + "WHERE id =" + id;
        try {
            Connection con = DatabaseConnector.getConnector();
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MedlemMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
     
     public void DisciplinUpdate(String disciplin, int id, int nummer, String db){
        String sql = "UPDATE " + db + " SET " + disciplin + " = " + nummer + " WHERE id = " + id;
        try {
            Connection con = DatabaseConnector.getConnector();
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.executeUpdate();
            
             } catch (SQLException ex) {
            Logger.getLogger(MedlemMapper.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
     
     public void SearchDiscipline(String disciplin, String db){
        String sql = "SELECT " + disciplin + " from " + db + " ORDER BY " + disciplin + " desc LIMIT 5";
        try {
            Connection con = DatabaseConnector.getConnector();
            PreparedStatement ps = con.prepareStatement(sql);            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
                System.out.println(rs.getInt(disciplin));
            
             } catch (SQLException ex) {
            Logger.getLogger(MedlemMapper.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }  
}
