
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.TipoGastos;


public interface TipoGastosService {
    
    public List<TipoGastos> listarTipoGastos();
    
    public void guardarTipoGastos(TipoGastos tipogastos);
    
    public TipoGastos encontrarTipoGastos(TipoGastos tipogastos);
    
}
