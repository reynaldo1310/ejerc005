package es.santander.ascender.ejerc005.repository;

import es.santander.ascender.ejerc005.model.Pais;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test") // Asegúrate de tener un perfil de prueba si es necesario
public class PaisRepositoryTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PaisRepository paisRepository;

    private Pais pais;

    @BeforeEach
    public void setUp() {
        // Crear un país para las pruebas
        pais = new Pais();
        pais.setNombre("Argentina");
        pais.setDescripcion("País en América del Sur");
        pais.setContinente("América");
        paisRepository.save(pais);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testObtenerPaisPorId() {
        // Hacer una solicitud GET al controlador
        ResponseEntity<Pais> response = restTemplate.getForEntity("/api/paises/" + pais.getId(), Pais.class);

        // Comprobar que la respuesta sea correcta
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Argentina", response.getBody().getNombre());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGuardarPais() {
        // Crear un nuevo país para guardar
        Pais nuevoPais = new Pais();
        nuevoPais.setNombre("Chile");
        nuevoPais.setDescripcion("País en América del Sur");
        nuevoPais.setContinente("América");

        // Enviar la solicitud POST para guardar el nuevo país
        ResponseEntity<Pais> response = restTemplate.postForEntity("/api/paises/", nuevoPais, Pais.class);

        // Verificar que el país se guardó correctamente
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Chile", response.getBody().getNombre());
    }

    @Test
    public void testEliminarPais() {
        // Enviar una solicitud DELETE para eliminar el país previamente creado
        restTemplate.delete("/api/paises/" + pais.getId());

        // Verificar que el país ha sido eliminado
        assertFalse(paisRepository.existsById(pais.getId()));
    }
}
