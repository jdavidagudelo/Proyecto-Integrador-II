package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbAdmUsuariosDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmPermisos;
import co.edu.udea.proyectointegrador.dto.TbAdmRoles;
import co.edu.udea.proyectointegrador.dto.TbAdmRolesxpermisos;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.service.encode.Cifrar;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * Permite acceder a la capa de logica del negocio de la tabla de usuarios de la
 * base de datos.
 * 
 * @author juan
 * 
 */
public class TbAdmUsuariosService {
	private TbAdmUsuariosDAO tbAdmUsuariosDAO;
	private TbAdmRolesService tbAdmRolesService;
	private TbAdmRolesxpermisosService tbAdmRolesxpermisosService;
	private TbAdmPermisosService tbAdmPermisosService;

	public TbAdmPermisosService getTbAdmPermisosService() {
		return tbAdmPermisosService;
	}

	public void setTbAdmPermisosService(
			TbAdmPermisosService tbAdmPermisosService) {
		this.tbAdmPermisosService = tbAdmPermisosService;
	}

	public TbAdmRolesxpermisosService getTbAdmRolesxpermisosService() {
		return tbAdmRolesxpermisosService;
	}

	public void setTbAdmRolesxpermisosService(
			TbAdmRolesxpermisosService tbAdmRolesxpermisosService) {
		this.tbAdmRolesxpermisosService = tbAdmRolesxpermisosService;
	}

	public TbAdmRolesService getTbAdmRolesService() {
		return tbAdmRolesService;
	}

	public void setTbAdmRolesService(TbAdmRolesService tbAdmRolesService) {
		this.tbAdmRolesService = tbAdmRolesService;
	}

	public TbAdmUsuariosDAO getTbAdmUsuariosDAO() {
		return tbAdmUsuariosDAO;
	}

	public void setTbAdmUsuariosDAO(TbAdmUsuariosDAO tbAdmUsuariosDAO) {
		this.tbAdmUsuariosDAO = tbAdmUsuariosDAO;
	}

	/**
	 * Permite obtener la lista usuarios con rol de participantes de un
	 * proyecto.
	 * 
	 * @return lista usuarios con rol de participantes de proyectos
	 * @throws DaoException
	 */
	public List<TbAdmUsuarios> getParticipantes() throws DaoException {
		return tbAdmUsuariosDAO.getParticipantes(tbAdmRolesService.getRolParticipante().getVrNombre());
	}

	/**
	 * Lista de usuarios con rol de asesores.
	 * 
	 * @return lista de usuarios con rol de asesores.
	 * @throws DaoException
	 */
	public List<TbAdmUsuarios> getAsesores() throws DaoException {
		return tbAdmUsuariosDAO.getAsesores(tbAdmRolesService.getRolAsesor().getVrNombre());
	}

	/**
	 * Lista de usuarios con rol de responsable.
	 * 
	 * @return lista de usuarios con rol de responsable
	 * @throws DaoException
	 */
	public List<TbAdmUsuarios> getResponsables() throws DaoException {
		return tbAdmUsuariosDAO.getResponsables(tbAdmRolesService.getRolResponsable().getVrNombre());
	}

	/**
	 * Permite obtener el usuario con el id ingresado como argumento.
	 * 
	 * @param id
	 *            el id del usuario
	 * @return usuario con el id ingresado como argumento
	 * @throws DaoException
	 */
	public TbAdmUsuarios get(Integer id) throws DaoException {
		return tbAdmUsuariosDAO.get(id);
	}

	/**
	 * Permite obtener el usuario con el login ingresado como argumento.
	 * 
	 * @param login
	 *            login del usuario
	 * @return usuario con el login ingresado como argumento
	 * @throws DaoException
	 */
	public TbAdmUsuarios findUsuarioByLogin(String login) throws DaoException {
		return tbAdmUsuariosDAO.findUsuarioByLogin(login);
	}

	/**
	 * Metodo que permite actualizar un usuario
	 * 
	 * @param usuarioCrea
	 *            login del usuario que crea el nuevo usuario
	 * @param nombreUsuario
	 *            el nuevo nombre del usuario
	 * @param nombres
	 *            los nombres del usuario
	 * @param apellidos
	 *            los apellidos del usuario
	 * @param correo
	 *            el correo del usuario
	 * @param universidad
	 *            la universidad del usuario
	 * @param clave
	 *            la clave del usuario
	 * @param cedula
	 *            la cedula del usuario
	 * @param rolId
	 *            el id del rol del usuario
	 * @param usuarioIdn
	 *            el id del usuario
	 * @return el usuario actualizado
	 * @throws DaoException
	 */
	public TbAdmUsuarios update(String usuarioCrea, String nombreUsuario,
			String nombres, String apellidos, String correo,
			String universidad, String clave, String cedula, Integer rolId,
			Integer usuarioIdn) throws DaoException {
		if (Validaciones.isTextoVacio(cedula)) {
			throw new DaoException("La cedula del usuario no puede ser nula");
		}
		if (Validaciones.isTextoVacio(universidad)) {
			throw new DaoException(
					"La universidad del usuario no puede ser nula");
		}
		if (Validaciones.isTextoVacio(nombres)) {
			throw new DaoException("El campo de nombres no puede ser vacio");
		}
		if (Validaciones.isTextoVacio(nombreUsuario)) {
			throw new DaoException(
					"El campo de nombre de usuario no puede ser nulo");
		}
		if (Validaciones.isTextoVacio(apellidos)) {
			throw new DaoException("El campo de apellidos no puede ser nulo");
		}
		if (!Validaciones.isEmail(correo)) {
			throw new DaoException("El correo es invalido");
		}
		if (rolId == null) {
			throw new DaoException("El rol no puede ser nulo");
		}
		TbAdmRoles rol = tbAdmRolesService.get(rolId);
		if (rol == null) {
			throw new DaoException("El rol seleccionado no es valido");
		}
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			usuarioCrea = nombreUsuario;
		}
		if (usuarioIdn == null) {
			throw new DaoException();
		}

		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		if (usuario == null) {
			throw new DaoException(
					"El usuario actualizado no existe en la base de datos");
		}
		TbAdmUsuarios usuarioActual = tbAdmUsuariosDAO
				.findUsuarioByLogin(nombreUsuario);
		if (usuarioActual != null
				&& !usuario.getVrUsuario().equals(nombreUsuario)) {
			throw new DaoException(
					"Existe otro usuario con el mismo nombre de usuario en la base de datos");
		}
		usuario.setTbAdmRoles(rol);
		usuario.setDtAdtfecha(new Date());
		usuario.setNbEstado(0);
		usuario.setVrAdtusuario(usuarioCrea);
		usuario.setVrApellidos(apellidos);
		usuario.setVrCedula(cedula);
		Cifrar c = new Cifrar();
		String encripted = c.encrypt(clave);
		usuario.setVrClave(encripted);
		usuario.setVrCorreo(correo);
		usuario.setVrNombres(nombres);
		usuario.setVrUniversidad(universidad);
		usuario.setVrUsuario(nombreUsuario);
		return tbAdmUsuariosDAO.update(usuario);
	}

	/**
	 * Metodo que permite crear un usuario
	 * 
	 * @param usuarioCrea
	 *            login del usuario que crea el nuevo usuario
	 * @param nombreUsuario
	 *            el nuevo nombre del usuario
	 * @param nombres
	 *            los nombres del usuario
	 * @param apellidos
	 *            los apellidos del usuario
	 * @param correo
	 *            el correo del usuario
	 * @param universidad
	 *            la universidad del usuario
	 * @param clave
	 *            la clave del usuario
	 * @param cedula
	 *            la cedula del usuario
	 * @param rolId
	 *            el id del rol del usuario
	 * @return el usuario creado
	 * @throws DaoException
	 */
	public TbAdmUsuarios insert(String usuarioCrea, String nombreUsuario,
			String nombres, String apellidos, String correo,
			String universidad, String clave, String cedula, Integer rolId)
			throws DaoException {
		if (Validaciones.isTextoVacio(cedula)) {
			throw new DaoException("La cedula del usuario no puede ser nula");
		}
		if (Validaciones.isTextoVacio(universidad)) {
			throw new DaoException(
					"La universidad del usuario no puede ser nula");
		}
		if (Validaciones.isTextoVacio(nombres)) {
			throw new DaoException("El campo de nombres no puede ser vacio");
		}
		if (Validaciones.isTextoVacio(nombreUsuario)) {
			throw new DaoException(
					"El campo de nombre de usuario no puede ser nulo");
		}
		if (Validaciones.isTextoVacio(apellidos)) {
			throw new DaoException("El campo de apellidos no puede ser nulo");
		}
		if (!Validaciones.isEmail(correo)) {
			throw new DaoException("El correo es invalido");
		}
		if (rolId == null) {
			throw new DaoException("El rol no puede ser nulo");
		}
		TbAdmRoles rol = tbAdmRolesService.get(rolId);
		if (rol == null) {
			throw new DaoException("El rol seleccionado no es valido");
		}
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			usuarioCrea = nombreUsuario;
		}
		TbAdmUsuarios usuarioActual = tbAdmUsuariosDAO
				.findUsuarioByLogin(nombreUsuario);
		if (usuarioActual != null) {
			throw new DaoException(
					"El nombre de usuario ya existe en la base de datos");
		}
		TbAdmUsuarios usuario = new TbAdmUsuarios();
		usuario.setTbAdmRoles(rol);
		usuario.setDtAdtfecha(new Date());
		usuario.setNbEstado(0);
		usuario.setVrAdtusuario(usuarioCrea);
		usuario.setVrApellidos(apellidos);
		usuario.setVrCedula(cedula);
		Cifrar c = new Cifrar();
		String encripted = c.encrypt(clave);
		usuario.setVrClave(encripted);
		usuario.setVrCorreo(correo);
		usuario.setVrNombres(nombres);
		usuario.setVrUniversidad(universidad);
		usuario.setVrUsuario(nombreUsuario);
		return tbAdmUsuariosDAO.save(usuario);
	}

	/**
	 * Metodo que permite validar si un usuario ingreso una clave valida.
	 * 
	 * @param usuarioIdn
	 *            el id del usuario que se desea validar
	 * @param clave
	 *            la clave que ha ingresado el usuario
	 * @return true si la clave es valida, false en caso contrario
	 * @throws DaoException
	 */
	public boolean validar(Integer usuarioIdn, String clave)
			throws DaoException {
		if (clave == null) {
			return false;
		}
		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		if (usuario == null) {
			return false;
		}
		Cifrar c = new Cifrar();
		String encripted = c.encrypt(clave);
		return encripted.equals(usuario.getVrClave());
	}

	/**
	 * Permisos asociado con el usuario
	 * 
	 * @param usuarioIdn
	 *            id del usuario
	 * @return permisos asociados con el usuario ingresado
	 * @throws DaoException
	 */
	public List<TbAdmRolesxpermisos> getPermisosUsuario(Integer usuarioIdn)
			throws DaoException {
		if (usuarioIdn == null) {
			throw new DaoException("El usuario no puede ser nulo");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		if (usuario == null) {
			throw new DaoException("El usuario no existe en la base de datos");
		}
		List<TbAdmRolesxpermisos> rolesPermisos = tbAdmRolesxpermisosService
				.findById(usuario.getTbAdmRoles().getNbIdn());
		return rolesPermisos;
	}

	/**
	 * Valida si el usuario ingresado tiene permiso de crear proyectos.
	 * 
	 * @param usuarioIdn
	 *            id del usuario
	 * @return true si el usuario tiene permiso de crear proyectos, false en
	 *         caso contrario
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoCrearProyecto(Integer usuarioIdn)
			throws NumberFormatException, DaoException {
		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService.getPermisoCrearProyecto();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * Valida si el usuario puede listar tipos de notificacion
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoListarTipoNotificacion(Integer usuarioIdn)
			throws NumberFormatException, DaoException {
		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService
				.getPermisoListarTipoNotificacion();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoEspecificarNotificaciones(Integer usuarioIdn)
			throws NumberFormatException, DaoException {
		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService
				.getPermisoEspecificarNotificaciones();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoPermisosProyectos(Integer usuarioIdn)
			throws NumberFormatException, DaoException {
		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService
				.getPermisoPermisosProyectos();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoPermisosActividades(Integer usuarioIdn)
			throws NumberFormatException, DaoException {

		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService
				.getPermisoPermisosActividades();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoCrearUsuario(Integer usuarioIdn)
			throws NumberFormatException, DaoException {

		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService.getPermisoCrearUsuario();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoListarProyectos(Integer usuarioIdn)
			throws NumberFormatException, DaoException {
		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService
				.getPermisoListarProyectos();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoModificarUsuario(Integer usuarioIdn)
			throws NumberFormatException, DaoException {

		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService
				.getPermisoModificarUsuario();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoListarNotificaciones(Integer usuarioIdn)
			throws NumberFormatException, DaoException {

		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService
				.getPermisoListarNotificaciones();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoListarReportes(Integer usuarioIdn)
			throws NumberFormatException, DaoException {

		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService.getPermisoListarReportes();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws NumberFormatException
	 * @throws DaoException
	 */
	public Boolean getPermisoListarPermisos(Integer usuarioIdn)
			throws NumberFormatException, DaoException {

		TbAdmUsuarios usuario = tbAdmUsuariosDAO.get(usuarioIdn);
		TbAdmPermisos permiso = tbAdmPermisosService.getPermisoListarPermisos();
		TbAdmRolesxpermisos rolPermiso = tbAdmRolesxpermisosService
				.findByForeignKey(usuario.getTbAdmRoles().getNbIdn(),
						permiso.getNbIdn());
		return rolPermiso != null;
	}

}
