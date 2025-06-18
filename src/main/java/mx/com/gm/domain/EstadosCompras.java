package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Hugo
 */
@Data
@Entity
@Table(name = "estados_compras")
public class EstadosCompras implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstado;

    private String nombre;
    private String descripcion;
    //---------------------------------------  
    @OneToMany
    @JoinColumn(name = "id_estado")
    private List<Compras> compras;
    //---------------------------------------
}
