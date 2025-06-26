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

    @OneToMany(mappedBy = "compra", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true) // EAGER para cargar los detalles
    private List<DetalleCompras> detalleCompras = new ArrayList<>();

    //Se inicializa el contador de Compras
    public Compras() {
        contadorCompras++;
    }

    //metodo para procesar detalles de la compra
    public void procesarDetalles(List<DetalleCompras> detalles) {
        if (detalles == null || detalles.isEmpty()) {
            return;
        }

        for (DetalleCompras detalle : detalles) {
            if (detalle != null
                    && detalle.getProducto() != null
                    && detalle.getCantidad() > 0
                    && detalle.getPrecioUnitario() > 0) {

                detalle.setCompra(this); // Asocia el detalle con esta compra
                this.detalleCompras.add(detalle); // Agrega a la lista interna
            }
        }
    }
    
     // Método para calcular el total de la compra
    public double getTotalCompra() {
        return detalleCompras.stream()
                .mapToDouble(detalle -> detalle.getPrecioUnitario() * detalle.getCantidad())
                .sum();
    }

}


