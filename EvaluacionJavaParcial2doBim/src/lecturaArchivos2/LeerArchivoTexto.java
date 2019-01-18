package lecturaArchivos2;

// Fig. 14.11: LeerArchivoTexto.java
// Este programa lee un archivo de texto y muestra cada registro.

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
import com.google.gson.Gson;
import java.io.BufferedWriter;

public class LeerArchivoTexto {

    private Scanner entrada;

    // Creamos una clase abrirArchivo esto para poder abrir el txt y el csv
    public void abrirArchivo(String informacion) {
        try {
            entrada = new Scanner(new File(informacion));
            
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo
    // En LeerRegistros procedemos a leer el diccionario(data2.txt)
    public ArrayList<Profesor> leerRegistros() {

        ArrayList<Profesor> lista = new ArrayList<>();

        try // lee registros del archivo, usando el objeto Scanner
        {
            entrada.nextLine();
    
            while (entrada.hasNext()) {
                // se crea el objeto para leer Json
                Gson g = new Gson();
                String linea = entrada.nextLine();
                // se hace el proceso de transformación
                Profesor p = g.fromJson(linea, Profesor.class);
                lista.add(p);
                //System.out.println(p);

            } // fin de while

        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista;
    } // fin del m�todo leerRegistros
    
    public ArrayList<Profesor> leerRegistros2() {
       // Creación de una lista para almacenar los datos
        ArrayList<Profesor> lista = new ArrayList<>();
  
        try{
            String linea = entrada.nextLine();
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                // procedemos a hacer un split al ArrayList
                ArrayList<String> lineas = new ArrayList<String>(Arrays.asList(linea.split(",")));
                Profesor prof = new Profesor();        
                prof.setCedula(lineas.get(0));   
                prof.setNombres(lineas.get(1));
                prof.setZona(lineas.get(2));
                prof.setProvincia(lineas.get(3));
                prof.setCanton(lineas.get(4));
                prof.setPersonalidad(lineas.get(5));
                prof.setRazonamiento(lineas.get(6));
                prof.setDictamenIdoniedad(lineas.get(7));
                // Agregamos agregamos todos los objetos a lineas
                lista.add(prof);
            } 
        }
        //Catchs para ver los errores en la ejecución
        catch (NoSuchElementException elementException) {           
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } 
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } 
        return lista;                               
    }
    public void escribirArchivo(ArrayList<Profesor> lista) throws IOException {
        // String que sera el nombre del archivo
        String ruta = "data/Orden_por_nombres.txt";
        // Creamos un objeto tipo File
        File archivo = new File(ruta);
        // se crea el objeto en el que ingresaran los datos ordenados
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        BufferedWriter bw = null;
        String cadena = "";
        // Try para empezar a escribir
        try {
            // Ingresamos la informacion en el archivo
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero ya esta creado");
            bw = new BufferedWriter(new FileWriter(archivo));
            // en el siguiente for se ingresan y se guarda toda la informacion
            for (int i = 0; i < lista.size(); i++) {
                Profesor prof = lista.get(i);
                cadena = String.format("%s|%s|%s|%s|%s|%s|%s|%s\n",
                        prof.getCedula(), prof.getNombres(), prof.getZona(), prof.getProvincia(), prof.getCanton(),
                        prof.getPersonalidad(), prof.getRazonamiento(), prof.getDictamenIdoniedad());
                // Se escribe la cadena dentro del archivo
                bw.write(cadena);
            }
            // Cerramos el archivo
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
} // fin de la clase LeerArchivoTexto

/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/
