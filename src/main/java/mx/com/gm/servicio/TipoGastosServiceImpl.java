
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.ITipoGastosDAO;
import mx.com.gm.domain.TipoGastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hugo
 */
@Service
public class TipoGastosServiceImpl implements TipoGastosService{

    @Autowired
    private ITipoGastosDAO tipoGastosDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoGastos> listarTipoGastos() {

        return (List<TipoGastos>) tipoGastosDao.findAll();
    }

    @Override
    @Transactional
    public void guardarTipoGastos(TipoGastos tipogastos) {
        tipoGastosDao.save(tipogastos);

    }

    @Override
     @Transactional(readOnly = true)
    public TipoGastos encontrarTipoGastos(TipoGastos tipogastos) {
          return tipoGastosDao.findById(tipogastos.getIdTipo()).orElse(null);
    
    }
    
}
