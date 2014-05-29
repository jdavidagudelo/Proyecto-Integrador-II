package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryPermisosxestadosDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmPermisos;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryEstados;
import co.edu.udea.proyectointegrador.dto.TbPryPermisosxestados;
import co.edu.udea.proyectointegrador.dto.TbPryRolesxpermisosestadosproyecto;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbPryPermisosxestadosService {
	private TbPryPermisosxestadosDAO tbPryPermisosxestadosDAO;
	private TbAdmPermisosService tbAdmPermisosService;
	private TbPryEstadosService tbPryEstadosService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbPryRolesxpermisosestadosproyectoService tbPryRolesxpermisosestadosproyectoService;

	public TbPryRolesxpermisosestadosproyectoService getTbPryRolesxpermisosestadosproyectoService() {
		return tbPryRolesxpermisosestadosproyectoService;
	}

	public void setTbPryRolesxpermisosestadosproyectoService(
			TbPryRolesxpermisosestadosproyectoService tbPryRolesxpermisosestadosproyectoService) {
		this.tbPryRolesxpermisosestadosproyectoService = tbPryRolesxpermisosestadosproyectoService;
	}

	/**
	 * 
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryPermisosxestados> findPermisosByEstado(Integer estadoIdn)
			throws DaoException {
		return tbPryPermisosxestadosDAO.findPermisosByEstado(estadoIdn);
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryPermisosxestados> findAll() throws DaoException {
		return tbPryPermisosxestadosDAO.findAll();
	}

	/**
	 * 
	 * @return
	 */
	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	/**
	 * 
	 * @param tbAdmUsuariosService
	 */
	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	/**
	 * 
	 * @return
	 */
	public TbPryPermisosxestadosDAO getTbPryPermisosxestadosDAO() {
		return tbPryPermisosxestadosDAO;
	}

	/**
	 * 
	 * @param tbPryPermisosxestadosDAO
	 */
	public void setTbPryPermisosxestadosDAO(
			TbPryPermisosxestadosDAO tbPryPermisosxestadosDAO) {
		this.tbPryPermisosxestadosDAO = tbPryPermisosxestadosDAO;
	}

	/**
	 * 
	 * @return
	 */
	public TbAdmPermisosService getTbAdmPermisosService() {
		return tbAdmPermisosService;
	}

	/**
	 * 
	 * @param tbAdmPermisosService
	 */
	public void setTbAdmPermisosService(
			TbAdmPermisosService tbAdmPermisosService) {
		this.tbAdmPermisosService = tbAdmPermisosService;
	}

	/**
	 * 
	 * @return
	 */
	public TbPryEstadosService getTbPryEstadosService() {
		return tbPryEstadosService;
	}

	public void setTbPryEstadosService(TbPryEstadosService tbPryEstadosService) {
		this.tbPryEstadosService = tbPryEstadosService;
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param permisoIdn
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryPermisosxestados insert(String usuarioCrea, Integer permisoIdn,
			Integer estadoIdn) throws DaoException {
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
		TbPryEstados estado = tbPryEstadosService.get(estadoIdn);
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
		TbPryPermisosxestados permisoxestado = new TbPryPermisosxestados();
		permisoxestado.setDtAdtfecha(new Date());
		permisoxestado.setTbAdmPermisos(permiso);
		permisoxestado.setTbPryEstados(estado);
		permisoxestado.setVrAdtusuario(usuarioCrea);
		return tbPryPermisosxestadosDAO.save(permisoxestado);
	}

	/**
	 * 
	 * @param permisoIdn
	 * @param estadoIdn
	 * @throws DaoException
	 */
	public void delete(Integer permisoIdn, Integer estadoIdn)
			throws DaoException {
		TbPryPermisosxestados permisoxestado = tbPryPermisosxestadosDAO
				.findByForeignKey(permisoIdn, estadoIdn);
		if (permisoxestado != null) {
			for (TbPryRolesxpermisosestadosproyecto rolPermiso : tbPryRolesxpermisosestadosproyectoService
					.findByForeignKey(permisoxestado.getNbIdn())) {
				tbPryRolesxpermisosestadosproyectoService.delete(rolPermiso
						.getTbAdmRoles().getNbIdn(), permisoxestado.getNbIdn());
			}
			tbPryPermisosxestadosDAO.delete(permisoxestado);
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbPryPermisosxestados get(Integer id) throws DaoException {
		return tbPryPermisosxestadosDAO.get(id);
	}
}
