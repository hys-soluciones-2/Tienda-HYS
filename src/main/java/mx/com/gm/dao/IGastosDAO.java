
package mx.com.gm.dao;

import mx.com.gm.domain.Gastos;
import java.util.List;
import mx.com.gm.domain.TipoGastos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Hugo
 */
public interface IGastosDAO extends CrudRepository<Gastos, Long>{


}
