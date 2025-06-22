package mx.com.gm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import java.sql.Date;
//import java.time.LocalDate;
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
    
    @NotNull(message = "La fecha es obligatoria")
    private Date fecha;
    
    @Positive
    private double valor;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo") // Este nombre debe coincidir con el de la tabla `gastos`
    private TipoGastos tipoGasto;
}
