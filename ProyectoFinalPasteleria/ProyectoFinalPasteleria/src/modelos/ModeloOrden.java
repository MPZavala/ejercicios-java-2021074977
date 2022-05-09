
package modelos;


public class ModeloOrden {
    
    private int numero_orden;
    private int empleado_orden;
    private String nombre_cliente_orden;
    private int producto_orden;
    private String extras_orden;
    private String fecha_entrega;
    private int tipo_entrega;
    private double costo_total;
    private int oferta_id;
    private int cantidad_producto;
    private int relleno_orden;
    private int betun_orden;
    private int bizcocho_orden;
    private String direccion_orden;

    public ModeloOrden(int numero_orden, int empleado_orden, String nombre_cliente_orden, int producto_orden, String extras_orden, String fecha_entrega, int tipo_entrega, double costo_total, int oferta_id, int cantidad_producto, int relleno_orden, int betun_orden, int bizcocho_orden, String direccion_orden) {
        this.numero_orden = numero_orden;
        this.empleado_orden = empleado_orden;
        this.nombre_cliente_orden = nombre_cliente_orden;
        this.producto_orden = producto_orden;
        this.extras_orden = extras_orden;
        this.fecha_entrega = fecha_entrega;
        this.tipo_entrega = tipo_entrega;
        this.costo_total = costo_total;
        this.oferta_id = oferta_id;
        this.cantidad_producto = cantidad_producto;
        this.relleno_orden = relleno_orden;
        this.betun_orden = betun_orden;
        this.bizcocho_orden = bizcocho_orden;
        this.direccion_orden = direccion_orden;
    }
    
    

    public int getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(int numero_orden) {
        this.numero_orden = numero_orden;
    }

    public int getEmpleado_orden() {
        return empleado_orden;
    }

    public void setEmpleado_orden(int empleado_orden) {
        this.empleado_orden = empleado_orden;
    }

    public String getNombre_cliente_orden() {
        return nombre_cliente_orden;
    }

    public void setNombre_cliente_orden(String nombre_cliente_orden) {
        this.nombre_cliente_orden = nombre_cliente_orden;
    }

    public int getProducto_orden() {
        return producto_orden;
    }

    public void setProducto_orden(int producto_orden) {
        this.producto_orden = producto_orden;
    }

    public String getExtras_orden() {
        return extras_orden;
    }

    public void setExtras_orden(String extras_orden) {
        this.extras_orden = extras_orden;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getTipo_entrega() {
        return tipo_entrega;
    }

    public void setTipo_entrega(int tipo_entrega) {
        this.tipo_entrega = tipo_entrega;
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }

    public int getOferta_id() {
        return oferta_id;
    }

    public void setOferta_id(int oferta_id) {
        this.oferta_id = oferta_id;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public int getRelleno_orden() {
        return relleno_orden;
    }

    public void setRelleno_orden(int relleno_orden) {
        this.relleno_orden = relleno_orden;
    }

    public int getBetun_orden() {
        return betun_orden;
    }

    public void setBetun_orden(int betun_orden) {
        this.betun_orden = betun_orden;
    }

    public int getBizcocho_orden() {
        return bizcocho_orden;
    }

    public void setBizcocho_orden(int bizcocho_orden) {
        this.bizcocho_orden = bizcocho_orden;
    }

    public String getDireccion_orden() {
        return direccion_orden;
    }

    public void setDireccion_orden(String direccion_orden) {
        this.direccion_orden = direccion_orden;
    }
    
    
    
}
