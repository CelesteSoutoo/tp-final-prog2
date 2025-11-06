import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class GestorConsumidores {

    List<Consumidor> listaConsumidores;

    public GestorConsumidores() {
        this.listaConsumidores = new LinkedList<>();
    }

    public List<Consumidor> getConsumidores() {
        return listaConsumidores;
    }

    public void agregarConsumidor(Consumidor consumidor){
        listaConsumidores.add(consumidor);
    }

    ///----------------------------------- SERIALIZACION DE CONSUMIDORES -----------------------------------///

    public JSONObject serializarConsumidor (Consumidor consumidor){
        JSONObject objeto = null;
        JSONArray arrayCarrito = null;
        try{
            objeto = new JSONObject();
            arrayCarrito = new JSONArray();

            objeto.put("nombre", consumidor.getNombre());
            objeto.put("mail", consumidor.getMail());
            objeto.put("password", consumidor.getPassword());
            objeto.put("DNI", consumidor.getDNI());
            objeto.put("activo", consumidor.getActivo());

            for (Libro l : consumidor.getCarrito()){
                arrayCarrito.put(GestorLibros.serializarLibro (l));
            }
            objeto.put("carrito", arrayCarrito);
            objeto.put("historial_compras", consumidor.getHistorial_compras());
            objeto.put("cantidad_compras", consumidor.getCantidad_compras());

        }catch (JSONException e){
            e.printStackTrace();
        }
        return objeto;
    }
    public JSONArray serializarListaCOnsumidores (){
        JSONArray arrayConsumidores = null;
        try{
            arrayConsumidores = new JSONArray();
            for (Consumidor consumidor : listaConsumidores){
                arrayConsumidores.put(serializarConsumidor(consumidor));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return arrayConsumidores;
    }






}
