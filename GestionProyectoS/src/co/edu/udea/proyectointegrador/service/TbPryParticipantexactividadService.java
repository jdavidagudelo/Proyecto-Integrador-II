package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryParticipantexactividadDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.dto.TbPryParticipantexactividad;
import co.edu.udea.proyectointegrador.exception.AlreadyExistsException;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryParticipantexactividadService {
	private TbPryParticipantexactividadDAO tbPryParticipantexactividadDAO;
	private TbPryActividadesService tbPryActividadesService;
	private TbAdmUsuariosService tbAdmUsuariosService;

	public TbPryParticipantexactividadDAO getTbPryParticipantexactividadDAO() {
		return tbPryParticipantexactividadDAO;
	}

	public void setTbPryParticipantexactividadDAO(
			TbPryParticipantexactividadDAO tbPryParticipantexactividadDAO) {
		this.tbPryParticipantexactividadDAO = tbPryParticipantexactividadDAO;
	}

	public TbPryActividadesService getTbPryActividadesService() {
		return tbPryActividadesService;
	}

	public void setTbPryActividadesService(
			TbPryActividadesService tbPryActividadesService) {
		this.tbPryActividadesService = tbPryActividadesService;
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
	 * @param nbIdn
	 * @throws DaoException
	 */
	public void delete(Integer nbIdn) throws DaoException {
		TbPryParticipantexactividad deleted = tbPryParticipantexactividadDAO
				.get(nbIdn);
		if (deleted != null) {
			tbPryParticipantexactividadDAO.delete(deleted);
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
		TbPryParticipantexactividad deleted = tbPryParticipantexactividadDAO
				.findByForeignKey(proyectoIdn, participanteIdn);
		if (deleted != null) {
			tbPryParticipantexactividadDAO.delete(deleted);
		}
	}

	/**
	 * 
	 * @param usuarioNombre
	 * @param actividadIdn
	 * @param participanteIdn
	 * @return
	 * @throws DaoException
	 * @throws AlreadyExistsException
	 */
	public TbPryParticipantexactividad insert(String usuarioNombre,
			Integer actividadIdn, Integer participanteIdn) throws DaoException,
			AlreadyExistsException {
		if (co.edu.udea.proyectointegrador.util.validations.Validaciones
				.isTextoVacio(usuarioNombre)) {
			throw new DaoException(
					"El nombre del usuario no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (participanteIdn == null) {
			throw new DaoException(
					"El codigo del participante no puede ser nulo");
		}
		TbPryParticipantexactividad current = tbPryParticipantexactividadDAO
				.findByForeignKey(actividadIdn, participanteIdn);
		if (current != null) {
			throw new AlreadyExistsException(
					"El participante ya fue asignado a la actividad");
		}
		TbAdmUsuarios participante = tbAdmUsuariosService.get(participanteIdn);
		if (participante == null) {
			throw new DaoException(
					"El participante con el id ingresado no existe en la base de datos");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException(
					"El proyecto con el id ingresado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNombre);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que agrega el participante no existe en la base de datos");
		}
		TbPryParticipantexactividad inserted = new TbPryParticipantexactividad();
		inserted.setDtAdtfecha(new Date());
		inserted.setTbAdmUsuarios(participante);
		inserted.setTbPryActividades(actividad);
		inserted.setVrAdtusuario(usuarioNombre);
		return tbPryParticipantexactividadDAO.save(inserted);
	}

	/**
	 * 
	 * @param actividadIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryParticipantexactividad> findByActividad(
			Integer actividadIdn) throws DaoException {
		return tbPryParticipantexactividadDAO.findByActividad(actividadIdn);
	}
}
