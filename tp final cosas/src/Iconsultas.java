public interface Iconsultas <T>{
    //int para hacer un flag si se agrego o no
    int agregarObjeto (T t); //un libro o un nuevo empleado
    int eliminarObjeto (T t);
    int buscarObjeto (T t);
    boolean verificarVacio(); //ver si la lista usada tiene elementos

}
