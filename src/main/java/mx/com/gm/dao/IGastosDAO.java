
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
    @Query(value = """
    SELECT g.id_gasto AS idGasto, 
           g.fecha AS fecha, 
           g.valor AS valor, 
           tg.nombre AS tipoDeGasto
    FROM gastos g
    LEFT JOIN tipo_gastos tg USING(id_tipo)
    """, nativeQuery = true)
List<TipoGastos> listarGastosConTipo();

@Query("SELECT g FROM Gastos g LEFT JOIN FETCH g.tipoGasto")
List<Gastos> listarConTipo();

}
