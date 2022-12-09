package com.mycompany.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //inicializacion de variables
        String sentidoEleva = "Elevador subiendo";

        int pisoActual = 4;
        int cont = 1;
        int tamaEdificio = 29;

        List<Integer> arregloPiso = new ArrayList<>(Arrays.asList(5, 29, 13, 10));

        Map<Integer, Integer> mapPisoAgregado = new HashMap<>();
        mapPisoAgregado.put(5, 2);
        mapPisoAgregado.put(29, 10);
        mapPisoAgregado.put(13, 1);
        mapPisoAgregado.put(10, 1);

        //while que termina el programa cuando el arreglo de pisos este vacio
        while (!arregloPiso.isEmpty()) {
            System.out.println(+cont + ". Elevador en piso " + pisoActual);
            System.out.println(cont + ". " + sentidoEleva);
            
            //contador que permite seguir la secuencia del codigo
            cont++;
            
            //for para recorrear el edificio de forma acendente
            for (int i = pisoActual, k = 0; i <= tamaEdificio; i++) {
                
                //if que determina si el piso actual esta en el arreglo de pisos mediante la variable i
                if (arregloPiso.contains(i)) {
                    cont++;
                    //remove permite remover el elelmento del arreglo medianate una varibale en este caso piso actual
                    arregloPiso.remove(Integer.valueOf(pisoActual));
                    System.out.println(cont + ". Elevador se detiene " + " ----->" + arregloPiso.toString());

                    //if que determinar si el piso actual esta en el mapa de pisos y que los pisos no se puedan repetir
                    if (mapPisoAgregado.containsKey(pisoActual) && !arregloPiso.contains(mapPisoAgregado.get(pisoActual))) {
                        
                        //permite agregar  pisos a arreglo de pisos
                        arregloPiso.add(mapPisoAgregado.get(pisoActual));
                        cont++;
                        System.out.println(cont + ". Piso ingresado " + mapPisoAgregado.get(pisoActual) + " ----->" + arregloPiso.toString());

                    }

                    //if para controlar el ultimo piso del edificio
                    if (i < tamaEdificio) {
                        cont++;
                        System.out.println(cont + ". " + sentidoEleva);
                        cont++;
                        pisoActual++;
                        System.out.println(cont + ". Elevador en piso " + pisoActual);
                        k++;

                    }

                } else {
                    pisoActual++;
                    System.out.println(cont + ". Elevador en piso " + pisoActual);
                    cont++;
                }
            }
            sentidoEleva = "Elevador Bajando";
            cont++;

            //if que permite recorrer el edificion de for descendiente
            for (int i = pisoActual, k = 0; i > 0; i--) {

                //if que determina si el piso actual esta en el arreglo de pisos mediante la variable i
                if (arregloPiso.contains(i)) {
                    arregloPiso.remove(Integer.valueOf(pisoActual));
                    System.out.println(cont + ". Elevador se detiene " + " ----->" + arregloPiso.toString());

                    //if que determinar si el piso actual esta en el mapa de pisos y que los pisos no se puedan repetir
                    if (mapPisoAgregado.containsKey(pisoActual) && !arregloPiso.contains(mapPisoAgregado.get(pisoActual))) {
                        arregloPiso.add(mapPisoAgregado.get(pisoActual));
                        cont++;
                        System.out.println(cont + ". Piso agregado " + mapPisoAgregado.get(pisoActual) + " ----->" + arregloPiso.toString());
                    }
                    
                    //if para controlar el primer piso del edificio
                    if (i < tamaEdificio && i != 1) {
                        cont++;
                        System.out.println(cont + ". " + sentidoEleva);
                        cont++;
                        pisoActual--;
                        System.out.println(cont + ". Elevador en piso " + pisoActual);
                        k++;
                    }

                } else {
                    pisoActual--;
                    System.out.println(cont + ". Elevador en piso " + pisoActual);
                    cont++;
                }

            }

        }
    }
}
