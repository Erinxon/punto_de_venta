package ConexionJDBC;
import Alertas.ErrorBD;
import java.sql.*;

public final class Conexion {
    
    private Connection conexion;
      
    private static Conexion Instance;
    
    private Conexion(){
       
    }  
       
    public Connection getConexion(){   
                    
        String conexionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Ventas;";
        
        final String USUARIO_SQL_SERVER = "Java"; 
        
        final String PASSWORD = "123456";
        
        try{         
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cone = DriverManager.getConnection(conexionUrl,USUARIO_SQL_SERVER,PASSWORD);
            
            conexion = cone;
                      
        }catch(ClassNotFoundException | SQLException e){
            ErrorBD error = new ErrorBD(null, true);
            error.setVisible(true);
            
        }
        return conexion;
    }
    
    public static Conexion getInstance(){
        if(Instance == null){ 
            Instance = new Conexion();
        }
        
        return Instance;
    }
   

  
}
