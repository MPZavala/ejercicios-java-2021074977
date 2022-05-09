
package modelos;


public class ModeloFacturacion {
    
    private int id_factura;
    private double monto_factura;
    private String fecha_factura;
    private int idusuario_factura;
    private int orden_factura;

    public ModeloFacturacion(int id_factura, double monto_factura, String fecha_factura, int idusuario_factura, int orden_factura) {
        this.id_factura = id_factura;
        this.monto_factura = monto_factura;
        this.fecha_factura = fecha_factura;
        this.idusuario_factura = idusuario_factura;
        this.orden_factura = orden_factura;
    }
    
    

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public double getMonto_factura() {
        return monto_factura;
    }

    public void setMonto_factura(double monto_factura) {
        this.monto_factura = monto_factura;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public int getIdusuario_factura() {
        return idusuario_factura;
    }

    public void setIdusuario_factura(int idusuario_factura) {
        this.idusuario_factura = idusuario_factura;
    }

    public int getOrden_factura() {
        return orden_factura;
    }

    public void setOrden_factura(int orden_factura) {
        this.orden_factura = orden_factura;
    }
    
    
    
}
