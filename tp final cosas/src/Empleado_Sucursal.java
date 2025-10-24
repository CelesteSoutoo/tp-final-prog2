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

    public void cambiarMercaderia(){}
    public void devolverDinero (){}
    public void anularVenta (){}
    public void deposito (){}
    public void llevarLibros (){}
    public void entregaLibro (Usuario DNI, Venta id){}; /// Error xq no esta la clase venta
    private Boolean ventaCorrespondePersona (){return true;} ///ver retorno
    public void pedirProveedor (){}
    public void cierre (){}
}
