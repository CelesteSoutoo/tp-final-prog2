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

    ///----------------------------------- DESERIALIZACION DE CONSUMIDORES -----------------------------------///

    public Consumidor deserializarConsumidor (JSONObject jobj){
        Consumidor consumidor = new Consumidor();
        try{
            consumidor.setNombre(jobj.getString("nombre"));
            consumidor.setMail(jobj.getString("mail"));
            consumidor.setPassword(jobj.getString("password"));
            consumidor.setDNI(jobj.getString("DNI"));
            consumidor.setActivo(jobj.getBoolean("activo"));
            /// FALTA CARRITO
            consumidor.setHistorial_compras(jobj.getString("historial_compras"));
            consumidor.setCantidad_compras(jobj.getInt("cantidad_compras"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return consumidor;
    }
    public List <Consumidor> deserializarListaConsumidores(JSONArray array){
        List <Consumidor> listaConsumidores = new LinkedList<>();
        try{
            for (int i = 0; i < array.length(); i++){
                listaConsumidores.add(deserializarConsumidor(array.getJSONObject(i)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listaConsumidores;
    }///VER EXCEPCION



}
