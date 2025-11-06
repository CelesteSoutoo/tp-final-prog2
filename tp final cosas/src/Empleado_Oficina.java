import java.util.*;

public final class Empleado_Oficina extends Empleado implements Iconsultas{

    List<String> locales;
    Queue<String>observaciones;

    /// Constructores

    public Empleado_Oficina(String nombre, String mail, String password, String DNI, Direccion direccion, Boolean activo,
                            tipoEmpleado tipo, Double ingreso, categoriaEmpleado categoria) {
        super(nombre, mail, password, DNI, direccion, activo, tipo, ingreso, categoria);
        this.locales = new ArrayList<>();
        this.observaciones = observaciones;
    }

    public Empleado_Oficina() {
        this.idEmpleado = contador++;
    } ///vacio

    /// G - S

    public List<String> getLocales() {
        return locales;
    }

    public Queue<String> getObservaciones() {
        return observaciones;
    }

    /// Metodos

    public void modifCaja(){

    }
    public void modifDepositos(){}
    public void modifHorarios (){}
    public void modifSalarios (){}

    /// interfaz consultas
    @Override
    public int agregarObjeto(Object o) {
        return 0;
    }

    @Override
    public int eliminarObjeto(Object o) {
        return 0;
    }

    @Override
    public int buscarObjeto(Object o) {
        return 0;
    }

    @Override
    public boolean verificarVacio() {
        return false;
    }
}
