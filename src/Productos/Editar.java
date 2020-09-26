package Productos;

import ConexionJDBC.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Editar extends javax.swing.JDialog {

    private int idProducto;
    private int xx, xy;

    private int idProveedor;
    private int idCategoria;

    private ResultSet result;
    private DefaultTableModel modelo;

    public Editar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        proveedores();
        categorias();
    }

    public void datos(int idProducto) {
        try {
            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            result = instrucion.executeQuery("select * from productos\n"
                    + "where idProducto = '" + idProducto + "'");

            while (result.next()) {
                this.idProducto = result.getInt(1);
                this.textNombre.setText(result.getString(2));
                this.idCategoria = result.getInt(3);
                this.idProveedor = result.getInt(4);          
                this.TextCantidad.setText(String.valueOf(result.getInt(5)));
                this.textPrecio.setText(String.valueOf(result.getFloat(6)));
                

            }

            instrucion.close();
            result.close();
            instrucion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
    }

    private void editarProductos(String name, int stock, float precio, int idcategoria, int idproveedor) {
        try {
            Conexion cone = Conexion.getInstance();

            CallableStatement editar = cone.getConexion().prepareCall("{CALL editarProductos(?,?,?,?,?,?)}");

            editar.setInt(1, this.idProducto);
            editar.setString(2, name);
            editar.setInt(3, stock);
            editar.setFloat(4, precio);
            editar.setInt(5, idcategoria);
            editar.setInt(6, idproveedor);

            editar.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void categorias() {
        try {
            modelo = (DefaultTableModel) tableCategoria.getModel();
            modelo.setRowCount(0);

            tableCategoria.setRowHeight(50);

            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            result = instrucion.executeQuery("select * from categoriaProductos");

            while (result.next()) {
                String[] categoria = new String[2];
                categoria[0] = String.valueOf(result.getInt(1));
                categoria[1] = result.getString(2);
                modelo.addRow(categoria);
                tableCategoria.setModel(modelo);

            }

            instrucion.close();
            result.close();
            instrucion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }

    }

    private void proveedores() {
        try {
            modelo = (DefaultTableModel) tableProveedore.getModel();
            modelo.setRowCount(0);

            tableProveedore.setRowHeight(50);
            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            result = instrucion.executeQuery("select * from proveedores");

            while (result.next()) {
                String[] proveedor = new String[2];
                proveedor[0] = String.valueOf(result.getInt("idProveedor"));
                proveedor[1] = result.getString("nombreCompania");
                modelo.addRow(proveedor);
                tableProveedore.setModel(modelo);

            }

            instrucion.close();
            result.close();
            instrucion.close();
        } catch (SQLException e) {
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
        btnSalir = new RSMaterialComponent.RSButtonMaterialOne();
        btnAgregar = new RSMaterialComponent.RSButtonMaterialOne();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableProveedore = new RSMaterialComponent.RSTableMetroCustom();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableCategoria = new RSMaterialComponent.RSTableMetroCustom();
        btnLimpiar = new RSMaterialComponent.RSButtonMaterialOne();

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

        textPrecio.setPlaceholder("Precio");

        textNombre.setPlaceholder("Nombre del producto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar Productos");

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0, 0, 255));
        btnAgregar.setText("Guardar");
        btnAgregar.setBackgroundHover(new java.awt.Color(0, 0, 255));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selecione un proveedor");
        jLabel3.setRequestFocusEnabled(false);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecione una categoria");
        jLabel2.setRequestFocusEnabled(false);

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

        btnLimpiar.setBackground(new java.awt.Color(0, 0, 255));
        btnLimpiar.setText("Limpiar Datos");
        btnLimpiar.setBackgroundHover(new java.awt.Color(0, 0, 255));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(220, 220, 220))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(TextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 933, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = this.textNombre.getText();
        String stock = this.TextCantidad.getText();
        String precio = this.textPrecio.getText();

        if (!nombre.equals("") && !stock.equals("") && !precio.equals("")) {

            editarProductos(nombre, Integer.parseInt(stock), Float.parseFloat(precio), this.idCategoria, this.idProveedor);
            JOptionPane.showMessageDialog(null, "Producto editado correctamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            

        } else {
            JOptionPane.showMessageDialog(null, "Parece que hay algun campo vacio"
                    + "\nEstos campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
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

    private void tableProveedoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedoreMouseClicked
        int seleccion = tableProveedore.getSelectedRow();
        this.idProveedor = Integer.parseInt(tableProveedore.getValueAt(seleccion, 0).toString());
    }//GEN-LAST:event_tableProveedoreMouseClicked

    private void tableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoriaMouseClicked
        int seleccion = tableCategoria.getSelectedRow();
        this.idCategoria = Integer.parseInt(tableCategoria.getValueAt(seleccion, 0).toString());
    }//GEN-LAST:event_tableCategoriaMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.idCategoria = 0;
        this.idProveedor = 0;
        this.TextCantidad.setText("");
        this.textPrecio.setText("");
        this.categorias();
        this.proveedores();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSTextFieldMaterial TextCantidad;
    private RSMaterialComponent.RSButtonMaterialOne btnAgregar;
    private RSMaterialComponent.RSButtonMaterialOne btnLimpiar;
    private RSMaterialComponent.RSButtonMaterialOne btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel panel;
    private RSMaterialComponent.RSTableMetroCustom tableCategoria;
    private RSMaterialComponent.RSTableMetroCustom tableProveedore;
    private RSMaterialComponent.RSTextFieldMaterial textNombre;
    private RSMaterialComponent.RSTextFieldMaterial textPrecio;
    // End of variables declaration//GEN-END:variables
}
