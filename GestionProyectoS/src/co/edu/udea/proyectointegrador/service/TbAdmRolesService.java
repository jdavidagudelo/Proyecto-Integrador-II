package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbAdmRolesDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmRoles;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.properties.Properties;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

public class TbAdmRolesService {
	private TbAdmRolesDAO tbAdmRolesDAO;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private static final Properties properties = Properties.getInstance();
	
	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbAdmRolesDAO getTbAdmRolesDAO() {
		return tbAdmRolesDAO;
	}

	public void setTbAdmRolesDAO(TbAdmRolesDAO tbAdmRolesDAO) {
		this.tbAdmRolesDAO = tbAdmRolesDAO;
	}

	/**
	 * Metodo que permite obtener el rol con el id ingresado como argumento.
	 * 
	 * @param id
	 *            el id del rol
	 * @return el rol con el id ingresado como argumento
	 * @throws DaoException
	 */
	public TbAdmRoles get(Integer id) throws DaoException {
		if (id == null) {
			throw new DaoException("El id del rol no puede ser nulo");
		}
		TbAdmRoles rol = tbAdmRolesDAO.get(id);
		if (rol == null) {
			throw new DaoException("El rol no existe en la base de datosw");
		}
		return rol;
	}

	/**
	 * Permite obtener los roles existentes en la base de datos.
	 * 
	 * @return lista de roles de la base de datos
	 * @throws DaoException
	 */
	public List<TbAdmRoles> findAll() throws DaoException {
		return tbAdmRolesDAO.findAll();
	}
	public TbAdmRoles findRolByNombre(String nombre) throws DaoException
	{
		return tbAdmRolesDAO.findRolByNombre(nombre);
	}
	public TbAdmRoles getRolAsesor() throws DaoException
	{
		return tbAdmRolesDAO.findRolByNombre(properties.getRolAsesor());
	}
	public TbAdmRoles getRolParticipante() throws DaoException
	{
		return tbAdmRolesDAO.findRolByNombre(properties.getRolParticipante());
	}
	public TbAdmRoles getRolResponsable() throws DaoException
	{
		return tbAdmRolesDAO.findRolByNombre(properties.getRolResponsable());
	}
	public TbAdmRoles getRolSuperUsuario() throws DaoException
	{
		return tbAdmRolesDAO.findRolByNombre(properties.getRolSuperUsuario());
	}
	/**
	 * Metodo que permite insertar un nuevo rol en la base de datos.
	 * 
	 * @param usuarioCrea
	 *            login del usuario que crea el rol
	 * @param nombre
	 *            el nombre del rol
	 * @param descripcion
	 *            la descripcion del rol
	 * @return el nuevo rol
	 * @throws DaoException
	 */
	public TbAdmRoles insert(String usuarioCrea, String nombre,
			String descripcion) throws DaoException {
		if (Validaciones.isTextoVacio(descripcion)) {
			throw new DaoException("La descripcion no puede ser nula o vacia");
		}
		if (Validaciones.isTextoVacio(nombre)) {
			throw new DaoException("El nombre no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException("El usuario no puede ser nulo");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException("El usuario no existe en la base de datos");
		}
		TbAdmRoles rol = new TbAdmRoles();
		rol.setVrNombre(nombre);
		rol.setVrAdtusuario(usuarioCrea);
		rol.setVrDescripcion(descripcion);
		rol.setDtAdtfecha(new Date());
		return tbAdmRolesDAO.save(rol);
	}
	
}
