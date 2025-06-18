
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.IComprasDAO;
import mx.com.gm.domain.Compras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hugo
 */
@Service
public class ComprasServiceImpl implements ComprasService{

    @Autowired
    private IComprasDAO comprasDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Compras> listarCompras() {
        return (List<Compras>) comprasDao.findAll();

    }

    @Override
    @Transactional
    public void gusrdarCompras(Compras compra) {

        comprasDao.save(compra);
    }

    @Override
    @Transactional(readOnly = true)
    public Compras encontrarCompra(Compras compra) {

        return comprasDao.findById(compra.getIdCompra()).orElse(null);
    }
    
}
