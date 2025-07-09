package dwf.semana2.rv200068;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;;

@Service
public class service {
    private final List<String> datos = new ArrayList<>();
    // Constructor
    // This is a service class that manages a list of data items.

    public service() {
        // Inicializar la lista con algunos datos de ejemplo
        datos.add("Dato 1");
        datos.add("Dato 2");
        datos.add("Dato 3");
    }

    public List<String> obtenerDatos() {
        return datos;
    }

    public void agregarDato(String nuevoDato) {
        datos.add(nuevoDato);
    }

    public void actualizarDato(int index, String nuevoDato) {
        if (index >= 0 && index < datos.size()) {
            datos.set(index, nuevoDato);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
    }

    public void eliminarDato(int index) {
        if (index >= 0 && index < datos.size()) {
            datos.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
    }
}
