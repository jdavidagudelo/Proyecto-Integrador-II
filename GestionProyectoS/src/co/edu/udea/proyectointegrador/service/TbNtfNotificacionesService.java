package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbNtfNotificacionesDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbNtfNotificaciones;
import co.edu.udea.proyectointegrador.dto.TbNtfTipontfs;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * Clase que implementa la logica del negocio de las notificaciones.
 * 
 * @author juan
 * 
 */
public class TbNtfNotificacionesService {
	private TbNtfNotificacionesDAO tbNtfNotificacionesDAO;
	private TbNtfTipontfsService tbNtfTipontfsService;
	private TbAdmUsuariosService tbAdmUsuariosService;

	public TbNtfTipontfsService getTbNtfTipontfsService() {
		return tbNtfTipontfsService;
	}

	public void setTbNtfTipontfsService(
			TbNtfTipontfsService tbNtfTipontfsService) {
		this.tbNtfTipontfsService = tbNtfTipontfsService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbNtfNotificacionesDAO getTbNtfNotificacionesDAO() {
		return tbNtfNotificacionesDAO;
	}

	public void setTbNtfNotificacionesDAO(
			TbNtfNotificacionesDAO tbNtfNotificacionesDAO) {
		this.tbNtfNotificacionesDAO = tbNtfNotificacionesDAO;
	}

	/**
	 * Permite obtener todas las notificaciones de la base de datos
	 * 
	 * @return lista de todas las notificaciones de la base de datos
	 * @throws DaoException
	 */
	public List<TbNtfNotificaciones> findAll() throws DaoException {
		return tbNtfNotificacionesDAO.findAll();
	}

	/**
	 * Permite obtener la notificacion con el id ingresado como argumento
	 * 
	 * @param id
	 *            id de la notificacion
	 * @return notificacion con el id ingresado como argumento
	 * @throws DaoException
	 */
	public TbNtfNotificaciones get(Integer id) throws DaoException {
		if (id == null) {
			throw new DaoException("El id de la notificacion no puede ser nulo");
		}
		TbNtfNotificaciones notificacion = tbNtfNotificacionesDAO.get(id);
		if (notificacion == null) {
			throw new DaoException(
					"La notificacion no existe en la base de datos");
		}
		return notificacion;
	}

	/**
	 * Metodo que permite crear una nueva notificacion en la base de datos.
	 * 
	 * @param usuarioCrea
	 *            login del usuario que crea la notificacion
	 * @param asunto
	 *            el asunto de la notificacion
	 * @param mensaje
	 *            el mensaje de la notificacion
	 * @param tipoNotificacionIdn
	 *            el id del tipo de notificacion
	 * @return la nueva notificacion
	 * @throws DaoException
	 */
	public TbNtfNotificaciones insert(String usuarioCrea, String asunto,
			String mensaje, Integer tipoNotificacionIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea la notificacion no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(asunto)) {
			throw new DaoException(
					"El asunto de la notificación no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(mensaje)) {
			throw new DaoException(
					"El mensaje de la notificación no puede ser nulo o vacio");
		}
		if (tipoNotificacionIdn == null) {
			throw new DaoException(
					"El codigo del tipo de notificacion no puede ser nulo o vacio");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea la notificación no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.get(tipoNotificacionIdn);
		if (tipoNotificacion == null) {
			throw new DaoException(
					"El tipo de notificación especificado no existe en la base de datos");
		}
		TbNtfNotificaciones notificacion = new TbNtfNotificaciones();
		Date current = new Date();
		notificacion.setDtAdtfecha(current);
		notificacion.setDtFecha(current);
		notificacion.setTbNtfTipontfs(tipoNotificacion);
		notificacion.setVrAdtusuario(usuarioCrea);
		notificacion.setVrAsunto(asunto);
		notificacion.setVrMensaje(mensaje);
		return tbNtfNotificacionesDAO.save(notificacion);
	}

}
