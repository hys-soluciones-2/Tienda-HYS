package mx.com.gm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

/**
 *
 * @author Hugo
 */
@Data
@Entity
@Table(name = "ventas")
public class Ventas implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVenta;
    @NotNull(message = "La fecha es obligatoria")
    private Date fecha;
    @Positive
    private double total;
}
