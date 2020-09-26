package Ventas;

import ConexionJDBC.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AgregarVenta extends javax.swing.JDialog {

    private int xx, xy;
    private DefaultTableModel modelo;

    private int idCliente = 0;
    private String cliente = "";
    private int idUsuario;
    private int idProducto = 0;

    ArrayList<Integer> ListaIDproducto = new ArrayList<>();
    ArrayList<Productos> productosAgregados = new ArrayList<>();

    private double precioTotal;
    
    private int idVenta;
    private int stockAnterior;
    public AgregarVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Realizar Ventas");
        this.setLocationRelativeTo(null);
        mostrarClientes();
        mostrarProductos();
                           
    }

   
    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }

   
    private void mostrarProductos() {
        try {
            
            
            modelo = (DefaultTableModel) tablaProductos.getModel();
            modelo.setRowCount(0);
            tablaProductos.setRowHeight(40);
            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            ResultSet result;

         
            
            if (textBusqueda.getText().equals("")) {
                result = instrucion.executeQuery("select * from productos where stock >0");
            } else{
                result = instrucion.executeQuery("select * from productos  as p \n" +
                "inner join categoriaProductos as c on c.idCategoria = p.idCategoria\n" +
                "where p.nombreProducto like '"+textBusqueda.getText()+"%' and stock >0");
            }
            

            while (result.next()) {
                
                String[] productos = new String[4];
                productos[0] = String.valueOf(result.getInt("idProducto"));
                productos[1] = result.getString("nombreProducto");
                productos[2] = String.valueOf(result.getDouble("precio"));
                productos[3] = String.valueOf(result.getInt("stock"));
                modelo.addRow(productos);
                tablaProductos.setModel(modelo);

            }

            instrucion.close();
            result.close();
            instrucion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
    }

    private void mostrarClientes() {
        try {
            modelo = (DefaultTableModel) tablaClientes.getModel();
            modelo.setRowCount(0);
            tablaClientes.setRowHeight(40);
            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            ResultSet result;
            if(this.textBusquedaCliente.getText().equals("")){
                result = instrucion.executeQuery("select idClientes,nombre from clientes");
            }else{
                result = instrucion.executeQuery("select idClientes,nombre from clientes\n" +
                "where nombre like '"+this.textBusquedaCliente.getText()+"%'");
            }
            
            while (result.next()) {
                String[] clientes = new String[2];
                clientes[0] = String.valueOf(result.getInt("idClientes"));
                clientes[1] = result.getString("nombre");
                modelo.addRow(clientes);
                tablaClientes.setModel(modelo);

            }

            instrucion.close();
            result.close();
            instrucion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
    }

    private void obtenerNombreCliente() {
        try {
            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            ResultSet result;
            result = instrucion.executeQuery("select nombre,apellido from clientes where idClientes = '" + this.idCliente + "'");

            while (result.next()) {
                this.cliente = result.getString("nombre");
                this.textClienteFinal.setText("Cliente: " + result.getString("nombre") + " " + result.getString("apellido"));

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

        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new newscomponents.RSButtonFlat_new();
        textCantidad = new RSMaterialComponent.RSTextFieldTwo();
        textTotal = new javax.swing.JLabel();
        btnConfirmar = new newscomponents.RSButtonFlat_new();
        btnAgregarCliente = new newscomponents.RSButtonFlat_new();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaVenta = new RSMaterialComponent.RSTableMetroCustom();
        textClienteFinal = new javax.swing.JLabel();
        textBusqueda = new RSMaterialComponent.RSTextFieldTwo();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaProductos = new RSMaterialComponent.RSTableMetroCustom();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaClientes = new RSMaterialComponent.RSTableMetroCustom();
        btnAgregarProducto = new newscomponents.RSButtonFlat_new();
        textBusquedaCliente = new RSMaterialComponent.RSTextFieldTwo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        textCantidad.setBorderColor(new java.awt.Color(255, 255, 255));
        textCantidad.setPhColor(new java.awt.Color(0, 0, 0));
        textCantidad.setPlaceholder(" Cantidad");
        textCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCantidadActionPerformed(evt);
            }
        });
        textCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCantidadKeyTyped(evt);
            }
        });

        textTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textTotal.setForeground(new java.awt.Color(255, 255, 255));
        textTotal.setText("Total $:");

        btnConfirmar.setText("Concretar Venta");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnAgregarCliente.setText("Agregar Cliente");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        jScrollPane4.setBorder(null);

        tablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Cantidad", "Precio unidad", "Precio total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVenta.setBackgoundHead(new java.awt.Color(80, 0, 202));
        tablaVenta.setBackgoundHover(null);
        tablaVenta.setBorderHead(null);
        tablaVenta.setBorderRows(null);
        tablaVenta.setColorSecondary(new java.awt.Color(255, 255, 255));
        tablaVenta.setDropMode(javax.swing.DropMode.ON);
        tablaVenta.setRowSelectionAllowed(false);
        tablaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaVenta);
        if (tablaVenta.getColumnModel().getColumnCount() > 0) {
            tablaVenta.getColumnModel().getColumn(0).setResizable(false);
            tablaVenta.getColumnModel().getColumn(1).setResizable(false);
            tablaVenta.getColumnModel().getColumn(2).setResizable(false);
            tablaVenta.getColumnModel().getColumn(3).setResizable(false);
            tablaVenta.getColumnModel().getColumn(4).setResizable(false);
        }

        textClienteFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textClienteFinal.setForeground(new java.awt.Color(255, 255, 255));
        textClienteFinal.setText("Cliente:");

        textBusqueda.setBorderColor(new java.awt.Color(255, 255, 255));
        textBusqueda.setPhColor(new java.awt.Color(0, 0, 0));
        textBusqueda.setPlaceholder(" Buscar productos   ");
        textBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBusquedaActionPerformed(evt);
            }
        });
        textBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBusquedaKeyTyped(evt);
            }
        });

        jScrollPane5.setBorder(null);

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio", "Existencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setBackgoundHover(null);
        tablaProductos.setBorderHead(null);
        tablaProductos.setBorderRows(null);
        tablaProductos.setColorSecondary(new java.awt.Color(255, 255, 255));
        tablaProductos.setDropMode(javax.swing.DropMode.ON);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaProductos.getColumnModel().getColumn(1).setResizable(false);
            tablaProductos.getColumnModel().getColumn(2).setResizable(false);
            tablaProductos.getColumnModel().getColumn(3).setResizable(false);
        }

        jScrollPane6.setBorder(null);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Cliente"
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
        tablaClientes.setBackgoundHover(null);
        tablaClientes.setBorderHead(null);
        tablaClientes.setBorderRows(null);
        tablaClientes.setColorSecondary(new java.awt.Color(255, 255, 255));
        tablaClientes.setDropMode(javax.swing.DropMode.ON);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
        }

        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        textBusquedaCliente.setBorderColor(new java.awt.Color(255, 255, 255));
        textBusquedaCliente.setPhColor(new java.awt.Color(0, 0, 0));
        textBusquedaCliente.setPlaceholder("Buscar Cliente");
        textBusquedaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBusquedaClienteActionPerformed(evt);
            }
        });
        textBusquedaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBusquedaClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBusquedaClienteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textBusquedaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(textClienteFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textTotal))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void textCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCantidadKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_textCantidadKeyTyped

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        if (this.idCliente == 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecione un cliente!", "Error: Cliente no seleccionado", JOptionPane.ERROR_MESSAGE);
        } else {
            this.mostrarClientes();
            this.obtenerNombreCliente();
            this.tablaClientes.setEnabled(false);
            this.btnAgregarCliente.setEnabled(false);
        }

    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (productosAgregados.size() <= 0) {
            JOptionPane.showMessageDialog(null, "No has agregado ningun producto!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (this.cliente.equals("")) {
            JOptionPane.showMessageDialog(null, "No has seleccionado un cliente!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
            obtnenerIdVenta();
 
            Ventas venta = new Ventas(this.idUsuario, this.idCliente, (this.idVenta + 1));
            venta.obtnerListaProductos(productosAgregados);     
            venta.detalleVenta();
            
            JOptionPane.showMessageDialog(null, "Venta registrada con éxito!", "Venta registrada",
                    JOptionPane.INFORMATION_MESSAGE);
            mostrarProductos();
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void tablaVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaVentaMouseClicked

    private void textBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBusquedaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textBusquedaKeyTyped

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int seleccion = this.tablaProductos.getSelectedRow();
        this.idProducto = Integer.parseInt(tablaProductos.getValueAt(seleccion, 0).toString());
        this.stockAnterior = Integer.parseInt(tablaProductos.getValueAt(seleccion, 3).toString());


    }//GEN-LAST:event_tablaProductosMouseClicked

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        if (this.cliente.equals("")) {
            int seleccion = this.tablaClientes.getSelectedRow();
            this.idCliente = Integer.parseInt(tablaClientes.getValueAt(seleccion, 0).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Ya seleccionaste un cliente", "", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_tablaClientesMouseClicked

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        if (this.idProducto == 0) {
            JOptionPane.showMessageDialog(null, "Primero debes seleccionar un producto", "Error: Producto no seleccionado", JOptionPane.ERROR_MESSAGE);
        } else if (this.textCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Primero debes escribir la cantidad de producto que quieres", "", JOptionPane.ERROR_MESSAGE);
        } else if (ListaIDproducto.contains(this.idProducto)) {
            JOptionPane.showMessageDialog(null, "Ese producto ya esta agregado\nIntente con otro", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(Integer.parseInt(this.textCantidad.getText()) > this.stockAnterior){
            JOptionPane.showMessageDialog(null, "No hay suficiente Stock\n"+
                    "Stock del producto "+this.stockAnterior, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try {
                ListaIDproducto.add(this.idProducto); 

                int can = Integer.parseInt(this.textCantidad.getText());
                Conexion cone = Conexion.getInstance();
                Statement instrucion;
                instrucion = cone.getConexion().createStatement();

                ResultSet result;
                result = instrucion.executeQuery("select * from productos where idProducto in ('" + this.idProducto + "')");
                while (result.next()) {
                    Productos oProducto = new Productos(this.idProducto, result.getString(2), can, result.getFloat(6), result.getFloat(6) * can);
                    this.precioTotal += result.getFloat(6) * can;
                    productosAgregados.add(oProducto);

                }
                mostrarDatos();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
            }

        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        productosAgregados.clear();
        this.ListaIDproducto.clear();
        this.idCliente = 0;
        this.precioTotal = 0;
        this.textClienteFinal.setText("Cliente: ");
        this.mostrarDatos();
        this.mostrarClientes();


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void textBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBusquedaActionPerformed

    }//GEN-LAST:event_textBusquedaActionPerformed

    private void textBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBusquedaKeyReleased
        mostrarProductos();
    }//GEN-LAST:event_textBusquedaKeyReleased

    private void textBusquedaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBusquedaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBusquedaClienteActionPerformed

    private void textBusquedaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBusquedaClienteKeyReleased
        mostrarClientes();
    }//GEN-LAST:event_textBusquedaClienteKeyReleased

    private void textBusquedaClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBusquedaClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textBusquedaClienteKeyTyped

    private void textCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCantidadActionPerformed

    private void mostrarDatos() {
        modelo = (DefaultTableModel) tablaVenta.getModel();
        modelo.setRowCount(0);
        tablaVenta.setRowHeight(40);

        String matriz[][] = new String[productosAgregados.size()][5];

        for (int i = 0; i < productosAgregados.size(); i++) {
            matriz[i][0] = String.valueOf(productosAgregados.get(i).getIdProducto());
            matriz[i][1] = String.valueOf(productosAgregados.get(i).getNombreProducto());
            matriz[i][2] = String.valueOf(productosAgregados.get(i).getCantidadProducto());
            matriz[i][3] = String.valueOf(productosAgregados.get(i).getPrecioProducto());
            DecimalFormat form;
            if(this.precioTotal - (int)this.precioTotal > 0.0)
                form = new DecimalFormat("0.00");
            else{
                form = new DecimalFormat("0");
            }
            
            matriz[i][4] = String.valueOf(form.format(productosAgregados.get(i).getTotal()));

        }

        tablaVenta.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Id", "Nombre", "Cantidad", "Precio unidad", "Precio total"
                }
        ));
        
        DecimalFormat formatter;
        if(this.precioTotal - (int)this.precioTotal > 0.0)
            formatter = new DecimalFormat("0.00");
        else{
            formatter = new DecimalFormat("0");
        }

        this.textTotal.setText("Total $: " + String.valueOf(formatter.format(this.precioTotal)));
       

    }

    private void obtnenerIdVenta() {
        try {
            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            ResultSet result;
            result = instrucion.executeQuery("select idventa from ventas where idventa = (SELECT MAX(idventa) from ventas)");

            while (result.next()) {
                
                this.idVenta = result.getInt(1);
        
            }

            instrucion.close();
            result.close();
            instrucion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonFlat_new btnAgregarCliente;
    private newscomponents.RSButtonFlat_new btnAgregarProducto;
    private newscomponents.RSButtonFlat_new btnCancelar;
    private newscomponents.RSButtonFlat_new btnConfirmar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private RSMaterialComponent.RSTableMetroCustom tablaClientes;
    private RSMaterialComponent.RSTableMetroCustom tablaProductos;
    private RSMaterialComponent.RSTableMetroCustom tablaVenta;
    private RSMaterialComponent.RSTextFieldTwo textBusqueda;
    private RSMaterialComponent.RSTextFieldTwo textBusquedaCliente;
    private RSMaterialComponent.RSTextFieldTwo textCantidad;
    private javax.swing.JLabel textClienteFinal;
    private javax.swing.JLabel textTotal;
    // End of variables declaration//GEN-END:variables
}
