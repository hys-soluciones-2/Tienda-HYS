
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.DetalleCompras;

/**
 *
 * @author Hugo
 */
public interface DetalleComprasService {

    public List<DetalleCompras> listarDetalleCompras();

    public void gusrdarDetalleComprasCompras(DetalleCompras detalleCompra);

    public DetalleCompras encontrarDetalleCompras(DetalleCompras detalleCompra);

}
