package Clientes;

import ConexionJDBC.Conexion;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cliente {
    
    public Cliente(){
    
    }
    
    public void agregarClinete(String nombre, String apellido, String direccion){
        try{  
            Conexion cone = Conexion.getInstance();   
       
            CallableStatement agregar = cone.getConexion().prepareCall("{CALL agregarClientes(?,?,?)}");
            
            agregar.setString(1, nombre);
            agregar.setString(2, apellido);
            agregar.setString(3, direccion);           
                
            agregar.execute();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Ocurrio un error inesperado","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarCliente(int idCliente,String nombre, String apellido, String direccion){
        try{  
            Conexion cone = Conexion.getInstance();   
       
            CallableStatement editar = cone.getConexion().prepareCall("{CALL editarClientes(?,?,?,?)}");
            
            editar.setInt(1, idCliente);
            editar.setString(2, nombre);
            editar.setString(3, apellido);
            editar.setString(4, direccion);           
                
            editar.execute();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Ocurrio un error inesperado","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
