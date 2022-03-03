
package App;
import Codigo.conexion.*;
import Codigo.nodos.*;
import Codigo.listas.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author JOSE ANDRES COGOLLO HERNANDEZ
 */
public final class Visual extends javax.swing.JFrame {

    int cont = 2;//Variable Cantidad de Intentos de Inicio de secion
    ArrayList TiposP = new ArrayList();//vector para guardar tipos de productos
    
    private Lista_Cajas obj = new Lista_Cajas();
    private Lista_Empleados obj2 = new Lista_Empleados();
    private Lista_VentaCajas obj1 = new Lista_VentaCajas();
    private Lista_Entrega obj3 = new Lista_Entrega();
    private Listas_Clientes obj4 = new Listas_Clientes();
    private Lista_Compras obj9 = new Lista_Compras();
    private Lista_Usuario obj11 = new Lista_Usuario();
    private Tb_bodega obj5 = new Tb_bodega();
    private Tb_Empledos obj6 = new Tb_Empledos();
    private Tb_Entrega obj7 = new Tb_Entrega();
    private Tb_Clien obj8 = new Tb_Clien();
    private Tb_Compras obj10 = new Tb_Compras();
    private Tb_Usuarios obj12 = new Tb_Usuarios();

    //rutas
    public static final String URL = "jdbc:mysql://localhost/bdBodega";
    public static final String USUARIO = "root";
    public static final String CONTRASENA = "#jose2016A";
    
    private String ruta1 = "src\\Ficheros\\Cajas.txt";
    private String ruta2 = "src\\Ficheros\\Productos.txt";
    private String ruta3 = "src\\Ficheros\\Productos_Vendidos.txt";
    private String ruta5 = "src\\Ficheros\\Empleados.txt";
    private String ruta6 = "src\\Ficheros\\Venta.txt";
    private String ruta7 = "src\\Ficheros\\TiposP.txt";

    DefaultCategoryDataset datos1 = new DefaultCategoryDataset();// datos de grafica de Cajas por Precios
    DefaultCategoryDataset datos = new DefaultCategoryDataset();// datos de grafica de Cajas por tipo
    JFreeChart grafica;//grafica de Cajas por tipo   
    JFreeChart grafica1;//grafica de Cajas por Precios

     //formato de numeros
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);

    public Visual() {
             initComponents();
             this.setLocationRelativeTo(null);
              //this.bnbInicio_S.addActionListener(this);
              setTitle("BODEGA");
              obj12.CargarLista(obj11);//carga  a la lista enlazada de Usuarios
              obj6.CargarLista(obj2);//carga los empleados a la lista enlazada
              obj5.CargarLista(obj);//carga las Cajas a la lista enlazada de cajas 
              obj7.CargarLista(obj3);//carga  a la lista enlazada de productos
              obj8.CargarLista(obj4);//carga  a la lista enlazada de Clientes
              obj10.CargarLista(obj9);//carga  a la lista enlazada de Compras
             
              
              Cambiar_Icono();//cambia el icono
              leer_TiP();//lee los archivos de Tipos productos
              Ag_Eti();//agrega valores a las etiquetas
              G_Eti_V();//agrega llos valores a las etiquetas de ventas
              llenar_T_Bod();//llenar tabla de Bodega
              Llenar_T_Ven();//llenar tabla de Ventas
              llenar_T_Asig_V();//llenar tabla de Asignacion de ventas
              Llenar_T_Pro_A();//llenar tabla de Proceso de ventas
              Llenar_T_Clie();//llenar tabla de Clientes
              bnbModifi.setVisible(false);
              this.Menu_P.setVisible(false);
              this.Cerrarsecion.setVisible(false);
              this.Panel_Abono.setVisible(false);
              setVisible(false); 

              try{
                  Image img = ImageIO.read(new File("icon.png"));
                  JFLogin.setIconImage(img);
              }catch(Exception ex){
                  JOptionPane.showMessageDialog(null, "Error con el icono ","Algo salio mal",JOptionPane.INFORMATION_MESSAGE);
              }
              JFLogin.setLocationRelativeTo(null);
              JFLogin.setTitle("Inicio");
              JFLogin.setSize(750, 490);
              JFLogin.setVisible(true);
              simbolo.setDecimalSeparator('.');
              simbolo.setGroupingSeparator(','); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        RegiUsu = new javax.swing.JFrame();
        JFLogin = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        Cerrarsecion = new javax.swing.JButton();
        p_Inicio = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtUsuario1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtContrase1 = new javax.swing.JPasswordField();
        bnbInicio_S = new javax.swing.JButton();
        JlImg = new javax.swing.JLabel();
        Menu_P = new javax.swing.JMenuBar();
        m_arch = new javax.swing.JMenu();
        rbnbabrir = new javax.swing.JRadioButtonMenuItem();
        rbnbC_Adm = new javax.swing.JMenuItem();
        rbnbC_Contre = new javax.swing.JMenuItem();
        rbnbSalir = new javax.swing.JMenuItem();
        Ingre_B1 = new javax.swing.JMenu();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        rbnbAsinar_V = new javax.swing.JRadioButtonMenuItem();
        M_Productos = new javax.swing.JMenu();
        rbnbProductos_A_V = new javax.swing.JRadioButtonMenuItem();
        rbnbProductos_P_V = new javax.swing.JRadioButtonMenuItem();
        rbnbProductos_B = new javax.swing.JRadioButtonMenuItem();
        m_Clientes = new javax.swing.JMenu();
        rbnbVer_Cli = new javax.swing.JRadioButtonMenuItem();
        rbnbAsignar_Cuenta = new javax.swing.JRadioButtonMenuItem();
        m_trab = new javax.swing.JMenu();
        rbnbVer_E = new javax.swing.JRadioButtonMenuItem();
        M_Esta = new javax.swing.JMenu();
        rbnbV_Empl = new javax.swing.JRadioButtonMenuItem();
        rbnbV_Pro = new javax.swing.JRadioButtonMenuItem();
        JfR_caja = new javax.swing.JFrame();
        panel_Reg = new javax.swing.JPanel();
        txtcod = new javax.swing.JTextField();
        txtcant = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jlabel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        JTi_B = new javax.swing.JComboBox<>();
        bnbReg = new javax.swing.JButton();
        bnbLimpiar = new javax.swing.JButton();
        bnbSalir = new javax.swing.JButton();
        bnbModifi = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        Id1 = new javax.swing.JLabel();
        txtNombre_P = new javax.swing.JTextField();
        Fecha_Cj = new com.toedter.calendar.JDateChooser();
        jPanel25 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        JfCambio_Adm = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtC_n_a = new javax.swing.JPasswordField();
        bnbCam_Ad = new javax.swing.JButton();
        JfCambio_Clv = new javax.swing.JFrame();
        p_N_Cont = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtC_n = new javax.swing.JPasswordField();
        txtCont_v = new javax.swing.JPasswordField();
        bnbCambiar_C = new javax.swing.JButton();
        Jfventas = new javax.swing.JFrame();
        jLabel21 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        JlC1 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTotalC1 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jlgananc1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        T_Ventas_C = new javax.swing.JTable();
        HAcerV = new javax.swing.JDialog();
        panel2 = new javax.swing.JPanel();
        txtcod2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bnbVender = new javax.swing.JButton();
        JFMuestra_T_B = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        bnbexi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        T_Busqueda = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        JFR_Empleado = new javax.swing.JFrame();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla_Em = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        JlTotal_Em = new javax.swing.JLabel();
        bnbReportEmp = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        M_Arc = new javax.swing.JMenu();
        rbnbEnviarN = new javax.swing.JRadioButtonMenuItem();
        rbnbSa = new javax.swing.JRadioButtonMenuItem();
        M_E = new javax.swing.JMenu();
        rbnbAsignar_C = new javax.swing.JRadioButtonMenuItem();
        rbnbI_Emp = new javax.swing.JRadioButtonMenuItem();
        rbnbMo_Em = new javax.swing.JRadioButtonMenuItem();
        rbnbElim_E = new javax.swing.JRadioButtonMenuItem();
        R_Empl = new javax.swing.JFrame();
        jPanel29 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        Co = new javax.swing.JTextField();
        identidad1 = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        celular = new javax.swing.JTextField();
        Ingre_Em = new javax.swing.JButton();
        Buscar_Em = new javax.swing.JButton();
        JdFecha = new com.toedter.calendar.JDateChooser();
        jLabel57 = new javax.swing.JLabel();
        Modi_Em = new javax.swing.JButton();
        JfAsignar_V = new javax.swing.JFrame();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        T_Asid_V = new javax.swing.JTable();
        bnbAsignar_V = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCod_P = new javax.swing.JTextField();
        JcEmpleadosV = new javax.swing.JComboBox<>();
        SpinnerCantAsig = new javax.swing.JSpinner();
        JfProductos_V = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        T_Productos_V = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        bnbFiltro = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mAdminPro = new javax.swing.JMenu();
        rbnbPromo = new javax.swing.JRadioButtonMenuItem();
        Jdasignar_Clie = new javax.swing.JDialog();
        jPanel15 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtNom_cli = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        JCForma_DeP = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        txtcelular_Cli = new javax.swing.JTextField();
        txtDirecion = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        Fecha_Vent = new com.toedter.calendar.JDateChooser();
        jLabel62 = new javax.swing.JLabel();
        SpinnerCant = new javax.swing.JSpinner();
        BnbAsignar_C = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        txtCod_Venta = new javax.swing.JTextField();
        JcEmpleados = new javax.swing.JComboBox<>();
        JcCodTique = new javax.swing.JComboBox<>();
        JdEliminar_E = new javax.swing.JDialog();
        panel3 = new javax.swing.JPanel();
        txtCod_E_E = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bnbEliminar_E = new javax.swing.JButton();
        JfClientes = new javax.swing.JFrame();
        jPanel19 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        T_Clientes = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        JlTotal_Clien = new javax.swing.JLabel();
        Panel_Abono = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtCo_Venta = new javax.swing.JTextField();
        txtAbono = new javax.swing.JTextField();
        bnbAbonar = new javax.swing.JButton();
        JdIngresarT = new javax.swing.JDialog();
        panel4 = new javax.swing.JPanel();
        txtTipoP = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        bnbIngTipo = new javax.swing.JButton();
        JdPromoc = new javax.swing.JDialog();
        panelPromo = new javax.swing.JPanel();
        bnbagreP = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        Jltipos = new javax.swing.JComboBox<>();
        JdCambioClvE = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        txtContEmp = new javax.swing.JPasswordField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        bnbCamClvE = new javax.swing.JButton();
        p_p = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jbTotalV = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTotalC = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JlC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        T_Bodega = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jlgananc = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        JTotal_Ganancia_B = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        JTotal_Ganancias_V = new javax.swing.JLabel();
        bnbLimpia_Cero = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        m_Guar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem5 = new javax.swing.JRadioButtonMenuItem();
        rbnbAbrir = new javax.swing.JRadioButtonMenuItem();
        m_Adm_B = new javax.swing.JMenu();
        rbnbAgregar = new javax.swing.JRadioButtonMenuItem();
        rbnbModi = new javax.swing.JRadioButtonMenuItem();
        rbnbVender = new javax.swing.JRadioButtonMenuItem();
        rbnbEliminar = new javax.swing.JRadioButtonMenuItem();
        Ingre_B = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        m_Estadistica = new javax.swing.JMenu();
        rbnbG_V = new javax.swing.JRadioButtonMenuItem();
        rbnbGp_V = new javax.swing.JRadioButtonMenuItem();
        m_Cerrar = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        rmIngrTp = new javax.swing.JRadioButtonMenuItem();

        javax.swing.GroupLayout RegiUsuLayout = new javax.swing.GroupLayout(RegiUsu.getContentPane());
        RegiUsu.getContentPane().setLayout(RegiUsuLayout);
        RegiUsuLayout.setHorizontalGroup(
            RegiUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        RegiUsuLayout.setVerticalGroup(
            RegiUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        JFLogin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Cerrarsecion.setBackground(new java.awt.Color(255, 255, 153));
        Cerrarsecion.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Cerrarsecion.setForeground(new java.awt.Color(0, 102, 51));
        Cerrarsecion.setText("Cerrar secion");
        Cerrarsecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarsecionActionPerformed(evt);
            }
        });

        p_Inicio.setBackground(new java.awt.Color(0, 102, 51));
        p_Inicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p_InicioKeyPressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 153));
        jLabel29.setText("Iniciar Secion");

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 153));
        jLabel30.setText("Usuario");

        txtUsuario1.setBackground(new java.awt.Color(255, 255, 153));
        txtUsuario1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtUsuario1.setForeground(new java.awt.Color(0, 102, 51));
        txtUsuario1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel31.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 153));
        jLabel31.setText("Contraseña");

        txtContrase1.setBackground(new java.awt.Color(255, 255, 153));
        txtContrase1.setForeground(new java.awt.Color(0, 102, 51));
        txtContrase1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        bnbInicio_S.setBackground(new java.awt.Color(255, 255, 153));
        bnbInicio_S.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        bnbInicio_S.setForeground(new java.awt.Color(0, 102, 51));
        bnbInicio_S.setText("Iniciar");
        bnbInicio_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbInicio_SActionPerformed(evt);
            }
        });
        bnbInicio_S.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bnbInicio_SKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bnbInicio_SKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout p_InicioLayout = new javax.swing.GroupLayout(p_Inicio);
        p_Inicio.setLayout(p_InicioLayout);
        p_InicioLayout.setHorizontalGroup(
            p_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_InicioLayout.createSequentialGroup()
                .addGroup(p_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_InicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(p_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(p_InicioLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel29))
                            .addComponent(txtUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(txtContrase1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(p_InicioLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(bnbInicio_S, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_InicioLayout.setVerticalGroup(
            p_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_InicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bnbInicio_S, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JlImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(JlImg, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cerrarsecion)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(JlImg, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(p_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)))
                .addComponent(Cerrarsecion, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Menu_P.setBackground(new java.awt.Color(255, 255, 153));
        Menu_P.setForeground(new java.awt.Color(0, 102, 51));

        m_arch.setBackground(new java.awt.Color(255, 255, 153));
        m_arch.setForeground(new java.awt.Color(0, 102, 51));
        m_arch.setText("Archivo");
        m_arch.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        rbnbabrir.setBackground(new java.awt.Color(255, 255, 153));
        rbnbabrir.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbabrir.setForeground(new java.awt.Color(0, 102, 51));
        rbnbabrir.setSelected(true);
        rbnbabrir.setText("Abrir");
        m_arch.add(rbnbabrir);

        rbnbC_Adm.setBackground(new java.awt.Color(255, 255, 153));
        rbnbC_Adm.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbC_Adm.setForeground(new java.awt.Color(0, 102, 51));
        rbnbC_Adm.setText("Cambiar Adm...");
        rbnbC_Adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbC_AdmActionPerformed(evt);
            }
        });
        m_arch.add(rbnbC_Adm);

        rbnbC_Contre.setBackground(new java.awt.Color(255, 255, 153));
        rbnbC_Contre.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbC_Contre.setForeground(new java.awt.Color(0, 102, 51));
        rbnbC_Contre.setText("Cambiar Contr...");
        rbnbC_Contre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbC_ContreActionPerformed(evt);
            }
        });
        m_arch.add(rbnbC_Contre);

        rbnbSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        rbnbSalir.setBackground(new java.awt.Color(255, 255, 153));
        rbnbSalir.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbSalir.setForeground(new java.awt.Color(0, 102, 51));
        rbnbSalir.setText("Salir");
        rbnbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbSalirActionPerformed(evt);
            }
        });
        m_arch.add(rbnbSalir);

        Menu_P.add(m_arch);

        Ingre_B1.setBackground(new java.awt.Color(255, 255, 153));
        Ingre_B1.setForeground(new java.awt.Color(0, 102, 51));
        Ingre_B1.setText("Bodega");
        Ingre_B1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Ingre_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ingre_B1MouseClicked(evt);
            }
        });
        Ingre_B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingre_B1ActionPerformed(evt);
            }
        });

        jRadioButtonMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jRadioButtonMenuItem2.setBackground(new java.awt.Color(255, 255, 153));
        jRadioButtonMenuItem2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jRadioButtonMenuItem2.setForeground(new java.awt.Color(0, 102, 51));
        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("Ingresar a la bodega");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        Ingre_B1.add(jRadioButtonMenuItem2);

        rbnbAsinar_V.setBackground(new java.awt.Color(255, 255, 153));
        rbnbAsinar_V.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbAsinar_V.setForeground(new java.awt.Color(0, 102, 51));
        rbnbAsinar_V.setSelected(true);
        rbnbAsinar_V.setText("Asignar productos a vendedores ");
        rbnbAsinar_V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbAsinar_VActionPerformed(evt);
            }
        });
        Ingre_B1.add(rbnbAsinar_V);

        Menu_P.add(Ingre_B1);

        M_Productos.setBackground(new java.awt.Color(255, 255, 153));
        M_Productos.setForeground(new java.awt.Color(0, 102, 51));
        M_Productos.setText("Productos");
        M_Productos.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N

        rbnbProductos_A_V.setBackground(new java.awt.Color(255, 255, 153));
        rbnbProductos_A_V.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbProductos_A_V.setForeground(new java.awt.Color(0, 102, 51));
        rbnbProductos_A_V.setSelected(true);
        rbnbProductos_A_V.setText("Productos Asignados a vender");
        rbnbProductos_A_V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbProductos_A_VActionPerformed(evt);
            }
        });
        M_Productos.add(rbnbProductos_A_V);

        rbnbProductos_P_V.setBackground(new java.awt.Color(255, 255, 153));
        rbnbProductos_P_V.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbProductos_P_V.setForeground(new java.awt.Color(0, 102, 51));
        rbnbProductos_P_V.setSelected(true);
        rbnbProductos_P_V.setText("Productos En Proceso Ventas");
        M_Productos.add(rbnbProductos_P_V);

        rbnbProductos_B.setBackground(new java.awt.Color(255, 255, 153));
        rbnbProductos_B.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbProductos_B.setForeground(new java.awt.Color(0, 102, 51));
        rbnbProductos_B.setSelected(true);
        rbnbProductos_B.setText("Productos En Bodega");
        rbnbProductos_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbProductos_BActionPerformed(evt);
            }
        });
        M_Productos.add(rbnbProductos_B);

        Menu_P.add(M_Productos);

        m_Clientes.setBackground(new java.awt.Color(255, 255, 153));
        m_Clientes.setForeground(new java.awt.Color(0, 102, 51));
        m_Clientes.setText("Clientes");
        m_Clientes.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N

        rbnbVer_Cli.setBackground(new java.awt.Color(255, 255, 153));
        rbnbVer_Cli.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbVer_Cli.setForeground(new java.awt.Color(0, 102, 51));
        rbnbVer_Cli.setSelected(true);
        rbnbVer_Cli.setText("Ver Clientes");
        rbnbVer_Cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbVer_CliActionPerformed(evt);
            }
        });
        m_Clientes.add(rbnbVer_Cli);

        rbnbAsignar_Cuenta.setBackground(new java.awt.Color(255, 255, 153));
        rbnbAsignar_Cuenta.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbAsignar_Cuenta.setForeground(new java.awt.Color(0, 102, 51));
        rbnbAsignar_Cuenta.setSelected(true);
        rbnbAsignar_Cuenta.setText("Asignar Cuota");
        rbnbAsignar_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbAsignar_CuentaActionPerformed(evt);
            }
        });
        m_Clientes.add(rbnbAsignar_Cuenta);

        Menu_P.add(m_Clientes);

        m_trab.setBackground(new java.awt.Color(255, 255, 153));
        m_trab.setForeground(new java.awt.Color(0, 102, 51));
        m_trab.setText("Empleados");
        m_trab.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        m_trab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_trabMouseClicked(evt);
            }
        });
        m_trab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_trabActionPerformed(evt);
            }
        });

        rbnbVer_E.setBackground(new java.awt.Color(255, 255, 153));
        rbnbVer_E.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbVer_E.setForeground(new java.awt.Color(0, 102, 51));
        rbnbVer_E.setSelected(true);
        rbnbVer_E.setText("Ver Empleados");
        rbnbVer_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbVer_EActionPerformed(evt);
            }
        });
        m_trab.add(rbnbVer_E);

        M_Esta.setBackground(new java.awt.Color(255, 255, 153));
        M_Esta.setForeground(new java.awt.Color(0, 102, 51));
        M_Esta.setText("Estadisticas");
        M_Esta.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        rbnbV_Empl.setBackground(new java.awt.Color(255, 255, 153));
        rbnbV_Empl.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbV_Empl.setForeground(new java.awt.Color(0, 102, 51));
        rbnbV_Empl.setSelected(true);
        rbnbV_Empl.setText("G/Ventas Por Empleado");
        rbnbV_Empl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbV_EmplActionPerformed(evt);
            }
        });
        M_Esta.add(rbnbV_Empl);

        rbnbV_Pro.setBackground(new java.awt.Color(255, 255, 153));
        rbnbV_Pro.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbV_Pro.setForeground(new java.awt.Color(0, 102, 51));
        rbnbV_Pro.setSelected(true);
        rbnbV_Pro.setText("G/Ventas Por Producto");
        rbnbV_Pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbV_ProActionPerformed(evt);
            }
        });
        M_Esta.add(rbnbV_Pro);

        m_trab.add(M_Esta);

        Menu_P.add(m_trab);

        JFLogin.setJMenuBar(Menu_P);

        javax.swing.GroupLayout JFLoginLayout = new javax.swing.GroupLayout(JFLogin.getContentPane());
        JFLogin.getContentPane().setLayout(JFLoginLayout);
        JFLoginLayout.setHorizontalGroup(
            JFLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JFLoginLayout.setVerticalGroup(
            JFLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_Reg.setBackground(new java.awt.Color(0, 102, 51));
        panel_Reg.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 1, true), "Detalles de la Caja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 13), new java.awt.Color(255, 255, 153))); // NOI18N

        txtcod.setBackground(new java.awt.Color(255, 255, 153));
        txtcod.setForeground(new java.awt.Color(0, 102, 51));
        txtcod.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodKeyTyped(evt);
            }
        });

        txtcant.setBackground(new java.awt.Color(255, 255, 153));
        txtcant.setForeground(new java.awt.Color(0, 102, 51));
        txtcant.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtcant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantKeyTyped(evt);
            }
        });

        txtPrecio.setBackground(new java.awt.Color(255, 255, 153));
        txtPrecio.setForeground(new java.awt.Color(0, 102, 51));
        txtPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 153));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setBackground(new java.awt.Color(255, 255, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setText("Codigo");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 153));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jlabel.setBackground(new java.awt.Color(255, 255, 153));
        jlabel.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jlabel.setForeground(new java.awt.Color(0, 102, 51));
        jlabel.setText("Cantidad de Unidades");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 153));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("Precio de Compra");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 153));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel6.setBackground(new java.awt.Color(255, 255, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 51));
        jLabel6.setText("Tipo de Producto");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTi_B.setBackground(new java.awt.Color(255, 255, 153));
        JTi_B.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        JTi_B.setForeground(new java.awt.Color(0, 102, 51));
        JTi_B.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        JTi_B.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        JTi_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTi_BActionPerformed(evt);
            }
        });

        bnbReg.setBackground(new java.awt.Color(255, 255, 153));
        bnbReg.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbReg.setForeground(new java.awt.Color(0, 102, 51));
        bnbReg.setText("Agregar");
        bnbReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbRegActionPerformed(evt);
            }
        });

        bnbLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        bnbLimpiar.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbLimpiar.setForeground(new java.awt.Color(0, 102, 51));
        bnbLimpiar.setText("Caja Nueva");
        bnbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbLimpiarActionPerformed(evt);
            }
        });

        bnbSalir.setBackground(new java.awt.Color(255, 255, 153));
        bnbSalir.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        bnbSalir.setForeground(new java.awt.Color(0, 102, 51));
        bnbSalir.setText("Cerrar Registro");
        bnbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbSalirActionPerformed(evt);
            }
        });

        bnbModifi.setBackground(new java.awt.Color(255, 255, 153));
        bnbModifi.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbModifi.setForeground(new java.awt.Color(0, 102, 51));
        bnbModifi.setText("Modificar");
        bnbModifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbModifiActionPerformed(evt);
            }
        });

        jPanel27.setBackground(new java.awt.Color(255, 255, 153));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Id1.setBackground(new java.awt.Color(255, 255, 153));
        Id1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Id1.setForeground(new java.awt.Color(0, 102, 51));
        Id1.setText("Descripcion De Producto");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Id1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Id1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtNombre_P.setBackground(new java.awt.Color(255, 255, 153));
        txtNombre_P.setForeground(new java.awt.Color(0, 102, 51));
        txtNombre_P.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre_P.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtNombre_P.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        Fecha_Cj.setBackground(new java.awt.Color(255, 255, 153));
        Fecha_Cj.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Fecha_Cj.setForeground(new java.awt.Color(0, 102, 51));
        Fecha_Cj.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        jPanel25.setBackground(new java.awt.Color(255, 255, 153));
        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel61.setBackground(new java.awt.Color(255, 255, 153));
        jLabel61.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 102, 51));
        jLabel61.setText("Fecha");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel61))
        );

        javax.swing.GroupLayout panel_RegLayout = new javax.swing.GroupLayout(panel_Reg);
        panel_Reg.setLayout(panel_RegLayout);
        panel_RegLayout.setHorizontalGroup(
            panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_RegLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RegLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtNombre_P, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel_RegLayout.createSequentialGroup()
                .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_RegLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RegLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_RegLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bnbLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bnbSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bnbReg, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bnbModifi, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))
                    .addGroup(panel_RegLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fecha_Cj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTi_B, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panel_RegLayout.setVerticalGroup(
            panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_RegLayout.createSequentialGroup()
                        .addComponent(bnbReg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bnbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bnbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bnbModifi, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_RegLayout.createSequentialGroup()
                        .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_RegLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre_P, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTi_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Fecha_Cj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JfR_cajaLayout = new javax.swing.GroupLayout(JfR_caja.getContentPane());
        JfR_caja.getContentPane().setLayout(JfR_cajaLayout);
        JfR_cajaLayout.setHorizontalGroup(
            JfR_cajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfR_cajaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JfR_cajaLayout.setVerticalGroup(
            JfR_cajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Reg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));

        jLabel32.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 153));
        jLabel32.setText("Cambio De Administrador");

        jLabel33.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 153));
        jLabel33.setText("Nombre");

        jLabel34.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 153));
        jLabel34.setText("Identidad");

        jLabel35.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 153));
        jLabel35.setText("Contraseña");

        txtNom.setBackground(new java.awt.Color(255, 255, 153));
        txtNom.setForeground(new java.awt.Color(0, 102, 51));

        txtId.setBackground(new java.awt.Color(255, 255, 153));
        txtId.setForeground(new java.awt.Color(0, 102, 51));
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        txtC_n_a.setBackground(new java.awt.Color(255, 255, 153));
        txtC_n_a.setForeground(new java.awt.Color(0, 102, 51));

        bnbCam_Ad.setBackground(new java.awt.Color(255, 255, 153));
        bnbCam_Ad.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbCam_Ad.setForeground(new java.awt.Color(0, 102, 51));
        bnbCam_Ad.setText("Cambiar");
        bnbCam_Ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbCam_AdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtC_n_a, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(bnbCam_Ad)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(30, 30, 30)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addGap(4, 4, 4)
                .addComponent(txtC_n_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bnbCam_Ad)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JfCambio_AdmLayout = new javax.swing.GroupLayout(JfCambio_Adm.getContentPane());
        JfCambio_Adm.getContentPane().setLayout(JfCambio_AdmLayout);
        JfCambio_AdmLayout.setHorizontalGroup(
            JfCambio_AdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JfCambio_AdmLayout.setVerticalGroup(
            JfCambio_AdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        p_N_Cont.setBackground(new java.awt.Color(0, 102, 51));

        jLabel36.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 153));
        jLabel36.setText("Contraseña");

        jLabel37.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 153));
        jLabel37.setText("Contraseña Nueva");

        txtC_n.setBackground(new java.awt.Color(255, 255, 153));
        txtC_n.setForeground(new java.awt.Color(0, 102, 51));

        txtCont_v.setBackground(new java.awt.Color(255, 255, 153));
        txtCont_v.setForeground(new java.awt.Color(0, 102, 51));

        bnbCambiar_C.setBackground(new java.awt.Color(255, 255, 153));
        bnbCambiar_C.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbCambiar_C.setForeground(new java.awt.Color(0, 102, 51));
        bnbCambiar_C.setText("Cambiar");
        bnbCambiar_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbCambiar_CActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_N_ContLayout = new javax.swing.GroupLayout(p_N_Cont);
        p_N_Cont.setLayout(p_N_ContLayout);
        p_N_ContLayout.setHorizontalGroup(
            p_N_ContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_N_ContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_N_ContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_N_ContLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(bnbCambiar_C, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(txtC_n, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCont_v, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        p_N_ContLayout.setVerticalGroup(
            p_N_ContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_N_ContLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCont_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtC_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bnbCambiar_C, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JfCambio_ClvLayout = new javax.swing.GroupLayout(JfCambio_Clv.getContentPane());
        JfCambio_Clv.getContentPane().setLayout(JfCambio_ClvLayout);
        JfCambio_ClvLayout.setHorizontalGroup(
            JfCambio_ClvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfCambio_ClvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_N_Cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JfCambio_ClvLayout.setVerticalGroup(
            JfCambio_ClvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfCambio_ClvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_N_Cont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel21.setBackground(new java.awt.Color(255, 255, 153));
        jLabel21.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 51));
        jLabel21.setText("CAJAS VENDIDAS");
        jLabel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel18.setBackground(new java.awt.Color(255, 255, 153));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 2, true));

        jPanel22.setBackground(new java.awt.Color(0, 102, 51));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel22.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 153));
        jLabel22.setText("Total de CAJAS");

        JlC1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        JlC1.setForeground(new java.awt.Color(255, 255, 153));
        JlC1.setText("0");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(JlC1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(JlC1)))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 153));
        jPanel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 2, true));

        jPanel24.setBackground(new java.awt.Color(0, 102, 51));
        jPanel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel23.setBackground(new java.awt.Color(255, 255, 153));
        jLabel23.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 153));
        jLabel23.setText("Precio T.Compra: ");

        jTotalC1.setBackground(new java.awt.Color(255, 255, 153));
        jTotalC1.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jTotalC1.setForeground(new java.awt.Color(255, 255, 153));
        jTotalC1.setText("000000");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTotalC1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTotalC1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel26.setBackground(new java.awt.Color(0, 102, 51));
        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel25.setBackground(new java.awt.Color(255, 255, 153));
        jLabel25.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 153));
        jLabel25.setText("Ganancias: ");

        jlgananc1.setBackground(new java.awt.Color(255, 255, 153));
        jlgananc1.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jlgananc1.setForeground(new java.awt.Color(255, 255, 153));
        jlgananc1.setText("000000");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlgananc1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jlgananc1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        T_Ventas_C.setBackground(new java.awt.Color(255, 255, 153));
        T_Ventas_C.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        T_Ventas_C.setForeground(new java.awt.Color(0, 102, 51));
        T_Ventas_C.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(T_Ventas_C);

        javax.swing.GroupLayout JfventasLayout = new javax.swing.GroupLayout(Jfventas.getContentPane());
        Jfventas.getContentPane().setLayout(JfventasLayout);
        JfventasLayout.setHorizontalGroup(
            JfventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfventasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(JfventasLayout.createSequentialGroup()
                .addGroup(JfventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JfventasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        JfventasLayout.setVerticalGroup(
            JfventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JfventasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(JfventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JfventasLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JfventasLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );

        panel2.setBackground(new java.awt.Color(0, 102, 51));
        panel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 3, true));
        panel2.setForeground(new java.awt.Color(255, 255, 153));

        txtcod2.setBackground(new java.awt.Color(255, 255, 153));
        txtcod2.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        txtcod2.setForeground(new java.awt.Color(0, 102, 51));
        txtcod2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcod2KeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 153));
        jLabel9.setText("NOTA:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 153));
        jLabel10.setText("Ingrese el codigo a vender");

        bnbVender.setBackground(new java.awt.Color(255, 255, 153));
        bnbVender.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbVender.setForeground(new java.awt.Color(0, 102, 51));
        bnbVender.setText("Vender");
        bnbVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbVenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcod2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bnbVender))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtcod2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnbVender)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout HAcerVLayout = new javax.swing.GroupLayout(HAcerV.getContentPane());
        HAcerV.getContentPane().setLayout(HAcerVLayout);
        HAcerVLayout.setHorizontalGroup(
            HAcerVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        HAcerVLayout.setVerticalGroup(
            HAcerVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bnbexi.setBackground(new java.awt.Color(255, 255, 153));
        bnbexi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        bnbexi.setForeground(new java.awt.Color(0, 102, 51));
        bnbexi.setText("Salir");
        bnbexi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbexiActionPerformed(evt);
            }
        });

        T_Busqueda.setBackground(new java.awt.Color(255, 255, 153));
        T_Busqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 2, true));
        T_Busqueda.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        T_Busqueda.setForeground(new java.awt.Color(0, 102, 51));
        T_Busqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(T_Busqueda);

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 153));
        jLabel17.setText("LISTA DE CAJAS CON PROMOCION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 497, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bnbexi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(478, 478, 478))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bnbexi)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout JFMuestra_T_BLayout = new javax.swing.GroupLayout(JFMuestra_T_B.getContentPane());
        JFMuestra_T_B.getContentPane().setLayout(JFMuestra_T_BLayout);
        JFMuestra_T_BLayout.setHorizontalGroup(
            JFMuestra_T_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFMuestra_T_BLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JFMuestra_T_BLayout.setVerticalGroup(
            JFMuestra_T_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JFMuestra_T_BLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel28.setBackground(new java.awt.Color(0, 102, 51));

        tabla_Em.setBackground(new java.awt.Color(255, 255, 153));
        tabla_Em.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tabla_Em.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        tabla_Em.setForeground(new java.awt.Color(0, 102, 51));
        tabla_Em.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_Em.setColumnSelectionAllowed(true);
        tabla_Em.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane5.setViewportView(tabla_Em);
        tabla_Em.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel21.setBackground(new java.awt.Color(255, 255, 153));
        jPanel21.setForeground(new java.awt.Color(0, 102, 51));

        jLabel51.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 51));
        jLabel51.setText("Total de empleados :");

        JlTotal_Em.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        JlTotal_Em.setForeground(new java.awt.Color(0, 102, 51));
        JlTotal_Em.setText("0");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlTotal_Em, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addComponent(JlTotal_Em))
        );

        bnbReportEmp.setBackground(new java.awt.Color(255, 255, 153));
        bnbReportEmp.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        bnbReportEmp.setForeground(new java.awt.Color(0, 102, 51));
        bnbReportEmp.setText("Reporte");
        bnbReportEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbReportEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bnbReportEmp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnbReportEmp)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        M_Arc.setBackground(new java.awt.Color(255, 255, 153));
        M_Arc.setForeground(new java.awt.Color(0, 102, 51));
        M_Arc.setText("Archivo");
        M_Arc.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        rbnbEnviarN.setBackground(new java.awt.Color(255, 255, 153));
        rbnbEnviarN.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbEnviarN.setForeground(new java.awt.Color(0, 102, 51));
        rbnbEnviarN.setSelected(true);
        rbnbEnviarN.setText("Enviar Nomina");
        rbnbEnviarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbEnviarNActionPerformed(evt);
            }
        });
        M_Arc.add(rbnbEnviarN);

        rbnbSa.setBackground(new java.awt.Color(255, 255, 153));
        rbnbSa.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbSa.setForeground(new java.awt.Color(0, 102, 51));
        rbnbSa.setSelected(true);
        rbnbSa.setText("Salir");
        rbnbSa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbSaActionPerformed(evt);
            }
        });
        M_Arc.add(rbnbSa);

        jMenuBar2.add(M_Arc);

        M_E.setBackground(new java.awt.Color(255, 255, 153));
        M_E.setForeground(new java.awt.Color(0, 102, 51));
        M_E.setText("Empleados");
        M_E.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N

        rbnbAsignar_C.setBackground(new java.awt.Color(255, 255, 153));
        rbnbAsignar_C.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbAsignar_C.setForeground(new java.awt.Color(0, 102, 51));
        rbnbAsignar_C.setSelected(true);
        rbnbAsignar_C.setText("Asignar Venta");
        rbnbAsignar_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbAsignar_CActionPerformed(evt);
            }
        });
        M_E.add(rbnbAsignar_C);

        rbnbI_Emp.setBackground(new java.awt.Color(255, 255, 153));
        rbnbI_Emp.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbI_Emp.setForeground(new java.awt.Color(0, 102, 51));
        rbnbI_Emp.setSelected(true);
        rbnbI_Emp.setText("Ingresar Empleado");
        rbnbI_Emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbI_EmpActionPerformed(evt);
            }
        });
        M_E.add(rbnbI_Emp);

        rbnbMo_Em.setBackground(new java.awt.Color(255, 255, 153));
        rbnbMo_Em.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbMo_Em.setForeground(new java.awt.Color(0, 102, 51));
        rbnbMo_Em.setSelected(true);
        rbnbMo_Em.setText("Modificar Empleado");
        rbnbMo_Em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbMo_EmActionPerformed(evt);
            }
        });
        M_E.add(rbnbMo_Em);

        rbnbElim_E.setBackground(new java.awt.Color(255, 255, 153));
        rbnbElim_E.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbElim_E.setForeground(new java.awt.Color(0, 102, 51));
        rbnbElim_E.setSelected(true);
        rbnbElim_E.setText("Eliminar Empleado");
        rbnbElim_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbElim_EActionPerformed(evt);
            }
        });
        M_E.add(rbnbElim_E);

        jMenuBar2.add(M_E);

        JFR_Empleado.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout JFR_EmpleadoLayout = new javax.swing.GroupLayout(JFR_Empleado.getContentPane());
        JFR_Empleado.getContentPane().setLayout(JFR_EmpleadoLayout);
        JFR_EmpleadoLayout.setHorizontalGroup(
            JFR_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JFR_EmpleadoLayout.setVerticalGroup(
            JFR_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFR_EmpleadoLayout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(0, 102, 51));

        jLabel43.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 153));
        jLabel43.setText("EMPLEADO");

        jLabel38.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 153));
        jLabel38.setText("Nombre");

        jLabel39.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 153));
        jLabel39.setText("Identificacion");

        jLabel40.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 153));
        jLabel40.setText("Codigo");

        jLabel41.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 153));
        jLabel41.setText("Correo/mail");

        jLabel42.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 153));
        jLabel42.setText("N° Celular");

        nombre.setBackground(new java.awt.Color(255, 255, 153));
        nombre.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        nombre.setForeground(new java.awt.Color(0, 102, 51));
        nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        Co.setBackground(new java.awt.Color(255, 255, 153));
        Co.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        Co.setForeground(new java.awt.Color(0, 102, 51));
        Co.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Co.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CoKeyTyped(evt);
            }
        });

        identidad1.setBackground(new java.awt.Color(255, 255, 153));
        identidad1.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        identidad1.setForeground(new java.awt.Color(0, 102, 51));
        identidad1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        identidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                identidad1KeyTyped(evt);
            }
        });

        correo.setBackground(new java.awt.Color(255, 255, 153));
        correo.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        correo.setForeground(new java.awt.Color(0, 102, 51));
        correo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        celular.setBackground(new java.awt.Color(255, 255, 153));
        celular.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        celular.setForeground(new java.awt.Color(0, 102, 51));
        celular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                celularKeyTyped(evt);
            }
        });

        Ingre_Em.setBackground(new java.awt.Color(255, 255, 153));
        Ingre_Em.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        Ingre_Em.setForeground(new java.awt.Color(0, 102, 51));
        Ingre_Em.setText("Ingresar");
        Ingre_Em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingre_EmActionPerformed(evt);
            }
        });

        Buscar_Em.setBackground(new java.awt.Color(255, 255, 153));
        Buscar_Em.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        Buscar_Em.setForeground(new java.awt.Color(0, 102, 51));
        Buscar_Em.setText("Buscar");
        Buscar_Em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_EmActionPerformed(evt);
            }
        });

        JdFecha.setBackground(new java.awt.Color(255, 255, 153));
        JdFecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        JdFecha.setForeground(new java.awt.Color(0, 102, 51));
        JdFecha.setDateFormatString("yyyy/MM/dd HH:mm:ss");
        JdFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel57.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 153));
        jLabel57.setText("Fecha ");

        Modi_Em.setBackground(new java.awt.Color(255, 255, 153));
        Modi_Em.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        Modi_Em.setForeground(new java.awt.Color(0, 102, 51));
        Modi_Em.setText("Modificar");
        Modi_Em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modi_EmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel29Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Co, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                        .addComponent(correo, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(identidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(JdFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(celular, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Modi_Em, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Ingre_Em, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Buscar_Em, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addGap(13, 13, 13)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Co, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(Ingre_Em, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(Buscar_Em, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Modi_Em, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout R_EmplLayout = new javax.swing.GroupLayout(R_Empl.getContentPane());
        R_Empl.getContentPane().setLayout(R_EmplLayout);
        R_EmplLayout.setHorizontalGroup(
            R_EmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(R_EmplLayout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        R_EmplLayout.setVerticalGroup(
            R_EmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(0, 102, 51));

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 153));
        jLabel14.setText("Codigo tiquete de entrega");

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 153));

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 153));
        jLabel16.setText("Codigo Vendedor");

        T_Asid_V.setBackground(new java.awt.Color(255, 255, 153));
        T_Asid_V.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        T_Asid_V.setForeground(new java.awt.Color(0, 102, 51));
        T_Asid_V.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_Asid_V.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        T_Asid_V.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_Asid_VMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(T_Asid_V);

        bnbAsignar_V.setBackground(new java.awt.Color(255, 255, 153));
        bnbAsignar_V.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        bnbAsignar_V.setForeground(new java.awt.Color(0, 102, 51));
        bnbAsignar_V.setText("Asignar");
        bnbAsignar_V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbAsignar_VActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 153));
        jLabel18.setText("CAJAS EN BODEGA");

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 153));
        jLabel19.setText("Cantidad ");

        txtCod_P.setBackground(new java.awt.Color(255, 255, 153));
        txtCod_P.setForeground(new java.awt.Color(0, 102, 51));
        txtCod_P.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_PKeyTyped(evt);
            }
        });

        JcEmpleadosV.setBackground(new java.awt.Color(255, 255, 153));
        JcEmpleadosV.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        JcEmpleadosV.setForeground(new java.awt.Color(0, 102, 51));

        SpinnerCantAsig.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        SpinnerCantAsig.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(SpinnerCantAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(bnbAsignar_V))
                            .addComponent(JcEmpleadosV, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCod_P, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcEmpleadosV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCod_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(SpinnerCantAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(44, 44, 44)
                        .addComponent(bnbAsignar_V)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout JfAsignar_VLayout = new javax.swing.GroupLayout(JfAsignar_V.getContentPane());
        JfAsignar_V.getContentPane().setLayout(JfAsignar_VLayout);
        JfAsignar_VLayout.setHorizontalGroup(
            JfAsignar_VLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfAsignar_VLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JfAsignar_VLayout.setVerticalGroup(
            JfAsignar_VLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfAsignar_VLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(0, 102, 51));

        T_Productos_V.setBackground(new java.awt.Color(255, 255, 153));
        T_Productos_V.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        T_Productos_V.setForeground(new java.awt.Color(0, 102, 51));
        T_Productos_V.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(T_Productos_V);

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 153));
        jLabel11.setText("PRODUCTOS ASIGNADOS A VENDEDORES");

        bnbFiltro.setBackground(new java.awt.Color(255, 255, 153));
        bnbFiltro.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbFiltro.setForeground(new java.awt.Color(0, 102, 51));
        bnbFiltro.setText("Filtrar");
        bnbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1079, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bnbFiltro)
                .addGap(34, 34, 34))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(bnbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jMenu1.setForeground(new java.awt.Color(0, 102, 51));
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jMenuBar3.add(jMenu1);

        mAdminPro.setForeground(new java.awt.Color(0, 102, 51));
        mAdminPro.setText("Admin.. Productos");
        mAdminPro.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        rbnbPromo.setBackground(new java.awt.Color(255, 255, 153));
        rbnbPromo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbPromo.setForeground(new java.awt.Color(0, 102, 51));
        rbnbPromo.setSelected(true);
        rbnbPromo.setText("Agregar Promocion");
        rbnbPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbPromoActionPerformed(evt);
            }
        });
        mAdminPro.add(rbnbPromo);

        jMenuBar3.add(mAdminPro);

        JfProductos_V.setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout JfProductos_VLayout = new javax.swing.GroupLayout(JfProductos_V.getContentPane());
        JfProductos_V.getContentPane().setLayout(JfProductos_VLayout);
        JfProductos_VLayout.setHorizontalGroup(
            JfProductos_VLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JfProductos_VLayout.setVerticalGroup(
            JfProductos_VLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfProductos_VLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(0, 102, 51));
        jPanel15.setForeground(new java.awt.Color(255, 255, 153));

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 153));
        jLabel20.setText("Codigo del Vendedor");

        jLabel27.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 153));
        jLabel27.setText("Nombre del Cliente ");

        txtNom_cli.setBackground(new java.awt.Color(255, 255, 153));
        txtNom_cli.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtNom_cli.setForeground(new java.awt.Color(0, 102, 51));
        txtNom_cli.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel47.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 153));
        jLabel47.setText("Codigo de Cartulina");

        jPanel16.setBackground(new java.awt.Color(0, 102, 51));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(255, 255, 153))); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 153));
        jLabel46.setText("Cantidad");

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 153));
        jLabel28.setText("Forma de Pago");

        JCForma_DeP.setBackground(new java.awt.Color(255, 255, 153));
        JCForma_DeP.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        JCForma_DeP.setForeground(new java.awt.Color(0, 102, 51));
        JCForma_DeP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Semanal", "Quinsenal" }));
        JCForma_DeP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel26.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 153));
        jLabel26.setText("Celular");

        txtcelular_Cli.setBackground(new java.awt.Color(255, 255, 153));
        txtcelular_Cli.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtcelular_Cli.setForeground(new java.awt.Color(0, 102, 51));
        txtcelular_Cli.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtcelular_Cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcelular_CliKeyTyped(evt);
            }
        });

        txtDirecion.setBackground(new java.awt.Color(255, 255, 153));
        txtDirecion.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtDirecion.setForeground(new java.awt.Color(0, 102, 51));
        txtDirecion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel44.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 153));
        jLabel44.setText("Direccion");

        Fecha_Vent.setBackground(new java.awt.Color(255, 255, 153));
        Fecha_Vent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Fecha_Vent.setForeground(new java.awt.Color(0, 102, 51));
        Fecha_Vent.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        jLabel62.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 153));
        jLabel62.setText("Fecha Registro");

        SpinnerCant.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        SpinnerCant.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fecha_Vent, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcelular_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDirecion, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel28))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JCForma_DeP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SpinnerCant, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(53, 53, 53))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDirecion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcelular_Cli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(SpinnerCant, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28)
                    .addComponent(JCForma_DeP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addComponent(Fecha_Vent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BnbAsignar_C.setBackground(new java.awt.Color(255, 255, 153));
        BnbAsignar_C.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BnbAsignar_C.setForeground(new java.awt.Color(0, 102, 51));
        BnbAsignar_C.setText("Asignar");
        BnbAsignar_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnbAsignar_CActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 153));
        jLabel48.setText("Codigo de tiquete");

        txtCod_Venta.setBackground(new java.awt.Color(255, 255, 153));
        txtCod_Venta.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtCod_Venta.setForeground(new java.awt.Color(0, 102, 51));
        txtCod_Venta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtCod_Venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_VentaKeyTyped(evt);
            }
        });

        JcEmpleados.setBackground(new java.awt.Color(255, 255, 153));
        JcEmpleados.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        JcEmpleados.setForeground(new java.awt.Color(0, 102, 51));
        JcEmpleados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        JcCodTique.setBackground(new java.awt.Color(255, 255, 153));
        JcCodTique.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        JcCodTique.setForeground(new java.awt.Color(0, 102, 51));
        JcCodTique.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNom_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCod_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcCodTique, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BnbAsignar_C)
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(19, Short.MAX_VALUE))))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(JcEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addGap(8, 8, 8)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(JcCodTique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtNom_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BnbAsignar_C)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Jdasignar_ClieLayout = new javax.swing.GroupLayout(Jdasignar_Clie.getContentPane());
        Jdasignar_Clie.getContentPane().setLayout(Jdasignar_ClieLayout);
        Jdasignar_ClieLayout.setHorizontalGroup(
            Jdasignar_ClieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jdasignar_ClieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        Jdasignar_ClieLayout.setVerticalGroup(
            Jdasignar_ClieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jdasignar_ClieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel3.setBackground(new java.awt.Color(0, 102, 51));
        panel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 3, true));
        panel3.setForeground(new java.awt.Color(255, 255, 153));

        txtCod_E_E.setBackground(new java.awt.Color(255, 255, 153));
        txtCod_E_E.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        txtCod_E_E.setForeground(new java.awt.Color(0, 102, 51));
        txtCod_E_E.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_E_EKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 153));
        jLabel12.setText("NOTA:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 153));
        jLabel13.setText("Ingrese el codigo a Eliminar");

        bnbEliminar_E.setBackground(new java.awt.Color(255, 255, 153));
        bnbEliminar_E.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbEliminar_E.setForeground(new java.awt.Color(0, 102, 51));
        bnbEliminar_E.setText("Eliminar");
        bnbEliminar_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbEliminar_EActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCod_E_E, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bnbEliminar_E))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCod_E_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnbEliminar_E))
        );

        javax.swing.GroupLayout JdEliminar_ELayout = new javax.swing.GroupLayout(JdEliminar_E.getContentPane());
        JdEliminar_E.getContentPane().setLayout(JdEliminar_ELayout);
        JdEliminar_ELayout.setHorizontalGroup(
            JdEliminar_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JdEliminar_ELayout.setVerticalGroup(
            JdEliminar_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdEliminar_ELayout.createSequentialGroup()
                .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel19.setBackground(new java.awt.Color(0, 102, 51));
        jPanel19.setForeground(new java.awt.Color(255, 255, 153));

        jLabel45.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 153));
        jLabel45.setText("Clientes");

        T_Clientes.setBackground(new java.awt.Color(255, 255, 153));
        T_Clientes.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        T_Clientes.setForeground(new java.awt.Color(0, 102, 51));
        T_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(T_Clientes);

        jPanel30.setBackground(new java.awt.Color(255, 255, 153));
        jPanel30.setForeground(new java.awt.Color(0, 102, 51));

        jLabel52.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 51));
        jLabel52.setText("Total de Clientes :");

        JlTotal_Clien.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        JlTotal_Clien.setForeground(new java.awt.Color(0, 102, 51));
        JlTotal_Clien.setText("0");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlTotal_Clien, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addComponent(JlTotal_Clien))
        );

        Panel_Abono.setBackground(new java.awt.Color(0, 102, 51));
        Panel_Abono.setForeground(new java.awt.Color(255, 255, 153));

        jLabel49.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 153));
        jLabel49.setText("Codigo de Cartulina");

        jLabel50.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 153));
        jLabel50.setText("Valor a Abonar");

        txtCo_Venta.setBackground(new java.awt.Color(255, 255, 153));
        txtCo_Venta.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtCo_Venta.setForeground(new java.awt.Color(0, 102, 51));
        txtCo_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCo_VentaActionPerformed(evt);
            }
        });
        txtCo_Venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCo_VentaKeyTyped(evt);
            }
        });

        txtAbono.setBackground(new java.awt.Color(255, 255, 153));
        txtAbono.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtAbono.setForeground(new java.awt.Color(0, 102, 51));
        txtAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbonoKeyTyped(evt);
            }
        });

        bnbAbonar.setBackground(new java.awt.Color(255, 255, 153));
        bnbAbonar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        bnbAbonar.setForeground(new java.awt.Color(0, 102, 51));
        bnbAbonar.setText("Abonar");
        bnbAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbAbonarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_AbonoLayout = new javax.swing.GroupLayout(Panel_Abono);
        Panel_Abono.setLayout(Panel_AbonoLayout);
        Panel_AbonoLayout.setHorizontalGroup(
            Panel_AbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AbonoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(Panel_AbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(Panel_AbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCo_Venta, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(txtAbono))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_AbonoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bnbAbonar)
                .addContainerGap())
        );
        Panel_AbonoLayout.setVerticalGroup(
            Panel_AbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AbonoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_AbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtCo_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_AbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bnbAbonar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Panel_Abono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel_Abono, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JfClientesLayout = new javax.swing.GroupLayout(JfClientes.getContentPane());
        JfClientes.getContentPane().setLayout(JfClientesLayout);
        JfClientesLayout.setHorizontalGroup(
            JfClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JfClientesLayout.setVerticalGroup(
            JfClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel4.setBackground(new java.awt.Color(0, 102, 51));
        panel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 3, true));
        panel4.setForeground(new java.awt.Color(255, 255, 153));

        txtTipoP.setBackground(new java.awt.Color(255, 255, 153));
        txtTipoP.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        txtTipoP.setForeground(new java.awt.Color(0, 102, 51));
        txtTipoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoPKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 153));
        jLabel24.setText("NOTA:");

        jLabel55.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 153));
        jLabel55.setText("Ingrese el Nombre del tipo de producto");

        bnbIngTipo.setBackground(new java.awt.Color(255, 255, 153));
        bnbIngTipo.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbIngTipo.setForeground(new java.awt.Color(0, 102, 51));
        bnbIngTipo.setText("Ingresar");
        bnbIngTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbIngTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoP, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bnbIngTipo))))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtTipoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnbIngTipo))
        );

        javax.swing.GroupLayout JdIngresarTLayout = new javax.swing.GroupLayout(JdIngresarT.getContentPane());
        JdIngresarT.getContentPane().setLayout(JdIngresarTLayout);
        JdIngresarTLayout.setHorizontalGroup(
            JdIngresarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JdIngresarTLayout.setVerticalGroup(
            JdIngresarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelPromo.setBackground(new java.awt.Color(0, 102, 51));
        panelPromo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Promociones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(255, 255, 153))); // NOI18N

        bnbagreP.setBackground(new java.awt.Color(255, 255, 153));
        bnbagreP.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        bnbagreP.setForeground(new java.awt.Color(0, 102, 0));
        bnbagreP.setText("Aceptar");
        bnbagreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbagrePActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 153));
        jLabel56.setText("Escoja el tipo de producto: ");

        Jltipos.setBackground(new java.awt.Color(255, 255, 153));
        Jltipos.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Jltipos.setForeground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout panelPromoLayout = new javax.swing.GroupLayout(panelPromo);
        panelPromo.setLayout(panelPromoLayout);
        panelPromoLayout.setHorizontalGroup(
            panelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPromoLayout.createSequentialGroup()
                .addGroup(panelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPromoLayout.createSequentialGroup()
                        .addContainerGap(309, Short.MAX_VALUE)
                        .addComponent(bnbagreP))
                    .addGroup(panelPromoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Jltipos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPromoLayout.setVerticalGroup(
            panelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPromoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(Jltipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bnbagreP))
        );

        javax.swing.GroupLayout JdPromocLayout = new javax.swing.GroupLayout(JdPromoc.getContentPane());
        JdPromoc.getContentPane().setLayout(JdPromocLayout);
        JdPromocLayout.setHorizontalGroup(
            JdPromocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPromo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JdPromocLayout.setVerticalGroup(
            JdPromocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 51));

        txtContEmp.setBackground(new java.awt.Color(255, 255, 153));
        txtContEmp.setForeground(new java.awt.Color(0, 102, 51));
        txtContEmp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel58.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 153));
        jLabel58.setText("Contraseña nueva");

        jLabel59.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 153));
        jLabel59.setText("y eliminar la creada por el sistema");
        jLabel59.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel60.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 153));
        jLabel60.setText("ingrese su nueva contraseña ");
        jLabel60.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        bnbCamClvE.setBackground(new java.awt.Color(255, 255, 153));
        bnbCamClvE.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        bnbCamClvE.setForeground(new java.awt.Color(0, 102, 51));
        bnbCamClvE.setText("Ingresar");
        bnbCamClvE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbCamClvEActionPerformed(evt);
            }
        });
        bnbCamClvE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bnbCamClvEKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtContEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(bnbCamClvE, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59)
                .addGap(24, 24, 24)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(bnbCamClvE, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JdCambioClvELayout = new javax.swing.GroupLayout(JdCambioClvE.getContentPane());
        JdCambioClvE.getContentPane().setLayout(JdCambioClvELayout);
        JdCambioClvELayout.setHorizontalGroup(
            JdCambioClvELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JdCambioClvELayout.setVerticalGroup(
            JdCambioClvELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        p_p.setBackground(new java.awt.Color(0, 102, 51));
        p_p.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        p_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_pMouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 102, 51));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 2, true));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 153));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 51));
        jLabel8.setText("Precio T.Venta: ");

        jbTotalV.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jbTotalV.setForeground(new java.awt.Color(0, 102, 51));
        jbTotalV.setText("000000");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbTotalV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbTotalV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 51));
        jLabel4.setText("Precio T.Compra: ");

        jTotalC.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jTotalC.setForeground(new java.awt.Color(0, 102, 51));
        jTotalC.setText("000000");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTotalC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(jTotalC))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 153));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 51));
        jLabel7.setText("Total de CAJAS");

        JlC.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        JlC.setForeground(new java.awt.Color(0, 102, 51));
        JlC.setText("0");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(JlC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JlC))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cajas de Productos Naturales");

        T_Bodega.setBackground(new java.awt.Color(255, 255, 153));
        T_Bodega.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        T_Bodega.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        T_Bodega.setForeground(new java.awt.Color(0, 102, 51));
        T_Bodega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_Bodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_BodegaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(T_Bodega);

        jPanel20.setBackground(new java.awt.Color(0, 102, 51));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 2, true));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 153));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setText("Ganancias Inicial: ");

        jlgananc.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jlgananc.setForeground(new java.awt.Color(0, 102, 51));
        jlgananc.setText("000000");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jlgananc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addComponent(jlgananc))
        );

        jPanel31.setBackground(new java.awt.Color(255, 255, 153));
        jPanel31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel53.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 102, 51));
        jLabel53.setText("Ganancias  en Bodega : ");

        JTotal_Ganancia_B.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        JTotal_Ganancia_B.setForeground(new java.awt.Color(0, 102, 51));
        JTotal_Ganancia_B.setText("000000");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTotal_Ganancia_B, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addComponent(JTotal_Ganancia_B))
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 153));
        jPanel32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel54.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 102, 51));
        jLabel54.setText("Ganancia Vendida :");

        JTotal_Ganancias_V.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        JTotal_Ganancias_V.setForeground(new java.awt.Color(0, 102, 51));
        JTotal_Ganancias_V.setText("000000");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTotal_Ganancias_V, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addComponent(JTotal_Ganancias_V))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel31, jPanel32, jPanel8});

        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel31, jPanel32, jPanel8});

        bnbLimpia_Cero.setBackground(new java.awt.Color(255, 255, 153));
        bnbLimpia_Cero.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        bnbLimpia_Cero.setForeground(new java.awt.Color(0, 102, 51));
        bnbLimpia_Cero.setText("Limpiar Cajas Vendidas");
        bnbLimpia_Cero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbLimpia_CeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_pLayout = new javax.swing.GroupLayout(p_p);
        p_p.setLayout(p_pLayout);
        p_pLayout.setHorizontalGroup(
            p_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_pLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
            .addGroup(p_pLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 487, Short.MAX_VALUE)
                .addComponent(bnbLimpia_Cero)
                .addGap(19, 19, 19))
        );
        p_pLayout.setVerticalGroup(
            p_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_pLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_pLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_pLayout.createSequentialGroup()
                        .addComponent(bnbLimpia_Cero, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 153));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        m_Guar.setBackground(new java.awt.Color(255, 255, 153));
        m_Guar.setForeground(new java.awt.Color(0, 102, 51));
        m_Guar.setText("Archivo");
        m_Guar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        m_Guar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_GuarMouseClicked(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(255, 255, 153));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 102, 51));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        m_Guar.add(jMenuItem1);

        jRadioButtonMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jRadioButtonMenuItem5.setBackground(new java.awt.Color(255, 255, 153));
        jRadioButtonMenuItem5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jRadioButtonMenuItem5.setForeground(new java.awt.Color(0, 102, 51));
        jRadioButtonMenuItem5.setSelected(true);
        jRadioButtonMenuItem5.setText("Guardar");
        jRadioButtonMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem5ActionPerformed(evt);
            }
        });
        m_Guar.add(jRadioButtonMenuItem5);

        rbnbAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        rbnbAbrir.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbAbrir.setForeground(new java.awt.Color(0, 102, 51));
        rbnbAbrir.setSelected(true);
        rbnbAbrir.setText("Abrir");
        rbnbAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbnbAbrirMouseClicked(evt);
            }
        });
        rbnbAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbAbrirActionPerformed(evt);
            }
        });
        m_Guar.add(rbnbAbrir);

        jMenuBar1.add(m_Guar);

        m_Adm_B.setBackground(new java.awt.Color(255, 255, 153));
        m_Adm_B.setForeground(new java.awt.Color(0, 102, 51));
        m_Adm_B.setText("Adm... Bodega");
        m_Adm_B.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        m_Adm_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_Adm_BActionPerformed(evt);
            }
        });

        rbnbAgregar.setBackground(new java.awt.Color(255, 255, 153));
        rbnbAgregar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbAgregar.setForeground(new java.awt.Color(0, 102, 51));
        rbnbAgregar.setSelected(true);
        rbnbAgregar.setText("Agregar Una Caja");
        rbnbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbAgregarActionPerformed(evt);
            }
        });
        m_Adm_B.add(rbnbAgregar);

        rbnbModi.setBackground(new java.awt.Color(255, 255, 153));
        rbnbModi.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbModi.setForeground(new java.awt.Color(0, 102, 51));
        rbnbModi.setSelected(true);
        rbnbModi.setText("Modificar Caja");
        rbnbModi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbModiActionPerformed(evt);
            }
        });
        m_Adm_B.add(rbnbModi);

        rbnbVender.setBackground(new java.awt.Color(255, 255, 153));
        rbnbVender.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbVender.setForeground(new java.awt.Color(0, 102, 51));
        rbnbVender.setSelected(true);
        rbnbVender.setText("Vender Una Caja");
        rbnbVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbVenderActionPerformed(evt);
            }
        });
        m_Adm_B.add(rbnbVender);

        rbnbEliminar.setBackground(new java.awt.Color(255, 255, 153));
        rbnbEliminar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbEliminar.setForeground(new java.awt.Color(0, 102, 51));
        rbnbEliminar.setSelected(true);
        rbnbEliminar.setText("Eliminar Una Caja");
        rbnbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbEliminarActionPerformed(evt);
            }
        });
        m_Adm_B.add(rbnbEliminar);

        jMenuBar1.add(m_Adm_B);

        Ingre_B.setBackground(new java.awt.Color(255, 255, 153));
        Ingre_B.setForeground(new java.awt.Color(0, 102, 51));
        Ingre_B.setText("Cajas/Vendidas");
        Ingre_B.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Ingre_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ingre_BMouseClicked(evt);
            }
        });
        Ingre_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingre_BActionPerformed(evt);
            }
        });

        jRadioButtonMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jRadioButtonMenuItem1.setBackground(new java.awt.Color(255, 255, 153));
        jRadioButtonMenuItem1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jRadioButtonMenuItem1.setForeground(new java.awt.Color(0, 102, 51));
        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Mostrar  Venta ");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        Ingre_B.add(jRadioButtonMenuItem1);

        jMenuBar1.add(Ingre_B);

        m_Estadistica.setBackground(new java.awt.Color(255, 255, 153));
        m_Estadistica.setForeground(new java.awt.Color(0, 102, 51));
        m_Estadistica.setText("Estadisticas");
        m_Estadistica.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        m_Estadistica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_EstadisticaMouseClicked(evt);
            }
        });
        m_Estadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_EstadisticaActionPerformed(evt);
            }
        });

        rbnbG_V.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        rbnbG_V.setBackground(new java.awt.Color(255, 255, 153));
        rbnbG_V.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbG_V.setForeground(new java.awt.Color(0, 102, 51));
        rbnbG_V.setSelected(true);
        rbnbG_V.setText("Grafica Cajas En Bodega");
        rbnbG_V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbG_VActionPerformed(evt);
            }
        });
        m_Estadistica.add(rbnbG_V);

        rbnbGp_V.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        rbnbGp_V.setBackground(new java.awt.Color(255, 255, 153));
        rbnbGp_V.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbnbGp_V.setForeground(new java.awt.Color(0, 102, 51));
        rbnbGp_V.setSelected(true);
        rbnbGp_V.setText("Grafica/Ventas:  por T.Bebidas");
        rbnbGp_V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnbGp_VActionPerformed(evt);
            }
        });
        m_Estadistica.add(rbnbGp_V);

        jMenuBar1.add(m_Estadistica);

        m_Cerrar.setBackground(new java.awt.Color(255, 255, 153));
        m_Cerrar.setForeground(new java.awt.Color(0, 102, 51));
        m_Cerrar.setText("Cerrar");
        m_Cerrar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        m_Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_CerrarMouseClicked(evt);
            }
        });
        m_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_CerrarActionPerformed(evt);
            }
        });
        jMenuBar1.add(m_Cerrar);

        jMenu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setForeground(new java.awt.Color(0, 102, 51));
        jMenu2.setText(":::");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        rmIngrTp.setBackground(new java.awt.Color(255, 255, 153));
        rmIngrTp.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rmIngrTp.setForeground(new java.awt.Color(0, 102, 51));
        rmIngrTp.setSelected(true);
        rmIngrTp.setText("Ingresar un tipo P");
        rmIngrTp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmIngrTpActionPerformed(evt);
            }
        });
        jMenu2.add(rmIngrTp);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_p, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JComboBox<String> getJCForma_DeP() {
        return JCForma_DeP;
    }
 
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jRadioButtonMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem5ActionPerformed
        // TODO add your handling code here:
        Guardar(obj,ruta1);
    }//GEN-LAST:event_jRadioButtonMenuItem5ActionPerformed

//metodo para ingresar los tipos de productos
  public void IngrTiP(String tipo){
       this.TiposP.add(tipo);
       MeterTipo(this.JTi_B); 
       MeterTipo(this.Jltipos); 
       Guardar(TiposP, ruta7);
    }
    
//metodo para ingresar la lista de los jcomboBox
  public void MeterTipo(JComboBox r){    
      r.removeAllItems();
       r.addItem("-Seleccione-");
       Collections.sort(this.TiposP);//ordenar el vector 
      for(int i=0; i<this.TiposP.size(); i++){
        r.addItem(String.valueOf(this.TiposP.get(i)));
      }
  }
  
//metodo para ingresar la lista de los jcomboBox
  public void LlenarEmpl(JComboBox r){  
      r.removeAllItems();
      r.addItem("-Seleccione-");
       Collections.sort(obj2.NombreEmp());//ordenar el vector 
      for(int i=0; i<obj2.NombreEmp().size(); i++){
        r.addItem(String.valueOf(obj2.NombreEmp().get(i)));
      }
  }  
  
//metodo para ingresar la lista de los jcomboBox
  public void LlenarEmplEntr(JComboBox r){  
      r.removeAllItems();
      r.addItem("-Seleccione-");
       Collections.sort(obj3.NombreEmpEntr());//ordenar el vector 
      for(int i=0; i<obj3.NombreEmpEntr().size(); i++){
        r.addItem(String.valueOf(obj3.NombreEmpEntr().get(i)));
      }
  }    
  
//metodo para guardar archivos
    public void Guardar(Object oc, String ruta) {
        java.io.FileOutputStream Archivo;
        try {
            Archivo = new java.io.FileOutputStream(ruta);
            ObjectOutputStream arc = new ObjectOutputStream(Archivo);
            arc.writeObject(oc);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar \n" + ex.toString(), "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    //metodo para preparar  tabla de los empleados
    public void Llenar_Tabla() {
        tabla_Em.setModel(obj2.agre());
        JlTotal_Em.setText(String.valueOf(obj2.contarNodos()));
        tabla_Em.setEnabled(false);
    }

    //metodo para preparar  tabla de los Clientes
    public void Llenar_T_Clie() {
        obj4.Eliminar_Cero();
        JlTotal_Clien.setText(String.valueOf(obj4.contarNodos()));
        T_Clientes.setModel(obj4.Agre_Prod_v());
        T_Clientes.setEnabled(false);
    }
    
    //metodo para preparar  tabla de ventas
    public void Llenar_T_Ven() {
        T_Ventas_C.setModel(obj1.Agre_Caja());
        T_Ventas_C.setEnabled(false);
    }

    //metodo para llenatr la tabla de la Bodega
    public void llenar_T_Bod() {
        //obj.Eliminar_Cero();
        T_Bodega.setModel(obj.Agre_Caja());
        T_Bodega.setEnabled(false);
    }

    //metodo para llenatr la tabla de la Asignar ventas
    public void llenar_T_Asig_V() {
        //obj.Eliminar_Cero();
        T_Asid_V.setModel(obj.Agre_Caja());
    }

     //metodo para llenar tabla de productos asignados
    public void Llenar_T_Pro_A(){
       obj3.Eliminar_Cero();   
       T_Productos_V.setModel(obj3.Agre_Prod());
       T_Productos_V.setEnabled(false);
    }

    //metodo para leer tipos  productos 
     public void leer_TiP() {
        java.io.FileInputStream Archivo;
        try {
            Archivo = new java.io.FileInputStream(ruta7);
            ObjectInputStream arc = new ObjectInputStream(Archivo);
            TiposP = (ArrayList) arc.readObject();        
            MeterTipo(this.JTi_B);
            MeterTipo(this.Jltipos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error con el Archivo de Productos \n" + ex.toString(), "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //metodo para leer el archivo de ventas
    public void leer_V() {
        java.io.FileInputStream Archivo;
        try {
            Archivo = new java.io.FileInputStream("src\\Ficheros\\Venta.txt");
            ObjectInputStream arc = new ObjectInputStream(Archivo);
            obj1 = (Lista_VentaCajas) arc.readObject();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error con el Archivo de ventas\n \n" + ex.toString(), "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    //metodo para controlar el tipo de entrada a enteros 
    public void Controlar_int(java.awt.event.KeyEvent evt){
     char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }
    
    //metodo para cambiar el icono at todos los jFrame
    public void Cambiar_Icono(){
            try{
         Image img = ImageIO.read(new File("icon.png"));
         this.setIconImage(img);
        }catch(Exception ex){
          JOptionPane.showInputDialog(null, "Error con el icono "+ex,"Algo salio mal",JOptionPane.ERROR);
        }
    }

    //metodo contador para las etiquetas JFRegistro_C
    public void Ag_Eti() {
        JlC.setText(String.valueOf(obj.contarNodos()));

        this.jTotalC.setText(String.valueOf(formateador.format(obj.Precio_C()))+" $");
        this.jbTotalV.setText(String.valueOf(formateador.format(obj.Precio_V()))+" $");
        this.jlgananc.setText(String.valueOf(formateador.format(obj.Precio_G()))+" $");
        this.JTotal_Ganancia_B.setText(String.valueOf(formateador.format(obj.Precio_G_V()))+" $");
         //this.JTotal_Ganancias_V.setText(String.valueOf());
    }

    //metodo agregar valores a las etiquetas de ventas
    public void G_Eti_V() {
        this.JlC1.setText(String.valueOf(obj1.contarNodos()));

        this.jTotalC1.setText(String.valueOf(formateador.format(obj1.Precio_C()))+" $");
        this.jlgananc1.setText(String.valueOf(formateador.format(obj1.Precio_G()))+" $");
       

    }

    private void rbnbAbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbnbAbrirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnbAbrirMouseClicked

    private void rbnbAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbAbrirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnbAbrirActionPerformed

    private void m_GuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_GuarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_m_GuarMouseClicked

    private void rbnbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbAgregarActionPerformed
        // TODO add your handling code here:

        this.bnbReg.setVisible(true);
        this.bnbLimpiar.setVisible(true);
        this.txtcod.setVisible(true);
        this.bnbModifi.setVisible(false);
        
        Cambiar_Icono();
        this.JfR_caja.setLocationRelativeTo(null);
        this.JfR_caja.setSize(527, 300);
        this.JfR_caja.setTitle("REGISTRO DE CAJA");
        this.JfR_caja.setVisible(true);
    }//GEN-LAST:event_rbnbAgregarActionPerformed

    private void rbnbPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbPromoActionPerformed
        // TODO add your handling code here
        Cambiar_Icono();
        this.JdPromoc.setTitle("Promo");
        this.JdPromoc.setVisible(true);
        this.JdPromoc.setSize(408,130);

    }//GEN-LAST:event_rbnbPromoActionPerformed

    private void rbnbModiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbModiActionPerformed
        // TODO add your handling code here:
        if (obj.contarNodos() > 0) {
            
            Cambiar_Icono();
            this.bnbReg.setVisible(false);
            this.bnbLimpiar.setVisible(false);
            this.txtcod.setVisible(false);
            this.bnbModifi.setVisible(true);
            this.JfR_caja.setTitle("Modificacion de caja");
            this.JfR_caja.setSize(527, 269);
            this.JfR_caja.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "registro de Bodega vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_rbnbModiActionPerformed

    private void rbnbVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbVenderActionPerformed
        // TODO add your handling code here:
        Cambiar_Icono();
        this.HAcerV.setSize(350, 150);
        this.HAcerV.setVisible(true);
    }//GEN-LAST:event_rbnbVenderActionPerformed

    private void rbnbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int x;
            if (obj.contarNodos() > 0) {

                x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Codigo de la CAJA a ELIMINAR", "Busqueda", JOptionPane.INFORMATION_MESSAGE));
                Nodo_Cajas Aux = obj.Buscar_No(x);
                if (Aux != null) {
                    obj.eliminar(Aux);// se elimina de la lista enlazada
                    obj5.Eliminar(Aux);//la caja se eliminara de la base de datos
                    Ag_Eti();//Agrega a la etiquetas 
                    Guardar(obj,ruta1);
                    llenar_T_Bod();
                    JOptionPane.showMessageDialog(null, "Caja Eliminada", "GENIAL", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Codigo No registrado", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "registro de BODEGA vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
        };
    }//GEN-LAST:event_rbnbEliminarActionPerformed

    private void m_Adm_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_Adm_BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_Adm_BActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        // TODO add your handling code here:
        Cambiar_Icono();
        Jfventas.setSize(1332, 541);
        Jfventas.setTitle("VENTAS");
        Jfventas.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void Ingre_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ingre_BMouseClicked
        // TODO add your handling code here
        Cambiar_Icono();
        Jfventas.setSize(1332, 541);
        Jfventas.setTitle("VENTAS");
        Jfventas.setVisible(true);
    }//GEN-LAST:event_Ingre_BMouseClicked

    private void Ingre_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingre_BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ingre_BActionPerformed

    private void rbnbG_VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbG_VActionPerformed
        // TODO add your handling code here:
        try {
            if (obj.contarNodos() > 0) {

                datos.addValue(obj.C_Tipos(String.valueOf(this.TiposP.get(0))), String.valueOf(this.TiposP.get(0)), String.valueOf(this.TiposP.get(0)));
                datos.addValue(obj.C_Tipos(String.valueOf(this.TiposP.get(1))), String.valueOf(this.TiposP.get(1)), String.valueOf(this.TiposP.get(1)));
                datos.addValue(obj.C_Tipos(String.valueOf(this.TiposP.get(2))), String.valueOf(this.TiposP.get(2)), String.valueOf(this.TiposP.get(2)));

                grafica = ChartFactory.createBarChart3D(null, "Cajas", "Cantidad de cajas", datos, PlotOrientation.VERTICAL, true, true, true);

                ChartFrame Panel = new ChartFrame("Grafica De Cajas En Bodega", grafica);

                Panel.setVisible(true);
                Panel.setSize(600, 500);
                Panel.setBackground(Color.GREEN);
            } else {
                JOptionPane.showMessageDialog(null, "registro de BODEGA vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "error al graficar "+e, "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        };
    }//GEN-LAST:event_rbnbG_VActionPerformed

    private void rbnbGp_VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbGp_VActionPerformed
        // TODO add your handling code here:
        try {
            if (obj1.contarNodos() > 0) {

                datos1.addValue(obj1.Ganan_Tip(String.valueOf(this.TiposP.get(0))), "P. Ganacias", String.valueOf(this.TiposP.get(0)));
                datos1.addValue(obj1.PrecioC_Tip(String.valueOf(this.TiposP.get(0))), "P. Compras", String.valueOf(this.TiposP.get(0)));
                datos1.addValue(obj1.PrecioV_Tip(String.valueOf(this.TiposP.get(0))), "P. Ventas", String.valueOf(this.TiposP.get(0)));

                datos1.addValue(obj1.Ganan_Tip(String.valueOf(this.TiposP.get(1))), "P. Ganacias", String.valueOf(this.TiposP.get(1)));
                datos1.addValue(obj1.PrecioC_Tip(String.valueOf(this.TiposP.get(1))), "P. Compras", String.valueOf(this.TiposP.get(1)));
                datos1.addValue(obj1.PrecioV_Tip(String.valueOf(this.TiposP.get(1))), "P. Ventas", String.valueOf(this.TiposP.get(1)));

                datos1.addValue(obj1.Ganan_Tip(String.valueOf(this.TiposP.get(2))), "P. Ganacias", String.valueOf(this.TiposP.get(2)));
                datos1.addValue(obj1.PrecioC_Tip(String.valueOf(this.TiposP.get(2))), "P. Compras", String.valueOf(this.TiposP.get(2)));
                datos1.addValue(obj1.PrecioV_Tip(String.valueOf(this.TiposP.get(2))), "P. Ventas", String.valueOf(this.TiposP.get(2)));

                grafica1 = ChartFactory.createBarChart(
                        "Graficas de Precios de Cajas Vendidas",
                        "Cajas",
                        "Precio Total",
                        datos1,
                        PlotOrientation.VERTICAL, true, true, true);

                ChartFrame Panel = new ChartFrame("Grafica de Precios", grafica1);

                Panel.setVisible(true);
                Panel.setSize(600, 500);

            } else {
                JOptionPane.showMessageDialog(null, "registro de Ventas vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        };
    }//GEN-LAST:event_rbnbGp_VActionPerformed

    private void m_EstadisticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_EstadisticaMouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_m_EstadisticaMouseClicked

    private void m_EstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_EstadisticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_EstadisticaActionPerformed

    private void m_CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_CerrarMouseClicked
        // TODO add your handling code here:
           int x = JOptionPane.showConfirmDialog(null, "Deseas Guardar? \n", "Confirmar Guardar", JOptionPane.YES_NO_OPTION);
        if (x == 0) {           
           Guardar(obj,ruta1);
        } else if (x == 1) {

        }
         setVisible(false);
    }//GEN-LAST:event_m_CerrarMouseClicked

    private void m_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_CerrarActionPerformed
        // TODO add your handling code here:JOptionPane.showConfirmDialog(null,"CONFIRMAR",null,JOptionPane.YES_NO_OPTION);
        int x = JOptionPane.showConfirmDialog(null, "Deseas Guardar? \n", "Confirmar Guardar", JOptionPane.YES_NO_OPTION);
        if (x == 0) {           
           Guardar(obj,ruta1);
        } else if (x == 1) {

        }
         setVisible(false);
    }//GEN-LAST:event_m_CerrarActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7MouseClicked

    private void bnbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbFiltroActionPerformed
        // TODO add your handling code here:
        try {
            if (obj.contarNodos() > 0) {
                String x = "";
                String OP[] = {"Promociones"};
                String res = (String) JOptionPane.showInputDialog(null, "¡Como Desea Buscar?", "BUSQUEDA", JOptionPane.INFORMATION_MESSAGE, null, OP, OP[0]);
                switch (res) {
                    case "Promociones":
                        Cambiar_Icono();
                        T_Busqueda.setModel(obj3.Lista_Pro());
                        JFMuestra_T_B.setSize(1050, 468);
                        JFMuestra_T_B.setTitle("PROMOCIONES");
                        JFMuestra_T_B.setVisible(true);
                        break;
                    default:
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "registro de BODEGA vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {

        };
    }//GEN-LAST:event_bnbFiltroActionPerformed

    private void p_pMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_pMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_p_pMouseClicked

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt);
    }//GEN-LAST:event_txtcodKeyTyped

    private void txtcantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt);
    }//GEN-LAST:event_txtcantKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt);
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void JTi_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTi_BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTi_BActionPerformed

    private void bnbRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbRegActionPerformed
        // TODO add your handling code here:
        try {  
            boolean x = false;
            Nodo_Cajas aux = new Nodo_Cajas();

            if (JTi_B.getSelectedIndex() != 0) {

                if (!txtNombre_P.getText().isEmpty()) {

                    int tem = JTi_B.getSelectedIndex() - 1;
                    
                    aux.setTipo(String.valueOf(TiposP.get(tem)));
                    aux.setCodigo(Integer.parseInt(txtcod.getText()));
                    aux.setDescripcion(txtNombre_P.getText());
                    aux.setCantidad(Integer.parseInt(txtcant.getText()));
                    aux.setStop(Integer.parseInt(txtcant.getText()));
                    aux.setPrecio(Float.parseFloat(txtPrecio.getText()));
                    aux.Precio_V(); 
                    aux.Precio_u();
                    aux.Ganancia();
                    aux.Ganancia_V();
                    aux.setFecha(((JTextField)Fecha_Cj.getDateEditor().getUiComponent()).getText());
                    aux.isPro();

                    x = obj.Comprobar(aux.getCodigo());//retorna verdadero si no se repite el codigo

                } else {
                    JOptionPane.showMessageDialog(null, "Escriba su descripcion ", "ALERTA", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Escoja un Tipo de Bebidas", "ALERTA", JOptionPane.WARNING_MESSAGE);
            }

            if (x) {
                obj.agregar(aux);//agrega a la lista enlazada
                obj5.Insertar(aux);//agrega a la base de datos
                llenar_T_Bod();
                Ag_Eti();

                this.txtcod.setText("");
                this.txtcant.setText("");
                this.txtPrecio.setText("");
                this.txtNombre_P.setText("");
                this.txtcod.requestFocus();
                this.JTi_B.setSelectedIndex(0);

                JOptionPane.showMessageDialog(null, "Caja registrada", "GENIAL", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (NumberFormatException aux) {
            JOptionPane.showMessageDialog(null, "campos vacios ", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bnbRegActionPerformed

    private void bnbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbLimpiarActionPerformed
        // TODO add your handling code here:
        
        this.txtcod.setText("");
        this.txtcant.setText("");
        this.txtcant.setText("");
        this.txtPrecio.setText("");
        this.txtNombre_P.setText("");
        this.txtcod.requestFocus();
    }//GEN-LAST:event_bnbLimpiarActionPerformed

    private void bnbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbSalirActionPerformed
        this.txtcod.setText("");
        this.txtcant.setText("");
        this.txtcant.setText("");
        this.txtPrecio.setText("");
        this.txtcod.requestFocus();
        this.JTi_B.setSelectedIndex(0);
        JfR_caja.setVisible(false);
    }//GEN-LAST:event_bnbSalirActionPerformed

    private void bnbModifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbModifiActionPerformed
        // TODO add your handling code here:
        try {
            if (obj.contarNodos() > 0) {
                int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Codigo de la Caja a Modificar", "CODIGO", JOptionPane.INFORMATION_MESSAGE));

                 int tem = JTi_B.getSelectedIndex() - 1;
                 String t = String.valueOf(this.TiposP.get(tem));
                 
                if (!t.isEmpty()) {
                    obj.modi_T(x, t);
                    llenar_T_Bod();
                    Ag_Eti();
                }
                if (!txtPrecio.getText().isEmpty()) {
                    obj.modi_Pre(x, Float.parseFloat(txtPrecio.getText()));
                    llenar_T_Bod();
                    Ag_Eti();
                }
                if (!txtcant.getText().isEmpty()) {
                    obj.modi_Ca(x, Integer.parseInt(txtcant.getText()));
                    llenar_T_Bod();
                    Ag_Eti();
                }
                if (!txtNombre_P.getText().isEmpty()) {
                    obj.modi_Desc(x, txtNombre_P.getText());
                    llenar_T_Bod();
                    Ag_Eti();
                }
                boolean aux = obj.Comprobar(x);
                
                this.txtcod.setText("");
                this.txtcant.setText("");
                this.txtcant.setText("");
                this.txtPrecio.setText("");
                this.txtNombre_P.setText("");
                this.txtcod.requestFocus();
                this.JTi_B.setSelectedIndex(0);

            } else {
                JOptionPane.showMessageDialog(null, "registro de Bodega vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {

        };
    }//GEN-LAST:event_bnbModifiActionPerformed

    private void CerrarsecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarsecionActionPerformed
        // TODO add your handling code here:

        int x = JOptionPane.showConfirmDialog(null, "Seguro, Deseas Cerrar Secion", null, JOptionPane.YES_NO_OPTION);;
        if (x == 0) {
            JOptionPane.showMessageDialog(null, "GRACIAS!!", "Hasta luego", JOptionPane.INFORMATION_MESSAGE);
            this.Menu_P.setVisible(false);
            this.Cerrarsecion.setVisible(false);
            this.p_Inicio.setVisible(true);

        } else if (x == 1) {
            
        }
    }//GEN-LAST:event_CerrarsecionActionPerformed

    private void bnbInicio_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbInicio_SActionPerformed
        // TODO add your handling code here:
        String Usu = this.txtUsuario1.getText();
        String Contr = this.txtContrase1.getText();
        String contr = this.txtContrase1.getText();

        if (cont > 0) {
      //si es un empleado o es el administador 
            if ( ( obj11.EnconAdm(Usu, contr)) || (obj11.Encontrado(Usu, contr))){
                   this.Menu_P.setVisible(true);
                   this.Cerrarsecion.setVisible(true);
                   this.p_Inicio.setVisible(false);
                   this.m_arch.setVisible(true);
                   this.Ingre_B1.setVisible(true);
                   this.rbnbProductos_B.setVisible(true);
                   this.rbnbProductos_P_V.setVisible(true);
                   this.jMenuBar2.setVisible(true);
                   //this.txtUsuario1.setText("");  
                   this.txtContrase1.setText("");
                   cont = 2;

            if(obj11.Encontrado(Usu, contr)){
                  this.m_arch.setVisible(false);
                   this.Ingre_B1.setVisible(false);
                   this.rbnbProductos_B.setVisible(false);
                   this.rbnbProductos_P_V.setVisible(false);
                   this.jMenuBar2.setVisible(false);
                   cont = 2;
                   
                   if(obj11.BuscaEmp(Usu)){
                   this.JdCambioClvE.setTitle("N Contraseña");
                   this.JdCambioClvE.setSize(220,160);
                   this.JdCambioClvE.setVisible(true);
            }
                   
          }
            } else {
                this.txtUsuario1.setText("");
                this.txtContrase1.setText("");
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta \n"
                        + "Le quedan " + cont + " Intentos", "ALETA", JOptionPane.WARNING_MESSAGE);
                cont--;
            }

        } else {
            this.txtUsuario1.setText("");
            this.txtContrase1.setText("");
            JOptionPane.showMessageDialog(null, "Maximos de intentos fallidos \n"
                    + "contactese con el ADMINISTRADOR", "ALETA", JOptionPane.WARNING_MESSAGE);
        }
      
    }//GEN-LAST:event_bnbInicio_SActionPerformed

    private void p_InicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_InicioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_InicioKeyPressed

    private void rbnbC_AdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbC_AdmActionPerformed
        // TODO add your handling code here: this.
        int x = JOptionPane.showConfirmDialog(null, "Deseas Cambiar Administrador?", null, JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            JfCambio_Adm.setSize(280, 300);
            this.JfCambio_Adm.setTitle("CAMBIO DE ADMINISTRADOR");
            Cambiar_Icono();
            JfCambio_Adm.setVisible(true);
        }
    }//GEN-LAST:event_rbnbC_AdmActionPerformed

    private void rbnbC_ContreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbC_ContreActionPerformed
        // TODO add your handling code here:

        int x = JOptionPane.showConfirmDialog(null, "Seguro, Deseas Cambiar Contraseña?", null, JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            Cambiar_Icono();
            this.JfCambio_Clv.setSize(250, 250);
            this.JfCambio_Clv.setTitle("CAMBIO DE CONTRASEÑA");
            this.JfCambio_Clv.setVisible(true);
        }
    }//GEN-LAST:event_rbnbC_ContreActionPerformed

    private void rbnbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnbSalirActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        // TODO add your handling code here:     
        setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void Ingre_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ingre_B1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_Ingre_B1MouseClicked

    private void Ingre_B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingre_B1ActionPerformed
        // TODO add your handling code here:
        setVisible(true);
    }//GEN-LAST:event_Ingre_B1ActionPerformed

    private void m_trabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_trabMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_m_trabMouseClicked

    private void m_trabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_trabActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_m_trabActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt);
    }//GEN-LAST:event_txtIdKeyTyped

    private void bnbCam_AdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbCam_AdActionPerformed
        // TODO add your handling code here:
        //Mod_adm();
        this.JfCambio_Adm.setVisible(false);
    }//GEN-LAST:event_bnbCam_AdActionPerformed

    private void bnbCambiar_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbCambiar_CActionPerformed
        // TODO add your handling code here:
        try {
            String Contr = this.txtCont_v.getText();
            String Contr_Nue = this.txtC_n.getText();
            Nodo_Usuario aux = obj11.CambioClvAdm(Contr_Nue, Contr);
            if (aux != null) {
                obj12.Modificar(aux);
               this.JfCambio_Clv.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta!!", "Error!", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Campos Vacios!!", "Error!", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_bnbCambiar_CActionPerformed

    private void txtcod2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcod2KeyTyped
        // TODO add your handling code here:
         Controlar_int(evt);
    }//GEN-LAST:event_txtcod2KeyTyped

    private void bnbVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbVenderActionPerformed
        // TODO add your handling code here:
        try {

            if (obj.contarNodos() > 0) {
                if (!txtcod2.getText().isEmpty()) {
                    int x = Integer.parseInt(this.txtcod2.getText());
                    Nodo_Cajas Aux = obj.Buscar_No(x);

                    if (Aux != null) {
                        obj.eliminar(Aux);

                        obj1.agregar_V(Aux);
                        Guardar(obj1,ruta6);
                        //hace conteo para las cajas almacenadas
                        Ag_Eti();
                        //hace conteo para las cajas vendidas
                        G_Eti_V();

                        Llenar_T_Ven();
                        llenar_T_Bod();
                        this.txtcod2.setText("");
                        JOptionPane.showMessageDialog(null, "Caja VENDIDA", "GENIAL", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Codigo No registrado", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                        this.txtcod2.setText("");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese el Codigo", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "registro de BODEGA vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
        };
    }//GEN-LAST:event_bnbVenderActionPerformed

    private void bnbexiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbexiActionPerformed
        // TODO add your handling code here:
        JFMuestra_T_B.setVisible(false);
    }//GEN-LAST:event_bnbexiActionPerformed

    private void rbnbV_EmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbV_EmplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnbV_EmplActionPerformed

    private void rbnbV_ProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbV_ProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnbV_ProActionPerformed

    private void rbnbI_EmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbI_EmpActionPerformed
        // TODO add your handling code here:
        this.Fecha_Cj.setVisible(true);
        this.nombre.setText("");
        this.identidad1.setText("");
        this.Co.setText("");
        this.correo.setText("");
        this.celular.setText("");
        Cambiar_Icono();
        R_Empl.setSize(508, 270);
        R_Empl.setTitle("Registro de un empleado");
        Buscar_Em.setVisible(false);
        Modi_Em.setVisible(false);
        Ingre_Em.setVisible(true);
        R_Empl.setVisible(true);
    }//GEN-LAST:event_rbnbI_EmpActionPerformed

    private void rbnbMo_EmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbMo_EmActionPerformed
        // TODO add your handling code here:
        Cambiar_Icono();
        R_Empl.setSize(508, 235);
        R_Empl.setTitle("Registro de un empleado");
        Ingre_Em.setVisible(false);
        Buscar_Em.setVisible(true);
        Modi_Em.setVisible(true);
        R_Empl.setVisible(true);
    }//GEN-LAST:event_rbnbMo_EmActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void CoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CoKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt);
    }//GEN-LAST:event_CoKeyTyped

    private void identidad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_identidad1KeyTyped
        // TODO add your handling code here:
         Controlar_int(evt);
    }//GEN-LAST:event_identidad1KeyTyped

    private void celularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celularKeyTyped
        // TODO add your handling code here:
         Controlar_int(evt);
    }//GEN-LAST:event_celularKeyTyped

    private void Ingre_EmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingre_EmActionPerformed
        // TODO add your handling code here:
        try {

            Nodo_Empleados aux = new Nodo_Empleados();
            Nodo_Usuario aux2 = new Nodo_Usuario();
            int N_Ide = obj11.contarNodos();//numero de usuarios
            
            boolean x = false;

            if (!nombre.getText().isEmpty()) {
                
  
                aux.setCodigo(Integer.parseInt(Co.getText()));
                aux.setNombre(nombre.getText());
                aux.setClave(nombre.getText());
                aux.setCargo("VENDEDOR");
                aux.setId(Integer.parseInt(identidad1.getText()));
                aux.setCorreo(correo.getText());
                aux.setCel(celular.getText());
                aux.setFecha(((JTextField)JdFecha.getDateEditor().getUiComponent()).getText());
                aux.getSueldo_base();
                aux.Salario();
                aux.Aporte_ARL();
                aux.N_Pagar();
                
                aux2.setNombre(aux.getNombre());
                aux2.setClave("0000");
                aux2.setTipo_U(false);
                aux2.setId(N_Ide + 1);
                
                x = obj2.Comprobar_C(aux.getCodigo());

            } else {
                JOptionPane.showMessageDialog(null, "Campo Nombre Vacio! ", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }

            if (x) {
                obj2.agregar(aux);//agrega a a lista_Empleados 
                obj11.agregar(aux2);//agrega a a lista_usuarios
                obj12.Insertar(aux2);//inserta e usuario
                obj6.Insertar(aux, aux2);//inserta el empleado

                Llenar_Tabla();
                Guardar(obj2,ruta5); //guarda un archivo de texto de empleados 

                this.Co.setText("");
                this.nombre.setText("");
                this.identidad1.setText("");
                this.correo.setText("");
                this.celular.setText("");
                this.nombre.requestFocus();

                JOptionPane.showMessageDialog(null, "Empleado registrado", "GENIAL", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (NumberFormatException aux) {
            JOptionPane.showMessageDialog(null, "Campos Vacios!", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        };
    }//GEN-LAST:event_Ingre_EmActionPerformed

    private void rbnbEnviarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbEnviarNActionPerformed
          Correos obj = new Correos();
          obj.EnviarC();
    }//GEN-LAST:event_rbnbEnviarNActionPerformed

    private void rbnbSaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbSaActionPerformed
        // TODO add your handling code here:

        int x = JOptionPane.showConfirmDialog(null, "Seguro, Deseas Salir \n Asegurese de Guardar", null, JOptionPane.YES_NO_OPTION);;
        if (x == 0) {
            JFR_Empleado.setVisible(false);
        } else if (x == 1) {
        }
    }//GEN-LAST:event_rbnbSaActionPerformed

    private void rbnbAsinar_VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbAsinar_VActionPerformed
        // TODO add your handling code here:
if(obj.contarNodos() > 0){
        this.txtCod_P.setText("");
        this.txtCod_P.requestFocus();
        
        Cambiar_Icono();
        LlenarEmpl(this.JcEmpleadosV);
        JfAsignar_V.setSize(1258, 555);
        JfAsignar_V.setTitle("Asignar Ventas");
        JfAsignar_V.setVisible(true);
        llenar_T_Asig_V();
        T_Asid_V.setEnabled(true);
}else{
JOptionPane.showMessageDialog(null, "Registro de Bodega Vacio!", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
}  
    }//GEN-LAST:event_rbnbAsinar_VActionPerformed

    private void bnbAsignar_VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbAsignar_VActionPerformed
        // TODO add your handling code here:
        try {

            int Can = Integer.parseInt(this.SpinnerCantAsig.getValue().toString());//cantidad a vender
            int cant = 0;//Para calcular la cantidad nueva al modificar en bodega
            int f = T_Asid_V.getSelectedRow();//numero de fila
            int c = 0;// lo que contiene la fila y columna en dicha posicion

            if (f >= 0) {
                c = (int) T_Asid_V.getValueAt(f, 0);
            }

            Nodo_Entrega aux = new Nodo_Entrega();
            Nodo_Empleados tem = obj2.buscar_Espec(Integer.parseInt(this.JcEmpleadosV.getSelectedItem().toString()));

            if (c != 0) {
                Nodo_Cajas tem2 = obj.buscar_Espec(c);

                if (tem2 != null) {

                    if (tem != null) {
    
                        if (Can <= tem2.getCantidad()) {
                            
                            boolean X = obj3.Comprobar(Integer.parseInt(this.txtCod_P.getText()));
                            
                            if(X){

                            aux.setVendedor(tem.getNombre());
                            aux.setStop(Can);
                            aux.setCodigo(Integer.parseInt(this.txtCod_P.getText()));
                            aux.setPrecio(tem2.getPrecio_U());
                            aux.setTipo(tem2.getTipo());
                            aux.setDescripcion(tem2.getDescripcion());
                            aux.setCodigo_C(tem2.getCodigo());
                            aux.setCodigo_V(tem.getCodigo());
                            aux.setFecha(tem2.getFecha());
                            aux.isPro();

                            cant = tem2.getStop() - Can;
                            tem2.setStop(cant);
                            tem2.Ganancia_V();
                            tem2.Precio_Vent_N(Can);
                            

                            obj3.agregar(aux);//agrega el nodo a la lista enlazada
                            obj7.Insertar(aux);//inserta en la base de datos en la Tb_Entrega                   
                            obj5.ModoCnt(tem2);//modifica la caja en la tabla Tb_bodega

                            Ag_Eti();
                            Guardar(obj3,ruta2);
                            Guardar(obj,ruta1);
                            llenar_T_Bod();
                            llenar_T_Asig_V();
                            Llenar_T_Pro_A();

                            this.txtCod_P.setText("");
                            this.txtCod_P.requestFocus();

                            JOptionPane.showMessageDialog(null, "Producto Asignado a " + tem.getNombre(), "ALERTA!!", JOptionPane.INFORMATION_MESSAGE);

                            } else {
                            JOptionPane.showMessageDialog(null, "Codigo Ya Existe! ", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                        }
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Cantidad digitada Mayor a la Almacenada ", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Codido de empleado No registrado", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Codido de Caja No registrado", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione el codigo de caja", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException aux) {
            JOptionPane.showMessageDialog(null, "Campos Vacios! " + aux.toString(), "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        };
    }//GEN-LAST:event_bnbAsignar_VActionPerformed

    private void txtCod_PKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_PKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt);
    }//GEN-LAST:event_txtCod_PKeyTyped

    private void rbnbProductos_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbProductos_BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnbProductos_BActionPerformed

    private void rbnbProductos_A_VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbProductos_A_VActionPerformed
        // TODO add your handling code here: 
        Cambiar_Icono();
        JfProductos_V.setSize(1090, 500);
        JfProductos_V.setTitle("Productos Asignados");
        JfProductos_V.setVisible(true);
    }//GEN-LAST:event_rbnbProductos_A_VActionPerformed

    private void rbnbElim_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbElim_EActionPerformed
        // TODO add your handling code here:}
        
          if(obj2.contarNodos() > 0){
         Cambiar_Icono();
        JdEliminar_E.setTitle("Eliminar Empleado");
        JdEliminar_E.setSize(350, 150);
        JdEliminar_E.setVisible(true);  
          }else{
        JOptionPane.showMessageDialog(null, "registro de EMPLEADOS vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_rbnbElim_EActionPerformed

    private void txtCod_E_EKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_E_EKeyTyped
        // TODO add your handling code here:
         Controlar_int(evt);
    }//GEN-LAST:event_txtCod_E_EKeyTyped

    private void bnbEliminar_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbEliminar_EActionPerformed
        // TODO add your handling code here:
        try{
        int  x = Integer.parseInt(this.txtCod_E_E.getText());
        
            if (obj2.contarNodos() > 0) {

                Nodo_Empleados Aux = obj2.Buscar_No(x);
                if (Aux != null) {
                    obj2.eliminar(Aux);
                   obj6.Eliminar(Aux);
                    Guardar(obj2,ruta5);
                    Llenar_Tabla();
                    this.txtCod_E_E.setText("");
                    JOptionPane.showMessageDialog(null, "Empleado Eliminada", "GENIAL", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Codigo No registrado", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                }
      
            } else {
                JOptionPane.showMessageDialog(null, "registro de EMPLEADOS vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }

            
        }catch(NumberFormatException aux){
                 JOptionPane.showMessageDialog(null, "Campo vacio!", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                } ;    
    }//GEN-LAST:event_bnbEliminar_EActionPerformed

    private void rbnbVer_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbVer_EActionPerformed
        // TODO add your handling code here:
        Cambiar_Icono();
        Llenar_Tabla();
        JFR_Empleado.setSize(1245, 275);
        JFR_Empleado.setTitle("EMPLEADOS");
        JFR_Empleado.setVisible(true);
      
    }//GEN-LAST:event_rbnbVer_EActionPerformed

    private void rbnbAsignar_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbAsignar_CActionPerformed
        // TODO add your handling code here:
          if(obj3.contarNodos() > 0){
        
        Cambiar_Icono();
        LlenarEmpl(this.JcEmpleados);
        LlenarEmplEntr(this.JcCodTique);
        Jdasignar_Clie.setSize(475, 425);
        Jdasignar_Clie.setTitle("Asignar Clientes");
        Jdasignar_Clie.setVisible(true);
            
        }else{
        JOptionPane.showMessageDialog(null, "registro de Productos Vacios", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_rbnbAsignar_CActionPerformed

    private void BnbAsignar_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnbAsignar_CActionPerformed
        // TODO add your handling code here:
        try {
           
            Nodo_Clientes aux = new Nodo_Clientes();
            Nodo_Compra aux2 = new Nodo_Compra();
            
            int Can = Integer.parseInt(this.SpinnerCant.getValue().toString());//cantidad vendida
            
            int cant =0;//variable para almacernar la nueva cantidad de Productos
            int cant2 =0;//variable para almacernar la nueva cantidad de de ventas de un empleado
          
            Nodo_Entrega tem = obj3.buscar_Espec(Integer.parseInt(this.JcCodTique.getSelectedItem().toString()));
            
            
            Nodo_Empleados tem2 = obj2.buscar_Espec(Integer.parseInt(this.JcEmpleados.getSelectedItem().toString()));
  
            if (JCForma_DeP.getSelectedIndex() != 0) {

                if (!txtNom_cli.getText().isEmpty()) {

                    if(!txtDirecion.getText().isEmpty()){
                        
                        boolean X = obj4.Comprobar(Integer.parseInt(txtCod_Venta.getText()));
                        
                        if(X){
                        
                       if (tem2 != null) {
                         
                          if (tem != null) {
                                
                              if (Can <= tem.getStop()) {
                                //llena el Nodo_Cliente Con la informacio de dicho cliente
                                aux.setForma_P(JCForma_DeP.getSelectedItem().toString());
                                aux.setCodigoClie(Integer.parseInt(txtCod_Venta.getText()));
                                aux.setNom_Cli(txtNom_cli.getText());
                                aux.setDireccion(txtDirecion.getText());
                                aux.setCant(Can);
                                aux.setCodigoE(tem2.getCodigo());
                                aux.setNom_Cli(txtNom_cli.getText());
                                aux.setPrecio(tem.getPrecio());
                                aux.setTipo_P(tem.getTipo());
                                aux.setTelefono(txtcelular_Cli.getText());
                                aux.setFecha(((JTextField)Fecha_Vent.getDateEditor().getUiComponent()).getText());
                                aux.Nuevo_Precio(Can);
                                aux.Valor_C();
                                aux.Deuda(0);
                                
                                //Posterior llena el siguiente nodo_compras  con la informaciion de e empleado que vendio el cliente que compro y el produ¿cto comprado 
                                aux2.setCodigoClien(aux.getCodigoClie());
                                aux2.setCodigoEmpl(tem2.getCodigo());
                                aux2.setCodigoEntr(tem.getCodigo());
                                aux2.setNombreC(aux.getNom_Cli());
                                aux2.setNombreE(tem.getVendedor());
                                aux2.setPrecio(aux.getPrecio());

                                cant = tem.getStop() - Can;//para descontarle a stop la cantidad vendida
                                cant2 = tem2.getCant_venta() + Can;//para sumar la cantidad vendida 
                                
                                tem.setStop(cant);//asigna a la entrega el nuevo stop

                                tem2.setCant_venta(cant2);//asigna al vendedor la nueva venta
                                tem2.N_Pagar();//le calcula el salario teniendo en cuuenta la cantidad vendida
                          
                                obj4.agregar(aux);//agrega un cliente a la lista_Clientes
                                obj9.agregar_V(aux2);//agrega un Compra a la lista_Compras
                                obj8.Insertar(aux);//se agrega un cliente a la base de datos en la tb_clientes
                                obj10.Insertar(aux2);//se agrega una compra a la base de datos en la tb_compras
                                obj6.AgregarCant(tem2);//actualiza el nodo_empleado en la base de datos en la tb_empl
                                obj7.ModoCnt(tem);//actualiza el nodo_entrega en la base de datos en la tb_entrega

                                Guardar(obj2,ruta5);
                                Guardar(obj3,ruta2);
                                Guardar(obj4,ruta3);

                                llenar_T_Asig_V();
                                Llenar_T_Pro_A();
                                Llenar_Tabla();
                                Llenar_T_Clie();
                                
                                this.txtNom_cli.setText("");
                                this.txtDirecion.setText("");
                                this.txtcelular_Cli.setText("");
                                this.txtCod_Venta.setText("");
                                this.SpinnerCant.setValue(0);
                                this.JcEmpleados.setSelectedIndex(0);
                                this.JcCodTique.setSelectedIndex(0);
                                this.JCForma_DeP.setSelectedIndex(0);
                                this.txtCod_Venta.requestFocus();

                                JOptionPane.showMessageDialog(null, "Cliente Asignado a " + tem2.getNombre(), "ALERTA!!", JOptionPane.INFORMATION_MESSAGE);
                             
                            } else {
                                JOptionPane.showMessageDialog(null, "Cantidad digitada Mayor a la Almacenada ", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Codido de Producto No registrado", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Codido de Empleado No registrado", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                    }
                    
                         } else {
                        JOptionPane.showMessageDialog(null, "Codido de Venta Ya Existe!", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                    }
                        
                  } else {
                    JOptionPane.showMessageDialog(null, "Por favor dijite la Direccion del Cliente", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                }  

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor dijite el Nombre del Cliente", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por Favor seleccione forma de pago", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException aux) {
            JOptionPane.showMessageDialog(null, "Campos Vacios! ", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        };
    }//GEN-LAST:event_BnbAsignar_CActionPerformed

    private void rbnbVer_CliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbVer_CliActionPerformed
        // TODO add your handling code here:
        Cambiar_Icono();
      JfClientes.setSize(1110,471);
      JfClientes.setTitle("Cliente");
      Panel_Abono.setVisible(false);  
      JfClientes.setVisible(true);     
    }//GEN-LAST:event_rbnbVer_CliActionPerformed

    private void rbnbAsignar_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnbAsignar_CuentaActionPerformed
        // TODO add your handling code here:
       Cambiar_Icono();
        Panel_Abono.setVisible(true);
        JfClientes.setSize(1110,485);
      JfClientes.setTitle("Cuotas de Cliente");
      JfClientes.setVisible(true);
    }//GEN-LAST:event_rbnbAsignar_CuentaActionPerformed

    private void txtCod_VentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_VentaKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt); 
    }//GEN-LAST:event_txtCod_VentaKeyTyped

    private void T_Asid_VMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_Asid_VMouseClicked
 // TODO add your handling code here:
        if (evt.getButton() == 3) {

            jPopupMenu1.add(rbnbPromo);
            jPopupMenu1.add(rbnbEliminar);
            jPopupMenu1.add(rbnbModi);
            jPopupMenu1.add(rbnbAsinar_V);

            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_T_Asid_VMouseClicked

    private void txtCo_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCo_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCo_VentaActionPerformed

    private void txtCo_VentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCo_VentaKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt); 
    }//GEN-LAST:event_txtCo_VentaKeyTyped

    private void txtAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt); 
    }//GEN-LAST:event_txtAbonoKeyTyped

    private void bnbAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbAbonarActionPerformed
        // TODO add your handling code here:
        try{
         /*   int f = T_Clientes.getSelectedRow();//numero de fila
            int c = 0;// lo que contiene la fila y columna en dicha posicion

            if (f >= 0) {
                c = (int) T_Clientes.getValueAt(f, 0);
            }*/
            Nodo_Clientes tem = obj4.buscar_Espec(Integer.parseInt(this.txtCo_Venta.getText()));

        if(tem != null){
            
            tem.Deuda(Float.parseFloat(this.txtAbono.getText()));
            obj8.ModiDeuda(tem);
            
            Guardar(obj4,ruta3);
            Llenar_T_Clie();
            
            this.txtCo_Venta.setText("");
            this.txtAbono.setText("");
            
        }else{
        JOptionPane.showMessageDialog(null, "Codigo de Cartulina No Existe ", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
        
        }catch(NumberFormatException aux){
          JOptionPane.showMessageDialog(null, "Campos Vacios! "+aux.toString(), "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bnbAbonarActionPerformed

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseClicked

    private void bnbLimpia_CeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbLimpia_CeroActionPerformed
        // TODO add your handling code here:
        Nodo_Cajas tem = obj.getCabeza();
        boolean x = false;
        
        while(tem != null){
            if(tem.getStop() <= 0){
         obj1.agregar_V(tem);
         obj.eliminar(tem);
         x = true;
            } 
         tem = tem.getSiguiente();       
       }
        if(!x){
           JOptionPane.showMessageDialog(null, "No hay Cajas Vendidas! ", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
     G_Eti_V();   
     Ag_Eti();
     llenar_T_Bod();
     Llenar_T_Ven();
     Guardar(obj1,ruta6);
     Guardar(obj,ruta1);
    }//GEN-LAST:event_bnbLimpia_CeroActionPerformed

    private void rmIngrTpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmIngrTpActionPerformed
        // TODO add your handling code here:  
        if(this.TiposP.size() <= 5){
        this.JdIngresarT.setTitle("Ingreso tipo");
        this.JdIngresarT.setSize(453,150);
        this.JdIngresarT.setVisible(true);    
        }else{
            this.rmIngrTp.setVisible(false);
            JOptionPane.showMessageDialog(null, "MAximos de tipos alcanzados","ALERTA",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_rmIngrTpActionPerformed

    private void txtTipoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoPKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoPKeyTyped

    private void bnbIngTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbIngTipoActionPerformed
        // TODO add your handling code here:  
        this.txtTipoP.requestFocus();
        if(!this.txtTipoP.getText().isEmpty()){
       IngrTiP(this.txtTipoP.getText());
       this.txtTipoP.setText("");
        JOptionPane.showMessageDialog(null, "Tipo registrado ","Genial",JOptionPane.INFORMATION_MESSAGE);
        }else{
        JOptionPane.showMessageDialog(null, "Campo Tipo de producto vacio","Alerta",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bnbIngTipoActionPerformed

    private void bnbagrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbagrePActionPerformed
        // TODO add your handling code here:
          try {
            String y;
            if (obj3.contarNodos() > 0) {
                if(Jltipos.getSelectedIndex() != 0){
                    
                int tem = this.Jltipos.getSelectedIndex() - 1;
                y = String.valueOf(TiposP.get(tem));
  
                if(obj3.Agre_Prom(y)){
                   
                  JOptionPane.showMessageDialog(null, "Promocion Agregada a "+y, "Genial!!", JOptionPane.INFORMATION_MESSAGE);
                  this.JdPromoc.setVisible(false);
                  Llenar_T_Pro_A();
                  Ag_Eti();
                
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Escoja un tipo de producto", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "registro de Bodega vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
        };
    }//GEN-LAST:event_bnbagrePActionPerformed

    private void bnbCamClvEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbCamClvEActionPerformed
        // TODO add your handling code here:
        String tem = this.txtContEmp.getText();
        String tem1 = this.txtUsuario1.getText();
        Nodo_Usuario aux2 = obj11.BuscaEmpleado(tem1);//para buscar el nodo por el nombre
        int id = aux2.getId();
        
          if(!txtContEmp.getText().isEmpty()){

              Nodo_Usuario aux = obj11.CambioClv(tem, id);
              
              if(aux != null){
              //obj12.Modificar(aux);
              }else{
                  System.out.println("No se encuentra");
              }
              this.JdCambioClvE.setVisible(false);
          }else{
            JOptionPane.showMessageDialog(null, "Campo Vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
          }
    }//GEN-LAST:event_bnbCamClvEActionPerformed

    private void bnbInicio_SKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bnbInicio_SKeyPressed
        // TODO add your handling code here:
         int tem = evt.getKeyCode();
        if(tem == KeyEvent.VK_ENTER){
           this.bnbInicio_S.doClick();
          
        }
    }//GEN-LAST:event_bnbInicio_SKeyPressed

    private void bnbInicio_SKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bnbInicio_SKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bnbInicio_SKeyTyped

    private void Buscar_EmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_EmActionPerformed
        // TODO add your handling code here:
        
        if(obj2.contarNodos() > 0){ 
        int x = Integer.parseInt(JOptionPane.showInputDialog(null,"Codigo"));
        Nodo_Empleados aux = obj2.buscar_Espec(x);
        if(aux != null){
        this.Fecha_Cj.setVisible(false);
        this.nombre.setText(String.valueOf(aux.getNombre()));
        this.identidad1.setText(String.valueOf(aux.getId()));
        this.Co.setText(String.valueOf(aux.getCodigo()));
        this.correo.setText(String.valueOf(aux.getCorreo()));
        this.celular.setText(String.valueOf(aux.getCel()));
        }else{
        JOptionPane.showMessageDialog(null, "Codigo No Registrado", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
          }else{
        JOptionPane.showMessageDialog(null, "registro de EMPLEADOS vacio", "ALERTA!!", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_Buscar_EmActionPerformed

    private void Modi_EmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modi_EmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Modi_EmActionPerformed

    private void bnbReportEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbReportEmpActionPerformed
        // TODO add your handling code here:
       try { 
           
        
        JasperReport Report = null;
        String ruta = "src\\Reporte\\Ventas_empl.jasper";

        Report = (JasperReport) JRLoader.loadObjectFromFile(ruta);
        
        JasperPrint jprint = JasperFillManager.fillReport(Report, null, obj6.getConexion());
        
        JasperViewer vista = new JasperViewer(jprint,false);
        vista.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        vista.setVisible(true);
        
        } catch (JRException ex) {
            Logger.getLogger(Visual.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_bnbReportEmpActionPerformed

    private void txtcelular_CliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelular_CliKeyTyped
        // TODO add your handling code here:
        Controlar_int(evt);
    }//GEN-LAST:event_txtcelular_CliKeyTyped

    private void bnbCamClvEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bnbCamClvEKeyPressed
        // TODO add your handling code here:
        int tem = evt.getKeyCode();
        if(tem == KeyEvent.VK_ENTER){
           this.bnbCamClvE.doClick();
          
        }
    }//GEN-LAST:event_bnbCamClvEKeyPressed

    private void T_BodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_BodegaMouseClicked
        // TODO add your handling code here:
         if (evt.getButton() == 3) {

            jPopupMenu1.add(rbnbPromo);
            jPopupMenu1.add(rbnbEliminar);
            jPopupMenu1.add(rbnbModi);
            jPopupMenu1.add(rbnbAsinar_V);

            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_T_BodegaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
            new Visual().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BnbAsignar_C;
    public javax.swing.JButton Buscar_Em;
    public javax.swing.JButton Cerrarsecion;
    public javax.swing.JTextField Co;
    public com.toedter.calendar.JDateChooser Fecha_Cj;
    public com.toedter.calendar.JDateChooser Fecha_Vent;
    public javax.swing.JDialog HAcerV;
    public javax.swing.JLabel Id1;
    public javax.swing.JMenu Ingre_B;
    public javax.swing.JMenu Ingre_B1;
    public javax.swing.JButton Ingre_Em;
    public javax.swing.JComboBox<String> JCForma_DeP;
    public javax.swing.JFrame JFLogin;
    public javax.swing.JFrame JFMuestra_T_B;
    public javax.swing.JFrame JFR_Empleado;
    public javax.swing.JComboBox<String> JTi_B;
    public javax.swing.JLabel JTotal_Ganancia_B;
    public javax.swing.JLabel JTotal_Ganancias_V;
    public javax.swing.JComboBox<String> JcCodTique;
    public javax.swing.JComboBox<String> JcEmpleados;
    public javax.swing.JComboBox<String> JcEmpleadosV;
    public javax.swing.JDialog JdCambioClvE;
    public javax.swing.JDialog JdEliminar_E;
    public com.toedter.calendar.JDateChooser JdFecha;
    public javax.swing.JDialog JdIngresarT;
    public javax.swing.JDialog JdPromoc;
    public javax.swing.JDialog Jdasignar_Clie;
    public javax.swing.JFrame JfAsignar_V;
    public javax.swing.JFrame JfCambio_Adm;
    public javax.swing.JFrame JfCambio_Clv;
    public javax.swing.JFrame JfClientes;
    public javax.swing.JFrame JfProductos_V;
    public javax.swing.JFrame JfR_caja;
    public javax.swing.JFrame Jfventas;
    public javax.swing.JLabel JlC;
    public javax.swing.JLabel JlC1;
    public javax.swing.JLabel JlImg;
    public javax.swing.JLabel JlTotal_Clien;
    public javax.swing.JLabel JlTotal_Em;
    public javax.swing.JComboBox<String> Jltipos;
    public javax.swing.JMenu M_Arc;
    public javax.swing.JMenu M_E;
    public javax.swing.JMenu M_Esta;
    public javax.swing.JMenu M_Productos;
    public javax.swing.JMenuBar Menu_P;
    public javax.swing.JButton Modi_Em;
    public javax.swing.JPanel Panel_Abono;
    public javax.swing.JFrame R_Empl;
    public javax.swing.JFrame RegiUsu;
    public javax.swing.JSpinner SpinnerCant;
    public javax.swing.JSpinner SpinnerCantAsig;
    public javax.swing.JTable T_Asid_V;
    public javax.swing.JTable T_Bodega;
    public javax.swing.JTable T_Busqueda;
    public javax.swing.JTable T_Clientes;
    public javax.swing.JTable T_Productos_V;
    public javax.swing.JTable T_Ventas_C;
    public javax.swing.JButton bnbAbonar;
    public javax.swing.JButton bnbAsignar_V;
    public javax.swing.JButton bnbCamClvE;
    public javax.swing.JButton bnbCam_Ad;
    public javax.swing.JButton bnbCambiar_C;
    public javax.swing.JButton bnbEliminar_E;
    public javax.swing.JButton bnbFiltro;
    public javax.swing.JButton bnbIngTipo;
    public javax.swing.JButton bnbInicio_S;
    public javax.swing.JButton bnbLimpia_Cero;
    public javax.swing.JButton bnbLimpiar;
    public javax.swing.JButton bnbModifi;
    public javax.swing.JButton bnbReg;
    public javax.swing.JButton bnbReportEmp;
    public javax.swing.JButton bnbSalir;
    public javax.swing.JButton bnbVender;
    public javax.swing.JButton bnbagreP;
    public javax.swing.JButton bnbexi;
    public javax.swing.JTextField celular;
    public javax.swing.JTextField correo;
    public javax.swing.JTextField identidad1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel26;
    public javax.swing.JLabel jLabel27;
    public javax.swing.JLabel jLabel28;
    public javax.swing.JLabel jLabel29;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel30;
    public javax.swing.JLabel jLabel31;
    public javax.swing.JLabel jLabel32;
    public javax.swing.JLabel jLabel33;
    public javax.swing.JLabel jLabel34;
    public javax.swing.JLabel jLabel35;
    public javax.swing.JLabel jLabel36;
    public javax.swing.JLabel jLabel37;
    public javax.swing.JLabel jLabel38;
    public javax.swing.JLabel jLabel39;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel40;
    public javax.swing.JLabel jLabel41;
    public javax.swing.JLabel jLabel42;
    public javax.swing.JLabel jLabel43;
    public javax.swing.JLabel jLabel44;
    public javax.swing.JLabel jLabel45;
    public javax.swing.JLabel jLabel46;
    public javax.swing.JLabel jLabel47;
    public javax.swing.JLabel jLabel48;
    public javax.swing.JLabel jLabel49;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel50;
    public javax.swing.JLabel jLabel51;
    public javax.swing.JLabel jLabel52;
    public javax.swing.JLabel jLabel53;
    public javax.swing.JLabel jLabel54;
    public javax.swing.JLabel jLabel55;
    public javax.swing.JLabel jLabel56;
    public javax.swing.JLabel jLabel57;
    public javax.swing.JLabel jLabel58;
    public javax.swing.JLabel jLabel59;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel60;
    public javax.swing.JLabel jLabel61;
    public javax.swing.JLabel jLabel62;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuBar jMenuBar2;
    public javax.swing.JMenuBar jMenuBar3;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel11;
    public javax.swing.JPanel jPanel12;
    public javax.swing.JPanel jPanel13;
    public javax.swing.JPanel jPanel14;
    public javax.swing.JPanel jPanel15;
    public javax.swing.JPanel jPanel16;
    public javax.swing.JPanel jPanel17;
    public javax.swing.JPanel jPanel18;
    public javax.swing.JPanel jPanel19;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel20;
    public javax.swing.JPanel jPanel21;
    public javax.swing.JPanel jPanel22;
    public javax.swing.JPanel jPanel23;
    public javax.swing.JPanel jPanel24;
    public javax.swing.JPanel jPanel25;
    public javax.swing.JPanel jPanel26;
    public javax.swing.JPanel jPanel27;
    public javax.swing.JPanel jPanel28;
    public javax.swing.JPanel jPanel29;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel30;
    public javax.swing.JPanel jPanel31;
    public javax.swing.JPanel jPanel32;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    public javax.swing.JPopupMenu jPopupMenu1;
    public javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    public javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    public javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JLabel jTotalC;
    public javax.swing.JLabel jTotalC1;
    public javax.swing.JLabel jbTotalV;
    public javax.swing.JLabel jlabel;
    public javax.swing.JLabel jlgananc;
    public javax.swing.JLabel jlgananc1;
    public javax.swing.JMenu mAdminPro;
    public javax.swing.JMenu m_Adm_B;
    public javax.swing.JMenu m_Cerrar;
    public javax.swing.JMenu m_Clientes;
    public javax.swing.JMenu m_Estadistica;
    public javax.swing.JMenu m_Guar;
    public javax.swing.JMenu m_arch;
    public javax.swing.JMenu m_trab;
    public javax.swing.JTextField nombre;
    public javax.swing.JPanel p_Inicio;
    public javax.swing.JPanel p_N_Cont;
    public javax.swing.JPanel p_p;
    public javax.swing.JPanel panel2;
    public javax.swing.JPanel panel3;
    public javax.swing.JPanel panel4;
    public javax.swing.JPanel panelPromo;
    public javax.swing.JPanel panel_Reg;
    public javax.swing.JRadioButtonMenuItem rbnbAbrir;
    public javax.swing.JRadioButtonMenuItem rbnbAgregar;
    public javax.swing.JRadioButtonMenuItem rbnbAsignar_C;
    public javax.swing.JRadioButtonMenuItem rbnbAsignar_Cuenta;
    public javax.swing.JRadioButtonMenuItem rbnbAsinar_V;
    public javax.swing.JMenuItem rbnbC_Adm;
    public javax.swing.JMenuItem rbnbC_Contre;
    public javax.swing.JRadioButtonMenuItem rbnbElim_E;
    public javax.swing.JRadioButtonMenuItem rbnbEliminar;
    public javax.swing.JRadioButtonMenuItem rbnbEnviarN;
    public javax.swing.JRadioButtonMenuItem rbnbG_V;
    public javax.swing.JRadioButtonMenuItem rbnbGp_V;
    public javax.swing.JRadioButtonMenuItem rbnbI_Emp;
    public javax.swing.JRadioButtonMenuItem rbnbMo_Em;
    public javax.swing.JRadioButtonMenuItem rbnbModi;
    public javax.swing.JRadioButtonMenuItem rbnbProductos_A_V;
    public javax.swing.JRadioButtonMenuItem rbnbProductos_B;
    public javax.swing.JRadioButtonMenuItem rbnbProductos_P_V;
    public javax.swing.JRadioButtonMenuItem rbnbPromo;
    public javax.swing.JRadioButtonMenuItem rbnbSa;
    public javax.swing.JMenuItem rbnbSalir;
    public javax.swing.JRadioButtonMenuItem rbnbV_Empl;
    public javax.swing.JRadioButtonMenuItem rbnbV_Pro;
    public javax.swing.JRadioButtonMenuItem rbnbVender;
    public javax.swing.JRadioButtonMenuItem rbnbVer_Cli;
    public javax.swing.JRadioButtonMenuItem rbnbVer_E;
    public javax.swing.JRadioButtonMenuItem rbnbabrir;
    public javax.swing.JRadioButtonMenuItem rmIngrTp;
    public javax.swing.JTable tabla_Em;
    public javax.swing.JTextField txtAbono;
    public javax.swing.JPasswordField txtC_n;
    public javax.swing.JPasswordField txtC_n_a;
    public javax.swing.JTextField txtCo_Venta;
    public javax.swing.JTextField txtCod_E_E;
    public javax.swing.JTextField txtCod_P;
    public javax.swing.JTextField txtCod_Venta;
    public javax.swing.JPasswordField txtContEmp;
    public javax.swing.JPasswordField txtCont_v;
    public javax.swing.JPasswordField txtContrase1;
    public javax.swing.JTextField txtDirecion;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNom;
    public javax.swing.JTextField txtNom_cli;
    public javax.swing.JTextField txtNombre_P;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtTipoP;
    public javax.swing.JTextField txtUsuario1;
    public javax.swing.JTextField txtcant;
    public javax.swing.JTextField txtcelular_Cli;
    public javax.swing.JTextField txtcod;
    public javax.swing.JTextField txtcod2;
    // End of variables declaration//GEN-END:variables

  
    
}
