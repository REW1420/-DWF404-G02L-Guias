package dwf.semana2.rv200068;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datos")
public class controller {

    @Autowired
    private service MyService;

    @GetMapping
    
    public List<String> obtenerDatos() {
        return MyService.obtenerDatos();
    }

    @PostMapping
    public String agregarDato(@RequestBody String nuevoDato) {
        MyService.agregarDato(nuevoDato);
        return "dato agregado correctamente" + nuevoDato;
    }

    @PutMapping
    public String actualizarDato() {
        MyService.actualizarDato(0, "nuevoDato");
        System.out.println(0);
        return "dato actualizado correctamente" + "nuevoDato";
    }

    @DeleteMapping
    public String eliminarDato(@RequestParam int index) {
        MyService.eliminarDato(1);
        return "dato eliminado correctamente en el índice: " + index;
    }
}