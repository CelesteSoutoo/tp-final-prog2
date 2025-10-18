import java.util.Objects;

public abstract class Usuario {
    String nombre;
    String mail;///hacer hashcode p' q no repita
    String password;
    String DNI; ///hacer hashcode p' q no repita
    String direccion;
    Boolean activo;



    /// Constructores

    public Usuario(String nombre, String mail, String password, String DNI, String direccion, Boolean activo) {
        this.nombre = nombre;
        this.mail = mail;
        this.password = password;
        this.DNI = DNI;
        this.direccion = direccion;
        this.activo = activo;
    }
    public Usuario() {
    }

    /// G - S

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /// Metodos
    //ver q poner

    public void logIn (){

    }
    public void logOut (){

    }
    public void activo (){

    }

    // Overrides

    @Override//de mail y de dni de user
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(mail, usuario.mail) && Objects.equals(DNI, usuario.DNI);
    }

    @Override//de mail y de dni de user
    public int hashCode() {
        return Objects.hash(mail, DNI);
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre +
                "Mail: " + mail +
                "Password: " + password +
                "DNI: " + DNI +
                "Direccion: " + direccion +
                "Activo: " + activo;
    }
}
