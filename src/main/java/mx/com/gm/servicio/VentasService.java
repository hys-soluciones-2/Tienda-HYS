
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Ventas;

/**
 *
 * @author Hugo
 */
public interface VentasService {
    
     public List<Ventas> listarVentas();
     
     public void guardarVentas(Ventas venta);
     
     public Ventas encontrarVenta(Ventas venta);
}
