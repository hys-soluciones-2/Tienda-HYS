
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.IDetalleComprasDAO;
import mx.com.gm.domain.DetalleCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hugo
 */
@Service
public class DetalleComprasServiceImpl implements DetalleComprasService{

    @Autowired
    private IDetalleComprasDAO detalleCompraDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<DetalleCompras> listarDetalleCompras() {

        return (List<DetalleCompras>) detalleCompraDao.findAll();
    }

    @Override
    @Transactional
    public void gusrdarDetalleComprasCompras(DetalleCompras detalleCompra) {

        detalleCompraDao.save(detalleCompra);
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleCompras encontrarDetalleCompras(DetalleCompras detalleCompra) {

        return detalleCompraDao.findById(detalleCompra.getIdDetalleCompra()).orElse(null);
    }
    
}
