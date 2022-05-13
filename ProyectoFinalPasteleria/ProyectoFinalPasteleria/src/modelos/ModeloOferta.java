
package modelos;


public class ModeloOferta {
    
    private int id_oferta;
    private int producto_oferta;
    private double valor_oferta;
    private String detalles_oferta;
    private String nombre_producto;

    public ModeloOferta() {
    }

    
    
    

    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
    }

    public int getProducto_oferta() {
        return producto_oferta;
    }

    public void setProducto_oferta(int producto_oferta) {
        this.producto_oferta = producto_oferta;
    }

    public double getValor_oferta() {
        return valor_oferta;
    }

    public void setValor_oferta(double valor_oferta) {
        this.valor_oferta = valor_oferta;
    }

    public String getDetalles_oferta() {
        return detalles_oferta;
    }

    public void setDetalles_oferta(String detalles_oferta) {
        this.detalles_oferta = detalles_oferta;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
    
    
}
