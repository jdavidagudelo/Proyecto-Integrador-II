package co.edu.udea.proyectointegrador.service;

import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbAdmPermisosDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmPermisos;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.properties.Properties;

/**
 * Clase usada para representar la logica del negocio de la aplicacion.
 * */
public class TbAdmPermisosService {
	private static final Properties properties = Properties.getInstance();
	/**
	 * Permite acceder a la lista de permisos.
	 * */
	private TbAdmPermisosDAO tbAdmPermisosDAO;

	/**
	 * Permite obtener la lista de todos los permisos de la base de datos.
	 * 
	 * @return lista de todos los permisos de la base de datos
	 * */
	public List<TbAdmPermisos> findAll() throws DaoException {
		return tbAdmPermisosDAO.findAll();
	}

	/**
	 * Permite obtener el permiso con el id ingresado como argumento.
	 * 
	 * @param id
	 *            el identificador del permiso en la base de datos.
	 * @return permiso con el id ingresado como argumento.
	 * */
	public TbAdmPermisos get(Integer id) throws DaoException {
		return tbAdmPermisosDAO.get(id);
	}

	public TbAdmPermisosDAO getTbAdmPermisosDAO() {
		return tbAdmPermisosDAO;
	}

	public void setTbAdmPermisosDAO(TbAdmPermisosDAO tbAdmPermisosDAO) {
		this.tbAdmPermisosDAO = tbAdmPermisosDAO;
	}

	/**
	 * Lista de permisos asociados a proyectos.
	 * 
	 * @return lista de los permisos de acciones que se pueden realizar sobre un
	 *         proyecto.
	 * */
	public List<TbAdmPermisos> findPermisosProyectos() throws DaoException {
		return tbAdmPermisosDAO
				.findPermisosByTipo(properties.getPermisoTipoProyecto());
	}

	/**
	 * Lista de permisos asociados a actividad.
	 * 
	 * @return lista de los permisos de acciones que se pueden realizar sobre
	 *         una actividad.
	 * */
	public List<TbAdmPermisos> findPermisosActividades() throws DaoException {
		return tbAdmPermisosDAO
				.findPermisosByTipo(properties.getPermisoTipoActividad());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbAdmPermisos> findPermisosGenerales() throws DaoException {
		return tbAdmPermisosDAO
				.findPermisosByTipo(properties.getPermisoTipoGeneral());
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoCrearProyecto()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisoCrearProyecto()));
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoListarTipoNotificacion()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisoListarTipoNotificacion()));
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoEspecificarNotificaciones()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisoEspecificarNotificaciones()));
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoPermisosProyectos()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisoPermisosProyectos()));
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoPermisosActividades()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisoPermisosActividades()));
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoCrearUsuario() throws NumberFormatException,
			DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisoCrearUsuario()));

	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoListarProyectos()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisoListarProyectos()));

	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoModificarUsuario()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisoModificarUsuario()));
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoListarNotificaciones()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisoListarNotificaciones()));
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoListarPermisos()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisosListarPermisos()));
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoListarReportes()
			throws NumberFormatException, DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisosListarReportes()));
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public TbAdmPermisos getPermisoListarRoles() throws NumberFormatException,
			DaoException {
		return tbAdmPermisosDAO.get(Integer.parseInt(properties
				.getPermisosListarRoles()));
	}
	public TbAdmPermisos getPermisoSuperUsuario() throws NumberFormatException, DaoException
	{
		return tbAdmPermisosDAO.get(Integer.parseInt(properties.getPermisoSuperUsuario()));
	}
}
