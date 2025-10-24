public abstract class Empleado extends Usuario {
    int idEmpleado;
    static int contador=0;
    tipoEmpleado tipo;
    Double ingreso; ///hora
    categoriaEmpleado categoria;

    /// Constructores

    public Empleado(String nombre, String mail, String password, String DNI, Direccion direccion, Boolean activo,
                     tipoEmpleado tipo, Double ingreso, categoriaEmpleado categoria) {
        super(nombre, mail, password, DNI, direccion, activo);
        this.idEmpleado = ++contador;
        this.tipo = tipo;
        this.ingreso = ingreso;
        this.categoria = categoria;
    }

    public Empleado(String nombre, String mail, String password, String DNI, Direccion direccion, Boolean activo) {
        super(nombre, mail, password, DNI, direccion, activo);
        this.idEmpleado = contador++;
    }

    public Empleado() {
        this.idEmpleado = contador++;
    }

    /// S - G
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public tipoEmpleado getTipo() {
        return tipo;
    }
    public void setTipo(tipoEmpleado tipo) {
        this.tipo = tipo;
    }

    public Double getIngreso() {
        return ingreso;
    }
    public void setIngreso(Double ingreso) {
        this.ingreso = ingreso;
    }

    public categoriaEmpleado getCategoria() {
        return categoria;
    }
    public void setCategoria(categoriaEmpleado categoria) {
        this.categoria = categoria;
    }

    /// Metodos


}
