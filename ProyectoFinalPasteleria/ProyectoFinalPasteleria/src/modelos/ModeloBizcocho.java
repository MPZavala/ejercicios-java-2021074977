
package modelos;


public class ModeloBizcocho {
    private int id_bizcocho;
    private String nombre_bizcocho;

    public ModeloBizcocho(int id_bizcocho, String nombre_bizcocho) {
        this.id_bizcocho = id_bizcocho;
        this.nombre_bizcocho = nombre_bizcocho;
    }
    
    

    public int getId_bizcocho() {
        return id_bizcocho;
    }

    public void setId_bizcocho(int id_bizcocho) {
        this.id_bizcocho = id_bizcocho;
    }

    public String getNombre_bizcocho() {
        return nombre_bizcocho;
    }

    public void setNombre_bizcocho(String nombre_bizcocho) {
        this.nombre_bizcocho = nombre_bizcocho;
    }
    
    
    
}
