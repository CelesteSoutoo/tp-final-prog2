import java.util.concurrent.locks.Condition;

public final class Empleado_Sucursal extends Empleado{
    int numVentas;
    double bono;
    Turnos turno;
    String deducciones;

    /// Constructores

    public Empleado_Sucursal(String nombre, String mail, String password, String DNI, Direccion direccion, Boolean activo,
                              tipoEmpleado tipo, Double ingreso, categoriaEmpleado categoria,
                             int numVentas, double bono, Turnos turno, String deducciones) {
        super(nombre, mail, password, DNI, direccion, activo, tipo, ingreso, categoria);
        this.numVentas = numVentas;
        this.bono = bono;
        this.turno = turno;
        this.deducciones = deducciones;
    }

    public Empleado_Sucursal(String nombre, String mail, String password, String DNI, Direccion direccion, Boolean activo,
                               tipoEmpleado tipo, Double ingreso, categoriaEmpleado categoria) {
        super(nombre, mail, password, DNI, direccion, activo, tipo, ingreso, categoria);

    }

    public Empleado_Sucursal() {
        this.idEmpleado = contador++;
    } ///vacio

    /// G - S

    public int getNumVentas() {
        return numVentas;
    }
    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    public double getBono() {
        return bono;
    }
    public void setBono(double bono) {
        this.bono = bono;
    }

    public Turnos getTurno() {
        return turno;
    }
    public void setTurno(Turnos turno) {
        this.turno = turno;
    }

    public String getDeducciones() {
        return deducciones;
    }
    public void setDeducciones(String deducciones) {
        this.deducciones = deducciones;
    }

    /// Metodos
    // cambiar retornos y cuerpo
    public void vender (Consumidor consumidor){
        double total = consumidor.totalCarrito();
    }

    public void cambiarMercaderia(){

    }
    public String devolverDinero (int monto, double porcentajeBono){
        this.bono -= monto * porcentajeBono;
    return "Devolución de $" + monto + " procesada.";
    }
    public String anularVenta (){
        if (numVentas > 0) {
            numVentas--;
            return "Venta anulada, total de ventas ahora: " + numVentas;
        }
        return "No hay ventas para anular.";
        }
    public String deposito (){
        return "";
    }///ver metodo
    public String llevarLibros (){return "";}///ver metodo
    /*
    public String entregaLibro (Usuario usuario, Venta venta){
        return "Entrega de libro al usuario " + usuario.getNombre();
    }; /// Error xq no esta la clase venta */
    private Boolean ventaCorrespondePersona (Consumidor consumidor){
        return consumidor != null && consumidor.getDNI().equals(this.getDNI());}
    public void pedirProveedor (){}///ver metodo
    public void cierre (){}///ver metodo
}
