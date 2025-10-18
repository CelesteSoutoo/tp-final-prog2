import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Empleado_Oficina extends Empleado implements Iconsultas{

    List<String> locales;
    Queue<String>observaciones;

    /// Constructores

    public Empleado_Oficina(String nombre, String mail, String password, String DNI, String direccion, Boolean activo,
                            int idEmpleado, tipoEmpleado tipo, Double ingreso, categoriaEmpleado categoria,
                            List<String> locales, Queue<String> observaciones) {
        super(nombre, mail, password, DNI, direccion, activo, idEmpleado, tipo, ingreso, categoria);
        this.locales = new ArrayList<>();
        this.observaciones = observaciones;
    }

    public Empleado_Oficina(String nombre, String mail, String password, String DNI, String direccion, Boolean activo,
                            int idEmpleado, tipoEmpleado tipo, Double ingreso, categoriaEmpleado categoria) {
        super(nombre, mail, password, DNI, direccion, activo, idEmpleado, tipo, ingreso, categoria);
    }

    public Empleado_Oficina() {
    } ///vacio

    /// G - S

    /// Metodos

    public void modifCaja(){}
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
