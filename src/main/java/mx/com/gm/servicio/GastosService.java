
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Gastos;

/**
 *
 * @author Hugo
 */
public interface GastosService {
    
     
    public List<Gastos> listarGastos();
    
    public void gusrdarGastos(Gastos gasto);
    
    public Gastos encontrarGasto(Gastos gasto);
    
    
}
