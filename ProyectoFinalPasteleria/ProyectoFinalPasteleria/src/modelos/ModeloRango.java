
package modelos;


public class ModeloRango {
    
    private int id_rango;
    private String nombre_rango;

    public ModeloRango(int id_rango, String nombre_rango) {
        this.id_rango = id_rango;
        this.nombre_rango = nombre_rango;
    }
    
    

    public int getId_rango() {
        return id_rango;
    }

    public void setId_rango(int id_rango) {
        this.id_rango = id_rango;
    }

    public String getNombre_rango() {
        return nombre_rango;
    }

    public void setNombre_rango(String nombre_rango) {
        this.nombre_rango = nombre_rango;
    }
    
    
    
}
