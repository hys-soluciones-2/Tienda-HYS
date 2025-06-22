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
@Table(name = "tipo_gastos")
public class TipoGastos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTipo;
    private String nombre;
    private String descripcion;

    //________________________________
//    @OneToMany
//    @JoinColumn(name = "id_tipo") // Este nombre debe coincidir con el de la tabla `gastos`
//    private List<Gastos> gastos;

}
