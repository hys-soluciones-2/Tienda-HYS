package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Productos;

/**
 *
 * @author Hugo
 */
public interface ProductoService {
    
    public List<Productos> listarProductos();
    
    public void guardar(Productos producto);
    
    public void eliminar(Productos producto);
    
    public Productos encontrarProducto(Productos producto);
}
