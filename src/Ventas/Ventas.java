package Ventas;


import ConexionJDBC.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Ventas {
    private final int idUsuario;
    private final int idCliente;
    private final int idVenta;


    private final ArrayList<Productos> productos = new ArrayList<>();

    public Ventas(int idUsuario, int idCliente, int idVenta) {
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.idVenta = idVenta;
        realizarVenta();
            
    }

    public void obtnerListaProductos(ArrayList<Productos> produ) {
        productos.addAll(produ);
       
  
    }
    
     
    private void realizarVenta(){      
        try {
            Conexion cone = Conexion.getInstance();
            
            PreparedStatement instrucion = cone.getConexion().prepareStatement("insert into ventas values('"+this.idVenta+"',convert(date,GETDATE()),'"+this.idCliente+"','"+this.idUsuario+"')");        
            instrucion.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
        
    }
     
    public void detalleVenta(){
        try{  
            Conexion cone = Conexion.getInstance();  
       
            CallableStatement calleVenta;
            calleVenta = cone.getConexion().prepareCall("{CALL agregarVentaProducto(?,?,?,?)}");
            
            for(int i=0;i<productos.size();i++){
                calleVenta.setInt(1, this.idVenta);
                calleVenta.setInt(2, productos.get(i).getIdProducto()); 
                calleVenta.setInt(3, productos.get(i).getCantidadProducto());             
                calleVenta.setDouble(4, productos.get(i).getPrecioProducto());
                
                calleVenta.addBatch();
            
            }
            calleVenta.executeBatch();
           
                     
            calleVenta.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Ocurrio un error al registrar los datos."+ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }

}
