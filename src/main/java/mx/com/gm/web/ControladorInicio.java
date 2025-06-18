package mx.com.gm.web;

import mx.com.gm.dao.IComprasDAO;
import mx.com.gm.dao.IDetalleComprasDAO;
import mx.com.gm.dao.IEstadosComprasDAO;
import mx.com.gm.dao.IGastosDAO;
import mx.com.gm.dao.ITipoGastosDAO;
import mx.com.gm.dao.IVentasDAO;
import mx.com.gm.domain.EstadosCompras;
import mx.com.gm.domain.Gastos;
import mx.com.gm.domain.Productos;
import mx.com.gm.domain.Provedores;
import mx.com.gm.domain.TipoGastos;
import mx.com.gm.domain.Ventas;
import mx.com.gm.servicio.ComprasService;
import mx.com.gm.servicio.DetalleComprasService;
import mx.com.gm.servicio.ProductoService;
import mx.com.gm.servicio.ProvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import mx.com.gm.servicio.EstadosComprasService;
import mx.com.gm.servicio.GastosService;
import mx.com.gm.servicio.TipoGastosService;
import mx.com.gm.servicio.VentasService;

/**
 *
 * @author Hugo Para que Spring reconosca esta clase se agrega la anotacion
 * @Controller
 */
@Controller
public class ControladorInicio {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProvedorService provedorService;

    @Autowired
    private EstadosComprasService estadoComprasServicio;

    @Autowired
    private TipoGastosService tipoGastosService;

    @Autowired
    private VentasService ventasService;

    @Autowired
    private GastosService gastosService;

    @Autowired
    private DetalleComprasService detalleComprasService;

    @Autowired
    private ComprasService compraService;


    
    

    //============================================================
    //Esta anotacion me muestra que va hacer una peticion de tipo Get
    //con una ruta en blanco
    @GetMapping("/")
    public String inicio() {

        return "index";//Es la pagina que se mostrara
    }
//------------------------------------------------------------
    //------Maping de Productos

    @GetMapping("/listarProductos")
    public String listar(Model model) {
        var productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "listarProductos";//Es la pagina que se mostrara;
    }

    //Se agrega el pahf de agregar
    @GetMapping("/agregarProducto")
    public String agregar(Productos producto) {
        return "modificarProducto";
    }

    @PostMapping("/guardarProducto")
    public String guardar(Productos producto) {
        productoService.guardar(producto);
        return "redirect:/listarProductos";//Es la pagina que se mostrara;
    }

    @GetMapping("/editar/{idProducto}")
    public String editar(Productos producto, Model model) {
        var productos = productoService.encontrarProducto(producto);
        model.addAttribute("productos", productos);
        return "modificarProducto";//Es la pagina que se mostrara;
    }

    //-------------------------------------------------------
    //Maping de la tabla de provedores
    @GetMapping("/listarProvedores")
    public String listarProvedor(Model model) {
        var provedores = provedorService.listaProvedores();
        model.addAttribute("provedores", provedores);
        return "listarProvedores";//Es la pagina que se mostrara;
    }

    @GetMapping("/agregarProvedor")
    public String agregar(Provedores provedor) {
        return "modificarProvedor";//Es la pagina que se mostrara;
    }

    @PostMapping("/guardarProvedor")
    public String guardar(Provedores provedor) {
        provedorService.guardar(provedor);
        return "redirect:/listarProvedores";//se redirige a la pagina que deseo ir
    }

    @GetMapping("/editarProvedor/{idProvedor}")
    public String editar(Provedores provedor, Model model) {
        provedor = provedorService.encontrarProvedor(provedor);
        model.addAttribute("provedores", provedor);
        return "modificarProvedor";//Es la pagina que se mostrara;
    }

    //---------------------------------------------------------
    //Maping  de Estados Compras
    @GetMapping("/listarEstadosCompras")
    public String listarEstadosCompras(Model model) {
        var estadosCompras = estadoComprasServicio.listarEstadosCompras();
        model.addAttribute("estadosCompras", estadosCompras);
        return "listarEstadosCompras";//Es la pagina que se mostrara;
    }

    @GetMapping("/agregarEstadoCompras")
    public String agregar(EstadosCompras estadosCompras) {
        return "modificarEstadoCompras";//Es la pagina que se mostrara;
    }

    @PostMapping("/guardarEstadoCompras")
    public String guardarEstado(EstadosCompras estadosCompras) {
        estadoComprasServicio.gusrdarEstadosCompras(estadosCompras);
        return "redirect:/listarEstadosCompras";//Es la pagina que se mostrara;
    }

    @GetMapping("/editarEstadoCompra/{idEstado}")
    public String editar(EstadosCompras estadosCompras, Model model) {
        estadosCompras = estadoComprasServicio.encontrarEstadosCompras(estadosCompras);
        model.addAttribute("estadosCompras", estadosCompras);
        return "modificarEstadoCompras";
    }

    //---------------------------------------------------------
    //-----------Maping de Tipo de de Gastos
    @GetMapping("/listarTipoGastos")
    public String listarTipoGastos(Model model) {
        var tipoGastos = tipoGastosService.listarTipoGastos();
        model.addAttribute("tipoGastos", tipoGastos);
        return "listarTipoGastos";//Es la pagina que se mostrara;
    }

    @GetMapping("/agregarTipoGastos")
    public String agregar(TipoGastos tipoGastos) {
        return "modificarTipoGastos";
    }

    @PostMapping("/guardarTipoGastos")
    public String guardarTipo(TipoGastos tipoGastos) {
        tipoGastosService.guardarTipoGastos(tipoGastos);
        return "redirect:/listarTipoGastos";
    }

    @GetMapping("/editarTipoGastos/{idTipo}")
    public String editar(TipoGastos tipoGastos, Model model) {
        tipoGastos = tipoGastosService.encontrarTipoGastos(tipoGastos);
        model.addAttribute("tipoGastos", tipoGastos);
        return "/modificarTipoGastos";
    }

    //-----------------------------------------------------------
    //----------Maping de tabla de Ventas--------------------
    @GetMapping("/listarVentas")
    public String listarVentas(Model model) {
        var venta = ventasService.listarVentas();
        model.addAttribute("ventas", venta);
        return "/listarVentas";
    }

    @GetMapping("/agregarVentas")
    public String agregar(Ventas venta) {
        return "modificarVentas";
    }

    @PostMapping("/guardarVentas")
    public String guardarVenta(Ventas venta) {
        ventasService.guardarVentas(venta);
        return "redirect:/listarVentas";
    }

    @GetMapping("/editarVentas/{idVenta}")
    public String editar(Ventas venta, Model model) {
        venta = ventasService.encontrarVenta(venta);
        model.addAttribute("ventas", venta);
        return "/modificarVentas";
    }

    //----------------------------------------------------
    //---------------Mapping de tabla de Gastos----------------
    @GetMapping("/listarGastos")
    public String listarGastos(Model model) {
        var gastos = gastosService.listarGastos();
        model.addAttribute("gastos", gastos);
        model.addAttribute("tipoGastos", gastos);
        return "/listarGastos";
    }

    @GetMapping("/agregarGastos")
    public String agregar(Gastos gasto, Model model) {

        var listaTipos = tipoGastosService.listarTipoGastos();
        model.addAttribute("gasto", gasto); // esto es necesario para th:object
        model.addAttribute("tipoGastos", tipoGastosService.listarTipoGastos());// esto llena el select
        return "modificarGastos";
    }

    @PostMapping("/guardarGasto")
    public String guardarGasto(Gastos gasto) {
        gastosService.gusrdarGastos(gasto);
        return "redirect:/listarGastos";
    }

    @GetMapping("/editarGasto/{idGasto}")
    public String editarGasto(Gastos gasto, Model model) {
        gasto = gastosService.encontrarGasto(gasto);
        model.addAttribute("gastos", gasto);
        model.addAttribute("tipoGastos", tipoGastosService.listarTipoGastos());// esto llena el select
        return "/modificarGastos";
    }

    //----------------------------------------------------
    //---------------Mapping de tabla de Compras----------------
    @GetMapping("/listarCompras")
    public String listarCompras(Model model) {
        var listaCompras1 = compraService.listarCompras();
        
        model.addAttribute("compras", listaCompras1);
      //  model.addAttribute("estado", estadoComprasServicio.listarEstadosCompras());
      //  model.addAttribute("provedores", provedorService.listaProvedores());
       // model.addAttribute("detalleCompras", detalleComprasService.listarDetalleCompras());
        return "/listarCompras";//Me redirecciona o muestra esta pagina
    }

}
