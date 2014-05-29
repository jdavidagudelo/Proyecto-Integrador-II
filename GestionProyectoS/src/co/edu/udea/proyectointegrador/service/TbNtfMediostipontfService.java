package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbNtfMediostipontfDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbNtfMediosntf;
import co.edu.udea.proyectointegrador.dto.TbNtfMediostipontf;
import co.edu.udea.proyectointegrador.dto.TbNtfTipontfs;
import co.edu.udea.proyectointegrador.exception.AlreadyExistsException;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * Clase que representa la capa de logica del negocio para la tabla de medios x
 * tipo de notificacion de la base de datos.
 * 
 * @author juan
 * 
 */
public class TbNtfMediostipontfService {
	private TbNtfMediostipontfDAO tbNtfMediostipontfDAO;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbNtfMediosntfService tbNtfMediosntfService;
	private TbNtfTipontfsService tbNtfTipontfsService;

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbNtfMediosntfService getTbNtfMediosntfService() {
		return tbNtfMediosntfService;
	}

	public void setTbNtfMediosntfService(
			TbNtfMediosntfService tbNtfMediosntfService) {
		this.tbNtfMediosntfService = tbNtfMediosntfService;
	}

	public TbNtfTipontfsService getTbNtfTipontfsService() {
		return tbNtfTipontfsService;
	}

	public void setTbNtfTipontfsService(
			TbNtfTipontfsService tbNtfTipontfsService) {
		this.tbNtfTipontfsService = tbNtfTipontfsService;
	}

	public TbNtfMediostipontfDAO getTbNtfMediostipontfDAO() {
		return tbNtfMediostipontfDAO;
	}

	public void setTbNtfMediostipontfDAO(
			TbNtfMediostipontfDAO tbNtfMediostipontfDAO) {
		this.tbNtfMediostipontfDAO = tbNtfMediostipontfDAO;
	}

	/**
	 * Metodo usado para obtener la lista de medios usados para el tipo de
	 * notificacion ingresado como argumento
	 * 
	 * @param tipoNotificacionIdn
	 *            el id del tipo de notificacion
	 * @return lista de medios usados para el tipo de notificacion ingresado
	 *         como argumento
	 * @throws DaoException
	 */
	public List<TbNtfMediostipontf> findByTipoNotificacion(
			Integer tipoNotificacionIdn) throws DaoException {
		return tbNtfMediostipontfDAO
				.findMediosByTipoNotificacion(tipoNotificacionIdn);
	}

	/**
	 * Lista de todos los medios x tipo de notificacion
	 * 
	 * @return lista de todos los medios x tipo de notificacion
	 * @throws DaoException
	 */
	public List<TbNtfMediostipontf> findAll() throws DaoException {
		return tbNtfMediostipontfDAO.findAll();
	}

	/**
	 * Permite obtener el tipo de notificacion x medio
	 * 
	 * @param id
	 *            el tipo de notificacion x medio
	 * @return tipo de notificacion x medio con el id ingresado como argumento.
	 * @throws DaoException
	 */
	public TbNtfMediostipontf get(Integer id) throws DaoException {
		if (id == null) {
			throw new DaoException(
					"El id del medio x tipo de notificacion no puede ser nulo");
		}
		TbNtfMediostipontf medioTipo = tbNtfMediostipontfDAO.get(id);
		if (medioTipo == null) {
			throw new DaoException(
					"El medio x tipo de notificacion no puede ser nulo");
		}
		return medioTipo;
	}

	/**
	 * Permite obtener el tipo de notificacion x medio con el medio y tipo de
	 * notificacion ingresados como argumento.
	 * 
	 * @param medioIdn
	 *            el id del medio
	 * @param tipoIdn
	 *            el id del tipo de notificacion
	 * @return el tipo de notificacion x medio con el medio y tipo de
	 *         notificacion ingresados como argumento.
	 * @throws DaoException
	 */
	public TbNtfMediostipontf findByForeignKey(Integer medioIdn, Integer tipoIdn)
			throws DaoException {
		if (medioIdn == null) {
			throw new DaoException("El id del medio es invalido");
		}
		if (tipoIdn == null) {
			throw new DaoException("El tipo de notificacion no puede ser nulo");
		}
		TbNtfMediosntf medio = tbNtfMediosntfService.get(medioIdn);
		if (medio == null) {
			throw new DaoException("El medio no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService.get(tipoIdn);
		if (tipoNotificacion == null) {
			throw new DaoException("El medio no existe en la base de datos");
		}
		return tbNtfMediostipontfDAO.findByForeignKey(medioIdn, tipoIdn);
	}

	/**
	 * Metodo usado para obtener la lista de medios usados para el tipo de
	 * notificacion ingresado como argumento
	 * 
	 * @param tipoIdn
	 *            el id del tipo de notificacion
	 * @return lista de medios usados para el tipo de notificacion ingresado
	 *         como argumento
	 * @throws DaoException
	 */
	public List<TbNtfMediostipontf> findMediosByTipoNotificacion(Integer tipoIdn)
			throws DaoException {
		return tbNtfMediostipontfDAO.findMediosByTipoNotificacion(tipoIdn);
	}

	/**
	 * Permite crear un nuevo medio x tipo de notificacion
	 * 
	 * @param usuarioCrea
	 *            login del usuario que crea el permiso x tipo de notificacion
	 * @param medioIdn
	 *            el id del medio
	 * @param tipoIdn
	 *            el id del tipo de notificacion
	 * @param configurable
	 *            indica si el tipo de notificacion es configurable
	 * @return nuevo medio x tipo de notificacion
	 * @throws DaoException
	 * @throws AlreadyExistsException
	 */
	public TbNtfMediostipontf insert(String usuarioCrea, Integer medioIdn,
			Integer tipoIdn, Boolean configurable) throws DaoException,
			AlreadyExistsException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea el medio por tipo de notificacion no puede ser nulo o vacio");
		}
		if (medioIdn == null) {
			throw new DaoException("El medio de comuncacion no puede ser nulo");
		}
		if (tipoIdn == null) {
			throw new DaoException("El tipo de notificacion no puede ser nulo");
		}
		TbNtfMediosntf medio = tbNtfMediosntfService.get(medioIdn);
		if (medio == null) {
			throw new DaoException(
					"El medio especificado no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService.get(tipoIdn);
		if (tipoNotificacion == null) {
			throw new DaoException(
					"El tipo de notificacion especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario especificado no existe en la base de datos");
		}
		TbNtfMediostipontf medioActual = tbNtfMediostipontfDAO
				.findByForeignKey(medioIdn, tipoIdn);
		if (medioActual != null) {
			throw new AlreadyExistsException(
					"El medio especificado ya esta asociado con el tipo de notificacion indicado");
		}
		TbNtfMediostipontf medioTipoNotificacion = new TbNtfMediostipontf();
		medioTipoNotificacion.setBlConfigurable(configurable);
		medioTipoNotificacion.setDtAdtfecha(new Date());
		medioTipoNotificacion.setTbNtfMediosntf(medio);
		medioTipoNotificacion.setTbNtfTipontfs(tipoNotificacion);
		medioTipoNotificacion.setVrAdtusuario(usuarioCrea);
		return tbNtfMediostipontfDAO.save(medioTipoNotificacion);
	}

	/**
	 * Permite modificar un nuevo medio x tipo de notificacion
	 * 
	 * @param usuarioCrea
	 *            login del usuario que crea el permiso x tipo de notificacion
	 * @param medioIdn
	 *            el id del medio
	 * @param tipoIdn
	 *            el id del tipo de notificacion
	 * @param configurable
	 *            indica si el tipo de notificacion es configurable
	 * @return modificar medio x tipo de notificacion
	 * @throws DaoException
	 * @throws AlreadyExistsException
	 */
	public TbNtfMediostipontf update(String usuarioCrea, Integer medioIdn,
			Integer tipoIdn, Boolean configurable) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea el medio por tipo de notificacion no puede ser nulo o vacio");
		}
		if (medioIdn == null) {
			throw new DaoException("El medio de comuncacion no puede ser nulo");
		}
		if (tipoIdn == null) {
			throw new DaoException("El tipo de notificacion no puede ser nulo");
		}
		TbNtfMediosntf medio = tbNtfMediosntfService.get(medioIdn);
		if (medio == null) {
			throw new DaoException(
					"El medio especificado no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService.get(tipoIdn);
		if (tipoNotificacion == null) {
			throw new DaoException(
					"El tipo de notificacion especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario especificado no existe en la base de datos");
		}
		TbNtfMediostipontf medioActual = tbNtfMediostipontfDAO
				.findByForeignKey(medioIdn, tipoIdn);
		if (medioActual == null) {
			throw new DaoException("El medio no existe en la base de datos");
		}
		medioActual.setBlConfigurable(configurable);
		medioActual.setDtAdtfecha(new Date());
		medioActual.setVrAdtusuario(usuarioCrea);
		return tbNtfMediostipontfDAO.update(medioActual);
	}

	/**
	 * Permite eliminar medio x tipo de notificacion
	 * 
	 * @param medioIdn
	 *            id del medio
	 * @param tipoIdn
	 *            id del tipo de notificacion
	 * @throws DaoException
	 */
	public void delete(Integer medioIdn, Integer tipoIdn) throws DaoException {
		TbNtfMediostipontf medio = findByForeignKey(medioIdn, tipoIdn);
		if (medio != null) {
			tbNtfMediostipontfDAO.delete(medio);
		}
	}
}
