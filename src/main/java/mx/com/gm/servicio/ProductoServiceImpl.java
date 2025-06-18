package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.IProductoDAO;
import mx.com.gm.domain.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hugo
 */
@Service
public class ProductoServiceImpl implements ProductoService{
    //importamos una instancia de IProductosDAO
    @Autowired
    private IProductoDAO productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Productos> listarProductos() {
      return (List<Productos>)productoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Productos producto) {
        productoDao.save(producto);
        
    }

    @Override
    @Transactional
    public void eliminar(Productos producto) {
       productoDao.delete(producto);
        
    }

    @Override
     @Transactional(readOnly = true)
    public Productos encontrarProducto(Productos producto) {
     return   productoDao.findById(producto.getIdProducto()).orElse(null);
        
    }
    
}
