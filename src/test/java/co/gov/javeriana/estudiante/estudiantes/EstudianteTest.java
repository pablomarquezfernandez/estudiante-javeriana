package co.gov.javeriana.estudiante.estudiantes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.gov.javeriana.estudiante.estudiantes.controllers.EstudianteController;
import co.gov.javeriana.estudiante.estudiantes.dto.EstudianteDTO;
import co.gov.javeriana.estudiante.estudiantes.services.EstudianteService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EstudianteTest {

    @Autowired
	EstudianteService estudianteController;

	@Test
	public void pruebaEstudiante() {
		int cantidad = estudianteController.get().size();
		EstudianteDTO estudianteDTO = new EstudianteDTO(null, "Pablo", "Márquez", "pablo.marquez@dynaco.co");
		estudianteDTO = estudianteController.save(estudianteDTO);
		int nuevaCantidad = estudianteController.get().size();
		assertEquals(cantidad + 1, nuevaCantidad);

		estudianteDTO.setNombres("Pablo Andres");
		estudianteController.update(estudianteDTO);
		EstudianteDTO estudianteActualizadoDTO = estudianteController.get(estudianteDTO.getId());
		assertEquals(estudianteActualizadoDTO.getNombres(), "Pablo Andres");

		

	}
}
