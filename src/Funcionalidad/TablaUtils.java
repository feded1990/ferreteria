package Funcionalidad;

import Interfaz.Articulos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class TablaUtils {

    public static DefaultTableModel recargarTabla(List<String> columnas, ResultSet rs) {
    
        try {
            
            DefaultTableModel modelo = new DefaultTableModel();
            int size = columnas.size();
            
            for (String columna : columnas) {
                modelo.addColumn(columna);
            }
            
            while (rs.next())
            {
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[size]; // Hay tres columnas en la tabla
                
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < size; i++) {
                    fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
            return modelo;
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
            
            DefaultTableModel modelo = new DefaultTableModel();
            for (String columna : columnas) {
                modelo.addColumn(columna);
            }
            
            return modelo;
        }
        
    }
    
}
