package BaseDatos;

import Funcionalidad.Articulo;
import Funcionalidad.Cliente;
import Funcionalidad.Compra;
import Funcionalidad.CompraArticulo;
import Funcionalidad.Proveedor;
import Funcionalidad.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    //private Connection conexion;
    private SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
    private Conexion conexion = new Conexion();    
    
    //ARTICULOS
    public void agregarArticulo(Articulo art){
        try {
            
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("INSERT INTO articulos (Nombre,Precio,Cantidad, Estado, "
                        + "Id_Proveedor, Codigo_Proveedor) VALUE (?,?,?,'N'"
                        + ",?,?)");
            ps.setString(1,art.getNombre().toUpperCase());
            ps.setFloat(2, art.getPrecio());
            ps.setInt(3, art.getCantidad());
            ps.setInt(4, art.getProveedor().getId_Proveedor());
            ps.setString(5, art.getCod_prov().toUpperCase());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarArticulo(int idart){
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("UPDATE articulos set Estado = 'V' where Id_Articulo = ?");
            ps.setInt(1, idart);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarArticulo(Articulo a) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement(
                    "Update articulos set Nombre = ?, Precio = ?, Cantidad = "
                            + "?, Id_Proveedor=?, Codigo_Proveedor=? Where "
                            + "Id_Articulo = ?");
            ps.setString(1, a.getNombre().toUpperCase());
            ps.setFloat(2, a.getPrecio());
            ps.setInt(3, a.getCantidad());
            ps.setInt(4,a.getProveedor().getId_Proveedor());
            ps.setString(5,a.getCod_prov());
            ps.setInt(6, a.getId_Articulo());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void actualizarArticuloPorCodigo(Map mapa, int id_proveedor) {
        try {
            float precio;
            String codigo;
            Iterator it = mapa.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry e = (Map.Entry)it.next();
                precio = (float) e.getValue();
                codigo = (String) e.getKey();
                PreparedStatement ps = conexion.obtenerConexion().prepareStatement(
                        "Update articulos set Precio = ? Where "
                                + "Codigo_Proveedor = ? and Id_Proveedor = ?");
                ps.setFloat(1, precio);
                ps.setString(2, codigo);
                ps.setInt(3, id_proveedor);
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public ResultSet listarArticulos(){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select articulos.Id_Articulo, articulos.Nombre, "
                        + "articulos.Precio, articulos.Cantidad, "
                        + "proveedores.Nombre, articulos.Codigo_Proveedor "
                        + "from articulos, proveedores WHERE articulos.Estado "
                        + "= 'N' and articulos.Id_Proveedor = proveedores.Id "
                        + "Order By articulos.Cantidad");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet listarArticulosEnStock(){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select articulos.Id_Articulo, articulos.Nombre, "
                        + "articulos.Precio, articulos.Cantidad, "
                        + "proveedores.Nombre, articulos.Codigo_Proveedor "
                        + "from articulos, proveedores WHERE articulos.Estado "
                        + "= 'N' and articulos.Id_Proveedor = proveedores.Id "
                        + "and Cantidad != 0 Order By articulos.Cantidad");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
            
    public ResultSet listarArticulosFiltro(String nom){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select * from articulos where Estado = 'N' AND Nombre "
                        + "LIKE '%"+nom.toUpperCase()+"%' Order By Cantidad");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet listarArticulosFiltroEnStock(String nombre){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select * from articulos where Estado = 'N' AND Cantidad != 0 AND Nombre "
                        + "LIKE ? Order By Cantidad");
            ps.setString(1, "%" + nombre.toUpperCase() + "%");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet consultarArticulo(int Id_Articulo){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select * from articulos  WHERE "
                        + "Estado = 'N' AND Id_Articulo = ?");
            ps.setInt(1, Id_Articulo);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet listarArticulosCantidad(){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select * from articulos  WHERE Estado = 'N' AND Cantidad>0 "
                        + "Order By Cantidad");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void actualizarStockCompra(int Id_Articulo, int Cantidad){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("update articulos set Cantidad = Cantidad - ? "
                        + "WHERE Id_Articulo = ?");
            ps.setInt(1, Cantidad);
            ps.setInt(2,Id_Articulo);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void actualizarCantidadQuitar(int Id_Articulo, int Cantidad){
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("update articulos SET Cantidad = Cantidad+? WHERE "
                        + "Id_Articulo = ?");
            ps.setInt(1, Cantidad);
            ps.setInt(2,Id_Articulo);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //CLIENTES
    public ResultSet buscarClientes(double dni){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select * from clientes WHERE Estado = 'N' AND DNI = ?");
            ps.setDouble(1, dni);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void agregarCliente(Cliente cliente){
        PreparedStatement ps;
        try {
            ps = conexion.obtenerConexion().prepareStatement
                ("Select * FROM clientes where DNI = ?");
            ps.setInt(1, cliente.getDNI());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ps = conexion.obtenerConexion().prepareStatement
                    ("Update clientes set Nombre = ?, Apellido = ?, "
                            + "Estado = 'N', deuda = 0 Where DNI  = ?");
                ps.setInt(3, cliente.getDNI());
                ps.setString(1, cliente.getNombre().toUpperCase());
                ps.setString(2, cliente.getApellido().toUpperCase());
                ps.execute();
            }else{
                ps = conexion.obtenerConexion().prepareStatement
                    ("INSERT INTO clientes(DNI, Nombre, Apellido, Estado) "
                            + "VALUES (?,?,?,'N')");
                ps.setInt(1, cliente.getDNI());
                ps.setString(2, cliente.getNombre().toUpperCase());
                ps.setString(3, cliente.getApellido().toUpperCase());
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarCliente(int Id_Cliente){
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("Update clientes set Estado = 'V' WHERE DNI = ?");
            ps.setInt(1, Id_Cliente);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarCliente(Cliente c) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement(
                    "Update clientes set Nombre = ?, Apellido = ? WHERE DNI = ?");
            ps.setString(1, c.getNombre().toUpperCase());
            ps.setString(2, c.getApellido().toUpperCase());
            ps.setInt(3, c.getDNI());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ResultSet listarClientes(){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select * from clientes WHERE Estado = 'N' Order By DNI");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
            
    public ResultSet listarClientesFiltro(int dni){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select * from clientes where Estado = 'N' AND DNI LIKE "
                        + "'%"+dni+"%' Order By DNI");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //COMPRA
    public int insertarNuevaCompra(Compra com, ArrayList<CompraArticulo> v){
        int Id_Compra = 0;
        java.util.Date myDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        CompraArticulo ca = new CompraArticulo();
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("INSERT INTO compras(Fecha, Id_Cliente,Total) VALUES (?,?,?)");
            ps.setDate(1, sqlDate);
            ps.setInt(2,com.getCliente().getDNI());
            ps.setFloat(3, com.getTotal());
            ps.execute();
            ps = conexion.obtenerConexion().prepareStatement
                ("SELECT MAX(Id_Compra) as Id_Compra FROM compras");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Id_Compra = rs.getInt("Id_Compra");
            }
            for( int i = 0 ; i < v.size() ; i++ ){
                ca = (CompraArticulo) v.get(i);
                System.out.println(ca.getArticulo().getId_Articulo());
                ps = conexion.obtenerConexion().prepareStatement
                    ("INSERT INTO comprasarticulos"
                            + "(Id_Compra, Id_Articulo, Cantidad) "
                            + "VALUES (?,?,?)");
                ps.setInt(1, Id_Compra);
                ps.setInt(2, ca.getArticulo().getId_Articulo());
                ps.setInt(3, ca.getCantidad());
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Id_Compra;
    }

   
    //Proveedores
    public void agregarProveedor(Proveedor p){
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("INSERT INTO proveedores(Nombre, CampoId, CampoPrecio, Estado) "
                        + "VALUES (?,?,?,'N')");
            ps.setString(1,p.getNombre().toUpperCase());
            ps.setInt(2, p.getCampoId());
            ps.setInt(3,p.getCampoPrecio());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void actualizarProveedor(Proveedor p) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("Update proveedores set Nombre = ?, CampoId = ?, CampoPrecio=? "
                        + "WHERE Id = ?");
            ps.setString(1, p.getNombre().toUpperCase());
            ps.setInt(2, p.getCampoId());
            ps.setInt(3, p.getCampoPrecio());
            ps.setInt(4, p.getId_Proveedor());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet buscarProveedor(int id){
        ResultSet rs= null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("Select * from proveedores where Id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet listarProveedores() {
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("Select * from proveedores where Estado = 'N'");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet listarProveedoresFiltro(String nombre){
        ResultSet rs = null;
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select * from proveedores where Estado = 'N' AND "
                        + "Nombre LIKE '%"+nombre+"%' Order By Id");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void eliminarProveedor(int idprov) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("Update proveedores set Estado = 'V', deuda = 0 WHERE Id = ?");
            ps.setInt(1, idprov);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearDeuda(int dni, float deuda) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("Select * from clientes where DNI = ? and Estado = 'N'");
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                float deudaActual = rs.getFloat("deuda");
                
                ps = conexion.obtenerConexion().prepareStatement
                ("Update clientes set deuda = ? where DNI = ?");
                ps.setFloat(1, deudaActual + deuda);
                ps.setInt(2, dni);
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Cliente> consultarDeudas() {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("Select * from clientes where Estado = 'N' and deuda != 0");
            ResultSet rs = ps.executeQuery();
            List<Cliente> clientes = new ArrayList<Cliente>();
            Cliente cliente;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setDNI(rs.getInt("DNI"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setDeuda(rs.getFloat("deuda"));
                clientes.add(cliente);
            }
            rs.close();
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Cliente> consultarDeudasFiltro(int dni) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("select * from clientes where Estado = 'N' AND DNI LIKE "
                        + "'%"+dni+"%' AND deuda != 0 Order By DNI");
            ResultSet rs = ps.executeQuery();
            List<Cliente> clientes = new ArrayList<Cliente>();
            Cliente cliente;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setDNI(rs.getInt("DNI"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setDeuda(rs.getFloat("deuda"));
                clientes.add(cliente);
            }
            rs.close();
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void actualizarDeuda(int dni, float monto) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement
                ("Select * from clientes where DNI = ? and Estado = 'N'");
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                float deudaActual = rs.getFloat("deuda");
                
                ps = conexion.obtenerConexion().prepareStatement
                ("Update clientes set deuda = ? where DNI = ?");
                ps.setFloat(1, deudaActual - monto);
                ps.setInt(2, dni);
                ps.execute();
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean loggin(Usuario usuario) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement(
                    "Select * from usuarios where usuario = ? and contraseña = ?");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContraseña());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                return true;
            }
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;                
    }
    
    public boolean crearUsuario(Usuario usuario) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement(
                    "Insert into usuarios (usuario, contraseña) value (?,?)");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContraseña());
            ps.execute();
            ps.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean actualizarContraseña(Usuario usuario) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement(
                    "Update usuarios set contraseña = ? where usuario = ?");
            ps.setString(2, usuario.getUsuario());
            ps.setString(1, usuario.getContraseña());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public int eliminarUsuario(String usuario) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement(
                    "Select count(*) from usuarios");
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                int cantidadRegistros = rs.getInt(1);
                
                if(cantidadRegistros > 1) {
                    ps = conexion.obtenerConexion().prepareStatement(
                    "Delete from usuarios where usuario = ?");
                    ps.setString(1, usuario);
                    
                    ps.close();
                    rs.close();
                    return 1;
                    
                } else {
                    rs.close();
                    ps.close();
                    return 2;
                }
            }
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public ResultSet consultarUsuarios() {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement(
                    "Select usuario from usuarios");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet consultarUsuariosFiltro(String usuario) {
        try {
            PreparedStatement ps = conexion.obtenerConexion().prepareStatement(
                    "Select usuario from usuarios where usuario like ?");
            ps.setString(1, "%" + usuario + "%");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
