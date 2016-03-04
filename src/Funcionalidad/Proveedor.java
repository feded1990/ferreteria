package Funcionalidad;

public class Proveedor {
    private int Id_Proveedor;
    private String Nombre;
    private int campoId;
    private int campoPrecio;

    public int getId_Proveedor() {
        return Id_Proveedor;
    }

    public void setId_Proveedor(int Id_Proveedor) {
        this.Id_Proveedor = Id_Proveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCampoId() {
        return campoId;
    }

    public void setCampoId(int campoId) {
        this.campoId = campoId;
    }

    public int getCampoPrecio() {
        return campoPrecio;
    }

    public void setCampoPrecio(int campoPrecio) {
        this.campoPrecio = campoPrecio;
    }
    
    
    
}
