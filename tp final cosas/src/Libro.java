import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Libro{
  //atributos de id
  private String isbn;
  private int local_id; //para identificar libros que no tengan isbn ademas para poder tener un UNICO hashmap que una tanto libros nuevos y usados
  private static int id_statico=1; //para el "local_id"

  //demas atributos
  private String nombre;
  private List<String> autores; /*libros comunes suelen tener 1 a 2 autores pero los de
                                  anatalogia muchos mas, con un array no es eficiente por varias cuestiones*/
  private double precio;
  private String editorial;
  private int anio;
  private Boolean disponible;

  //constructores
  public Libro(String isbn, String nombre, double precio, String editorial, int anio, boolean disponible) {

        this.isbn = isbn;
        this.local_id = id_statico++;
        this.nombre = nombre;
        this.autores = new ArrayList<>(autores);
        this.precio = precio;
        this.editorial = editorial;
        this.anio = anio;
        this.disponible = disponible;
    }

    public Libro(String isbn, String nombre, List<String> autores,
                 double precio, String editorial, int anio) {

        this.isbn = isbn;
        this.local_id = id_statico++;
        this.nombre = nombre;
        this.autores = new ArrayList<>(autores); // copia defensiva
        this.precio = precio;
        this.editorial = editorial;
        this.anio = anio;
        this.disponible= false;
    }

    public Libro(String isbn)
  {
        this.isbn = isbn;
        this.nombre = null;
        this.autores = new ArrayList<>();
        this.precio = 0;
        this.editorial = "";
        this.anio = 0;
        this.disponible= false;
  }

    public Libro() {
        this.autores = new ArrayList<>(autores);
    }

    //get set

  public String getIsbn() {
        return isbn;
    }

    public int getLocalId() {
        return local_id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getAutores() {
        return autores;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutores(List<String> autores) {
        this.autores = new ArrayList<>(autores); // copia defensiva
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setIsbn(String isbn) {
      this.isbn = isbn;
    }

    public void setLocal_id(int local_id) {
        this.local_id = local_id;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    //metodos

  @Override
    public String toString() {
        return "Libro: " + nombre + "\n" +
               "ID_local: " + local_id + "\n" +
               "Autores: " + autores + "\n" +
               "Precio: $" + precio + "\n" +
               "Editorial: " + editorial + "\n" +
               "Año: " + anio + "\n" +
               "Disponible: " + (disponible ? "Sí" : "No");
    }

  @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
  
      Libro otro = (Libro) obj;
      return this.getLocalId()==(otro.getLocalId());
    }

  public Boolean tiene_isbn(){
    if(this.isbn==null)
      return false;
    else
      return true;
    }
}
