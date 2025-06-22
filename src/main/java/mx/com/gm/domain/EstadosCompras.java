package mx.com.gm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;
    //---------------------------------------  
    @OneToMany
    @JoinColumn(name = "id_estado")
    private List<Compras> compras;
    //---------------------------------------
}
