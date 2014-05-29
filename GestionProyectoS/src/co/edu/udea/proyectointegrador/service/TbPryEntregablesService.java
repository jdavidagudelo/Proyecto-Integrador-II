package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryEntregablesDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.dto.TbPryEntregables;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * Clase utilizada para acceder a la tabla de entregables de la base de datos.
 * 
 * @author juan
 * 
 */
public class TbPryEntregablesService {
	private TbPryEntregablesDAO tbPryEntregablesDAO;
	private TbPryActividadesService tbPryActividadesService;
	private TbAdmUsuariosService tbAdmUsuariosService;

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbPryActividadesService getTbPryActividadesService() {
		return tbPryActividadesService;
	}

	public void setTbPryActividadesService(
			TbPryActividadesService tbPryActividadesService) {
		this.tbPryActividadesService = tbPryActividadesService;
	}

	public TbPryEntregablesDAO getTbPryEntregablesDAO() {
		return tbPryEntregablesDAO;
	}

	public void setTbPryEntregablesDAO(TbPryEntregablesDAO tbPryEntregablesDAO) {
		this.tbPryEntregablesDAO = tbPryEntregablesDAO;
	}

	/**
	 * Permite insertar un nuevo entregable en la base de datos
	 * 
	 * @param usuarioCrea
	 *            el login del usuario que crea el entregable
	 * @param nombre
	 *            el nombre del entregable
	 * @param comentarioParticipante
	 *            el comentario del participante
	 * @param archivoAdjunto
	 *            archivo asociado con el entregable
	 * @param actividadIdn
	 *            el id de la actividad asociada al entregable
	 * @return el entregable creado
	 * @throws DaoException
	 *             error
	 */
	public TbPryEntregables insert(String usuarioCrea, String nombre,
			String comentarioParticipante, byte[] archivoAdjunto,
			Integer actividadIdn) throws DaoException {
		if (Validaciones.isTextoVacio(nombre)) {
			throw new DaoException(
					"El nombre del entregable no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea el entregable no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(comentarioParticipante)) {
			throw new DaoException(
					"El comentario del entregable no puede ser nulo o vacio");
		}
		if (archivoAdjunto == null || archivoAdjunto.length == 0) {
			throw new DaoException(
					"El archivo adjunto no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"La actividad asociada con el entregable no puede ser nula");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException(
					"La actividad ingresada no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea el entregable no existe en la base de datos");
		}
		TbPryEntregables entregable = new TbPryEntregables();
		entregable.setBlobAdjunto(archivoAdjunto);
		entregable.setVrNombre(nombre);
		entregable.setDtAdtfecha(new Date());
		entregable.setTbPryActividades(actividad);
		entregable.setVrAdtusuario(usuarioCrea);
		entregable.setVrComentarioparticipante(comentarioParticipante);
		return tbPryEntregablesDAO.save(entregable);
	}

	/**
	 * Metodo que permite obtener los entregables asociados a una actividad
	 * 
	 * @param actividadIdn
	 *            id de la actividad
	 * @return entregables asociados a la actividad ingresada como argumento
	 * @throws DaoException
	 */
	public List<TbPryEntregables> findByActividad(Integer actividadIdn)
			throws DaoException {
		return tbPryEntregablesDAO.findByActividad(actividadIdn);
	}

	/**
	 * Metodo que permite obtener un entregable con el id ingresado
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbPryEntregables get(Integer id) throws DaoException {
		if (id == null) {
			throw new DaoException("El id del entregable no puede ser nulo");
		}
		TbPryEntregables entregable = tbPryEntregablesDAO.get(id);
		if (entregable == null) {
			throw new DaoException(
					"El entregable no existe en la base de datos");
		}
		return entregable;
	}

	/**
	 * Metodo que permite realizar seguimiento a un entregable de un proyecto.
	 * 
	 * @param usuarioModifica
	 *            login del usuario que realiza el seguimiento del entregable.
	 * @param comentarioProfesor
	 *            comentario del asesor del proyecto.
	 * @param entregableIdn
	 *            id del entregable al que se hace seguimiento
	 * @return entregable actualizado
	 * */
	public TbPryEntregables realizarSeguimiento(String usuarioModifica,
			String comentarioProfesor, Integer entregableIdn)
			throws DaoException {
		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que modifica la actividad no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(comentarioProfesor)) {
			throw new DaoException(
					"El comentario del profesor no puede ser nulo o vacio");
		}
		if (entregableIdn == null) {
			throw new DaoException("El entregable no puede ser nulo");
		}
		TbPryEntregables entregable = tbPryEntregablesDAO.get(entregableIdn);
		if (entregable == null) {
			throw new DaoException(
					"El entregable no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que modifica el entregable no existe en la base de datos");
		}
		entregable.setDtAdtfecha(new Date());
		entregable.setVrComentarioprofesor(comentarioProfesor);
		entregable.setVrAdtusuario(usuarioModifica);
		return tbPryEntregablesDAO.update(entregable);
	}

	/**
	 * Permite eliminar un entregable de la base de datos
	 * 
	 * @param nbIdn
	 *            el id del entregable
	 * */
	public void delete(Integer nbIdn) throws DaoException {
		TbPryEntregables deleted = tbPryEntregablesDAO.get(nbIdn);
		if (deleted != null) {
			tbPryEntregablesDAO.delete(deleted);
		}
	}
}
