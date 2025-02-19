package es.santander.ascender.ejerc005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.ejerc005.model.Provincia;
import es.santander.ascender.ejerc005.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository repository;

    public Provincia create(Provincia provincia){
         if (provincia.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro provincia utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 provincia.getId());
        }
        return repository.save(provincia);
    }

    public Provincia read(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Provincia> read(){
        return repository.findAll();
    }

    public Provincia update(Provincia provincia){
        if (provincia.getId() == null){
            throw new CrudSecurityException("Han tratado de crear un registro provincia utilizando la modificación",
                                                CRUDOperation.UPDATE, 
                                                provincia.getId());
        }
        return repository.save(provincia);
    }

    public void delete (Long id){
        repository.deleteById(id);
        return;
    }

}