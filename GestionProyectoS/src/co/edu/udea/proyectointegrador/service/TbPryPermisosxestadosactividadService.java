package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryPermisosxestadosactividadDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmPermisos;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryEstadosactividad;
import co.edu.udea.proyectointegrador.dto.TbPryPermisosxestadosactividad;
import co.edu.udea.proyectointegrador.dto.TbPryRolesxpermisosestadosactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbPryPermisosxestadosactividadService {
	private TbPryPermisosxestadosactividadDAO tbPryPermisosxestadosactividadDAO;
	private TbPryEstadosactividadService tbPryEstadosactividadService;
	private TbAdmPermisosService tbAdmPermisosService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbPryRolesxpermisosestadosactividadService tbPryRolesxpermisosestadosactividadService;

	public TbPryRolesxpermisosestadosactividadService getTbPryRolesxpermisosestadosactividadService() {
		return tbPryRolesxpermisosestadosactividadService;
	}

	public void setTbPryRolesxpermisosestadosactividadService(
			TbPryRolesxpermisosestadosactividadService tbPryRolesxpermisosestadosactividadService) {
		this.tbPryRolesxpermisosestadosactividadService = tbPryRolesxpermisosestadosactividadService;
	}

	public List<TbPryPermisosxestadosactividad> findPermisosByEstado(
			Integer estadoIdn) throws DaoException {
		return tbPryPermisosxestadosactividadDAO
				.findPermisosByEstado(estadoIdn);
	}

	public List<TbPryPermisosxestadosactividad> findAll() throws DaoException {
		return tbPryPermisosxestadosactividadDAO.findAll();
	}

	public TbPryPermisosxestadosactividadDAO getTbPryPermisosxestadosactividadDAO() {
		return tbPryPermisosxestadosactividadDAO;
	}

	public void setTbPryPermisosxestadosactividadDAO(
			TbPryPermisosxestadosactividadDAO tbPryPermisosxestadosactividadDAO) {
		this.tbPryPermisosxestadosactividadDAO = tbPryPermisosxestadosactividadDAO;
	}

	public TbPryEstadosactividadService getTbPryEstadosactividadService() {
		return tbPryEstadosactividadService;
	}

	public void setTbPryEstadosactividadService(
			TbPryEstadosactividadService tbPryEstadosactividadService) {
		this.tbPryEstadosactividadService = tbPryEstadosactividadService;
	}

	public TbAdmPermisosService getTbAdmPermisosService() {
		return tbAdmPermisosService;
	}

	public void setTbAdmPermisosService(
			TbAdmPermisosService tbAdmPermisosService) {
		this.tbAdmPermisosService = tbAdmPermisosService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param permisoIdn
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryPermisosxestadosactividad insert(String usuarioCrea,
			Integer permisoIdn, Integer estadoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea el permiso no puede ser nulo o vacio");
		}
		if (permisoIdn == null) {
			throw new DaoException("El codigo del permiso no puede ser nulo");
		}
		if (estadoIdn == null) {
			throw new DaoException("El codigo del estado no puede ser nulo");
		}
		TbPryEstadosactividad estado = tbPryEstadosactividadService
				.get(estadoIdn);
		if (estado == null) {
			throw new DaoException(
					"El estado especificado no existe en la base de datos");
		}
		TbAdmPermisos permiso = tbAdmPermisosService.get(permisoIdn);
		if (permiso == null) {
			throw new DaoException(
					"El permiso especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea el permiso no existe en la base de datos");
		}
		TbPryPermisosxestadosactividad permisoxestado = new TbPryPermisosxestadosactividad();
		permisoxestado.setDtAdtfecha(new Date());
		permisoxestado.setTbAdmPermisos(permiso);
		permisoxestado.setTbPryEstadosactividad(estado);
		permisoxestado.setVrAdtusuario(usuarioCrea);
		return tbPryPermisosxestadosactividadDAO.save(permisoxestado);
	}

	/**
	 * 
	 * @param permisoIdn
	 * @param estadoIdn
	 * @throws DaoException
	 */
	public void delete(Integer permisoIdn, Integer estadoIdn)
			throws DaoException {
		TbPryPermisosxestadosactividad permisoxestado = tbPryPermisosxestadosactividadDAO
				.findByForeignKey(permisoIdn, estadoIdn);
		if (permisoxestado != null) {
			for (TbPryRolesxpermisosestadosactividad rolPermiso : tbPryRolesxpermisosestadosactividadService
					.findByForeignKey(permisoxestado.getNbIdn())) {
				tbPryRolesxpermisosestadosactividadService.delete(rolPermiso
						.getTbAdmRoles().getNbIdn(), permisoxestado.getNbIdn());
			}
			tbPryPermisosxestadosactividadDAO.delete(permisoxestado);
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbPryPermisosxestadosactividad get(Integer id) throws DaoException {
		return tbPryPermisosxestadosactividadDAO.get(id);
	}
}
