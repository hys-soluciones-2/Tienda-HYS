
package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Hugo
 */
@Data
@Entity
@Table(name = "detalle_compras")
public class DetalleCompras implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetalleCompra;
    
       
    @ManyToOne
    @JoinColumn(name = "id_compra") // Este nombre debe coincidir con el de la tabla compras`
    private Compras compra;
   
       
    @ManyToOne
    @JoinColumn(name = "id_producto") // Este nombre debe coincidir con el de la tabla `productos'
    private Productos producto;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "precio_unitario")
    private double precioUnitario;
}
