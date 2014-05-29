package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbNtfUsuariostipontfDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbNtfUsrtpntfmedios;
import co.edu.udea.proyectointegrador.dto.TbNtfUsuariostipontf;
import co.edu.udea.proyectointegrador.dto.TbNtfsTipontfsroles;
import co.edu.udea.proyectointegrador.exception.AlreadyExistsException;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfUsuariostipontfService {
	private TbNtfUsuariostipontfDAO tbNtfUsuariostipontfDAO;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbNtfsTipontfsrolesService tbNtfsTipontfsrolesService;
	private TbNtfUsrtpntfmediosService tbNtfUsrtpntfmediosService;

	public TbNtfUsrtpntfmediosService getTbNtfUsrtpntfmediosService() {
		return tbNtfUsrtpntfmediosService;
	}

	public void setTbNtfUsrtpntfmediosService(
			TbNtfUsrtpntfmediosService tbNtfUsrtpntfmediosService) {
		this.tbNtfUsrtpntfmediosService = tbNtfUsrtpntfmediosService;
	}

	public TbNtfsTipontfsrolesService getTbNtfsTipontfsrolesService() {
		return tbNtfsTipontfsrolesService;
	}

	public void setTbNtfsTipontfsrolesService(
			TbNtfsTipontfsrolesService tbNtfsTipontfsrolesService) {
		this.tbNtfsTipontfsrolesService = tbNtfsTipontfsrolesService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbNtfUsuariostipontfDAO getTbNtfUsuariostipontfDAO() {
		return tbNtfUsuariostipontfDAO;
	}

	public void setTbNtfUsuariostipontfDAO(
			TbNtfUsuariostipontfDAO tbNtfUsuariostipontfDAO) {
		this.tbNtfUsuariostipontfDAO = tbNtfUsuariostipontfDAO;
	}

	/**
	 * 
	 * @param tipoRolIdn
	 * @param usuarioIdn
	 * @return
	 * @throws DaoException
	 */
	public TbNtfUsuariostipontf findByForeignKey(Integer tipoRolIdn,
			Integer usuarioIdn) throws DaoException {
		return tbNtfUsuariostipontfDAO.findByForeignKey(tipoRolIdn, usuarioIdn);
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfUsuariostipontf> findAll() throws DaoException {
		return tbNtfUsuariostipontfDAO.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbNtfUsuariostipontf get(Integer id) throws DaoException {
		return tbNtfUsuariostipontfDAO.get(id);
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param usuarioIdn
	 * @param tipoNotificacionIdn
	 * @param notificar
	 * @return
	 * @throws DaoException
	 */
	public TbNtfUsuariostipontf update(String usuarioCrea, Integer usuarioIdn,
			Integer tipoNotificacionIdn, Boolean notificar) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que especifica no puede ser nulo o vacio");
		}
		if (usuarioIdn == null) {
			throw new DaoException(
					"El usuario al que se le asocia el tipo de notificacion no puede ser nulo");
		}
		if (tipoNotificacionIdn == null) {
			throw new DaoException("El tipo de notificacion no puede ser nulo");
		}
		if (notificar == null) {
			throw new DaoException("El valor de notificar no puede ser nulo");
		}
		TbNtfUsuariostipontf tipoUsuario = tbNtfUsuariostipontfDAO
				.findByForeignKey(tipoNotificacionIdn, usuarioIdn);
		if (tipoUsuario == null) {
			throw new DaoException(
					"El usuario no esta asociado con el tipo de notificacion");
		}
		TbAdmUsuarios usuarioActual = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuarioActual == null) {
			throw new DaoException(
					"El usuario que crea el permiso de notificacion no existe en la base de datos");
		}
		tipoUsuario.setBlNotificar(notificar);
		tipoUsuario.setDtAdtfecha(new Date());
		tipoUsuario.setVrAdtusuario(usuarioCrea);
		return tbNtfUsuariostipontfDAO.update(tipoUsuario);
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param usuarioIdn
	 * @param tipoNotificacionIdn
	 * @param notificar
	 * @return
	 * @throws DaoException
	 * @throws AlreadyExistsException
	 */
	public TbNtfUsuariostipontf insert(String usuarioCrea, Integer usuarioIdn,
			Integer tipoNotificacionIdn, Boolean notificar)
			throws DaoException, AlreadyExistsException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que especifica no puede ser nulo o vacio");
		}
		if (usuarioIdn == null) {
			throw new DaoException(
					"El usuario al que se le asocia el tipo de notificacion no puede ser nulo");
		}
		if (tipoNotificacionIdn == null) {
			throw new DaoException("El tipo de notificacion no puede ser nulo");
		}
		if (notificar == null) {
			throw new DaoException("El valor de notificar no puede ser nulo");
		}
		TbNtfUsuariostipontf tipoUsuario = tbNtfUsuariostipontfDAO
				.findByForeignKey(tipoNotificacionIdn, usuarioIdn);
		if (tipoUsuario != null) {
			throw new AlreadyExistsException(
					"El usuario ya esta asociado con el tipo de notificacion");
		}
		TbAdmUsuarios usuarioActual = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuarioActual == null) {
			throw new DaoException(
					"El usuario que crea el permiso de notificacion no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService.get(usuarioIdn);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que especifica el tipo de notificacion no existe en la base de datos");
		}
		TbNtfsTipontfsroles tipoNotificacionRol = tbNtfsTipontfsrolesService
				.get(tipoNotificacionIdn);
		if (tipoNotificacionRol == null) {
			throw new DaoException(
					"El tipo de notificacion especificado no existe en la base de datos");
		}
		tipoUsuario = new TbNtfUsuariostipontf();
		tipoUsuario.setBlNotificar(notificar);
		tipoUsuario.setDtAdtfecha(new Date());
		tipoUsuario.setTbAdmUsuarios(usuario);
		tipoUsuario.setTbNtfsTipontfsroles(tipoNotificacionRol);
		tipoUsuario.setVrAdtusuario(usuarioCrea);
		return tbNtfUsuariostipontfDAO.save(tipoUsuario);
	}

	/**
	 * 
	 * @param tipoRolIdn
	 * @param usuarioIdn
	 * @throws DaoException
	 */
	public void delete(Integer tipoRolIdn, Integer usuarioIdn)
			throws DaoException {
		TbNtfUsuariostipontf deleted = findByForeignKey(tipoRolIdn, usuarioIdn);
		if (deleted != null) {
			
			for (TbNtfUsrtpntfmedios medio : tbNtfUsrtpntfmediosService.findMediosByUsuarioTipoNotificacion(deleted.getNbIdn())) {
				tbNtfUsrtpntfmediosService.delete(medio
						.getTbNtfUsuariostipontf().getNbIdn(), medio
						.getTbNtfMediostipontf().getNbIdn());
			}
			tbNtfUsuariostipontfDAO.delete(deleted);
		}
	}

	/**
	 * 
	 * @param tipoNotificacionIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfUsuariostipontf> findTipoNotificacionByTipoNotificacion(
			Integer tipoNotificacionIdn) throws DaoException {
		return tbNtfUsuariostipontfDAO
				.findTipoNotificacionByTipoNotificacion(tipoNotificacionIdn);
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfUsuariostipontf> findTipoNotificacionByUsuario(
			Integer usuarioIdn) throws DaoException {
		return tbNtfUsuariostipontfDAO
				.findTipoNotificacionByUsuario(usuarioIdn);
	}

}
