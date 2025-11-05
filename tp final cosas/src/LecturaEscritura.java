import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public final class LecturaEscritura {

    public static void escribirArchivo (String archivo, JSONObject jObj){
        File file = new File(archivo);
        try{
            FileWriter fw = new FileWriter(file);
            fw.write(jObj.toString(4));
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static JSONTokener leerArchivo (String archivo){
        File file = new File(archivo);
        JSONTokener jsonTokener = null;
        try{
            jsonTokener = new JSONTokener(new FileReader(file));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return jsonTokener;
    }
}
