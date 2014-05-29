package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryActividadesxactividadesDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.dto.TbPryActividadesxactividades;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbPryActividadesxactividadesService {
	private TbPryActividadesxactividadesDAO tbPryActividadesxactividadesDAO;
	private TbPryActividadesService tbPryActividadesService;
	private TbAdmUsuariosService tbAdmUsuariosService;

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbPryActividadesService getTbPryActividadesService() {
		return tbPryActividadesService;
	}

	public void setTbPryActividadesService(
			TbPryActividadesService tbPryActividadesService) {
		this.tbPryActividadesService = tbPryActividadesService;
	}

	public TbPryActividadesxactividadesDAO getTbPryActividadesxactividadesDAO() {
		return tbPryActividadesxactividadesDAO;
	}

	public void setTbPryActividadesxactividadesDAO(
			TbPryActividadesxactividadesDAO tbPryActividadesxactividadesDAO) {
		this.tbPryActividadesxactividadesDAO = tbPryActividadesxactividadesDAO;
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param actividadPreviaIdn
	 * @param actividadSiguienteIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryActividadesxactividades insert(String usuarioCrea,
			Integer actividadPreviaIdn, Integer actividadSiguienteIdn)
			throws DaoException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea la actividad no puede ser nulo o vacio");
		}
		if (actividadPreviaIdn == null) {
			throw new DaoException(
					"El codigo de la actividad previa no puede ser nulo");
		}
		if (actividadSiguienteIdn == null) {
			throw new DaoException(
					"El codigo de la actividad siguiente no puede ser nulo o vacio");
		}
		TbPryActividades actividadPrevia = tbPryActividadesService
				.get(actividadPreviaIdn);
		if (actividadPrevia == null) {
			throw new DaoException(
					"La actividad inicial no existe en la base de datos");
		}
		TbPryActividades actividadSiguiente = tbPryActividadesService
				.get(actividadSiguienteIdn);
		if (actividadSiguiente == null) {
			throw new DaoException(
					"La actividad siguiente no existe en la base de datos");
		}
		if (actividadPrevia.getDtFechafinal().compareTo(
				actividadSiguiente.getDtFechainicial()) > 0) {
			throw new DaoException(
					"La actividad siguiente debe comenzar una vez la actividad previa ha finalizado");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException("El usuario no existe en la base de datos");
		}
		TbPryActividadesxactividades actividad = new TbPryActividadesxactividades();
		actividad.setTbPryActividadPrevia(actividadPrevia);
		actividad.setTbPryActividadSiguiente(actividadSiguiente);
		actividad.setVrAdtusuario(usuarioCrea);
		actividad.setDtAdtfecha(new Date());
		return tbPryActividadesxactividadesDAO.save(actividad);
	}

	/**
	 * 
	 * @param actividadPreviaIdn
	 * @param actividadSiguienteIdn
	 * @throws DaoException
	 */
	public void delete(Integer actividadPreviaIdn, Integer actividadSiguienteIdn)
			throws DaoException {
		TbPryActividadesxactividades actividad = tbPryActividadesxactividadesDAO
				.findByForeignKey(actividadPreviaIdn, actividadSiguienteIdn);
		if (actividad != null) {
			tbPryActividadesxactividadesDAO.delete(actividad);
		}
	}

	/**
	 * 
	 * @param actividadIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryActividadesxactividades> findActividadesPrevias(
			Integer actividadIdn) throws DaoException {
		return tbPryActividadesxactividadesDAO
				.findActividadesPrevias(actividadIdn);
	}
}
