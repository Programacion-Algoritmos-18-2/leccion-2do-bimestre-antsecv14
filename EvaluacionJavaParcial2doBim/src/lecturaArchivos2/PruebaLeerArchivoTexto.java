package lecturaArchivos2;

// Fig. 14.12: PruebaLeerArchivoTexto.java
import java.io.IOException;
import java.util.ArrayList;

public class PruebaLeerArchivoTexto {

    public static void main(String args[]) throws IOException {
        //Creamos un objeto de la clase LeerArchivoTexto 
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        //Creamos un objeto tipo OperacionData
        OperacionData operacion = new OperacionData();
        //Declaramos la ubicacion de nuestros datos como un String
        String informacion = "data/data2.txt";
        String informacion2 = "data/data1.csv";
        //Enviamos la ubucacion de informacion al metodo abrirArchivo mediante el objeto aplicacion
        aplicacion.abrirArchivo(informacion);
        //La lista resultante del metodo LeerRegistros se volvera lista1 
        ArrayList<Profesor> lista1 = aplicacion.leerRegistros();
        //Enviamos la ubicacion de informacion2 al metodo abrirArchivo  mediante el objeto aplicacion
        aplicacion.abrirArchivo(informacion2);
        //La lista resultante del metodo LeerRegistros2 se volvera lista2
        ArrayList<Profesor> lista2 = aplicacion.leerRegistros2();
        //Creamos una lista con el nombre lista combinada para agregar los valores de las dos listas
        ArrayList<Profesor> listacombinada = new ArrayList<>();
        //Mediante el siguiente for agregamos a cada participante de la lista1
        for (int i = 0; i < lista1.size(); i++) {
            listacombinada.add(lista1.get(i));
        }
        //Mediante el siguiente for agregamos a cada participante de la lista2
        for (int i = 0; i < lista2.size(); i++) {
            listacombinada.add(lista2.get(i));
        }
        
        //Enviamos listacombinada al metodo agregarInformacion esto para utilizar la misma en las operaciones
        operacion.agregarInformacion(listacombinada);
        
        //llamamos al metodo ordenarPorCanton para imprimir todos los participantes ordenados por canton
        operacion.ordenarPorCanton();
        
        //La lista resultante del metodo ordenarPorNombres en la presente clase sera lista_ordenada
        ArrayList<Profesor> lista_ordenada = operacion.ordenarPorNombres();
        //Enviamos la lista_ordenada a nuestra clase escribirArchivo para crear un nuevo txt en el que se ingresaran todos los participantes
        //ordenados por nombre
        aplicacion.escribirArchivo(lista_ordenada);
        System.out.println("---Tabulacion de personalidad e idoneidad---");
        //llamamos al metodo conteo_personalidad y conteo_idoeidad para imprimir la tabulacion de la variable personalidad e idoneidad
        operacion.conteo_personalidad();
        operacion.conteo_idoneidad();
        //Finalmente Cerramos el Archivo
        aplicacion.cerrarArchivo();
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto

