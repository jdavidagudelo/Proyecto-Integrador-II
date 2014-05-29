package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.proyectointegrador.dao.TbPryParticipantexproyectoDAO;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.service.TbPryAsesorxproyectoService;
import co.edu.udea.proyectointegrador.service.TbPryParticipantexproyectoService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")
public class ParticipantexproyectoTest {
	@Autowired
	private TbPryParticipantexproyectoDAO tbPryParticipantexproyectoDAO;
	@Autowired
	private TbPryParticipantexproyectoService tbPryParticipantexproyectoService;
	@Autowired
	private TbPryAsesorxproyectoService tbPryAsesorxproyectoService;
	@Test
	public void testDelete()
	{
		try {
			//tbPryParticipantexproyectoService.delete(104, 6);
			tbPryAsesorxproyectoService.delete(104, 7);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
