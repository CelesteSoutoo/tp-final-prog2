public class Direccion {
    String calle;
    String altura;
    String departamento;
    String ciudad;
    String provincia;
    String pais;


    public Direccion(String calle, String altura, String departamento, String ciudad, String provincia, String pais) {
        this.calle = calle;
        this.altura = altura;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public Direccion(String calle, String altura, String ciudad, String provincia, String pais) {
        this.calle = calle;
        this.altura = altura;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    } ///sin dpto.

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "\n---Direccion---\n" +
                "\nCalle: " + calle +
                "\nAltura: " + altura +
                "\nDepartamento: " + departamento +
                "\nCiudad: " + ciudad +
                "\nProvincia: " + provincia +
                "\nPais: " + pais;
    }
}
