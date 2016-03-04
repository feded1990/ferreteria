package Interfaz;

import BaseDatos.DB;
import Funcionalidad.Cliente;
import Funcionalidad.TablaUtils;
import Funcionalidad.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Usuarios extends javax.swing.JFrame {
    //Variables Globales
    String rutaArchivo = "";
    String nombre, precio;
    DB db = new DB();
    ResultSet resultSet;
    PanelPrincipal panelPrincipal;
    List<String> columnas = new ArrayList<>(Arrays.asList("Nombre de Usuario"));
    
    public Usuarios(PanelPrincipal panelPrincipal) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        recargarTabla();
        this.panelPrincipal = panelPrincipal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        panelImage4 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel4 = new javax.swing.JLabel();
        textoNombreUsuario = new javax.swing.JTextField();
        botonVolver = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clientes");

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

        panelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/fondo.jpg"))); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabla);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Filtrar por Usuario:");

        textoNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreUsuarioActionPerformed(evt);
            }
        });
        textoNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoNombreUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoNombreUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNombreUsuarioKeyTyped(evt);
            }
        });

        botonVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonActualizar.setText("Actualizar");
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

        javax.swing.GroupLayout panelImage4Layout = new javax.swing.GroupLayout(panelImage4);
        panelImage4.setLayout(panelImage4Layout);
        panelImage4Layout.setHorizontalGroup(
            panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelImage4Layout.createSequentialGroup()
                        .addGroup(panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelImage4Layout.createSequentialGroup()
                                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textoNombreUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(31, 31, 31))))
        );
        panelImage4Layout.setVerticalGroup(
            panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addGroup(panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNombreUsuarioActionPerformed

    private void textoNombreUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreUsuarioKeyPressed

    }//GEN-LAST:event_textoNombreUsuarioKeyPressed

    private void textoNombreUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreUsuarioKeyReleased
        tabla.setModel(TablaUtils.recargarTabla(columnas, db.consultarUsuariosFiltro(textoNombreUsuario.getText())));
    }//GEN-LAST:event_textoNombreUsuarioKeyReleased

    private void textoNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreUsuarioKeyTyped
        
    }//GEN-LAST:event_textoNombreUsuarioKeyTyped

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        int i = JOptionPane.showConfirmDialog(panelImage4, "¿Desea volver al panel principal?", "Volver", 0);
        if(i==0){
            panelPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

        if(tabla.getSelectedRow()+1>0){
            int filaSeleccionada = tabla.getSelectedRow();
            String nombreUsuario = tabla.getValueAt(filaSeleccionada, 0).toString();
            String contraseña = JOptionPane.showInputDialog("Ingrese nueva contraseña:");
            Usuario usuario = new Usuario(nombreUsuario, contraseña);
            boolean success = db.actualizarContraseña(usuario);
            if (success) {
                JOptionPane.showMessageDialog(panelImage4, "La contraseña se actualizó correctamente", "Actualizada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(panelImage4, "Error inesperado, no se pudo actualizar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            recargarTabla();
        }else{
            JOptionPane.showMessageDialog(panelImage4, "Debe seleccionar una fila");
        }

    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        JLabel jNombreUsuario = new JLabel("Usuario");
        JTextField nombreUsuario = new JTextField();
        JLabel jContraseña = new JLabel("Contraseña");
        JTextField contraseña = new JPasswordField();
        Object[] ob = {jNombreUsuario, nombreUsuario, jContraseña, contraseña};
        
        int resultado = JOptionPane.showConfirmDialog(null, ob, "Credenciales", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
 
        if (resultado == JOptionPane.OK_OPTION) {
            if(!nombreUsuario.getText().isEmpty() && !contraseña.getText().isEmpty()) {
                Usuario usuario = new Usuario(nombreUsuario.getText().toUpperCase(), 
                        contraseña.getText().toUpperCase());
                if (db.crearUsuario(usuario)) {
                    JOptionPane.showMessageDialog(panelImage4, "El usuario se creo exitosamente.", "Usuario creado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panelImage4, "Error inesperado al crear.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                recargarTabla();
            } else {
                JOptionPane.showMessageDialog(panelImage4, "No se ingreso ningun usuario o contraseña.", "Valores no ingresados", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if(tabla.getSelectedRow()+1>0){           
            int filaSeleccionada = tabla.getSelectedRow();                
            String nombreUsuario = tabla.getValueAt(filaSeleccionada, 0).toString().toUpperCase();
            int i = JOptionPane.showConfirmDialog(panelImage4, "¿Esta seguro que desea eliminar al usuario seleccionado?", "Confirmar", 0);
            if(i==0){
                int respuesta = db.eliminarUsuario(nombreUsuario);
                
                switch (respuesta) {
                    case 0:
                        JOptionPane.showMessageDialog(panelImage4, "Ocurrio un error inesperado. No se pudo eliminar el usuario seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(panelImage4, "El usuario se elimino correctamente.", "Usuario eliminado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(panelImage4, "Solo existe un usuario, por lo que no se puede eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(panelImage4, "Ocurrio un error inesperado. No se pudo eliminar el usuario seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
                this.recargarTabla();
            }else{
                JOptionPane.showMessageDialog(panelImage4, "No se elimino ningun cliente");
            }
        }else{
            JOptionPane.showMessageDialog(panelImage4, "Debe seleccionar un cliente");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    public void recargarTabla(){
        tabla.setModel(TablaUtils.recargarTabla(columnas, db.consultarUsuarios()));
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelImage panelImage4;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField textoNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
