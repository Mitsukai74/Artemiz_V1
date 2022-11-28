
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Vista.vistaPrincipal;

public class Consultas {
    
    ConexionBD nuevaConexion = new ConexionBD();
    
    
    public boolean registrarParada(){
        
        PreparedStatement ps = null;
        Connection con = nuevaConexion.hacerConexion();
        
        String sql = "INSERT INTO controlparadas (causal,tiempo) VALUES (?,?)";
        try {
            ps=con.prepareStatement(sql);
            
        } catch (Exception e) {
        }
        
        
        return true;
        
    }
    
}
