
package modelos;


public class ModeloTipoMovimiento {
    
    private int id_tipomovimiento;
    private String descrip_tipomovimiento;

    public ModeloTipoMovimiento(int id_tipomovimiento, String descrip_tipomovimiento) {
        this.id_tipomovimiento = id_tipomovimiento;
        this.descrip_tipomovimiento = descrip_tipomovimiento;
    }
    
    

    public int getId_tipomovimiento() {
        return id_tipomovimiento;
    }

    public void setId_tipomovimiento(int id_tipomovimiento) {
        this.id_tipomovimiento = id_tipomovimiento;
    }

    public String getDescrip_tipomovimiento() {
        return descrip_tipomovimiento;
    }

    public void setDescrip_tipomovimiento(String descrip_tipomovimiento) {
        this.descrip_tipomovimiento = descrip_tipomovimiento;
    }
    
    
    
}
