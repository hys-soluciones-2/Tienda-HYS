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
@Table(name = "provedores")
public class Provedores implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProvedor;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;
    private boolean estado;
/*
    @OneToMany
    @JoinColumn(name = "id_provedor")
    private List<Compras> compras; // ✅ Debe coincidir con la base de datos
*/
}
