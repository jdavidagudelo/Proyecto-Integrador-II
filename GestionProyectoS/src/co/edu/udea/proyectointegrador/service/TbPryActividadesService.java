package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryActividadesDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.dto.TbPryActividadesxactividades;
import co.edu.udea.proyectointegrador.dto.TbPryEntregables;
import co.edu.udea.proyectointegrador.dto.TbPryEstadosactividad;
import co.edu.udea.proyectointegrador.dto.TbPryObjetivosespecificos;
import co.edu.udea.proyectointegrador.dto.TbPryParticipantexactividad;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbPryActividadesService {
	private TbPryActividadesDAO tbPryActividadesDAO;
	private TbPryObjetivosespecificosService tbPryObjetivosespecificosService;
	private TbPryEstadosactividadService tbPryEstadosactividadService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbNtfNtfsxusuarioService tbNtfNtfsxusuarioService;
	private TbPryParticipantexactividadService tbPryParticipantexactividadService;
	private TbPryEntregablesService tbPryEntregablesService;
	private TbPryActividadesxactividadesService tbPryActividadesxactividadesService;
	private TbPryProyectosService tbPryProyectosService;

	public TbPryProyectosService getTbPryProyectosService() {
		return tbPryProyectosService;
	}

	public void setTbPryProyectosService(
			TbPryProyectosService tbPryProyectosService) {
		this.tbPryProyectosService = tbPryProyectosService;
	}

	public TbPryActividadesxactividadesService getTbPryActividadesxactividadesService() {
		return tbPryActividadesxactividadesService;
	}

	public void setTbPryActividadesxactividadesService(
			TbPryActividadesxactividadesService tbPryActividadesxactividadesService) {
		this.tbPryActividadesxactividadesService = tbPryActividadesxactividadesService;
	}

	public TbPryParticipantexactividadService getTbPryParticipantexactividadService() {
		return tbPryParticipantexactividadService;
	}

	public void setTbPryParticipantexactividadService(
			TbPryParticipantexactividadService tbPryParticipantexactividadService) {
		this.tbPryParticipantexactividadService = tbPryParticipantexactividadService;
	}

	public TbPryEntregablesService getTbPryEntregablesService() {
		return tbPryEntregablesService;
	}

	public void setTbPryEntregablesService(
			TbPryEntregablesService tbPryEntregablesService) {
		this.tbPryEntregablesService = tbPryEntregablesService;
	}

	public TbNtfNtfsxusuarioService getTbNtfNtfsxusuarioService() {
		return tbNtfNtfsxusuarioService;
	}

	public void setTbNtfNtfsxusuarioService(
			TbNtfNtfsxusuarioService tbNtfNtfsxusuarioService) {
		this.tbNtfNtfsxusuarioService = tbNtfNtfsxusuarioService;
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

	public TbPryActividadesDAO getTbPryActividadesDAO() {
		return tbPryActividadesDAO;
	}

	public void setTbPryActividadesDAO(TbPryActividadesDAO tbPryActividadesDAO) {
		this.tbPryActividadesDAO = tbPryActividadesDAO;
	}

	public TbPryObjetivosespecificosService getTbPryObjetivosespecificosService() {
		return tbPryObjetivosespecificosService;
	}

	public void setTbPryObjetivosespecificosService(
			TbPryObjetivosespecificosService tbPryObjetivosespecificosService) {
		this.tbPryObjetivosespecificosService = tbPryObjetivosespecificosService;
	}

	/**
	 * Metodo para obtener una actividad de la base de datos
	 * 
	 * @param id
	 *            id de la actividad
	 * @return actividad con el codigo ingresado como argumento
	 * @throws DaoException
	 *             si no es valido
	 * */
	public TbPryActividades get(Integer id) throws DaoException {
		if (id == null) {
			throw new DaoException("El id no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesDAO.get(id);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		return actividad;
	}

	/**
	 * Metodo que permite obtener todas las actividades del proyecto ingresado.
	 * 
	 * @param proyectoIdn
	 *            el id del proyecto
	 * @return las actividades del proyecto ingresado como argumento.
	 * */
	public List<TbPryActividades> findActividadesByProyecto(Integer proyectoIdn)
			throws DaoException {
		if (proyectoIdn == null) {
			throw new DaoException(
					"El codigo del proyecto no puede ser nulo o vacio");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException("El proyecto no existe en la base de datos");
		}
		return tbPryActividadesDAO.findActividadesByProyecto(proyectoIdn);
	}

	/**
	 * Metodo usado para obtener las actividades de un proyecto en un estado
	 * especifico.
	 * 
	 * @param estadoIdn
	 *            el estado de las actividades que se desean obtener
	 * @param proyectoIdn
	 *            el proyecto para el cual se desean obtener las actividades
	 * */
	public List<TbPryActividades> findActividadesByEstado(Integer estadoIdn,
			Integer proyectoIdn) throws DaoException {
		if (estadoIdn == null) {
			throw new DaoException(
					"El estado de la actividad no puede ser nulo o vacio");
		}
		TbPryEstadosactividad estado = tbPryEstadosactividadService
				.get(estadoIdn);
		if (estado == null) {
			throw new DaoException(
					"EL estado de la actividad no existe en la base de datos");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException("Proyecto no existe en base de datos");
		}
		return tbPryActividadesDAO.findActividadesByEstado(estadoIdn,
				proyectoIdn);
	}

	/**
	 * Metodo que permite actualizar una actividad existente
	 * 
	 * @param usuarioModifica
	 *            el login del usuario que modifica la actividad
	 * @param nombre
	 *            el nuevo nombre del proyecto
	 * @param fechaInicial
	 *            la nueva fecha inicial del proyecto
	 * @param fechaFinal
	 *            la nueva fecha final del proyecto
	 * @param objetivoIdn
	 *            el id del nuevo objetivo especifico asociado a la actividad
	 * @param porcentaje
	 *            el nuevo porcentaje de la actividad con respecto al objetivo
	 *            especifico
	 * @param descripcion
	 *            la nueva descripcion de la actividad
	 * @param actividadIdn
	 *            el id de la actividad que se desea modificar
	 * @return la actividad modificada
	 * */
	public TbPryActividades update(String usuarioModifica, String nombre,
			Date fechaInicial, Date fechaFinal, Integer objetivoIdn,
			Long porcentaje, String descripcion, Integer actividadIdn)
			throws DaoException {
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad modificada no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesDAO.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException(
					"La actividad ingresada no existe en la base datos");
		}
		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que modifica la actividad no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(nombre)) {
			throw new DaoException(
					"El nombre de la actividad no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(descripcion)) {
			throw new DaoException(
					"La descripcion de la actividad no puede ser nula o vacia");
		}
		if (porcentaje == null) {
			throw new DaoException(
					"El porcentaje de la actividad no puede ser nulo");
		}
		if (objetivoIdn == null) {
			throw new DaoException("El codigo del objetivo no puede ser nulo");
		}
		Date current = actividad.getDtFechacreacion();
		if (fechaInicial.compareTo(current) <= 0) {
			throw new DaoException(
					"La fecha inicial debe ser mayor a la fecha de creación de la actividad");
		}
		if (fechaFinal.compareTo(fechaInicial) <= 0) {
			throw new DaoException(
					"La fecha final debe ser mayor a la fecha inicial de la actividad");
		}
		TbPryObjetivosespecificos objetivo = tbPryObjetivosespecificosService
				.get(objetivoIdn);
		if (objetivo == null) {
			throw new DaoException(
					"El objetivo especifico no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea la actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = objetivo.getTbPryProyectos();
		if (fechaInicial.compareTo(proyecto.getDtFechainicial()) < 0) {
			throw new DaoException(
					"La fecha inicial de la actividad debe ser mayor a la fecha inicial del proyecto");
		}
		if (fechaFinal.compareTo(proyecto.getDtFechafinal()) > 0) {
			throw new DaoException(
					"La fecha final de la actividad debe ser menor o igual a la fecha final del proyecto");
		}
		if (!tbPryProyectosService.isEditable(proyecto.getNbIdn())) {
			throw new DaoException(
					"No se pueden modificar las actividades de un proyecto cancelado, suspendido, vencido o finalizado");
		}
		actividad.setDtAdtfecha(new Date());
		actividad.setDtFechafinal(fechaFinal);
		actividad.setDtFechainicial(fechaInicial);
		actividad.setNbPorcentajesobreactividad(porcentaje);
		actividad.setTbPryObjetivosespecificos(objetivo);
		actividad.setVrAdtusuario(usuarioModifica);
		actividad.setVrDescripcionactividad(descripcion);
		actividad.setVrNombreactividad(nombre);
		actividad = tbPryActividadesDAO.update(actividad);
		return actividad;
	}

	/**
	 * Metodo que permite crear una nueva actividad
	 * 
	 * @param usuarioModifica
	 *            el login del usuario que modifica la actividad
	 * @param nombre
	 *            el nuevo nombre del proyecto
	 * @param fechaInicial
	 *            la nueva fecha inicial del proyecto
	 * @param fechaFinal
	 *            la nueva fecha final del proyecto
	 * @param objetivoIdn
	 *            el id del nuevo objetivo especifico asociado a la actividad
	 * @param porcentaje
	 *            el nuevo porcentaje de la actividad con respecto al objetivo
	 *            especifico
	 * @param descripcion
	 *            la nueva descripcion de la actividad
	 * @return la actividad creada
	 * */
	public TbPryActividades insert(String usuarioCrea, String nombre,
			Date fechaInicial, Date fechaFinal, Integer objetivoIdn,
			Long porcentaje, String descripcion) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException("El usuario no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(nombre)) {
			throw new DaoException(
					"El nombre de la actividad no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(descripcion)) {
			throw new DaoException(
					"La descripcion de la actividad no puede ser nula o vacia");
		}
		if (porcentaje == null) {
			throw new DaoException(
					"El porcentaje de la actividad no puede ser nulo");
		}
		if (objetivoIdn == null) {
			throw new DaoException("El codigo del objetivo no puede ser nulo");
		}
		Date current = new Date();
		if (fechaInicial.compareTo(current) <= 0) {
			throw new DaoException(
					"La fecha inicial debe ser mayor a la fecha de creación de la actividad");
		}
		if (fechaFinal.compareTo(fechaInicial) <= 0) {
			throw new DaoException(
					"La fecha final debe ser mayor a la fecha inicial de la actividad");
		}
		TbPryObjetivosespecificos objetivo = tbPryObjetivosespecificosService
				.get(objetivoIdn);
		if (objetivo == null) {
			throw new DaoException(
					"El objetivo especifico no existe en la base de datos");
		}
		Long porcentajeActual = tbPryObjetivosespecificosService
				.getPorcentaje(objetivo.getNbIdn());
		if (porcentajeActual == null) {
			porcentajeActual = 0l;
		}
		if (porcentaje > 100l - porcentajeActual) {
			throw new DaoException(
					"El porcentaje de la actividad hace que el porcentaje total del objetivo supere el 100%");
		}
		TbPryProyectos proyecto = objetivo.getTbPryProyectos();
		if (fechaInicial.compareTo(proyecto.getDtFechainicial()) < 0) {
			throw new DaoException(
					"La fecha inicial de la actividad debe ser mayor a la fecha inicial del proyecto");
		}
		if (fechaFinal.compareTo(proyecto.getDtFechafinal()) > 0) {
			throw new DaoException(
					"La fecha final de la actividad debe ser menor o igual a la fecha final del proyecto");
		}
		if (!tbPryProyectosService.isEditable(proyecto.getNbIdn())) {
			throw new DaoException(
					"No se puede insertar una actividad a un proyecto cancelado, suspendido, vencido o finalizado");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea la actividad no existe en la base de datos");
		}
		TbPryEstadosactividad estadoInicial = tbPryEstadosactividadService
				.getEstadoInicialActividad();

		TbPryActividades inserted = new TbPryActividades();
		inserted.setDtAdtfecha(current);
		inserted.setDtFechacreacion(current);
		inserted.setDtFechafinal(fechaFinal);
		inserted.setDtFechainicial(fechaInicial);
		inserted.setNbPorcentajesobreactividad(porcentaje);
		inserted.setTbPryEstadosactividad(estadoInicial);
		inserted.setVrAdtusuario(usuarioCrea);
		inserted.setVrDescripcionactividad(descripcion);
		inserted.setTbPryObjetivosespecificos(objetivo);
		inserted.setVrNombreactividad(nombre);
		inserted = tbPryActividadesDAO.save(inserted);

		return inserted;
	}

	/**
	 * Metodo que permite suspender una actividad.
	 * 
	 * @param usuarioModifica
	 *            login del usuario que suspende la actividad
	 * @param actividadIdn
	 *            el id de la actividad que se desea suspender
	 * @param justificacion
	 *            la justificacion de la suspencion de la actividad
	 * @return la actividad modificada
	 * */
	public TbPryActividades suspenderActividad(String usuarioModifica,
			Integer actividadIdn, String justificacion) throws DaoException {
		{
			if (Validaciones.isTextoVacio(usuarioModifica)) {
				throw new DaoException(
						"El usuario que suspende la actividad no puede ser nulo");
			}
			if (actividadIdn == null) {
				throw new DaoException(
						"El codigo de la actividad no puede ser nulo");
			}
			if (Validaciones.isTextoVacio(justificacion)) {
				throw new DaoException(
						"La justificacion de la suspencion no puede ser nula o vacia");
			}
			TbPryActividades actividad = tbPryActividadesDAO.get(actividadIdn);
			if (actividad == null) {
				throw new DaoException(
						"La actividad no existe en la base de datos");
			}
			TbPryEstadosactividad estadoVencido = tbPryEstadosactividadService
					.getEstadoVencido();
			if (estadoVencido == null) {
				throw new DaoException(
						"El estado vencido no existe en la base de datos");
			}
			if (estadoVencido.getNbIdn().equals(
					actividad.getTbPryEstadosactividad().getNbIdn())) {
				throw new DaoException(
						"No se puede suspender una actividad vencida");
			}
			TbPryEstadosactividad estadoFinalizado = tbPryEstadosactividadService
					.getEstadoVerificado();
			if (estadoFinalizado == null) {
				throw new DaoException(
						"El estado verificado no existe en la base de datos");
			}
			if (estadoFinalizado.getNbIdn().equals(
					actividad.getTbPryEstadosactividad().getNbIdn())) {
				throw new DaoException(
						"No se puede suspender una actividad finalizada");
			}
			TbPryEstadosactividad estadoCancelado = tbPryEstadosactividadService
					.getEstadoCancelado();
			if (estadoCancelado.getNbIdn().equals(
					actividad.getTbPryEstadosactividad().getNbIdn())) {
				return actividad;
			}
			TbPryEstadosactividad estado = tbPryEstadosactividadService
					.getEstadoSuspendido();
			if (estado == null) {
				throw new DaoException(
						"El estado suspendido no existe en la base de datos");
			}
			TbPryProyectos proyecto = actividad.getTbPryObjetivosespecificos()
					.getTbPryProyectos();

			if (!tbPryProyectosService.isEditable(proyecto.getNbIdn())) {
				throw new DaoException(
						"No se puede suspender una actividad de un proyecto cancelado, suspendido, vencido o finalizado");
			}
			TbAdmUsuarios usuario = tbAdmUsuariosService
					.findUsuarioByLogin(usuarioModifica);
			if (usuario == null) {
				throw new DaoException(
						"El usuario que suspende el proyecto no existe en la base de datos");
			}
			actividad.setDtAdtfecha(new Date());
			actividad.setVrAdtusuario(usuarioModifica);
			actividad.setVrJustificacionsuspencion(justificacion);
			actividad.setTbPryEstadosactividad(estado);
			return tbPryActividadesDAO.update(actividad);
		}
	}

	/**
	 * Metodo que permite cancelar una actividad
	 * 
	 * @param usuarioModifica
	 *            login del usuario que cancela la actividad
	 * @param actividadIdn
	 *            id de la actividad que se desea cancelar
	 * @param justificacion
	 *            la justificacion de la cancelacion de la actividad
	 * @return la actividad actualizada
	 * */
	public TbPryActividades cancelarActividad(String usuarioModifica,
			Integer actividadIdn, String justificacion) throws DaoException {
		{
			if (Validaciones.isTextoVacio(usuarioModifica)) {
				throw new DaoException(
						"El usuario que suspende la actividad no puede ser nulo");
			}
			if (actividadIdn == null) {
				throw new DaoException(
						"El codigo de la actividad no puede ser nulo");
			}
			if (Validaciones.isTextoVacio(justificacion)) {
				throw new DaoException(
						"La justificacion de la cancelacion no puede ser nula o vacia");
			}
			TbPryActividades actividad = tbPryActividadesDAO.get(actividadIdn);
			if (actividad == null) {
				throw new DaoException(
						"La actividad no existe en la base de datos");
			}
			TbPryEstadosactividad estado = tbPryEstadosactividadService
					.getEstadoCancelado();
			if (estado == null) {
				throw new DaoException(
						"El estado cancelado no existe en la base de datos");
			}
			TbPryProyectos proyecto = actividad.getTbPryObjetivosespecificos()
					.getTbPryProyectos();

			if (!tbPryProyectosService.isEditable(proyecto.getNbIdn())) {
				throw new DaoException(
						"No se puede cancelar una actividad a un proyecto cancelado, suspendido, vencido o finalizado");
			}
			TbAdmUsuarios usuario = tbAdmUsuariosService
					.findUsuarioByLogin(usuarioModifica);
			if (usuario == null) {
				throw new DaoException(
						"El usuario que cancela el proyecto no existe en la base de datos");
			}
			actividad.setDtAdtfecha(new Date());
			actividad.setVrAdtusuario(usuarioModifica);
			actividad.setVrJustificacioncancelacion(justificacion);
			actividad.setTbPryEstadosactividad(estado);
			actividad = tbPryActividadesDAO.update(actividad);
			return actividad;
		}
	}

	/**
	 * Metodo que permite reanudar una actividad
	 * 
	 * @param usuarioModifica
	 *            el login del usuario que reanuda la actividad
	 * @param fechaInicial
	 *            la nueva fecha inicial de la actividad
	 * @param fechaFinal
	 *            la nueva fecha final de la actividad
	 * @param actividadIdn
	 *            el id de la actividad que se desea reanudar
	 * */
	public TbPryActividades reanudarActividad(String usuarioModifica,
			Date fechaInicial, Date fechaFinal, Integer actividadIdn)
			throws DaoException {
		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que finaliza el proyecto no puede ser nulo");
		}
		Date current = new Date();
		if (fechaInicial.compareTo(current) <= 0) {
			throw new DaoException(
					"La fecha inicial debe ser mayor a la fecha de creación de la actividad");
		}
		if (fechaFinal.compareTo(fechaInicial) <= 0) {
			throw new DaoException(
					"La fecha final debe ser mayor a la fecha final de la actividad");
		}

		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea la actividad no existe en la base de datos");
		}
		TbPryActividades actividad = tbPryActividadesDAO.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryObjetivosespecificos objetivo = actividad
				.getTbPryObjetivosespecificos();
		if (objetivo == null) {
			throw new DaoException(
					"El objetivo especifico no existe en la base de datos");
		}
		TbPryProyectos proyecto = objetivo.getTbPryProyectos();
		if (fechaInicial.compareTo(proyecto.getDtFechainicial()) < 0) {
			throw new DaoException(
					"La fecha inicial de la actividad debe ser mayor a la fecha inicial del proyecto");
		}
		if (fechaFinal.compareTo(proyecto.getDtFechafinal()) > 0) {
			throw new DaoException(
					"La fecha final de la actividad debe ser menor o igual a la fecha final del proyecto");
		}

		if (!tbPryProyectosService.isEditable(proyecto.getNbIdn())) {
			throw new DaoException(
					"No se puede reanudar una actividad a un proyecto cancelado, suspendido, vencido o finalizado");
		}
		TbPryEstadosactividad estadoFinalizado = tbPryEstadosactividadService
				.getEstadoVerificado();
		TbPryEstadosactividad estadoCancelado = tbPryEstadosactividadService
				.getEstadoCancelado();
		if (estadoFinalizado.getNbIdn().equals(
				actividad.getTbPryEstadosactividad().getNbIdn())) {
			throw new DaoException(
					"No se puede reanudar una actividad finalizada");
		}
		if (estadoCancelado.getNbIdn().equals(
				actividad.getTbPryEstadosactividad().getNbIdn())) {
			throw new DaoException(
					"No se puede reanudar una actividad cancelada");
		}
		TbPryEstadosactividad estado = tbPryEstadosactividadService
				.getEstadoReanudado();
		if (estado == null) {
			throw new DaoException(
					"El estado reanudado no existe en la base de datos");
		}
		actividad.setDtAdtfecha(current);
		actividad.setDtFechafinal(fechaFinal);
		actividad.setDtFechainicial(fechaInicial);
		actividad.setTbPryEstadosactividad(estado);
		actividad.setVrAdtusuario(usuarioModifica);
		return tbPryActividadesDAO.update(actividad);
	}

	/**
	 * 
	 * @param usuarioModifica
	 * @param comentarioProfesor
	 * @param actividadIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryActividades realizarSeguimiento(String usuarioModifica,
			String comentarioProfesor, Integer actividadIdn)
			throws DaoException {
		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que modifica la actividad no puede ser nulo o vacio");
		}
		if (Validaciones.isTextoVacio(comentarioProfesor)) {
			throw new DaoException(
					"El comentario del profesor no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException("La actividad no puede ser nula");
		}
		TbPryActividades actividad = tbPryActividadesDAO.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException(
					"La actividad especificada no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que modifica la actividad existe en la base de datos");
		}
		TbPryEstadosactividad estadoFinalizado = tbPryEstadosactividadService
				.getEstadoVerificado();
		actividad.setVrAdtusuario(usuarioModifica);
		actividad.setDtAdtfecha(new Date());
		actividad.setTbPryEstadosactividad(estadoFinalizado);
		return tbPryActividadesDAO.update(actividad);
	}

	/**
	 * Metodo que permite verificar la realizacion exitosa de una actividad
	 * 
	 * @param usuarioModifica
	 *            login del usuario que verifica la actividad
	 * @param actividadIdn
	 *            id de la actividad que se verifica
	 * @return actividad actualizada
	 * */
	public TbPryActividades verificarActividad(String usuarioModifica,
			Integer actividadIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que modifica la actividad no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesDAO.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException(
					"La actividad especificada no existe en la base de datos");
		}
		TbPryEstadosactividad estado = actividad.getTbPryEstadosactividad();
		TbPryEstadosactividad estadoEnProceso = tbPryEstadosactividadService
				.getEstadoEnProceso();
		if (estadoEnProceso == null) {
			throw new DaoException(
					"El estado en proceso no existe en la base de datos");
		}
		TbPryEstadosactividad estadoVencido = tbPryEstadosactividadService
				.getEstadoVencido();
		if (estadoVencido == null) {
			throw new DaoException(
					"El estado vencido no existe en la base de datos");
		}
		if (!estadoEnProceso.getNbIdn().equals(estado.getNbIdn())
				&& !estadoVencido.getNbIdn().equals(estado.getNbIdn())) {
			throw new DaoException(
					"Solo se pueden verificar actividades en proceso o vencidas");
		}
		TbPryProyectos proyecto = actividad.getTbPryObjetivosespecificos()
				.getTbPryProyectos();

		if (!tbPryProyectosService.isEditable(proyecto.getNbIdn())) {
			throw new DaoException(
					"No se puede verificar una actividad a un proyecto cancelado, suspendido, vencido o finalizado");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que modifica la actividad existe en la base de datos");
		}
		estado = tbPryEstadosactividadService.getEstadoVerificado();
		actividad.setTbPryEstadosactividad(estado);
		actividad.setVrAdtusuario(usuarioModifica);
		actividad.setDtAdtfecha(new Date());
		return tbPryActividadesDAO.update(actividad);
	}

	/**
	 * Método que permite actualizar los estados de las actividades de acuerdo
	 * con la fecha actual, para establecer actividades vencidas o en proceso.
	 * 
	 * @param usuarioModifica
	 *            el usuario que modifica las actividades
	 * @param proyectoIdn
	 *            el id del proyecto
	 * */
	public void updateEstadoActividades(String usuarioModifica,
			Integer proyectoIdn) throws DaoException {
		TbPryEstadosactividad estadoAbierto = tbPryEstadosactividadService
				.getEstadoAbierto();
		TbPryEstadosactividad estadoReanudado = tbPryEstadosactividadService
				.getEstadoReanudado();
		TbPryEstadosactividad estadoEnProceso = tbPryEstadosactividadService
				.getEstadoEnProceso();
		TbPryEstadosactividad estadoVencido = tbPryEstadosactividadService
				.getEstadoVencido();
		List<TbPryActividades> actividadesVencidas = tbPryActividadesDAO
				.findActividadesVencidas(estadoEnProceso.getNbIdn());
		List<TbPryActividades> actividadesEnProceso = tbPryActividadesDAO
				.findActividadesEnProceso(estadoAbierto.getNbIdn(),
						estadoReanudado.getNbIdn());
		for (TbPryActividades actividad : actividadesVencidas) {
			actividad.setTbPryEstadosactividad(estadoVencido);
			tbPryActividadesDAO.update(actividad);
			tbNtfNtfsxusuarioService.notificarVencimientoActividad(
					usuarioModifica, proyectoIdn, actividad.getNbIdn());
		}
		for (TbPryActividades actividad : actividadesEnProceso) {
			actividad.setTbPryEstadosactividad(estadoEnProceso);
			tbPryActividadesDAO.update(actividad);
		}
	}

	/**
	 * Método usado para eliminar una actividad junto con todos sus objetivos.
	 * 
	 * @param actividadIdn
	 *            el id de la actividad
	 * */
	public void delete(Integer actividadIdn) throws DaoException {
		TbPryActividades deleted = tbPryActividadesDAO.get(actividadIdn);
		if (deleted != null) {
			for (TbPryParticipantexactividad participante : tbPryParticipantexactividadService
					.findByActividad(actividadIdn)) {
				tbPryParticipantexactividadService.delete(participante
						.getNbIdn());
			}
			for (TbPryEntregables entregable : tbPryEntregablesService
					.findByActividad(actividadIdn)) {
				tbPryEntregablesService.delete(entregable.getNbIdn());
			}
			for (TbPryActividadesxactividades actividad : tbPryActividadesxactividadesService
					.findActividadesPrevias(actividadIdn)) {
				tbPryActividadesxactividadesService.delete(
						actividad.getNbIdn(), actividadIdn);
			}
			tbPryActividadesDAO.delete(deleted);
		}
	}

	/**
	 * Metodo que permite obtener las actividades abiertas, en proceso o
	 * reanudadas de un proyecto.
	 * 
	 * @param proyectoIdn
	 *            el id del proyecto
	 * @return lista de actividades abiertas, en proceso o reanudadas de un
	 *         proyecto.
	 * */
	public List<TbPryActividades> findActividadesActivas(Integer proyectoIdn)
			throws DaoException {
		TbPryEstadosactividad estadoAbierto = tbPryEstadosactividadService
				.getEstadoAbierto();
		TbPryEstadosactividad estadoEnproceso = tbPryEstadosactividadService
				.getEstadoEnProceso();
		TbPryEstadosactividad estadoReanudado = tbPryEstadosactividadService
				.getEstadoReanudado();
		return tbPryActividadesDAO.findActividadesActivas(proyectoIdn,
				estadoAbierto.getNbIdn(), estadoEnproceso.getNbIdn(),
				estadoReanudado.getNbIdn());
	}

	/**
	 * Metodo que permite obtener las actividades que ya fueron realizadas o
	 * seran realizadas.
	 * 
	 * @param proyectoIdn
	 *            el id del proyecto
	 * @return las actividades no canceladas o suspendidas de un proyecto
	 * */
	public List<TbPryActividades> findActividadesRealizadas(Integer proyectoIdn)
			throws DaoException {
		TbPryEstadosactividad estadoCancelado = tbPryEstadosactividadService
				.getEstadoCancelado();
		TbPryEstadosactividad estadoSuspendido = tbPryEstadosactividadService
				.getEstadoSuspendido();
		return tbPryActividadesDAO.findActividadesRealizadas(proyectoIdn,
				estadoCancelado.getNbIdn(), estadoSuspendido.getNbIdn());
	}

	/**
	 * Metodo que permite obtener las actividades asociadas con el objetivo
	 * ingresado como argumento
	 * 
	 * @param objetivoIdn
	 *            el id del objetivo
	 * @return lista de actividades asociadas con el objetivo ingresado como
	 *         argumento
	 * */
	public List<TbPryActividades> findActividadesByObjetivo(Integer objetivoIdn)
			throws DaoException {
		return tbPryActividadesDAO.findActividadesByObjetivo(objetivoIdn);
	}

}
