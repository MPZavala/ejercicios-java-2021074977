
package modelos;


public class ModeloMovimientos {
    
    private int id_movimientos;
    private int codigolibro_movimientos;
    private String fechasalida_movimientos;
    private String fechadevolucion_movimientos;
    private String fechaventa_movimientos;
    private int idusuario_movimientos;
    private int tipo_movimientos;

    public ModeloMovimientos(int id_movimientos, int codigolibro_movimientos, String fechasalida_movimientos, String fechadevolucion_movimientos, String fechaventa_movimientos, int idusuario_movimientos, int tipo_movimientos) {
        this.id_movimientos = id_movimientos;
        this.codigolibro_movimientos = codigolibro_movimientos;
        this.fechasalida_movimientos = fechasalida_movimientos;
        this.fechadevolucion_movimientos = fechadevolucion_movimientos;
        this.fechaventa_movimientos = fechaventa_movimientos;
        this.idusuario_movimientos = idusuario_movimientos;
        this.tipo_movimientos = tipo_movimientos;
    }
    
    

    public int getId_movimientos() {
        return id_movimientos;
    }

    public void setId_movimientos(int id_movimientos) {
        this.id_movimientos = id_movimientos;
    }

    public int getCodigolibro_movimientos() {
        return codigolibro_movimientos;
    }

    public void setCodigolibro_movimientos(int codigolibro_movimientos) {
        this.codigolibro_movimientos = codigolibro_movimientos;
    }

    public String getFechasalida_movimientos() {
        return fechasalida_movimientos;
    }

    public void setFechasalida_movimientos(String fechasalida_movimientos) {
        this.fechasalida_movimientos = fechasalida_movimientos;
    }

    public String getFechadevolucion_movimientos() {
        return fechadevolucion_movimientos;
    }

    public void setFechadevolucion_movimientos(String fechadevolucion_movimientos) {
        this.fechadevolucion_movimientos = fechadevolucion_movimientos;
    }

    public String getFechaventa_movimientos() {
        return fechaventa_movimientos;
    }

    public void setFechaventa_movimientos(String fechaventa_movimientos) {
        this.fechaventa_movimientos = fechaventa_movimientos;
    }

    public int getIdusuario_movimientos() {
        return idusuario_movimientos;
    }

    public void setIdusuario_movimientos(int idusuario_movimientos) {
        this.idusuario_movimientos = idusuario_movimientos;
    }

    public int getTipo_movimientos() {
        return tipo_movimientos;
    }

    public void setTipo_movimientos(int tipo_movimientos) {
        this.tipo_movimientos = tipo_movimientos;
    }
    
    
    
}
