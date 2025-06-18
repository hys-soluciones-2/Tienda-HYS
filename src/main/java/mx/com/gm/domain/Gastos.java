package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;
import mx.com.gm.domain.TipoGastos;

/**
 *
 * @author Hugo
 */
@Data
@Entity
@Table(name = "gastos")
public class Gastos implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGasto;
    private Date fecha;
    private double valor;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo") // Este nombre debe coincidir con el de la tabla `gastos`
    private TipoGastos tipoGasto;
}
