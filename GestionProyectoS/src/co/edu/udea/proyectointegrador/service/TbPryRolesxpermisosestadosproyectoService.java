package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryRolesxpermisosestadosproyectoDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmRoles;
import co.edu.udea.proyectointegrador.dto.TbPryPermisosxestados;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.dto.TbPryRolesxpermisosestadosproyecto;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryRolesxpermisosestadosproyectoService {
	private TbPryRolesxpermisosestadosproyectoDAO tbPryRolesxpermisosestadosproyectoDAO;
	private TbPryPermisosxestadosService tbPryPermisosxestadosService;
	private TbAdmRolesService tbAdmRolesService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbPryProyectosService tbPryProyectosService;

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

	public TbPryPermisosxestadosService getTbPryPermisosxestadosService() {
		return tbPryPermisosxestadosService;
	}

	public void setTbPryPermisosxestadosService(
			TbPryPermisosxestadosService tbPryPermisosxestadosService) {
		this.tbPryPermisosxestadosService = tbPryPermisosxestadosService;
	}

	public TbAdmRolesService getTbAdmRolesService() {
		return tbAdmRolesService;
	}

	public void setTbAdmRolesService(TbAdmRolesService tbAdmRolesService) {
		this.tbAdmRolesService = tbAdmRolesService;
	}

	public TbPryRolesxpermisosestadosproyectoDAO getTbPryRolesxpermisosestadosproyectoDAO() {
		return tbPryRolesxpermisosestadosproyectoDAO;
	}

	public void setTbPryRolesxpermisosestadosproyectoDAO(
			TbPryRolesxpermisosestadosproyectoDAO tbPryRolesxpermisosestadosproyectoDAO) {
		this.tbPryRolesxpermisosestadosproyectoDAO = tbPryRolesxpermisosestadosproyectoDAO;
	}

	/**
	 * 
	 * @param permisoEstadoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryRolesxpermisosestadosproyecto> findByForeignKey(
			Integer permisoEstadoIdn) throws DaoException {
		return tbPryRolesxpermisosestadosproyectoDAO
				.findByForeignKey(permisoEstadoIdn);
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param rolIdn
	 * @param permisoIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryRolesxpermisosestadosproyecto insert(String usuarioCrea,
			Integer rolIdn, Integer permisoIdn) throws DaoException {
		TbAdmRoles rol = tbAdmRolesService.get(rolIdn);
		TbPryPermisosxestados permiso = tbPryPermisosxestadosService
				.get(permisoIdn);
		TbPryRolesxpermisosestadosproyecto rolPermiso = new TbPryRolesxpermisosestadosproyecto();
		rolPermiso.setDtAdtfecha(new Date());
		rolPermiso.setVrAdtusuario(usuarioCrea);
		rolPermiso.setTbAdmRoles(rol);
		rolPermiso.setTbPryPermisosxestados(permiso);
		return tbPryRolesxpermisosestadosproyectoDAO.save(rolPermiso);
	}
	/**
	 * 
	 * @param estadoIdn
	 * @param rolIdn
	 * @param permisoNombre
	 * @return
	 * @throws DaoException
	 */
	public Boolean validarPermiso(Integer estadoIdn, Integer rolIdn,
			String permisoNombre) throws DaoException {
		return tbPryRolesxpermisosestadosproyectoDAO.validarPermiso(estadoIdn,
				rolIdn, permisoNombre);
	}
	/**
	 * 
	 * @param proyectoIdn
	 * @param rolIdn
	 * @param permisoNombre
	 * @return
	 * @throws DaoException
	 */
	public Boolean validarPermisoProyecto(Integer proyectoIdn, Integer rolIdn,
			String permisoNombre) throws DaoException {
		if(proyectoIdn == null)
		{
			throw new DaoException("El id del proyecto no puede ser nulo");
		}
		if(rolIdn == null)
		{
			throw new DaoException("El rol del proyecto no puede ser nulo");
		}
		if(permisoNombre == null)
		{
			throw new DaoException("El permiso no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if(proyecto == null)
		{
			throw new DaoException("El proyecto con el id especificado no existe en la base de datos");
		}
		return tbPryRolesxpermisosestadosproyectoDAO.validarPermiso(proyecto
				.getTbPryEstados().getNbIdn(), rolIdn, permisoNombre);
	}

	/**
	 * 
	 * @param rolIdn
	 * @param permisoEstadoIdn
	 * @throws DaoException
	 */
	public void delete(Integer rolIdn, Integer permisoEstadoIdn)
			throws DaoException {
		TbPryRolesxpermisosestadosproyecto rolPermiso = tbPryRolesxpermisosestadosproyectoDAO
				.findPermisoEstadoByForeignKey(rolIdn, permisoEstadoIdn);
		if (rolPermiso != null) {
			tbPryRolesxpermisosestadosproyectoDAO.delete(rolPermiso);
		}
	}

	/**
	 * 
	 * @param rolIdn
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryRolesxpermisosestadosproyecto> findByForeignKey(
			Integer rolIdn, Integer estadoIdn) throws DaoException {
		return tbPryRolesxpermisosestadosproyectoDAO.findByForeignKey(rolIdn,
				estadoIdn);
	}
}
