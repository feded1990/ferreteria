package Interfaz;

import BaseDatos.DB;
import Funcionalidad.Cliente;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Deudas extends javax.swing.JFrame {
    //Variables Globales
    String rutaArchivo = "", nombre, precio;
    DB db = new DB();
    ResultSet rs;
    PanelPrincipal panelPrincipal;
    List<String> columnas = new ArrayList<>(Arrays.asList("DNI", "Nombre", "Apellido", "Deuda"));
    
    public Deudas(PanelPrincipal panelPrincial) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        recargarTabla();
        
        this.panelPrincipal = panelPrincial;
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
        textoDNI = new javax.swing.JTextField();
        botonVolver = new javax.swing.JButton();
        botonPagar = new javax.swing.JButton();

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
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
        jLabel4.setText("Filtrar por DNI del cliente:");

        textoDNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoDNIActionPerformed(evt);
            }
        });
        textoDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoDNIKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoDNIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoDNIKeyTyped(evt);
            }
        });

        botonVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonPagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonPagar.setText("Pagar");
        botonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPagarActionPerformed(evt);
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textoDNI, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE))
                        .addGap(31, 31, 31))))
        );
        panelImage4Layout.setVerticalGroup(
            panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addGroup(panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void textoDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoDNIActionPerformed

    private void textoDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoDNIKeyPressed

    }//GEN-LAST:event_textoDNIKeyPressed

    private void textoDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoDNIKeyReleased
        
        List<Cliente> clientes; 
        
        if (textoDNI.getText().equals("")) {
            clientes = db.consultarDeudas();
        } else {        
            clientes = db.consultarDeudasFiltro(Integer.parseInt(textoDNI.getText()));
        }
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        for (String columna : columnas) {
            modelo.addColumn(columna);
        }
        
        if (clientes != null) {
            for (Cliente cliente : clientes) {
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[4]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = cliente.getDNI();
                fila[1] = cliente.getNombre();
                fila[2] = cliente.getApellido();
                fila[3] = cliente.getDeuda();

                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(panelImage4, "Error al conectar a la base de datos");
        }
        tabla.setModel(modelo);
        
    }//GEN-LAST:event_textoDNIKeyReleased

    private void textoDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoDNIKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
        {
             Toolkit.getDefaultToolkit().beep();
             evt.consume();
         }
    }//GEN-LAST:event_textoDNIKeyTyped

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        int i = JOptionPane.showConfirmDialog(panelImage4, "¿Desea volver al panel principal?", "Volver", 0);
        if(i==0){
            panelPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPagarActionPerformed
        
        if(tabla.getSelectedRow()+1>0){
            
            int filaSeleccionada = tabla.getSelectedRow();
            int dni = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString());
            String monto = (JOptionPane.showInputDialog("Ingrese monto (Formato numerico)"))
                    .replace(',', '.');
            try {
                float montoPagado = Float.parseFloat(monto);
                db.actualizarDeuda(dni, montoPagado);
            } catch (NumberFormatException e){
                JOptionPane.showConfirmDialog(null, "El valor ingresado no es valido. Vuelva a intentar", 
                        "naughty", JOptionPane.CANCEL_OPTION);
            }

        }else{
            JOptionPane.showMessageDialog(panelImage4, "Debe seleccionar una fila");
        }
        
        recargarTabla();
    }//GEN-LAST:event_botonPagarActionPerformed

    public void recargarTabla(){
        List<Cliente> clientes = db.consultarDeudas();
        
        DefaultTableModel modeloTabla = new DefaultTableModel();
        
        for (String columna : columnas) {
            modeloTabla.addColumn(columna);
        }
        
        if (clientes != null) {
            if (!clientes.isEmpty()) {
            
                for (Cliente cliente : clientes) {
                    // Se crea un array que será una de las filas de la tabla.
                    Object [] fila = new Object[4]; // Hay tres columnas en la tabla

                    // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                    fila[0] = cliente.getDNI();
                    fila[1] = cliente.getNombre();
                    fila[2] = cliente.getApellido();
                    fila[3] = cliente.getDeuda();

                    // Se añade al modelo la fila completa.
                    modeloTabla.addRow(fila);
                }
            } else {
                JOptionPane.showMessageDialog(panelImage4, "No se registran clientes con deuda");
            }
        } else {
            JOptionPane.showMessageDialog(panelImage4, "Error al conectar a la base de datos");
        }
        tabla.setModel(modeloTabla);
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPagar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelImage panelImage4;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField textoDNI;
    // End of variables declaration//GEN-END:variables
}
