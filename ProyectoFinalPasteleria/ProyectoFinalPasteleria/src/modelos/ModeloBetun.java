
package modelos;


public class ModeloBetun {
    
    private int id_betun;
    private String nombre_betun;

    public ModeloBetun(int id_betun, String nombre_betun) {
        this.id_betun = id_betun;
        this.nombre_betun = nombre_betun;
    }
    

    public int getId_betun() {
        return id_betun;
    }

    public void setId_betun(int id_betun) {
        this.id_betun = id_betun;
    }

    public String getNombre_betun() {
        return nombre_betun;
    }

    public void setNombre_betun(String nombre_betun) {
        this.nombre_betun = nombre_betun;
    }
    
    
    
}
