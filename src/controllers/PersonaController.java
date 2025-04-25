package controllers;

import models.Persona;

public class PersonaController {

    // Método de ordenamiento selección descendente por código de dirección
    public void sortByDireccionCodigo(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            int indexMayor = i;

            for (int j = i + 1; j < personas.length; j++) {
                if (personas[j].compareCodigoDireccion(personas[indexMayor])) {
                    indexMayor = j;
                }
            }

            if (i != indexMayor) {
                Persona aux = personas[indexMayor];
                personas[indexMayor] = personas[i];
                personas[i] = aux;
            }
        }
    }

    // Método de búsqueda binaria en un arreglo ordenado descendente por código de
    // dirección
    public Persona findPersonaByCodigoDireccion(Persona[] personas, int codigo) {
        int bajo = 0;
        int alto = personas.length - 1;

        while (bajo <= alto) {
            int centro = (bajo + alto) / 2;

            if (personas[centro].equalsByCodigoDireccion(codigo)) {
                return personas[centro];
            }

            if (personas[centro].getCodigoDireccion() < codigo) {
                alto = centro - 1;
            } else {
                bajo = centro + 1;
            }
        }

        return null;
    }
}
