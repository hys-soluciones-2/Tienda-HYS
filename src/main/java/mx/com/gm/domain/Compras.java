package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Hugo
 */
@Data
@Entity
@Table(name = "compras")
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompra;
    @ManyToOne
    @JoinColumn(name = "id_provedor")
    private Provedores provedor;
    private Date fechaCompra;
    private Date fechaLlegada;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadosCompras estado; // ✅ Debe coincidir con la base de datos
    private static int contadorCompras;
    
   
    @OneToMany(mappedBy = "compra", fetch = FetchType.EAGER) // EAGER para cargar los detalles
    private List<DetalleCompras> detalleCompras = new ArrayList<>();

    // Método para calcular el total de la compra
    public double getTotalCompra() {
        return detalleCompras.stream()
                .mapToDouble(detalle -> detalle.getPrecioUnitario() * detalle.getCantidad())
                .sum();
    }
}
