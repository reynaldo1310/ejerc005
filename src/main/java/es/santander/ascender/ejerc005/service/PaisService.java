package es.santander.ascender.ejerc005.service;

import es.santander.ascender.ejerc005.model.Pais;
import es.santander.ascender.ejerc005.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> obtenerTodosLosPaises() {
        return paisRepository.findAll();
    }

    public Optional<Pais> obtenerPaisPorId(Long id) {
        return paisRepository.findById(id);
    }

    public Pais guardarPais(Pais pais) {
        return paisRepository.save(pais);
    }

    public void eliminarPais(Long id) {
        paisRepository.deleteById(id);
    }
}
