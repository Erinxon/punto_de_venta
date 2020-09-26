package Configuracion;

import ConexionJDBC.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionCategorias extends javax.swing.JDialog {

    private int idCategoria;
    private  int xx,xy;
    
    private ResultSet result;
    private DefaultTableModel modelo;
    
    public GestionCategorias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Gestion Categorias");
        datos();
    }

    private void datos(){
        try {

            modelo = (DefaultTableModel) tableCategorias.getModel();
            modelo.setRowCount(0);
            tableCategorias.setRowHeight(50);

            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            if(this.textBusqueda.getText().equals("")){
                result = instrucion.executeQuery("select * from categoriaProductos");
            }else{          
                result = instrucion.executeQuery("select * from categoriaProductos\n" +
                "where nombreCategoria like '"+this.textBusqueda.getText()+"%'");
            }
            
                 

            while (result.next()) {
                String[] categorias = new String[2];
                categorias[0] = String.valueOf(result.getInt(1));
                categorias[1] = result.getString(2);                
                modelo.addRow(categorias);
                tableCategorias.setModel(modelo);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado.." + e.toString());
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEditar = new RSMaterialComponent.RSButtonMaterialIconOne();
        textBusqueda = new RSMaterialComponent.RSTextFieldTwo();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableCategorias = new RSMaterialComponent.RSTableMetroCustom();
        btnUpdate = new RSMaterialComponent.RSButtonMaterialIconOne();

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

        btnEditar.setText(" Editar Categoria");
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        textBusqueda.setBorderColor(new java.awt.Color(255, 255, 255));
        textBusqueda.setPhColor(new java.awt.Color(0, 0, 0));
        textBusqueda.setPlaceholder(" Buscar por nombre de categoria   ");
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

        tableCategorias.setBackground(new java.awt.Color(0, 0, 0));
        tableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Categoria"
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
        tableCategorias.setBackgoundHead(new java.awt.Color(80, 0, 202));
        tableCategorias.setBackgoundHover(null);
        tableCategorias.setBorderHead(null);
        tableCategorias.setBorderRows(null);
        tableCategorias.setColorSecondary(new java.awt.Color(255, 255, 255));
        tableCategorias.setDropMode(javax.swing.DropMode.ON);
        tableCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCategoriasMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tableCategorias);
        if (tableCategorias.getColumnModel().getColumnCount() > 0) {
            tableCategorias.getColumnModel().getColumn(0).setResizable(false);
            tableCategorias.getColumnModel().getColumn(1).setResizable(false);
        }

        btnUpdate.setText("Actualizar datos");
        btnUpdate.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane9)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if(this.idCategoria == 0){
            JOptionPane.showMessageDialog(null, "Primero debes selecionar una fila", "Error: Usuario no selecionado", JOptionPane.ERROR_MESSAGE);
        }else{
            EditarCategorias editarCategorias  = new EditarCategorias(null,true);
            editarCategorias.datos(this.idCategoria);
            editarCategorias.setVisible(true);
            this.idCategoria = 0;
            datos();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void textBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBusquedaActionPerformed

    }//GEN-LAST:event_textBusquedaActionPerformed

    private void textBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBusquedaKeyReleased
        this.datos();
    }//GEN-LAST:event_textBusquedaKeyReleased

    private void textBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBusquedaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textBusquedaKeyTyped

    private void tableCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoriasMouseClicked
        int seleccion = tableCategorias.getSelectedRow();
        this.idCategoria = Integer.parseInt(tableCategorias.getValueAt(seleccion, 0).toString());
    }//GEN-LAST:event_tableCategoriasMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        datos();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane9;
    private RSMaterialComponent.RSTableMetroCustom tableCategorias;
    private RSMaterialComponent.RSTextFieldTwo textBusqueda;
    // End of variables declaration//GEN-END:variables
}
