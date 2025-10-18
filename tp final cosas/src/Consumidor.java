import java.util.ArrayList;
import java.util.List;

public class Consumidor extends Usuario{
    List<Libro> carrito; ///error xq no esta clase libro
    String historial_compras; //ventas
    Integer cantidad_compras;


    /// Constructores

    public Consumidor(String nombre, String mail, String password, String DNI, String direccion, Boolean activo,
                      List<Libro> carrito, String historial_compras, Integer cantidad_compras) {
        super(nombre, mail, password, DNI, direccion, activo);
        this.carrito = new ArrayList<>();
        this.historial_compras = historial_compras;
        this.cantidad_compras = cantidad_compras;
    }

    public Consumidor(String nombre, String mail, String password, String DNI, String direccion, Boolean activo) {
        super(nombre, mail, password, DNI, direccion, activo);
    }

    public Consumidor (){}

    /// G - S
    public String getHistorial_compras() {
        return historial_compras;
    }
    public void setHistorial_compras(String historial_compras) {
        this.historial_compras = historial_compras;
    }

    public Integer getCantidad_compras() {
        return cantidad_compras;
    }
    public void setCantidad_compras(Integer cantidad_compras) {
        this.cantidad_compras = cantidad_compras;
    }

    /// Metodos

    public void verCarrito (){}
    public void verUltimasCompras (){}
    public void totalCarrito (){}
    public void pagar (){} ///nedios de pago distintos
    public void vaciarCarrito(){}
}
