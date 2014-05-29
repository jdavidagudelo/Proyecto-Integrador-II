package co.edu.udea.proyectointegrador.service;

import java.util.Date;

import java.util.List;
import co.edu.udea.proyectointegrador.dao.TbAdmRolesxpermisosDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmPermisos;
import co.edu.udea.proyectointegrador.dto.TbAdmRoles;
import co.edu.udea.proyectointegrador.dto.TbAdmRolesxpermisos;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * Clase usada para acceder a la tabla de permisos x roles de la base de datos
 * 
 * @author juan
 * 
 */
public class TbAdmRolesxpermisosService {
	private TbAdmRolesxpermisosDAO tbAdmRolesxpermisosDAO;
	private TbAdmRolesService tbAdmRolesService;
	private TbAdmPermisosService tbAdmPermisosService;
	private TbAdmUsuariosService tbAdmUsuariosService;

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

	public TbAdmPermisosService getTbAdmPermisosService() {
		return tbAdmPermisosService;
	}

	public void setTbAdmPermisosService(
			TbAdmPermisosService tbAdmPermisosService) {
		this.tbAdmPermisosService = tbAdmPermisosService;
	}

	/**
	 * Metodo que permite obtener todos los permisos x roles de la base de
	 * datos.
	 * 
	 * @return lista de todos los roles x permisos
	 * @throws DaoException
	 */
	public List<TbAdmRolesxpermisos> findAll() throws DaoException {
		return tbAdmRolesxpermisosDAO.findAll();
	}

	/**
	 * Metodo que permite obtener el permiso de rol con el id ingresado como
	 * argumento.
	 * 
	 * @param id
	 *            id del rol x permiso.
	 * @return el rol x permiso con el id ingresado como argumento
	 * @throws DaoException
	 */
	public TbAdmRolesxpermisos get(Integer id) throws DaoException {
		return tbAdmRolesxpermisosDAO.get(id);
	}

	public TbAdmRolesxpermisosDAO getTbAdmRolesxpermisosDAO() {
		return tbAdmRolesxpermisosDAO;
	}

	public void setTbAdmRolesxpermisosDAO(
			TbAdmRolesxpermisosDAO tbAdmRolesxpermisosDAO) {
		this.tbAdmRolesxpermisosDAO = tbAdmRolesxpermisosDAO;
	}

	/**
	 * Permite obtener todos los permisos asociados con el rol ingresado como
	 * argumento.
	 * 
	 * @param rolId
	 *            el id del rol para el que se desean buscar los permisos
	 * @return lista de permisos asociados con el rol ingresado como argumento
	 * @throws DaoException
	 */
	public List<TbAdmRolesxpermisos> findById(Integer rolId)
			throws DaoException {
		return tbAdmRolesxpermisosDAO.findById(rolId);
	}

	/**
	 * Metodo que permite insertar un nuevo rol x permiso en la base de datos
	 * 
	 * @param usuarioCrea
	 *            el login del usuario que crea el rol x permiso
	 * @param rolIdn
	 *            el id del rol asociado con el permiso
	 * @param permisoIdn
	 *            el id del permiso asociado con el rol
	 * @return permiso x rol creado
	 * @throws DaoException
	 */
	public TbAdmRolesxpermisos insert(String usuarioCrea, Integer rolIdn,
			Integer permisoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea el rol x permiso no puede ser nulo");
		}
		if (rolIdn == null) {
			throw new DaoException("EL rol id no puede ser nulo");
		}
		if (permisoIdn == null) {
			throw new DaoException("El id del permiso no puede ser nulo");
		}
		TbAdmRoles rol = tbAdmRolesService.get(rolIdn);
		if (rol == null) {
			throw new DaoException(
					"El rol ingresado no existe en la base de datos");
		}
		TbAdmPermisos permiso = tbAdmPermisosService.get(permisoIdn);
		if (permiso == null) {
			throw new DaoException(
					"El permiso ingresado no existe en la base de datos");
		}
		TbAdmRolesxpermisos rolPermiso = new TbAdmRolesxpermisos();
		rolPermiso.setDtAdtfecha(new Date());
		rolPermiso.setVrAdtusuario(usuarioCrea);
		rolPermiso.setTbAdmPermisos(permiso);
		rolPermiso.setTbAdmRoles(rol);
		return tbAdmRolesxpermisosDAO.save(rolPermiso);
	}

	/**
	 * Metodo que permite obtener el rol x permiso con el rol y permiso
	 * ingresados como argumento
	 * 
	 * @param rolId
	 *            rol del permiso
	 * @param permisoIdn
	 *            permiso asociado
	 * @return rol x permiso asociado con los argumentos ingresados
	 * @throws DaoException
	 */
	public TbAdmRolesxpermisos findByForeignKey(Integer rolId,
			Integer permisoIdn) throws DaoException {
		if (rolId == null) {
			throw new DaoException("El id del rol no puede ser nulo");
		}
		if (permisoIdn == null) {
			throw new DaoException("El id del permiso no puede ser nulo");
		}
		TbAdmRoles rol = tbAdmRolesService.get(rolId);
		if (rol == null) {
			throw new DaoException("El rol no existe en la base de datos");
		}
		TbAdmPermisos permiso = tbAdmPermisosService.get(permisoIdn);
		if (permiso == null) {
			throw new DaoException("El permiso no existe en la base de datos");
		}
		return tbAdmRolesxpermisosDAO.findByForeignKey(rolId, permisoIdn);
	}

	/**
	 * Metodo usado para eliminar el rol x permiso con el id ingresado como
	 * argumento
	 * 
	 * @param nbIdn
	 *            el id del rol x permiso
	 * @throws DaoException
	 */
	public void delete(Integer nbIdn) throws DaoException {
		if (nbIdn == null) {
			throw new DaoException("El id no puede ser nulo");
		}
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosDAO.get(nbIdn);
		if (rolPermiso != null) {
			tbAdmRolesxpermisosDAO.delete(rolPermiso);
		}
	}
}
