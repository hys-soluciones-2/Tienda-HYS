
package mx.com.gm.dao;

import mx.com.gm.domain.Ventas;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author Hugo
 */
public interface IVentasDAO extends CrudRepository<Ventas, Long>{
    
}
