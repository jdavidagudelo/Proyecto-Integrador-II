package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbNtfsTipontfsrolesDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmRoles;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbNtfTipontfs;
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
public class TbNtfsTipontfsrolesService {
	private TbNtfsTipontfsrolesDAO tbNtfsTipontfsrolesDAO;
	private TbAdmRolesService tbAdmRolesService;
	private TbNtfTipontfsService tbNtfTipontfsService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbNtfUsuariostipontfService tbNtfUsuariostipontfService;

	public TbNtfUsuariostipontfService getTbNtfUsuariostipontfService() {
		return tbNtfUsuariostipontfService;
	}

	public void setTbNtfUsuariostipontfService(
			TbNtfUsuariostipontfService tbNtfUsuariostipontfService) {
		this.tbNtfUsuariostipontfService = tbNtfUsuariostipontfService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbAdmRolesService getTbAdmRolesService() {
		return tbAdmRolesService;
	}

	public void setTbAdmRolesService(TbAdmRolesService tbAdmRolesService) {
		this.tbAdmRolesService = tbAdmRolesService;
	}

	public TbNtfTipontfsService getTbNtfTipontfsService() {
		return tbNtfTipontfsService;
	}

	public void setTbNtfTipontfsService(
			TbNtfTipontfsService tbNtfTipontfsService) {
		this.tbNtfTipontfsService = tbNtfTipontfsService;
	}

	public TbNtfsTipontfsrolesDAO getTbNtfsTipontfsrolesDAO() {
		return tbNtfsTipontfsrolesDAO;
	}

	public void setTbNtfsTipontfsrolesDAO(
			TbNtfsTipontfsrolesDAO tbNtfsTipontfsrolesDAO) {
		this.tbNtfsTipontfsrolesDAO = tbNtfsTipontfsrolesDAO;
	}

	/**
	 * 
	 * @param rolIdn
	 * @param tipoNotificacionIdn
	 * @return
	 * @throws DaoException
	 */
	public TbNtfsTipontfsroles findByForeignKey(Integer rolIdn,
			Integer tipoNotificacionIdn) throws DaoException {
		return tbNtfsTipontfsrolesDAO.findByForeignKey(rolIdn,
				tipoNotificacionIdn);
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfsTipontfsroles> findAll() throws DaoException {
		return tbNtfsTipontfsrolesDAO.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbNtfsTipontfsroles get(Integer id) throws DaoException {
		return tbNtfsTipontfsrolesDAO.get(id);
	}

	/**
	 * 
	 * @param tipoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfsTipontfsroles> findRolesByTipoNotificacion(Integer tipoIdn)
			throws DaoException {
		return tbNtfsTipontfsrolesDAO.findRolesByTipoNotificacion(tipoIdn);
	}

	/**
	 * 
	 * @param rolIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfsTipontfsroles> findTiposNotificacionByRol(Integer rolIdn)
			throws DaoException {
		return tbNtfsTipontfsrolesDAO.findTiposNotificacionByRol(rolIdn);
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param tipoIdn
	 * @param rolIdn
	 * @param configurable
	 * @return
	 * @throws DaoException
	 */
	public TbNtfsTipontfsroles update(String usuarioCrea, Integer tipoIdn,
			Integer rolIdn, Boolean configurable) throws DaoException {

		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea la notificación por rol no puede ser nulo o vacio");
		}
		if (tipoIdn == null) {
			throw new DaoException("El tipo de notificacion no puede ser nulo");
		}
		if (rolIdn == null) {
			throw new DaoException("El rol no puede ser nulo");
		}
		if (configurable == null) {
			throw new DaoException("El valor de configurable no puede ser nulo");
		}
		TbNtfsTipontfsroles tipoRol = tbNtfsTipontfsrolesDAO.findByForeignKey(
				rolIdn, tipoIdn);
		if (tipoRol == null) {
			throw new DaoException(
					"La notificacion por rol no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario especificado no existe en la base de datos");
		}
		tipoRol.setBlConfigurable(configurable);
		tipoRol.setDtAdtfecha(new Date());
		tipoRol.setVrAdtusuario(usuarioCrea);
		return tbNtfsTipontfsrolesDAO.update(tipoRol);
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param tipoIdn
	 * @param rolIdn
	 * @param configurable
	 * @return
	 * @throws DaoException
	 * @throws AlreadyExistsException
	 */
	public TbNtfsTipontfsroles insert(String usuarioCrea, Integer tipoIdn,
			Integer rolIdn, Boolean configurable) throws DaoException,
			AlreadyExistsException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea la notificación por rol no puede ser nulo o vacio");
		}
		if (tipoIdn == null) {
			throw new DaoException("El tipo de notificacion no puede ser nulo");
		}
		if (rolIdn == null) {
			throw new DaoException("El rol no puede ser nulo");
		}
		if (configurable == null) {
			throw new DaoException("El valor de configurable no puede ser nulo");
		}
		TbNtfsTipontfsroles tipoRol = tbNtfsTipontfsrolesDAO.findByForeignKey(
				rolIdn, tipoIdn);
		if (tipoRol != null) {
			throw new AlreadyExistsException(
					"La notificacion por rol ya existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario especificado no existe en la base de datos");
		}
		TbAdmRoles rol = tbAdmRolesService.get(rolIdn);
		if (rol == null) {
			throw new DaoException(
					"El rol especificado no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService.get(tipoIdn);
		if (tipoNotificacion == null) {
			throw new DaoException(
					"El tipo de notificacion no existe en la base de datos");
		}
		tipoRol = new TbNtfsTipontfsroles();
		tipoRol.setBlConfigurable(configurable);
		tipoRol.setDtAdtfecha(new Date());
		tipoRol.setTbAdmRoles(rol);
		tipoRol.setTbNtfTipontfs(tipoNotificacion);
		tipoRol.setVrAdtusuario(usuarioCrea);
		return tbNtfsTipontfsrolesDAO.save(tipoRol);
	}

	/**
	 * 
	 * @param rolIdn
	 * @param tipoIdn
	 * @throws DaoException
	 */
	public void delete(Integer rolIdn, Integer tipoIdn) throws DaoException {
		TbNtfsTipontfsroles rolTipo = findByForeignKey(rolIdn, tipoIdn);
		if (rolTipo != null) {
			for (TbNtfUsuariostipontf usuario : tbNtfUsuariostipontfService
					.findTipoNotificacionByTipoNotificacion(rolTipo.getNbIdn())) {
				tbNtfUsuariostipontfService.delete(usuario
						.getTbNtfsTipontfsroles().getNbIdn(), usuario
						.getTbAdmUsuarios().getNbIdn());
			}
			tbNtfsTipontfsrolesDAO.delete(rolTipo);
		}
	}

}
