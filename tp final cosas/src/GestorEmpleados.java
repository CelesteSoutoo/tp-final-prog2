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
}
