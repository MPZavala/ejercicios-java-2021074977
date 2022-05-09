
package modelos;


public class ModeloProducto {
    
    private int id_producto;
    private double costo_unidad_producto;
    private int disponible_producto;
    private String nombre_producto;

    public ModeloProducto(int id_producto, double costo_unidad_producto, int disponible_producto, String nombre_producto) {
        this.id_producto = id_producto;
        this.costo_unidad_producto = costo_unidad_producto;
        this.disponible_producto = disponible_producto;
        this.nombre_producto = nombre_producto;
    }
    
    

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getCosto_unidad_producto() {
        return costo_unidad_producto;
    }

    public void setCosto_unidad_producto(double costo_unidad_producto) {
        this.costo_unidad_producto = costo_unidad_producto;
    }

    public int getDisponible_producto() {
        return disponible_producto;
    }

    public void setDisponible_producto(int disponible_producto) {
        this.disponible_producto = disponible_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
    
    
}
