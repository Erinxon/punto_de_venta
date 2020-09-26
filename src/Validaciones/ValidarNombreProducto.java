package Validaciones;

import ConexionJDBC.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ValidarNombreProducto {
    
    private boolean validar;
    public ValidarNombreProducto(){
        
    }
    
    public boolean validarNombre(String nombre){
        try{
            Conexion cone = Conexion.getInstance();    
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();
            
            ResultSet result;
            result = instrucion.executeQuery("select nombreProducto from productos\n" +
            "where nombreProducto = '"+nombre+"'");   
                
            this.validar = result.next();
                    
            instrucion.close();
            result.close();
            instrucion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
        
        return this.validar;
    }
    
    
}
