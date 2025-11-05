import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestoraJSON {

    public JSONObject serializarEmpleadoOfic (Empleado_Oficina empleado){
        JSONObject objeto = null;
        try{
            objeto = new JSONObject();

            objeto.put("nombre", empleado.getNombre());
            objeto.put("mail", empleado.getMail());
            objeto.put("password", empleado.getPassword());
            objeto.put("DNI", empleado.getDNI());
            objeto.put("activo", empleado.getActivo());
            objeto.put("idEmpleado", empleado.getIdEmpleado());
            objeto.put("tipo", empleado.getTipo());
            objeto.put("ingreso", empleado.getIngreso());
            objeto.put("categoria", empleado.getCategoria());
            /// FALTAN LISTAS DE EMPLEADO_OFICINA

        }catch (JSONException e){
            e.printStackTrace();
        }
        return objeto;
    }
    public JSONObject serializarEmpleadoSuc (Empleado_Sucursal empleado){
        JSONObject objeto = null;
        try{
            objeto = new JSONObject();

            objeto.put("nombre", empleado.getNombre());
            objeto.put("mail", empleado.getMail());
            objeto.put("password", empleado.getPassword());
            objeto.put("DNI", empleado.getDNI());
            objeto.put("activo", empleado.getActivo());
            objeto.put("idEmpleado", empleado.getIdEmpleado());
            objeto.put("tipo", empleado.getTipo());
            objeto.put("ingreso", empleado.getIngreso());
            objeto.put("categoria", empleado.getCategoria());
            objeto.put("numVentas", empleado.getNumVentas());
            objeto.put("bono", empleado.getBono());
            objeto.put("turno", empleado.getTurno());
            objeto.put("deducciones",  empleado.getDeducciones());

        }catch (JSONException e){
            e.printStackTrace();
        }
        return objeto;
    }
    public JSONObject serializarConsumidor (Consumidor consumidor){
        JSONObject objeto = null;
        try{
            objeto = new JSONObject();

            objeto.put("nombre", consumidor.getNombre());
            objeto.put("mail", consumidor.getMail());
            objeto.put("password", consumidor.getPassword());
            objeto.put("DNI", consumidor.getDNI());
            objeto.put("activo", consumidor.getActivo());
            /// FALTA PONER EL CARRITO
            objeto.put("historial_compras", consumidor.getHistorial_compras());
            objeto.put("cantidad_compras", consumidor.getCantidad_compras());

        }catch (JSONException e){
            e.printStackTrace();
        }
        return objeto;
    }
    public JSONObject serializarLibro (Libro libro){
        JSONObject objeto = null;
        try{
            objeto = new JSONObject();

            objeto.put("isbn", libro.getIsbn());
            objeto.put("localId", libro.getLocalId());
            objeto.put("nombre", libro.getNombre());
            /// FALTA LISTA AUTORES
            objeto.put("precio", libro.getPrecio());
            objeto.put("editorial", libro.getEditorial());
            objeto.put("anio", libro.getAnio());
            objeto.put("disponible", libro.isDisponible());
        }catch(JSONException e){
            e.printStackTrace();
        }
        return objeto;
    }
}
