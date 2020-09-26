package Productos;


import ConexionJDBC.Conexion;
import Validaciones.ValidarNombreProducto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Agregar extends javax.swing.JDialog {
   
    private String nombre;
    private String stock;
    private String precio;

    private int xx, xy;
    
    private int idProveedor;
    private int idCategoria;
    
    private ResultSet result;
    private DefaultTableModel modelo;
    
    public Agregar(){
    
    }
    public Agregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        proveedores();
        categorias();
                    
    }

    public void setIdProveedor(int idProveedor){
        this.idProveedor = idProveedor;
    }
    

    private void agregarProductos(String name,int stock,float precio){
        try{  
            Conexion cone = Conexion.getInstance();   
       
            
            CallableStatement registrarse = cone.getConexion().prepareCall("{CALL agregarProductos(?,?,?,?,?)}");
            
            registrarse.setString(1, name);
            registrarse.setInt(2, stock);   
            registrarse.setFloat(3, precio);
            registrarse.setInt(4, this.idCategoria);                   
            registrarse.setInt(5, this.idProveedor);

                
            registrarse.execute();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Ocurrio un error inesperado","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
   
    
    private void categorias(){
        try{
            modelo = (DefaultTableModel) tableCategoria.getModel();
            modelo.setRowCount(0);
            
            tableCategoria.setRowHeight(50);
            
            Conexion cone = Conexion.getInstance();      
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();
            
        
            result = instrucion.executeQuery("select * from categoriaProductos");   
                
            while(result.next()){
                String[] categoria = new String[2];
                categoria[0] = String.valueOf(result.getInt(1));
                categoria[1] = result.getString(2);
                modelo.addRow(categoria);
                tableCategoria.setModel(modelo);      
            
            }          
                    
            instrucion.close();
            result.close();
            instrucion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
        
        
    }
    private void proveedores(){
        try{
            modelo = (DefaultTableModel) tableProveedore.getModel();
            modelo.setRowCount(0);
            
            tableProveedore.setRowHeight(50);
            Conexion cone = Conexion.getInstance(); 
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();
            
          
            result = instrucion.executeQuery("select * from proveedores");   
                
            while(result.next()){
                String[] proveedor = new String[2];
                proveedor[0] = String.valueOf(result.getInt("idProveedor"));
                proveedor[1] = result.getString("nombreCompania");
                modelo.addRow(proveedor);
                tableProveedore.setModel(modelo);           
            
            }          
                    
            instrucion.close();
            result.close();
            instrucion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        TextCantidad = new RSMaterialComponent.RSTextFieldMaterial();
        textPrecio = new RSMaterialComponent.RSTextFieldMaterial();
        textNombre = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new RSMaterialComponent.RSButtonMaterialOne();
        btnCancelar1 = new RSMaterialComponent.RSButtonMaterialOne();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableCategoria = new RSMaterialComponent.RSTableMetroCustom();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableProveedore = new RSMaterialComponent.RSTableMetroCustom();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar1 = new RSMaterialComponent.RSButtonMaterialOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panel.setBackground(new java.awt.Color(51, 51, 51));
        panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelMouseMoved(evt);
            }
        });

        TextCantidad.setPlaceholder("Cantidad");
        TextCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextCantidadKeyTyped(evt);
            }
        });

        textPrecio.setPlaceholder("Precio");
        textPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPrecioKeyTyped(evt);
            }
        });

        textNombre.setPlaceholder("Nombre del producto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecione una categoria");
        jLabel1.setRequestFocusEnabled(false);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar1.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar1.setText("Salir");
        btnCancelar1.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        tableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCategoria.setBackgoundHead(new java.awt.Color(80, 0, 202));
        tableCategoria.setBackgoundHover(null);
        tableCategoria.setBorderHead(null);
        tableCategoria.setBorderRows(null);
        tableCategoria.setColorSecondary(new java.awt.Color(255, 255, 255));
        tableCategoria.setDropMode(javax.swing.DropMode.ON);
        tableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCategoriaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tableCategoria);
        if (tableCategoria.getColumnModel().getColumnCount() > 0) {
            tableCategoria.getColumnModel().getColumn(0).setResizable(false);
            tableCategoria.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Agregar productos");

        tableProveedore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Razon Social"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProveedore.setBackgoundHead(new java.awt.Color(80, 0, 202));
        tableProveedore.setBackgoundHover(null);
        tableProveedore.setBorderHead(null);
        tableProveedore.setBorderRows(null);
        tableProveedore.setColorSecondary(new java.awt.Color(255, 255, 255));
        tableProveedore.setDropMode(javax.swing.DropMode.ON);
        tableProveedore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProveedoreMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tableProveedore);
        if (tableProveedore.getColumnModel().getColumnCount() > 0) {
            tableProveedore.getColumnModel().getColumn(0).setResizable(false);
            tableProveedore.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selecione un proveedor");
        jLabel3.setRequestFocusEnabled(false);

        btnAgregar1.setText("Limpiar Datos");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(692, Short.MAX_VALUE)))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(TextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextCantidadKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_TextCantidadKeyTyped

    private void textPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPrecioKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<',' || car>'.')) evt.consume();
    }//GEN-LAST:event_textPrecioKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
        this.nombre = this.textNombre.getText();     
        this.stock = this.TextCantidad.getText();
        this.precio = this.textPrecio.getText();
              
        ValidarNombreProducto validar = new ValidarNombreProducto();
        
        
        if(!this.nombre.equals("") && !this.stock.equals("") && !this.precio.equals("")){
            if(validar.validarNombre(this.nombre)){
                JOptionPane.showMessageDialog(null,this.nombre + " ya esta agregado en la base de datos"+
                        "\nIntente con otro nombre","Error",JOptionPane.ERROR_MESSAGE);
            }else if(this.idProveedor == 0){
                JOptionPane.showMessageDialog(null, "Primero debes selecionar una fila", "Error: Proveedor no selecionado", JOptionPane.ERROR_MESSAGE);
            }else if(this.idCategoria == 0){
                JOptionPane.showMessageDialog(null, "Primero debes selecionar una fila", "Error: Categoria no selecionada", JOptionPane.ERROR_MESSAGE);
            }
            else{              
                agregarProductos(this.nombre,Integer.parseInt(this.stock),Float.parseFloat(this.precio));
                JOptionPane.showMessageDialog(null,"Producto agregado correctamente","Registro Exitoso",JOptionPane.INFORMATION_MESSAGE); 
                this.idCategoria = 0;
                this.idProveedor = 0;
                
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Parece que hay algun campo vacio"+
                    "\nEstos campos son requeridos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_panelMouseDragged

    private void panelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseMoved
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_panelMouseMoved

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void tableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoriaMouseClicked
        int seleccion = tableCategoria.getSelectedRow();
        this.idCategoria = Integer.parseInt(tableCategoria.getValueAt(seleccion, 0).toString());
    }//GEN-LAST:event_tableCategoriaMouseClicked

    private void tableProveedoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedoreMouseClicked
        int seleccion = tableProveedore.getSelectedRow();
        this.idProveedor = Integer.parseInt(tableProveedore.getValueAt(seleccion, 0).toString());
    }//GEN-LAST:event_tableProveedoreMouseClicked

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        this.categorias();
        this.proveedores();
        this.idCategoria = 0;
        this.idProveedor = 0;
        this.textNombre.setText("");
        this.textPrecio.setText("");
        this.TextCantidad.setText("");
    }//GEN-LAST:event_btnAgregar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSTextFieldMaterial TextCantidad;
    private RSMaterialComponent.RSButtonMaterialOne btnAgregar;
    private RSMaterialComponent.RSButtonMaterialOne btnAgregar1;
    private RSMaterialComponent.RSButtonMaterialOne btnCancelar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel panel;
    private newscomponents.RSPanelOpacity rSPanelOpacity1;
    private newscomponents.RSPanelOpacity rSPanelOpacity2;
    private newscomponents.RSPanelOpacity rSPanelOpacity3;
    private newscomponents.RSPanelOpacity rSPanelOpacity4;
    private newscomponents.RSPanelOpacity rSPanelOpacity5;
    private RSMaterialComponent.RSTableMetroCustom tableCategoria;
    private RSMaterialComponent.RSTableMetroCustom tableProveedore;
    private RSMaterialComponent.RSTextFieldMaterial textNombre;
    private RSMaterialComponent.RSTextFieldMaterial textPrecio;
    // End of variables declaration//GEN-END:variables
}

