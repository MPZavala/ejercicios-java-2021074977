
package modelos;


public class ModeloLibros {
    
    private int id_libro;
    private String nombre_libro;
    private int autor_libro;
    private String codigo_libro;
    private int editorial_libro;
    private int tipo_libro;
    private double precio_libro;
    private int stock_libro;

    public ModeloLibros(int id_libro, String nombre_libro, int autor_libro, String codigo_libro, int tipo_libro, double precio_libro, int stock_libro) {
        this.id_libro = id_libro;
        this.nombre_libro = nombre_libro;
        this.autor_libro = autor_libro;
        this.codigo_libro = codigo_libro;
        this.tipo_libro = tipo_libro;
        this.precio_libro = precio_libro;
        this.stock_libro = stock_libro;
    }
    
    

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public int getAutor_libro() {
        return autor_libro;
    }

    public void setAutor_libro(int autor_libro) {
        this.autor_libro = autor_libro;
    }

    public String getCodigo_libro() {
        return codigo_libro;
    }

    public void setCodigo_libro(String codigo_libro) {
        this.codigo_libro = codigo_libro;
    }

    public int getEditorial_libro() {
        return editorial_libro;
    }

    public void setEditorial_libro(int editorial_libro) {
        this.editorial_libro = editorial_libro;
    }

    public int getTipo_libro() {
        return tipo_libro;
    }

    public void setTipo_libro(int tipo_libro) {
        this.tipo_libro = tipo_libro;
    }

    public double getPrecio_libro() {
        return precio_libro;
    }

    public void setPrecio_libro(double precio_libro) {
        this.precio_libro = precio_libro;
    }

    public int getStock_libro() {
        return stock_libro;
    }

    public void setStock_libro(int stock_libro) {
        this.stock_libro = stock_libro;
    }
    
    
    
}
