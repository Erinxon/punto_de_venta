package Login;

import ConexionJDBC.Conexion;
import Home.Home;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private int xx, xy;

    private String usuario;
    private String password;

    private boolean validarUsuario;
    private boolean validarSesion;
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Img/Iconoo.png")).getImage());
        
    }
    
    public boolean validarSesion(String usuario, String pass){
        try{
            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();
            
            ResultSet result;
            result = instrucion.executeQuery("select * from Usuarios where usuario = '"+usuario+"' and pass = '"+pass+"'");   
            
            this.validarSesion = result.next();
            
            instrucion.close();
            result.close();
            instrucion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage());
            
        }
        
        return this.validarSesion;
        
    }
    
    public boolean validarUsuario(String usuario){
        try{
            Conexion cone = Conexion.getInstance();     
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();
            
            ResultSet result;
            result = instrucion.executeQuery("select * from Usuarios where usuario = '"+usuario+"' ");   
            
            this.validarUsuario = result.next();
            
            instrucion.close();
            result.close();
            instrucion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage());
        }
        
        return this.validarUsuario;
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnInicarSesion = new newscomponents.RSButtonFlat_new();
        cerrar1 = new javax.swing.JButton();
        textUsuario = new RSMaterialComponent.RSTextFieldMaterialIcon();
        jEImagePanel1 = new LIB.JEImagePanel();
        textPass = new RSMaterialComponent.RSPasswordMaterialIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        btnInicarSesion.setBackground(new java.awt.Color(125, 0, 229));
        btnInicarSesion.setText("Entrar");
        btnInicarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicarSesionActionPerformed(evt);
            }
        });

        cerrar1.setBackground(new java.awt.Color(51, 51, 51));
        cerrar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cerrar1.setForeground(new java.awt.Color(255, 255, 255));
        cerrar1.setText("X");
        cerrar1.setToolTipText("");
        cerrar1.setBorder(null);
        cerrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar1.setFocusPainted(false);
        cerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrar1MouseExited(evt);
            }
        });
        cerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar1ActionPerformed(evt);
            }
        });

        textUsuario.setColorIcon(new java.awt.Color(125, 0, 229));
        textUsuario.setColorMaterial(new java.awt.Color(125, 0, 229));
        textUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        textUsuario.setPlaceholder("Usuario");

        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iniciar-sesion.png"))); // NOI18N

        javax.swing.GroupLayout jEImagePanel1Layout = new javax.swing.GroupLayout(jEImagePanel1);
        jEImagePanel1.setLayout(jEImagePanel1Layout);
        jEImagePanel1Layout.setHorizontalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jEImagePanel1Layout.setVerticalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        textPass.setColorIcon(new java.awt.Color(125, 0, 229));
        textPass.setColorMaterial(new java.awt.Color(125, 0, 229));
        textPass.setPlaceholder("Contraseña");
        textPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPassKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(cerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jEImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(textPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnInicarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jEImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(textPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnInicarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private  void inciar(){
        try {
            this.usuario = this.textUsuario.getText();
            this.password = this.textPass.getText();
           
            if (!this.usuario.equals("") && !this.password.equals("")) {
                if (validarUsuario(usuario)) {
                    if (validarSesion(usuario, password)) {
                        Home home = new Home();
                        home.reportesInicio();
                        home.obtenerIdUsuario(this.usuario);
                        home.setVisible(true);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ese usuario no existe en nuestra base de datos"
                            + "\nPor favor intente con otro..", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Parece que uno o todos los campos estan vacios"
                        + "\nEstos campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage());
        }
    }
    
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MouseMoved

    private void btnInicarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicarSesionActionPerformed

        inciar();

    }//GEN-LAST:event_btnInicarSesionActionPerformed

    private void cerrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar1MouseEntered
        cerrar1.setBackground(Color.red);
    }//GEN-LAST:event_cerrar1MouseEntered

    private void cerrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar1MouseExited
        cerrar1.setBackground(new Color(51, 51, 51));

    }//GEN-LAST:event_cerrar1MouseExited

    private void cerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cerrar1ActionPerformed

    private void textPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            inciar();
        }

    }//GEN-LAST:event_textPassKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonFlat_new btnInicarSesion;
    private javax.swing.JButton cerrar1;
    private LIB.JEImagePanel jEImagePanel1;
    private javax.swing.JPanel jPanel1;
    private RSMaterialComponent.RSPasswordMaterialIcon textPass;
    private RSMaterialComponent.RSTextFieldMaterialIcon textUsuario;
    // End of variables declaration//GEN-END:variables
}
