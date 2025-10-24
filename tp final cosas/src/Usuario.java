import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public abstract class Usuario {
    String nombre;
    String mail;///hacer hashcode p' q no repita
    String password;
    String DNI; ///hacer hashcode p' q no repita
    Direccion direccion;
    Boolean activo;
    Map<String, String> users;



    /// Constructores

    public Usuario(String nombre, String mail, String password, String DNI, Direccion direccion, Boolean activo) {
        this.nombre = nombre;
        this.mail = mail;
        this.password = password;
        this.DNI = DNI;
        this.direccion = direccion;
        this.activo = activo;
        this.users = new HashMap<>(users);
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

    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /// Metodos

    public boolean logIn (String mail, String password){
        Iterator<Map.Entry<String, String>> it = users.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry<String, String> aux = it.next();
            if(aux.getKey().equals(mail) && aux.getValue().equals(password)){
                return true;
            }
        }
        return false;
    }

    public String logOut (){
        boolean estado = activo;
        if (estado==true){
            return "Cerrando sesion";
        }
        return "La sesion ya se encuentra cerrada";
    }

    public boolean activo (){
        boolean activo;

        return  activo = logIn(this.mail, this.password);

    }

    // Overrides

    @Override
    public String toString() {
        return  "Nombre: " + nombre +
                "Mail: " + mail +
                "Password: " + password +
                "DNI: " + DNI +
                "Direccion: " + direccion +
                "Activo: " + activo;
    }

    ///HashCode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(mail, usuario.mail) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, password);
    }
}
