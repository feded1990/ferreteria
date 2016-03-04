package Interfaz;

import BaseDatos.DB;
import Funcionalidad.Articulo;
import Funcionalidad.Proveedor;
import Funcionalidad.TablaUtils;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Articulos extends javax.swing.JFrame {
    //Variables Globales
    String rutaArchivo = "";
    String codigo, precio;
    DB db = new DB();
    ResultSet resultSet;
    List<String> columnas = new ArrayList<>(Arrays.asList(
                "Codigo","Nombre","Precio","Cantidad","Proveedor","Codigo de Proveedor"));
    
    public Articulos() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
        recargarTabla();
        
        cargarCombo();
    }

    public void cargarCombo(){
        try {
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            ResultSet resultSet = db.listarProveedores();
            modeloCombo.addElement("SELECCIONAR...");
            while(resultSet.next()){
                try {
                    modeloCombo.addElement(resultSet.getString("Nombre"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panelImagen, "Error al cargar proveedores");
                }
            }
            comboProveedoresPrecio.setModel(modeloCombo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panelImagen, "Error al cargar proveedores");
        }
    }
    
    public void recargarTabla() {
        ResultSet resultSet = db.listarArticulos();
        tabla.setModel(TablaUtils.recargarTabla(columnas, resultSet));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel2 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        BotonVolverActualizar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        panelImagen = new org.edisoncor.gui.panel.PanelImage();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        comboProveedoresPrecio = new javax.swing.JComboBox();
        botonImportar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaArchivo = new javax.swing.JTable();
        botonVolverArchivo = new javax.swing.JButton();
        botonConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Articulos");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(248, 248, 248))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/fondo.jpg"))); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Filtrar por nombre de articulo:");

        textoNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreActionPerformed(evt);
            }
        });
        textoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNombreKeyTyped(evt);
            }
        });

        BotonVolverActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonVolverActualizar.setText("Volver");
        BotonVolverActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVolverActualizarActionPerformed(evt);
            }
        });

        botonActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonActualizar.setText("Actualizar (F1)");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelImage3Layout.createSequentialGroup()
                        .addGroup(panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelImage3Layout.createSequentialGroup()
                                .addComponent(BotonVolverActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(31, 31, 31))))
        );
        panelImage3Layout.setVerticalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addGroup(panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonVolverActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Actualizar", panelImage3);

        panelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/fondo.jpg"))); // NOI18N

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Seleccionar archivo a importar:");

        jButton1.setText("Buscar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboProveedoresPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProveedoresPrecioActionPerformed(evt);
            }
        });

        botonImportar.setText("Importar");
        botonImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImportarActionPerformed(evt);
            }
        });

        tablaArchivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio"
            }
        ));
        tablaArchivo.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaArchivo);

        botonVolverArchivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonVolverArchivo.setText("Volver");
        botonVolverArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverArchivoActionPerformed(evt);
            }
        });

        botonConfirmar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonConfirmar.setText("Confirmar");
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImagenLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addGap(507, 507, 507))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImagenLayout.createSequentialGroup()
                        .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelImagenLayout.createSequentialGroup()
                                .addComponent(botonVolverArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addGroup(panelImagenLayout.createSequentialGroup()
                                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2)
                                    .addComponent(comboProveedoresPrecio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botonImportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
                        .addGap(32, 32, 32))))
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProveedoresPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolverArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Actualizar Precios", panelImagen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea "
                + "actualizar los precios?");
        int bandera=0;
        String codigo;
        float precio;
        Map mapa = new HashMap();
        
        int item = comboProveedoresPrecio.getSelectedIndex(),idProveedor=0;
        if(item != 0){
            try {
                resultSet = db.listarProveedores();
                int i = 1;
                while(resultSet.next()){
                    if(i==item){
                        idProveedor = resultSet.getInt("Id");
                    }
                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(confirmacion==0){
            try{
                
                for(int j = 0; j < tablaArchivo.getRowCount(); j++){

                    codigo = tablaArchivo.getValueAt(j, 0).toString();
                    precio = Float.parseFloat(tablaArchivo.getValueAt(j, 1).toString());
                    mapa.put(codigo, precio);
                }
                db.actualizarArticuloPorCodigo(mapa, idProveedor);
                PanelPrincipal panelPrincipal = new PanelPrincipal();
                panelPrincipal.setVisible(true);
                this.setVisible(false);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Hubo un error al actualizar revisar valores");
                bandera=1;
            }
        }
        if(bandera == 0){
            JOptionPane.showMessageDialog(null, "Todos los codigos fueron actualizados");
        }
    }//GEN-LAST:event_botonConfirmarActionPerformed

    private void botonVolverArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverArchivoActionPerformed
        int i = JOptionPane.showConfirmDialog(panelImagen, "¿Desea volver al panel principal?", "Volver", 0);
        if(i==0){
            PanelPrincipal pp = new PanelPrincipal();
            pp.setVisible(true);
            this.setVisible(false);
            
        }
    }//GEN-LAST:event_botonVolverArchivoActionPerformed

    private void botonImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImportarActionPerformed
            
        try {
            int item = comboProveedoresPrecio.getSelectedIndex();
            
            if(item != 0){
                    resultSet = db.listarProveedores();
                    int i=1, id=0;
                    while(resultSet.next()){
                        if(i==item){
                            
                            id=resultSet.getInt("Id");
                        }
                        i++;
                    }   resultSet = db.buscarProveedor(id);
                Proveedor proveedor = new Proveedor();
                    if(resultSet.next()){
                        proveedor.setId_Proveedor(resultSet.getInt("Id"));
                        proveedor.setNombre(resultSet.getString("Nombre"));
                        proveedor.setCampoId(resultSet.getInt("CampoId"));
                        proveedor.setCampoPrecio(resultSet.getInt("CampoPrecio"));
                    }   DefaultTableModel modeloDeMiTabla=(DefaultTableModel)tablaArchivo.getModel();
                File file = new File(rutaArchivo);
                Workbook archivoExcel;
                try {
                    archivoExcel = Workbook.getWorkbook(file);
                
                    if (archivoExcel != null) {
                        
                        for (int numeroHoja = 0; numeroHoja < archivoExcel.getNumberOfSheets(); numeroHoja++) {
                            
                            Sheet hoja = archivoExcel.getSheet(numeroHoja);
                            int numeroColumnas = hoja.getColumns(), numeroFilas = hoja.getRows(), 
                                    numeroFila = 0, cabecera=0;
                            
                            for (int fila = 0; fila < numeroFilas; fila++) {
                                if((!"".equals(hoja.getCell(proveedor.getCampoId(), fila).getContents()))
                                        &&(!"".equals(hoja.getCell(proveedor.getCampoPrecio(), fila).getContents()))){
                                    codigo = hoja.getCell(proveedor.getCampoId(), fila).getContents();
                                    precio = hoja.getCell(proveedor.getCampoPrecio(), fila).getContents();
                                    precio = precio.replace(" ","");
                                    precio = precio.replace("$", "");
                                    precio = precio.replace("\"", "");
                                    precio = precio.replace(",",".");
                                    precio = eliminarPuntos(precio);
                                    
                                    modeloDeMiTabla.addRow(new Object[fila]);
                                    tablaArchivo.setValueAt(codigo, numeroFila, 0);
                                    tablaArchivo.setValueAt(precio, numeroFila, 1);
                                    numeroFila++;
                                }        
                            }
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(panelImagen, "Error al importar, verifique el archivo seleccionado");
                    }
                
                } catch (IOException | BiffException ex) {
                    JOptionPane.showMessageDialog(panelImagen, "Error al importar, verifique el archivo seleccionado");
                }    
                    
            }else{
                JOptionPane.showMessageDialog(panelImagen, "Debe seleccionar el proveedor de la lista de precios a importar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonImportarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser selectorArchivo = new JFileChooser();
        int seleccion = selectorArchivo.showSaveDialog(selectorArchivo);
        //si la opción es la correcta
        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
            File fichero = selectorArchivo.getSelectedFile();
            //obtenemos la ruta
            rutaArchivo = fichero.getAbsolutePath();
            jTextField2.setText(rutaArchivo);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained

    }//GEN-LAST:event_jTextField2FocusGained

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

        Articulo articulo = new Articulo();
        
        if(tabla.getSelectedRow()+1>0){           
            int filaSeleccionada = tabla.getSelectedRow();
            Proveedor proveedor = new Proveedor();
                            
            articulo.setId_Articulo(Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString()));
            articulo.setNombre(tabla.getValueAt(filaSeleccionada, 1).toString());
            articulo.setPrecio(Float.parseFloat(tabla.getValueAt(filaSeleccionada, 2).toString()));
            articulo.setCantidad(Integer.parseInt(tabla.getValueAt(filaSeleccionada, 3).toString()));
            
            proveedor.setNombre(tabla.getValueAt(filaSeleccionada, 4).toString());
            articulo.setProveedor(proveedor);
            articulo.setCod_prov(tabla.getValueAt(filaSeleccionada, 5).toString());
            ActualizarArticulos jActualizarArticulo = new ActualizarArticulos(this,articulo);
            jActualizarArticulo.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(panelImagen, "Debe seleccionar una fila");
        }        
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void BotonVolverActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVolverActualizarActionPerformed
        int i = JOptionPane.showConfirmDialog(panelImagen, "¿Desea volver al panel principal?", "Volver", 0);
        if(i==0){
            PanelPrincipal jPanelPrincipal = new PanelPrincipal();
            jPanelPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_BotonVolverActualizarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        AgregarArticulo jAgregarArticulo = new AgregarArticulo(this);
        jAgregarArticulo.setLocationRelativeTo(null);
        jAgregarArticulo.setVisible(true);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNombreActionPerformed

    private void textoNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyPressed
        
    }//GEN-LAST:event_textoNombreKeyPressed

    private void textoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyTyped
        
    }//GEN-LAST:event_textoNombreKeyTyped

    private void textoNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyReleased
        String nombre = textoNombre.getText();
        tabla.setModel(TablaUtils.recargarTabla(columnas, db.listarArticulosFiltro(nombre)));
    }//GEN-LAST:event_textoNombreKeyReleased

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if(tabla.getSelectedRow()+1>0){           
            int pos1 = tabla.getSelectedRow();                
            int idart = Integer.parseInt(tabla.getValueAt(pos1, 0).toString());
            int i = JOptionPane.showConfirmDialog(panelImagen, "¿Esta seguro que desea eliminar el articulo seleccionado?", "Confirmar", 0);
            if(i==0){
                db.eliminarArticulo(idart);
                this.recargarTabla();
            }else{
                JOptionPane.showMessageDialog(panelImagen, "No se elimino ningun archivo");
            }
        }else{
            JOptionPane.showMessageDialog(panelImagen, "Debe seleccionar un articulo");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void comboProveedoresPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProveedoresPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProveedoresPrecioActionPerformed

    private void tablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyReleased
        if (evt.getKeyCode() == 112) {
            
            Articulo articulo = new Articulo();
            
            if(tabla.getSelectedRow()+1>0){           
                int filaSeleccionada = tabla.getSelectedRow();                
                Proveedor proveedor = new Proveedor();
                
                articulo.setId_Articulo(Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString()));
                articulo.setNombre(tabla.getValueAt(filaSeleccionada, 1).toString());
                articulo.setPrecio(Float.parseFloat(tabla.getValueAt(filaSeleccionada, 2).toString()));
                articulo.setCantidad(Integer.parseInt(tabla.getValueAt(filaSeleccionada, 3).toString()));
                
                proveedor.setNombre(tabla.getValueAt(filaSeleccionada, 4).toString());
                articulo.setProveedor(proveedor);
                articulo.setCod_prov(tabla.getValueAt(filaSeleccionada, 5).toString());
                ActualizarArticulos jActualizarArticulo = new ActualizarArticulos(this,articulo);
                jActualizarArticulo.setVisible(true);
            
            }else{
                
                JOptionPane.showMessageDialog(panelImagen, "Debe seleccionar una fila");
            }
        }
    }//GEN-LAST:event_tablaKeyReleased
    
    private static String eliminarPuntos(String palabra){
        char cadena[]; 
        int contador=0, i=0, j;
        
        cadena = palabra.toCharArray();
        
        for(char caracter : cadena){
            if(caracter == '.'){
                contador++;
            }
        }
        
        while(contador > 1){
            if(cadena[i] == '.'){
                j=i;                
                while(j < (cadena.length-1)){
                    cadena[j] = cadena[j+1];
                    j++;
                }
                cadena[j] = ' ';
                contador--;
            }
            i++;
        }
        
        return String.valueOf(cadena).replace(" ", "");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonVolverActualizar;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonImportar;
    private javax.swing.JButton botonVolverArchivo;
    private javax.swing.JComboBox comboProveedoresPrecio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField2;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private org.edisoncor.gui.panel.PanelImage panelImagen;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaArchivo;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
