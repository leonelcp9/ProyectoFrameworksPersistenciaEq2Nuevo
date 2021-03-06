package cursoDAgil.dao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Ganancia;
import cursoDAgil.dao.ganancia.GananciaDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
public class GananciaDaoImplTest {
	@Inject
	GananciaDao gananciaDao;
	
	@Test
	public void pruebaConsultarTodo() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test consultar todas las ganancias");
		try {
			List<Ganancia> lista = gananciaDao.listarGanancia();
			int a = lista.size();
			assertEquals(lista.size(),a);
		}catch(Exception ex){
			System.out.println("Error" + ex);
		}
	}
	
	@Test
	public void pruebaListarPorFecha() {
		System.out.println("------------------------------------------------------");
		System.out.println("Test consultar por fecha");
		Ganancia ganancia = new Ganancia();
		Map<String, String> mapGanancia = new HashMap<>();
		mapGanancia.put("fecha","2022-04-28");
		try{
			ganancia=gananciaDao.listarPorFecha(mapGanancia);
			assertNotNull(ganancia);
			System.out.println("Fecha" + ganancia.getFecha());
			System.out.println("Total ganancia" + ganancia.getTotalGanancia());
			System.out.println("Id ganancia" + ganancia.getIdGanancia());
			System.out.println("Id venta" + ganancia.getVentaId());
			System.out.println();
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}

}