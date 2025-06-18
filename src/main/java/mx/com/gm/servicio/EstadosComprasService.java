
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.EstadosCompras;

/**
 *
 * @author Hugo
 */
public interface EstadosComprasService {
    
    public List<EstadosCompras> listarEstadosCompras();
    
    public void gusrdarEstadosCompras(EstadosCompras estadoCompra);
    
    public EstadosCompras encontrarEstadosCompras(EstadosCompras estadoCompra);
    
}
