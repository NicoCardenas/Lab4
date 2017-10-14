package aplicacion;   
 
/**
 * @version ECI 2017-2
 */

public class Personaje{
    private String nombreCorto;
    private String nombre;
    private String epoca;
    private String productos;    
    private String descripcion;

 
    public Personaje(String nombreCorto, String nombre,  String epoca, String productos, String descripcion){
        this.nombreCorto = nombreCorto.trim();
        this.nombre = nombre.trim();
        this.epoca = epoca.trim();
        this.productos = productos.trim();
        this.descripcion = descripcion.trim();
    }
    
    /**
     * @return 
     */
    public String getNombreCorto(){
        return nombreCorto;
    }

    /**
     * @return 
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * @return 
     */
    public String getEpoca(){
        return epoca;
    }
    
    /**
     * @return 
     */
    public String getProductos(){
        return productos;
    }
    
    /**
     * @return 
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * @return 
     */
    public String toString(){
        return nombreCorto + "\n" + nombre + "\n" + productos + "\n"+descripcion;
    }

}
