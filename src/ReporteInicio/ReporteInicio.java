package ReporteInicio;

import ConexionJDBC.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class ReporteInicio {
    private final String SQL_IVENTARIO = "select sum(stock *precio) as 'Costo general',sum(stock) as 'stock' from productos";
    private long totalIventario;
    private int productoStock;
    
    private final String SQL_CLIENTES = "select count(*) as 'Cantidad de clientes' from clientes";
    private int cantidadClientes;
    
    private final String SQL_VENTAS = "select sum(dv.cantidad * p.precio) as 'Total ventas' from ventas as v\n" +
    "inner join detalle_ventas as dv on dv.idventa = v.idventa\n" +
    "inner join productos as p on p.idProducto = dv.idProducto\n" +
    "where year(v.fecha) = year(GETDATE())";
    private double ventas;
      
    
    private final String SQL_PROVEEDORES = "select count(*) from proveedores";
    private int totalProveedores;
    
    public ReporteInicio(){
        ReporteIventario();
        reporteCliente();
        reporteVentas();
        reporteProveedores();

    }
    
    private void ReporteIventario(){
        try{
            Conexion cone = Conexion.getInstance(); 
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();
            
            ResultSet result;
            result = instrucion.executeQuery(this.SQL_IVENTARIO);   
                
            while(result.next()){
                this.totalIventario = result.getLong("Costo general");
                this.productoStock = result.getInt("stock");
            }
            
            instrucion.close();
            result.close();
            instrucion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
        
    }
    
    public String getTotalIventario() //Got here 6.743240136E7 or something..
    {
        DecimalFormat formatter;
        if(this.totalIventario - (int)this.totalIventario > 0.0)
            formatter = new DecimalFormat("0.00");
        else
            formatter = new DecimalFormat("0");

        return formatter.format(this.totalIventario);
    }
    
    public int getProductoStock(){
        return this.productoStock;
    }
    
    private void reporteCliente(){
         try{
            Conexion cone = Conexion.getInstance();   
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();
            
            ResultSet result;
            result = instrucion.executeQuery(this.SQL_CLIENTES);   
                
            while(result.next()){
                this.cantidadClientes = result.getInt("Cantidad de clientes");
                
            }
            
            instrucion.close();
            result.close();
            instrucion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
    }
      
    public int getCantidadClientes(){
        return this.cantidadClientes;
    }
    
    private void reporteVentas(){
        try{
            Conexion cone = Conexion.getInstance();       
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();
            
            ResultSet result;
            result = instrucion.executeQuery(this.SQL_VENTAS);   
                
            while(result.next()){
                this.ventas = result.getLong("Total ventas");
                
            }
            
            instrucion.close();
            result.close();
            instrucion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
    }
    
    public String getVentas(){
        
        DecimalFormat formatter;
        if(this.ventas - (int)this.ventas > 0.0)
            formatter = new DecimalFormat("0.00");
        else{
            formatter = new DecimalFormat("0");
        }
            
        return formatter.format(this.ventas);
        
      
    }
   
    
    private void reporteProveedores(){
        try{
            Conexion cone = Conexion.getInstance();          
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();
            
            ResultSet result;
            result = instrucion.executeQuery(this.SQL_PROVEEDORES);   
                
            while(result.next()){
                this.totalProveedores = result.getInt(1);
                
            }
            
            instrucion.close();
            result.close();
            instrucion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
    
    }
    
    public int cantidadProveedores(){
        return this.totalProveedores;
    }
    
    
}
