package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.service.TbNtfNtfsxusuarioService;
import co.edu.udea.proyectointegrador.service.email.EnviarEmail;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")
public class EmailTest {
	@Autowired
	private TbNtfNtfsxusuarioService tbNtfNtfsxusuarioService;
	@Test
	public void sendEmailTest() throws InterruptedException, DaoException
	{
		EnviarEmail enviarEmail = new EnviarEmail();
		enviarEmail.sendEmail("jdaaa2009@gmail.com","HI", "HITLER");
	}
	@Test
	public void notificaProyecto() throws DaoException, InterruptedException
	{
//		tbNtfNtfsxusuarioService.notificarCreacionActividadEmail("freddy.rivera", 111, 13);
//		Thread.sleep(60000);
	}
}
