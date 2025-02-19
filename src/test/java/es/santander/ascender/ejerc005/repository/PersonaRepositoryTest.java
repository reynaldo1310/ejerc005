package es.santander.ascender.ejerc005.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc005.model.Persona;

@SpringBootTest
public class PersonaRepositoryTest {

    @Autowired
    private PersonaRepository repository;

     @Test
    public void testCreate() {
                Persona persona = new Persona();
                persona.setNombre("Paula");
                persona.setApellido("Gomez");
                persona.setProvincia_id(55l);
                

                repository.save(persona);
                assertTrue(
                                repository
                                                .findById(persona.getId())
                                                .isPresent());
        }

        @Test
        public void delete() {
            Persona persona = new Persona();
            persona.setNombre("Paula");
            persona.setApellido("Gomez");
            persona.setProvincia_id(55l);
            

            repository.save(persona);
                assertTrue(
                                repository
                                                .findById(persona.getId())
                                                .isPresent());
                repository.deleteById(persona.getId());
        }

        @Test
        public void update() {
            Persona persona = new Persona();
                persona.setNombre("Paula");
                persona.setApellido("Gomez");
                persona.setProvincia_id(55l);
                

                repository.save(persona);
                assertTrue(
                                repository
                                                .existsById(persona.getId()));
                persona.setNombre("Lucia");
                repository.save(persona);
                Optional<Persona> updatedPersona= repository.findById(persona.getId());
                assertTrue(updatedPersona.isPresent());
                assertTrue(updatedPersona.get().getNombre() == "Lucia");
        }

}