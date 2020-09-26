package Home;

import Alertas.PermisoDenegado;
import Clientes.AgregarClientes;
import Clientes.EditarClientes;
import ConexionJDBC.Conexion;
import Configuracion.AddCategorias;
import Configuracion.AddUsuarios;
import Configuracion.GestionCategorias;
import Configuracion.GestionUsuarios;
import Productos.Agregar;
import Productos.Editar;
import ReporteInicio.ReporteInicio;
import Ventas.AgregarVenta;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import Proveedores.AgregarProveedor;
import Proveedores.EditarProveedores;
import javax.swing.ImageIcon;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

public class Home extends javax.swing.JFrame {

    private int idProducto = 0;
    private ResultSet result;
    private DefaultTableModel modelo;

    private int idUsuario;
    private int idVenta;
    private int idCliente;
    private int idProveedor;

    private String tipoUsuario;

    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Img/Iconoo.png")).getImage());
     
        this.setTitle("Punto de venta");
        this.btnIncio.setBackground(new Color(39, 48, 54));
        btnIncio.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
        mostrarOcultarJpanel(true, false, false, false, false, false, false, false);

    }

    public void obtenerIdUsuario(String usuario) {
        try {
            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            ResultSet r = instrucion.executeQuery("select id_usuario,rol from Usuarios where usuario = '" + usuario + "'");

            while (r.next()) {
                this.idUsuario = r.getInt(1);
                this.tipoUsuario = r.getString(2);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado! " + e.toString());
        }
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        btnIncio = new newscomponents.RSPanelOpacity();
        jLabel1 = new javax.swing.JLabel();
        btnProducto = new newscomponents.RSPanelOpacity();
        jLabel2 = new javax.swing.JLabel();
        btnVentas = new newscomponents.RSPanelOpacity();
        jLabel3 = new javax.swing.JLabel();
        btnClientes = new newscomponents.RSPanelOpacity();
        jLabel5 = new javax.swing.JLabel();
        btnProveedores = new newscomponents.RSPanelOpacity();
        jLabel6 = new javax.swing.JLabel();
        btnReportes = new newscomponents.RSPanelOpacity();
        jLabel7 = new javax.swing.JLabel();
        btnConfiguracion = new newscomponents.RSPanelOpacity();
        jLabel10 = new javax.swing.JLabel();
        PanelInicio = new javax.swing.JPanel();
        rSPanelOpacity1 = new newscomponents.RSPanelOpacity();
        jLabel9 = new javax.swing.JLabel();
        rSPanelOpacity3 = new newscomponents.RSPanelOpacity();
        textTotalVentas = new javax.swing.JLabel();
        labelVentaYearActual = new javax.swing.JLabel();
        rSPanelOpacity4 = new newscomponents.RSPanelOpacity();
        jLabel12 = new javax.swing.JLabel();
        rSPanelOpacity5 = new newscomponents.RSPanelOpacity();
        jLabel13 = new javax.swing.JLabel();
        textCantidadClientes = new javax.swing.JLabel();
        rSPanelOpacity8 = new newscomponents.RSPanelOpacity();
        jLabel16 = new javax.swing.JLabel();
        rSPanelOpacity10 = new newscomponents.RSPanelOpacity();
        textStock = new javax.swing.JLabel();
        rSPanelOpacity9 = new newscomponents.RSPanelOpacity();
        jLabel17 = new javax.swing.JLabel();
        textDineroIventario = new javax.swing.JLabel();
        lebelReporteYearActual = new javax.swing.JLabel();
        rSPanelOpacity12 = new newscomponents.RSPanelOpacity();
        jLabel18 = new javax.swing.JLabel();
        rSPanelOpacity13 = new newscomponents.RSPanelOpacity();
        jLabel20 = new javax.swing.JLabel();
        textCantidadProveedores = new javax.swing.JLabel();
        PanelProductos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProductos = new RSMaterialComponent.RSTableMetroCustom();
        textBuscarProductos = new RSMaterialComponent.RSTextFieldOne();
        btnAgregarProductos = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnEditarProductos = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnUpdateTabla = new RSMaterialComponent.RSButtonMaterialIconTwo();
        PanelVentas = new javax.swing.JPanel();
        textBuscarProductoVentas = new RSMaterialComponent.RSTextFieldOne();
        btnAgregarVenta = new RSMaterialComponent.RSButtonMaterialIconTwo();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableVentas = new RSMaterialComponent.RSTableMetroCustom();
        btnImprimirFactura = new RSMaterialComponent.RSButtonMaterialIconTwo();
        PanelClientes = new javax.swing.JPanel();
        textBuscarClientes = new RSMaterialComponent.RSTextFieldOne();
        btnEditarClientes = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnAgregarClientes = new RSMaterialComponent.RSButtonMaterialIconTwo();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableClientes = new RSMaterialComponent.RSTableMetroCustom();
        PanelProveedores = new javax.swing.JPanel();
        textBuscarProveedores = new RSMaterialComponent.RSTextFieldOne();
        btnAgregarProductos4 = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnAgregarProductos3 = new RSMaterialComponent.RSButtonMaterialIconTwo();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableProveedores = new RSMaterialComponent.RSTableMetroCustom();
        PanelReportes = new javax.swing.JPanel();
        btnReporteIventario = new newscomponents.RSPanelOpacity();
        jLabel11 = new javax.swing.JLabel();
        btnProductosMasVendidos = new newscomponents.RSPanelOpacity();
        jLabel4 = new javax.swing.JLabel();
        btnReporteVentas = new newscomponents.RSPanelOpacity();
        jLabel8 = new javax.swing.JLabel();
        PanelConfiguracion = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        rSPanelOpacity6 = new newscomponents.RSPanelOpacity();
        btnAddUsurios = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGestionarUsuarios = new RSMaterialComponent.RSButtonMaterialIconOne();
        rSPanelOpacity7 = new newscomponents.RSPanelOpacity();
        btnGestionCategorias = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAddCategorias = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(80, 0, 202));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIncio.setBackground(new java.awt.Color(80, 0, 202));
        btnIncio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIncioMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_home_24px.png"))); // NOI18N
        jLabel1.setText("   Inicio");

        javax.swing.GroupLayout btnIncioLayout = new javax.swing.GroupLayout(btnIncio);
        btnIncio.setLayout(btnIncioLayout);
        btnIncioLayout.setHorizontalGroup(
            btnIncioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnIncioLayout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnIncioLayout.setVerticalGroup(
            btnIncioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnIncioLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.add(btnIncio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 60));

        btnProducto.setBackground(new java.awt.Color(80, 0, 202));
        btnProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductoMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_product_26px_1.png"))); // NOI18N
        jLabel2.setText("  Productos");

        javax.swing.GroupLayout btnProductoLayout = new javax.swing.GroupLayout(btnProducto);
        btnProducto.setLayout(btnProductoLayout);
        btnProductoLayout.setHorizontalGroup(
            btnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProductoLayout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnProductoLayout.setVerticalGroup(
            btnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProductoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Menu.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 240, 60));

        btnVentas.setBackground(new java.awt.Color(80, 0, 202));
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVentasMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_money_24px.png"))); // NOI18N
        jLabel3.setText("  Ventas");

        javax.swing.GroupLayout btnVentasLayout = new javax.swing.GroupLayout(btnVentas);
        btnVentas.setLayout(btnVentasLayout);
        btnVentasLayout.setHorizontalGroup(
            btnVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVentasLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnVentasLayout.setVerticalGroup(
            btnVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVentasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Menu.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 240, 60));

        btnClientes.setBackground(new java.awt.Color(80, 0, 202));
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientesMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_client_management_24px.png"))); // NOI18N
        jLabel5.setText("  Clientes");

        javax.swing.GroupLayout btnClientesLayout = new javax.swing.GroupLayout(btnClientes);
        btnClientes.setLayout(btnClientesLayout);
        btnClientesLayout.setHorizontalGroup(
            btnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnClientesLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        btnClientesLayout.setVerticalGroup(
            btnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnClientesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Menu.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 240, 60));

        btnProveedores.setBackground(new java.awt.Color(80, 0, 202));
        btnProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_car_24px.png"))); // NOI18N
        jLabel6.setText("  Proveedores");

        javax.swing.GroupLayout btnProveedoresLayout = new javax.swing.GroupLayout(btnProveedores);
        btnProveedores.setLayout(btnProveedoresLayout);
        btnProveedoresLayout.setHorizontalGroup(
            btnProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProveedoresLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnProveedoresLayout.setVerticalGroup(
            btnProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProveedoresLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Menu.add(btnProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 240, 60));

        btnReportes.setBackground(new java.awt.Color(80, 0, 202));
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_combo_chart_30px.png"))); // NOI18N
        jLabel7.setText(" Reportes");

        javax.swing.GroupLayout btnReportesLayout = new javax.swing.GroupLayout(btnReportes);
        btnReportes.setLayout(btnReportesLayout);
        btnReportesLayout.setHorizontalGroup(
            btnReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReportesLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnReportesLayout.setVerticalGroup(
            btnReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReportesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Menu.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 240, 60));

        btnConfiguracion.setBackground(new java.awt.Color(80, 0, 202));
        btnConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfiguracionMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_services_24px.png"))); // NOI18N
        jLabel10.setText(" Configuración ");

        javax.swing.GroupLayout btnConfiguracionLayout = new javax.swing.GroupLayout(btnConfiguracion);
        btnConfiguracion.setLayout(btnConfiguracionLayout);
        btnConfiguracionLayout.setHorizontalGroup(
            btnConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnConfiguracionLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnConfiguracionLayout.setVerticalGroup(
            btnConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnConfiguracionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Menu.add(btnConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 240, 60));

        jPanel1.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 550));

        PanelInicio.setBackground(new java.awt.Color(255, 255, 255));

        rSPanelOpacity1.setBackground(new java.awt.Color(0, 153, 51));
        rSPanelOpacity1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(255, 255, 255)));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dinero.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelOpacity1Layout = new javax.swing.GroupLayout(rSPanelOpacity1);
        rSPanelOpacity1.setLayout(rSPanelOpacity1Layout);
        rSPanelOpacity1Layout.setHorizontalGroup(
            rSPanelOpacity1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        rSPanelOpacity1Layout.setVerticalGroup(
            rSPanelOpacity1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        rSPanelOpacity3.setBackground(new java.awt.Color(0, 153, 51));
        rSPanelOpacity3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textTotalVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textTotalVentas.setForeground(new java.awt.Color(255, 255, 255));
        textTotalVentas.setText("0");
        rSPanelOpacity3.add(textTotalVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 190, 30));

        labelVentaYearActual.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelVentaYearActual.setForeground(new java.awt.Color(255, 255, 255));
        labelVentaYearActual.setText("Ventas ");
        rSPanelOpacity3.add(labelVentaYearActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 30));

        rSPanelOpacity4.setBackground(new java.awt.Color(0, 0, 255));
        rSPanelOpacity4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(255, 255, 255)));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_client_management_24px.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelOpacity4Layout = new javax.swing.GroupLayout(rSPanelOpacity4);
        rSPanelOpacity4.setLayout(rSPanelOpacity4Layout);
        rSPanelOpacity4Layout.setHorizontalGroup(
            rSPanelOpacity4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        rSPanelOpacity4Layout.setVerticalGroup(
            rSPanelOpacity4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity4Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        rSPanelOpacity5.setBackground(new java.awt.Color(0, 0, 255));
        rSPanelOpacity5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Clientes");
        rSPanelOpacity5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 125, 58));

        textCantidadClientes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textCantidadClientes.setForeground(new java.awt.Color(255, 255, 255));
        textCantidadClientes.setText("0");
        rSPanelOpacity5.add(textCantidadClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 46, 170, 50));

        rSPanelOpacity8.setBackground(new java.awt.Color(102, 0, 102));
        rSPanelOpacity8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(255, 255, 255)));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_tags_30px.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelOpacity8Layout = new javax.swing.GroupLayout(rSPanelOpacity8);
        rSPanelOpacity8.setLayout(rSPanelOpacity8Layout);
        rSPanelOpacity8Layout.setHorizontalGroup(
            rSPanelOpacity8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity8Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        rSPanelOpacity8Layout.setVerticalGroup(
            rSPanelOpacity8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity8Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        rSPanelOpacity10.setBackground(new java.awt.Color(102, 0, 102));
        rSPanelOpacity10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        textStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textStock.setForeground(new java.awt.Color(255, 255, 255));
        textStock.setText("Productos en stock: 0");

        javax.swing.GroupLayout rSPanelOpacity10Layout = new javax.swing.GroupLayout(rSPanelOpacity10);
        rSPanelOpacity10.setLayout(rSPanelOpacity10Layout);
        rSPanelOpacity10Layout.setHorizontalGroup(
            rSPanelOpacity10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textStock, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );
        rSPanelOpacity10Layout.setVerticalGroup(
            rSPanelOpacity10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        rSPanelOpacity9.setBackground(new java.awt.Color(102, 0, 102));
        rSPanelOpacity9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Iventario");
        rSPanelOpacity9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 125, 30));

        textDineroIventario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textDineroIventario.setForeground(new java.awt.Color(255, 255, 255));
        textDineroIventario.setText("0");
        rSPanelOpacity9.add(textDineroIventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 200, 20));

        lebelReporteYearActual.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lebelReporteYearActual.setForeground(new java.awt.Color(51, 51, 51));
        lebelReporteYearActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/analitica.png"))); // NOI18N
        lebelReporteYearActual.setText(" Reporte Año");

        rSPanelOpacity12.setBackground(new java.awt.Color(255, 102, 0));
        rSPanelOpacity12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(255, 255, 255)));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_car_24px.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelOpacity12Layout = new javax.swing.GroupLayout(rSPanelOpacity12);
        rSPanelOpacity12.setLayout(rSPanelOpacity12Layout);
        rSPanelOpacity12Layout.setHorizontalGroup(
            rSPanelOpacity12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity12Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        rSPanelOpacity12Layout.setVerticalGroup(
            rSPanelOpacity12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity12Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        rSPanelOpacity13.setBackground(new java.awt.Color(255, 102, 0));
        rSPanelOpacity13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Proveedores");
        rSPanelOpacity13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 58));

        textCantidadProveedores.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textCantidadProveedores.setForeground(new java.awt.Color(255, 255, 255));
        textCantidadProveedores.setText("0");
        rSPanelOpacity13.add(textCantidadProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 46, 170, 50));

        javax.swing.GroupLayout PanelInicioLayout = new javax.swing.GroupLayout(PanelInicio);
        PanelInicio.setLayout(PanelInicioLayout);
        PanelInicioLayout.setHorizontalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(lebelReporteYearActual, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addComponent(rSPanelOpacity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(rSPanelOpacity3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addComponent(rSPanelOpacity12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(rSPanelOpacity13, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                        .addComponent(rSPanelOpacity4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(rSPanelOpacity5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                        .addComponent(rSPanelOpacity8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSPanelOpacity9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSPanelOpacity10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );
        PanelInicioLayout.setVerticalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lebelReporteYearActual, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSPanelOpacity1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(rSPanelOpacity4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(rSPanelOpacity5, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(rSPanelOpacity3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSPanelOpacity8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addComponent(rSPanelOpacity9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(rSPanelOpacity10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rSPanelOpacity12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSPanelOpacity13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(PanelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 810, 550));

        PanelProductos.setBackground(new java.awt.Color(255, 255, 255));
        PanelProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Producto", "Categria", "Existencia", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProductos.setBackgoundHead(new java.awt.Color(80, 0, 202));
        tableProductos.setBackgoundHover(null);
        tableProductos.setBorderHead(null);
        tableProductos.setBorderRows(null);
        tableProductos.setColorSecondary(new java.awt.Color(255, 255, 255));
        tableProductos.setDropMode(javax.swing.DropMode.ON);
        tableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProductos);
        if (tableProductos.getColumnModel().getColumnCount() > 0) {
            tableProductos.getColumnModel().getColumn(0).setResizable(false);
            tableProductos.getColumnModel().getColumn(1).setResizable(false);
            tableProductos.getColumnModel().getColumn(2).setResizable(false);
            tableProductos.getColumnModel().getColumn(3).setResizable(false);
            tableProductos.getColumnModel().getColumn(4).setResizable(false);
            tableProductos.getColumnModel().getColumn(4).setHeaderValue("Precio");
        }

        PanelProductos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 830, 470));

        textBuscarProductos.setForeground(new java.awt.Color(0, 0, 0));
        textBuscarProductos.setBorderColor(new java.awt.Color(80, 0, 202));
        textBuscarProductos.setPhColor(new java.awt.Color(0, 0, 0));
        textBuscarProductos.setPlaceholder("Buscar por nombre de producto");
        textBuscarProductos.setSelectionColor(new java.awt.Color(0, 0, 0));
        textBuscarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscarProductosKeyReleased(evt);
            }
        });
        PanelProductos.add(textBuscarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, -1));

        btnAgregarProductos.setBorder(null);
        btnAgregarProductos.setText("Agregar Nuevo Producto");
        btnAgregarProductos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductosActionPerformed(evt);
            }
        });
        PanelProductos.add(btnAgregarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 16, 220, -1));

        btnEditarProductos.setBackground(new java.awt.Color(10, 158, 1));
        btnEditarProductos.setBorder(null);
        btnEditarProductos.setText("Editar  Producto");
        btnEditarProductos.setBackgroundHover(new java.awt.Color(10, 158, 1));
        btnEditarProductos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductosActionPerformed(evt);
            }
        });
        PanelProductos.add(btnEditarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 16, 170, -1));

        btnUpdateTabla.setBorder(null);
        btnUpdateTabla.setText("Actualizar Tabla");
        btnUpdateTabla.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        btnUpdateTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTablaActionPerformed(evt);
            }
        });
        PanelProductos.add(btnUpdateTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 16, 170, -1));

        jPanel1.add(PanelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 810, 550));

        PanelVentas.setBackground(new java.awt.Color(255, 255, 255));
        PanelVentas.setInheritsPopupMenu(true);

        textBuscarProductoVentas.setForeground(new java.awt.Color(0, 0, 0));
        textBuscarProductoVentas.setBorderColor(new java.awt.Color(80, 0, 202));
        textBuscarProductoVentas.setPhColor(new java.awt.Color(0, 0, 0));
        textBuscarProductoVentas.setPlaceholder("Buscar por Fecha/cliente");
        textBuscarProductoVentas.setSelectionColor(new java.awt.Color(0, 0, 0));
        textBuscarProductoVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscarProductoVentasKeyReleased(evt);
            }
        });

        btnAgregarVenta.setBorder(null);
        btnAgregarVenta.setText("Agregar venta");
        btnAgregarVenta.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVentaActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);

        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Cliente", "Vendedor", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVentas.setBackgoundHead(new java.awt.Color(80, 0, 202));
        tableVentas.setBackgoundHover(null);
        tableVentas.setBorderHead(null);
        tableVentas.setBorderRows(null);
        tableVentas.setColorSecondary(new java.awt.Color(255, 255, 255));
        tableVentas.setDropMode(javax.swing.DropMode.ON);
        tableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableVentas);
        if (tableVentas.getColumnModel().getColumnCount() > 0) {
            tableVentas.getColumnModel().getColumn(0).setResizable(false);
            tableVentas.getColumnModel().getColumn(1).setResizable(false);
            tableVentas.getColumnModel().getColumn(1).setHeaderValue("Fecha");
            tableVentas.getColumnModel().getColumn(2).setResizable(false);
            tableVentas.getColumnModel().getColumn(3).setResizable(false);
            tableVentas.getColumnModel().getColumn(4).setResizable(false);
        }

        btnImprimirFactura.setBorder(null);
        btnImprimirFactura.setText("Imprimir factura");
        btnImprimirFactura.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelVentasLayout = new javax.swing.GroupLayout(PanelVentas);
        PanelVentas.setLayout(PanelVentasLayout);
        PanelVentasLayout.setHorizontalGroup(
            PanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVentasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(textBuscarProductoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnAgregarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnImprimirFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        PanelVentasLayout.setVerticalGroup(
            PanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVentasLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelVentasLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(textBuscarProductoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimirFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(PanelVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 810, 550));

        PanelClientes.setBackground(new java.awt.Color(255, 255, 255));
        PanelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textBuscarClientes.setForeground(new java.awt.Color(0, 0, 0));
        textBuscarClientes.setBorderColor(new java.awt.Color(80, 0, 202));
        textBuscarClientes.setPhColor(new java.awt.Color(0, 0, 0));
        textBuscarClientes.setPlaceholder("Buscar por nombre");
        textBuscarClientes.setSelectionColor(new java.awt.Color(0, 0, 0));
        textBuscarClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscarClientesKeyReleased(evt);
            }
        });
        PanelClientes.add(textBuscarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 370, -1));

        btnEditarClientes.setBorder(null);
        btnEditarClientes.setText("Editar Clientes");
        btnEditarClientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClientesActionPerformed(evt);
            }
        });
        PanelClientes.add(btnEditarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 4, 170, -1));

        btnAgregarClientes.setBorder(null);
        btnAgregarClientes.setText("Agregar Nuevos Clientes");
        btnAgregarClientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClientesActionPerformed(evt);
            }
        });
        PanelClientes.add(btnAgregarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 4, 250, -1));

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Completo", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableClientes.setBackgoundHead(new java.awt.Color(80, 0, 202));
        tableClientes.setBackgoundHover(null);
        tableClientes.setBorderHead(null);
        tableClientes.setBorderRows(null);
        tableClientes.setColorSecondary(new java.awt.Color(255, 255, 255));
        tableClientes.setDropMode(javax.swing.DropMode.ON);
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableClientes);
        if (tableClientes.getColumnModel().getColumnCount() > 0) {
            tableClientes.getColumnModel().getColumn(0).setResizable(false);
            tableClientes.getColumnModel().getColumn(1).setResizable(false);
            tableClientes.getColumnModel().getColumn(2).setResizable(false);
        }

        PanelClientes.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 830, 490));

        jPanel1.add(PanelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 810, 550));

        PanelProveedores.setBackground(new java.awt.Color(255, 255, 255));

        textBuscarProveedores.setForeground(new java.awt.Color(0, 0, 0));
        textBuscarProveedores.setBorderColor(new java.awt.Color(80, 0, 202));
        textBuscarProveedores.setPhColor(new java.awt.Color(0, 0, 0));
        textBuscarProveedores.setPlaceholder("Buscar por nombre");
        textBuscarProveedores.setSelectionColor(new java.awt.Color(0, 0, 0));
        textBuscarProveedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscarProveedoresKeyReleased(evt);
            }
        });

        btnAgregarProductos4.setBorder(null);
        btnAgregarProductos4.setText("Editar ");
        btnAgregarProductos4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnAgregarProductos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductos4ActionPerformed(evt);
            }
        });

        btnAgregarProductos3.setBorder(null);
        btnAgregarProductos3.setText("Agregar  Nuevo Proveedor");
        btnAgregarProductos3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarProductos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductos3ActionPerformed(evt);
            }
        });

        tableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Compañia", "Telefono", "Nombre Completo", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProveedores.setBackgoundHead(new java.awt.Color(80, 0, 202));
        tableProveedores.setBackgoundHover(null);
        tableProveedores.setBorderHead(null);
        tableProveedores.setBorderRows(null);
        tableProveedores.setColorSecondary(new java.awt.Color(255, 255, 255));
        tableProveedores.setDropMode(javax.swing.DropMode.ON);
        tableProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProveedoresMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableProveedores);
        if (tableProveedores.getColumnModel().getColumnCount() > 0) {
            tableProveedores.getColumnModel().getColumn(0).setResizable(false);
            tableProveedores.getColumnModel().getColumn(1).setResizable(false);
            tableProveedores.getColumnModel().getColumn(2).setResizable(false);
            tableProveedores.getColumnModel().getColumn(3).setResizable(false);
            tableProveedores.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout PanelProveedoresLayout = new javax.swing.GroupLayout(PanelProveedores);
        PanelProveedores.setLayout(PanelProveedoresLayout);
        PanelProveedoresLayout.setHorizontalGroup(
            PanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProveedoresLayout.createSequentialGroup()
                .addGroup(PanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProveedoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textBuscarProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarProductos3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarProductos4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelProveedoresLayout.setVerticalGroup(
            PanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProveedoresLayout.createSequentialGroup()
                .addGroup(PanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProveedoresLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(PanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarProductos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarProductos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelProveedoresLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(textBuscarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
        );

        jPanel1.add(PanelProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 810, 550));

        PanelReportes.setBackground(new java.awt.Color(255, 255, 255));

        btnReporteIventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteIventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReporteIventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReporteIventarioMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inventario.png"))); // NOI18N
        jLabel11.setText("Reporte de inventario");

        javax.swing.GroupLayout btnReporteIventarioLayout = new javax.swing.GroupLayout(btnReporteIventario);
        btnReporteIventario.setLayout(btnReporteIventarioLayout);
        btnReporteIventarioLayout.setHorizontalGroup(
            btnReporteIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReporteIventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnReporteIventarioLayout.setVerticalGroup(
            btnReporteIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReporteIventarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(15, 15, 15))
        );

        btnProductosMasVendidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMasVendidosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductosMasVendidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductosMasVendidosMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/analisis-de-datos.png"))); // NOI18N
        jLabel4.setText("Productos mas ventidos");

        javax.swing.GroupLayout btnProductosMasVendidosLayout = new javax.swing.GroupLayout(btnProductosMasVendidos);
        btnProductosMasVendidos.setLayout(btnProductosMasVendidosLayout);
        btnProductosMasVendidosLayout.setHorizontalGroup(
            btnProductosMasVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProductosMasVendidosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btnProductosMasVendidosLayout.setVerticalGroup(
            btnProductosMasVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        btnReporteVentas.setBackground(new java.awt.Color(0, 153, 51));
        btnReporteVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReporteVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReporteVentasMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporteVenta.png"))); // NOI18N
        jLabel8.setText("Reporte de ventas");

        javax.swing.GroupLayout btnReporteVentasLayout = new javax.swing.GroupLayout(btnReporteVentas);
        btnReporteVentas.setLayout(btnReporteVentasLayout);
        btnReporteVentasLayout.setHorizontalGroup(
            btnReporteVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReporteVentasLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(15, 15, 15))
        );
        btnReporteVentasLayout.setVerticalGroup(
            btnReporteVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReporteVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelReportesLayout = new javax.swing.GroupLayout(PanelReportes);
        PanelReportes.setLayout(PanelReportesLayout);
        PanelReportesLayout.setHorizontalGroup(
            PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReportesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnReporteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(btnReporteIventario, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(PanelReportesLayout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(btnProductosMasVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelReportesLayout.setVerticalGroup(
            PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReportesLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReporteIventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReporteVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(82, 82, 82)
                .addComponent(btnProductosMasVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jPanel1.add(PanelReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 810, 550));

        PanelConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        PanelConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel14.setText("Configuración");
        PanelConfiguracion.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, 50));

        rSPanelOpacity6.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelOpacity6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        rSPanelOpacity6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSPanelOpacity6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSPanelOpacity6MouseExited(evt);
            }
        });

        btnAddUsurios.setText(" Añadir Usuarios");
        btnAddUsurios.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnAddUsurios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsuriosActionPerformed(evt);
            }
        });

        btnGestionarUsuarios.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        btnGestionarUsuarios.setLabel(" Gestionar Usuario");
        btnGestionarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelOpacity6Layout = new javax.swing.GroupLayout(rSPanelOpacity6);
        rSPanelOpacity6.setLayout(rSPanelOpacity6Layout);
        rSPanelOpacity6Layout.setHorizontalGroup(
            rSPanelOpacity6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity6Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(rSPanelOpacity6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGestionarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddUsurios, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        rSPanelOpacity6Layout.setVerticalGroup(
            rSPanelOpacity6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity6Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(btnGestionarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddUsurios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        PanelConfiguracion.add(rSPanelOpacity6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 300, 190));

        rSPanelOpacity7.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelOpacity7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categorias", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnGestionCategorias.setText(" Gestionar Categorias");
        btnGestionCategorias.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LABEL);
        btnGestionCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionCategoriasActionPerformed(evt);
            }
        });

        btnAddCategorias.setText(" Añadir Categorias");
        btnAddCategorias.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnAddCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelOpacity7Layout = new javax.swing.GroupLayout(rSPanelOpacity7);
        rSPanelOpacity7.setLayout(rSPanelOpacity7Layout);
        rSPanelOpacity7Layout.setHorizontalGroup(
            rSPanelOpacity7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity7Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(rSPanelOpacity7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        rSPanelOpacity7Layout.setVerticalGroup(
            rSPanelOpacity7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelOpacity7Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(btnGestionCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        PanelConfiguracion.add(rSPanelOpacity7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 300, 190));

        jPanel1.add(PanelConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 810, 550));

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

    public void reportesInicio() {
        ReporteInicio iventario = new ReporteInicio();
        this.textDineroIventario.setText("$" + String.valueOf(iventario.getTotalIventario()));
        this.textStock.setText("Productos en stock: " + String.valueOf(iventario.getProductoStock()));
        this.textCantidadClientes.setText(String.valueOf(iventario.getCantidadClientes()));
        this.textTotalVentas.setText("$" + String.valueOf(iventario.getVentas()));
        Calendar fecha = new GregorianCalendar();
        this.labelVentaYearActual.setText("Ventas " + fecha.get(Calendar.YEAR));
        this.lebelReporteYearActual.setText("Reporte " + fecha.get(Calendar.YEAR));
        this.textCantidadProveedores.setText(String.valueOf(iventario.cantidadProveedores()));

    }

    private void coloresMenu(Color color1, Color color2, Color color4, Color color5, Color color6, Color color7, Color color8) {
        this.btnIncio.setBackground(color1);
        this.btnClientes.setBackground(color2);
        this.btnProducto.setBackground(color4);
        this.btnProveedores.setBackground(color5);
        this.btnReportes.setBackground(color6); //Reportes
        this.btnVentas.setBackground(color7);
        this.btnConfiguracion.setBackground(color8);
    }

    private void mostrarOcultarJpanel(boolean inicio, boolean producto, boolean ventas, boolean compra, boolean cliente,
            boolean proveedores, boolean reporte, boolean configuracion) {
        this.PanelInicio.setVisible(inicio);
        this.PanelProductos.setVisible(producto);
        this.PanelVentas.setVisible(ventas);
        this.PanelClientes.setVisible(cliente);
        this.PanelProveedores.setVisible(proveedores);
        this.PanelReportes.setVisible(reporte);
        this.PanelConfiguracion.setVisible(configuracion);

    }
    
    private void productos() {
        try {

            modelo = (DefaultTableModel) tableProductos.getModel();
            modelo.setRowCount(0);
            tableProductos.setRowHeight(50);

            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            if (this.textBuscarProductos.equals("")) {
                result = instrucion.executeQuery("select idProducto,nombreProducto,c.nombreCategoria,stock,precio from productos as p\n"
                        + "inner join categoriaProductos as c on c.idCategoria = p.idCategoria");
            } else {
                result = instrucion.executeQuery("select idProducto,nombreProducto,c.nombreCategoria,stock,precio from productos as p\n"
                        + "inner join categoriaProductos as c on c.idCategoria = p.idCategoria\n"
                        + "where p.nombreProducto like '" + this.textBuscarProductos.getText() + "%' or c.nombreCategoria like '" + this.textBuscarProductos.getText() + "%'");
            }

            while (result.next()) {
                String[] productos = new String[5];
                productos[0] = String.valueOf(result.getInt("idProducto"));
                productos[1] = result.getString("nombreProducto");
                productos[2] = result.getString("nombreCategoria");
                productos[3] = String.valueOf(result.getInt("stock"));
                productos[4] = String.valueOf(result.getDouble("precio"));
                modelo.addRow(productos);
                tableProductos.setModel(modelo);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado.." + e.toString());
        }
    }

    private void mostrarClientes() {
        try {

            modelo = (DefaultTableModel) tableClientes.getModel();
            modelo.setRowCount(0);
            tableClientes.setRowHeight(40);

            tableClientes.getColumn("Id").setPreferredWidth(20);
            
            
            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            instrucion = cone.getConexion().createStatement();

            if (this.textBuscarProductos.equals("")) {
                result = instrucion.executeQuery("select idClientes,nombre,apellido ,direccion from clientes");
            } else {
                result = instrucion.executeQuery("select idClientes,nombre,apellido ,direccion from clientes\n"
                        + "where nombre LIKE '" + this.textBuscarClientes.getText() + "%' ");
            }

            while (result.next()) {
                String[] clients = new String[3];
                clients[0] = String.valueOf(result.getInt("idClientes"));
                clients[1] = result.getString("nombre") + " " + result.getString("apellido");             
                clients[2] = result.getString("direccion");
                modelo.addRow(clients);
                tableClientes.setModel(modelo);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado.." + e.toString());
        }

    }

    private void btnIncioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncioMouseClicked
        coloresMenu(new Color(39, 48, 54), new Color(80, 0, 202), new Color(80, 0, 202),
                new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202));

        btnIncio.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
        btnClientes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProducto.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProveedores.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnReportes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnVentas.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnConfiguracion.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        reportesInicio();
        mostrarOcultarJpanel(true, false, false, false, false, false, false, false);

    }//GEN-LAST:event_btnIncioMouseClicked

    private void btnProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseClicked
        coloresMenu(new Color(80, 0, 202), new Color(80, 0, 202), new Color(39, 48, 54),
                new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202));

        btnIncio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnClientes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProducto.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
        btnProveedores.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnReportes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnVentas.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnConfiguracion.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        productos(); //Tabla
        mostrarOcultarJpanel(false, true, false, false, false, false, false, false);

    }//GEN-LAST:event_btnProductoMouseClicked

    private void btnVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseClicked
        coloresMenu(new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202),
                new Color(80, 0, 202), new Color(80, 0, 202), new Color(39, 48, 54), new Color(80, 0, 202));

        mostrarVentas();
        btnIncio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnClientes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProducto.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProveedores.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnReportes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnVentas.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
        btnConfiguracion.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));

        mostrarOcultarJpanel(false, false, true, false, false, false, false, false);

    }//GEN-LAST:event_btnVentasMouseClicked

    private void mostrarVentas() {
        String SQL_VENTA_TODO = "select v.idventa,convert(date,v.fecha) as 'Fecha',c.nombre as 'Cliente',u.nombre as 'Vendedor',sum(dv.cantidad * dv.precio) as 'total' from ventas as v\n"
                + "inner join detalle_ventas as dv on dv.idventa = v.idventa\n"
                + "inner join clientes as c on c.idClientes = v.idcliente\n"
                + "inner join Usuarios as u on u.id_usuario = v.idusuario\n"
                + "group by v.idventa,v.fecha,c.nombre,u.nombre";

        try {

            modelo = (DefaultTableModel) tableVentas.getModel();
            modelo.setRowCount(0);
            tableVentas.setRowHeight(50);

            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            
            instrucion = cone.getConexion().createStatement();

            if (this.textBuscarProductoVentas.getText().equals("")) {
                result = instrucion.executeQuery(SQL_VENTA_TODO);
            } else {

                result = instrucion.executeQuery("select v.idventa,convert(date,v.fecha) as 'Fecha',c.nombre as 'Cliente',u.nombre as 'Vendedor',sum(dv.cantidad * dv.precio) as 'total' from ventas as v\n"
                        + "inner join detalle_ventas as dv on dv.idventa = v.idventa\n"
                        + "inner join clientes as c on c.idClientes = v.idcliente\n"
                        + "inner join Usuarios as u on u.id_usuario = v.idusuario\n"
                        + "where c.nombre LIKE '" + this.textBuscarProductoVentas.getText() + "%' or v.fecha LIKE '" + this.textBuscarProductoVentas.getText() + "%' or u.nombre  LIKE '" + this.textBuscarProductoVentas.getText() + "&' "
                        + "group by v.idventa,v.fecha,c.nombre,u.nombre"
                );
            }

            while (result.next()) {
                String[] productos = new String[5];
                productos[0] = String.valueOf(result.getInt("idventa"));
                productos[1] = result.getString("Fecha");
                productos[2] = result.getString("Cliente");
                productos[3] = String.valueOf(result.getString("Vendedor"));
                productos[4] = String.valueOf(result.getLong("total"));
                modelo.addRow(productos);
                tableVentas.setModel(modelo);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado.." + e.toString());
        }
    }

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        coloresMenu(new Color(80, 0, 202), new Color(39, 48, 54), new Color(80, 0, 202),
                new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202));

        mostrarClientes();
        btnIncio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnClientes.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
        btnProducto.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProveedores.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnReportes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnVentas.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnConfiguracion.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));

        mostrarOcultarJpanel(false, false, false, false, true, false, false, false);
    }//GEN-LAST:event_btnClientesMouseClicked

    private void mostrarProveedores() {
        try {

            modelo = (DefaultTableModel) tableProveedores.getModel();
            modelo.setRowCount(0);

            tableProveedores.setRowHeight(50);

            Conexion cone = Conexion.getInstance();
            Statement instrucion;
            
            instrucion = cone.getConexion().createStatement();

            if (this.textBuscarProveedores.getText().equals("")) {
                result = instrucion.executeQuery("select * from proveedores");
            } else {

                result = instrucion.executeQuery("select * from proveedores\n"
                        + "where nombreCompania LIKE '" + this.textBuscarProveedores.getText() + "%' ");
            }

            while (result.next()) {
                String[] proveedor = new String[5];
                proveedor[0] = String.valueOf(result.getInt("idProveedor"));
                proveedor[1] = result.getString("nombreCompania");
                proveedor[2] = result.getString("telefono");
                proveedor[3] = result.getString("nombre") + " " + result.getString("apellido");
                proveedor[4] = result.getString("correoElectronico");
                modelo.addRow(proveedor);
                tableProveedores.setModel(modelo);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado.." + e.toString());
        }

    }
    private void btnProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseClicked
        coloresMenu(new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202),
                new Color(39, 48, 54), new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202));
        mostrarProveedores();
        btnIncio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnClientes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProducto.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProveedores.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
        btnReportes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnVentas.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnConfiguracion.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));

        mostrarOcultarJpanel(false, false, false, false, false, true, false, false);
    }//GEN-LAST:event_btnProveedoresMouseClicked

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        if (this.tipoUsuario.equals("Administrador")) {
            coloresMenu(new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202),
                    new Color(80, 0, 202), new Color(39, 48, 54), new Color(80, 0, 202), new Color(80, 0, 202));

            btnIncio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
            btnClientes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
            btnProducto.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
            btnProveedores.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
            btnReportes.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
            btnVentas.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
            btnConfiguracion.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));

            mostrarOcultarJpanel(false, false, false, false, false, false, true, false);
        } else {
            PermisoDenegado permiso = new PermisoDenegado(this, true);
            permiso.setVisible(true);
        }


    }//GEN-LAST:event_btnReportesMouseClicked

    private void textBuscarProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarProductosKeyReleased
        productos();
    }//GEN-LAST:event_textBuscarProductosKeyReleased

    private void btnAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductosActionPerformed
        new Agregar(this, true).setVisible(true);
        productos();


    }//GEN-LAST:event_btnAgregarProductosActionPerformed

    private void tableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductosMouseClicked
        int seleccion = tableProductos.getSelectedRow();
        this.idProducto = Integer.parseInt(tableProductos.getValueAt(seleccion, 0).toString());
    }//GEN-LAST:event_tableProductosMouseClicked

    private void btnEditarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductosActionPerformed
        if (this.idProducto == 0) {
            JOptionPane.showMessageDialog(null, "Primero debes selecionar una fila", "Error: Producto no selecionado", JOptionPane.ERROR_MESSAGE);
        } else {
            Editar editar = new Editar(this, true);
            editar.datos(idProducto);
            editar.setVisible(true);
            this.idProducto = 0;
            this.productos();

        }

    }//GEN-LAST:event_btnEditarProductosActionPerformed

    private void btnUpdateTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTablaActionPerformed
        this.productos();
    }//GEN-LAST:event_btnUpdateTablaActionPerformed

    private void textBuscarProductoVentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarProductoVentasKeyReleased
        mostrarVentas();
    }//GEN-LAST:event_textBuscarProductoVentasKeyReleased

    private void btnAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVentaActionPerformed
        AgregarVenta addVentas = new AgregarVenta(this, true);
        addVentas.setIdUsuario(getIdUsuario());
        addVentas.setVisible(true);
        mostrarVentas();


    }//GEN-LAST:event_btnAgregarVentaActionPerformed

    private void btnImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirFacturaActionPerformed

        if (this.idVenta == 0) {
            JOptionPane.showMessageDialog(null, "Primero debes selecionar una fila", "Error: Venta no selecionado", JOptionPane.ERROR_MESSAGE);
        } else {
         
            Conexion conn = Conexion.getInstance();
            Map parametro = new HashMap();
            parametro.put("idVenta", this.idVenta);
            JasperReport reporte;
            try {
                reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Ventas/ImprimirFactura.jasper"));
                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn.getConexion());

                JasperViewer view = new JasperViewer(jprint, false);
                view.setIconImage(new ImageIcon(getClass().getResource("/Img/Iconoo.png")).getImage());
                view.setVisible(true);
                

                view.setTitle("Imprimir Factura");
            } catch (JRException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.mostrarVentas();
            this.idVenta = 0;

        }

    }//GEN-LAST:event_btnImprimirFacturaActionPerformed


    private void btnConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMouseClicked

        coloresMenu(new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202),
                new Color(80, 0, 202), new Color(80, 0, 202), new Color(80, 0, 202), new Color(39, 48, 54));

        btnIncio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnClientes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProducto.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnProveedores.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnReportes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnVentas.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(80, 0, 202)));
        btnConfiguracion.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));

        mostrarOcultarJpanel(false, false, false, false, false, false, false, true);

        if(!this.tipoUsuario.equals("Administrador")){
            this.btnGestionarUsuarios.setEnabled(false);
            this.btnAddUsurios.setEnabled(false);
        }

    }//GEN-LAST:event_btnConfiguracionMouseClicked

    private void textBuscarClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarClientesKeyReleased
        mostrarClientes();
    }//GEN-LAST:event_textBuscarClientesKeyReleased

    private void btnEditarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClientesActionPerformed
        if (this.idCliente == 0) {
            JOptionPane.showMessageDialog(null, "Primero debes selecionar una fila", "Error: Cliente no selecionado", JOptionPane.ERROR_MESSAGE);
        } else {
            EditarClientes editClient = new EditarClientes(this, true);
            editClient.mostrarDatos(idCliente);
            editClient.setVisible(true);
            this.idCliente = 0;
            mostrarClientes();
        }


    }//GEN-LAST:event_btnEditarClientesActionPerformed

    private void btnAgregarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClientesActionPerformed
        AgregarClientes newClient = new AgregarClientes(this, true);
        newClient.setVisible(true);
        mostrarClientes();
    }//GEN-LAST:event_btnAgregarClientesActionPerformed

    private void tableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasMouseClicked

        int seleccion = tableVentas.getSelectedRow();
        this.idVenta = Integer.parseInt(tableVentas.getValueAt(seleccion, 0).toString());

    }//GEN-LAST:event_tableVentasMouseClicked

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientesMouseClicked
        int seleccion = tableClientes.getSelectedRow();
        this.idCliente = Integer.parseInt(tableClientes.getValueAt(seleccion, 0).toString());
    }//GEN-LAST:event_tableClientesMouseClicked

    private void textBuscarProveedoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarProveedoresKeyReleased
        mostrarProveedores();
    }//GEN-LAST:event_textBuscarProveedoresKeyReleased

    private void tableProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedoresMouseClicked
        int seleccion = tableProveedores.getSelectedRow();
        this.idProveedor = Integer.parseInt(tableProveedores.getValueAt(seleccion, 0).toString());
    }//GEN-LAST:event_tableProveedoresMouseClicked

    private void btnAgregarProductos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductos3ActionPerformed
        AgregarProveedor agregar = new AgregarProveedor(this, true);
        agregar.setVisible(true);
        mostrarProveedores();
    }//GEN-LAST:event_btnAgregarProductos3ActionPerformed

    private void btnAgregarProductos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductos4ActionPerformed
        if (this.idProveedor == 0) {
            JOptionPane.showMessageDialog(null, "Primero debes selecionar una fila", "Error: Proveedor no selecionado", JOptionPane.ERROR_MESSAGE);
        } else {
            EditarProveedores editar = new EditarProveedores(this, true);
            editar.mostrarDatos(this.idProveedor);
            editar.setVisible(true);
            this.idProveedor = 0;
            mostrarProveedores();

        }


    }//GEN-LAST:event_btnAgregarProductos4ActionPerformed

    private void btnReporteVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteVentasMouseEntered
        this.btnReporteVentas.setOpacity((float) 0.8);
    }//GEN-LAST:event_btnReporteVentasMouseEntered

    private void btnReporteVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteVentasMouseExited
        this.btnReporteVentas.setOpacity((float) 1.0);
    }//GEN-LAST:event_btnReporteVentasMouseExited

    private void btnReporteIventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteIventarioMouseEntered
        this.btnReporteIventario.setOpacity((float) 0.8);
    }//GEN-LAST:event_btnReporteIventarioMouseEntered

    private void btnReporteIventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteIventarioMouseExited
        this.btnReporteIventario.setOpacity((float) 1.0);
    }//GEN-LAST:event_btnReporteIventarioMouseExited

    private void btnProductosMasVendidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMasVendidosMouseEntered
        this.btnProductosMasVendidos.setOpacity((float) 0.8);
    }//GEN-LAST:event_btnProductosMasVendidosMouseEntered

    private void btnProductosMasVendidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMasVendidosMouseExited
        this.btnProductosMasVendidos.setOpacity((float) 1.0);
    }//GEN-LAST:event_btnProductosMasVendidosMouseExited

    private void btnReporteVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteVentasMouseClicked

        try {
            Conexion conn = Conexion.getInstance();
            JasperReport reporte;
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/ReporteInicio/ReporteVentas.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setIconImage(new ImageIcon(getClass().getResource("/Img/Iconoo.png")).getImage());
            view.setVisible(true);

            view.setTitle("Reporte de ventas");
        } catch (JRException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnReporteVentasMouseClicked

    private void btnReporteIventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteIventarioMouseClicked
        try {
            
            Conexion conn = Conexion.getInstance();
            
            JasperReport reporte;
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/ReporteInicio/ReporteIventario.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setIconImage(new ImageIcon(getClass().getResource("/Img/Iconoo.png")).getImage());
            view.setVisible(true);

            view.setTitle("Reporte de inventario");
        } catch (JRException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteIventarioMouseClicked

    private void btnProductosMasVendidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMasVendidosMouseClicked
        try {
            Conexion conn = Conexion.getInstance();
            JasperReport reporte;
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/ReporteInicio/ReporteProductosMasVendidos.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setIconImage(new ImageIcon(getClass().getResource("/Img/Iconoo.png")).getImage());
            view.setTitle("Productos mas vendidos");
            
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProductosMasVendidosMouseClicked

    private void rSPanelOpacity6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelOpacity6MouseEntered

    }//GEN-LAST:event_rSPanelOpacity6MouseEntered

    private void rSPanelOpacity6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelOpacity6MouseExited

    }//GEN-LAST:event_rSPanelOpacity6MouseExited

    private void btnGestionarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarUsuariosActionPerformed
        GestionUsuarios gestionUsuarios = new GestionUsuarios(this, true);
        gestionUsuarios.setVisible(true);
    }//GEN-LAST:event_btnGestionarUsuariosActionPerformed

    private void btnAddUsuriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUsuriosActionPerformed
        AddUsuarios addUsuarios = new AddUsuarios(this, true);
        addUsuarios.setVisible(true);
    }//GEN-LAST:event_btnAddUsuriosActionPerformed

    private void btnGestionCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionCategoriasActionPerformed
        GestionCategorias gestionCategorias = new GestionCategorias(this, true);
        gestionCategorias.setVisible(true);
    }//GEN-LAST:event_btnGestionCategoriasActionPerformed

    private void btnAddCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoriasActionPerformed
        AddCategorias addCategorias = new AddCategorias(null, true);
        addCategorias.setVisible(true);
    }//GEN-LAST:event_btnAddCategoriasActionPerformed

    private void btnProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseExited
        this.idProducto = 0;
    }//GEN-LAST:event_btnProductoMouseExited

    private void btnVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseExited
        this.idVenta = 0;
    }//GEN-LAST:event_btnVentasMouseExited

    private void btnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseExited
        this.idCliente = 0;
    }//GEN-LAST:event_btnClientesMouseExited

    private void btnProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseExited
        this.idProveedor = 0;
    }//GEN-LAST:event_btnProveedoresMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelConfiguracion;
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JPanel PanelProductos;
    private javax.swing.JPanel PanelProveedores;
    private javax.swing.JPanel PanelReportes;
    private javax.swing.JPanel PanelVentas;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAddCategorias;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAddUsurios;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAgregarClientes;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAgregarProductos;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAgregarProductos3;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAgregarProductos4;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAgregarVenta;
    private newscomponents.RSPanelOpacity btnClientes;
    private newscomponents.RSPanelOpacity btnConfiguracion;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnEditarClientes;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnEditarProductos;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGestionCategorias;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGestionarUsuarios;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnImprimirFactura;
    private newscomponents.RSPanelOpacity btnIncio;
    private newscomponents.RSPanelOpacity btnProducto;
    private newscomponents.RSPanelOpacity btnProductosMasVendidos;
    private newscomponents.RSPanelOpacity btnProveedores;
    private newscomponents.RSPanelOpacity btnReporteIventario;
    private newscomponents.RSPanelOpacity btnReporteVentas;
    private newscomponents.RSPanelOpacity btnReportes;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnUpdateTabla;
    private newscomponents.RSPanelOpacity btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelVentaYearActual;
    private javax.swing.JLabel lebelReporteYearActual;
    private newscomponents.RSPanelOpacity rSPanelOpacity1;
    private newscomponents.RSPanelOpacity rSPanelOpacity10;
    private newscomponents.RSPanelOpacity rSPanelOpacity12;
    private newscomponents.RSPanelOpacity rSPanelOpacity13;
    private newscomponents.RSPanelOpacity rSPanelOpacity3;
    private newscomponents.RSPanelOpacity rSPanelOpacity4;
    private newscomponents.RSPanelOpacity rSPanelOpacity5;
    private newscomponents.RSPanelOpacity rSPanelOpacity6;
    private newscomponents.RSPanelOpacity rSPanelOpacity7;
    private newscomponents.RSPanelOpacity rSPanelOpacity8;
    private newscomponents.RSPanelOpacity rSPanelOpacity9;
    private RSMaterialComponent.RSTableMetroCustom tableClientes;
    private RSMaterialComponent.RSTableMetroCustom tableProductos;
    private RSMaterialComponent.RSTableMetroCustom tableProveedores;
    private RSMaterialComponent.RSTableMetroCustom tableVentas;
    private RSMaterialComponent.RSTextFieldOne textBuscarClientes;
    private RSMaterialComponent.RSTextFieldOne textBuscarProductoVentas;
    private RSMaterialComponent.RSTextFieldOne textBuscarProductos;
    private RSMaterialComponent.RSTextFieldOne textBuscarProveedores;
    private javax.swing.JLabel textCantidadClientes;
    private javax.swing.JLabel textCantidadProveedores;
    private javax.swing.JLabel textDineroIventario;
    private javax.swing.JLabel textStock;
    private javax.swing.JLabel textTotalVentas;
    // End of variables declaration//GEN-END:variables
}