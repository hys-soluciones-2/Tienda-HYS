
package mx.com.gm.dao;

import mx.com.gm.domain.Productos;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Hugo
 */
public interface IProductoDAO extends CrudRepository<Productos, Long>{
    
    
}
