
package Controlador;

import Modelo.ParadasClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {
    
    ConexionBD nuevaConexion = new ConexionBD();
    
    
    public boolean registrarParada(ParadasClass newParada){
        
        PreparedStatement ps = null;
        Connection con = nuevaConexion.hacerConexion();
        
        String sql = "INSERT INTO controlparadas (causal,tiempo) VALUES (?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, newParada.getCausal());
            ps.setString(2, newParada.getTiempo());
            
            ps.executeUpdate();
            
            try (ResultSet rs = ps.getGeneratedKeys()){
                while (rs.next()) {                    
                    newParada.setId(rs.getInt(1));
                    System.out.println("Parada registrada");
                }
                
            } catch (Exception e) {
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }      
        
        return true;        
    }
    
}
