package es.santander.ascender.ejerc005.controller;

import es.santander.ascender.ejerc005.model.Pais;
import es.santander.ascender.ejerc005.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/")
    public List<Pais> obtenerTodosLosPaises() {
        return paisService.obtenerTodosLosPaises();
    }

    @GetMapping("/{id}")
    public Pais obtenerPaisPorId(@PathVariable Long id) {
        return paisService.obtenerPaisPorId(id).orElse(null);
    }

    @PostMapping("/")
    public Pais guardarPais(@RequestBody Pais pais) {
        return paisService.guardarPais(pais);
    }

    @DeleteMapping("/{id}")
    public void eliminarPais(@PathVariable Long id) {
        paisService.eliminarPais(id);
    }
}
