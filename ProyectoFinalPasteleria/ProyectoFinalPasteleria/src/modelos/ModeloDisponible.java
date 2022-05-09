
package modelos;


public class ModeloDisponible {
    
    private int id_disponible;
    private String disponibilidad;

    public ModeloDisponible(int id_disponible, String disponibilidad) {
        this.id_disponible = id_disponible;
        this.disponibilidad = disponibilidad;
    }
    
    

    public int getId_disponible() {
        return id_disponible;
    }

    public void setId_disponible(int id_disponible) {
        this.id_disponible = id_disponible;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
    
}
