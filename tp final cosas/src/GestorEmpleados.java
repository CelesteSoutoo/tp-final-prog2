import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GestorEmpleados {
    List<Empleado> listaEmpleados;

    public GestorEmpleados() {
        this.listaEmpleados = new LinkedList<>();
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void agregarEmpleado (Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    ///----------------------------------- SERIALIZACION DE EMPLEADOS -----------------------------------///

    public JSONObject serializarEmpleadoOfic (Empleado_Oficina empleado){
        JSONObject objeto = null;
        JSONArray arrayLocales = null;
        JSONArray arrayObserv = null;
        try{
            objeto = new JSONObject();
            arrayLocales = new JSONArray();
            arrayObserv = new JSONArray();

            objeto.put("nombre", empleado.getNombre());
            objeto.put("mail", empleado.getMail());
            objeto.put("password", empleado.getPassword());
            objeto.put("DNI", empleado.getDNI());
            objeto.put("activo", empleado.getActivo());
            objeto.put("idEmpleado", empleado.getIdEmpleado());
            objeto.put("tipo", empleado.getTipo());
            objeto.put("ingreso", empleado.getIngreso());
            objeto.put("categoria", empleado.getCategoria());

            for (String local : empleado.getLocales()){
                arrayLocales.put(local);
            } ///JSONArray de locales
            objeto.put("locales", arrayLocales);

            for (String observacion : empleado.getObservaciones()){
                arrayObserv.put(observacion);
            } ///JSONArray de observaciones
            objeto.put("observaciones", arrayObserv);

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

    public JSONArray serializarListaEmpleadosCompleta (){
        JSONArray arrayEmpleados = null;
        try{
            arrayEmpleados = new JSONArray();
            for (Empleado empleado : listaEmpleados){
                if (empleado.tipo.equals("empleadoSucursal")){
                    arrayEmpleados.put(serializarEmpleadoSuc((Empleado_Sucursal)empleado));
                }
                else{
                    arrayEmpleados.put(serializarEmpleadoOfic((Empleado_Oficina) empleado));
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return arrayEmpleados;
    }
    public JSONArray serializarListaEmpleadosOficina (){
        JSONArray arrayEmpleados = null;
        try{
            arrayEmpleados = new JSONArray();
            for (Empleado empleado : listaEmpleados){
                if (empleado.tipo.equals("empleadoOficina")){
                arrayEmpleados.put(serializarEmpleadoOfic((Empleado_Oficina)empleado));
                }
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        return arrayEmpleados;
    }
    public JSONArray serializarListaEmpleadosSucursal (){
        JSONArray arrayEmpleados = null;
        try{
            arrayEmpleados = new JSONArray();
            for (Empleado empleado : listaEmpleados){
                if (empleado.tipo.equals("empleadoSucursal")){
                arrayEmpleados.put(serializarEmpleadoSuc((Empleado_Sucursal) empleado));
                }
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        return arrayEmpleados;
    }

    ///----------------------------------- DESERIALIZACION DE EMPLEADOS -----------------------------------///

    public Empleado_Oficina deserializarEmpleadoOfic (JSONObject jObj){
        Empleado_Oficina empleado = new Empleado_Oficina();
        try{
            empleado.setNombre(jObj.getString("nombre"));
            empleado.setMail(jObj.getString("mail"));
            empleado.setPassword(jObj.getString("password"));
            empleado.setDNI(jObj.getString("DNI"));
            empleado.setActivo(jObj.getBoolean("activo"));
            empleado.setIdEmpleado(jObj.getInt("idEmpleado"));
            empleado.setTipo(tipoEmpleado.valueOf(jObj.getString("tipo")));
            empleado.setIngreso(jObj.getDouble("ingreso"));
            empleado.setCategoria((categoriaEmpleado) jObj.get("categoria"));
            ///FALTAN 2 LISTAS

        }catch (Exception e){
            e.printStackTrace();
        }
        return empleado;
    }
    public Empleado_Sucursal deserializarEmpleadoSuc (JSONObject jObj){
        Empleado_Sucursal empleado = new Empleado_Sucursal();
        try{
            empleado.setNombre(jObj.getString("nombre"));
            empleado.setMail(jObj.getString("mail"));
            empleado.setPassword(jObj.getString("password"));
            empleado.setDNI(jObj.getString("DNI"));
            empleado.setActivo(jObj.getBoolean("activo"));
            empleado.setIdEmpleado(jObj.getInt("idEmpleado"));
            empleado.setTipo(tipoEmpleado.valueOf(jObj.getString("tipo")));
            empleado.setIngreso(jObj.getDouble("ingreso"));
            empleado.setCategoria((categoriaEmpleado) jObj.get("categoria"));
            empleado.setNumVentas(jObj.getInt("numVentas"));
            empleado.setBono(jObj.getDouble("bono"));
            empleado.setTurno((Turnos) jObj.get("turno"));
            empleado.setDeducciones(jObj.getString("deducciones"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return empleado;
    }

    public List <Empleado_Oficina> deserializarListaEmpleadosOficina (JSONArray jArray){
        List <Empleado_Oficina> listaEmpleadosOficina = new ArrayList();
        try{
            for (int i = 0; i<jArray.length(); i++){
                listaEmpleadosOficina.add(deserializarEmpleadoOfic(jArray.getJSONObject(i)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaEmpleadosOficina;
    }///VER SI ES EL TIPO DE LISTA, EXCEPCION
    public List<Empleado_Sucursal> deserializarListaEmpleadosSucursal(JSONArray jArray){
        List <Empleado_Sucursal> listaEmpleados = new ArrayList();
        try{
            for (int i = 0; i<jArray.length(); i++){
                listaEmpleados.add(deserializarEmpleadoSuc(jArray.getJSONObject(i)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaEmpleados;
    }


}
