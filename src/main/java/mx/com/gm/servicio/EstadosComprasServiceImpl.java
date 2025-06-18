
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.IEstadosComprasDAO;
import mx.com.gm.domain.EstadosCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hugo
 */
@Service
public class EstadosComprasServiceImpl implements EstadosComprasService{

    
    //Inyectamos una instaancia de la clase de tipo EstadosCompraDao
    @Autowired
    private IEstadosComprasDAO estadoComprasDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<EstadosCompras> listarEstadosCompras() {
        return   (List<EstadosCompras>) estadoComprasDao.findAll();

    }

    @Override
    @Transactional
    public void gusrdarEstadosCompras(EstadosCompras estadoCompra) {
        estadoComprasDao.save(estadoCompra);

    }

    @Override
    @Transactional(readOnly = true)
    public EstadosCompras encontrarEstadosCompras(EstadosCompras estadoCompra) {
       return estadoComprasDao.findById(estadoCompra.getIdEstado()).orElse(null);
        

    }

 
}
