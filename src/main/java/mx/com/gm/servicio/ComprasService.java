
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Compras;

/**
 *
 * @author Hugo
 */
public interface ComprasService {
    
     public List<Compras> listarCompras();
    
    public void gusrdarCompras(Compras Compra);
    
    public Compras encontrarCompra(Compras Compra);
    
}
