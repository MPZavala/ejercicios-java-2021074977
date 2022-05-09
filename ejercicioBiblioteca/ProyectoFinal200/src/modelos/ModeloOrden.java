
package modelos;


public class ModeloOrden {
    
    private int id_orden;
    private int codigolibro_orden;
    private double monto_orden;
    private int cantidad_orden;

    public ModeloOrden(int id_orden, int codigolibro_orden, double monto_orden, int cantidad_orden) {
        this.id_orden = id_orden;
        this.codigolibro_orden = codigolibro_orden;
        this.monto_orden = monto_orden;
        this.cantidad_orden = cantidad_orden;
    }
    
    

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getCodigolibro_orden() {
        return codigolibro_orden;
    }

    public void setCodigolibro_orden(int codigolibro_orden) {
        this.codigolibro_orden = codigolibro_orden;
    }

    public double getMonto_orden() {
        return monto_orden;
    }

    public void setMonto_orden(double monto_orden) {
        this.monto_orden = monto_orden;
    }

    public int getCantidad_orden() {
        return cantidad_orden;
    }

    public void setCantidad_orden(int cantidad_orden) {
        this.cantidad_orden = cantidad_orden;
    }
    
    
    
}
