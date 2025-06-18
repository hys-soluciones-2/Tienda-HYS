
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Provedores;

/**
 *
 * @author Hugo
 */
public interface ProvedorService {
    
    public List<Provedores> listaProvedores();
    
    public void guardar(Provedores provedor);
    
    public Provedores encontrarProvedor(Provedores provedor);
    
    
}
