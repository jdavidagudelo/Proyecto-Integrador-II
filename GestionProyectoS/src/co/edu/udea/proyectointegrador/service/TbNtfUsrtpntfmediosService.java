package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbNtfUsrtpntfmediosDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbNtfMediostipontf;
import co.edu.udea.proyectointegrador.dto.TbNtfUsrtpntfmedios;
import co.edu.udea.proyectointegrador.dto.TbNtfUsuariostipontf;
import co.edu.udea.proyectointegrador.exception.AlreadyExistsException;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfUsrtpntfmediosService {
	private TbNtfUsrtpntfmediosDAO tbNtfUsrtpntfmediosDAO;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbNtfUsuariostipontfService tbNtfUsuariostipontfService;
	private TbNtfMediostipontfService tbNtfMediostipontfService;

	public TbNtfMediostipontfService getTbNtfMediostipontfService() {
		return tbNtfMediostipontfService;
	}

	public void setTbNtfMediostipontfService(
			TbNtfMediostipontfService tbNtfMediostipontfService) {
		this.tbNtfMediostipontfService = tbNtfMediostipontfService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbNtfUsuariostipontfService getTbNtfUsuariostipontfService() {
		return tbNtfUsuariostipontfService;
	}

	public void setTbNtfUsuariostipontfService(
			TbNtfUsuariostipontfService tbNtfUsuariostipontfService) {
		this.tbNtfUsuariostipontfService = tbNtfUsuariostipontfService;
	}

	public TbNtfUsrtpntfmediosDAO getTbNtfUsrtpntfmediosDAO() {
		return tbNtfUsrtpntfmediosDAO;
	}

	public void setTbNtfUsrtpntfmediosDAO(
			TbNtfUsrtpntfmediosDAO tbNtfUsrtpntfmediosDAO) {
		this.tbNtfUsrtpntfmediosDAO = tbNtfUsrtpntfmediosDAO;
	}

	/**
	 * 
	 * @param tipoMedioIdn
	 * @param tipoUsuarioIdn
	 * @return
	 * @throws DaoException
	 */
	public TbNtfUsrtpntfmedios findByForeignKey(Integer tipoMedioIdn,
			Integer tipoUsuarioIdn) throws DaoException {
		return tbNtfUsrtpntfmediosDAO.findByForeignKey(tipoMedioIdn,
				tipoUsuarioIdn);
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfUsrtpntfmedios> findAll() throws DaoException {
		return tbNtfUsrtpntfmediosDAO.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbNtfUsrtpntfmedios get(Integer id) throws DaoException {
		return tbNtfUsrtpntfmediosDAO.get(id);
	}

	/**
	 * 
	 * @param usuarioTipoNotificacionIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfUsrtpntfmedios> findMediosByUsuarioTipoNotificacion(
			Integer usuarioTipoNotificacionIdn) throws DaoException {
		return tbNtfUsrtpntfmediosDAO
				.findMediosByUsuarioTipoNotificacion(usuarioTipoNotificacionIdn);
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param usuarioTipoNotificacionIdn
	 * @param tipoMedioIdn
	 * @param notificar
	 * @return
	 * @throws DaoException
	 * @throws AlreadyExistsException
	 */
	public TbNtfUsrtpntfmedios insert(String usuarioCrea,
			Integer usuarioTipoNotificacionIdn, Integer tipoMedioIdn,
			Boolean notificar) throws DaoException, AlreadyExistsException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea los medio de notificacion no puede ser nulo o vacio");
		}
		if (usuarioTipoNotificacionIdn == null) {
			throw new DaoException(
					"El codigo del tipo de notificacion de usuario no puede ser nulo");
		}
		if (tipoMedioIdn == null) {
			throw new DaoException(
					"El codigo del medio de notificacion no puede ser nulo");
		}
		if (notificar == null) {
			throw new DaoException("El valor de notificar no puede ser nulo");
		}
		TbNtfUsrtpntfmedios inserted = tbNtfUsrtpntfmediosDAO.findByForeignKey(
				tipoMedioIdn, usuarioTipoNotificacionIdn);
		if (inserted != null) {
			throw new AlreadyExistsException(
					"El medio x usuario ya existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea no existe en la base de datos");
		}
		TbNtfMediostipontf tipoMedio = tbNtfMediostipontfService
				.get(tipoMedioIdn);
		if (tipoMedio == null) {
			throw new DaoException(
					"El tipo de medio especificado no existe en la base de datos");
		}
		TbNtfUsuariostipontf usuarioTipo = tbNtfUsuariostipontfService
				.get(usuarioTipoNotificacionIdn);
		if (usuarioTipo == null) {
			throw new DaoException(
					"El tipo de usuario por notificacion no existe en la base de datos");
		}
		inserted = new TbNtfUsrtpntfmedios();
		inserted.setBlNotificar(notificar);
		inserted.setDtAdtfecha(new Date());
		inserted.setTbNtfMediostipontf(tipoMedio);
		inserted.setTbNtfUsuariostipontf(usuarioTipo);
		inserted.setVrAdtusuario(usuarioCrea);
		return tbNtfUsrtpntfmediosDAO.save(inserted);
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param usuarioTipoNotificacionIdn
	 * @param tipoMedioIdn
	 * @param notificar
	 * @return
	 * @throws DaoException
	 */
	public TbNtfUsrtpntfmedios update(String usuarioCrea,
			Integer usuarioTipoNotificacionIdn, Integer tipoMedioIdn,
			Boolean notificar) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea los medio de notificacion no puede ser nulo o vacio");
		}
		if (usuarioTipoNotificacionIdn == null) {
			throw new DaoException(
					"El codigo del tipo de notificacion de usuario no puede ser nulo");
		}
		if (tipoMedioIdn == null) {
			throw new DaoException(
					"El codigo del medio de notificacion no puede ser nulo");
		}
		if (notificar == null) {
			throw new DaoException("El valor de notificar no puede ser nulo");
		}
		TbNtfUsrtpntfmedios updated = tbNtfUsrtpntfmediosDAO.findByForeignKey(
				tipoMedioIdn, usuarioTipoNotificacionIdn);
		if (updated == null) {
			throw new DaoException(
					"El medio x usuario no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea no existe en la base de datos");
		}
		updated.setBlNotificar(notificar);
		updated.setDtAdtfecha(new Date());
		updated.setVrAdtusuario(usuarioCrea);
		return tbNtfUsrtpntfmediosDAO.update(updated);
	}

	/**
	 * 
	 * @param usuarioTipoNotificacionIdn
	 * @param tipoMedioIdn
	 * @throws DaoException
	 */
	public void delete(Integer usuarioTipoNotificacionIdn, Integer tipoMedioIdn)
			throws DaoException {
		TbNtfUsrtpntfmedios deleted = findByForeignKey(tipoMedioIdn,
				usuarioTipoNotificacionIdn);
		if (deleted != null) {
			tbNtfUsrtpntfmediosDAO.delete(deleted);
		}
	}
}
