import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class GestorLibros {
    List<Libro> listaLibros;

    public GestorLibros() {
        listaLibros = new ArrayList<>();
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void agregarLibro (Libro libro){
        listaLibros.add(libro);
    }

    ///----------------------------------- SERIALIZACION DE LIBROS -----------------------------------///
    public static JSONObject serializarLibro (Libro libro){
        JSONObject objeto = null;
        JSONArray array = null;
        try{
            objeto = new JSONObject();
            array = new JSONArray();

            objeto.put("isbn", libro.getIsbn());
            objeto.put("localId", libro.getLocalId());
            objeto.put("nombre", libro.getNombre());

            for (String autor : libro.getAutores()){
                array.put(autor);
            } ///JSONArray de autores.
            objeto.put("listaAutores", array);
            objeto.put("precio", libro.getPrecio());
            objeto.put("editorial", libro.getEditorial());
            objeto.put("anio", libro.getAnio());
            objeto.put("disponible", libro.isDisponible());
        }catch(JSONException e){
            e.printStackTrace();
        }
        return objeto;
    }
    public JSONArray serializarListaLibros(){
        JSONArray array = null;
        try{
            array = new JSONArray();
            for (Libro libro : listaLibros){
                array.put(serializarLibro(libro));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return array;
    }

    ///----------------------------------- SERIALIZACION DE LIBROS -----------------------------------///

    public Libro deserializarLibro (JSONObject jobj){
        Libro libro = new Libro ();
        try{
            libro.setIsbn(jobj.getString("isbn"));
            libro.setLocal_id(jobj.getInt("localId"));
            libro.setNombre(jobj.getString("nombre"));
            ///FALTA DESERIALIZAR LISTA


            libro.setPrecio(jobj.getInt("precio"));
            libro.setEditorial(jobj.getString("editorial"));
            libro.setAnio(jobj.getInt("anio"));
            libro.setDisponible(jobj.getBoolean("disponible"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return libro;
    } /// VER EXCEPCION
    public List <Libro> deserializarListaLibros (JSONArray jarray){
        List <Libro> lista = new ArrayList<>();
        try{
            for (int i =0; i<jarray.length(); i++){
                lista.add(deserializarLibro(jarray.getJSONObject(i)));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }/// VER EXCEPCION

}
