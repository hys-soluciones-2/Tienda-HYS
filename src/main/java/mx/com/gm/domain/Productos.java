
package mx.com.gm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Hugo
 */
@Data
@Entity
@Table(name="productos")
public class Productos implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProducto;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;
    private boolean estado;
    //------------------------
//     //---------------------------------------  
//    @OneToMany
//    @JoinColumn(name = "id_estado")
//    private List<Compras> compras;
    //---------------------------------------
}
