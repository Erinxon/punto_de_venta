package Ventas;

import java.text.DecimalFormat;

public class Productos {
    
    private final int idProducto;
    private final String nombreProducto;
    private final int cantidadProducto;
    private final double precioProducto;
    private final double total;

    public Productos(int idProducto,String nombreProducto,int cantidadProducto,double precioProducto,double total){
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.total = total;
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public double getTotal() {
        DecimalFormat formatter;
        if(this.total - (int)this.total > 0.0)
            formatter = new DecimalFormat("0.00");
        else{
            formatter = new DecimalFormat("0");
        }
            
        return Double.valueOf(formatter.format(this.total));
        
    }
    
    
}
