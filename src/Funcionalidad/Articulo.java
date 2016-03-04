package Funcionalidad;

public class Articulo {
    private int Id_Articulo;
    private String Nombre;
    private float Precio;
    private int Cantidad;
    private Proveedor Proveedor;
    private String cod_prov;

    public String getCod_prov() {
        return cod_prov;
    }

    public void setCod_prov(String cod_prov) {
        this.cod_prov = cod_prov;
    }

    public Proveedor getProveedor() {
        return Proveedor;
    }

    public void setProveedor(Proveedor Proveedor) {
        this.Proveedor = Proveedor;
    }

    public int getId_Articulo() {
        return Id_Articulo;
    }

    public void setId_Articulo(int Id_Articulo) {
        this.Id_Articulo = Id_Articulo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
    
}
