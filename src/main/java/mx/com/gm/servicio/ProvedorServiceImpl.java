package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.IProvedorDAO;
import mx.com.gm.domain.Provedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hugo
 */
@Service
public class ProvedorServiceImpl implements ProvedorService{

    //Inyectamos una instancia de ProvedorDAO a una variaable local
    @Autowired
    private IProvedorDAO provedorDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Provedores> listaProvedores() {
       
        return (List<Provedores>) provedorDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Provedores provedor) {
        
        provedorDao.save(provedor);
    }

    @Override
    @Transactional(readOnly = true)
    public Provedores encontrarProvedor(Provedores provedor) {
       
      return  provedorDao.findById(provedor.getIdProvedor()).orElse(null);
    }
    
}
