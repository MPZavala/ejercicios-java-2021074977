
package modelos;


public class ModeloTipoLibro {
    
    private int id_tipolibro;
    private String desc_tipolibro;

    public ModeloTipoLibro(int id_tipolibro, String desc_tipolibro) {
        this.id_tipolibro = id_tipolibro;
        this.desc_tipolibro = desc_tipolibro;
    }
    
    

    public int getId_tipolibro() {
        return id_tipolibro;
    }

    public void setId_tipolibro(int id_tipolibro) {
        this.id_tipolibro = id_tipolibro;
    }

    public String getDesc_tipolibro() {
        return desc_tipolibro;
    }

    public void setDesc_tipolibro(String desc_tipolibro) {
        this.desc_tipolibro = desc_tipolibro;
    }
    
    
    
}
