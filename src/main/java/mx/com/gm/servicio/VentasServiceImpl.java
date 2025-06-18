
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.IVentasDAO;
import mx.com.gm.domain.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hugo
 */
@Service
public class VentasServiceImpl implements VentasService{
    
    @Autowired
    private IVentasDAO ventasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ventas> listarVentas() {
        return (List<Ventas>) ventasDao.findAll();

    }

    @Override
    @Transactional
    public void guardarVentas(Ventas venta) {
        ventasDao.save(venta);

    }

    @Override
    @Transactional(readOnly = true)
    public Ventas encontrarVenta(Ventas venta) {
        return ventasDao.findById(venta.getIdVenta()).orElse(null);

    }
    
}
