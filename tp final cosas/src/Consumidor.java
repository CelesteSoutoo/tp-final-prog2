import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class Consumidor extends Usuario{
    List<Libro> carrito; ///error xq no esta clase libro
    String historial_compras; //ventas
    Integer cantidad_compras;


    /// Constructores

    public Consumidor(String nombre, String mail, String password, String DNI, Direccion direccion, Boolean activo,
                      String historial_compras, Integer cantidad_compras) {
        super(nombre, mail, password, DNI, direccion, activo);
        this.carrito = new ArrayList<>();
        this.historial_compras = historial_compras;
        this.cantidad_compras = cantidad_compras;
    }

    public Consumidor(String nombre, String mail, String password, String DNI, Direccion direccion, Boolean activo) {
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

    public void verCarrito (){
        ListIterator <Libro> it = carrito.listIterator();
        while (it.hasNext()){
            Libro aux = (Libro) it.next();
            System.out.println(aux);
        }
    }
    public void verUltimasCompras (){}///falta
    public Double totalCarrito (){

        ListIterator<Libro>it=carrito.listIterator();
        double total=0;
        while (it.hasNext()){
            total=total+it.next().getPrecio();
        }
        return total;
    }
    public void pagar (){} ///medios de pago distintos - falta
    public String vaciarCarrito(){
        carrito.clear();
    return "Se vacio el carrito";
    }
}
