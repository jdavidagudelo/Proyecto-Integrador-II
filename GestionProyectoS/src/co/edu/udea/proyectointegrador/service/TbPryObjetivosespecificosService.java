package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryObjetivosespecificosDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.dto.TbPryEstadosactividad;
import co.edu.udea.proyectointegrador.dto.TbPryObjetivosespecificos;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbPryObjetivosespecificosService {
	private TbPryObjetivosespecificosDAO tbPryObjetivosespecificosDAO;
	private TbPryProyectosService tbPryProyectosService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbPryEstadosactividadService tbPryEstadosactividadService;
	private TbPryActividadesService tbPryActividadesService;

	public TbPryActividadesService getTbPryActividadesService() {
		return tbPryActividadesService;
	}

	public void setTbPryActividadesService(
			TbPryActividadesService tbPryActividadesService) {
		this.tbPryActividadesService = tbPryActividadesService;
	}

	public TbPryEstadosactividadService getTbPryEstadosactividadService() {
		return tbPryEstadosactividadService;
	}

	public void setTbPryEstadosactividadService(
			TbPryEstadosactividadService tbPryEstadosactividadService) {
		this.tbPryEstadosactividadService = tbPryEstadosactividadService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbPryObjetivosespecificosDAO getTbPryObjetivosespecificosDAO() {
		return tbPryObjetivosespecificosDAO;
	}

	public void setTbPryObjetivosespecificosDAO(
			TbPryObjetivosespecificosDAO tbPryObjetivosespecificosDAO) {
		this.tbPryObjetivosespecificosDAO = tbPryObjetivosespecificosDAO;
	}

	public TbPryProyectosService getTbPryProyectosService() {
		return tbPryProyectosService;
	}

	public void setTbPryProyectosService(
			TbPryProyectosService tbPryProyectosService) {
		this.tbPryProyectosService = tbPryProyectosService;
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryObjetivosespecificos> findAll() throws DaoException {
		return tbPryObjetivosespecificosDAO.findAll();
	}

	/**
	 * Metodo para obtener el objetivo con el id ingresado como argumento
	 * 
	 * @param id
	 *            id del objetivo especifico
	 * @return objetivo con el id ingresado como argumento
	 * */
	public TbPryObjetivosespecificos get(Integer id) throws DaoException {
		return tbPryObjetivosespecificosDAO.get(id);
	}

	/**
	 * Metodo que permite eliminar un objetivo especifico junto con todas las
	 * actividades asociadas
	 * 
	 * @param nbIdn
	 *            el id del objetivo
	 * @throws DaoException
	 *             en caso de error
	 */
	public void delete(Integer nbIdn) throws DaoException {
		TbPryObjetivosespecificos deleted = tbPryObjetivosespecificosDAO
				.get(nbIdn);
		if (deleted != null) {
			for (TbPryActividades actividad : getActividades(deleted.getNbIdn())) {
				tbPryActividadesService.delete(actividad.getNbIdn());
			}
			tbPryObjetivosespecificosDAO.delete(deleted);
		}
	}

	/**
	 * Metodo para crear un nuevo objetivo especifico
	 * 
	 * @param usuarioCrea
	 *            login del usuario que crea el objetivo
	 * @param descripcion
	 *            la descripcion del objetivo
	 * @param porcentaje
	 *            el porcentaje del objetivo
	 * @param proyectoIdn
	 *            el id del proyecto asociado al objetivo
	 * @return el nuevo objetivo creado
	 * @throws DaoException
	 *             en caso de datos invalidos
	 */
	public TbPryObjetivosespecificos insert(String usuarioCrea,
			String descripcion, Long porcentaje, Integer proyectoIdn)
			throws DaoException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea el objetivo especifico no puede ser nulo vacio");
		}
		if (Validaciones.isTextoVacio(descripcion)) {
			throw new DaoException(
					"La descripcion del objetivo no puede ser nula o vacia");
		}
		if (porcentaje == null) {
			throw new DaoException(
					"El porcentaje del objetivo no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException(
					"El codigo del proyecto asociado con el objetivo no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto ingresado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea el objetivo no existe en la base de datos");
		}
		TbPryObjetivosespecificos inserted = new TbPryObjetivosespecificos();
		inserted.setDtAdtfecha(new Date());
		inserted.setNbPorcentajesobreproyecto(porcentaje);
		inserted.setTbPryProyectos(proyecto);
		inserted.setVrAdtusuario(usuarioCrea);
		inserted.setVrDescripcion(descripcion);
		return tbPryObjetivosespecificosDAO.save(inserted);
	}

	/**
	 * Metodo para obtener las actividades asociadas a un objetivo.
	 * 
	 * @param objetivoIdn
	 *            el id del objetivo
	 * @return lista de actividades asociadas al objetivo especificado
	 * @throws DaoException
	 *             error en los parametros
	 */
	public List<TbPryActividades> getActividades(Integer objetivoIdn)
			throws DaoException {
		if (objetivoIdn == null) {
			throw new DaoException("El codigo del objetivo no puede ser nulo");
		}
		TbPryObjetivosespecificos objetivo = tbPryObjetivosespecificosDAO
				.get(objetivoIdn);
		if (objetivo == null) {
			throw new DaoException("El objetivo no existe en la base de datos");
		}
		return tbPryActividadesService.findActividadesByObjetivo(objetivoIdn);
	}

	/**
	 * Metodo para obtener los objetivos especificos del proyecto ingresado como
	 * argumento
	 * 
	 * @param proyectoIdn
	 *            el id del proyecto
	 * @return los objetivos especificos del proyecto ingresado como argumento
	 * @throws DaoException
	 */
	public List<TbPryObjetivosespecificos> findByProyecto(Integer proyectoIdn)
			throws DaoException {
		return tbPryObjetivosespecificosDAO.findByProyecto(proyectoIdn);
	}

	/**
	 * Metodo que permite obtener el porcentaje acumulado de todas las
	 * actividades asociadas al objetivo especifico ingresado como argumento
	 * 
	 * @param objetivoIdn
	 *            id del objetivo especifico
	 * @return el porcentaje acumulado de las actividades asociadas al objetivo
	 *         especificado ingresado como argumento
	 * @throws DaoException
	 */
	public Long getPorcentaje(Integer objetivoIdn) throws DaoException {
		TbPryEstadosactividad estadoActividadCancelado = tbPryEstadosactividadService
				.getEstadoCancelado();
		return tbPryObjetivosespecificosDAO.getPorcentaje(objetivoIdn,
				estadoActividadCancelado.getNbIdn());
	}
}
