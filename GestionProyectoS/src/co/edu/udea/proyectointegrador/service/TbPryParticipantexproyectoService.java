package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryParticipantexproyectoDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryParticipantexproyecto;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.exception.AlreadyExistsException;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryParticipantexproyectoService {
	private TbPryParticipantexproyectoDAO tbPryParticipantexproyectoDAO;
	private TbPryProyectosService tbPryProyectosService;
	private TbAdmUsuariosService tbAdmUsuariosService;

	public TbPryParticipantexproyectoDAO getTbPryParticipantexproyectoDAO() {
		return tbPryParticipantexproyectoDAO;
	}

	public void setTbPryParticipantexproyectoDAO(
			TbPryParticipantexproyectoDAO tbPryParticipantexproyectoDAO) {
		this.tbPryParticipantexproyectoDAO = tbPryParticipantexproyectoDAO;
	}

	public TbPryProyectosService getTbPryProyectosService() {
		return tbPryProyectosService;
	}

	public void setTbPryProyectosService(
			TbPryProyectosService tbPryProyectosService) {
		this.tbPryProyectosService = tbPryProyectosService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryParticipantexproyecto> findAll() throws DaoException {
		return tbPryParticipantexproyectoDAO.findAll();
	}

	/**
	 * 
	 * @param nbIdn
	 * @throws DaoException
	 */
	public void delete(Integer nbIdn) throws DaoException {
		TbPryParticipantexproyecto deleted = tbPryParticipantexproyectoDAO
				.get(nbIdn);
		if (deleted != null) {
			tbPryParticipantexproyectoDAO.delete(deleted);
		}
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @param participanteIdn
	 * @throws DaoException
	 */
	public void delete(Integer proyectoIdn, Integer participanteIdn)
			throws DaoException {
		TbPryParticipantexproyecto deleted = tbPryParticipantexproyectoDAO
				.findByForeignKey(proyectoIdn, participanteIdn);
		if (deleted != null) {
			tbPryParticipantexproyectoDAO.delete(deleted);
		}
	}

	/**
	 * 
	 * @param usuarioNombre
	 * @param proyectoIdn
	 * @param participanteIdn
	 * @return
	 * @throws DaoException
	 * @throws AlreadyExistsException
	 */
	public TbPryParticipantexproyecto insert(String usuarioNombre,
			Integer proyectoIdn, Integer participanteIdn) throws DaoException,
			AlreadyExistsException {
		if (co.edu.udea.proyectointegrador.util.validations.Validaciones
				.isTextoVacio(usuarioNombre)) {
			throw new DaoException(
					"El nombre del usuario no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El codigo del proyecto no puede ser nulo");
		}
		if (participanteIdn == null) {
			throw new DaoException(
					"El codigo del participante no puede ser nulo");
		}
		TbPryParticipantexproyecto current = tbPryParticipantexproyectoDAO
				.findByForeignKey(proyectoIdn, participanteIdn);
		if (current != null) {
			throw new AlreadyExistsException(
					"El participante ya fue asignado al proyecto");
		}
		TbAdmUsuarios participante = tbAdmUsuariosService.get(participanteIdn);
		if (participante == null) {
			throw new DaoException(
					"El participante con el id ingresado no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto con el id ingresado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNombre);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que agrega el participante no existe en la base de datos");
		}
		TbPryParticipantexproyecto inserted = new TbPryParticipantexproyecto();
		inserted.setDtAdtfecha(new Date());
		inserted.setTbAdmUsuarios(participante);
		inserted.setTbPryProyectos(proyecto);
		inserted.setVrAdtusuario(usuarioNombre);
		return tbPryParticipantexproyectoDAO.save(inserted);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryParticipantexproyecto> findByProyecto(Integer proyectoIdn)
			throws DaoException {
		return tbPryParticipantexproyectoDAO.findByProyecto(proyectoIdn);
	}
}
