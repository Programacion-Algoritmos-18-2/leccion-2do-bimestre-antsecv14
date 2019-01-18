/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author reroes
 */
public class OperacionData {

    ArrayList<Profesor> informacion = new ArrayList<>();

    public void agregarInformacion(ArrayList<Profesor> info) {
        //informacion = new ArrayList<Profesor>(info.subList(1, 4));
        informacion = info;
    }

    public ArrayList<Profesor> obtenerInformacion() {
        return informacion;
    }

    public double obtenerPromedioCapacidad() {
        double suma = 0;
        return suma;
    }

    // proceso de ordenar, a través del uso de Collections\
    //Mediante el siguiente metodo se ordena la informacion por canton
    public void ordenarPorCanton() {
        ArrayList<Profesor> dataPorCantones = new ArrayList<>();
        dataPorCantones.addAll(informacion);
        Collections.sort(dataPorCantones,
                (o1, o2) -> o1.canton.compareTo(o2.canton));
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.println(dataPorCantones.get(i));
        }
    }
    
    //Mediante el siguiente metodo se ordena la informacion por nombres
    public ArrayList<Profesor> ordenarPorNombres() {
        ArrayList<Profesor> dataPorNombres = new ArrayList<>();
        dataPorNombres.addAll(informacion);
        Collections.sort(dataPorNombres,
                (o1, o2) -> o1.nombres.compareTo(o2.nombres));
        return dataPorNombres;

    }

    public void conteo_personalidad() {
        // Se declaran dos contadores para los casos de su respectivo nombre
        int adecuado = 0;
        int por_convocar = 0;
        // Dentro del siguiente for comprovamos si el participante es adecuado o esta por convocar y
        // a las variables anteriormente declaradas se les ira sumando 1 dependiendo de la condicion
        for (int i = 0; i < this.informacion.size(); i++) {
            if (this.informacion.get(i).getPersonalidad().equals("ADECUADO")) {
                adecuado = adecuado + 1;
            } else if (this.informacion.get(i).getPersonalidad().equals("POR CONVOCAR")) {
                por_convocar = por_convocar + 1;
            }
        }
        //Se presentan los resultados
        System.out.printf("La cantidad de participantes adecuados: %d\n", adecuado);
        System.out.printf("La cantidad de participantes por convocar: %d\n", por_convocar);
    }
    public void conteo_idoneidad() {
        // Se declaran dos contadores para los casos de su respectivo nombre
        int idoneo = 0;
        int no_idoneo = 0;
        // Dentro del siguiente for comprovamos si el participante es idoneo o no idoneo 
        for (int i = 0; i < this.informacion.size(); i++) {
            if (this.informacion.get(i).getDictamenIdoniedad().equals("IDONEO")) {
                idoneo = idoneo + 1;
            } else if (this.informacion.get(i).getDictamenIdoniedad().equals("NO IDONEO")) {
                no_idoneo = no_idoneo + 1;
            }
        }
        // Se presentan los resultados 
        System.out.printf("La cantidad de participantes idoneo: %d\n", idoneo);
        System.out.printf("La cantidad de participantes no idoneo: %d\n", no_idoneo);
    }
// En el siguiente metodo se leen los datos
    public void lecturaData() {
        for (int i = 0; i < obtenerInformacion().size(); i++) {
            System.out.println(obtenerInformacion().get(i));

        }

    }

}
