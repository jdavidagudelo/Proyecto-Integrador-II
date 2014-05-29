package test;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.proyectointegrador.dao.TbAdmRolesDAO;
import co.edu.udea.proyectointegrador.dao.TbAdmUsuariosDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmRoles;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")
public class UsuarioTest {

	@Autowired
	TbAdmRolesDAO rolesDAO;
	@Autowired
	TbAdmUsuariosDAO usuariosDAO;
	@Test
	public void test() throws DaoException {
		List<TbAdmUsuarios> usuarios = usuariosDAO.findAll();
		for(TbAdmUsuarios usuario : usuarios)
		{
			System.out.println(usuario.getVrNombres());
		}
		System.out.println("End of test---------------------------");
	}

	@Test
	public void testInsert() throws DaoException
	{
		TbAdmRoles rol = rolesDAO.get(1);
		TbAdmUsuarios inserted = new TbAdmUsuarios();
		inserted.setDtAdtfecha(new Date());
		inserted.setNbEstado(1);
		inserted.setTbAdmRoles(rol);
		inserted.setVrAdtusuario("juan");
		inserted.setVrApellidos("Alvarez");
		inserted.setVrCorreo("jdaaa2009@gmail.es");
		inserted.setVrNombres("Pedrito");
		inserted.setVrUsuario("pedrito.alvarez");
		inserted.setVrUniversidad("Universidad de Antioquia");
		usuariosDAO.save(inserted);
		System.out.println(inserted.getNbIdn());
	}
}
