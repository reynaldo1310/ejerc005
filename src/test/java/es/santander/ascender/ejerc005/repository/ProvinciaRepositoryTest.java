package es.santander.ascender.ejerc005.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc005.model.Provincia;

@SpringBootTest
public class ProvinciaRepositoryTest {

    @Autowired
    private ProvinciaRepository repository;

    @Test
        public void testCreate() {
                Provincia provincia = new Provincia();
                provincia.setNombre("Cantabria");
                         

                repository.save(provincia);
                assertTrue(
                                repository
                                                .findById(provincia.getId())
                                                .isPresent());
        }

        @Test
        public void delete() {
            Provincia provincia = new Provincia();
            provincia.setNombre("Cantabria");
                   

            repository.save(provincia);
                assertTrue(
                                repository
                                                .findById(provincia.getId())
                                                .isPresent());
                repository.deleteById(provincia.getId());
        }

        @Test
        public void update() {
            Provincia provincia = new Provincia();
            provincia.setNombre("Cantabria");
                     

            repository.save(provincia);
                assertTrue(
                                repository
                                                .existsById(provincia.getId()));
                provincia.setNombre("Cataluña");
                repository.save(provincia);
                Optional<Provincia> updatedProvincia= repository.findById(provincia.getId());
                assertTrue(updatedProvincia.isPresent());
                assertTrue(updatedProvincia.get().getNombre() == "Cataluña");
        }

}