package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryRolesxpermisosestadosactividadDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmRoles;
import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.dto.TbPryPermisosxestadosactividad;
import co.edu.udea.proyectointegrador.dto.TbPryRolesxpermisosestadosactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryRolesxpermisosestadosactividadService {
	private TbPryRolesxpermisosestadosactividadDAO tbPryRolesxpermisosestadosactividadDAO;
	private TbPryPermisosxestadosactividadService tbPryPermisosxestadosactividadService;
	private TbAdmRolesService tbAdmRolesService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbPryActividadesService tbPryActividadesService;

	public TbPryActividadesService getTbPryActividadesService() {
		return tbPryActividadesService;
	}

	public void setTbPryActividadesService(
			TbPryActividadesService tbPryActividadesService) {
		this.tbPryActividadesService = tbPryActividadesService;
	}

	public TbPryPermisosxestadosactividadService getTbPryPermisosxestadosactividadService() {
		return tbPryPermisosxestadosactividadService;
	}

	public void setTbPryPermisosxestadosactividadService(
			TbPryPermisosxestadosactividadService tbPryPermisosxestadosactividadService) {
		this.tbPryPermisosxestadosactividadService = tbPryPermisosxestadosactividadService;
	}

	public TbAdmRolesService getTbAdmRolesService() {
		return tbAdmRolesService;
	}

	public void setTbAdmRolesService(TbAdmRolesService tbAdmRolesService) {
		this.tbAdmRolesService = tbAdmRolesService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbPryRolesxpermisosestadosactividadDAO getTbPryRolesxpermisosestadosactividadDAO() {
		return tbPryRolesxpermisosestadosactividadDAO;
	}

	public void setTbPryRolesxpermisosestadosactividadDAO(
			TbPryRolesxpermisosestadosactividadDAO tbPryRolesxpermisosestadosactividadDAO) {
		this.tbPryRolesxpermisosestadosactividadDAO = tbPryRolesxpermisosestadosactividadDAO;
	}

	/**
	 * 
	 * @param permisoEstadoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryRolesxpermisosestadosactividad> findByForeignKey(
			Integer permisoEstadoIdn) throws DaoException {
		return tbPryRolesxpermisosestadosactividadDAO
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
	public TbPryRolesxpermisosestadosactividad insert(String usuarioCrea,
			Integer rolIdn, Integer permisoIdn) throws DaoException {
		TbAdmRoles rol = tbAdmRolesService.get(rolIdn);
		TbPryPermisosxestadosactividad permiso = tbPryPermisosxestadosactividadService
				.get(permisoIdn);
		TbPryRolesxpermisosestadosactividad rolPermiso = new TbPryRolesxpermisosestadosactividad();
		rolPermiso.setDtAdtfecha(new Date());
		rolPermiso.setVrAdtusuario(usuarioCrea);
		rolPermiso.setTbAdmRoles(rol);
		rolPermiso.setTbPryPermisosxestadosactividad(permiso);
		return tbPryRolesxpermisosestadosactividadDAO.save(rolPermiso);
	}

	/**
	 * 
	 * @param rolIdn
	 * @param permisoEstadoIdn
	 * @throws DaoException
	 */
	public void delete(Integer rolIdn, Integer permisoEstadoIdn)
			throws DaoException {
		TbPryRolesxpermisosestadosactividad rolPermiso = tbPryRolesxpermisosestadosactividadDAO
				.findPermisoEstadoByForeignKey(rolIdn, permisoEstadoIdn);
		if (rolPermiso != null) {
			tbPryRolesxpermisosestadosactividadDAO.delete(rolPermiso);
		}
	}

	/**
	 * 
	 * @param rolIdn
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryRolesxpermisosestadosactividad> findByForeignKey(
			Integer rolIdn, Integer estadoIdn) throws DaoException {
		return tbPryRolesxpermisosestadosactividadDAO.findByForeignKey(rolIdn,
				estadoIdn);
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
		return tbPryRolesxpermisosestadosactividadDAO.validarPermiso(estadoIdn,
				rolIdn, permisoNombre);
	}
	/**
	 * 
	 * @param actividadIdn
	 * @param rolIdn
	 * @param permisoNombre
	 * @return
	 * @throws DaoException
	 */
	public Boolean validarPermisoActividad(Integer actividadIdn,
			Integer rolIdn, String permisoNombre) throws DaoException {
		if(actividadIdn == null)
		{
			throw new DaoException("La actividad no puede ser nula");
		}
		if(rolIdn == null)
		{
			throw new DaoException("El rol no puede ser nulo");
		}
		if(permisoNombre == null)
		{
			throw new DaoException("El permiso no puede ser nulo");
		}
		
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if(actividad == null)
		{
			throw new DaoException("La actividad con el id ingresado no existe en la base de datos");
		}
		return tbPryRolesxpermisosestadosactividadDAO.validarPermiso(actividad
				.getTbPryEstadosactividad().getNbIdn(), rolIdn, permisoNombre);
	}
}
