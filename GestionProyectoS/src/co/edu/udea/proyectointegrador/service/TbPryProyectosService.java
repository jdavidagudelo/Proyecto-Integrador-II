package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import co.edu.udea.proyectointegrador.dao.TbPryProyectosDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmRoles;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.dto.TbPryEstados;
import co.edu.udea.proyectointegrador.dto.TbPryEstadosactividad;
import co.edu.udea.proyectointegrador.dto.TbPryModalidades;
import co.edu.udea.proyectointegrador.dto.TbPryObjetivosespecificos;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.dto.TbPryTiposproyecto;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * Clase usada para implementar la logica del negocio asociada con la tabla de
 * proyectos de la base de datos.
 * 
 * @author juan
 * 
 */
public class TbPryProyectosService {
	private static final Logger logger = Logger.getLogger(TbPryProyectosService.class);
	private TbPryProyectosDAO tbPryProyectosDAO;
	private TbPryEstadosService tbPryEstadosService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbPryTiposProyectoService tbPryTiposProyectoService;
	private TbPryModalidadesService tbPryModalidadesService;
	private TbPryActividadesService tbPryActividadesService;
	private TbPryObjetivosespecificosService tbPryObjetivosespecificosService;
	private TbPryEstadosactividadService tbPryEstadosactividadService;
	private TbNtfNtfsxusuarioService tbNtfNtfsxusuarioService;
	private TbAdmRolesService tbAdmRolesService;
	
	public TbAdmRolesService getTbAdmRolesService() {
		return tbAdmRolesService;
	}

	public void setTbAdmRolesService(TbAdmRolesService tbAdmRolesService) {
		this.tbAdmRolesService = tbAdmRolesService;
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

	public TbPryEstadosService getTbPryEstadosService() {
		return tbPryEstadosService;
	}

	public TbPryActividadesService getTbPryActividadesService() {
		return tbPryActividadesService;
	}

	public TbPryObjetivosespecificosService getTbPryObjetivosespecificosService() {
		return tbPryObjetivosespecificosService;
	}

	public void setTbPryObjetivosespecificosService(
			TbPryObjetivosespecificosService tbPryObjetivosespecificosService) {
		this.tbPryObjetivosespecificosService = tbPryObjetivosespecificosService;
	}

	public void setTbPryActividadesService(
			TbPryActividadesService tbPryActividadesService) {
		this.tbPryActividadesService = tbPryActividadesService;
	}

	public List<TbPryProyectos> findAll() throws DaoException {
		return tbPryProyectosDAO.findAll();
	}

	public void setTbPryEstadosService(TbPryEstadosService tbPryEstadosService) {
		this.tbPryEstadosService = tbPryEstadosService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbPryTiposProyectoService getTbPryTiposProyectoService() {
		return tbPryTiposProyectoService;
	}

	public void setTbPryTiposProyectoService(
			TbPryTiposProyectoService tbPryTiposProyectoService) {
		this.tbPryTiposProyectoService = tbPryTiposProyectoService;
	}

	public TbPryModalidadesService getTbPryModalidadesService() {
		return tbPryModalidadesService;
	}

	public void setTbPryModalidadesService(
			TbPryModalidadesService tbPryModalidadesService) {
		this.tbPryModalidadesService = tbPryModalidadesService;
	}

	public TbPryProyectosDAO getTbPryProyectosDAO() {
		return tbPryProyectosDAO;
	}

	public void setTbPryProyectosDAO(TbPryProyectosDAO tbPryProyectosDAO) {
		this.tbPryProyectosDAO = tbPryProyectosDAO;
	}

	/**
	 * Metodo que permite obtener el proyecto con el ID ingresado como
	 * argumento.
	 * 
	 * @author juan
	 * @param id
	 *            el identificador unico de un proyecto en la base de datos.
	 * @return proyecto con el id ingresado como argumento
	 * @throws DaoException
	 *             en caso de que el id sea nulo o no exista en la base de
	 *             datos.
	 * */
	public TbPryProyectos get(Integer id) throws DaoException {
		if (id == null) {
			throw new DaoException("El id del proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosDAO.get(id);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto con el id especificado no existe en la base de datos");
		}
		return proyecto;
	}

	/**
	 * Metodo usado para comprobar que las fechas del proyecto incluyan las
	 * fechas de las actividades asociadas.
	 * 
	 * @param fechaInicial
	 *            la fecha inicial del proyecto
	 * @param fechaFinal
	 *            la fecha final del proyecto
	 * @param proyectoIdn
	 *            el id del proyecto para el que se desea comprobar
	 * @throws DaoException
	 *             si las fechas son invalidas
	 * */
	private void testFechas(Date fechaInicial, Date fechaFinal,
			Integer proyectoIdn) throws DaoException {
		List<TbPryActividades> actividadesActivas = tbPryActividadesService
				.findActividadesActivas(proyectoIdn);
		Date dateMaxima = null;
		Date dateMinima = null;
		for (TbPryActividades actividad : actividadesActivas) {
			if (dateMaxima == null) {
				dateMaxima = actividad.getDtFechafinal();
			} else if (dateMaxima.compareTo(actividad.getDtFechafinal()) < 0) {
				dateMaxima = actividad.getDtFechafinal();
			}
			if (dateMinima == null) {
				dateMinima = actividad.getDtFechainicial();
			} else if (dateMinima.compareTo(actividad.getDtFechainicial()) > 0) {
				dateMinima = actividad.getDtFechainicial();
			}
		}
		if (dateMaxima != null && dateMaxima.compareTo(fechaFinal) > 0) {
			throw new DaoException(
					"La fecha final del proyecto debe ser mayor a la fecha final de todas sus actividades activas actualmente");
		}
		if (dateMinima != null && dateMinima.compareTo(fechaInicial) < 0) {
			throw new DaoException(
					"La fecha inicial del proyecto debe ser menor a la fecha inicial de todas sus actividades activas");
		}
	}

	/**
	 * Metodo que permite actualizar un proyecto de la base de datos.
	 * 
	 * @param usuarioModifica
	 *            el login del usuario que modifica el proyecto.
	 * @param nombre
	 *            el nuevo nombre del proyecto
	 * @param objetivoGeneral
	 *            el objetivo general del proyecto
	 * @param fechaInicial
	 *            la fecha inicial del proyecto
	 * @param modalidadIdn
	 *            el id de la modalidad del proyecto
	 * @param tipoProyectoIdn
	 *            el id del tipo de proyecto
	 * @param fechaFinal
	 *            la fecha final del proyecto
	 * @param proyectoIdn
	 *            el id del proyecto que se desea modificar
	 * @author juan
	 * @return el proyecto modificado
	 * @throws DaoException
	 *             algun parametro es invalido
	 * */
	public TbPryProyectos update(String usuarioModifica, String nombre,
			String objetivoGeneral, Date fechaInicial, Integer modalidadIdn,
			Integer tipoProyectoIdn, Date fechaFinal, Integer proyectoIdn)
			throws DaoException {
		if (fechaInicial == null) {
			throw new DaoException("La fecha inicial no puede ser nula");
		}
		if (fechaFinal == null) {
			throw new DaoException("La fecha final no puede ser nula");
		}
		if (Validaciones.isTextoVacio(nombre)) {
			throw new DaoException("El nombre del proyecto no puede ser vacio");
		}
		if (Validaciones.isTextoVacio(objetivoGeneral)) {
			throw new DaoException(
					"El objetivo general del proyecto no puede ser vacio");
		}
		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que crea el proyecto no puede ser vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto actualizado no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosDAO.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto que se desea actualizar no existe");
		}
		if (modalidadIdn == null) {
			throw new DaoException("La modalidad no puede ser nula");
		}
		TbPryModalidades modalidad = tbPryModalidadesService.get(modalidadIdn);
		if (modalidad == null) {
			throw new DaoException("La modalidad no existe en la base de datos");
		}
		Date current = proyecto.getDtFechacreacion();
		if (fechaInicial.compareTo(current) <= 0) {
			throw new DaoException(
					"La fecha inicial debe ser mayor a la fecha de creación del proyecto");
		}
		if (fechaFinal.compareTo(fechaInicial) <= 0) {
			throw new DaoException(
					"La fecha final debe ser mayor a la fecha inicial del proyecto");
		}
		TbPryTiposproyecto tipoProyecto = tbPryTiposProyectoService
				.get(tipoProyectoIdn);
		if (tipoProyecto == null) {
			throw new DaoException(
					"El tipo de proyecto no existe en la base de datos");
		}
		if (!isEditable(proyectoIdn)) {
			throw new DaoException(
					"No se pueden modificar proyectos suspendidos, cancelados, vencidos o finalizados");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que modifica el proyecto no existe en la base de datos");
		}
		testFechas(fechaInicial, fechaFinal, proyectoIdn);
		proyecto.setVrAdtusuario(usuarioModifica);
		proyecto.setDtAdtfecha(current);
		proyecto.setVrNombreproyecto(nombre);
		proyecto.setVrObjetivogeneral(objetivoGeneral);
		proyecto.setDtFechafinal(fechaFinal);
		proyecto.setDtFechainicial(fechaInicial);
		proyecto.setTbPryModalidades(modalidad);
		proyecto.setTbPryTiposproyecto(tipoProyecto);
		proyecto = tbPryProyectosDAO.update(proyecto);
		StringBuilder message = new StringBuilder();
		message.append("El proyecto: ").append(proyecto.getNbIdn());
		message.append(" ").append(proyecto.getVrNombreproyecto());
		message.append(" ha sido modificado");
		logger.info(message.toString());
		return proyecto;
	}

	/**
	 * Metodo usado para insertar un nuevo proyecto en la base de datos.
	 * 
	 * @param usuarioCrea
	 *            el login del usuario que crea el proyecto
	 * @param nombre
	 *            el nombre del proyecto
	 * @param objetivoGeneral
	 *            el objetivo general del proyecto
	 * @param fechaInicial
	 *            la fecha inicial del proyecto
	 * @param modalidadIdn
	 *            el codigo de la modalidad del proyecto
	 * @param tipoProyectoIdn
	 *            el codigo del tipo de proyecto
	 * @param responsableIdn
	 *            el codigo del responsable del proyecto
	 * @param fechaFinal
	 *            la fecha final del proyecto
	 * @return el nuevo proyecto insertado con el id asignado por el sistema de
	 *         gestión de bases de datos.
	 * @throws DaoException
	 *             si hay parametros invalidos.
	 * */
	public TbPryProyectos insert(String usuarioCrea, String nombre,
			String objetivoGeneral, Date fechaInicial, Integer modalidadIdn,
			Integer tipoProyectoIdn, Integer responsableIdn, Date fechaFinal)
			throws DaoException {
		if (fechaInicial == null) {
			throw new DaoException("La fecha inicial no puede ser nula");
		}
		if (fechaFinal == null) {
			throw new DaoException("La fecha final no puede ser nula");
		}
		if (Validaciones.isTextoVacio(nombre)) {
			throw new DaoException("El nombre del proyecto no puede ser vacio");
		}
		if (Validaciones.isTextoVacio(objetivoGeneral)) {
			throw new DaoException(
					"El objetivo general del proyecto no puede ser vacio");
		}
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException(
					"El usuario que crea el proyecto no puede ser vacio");
		}
		Date current = new Date();
		if (fechaInicial.compareTo(current) <= 0) {
			throw new DaoException(
					"La fecha inicial debe ser mayor a la fecha de creación del proyecto");
		}
		if (fechaFinal.compareTo(fechaInicial) <= 0) {
			throw new DaoException(
					"La fecha final debe ser mayor a la fecha final del proyecto");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea el proyecto no existe en la base de datos");
		}
		TbPryEstados estado = tbPryEstadosService.getEstadoInicialProyecto();
		if (estado == null) {
			throw new DaoException(
					"El estado inicial del proyecto no existe en la base de datos");
		}
		TbPryModalidades modalidad = tbPryModalidadesService.get(modalidadIdn);
		if (modalidad == null) {
			throw new DaoException(
					"La modalidad del proyecto no existe en la base de datos");
		}
		TbPryTiposproyecto tipoProyecto = tbPryTiposProyectoService
				.get(tipoProyectoIdn);
		if (tipoProyecto == null) {
			throw new DaoException(
					"El tipo de proyecto no existe en la base de datos");
		}
		TbAdmUsuarios responsable = tbAdmUsuariosService.get(responsableIdn);
		if (responsable == null) {
			throw new DaoException(
					"El responsable del proyecto no existe en la base de datos");
		}
		TbPryProyectos inserted = new TbPryProyectos();
		inserted.setDtAdtfecha(current);
		inserted.setDtFechacreacion(current);
		inserted.setDtFechafinal(fechaFinal);
		inserted.setDtFechainicial(fechaInicial);
		inserted.setTbAdmUsuarios(responsable);
		inserted.setTbPryEstados(estado);
		inserted.setTbPryModalidades(modalidad);
		inserted.setTbPryTiposproyecto(tipoProyecto);
		inserted.setVrAdtusuario(usuarioCrea);
		inserted.setVrNombreproyecto(nombre);
		inserted.setVrObjetivogeneral(objetivoGeneral);
		inserted = tbPryProyectosDAO.save(inserted);
		StringBuilder message = new StringBuilder();
		message.append("El proyecto: ").append(inserted.getNbIdn());
		message.append(" ").append(inserted.getVrNombreproyecto());
		message.append(" ha sido modificado");
		logger.info(message.toString());
		return inserted;
	}

	/**
	 * Metodo que permite cancelar un proyecto.
	 * 
	 * @param usuarioModifica
	 *            el login del usuario que cancela el proyecto
	 * @param proyectoIdn
	 *            el id del proyecto que se desea cancelar
	 * @param justificacion
	 *            la justificacion de la cancelacion del proyecto
	 * @return el proyecto actualizado
	 * */
	public TbPryProyectos cancelarProyecto(String usuarioModifica,
			Integer proyectoIdn, String justificacion) throws DaoException {

		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que cancela el proyecto no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El codigo del proyecto no puede ser nulo");
		}
		if (Validaciones.isTextoVacio(justificacion)) {
			throw new DaoException(
					"La justificacion de la suspencion no puede ser nula o vacia");
		}
		TbPryProyectos proyecto = tbPryProyectosDAO.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException("El proyecto no existe en la base de datos");
		}
		TbPryEstados estadoFinalizado = tbPryEstadosService
				.getEstadoFinalizado();
		if (estadoFinalizado == null) {
			throw new DaoException(
					"El estado finalizado no existe en la base de datos");
		}
		if (estadoFinalizado.getNbIdn().equals(
				proyecto.getTbPryEstados().getNbIdn())) {
			throw new DaoException(
					"No se puede cancelar un proyecto finalizado");
		}
		TbPryEstados estado = tbPryEstadosService.getEstadoCancelado();
		if (estado == null) {
			throw new DaoException(
					"El estado cancelado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que cancela el proyecto no existe en la base de datos");
		}
		proyecto.setDtAdtfecha(new Date());
		proyecto.setVrAdtusuario(usuarioModifica);
		proyecto.setTbPryEstados(estado);
		proyecto.setVrJustificacioncancelacion(justificacion);
		List<TbPryActividades> actividades = tbPryActividadesService
				.findActividadesByProyecto(proyectoIdn);
		for (TbPryActividades actividad : actividades) {
			try {
				tbPryActividadesService.cancelarActividad(usuarioModifica,
						actividad.getNbIdn(), justificacion);
			} catch (DaoException e) {

			}
		}
		proyecto = tbPryProyectosDAO.update(proyecto);
		StringBuilder message = new StringBuilder();
		message.append("El proyecto: ").append(proyecto.getNbIdn());
		message.append(" ").append(proyecto.getVrNombreproyecto());
		message.append(" ha sido cancelado");
		logger.info(message.toString());
		return proyecto;
	}

	/**
	 * Metodo que permite suspender un proyecto.
	 * 
	 * @param usuarioModifica
	 *            el login del usuario que suspende el proyecto
	 * @param proyectoIdn
	 *            el id del proyecto que se desea suspender
	 * @param justificacion
	 *            la justificacion de la suspencion
	 * @return el proyecto actualizado
	 * */
	public TbPryProyectos suspenderProyecto(String usuarioModifica,
			Integer proyectoIdn, String justificacion) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que suspende el proyecto no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El codigo del proyecto no puede ser nulo");
		}
		if (Validaciones.isTextoVacio(justificacion)) {
			throw new DaoException(
					"La justificacion de la suspencion no puede ser nula o vacia");
		}
		TbPryProyectos proyecto = tbPryProyectosDAO.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException("El proyecto no existe en la base de datos");
		}
		TbPryEstados estadoVencido = tbPryEstadosService.getEstadoVencido();
		if (estadoVencido == null) {
			throw new DaoException(
					"El estado vencido no existe en la base de datos");
		}
		if (estadoVencido.getNbIdn().equals(
				proyecto.getTbPryEstados().getNbIdn())) {
			throw new DaoException("No se puede suspender un proyecto vencido");
		}
		TbPryEstados estadoFinalizado = tbPryEstadosService
				.getEstadoFinalizado();
		if (estadoFinalizado == null) {
			throw new DaoException(
					"El estado finalizado no existe en la base de datos");
		}
		if (estadoFinalizado.getNbIdn().equals(
				proyecto.getTbPryEstados().getNbIdn())) {
			throw new DaoException(
					"No se puede suspender un proyecto finalizado");
		}
		TbPryEstados estadoCancelado = tbPryEstadosService.getEstadoCancelado();
		if (estadoCancelado == null) {
			throw new DaoException(
					"El estado cancelado no existe en la base de datos");
		}
		if (estadoCancelado.getNbIdn().equals(
				proyecto.getTbPryEstados().getNbIdn())) {
			throw new DaoException(
					"No se puede suspender un proyecto cancelado");
		}
		TbPryEstados estado = tbPryEstadosService.getEstadoSuspendido();
		if (estado == null) {
			throw new DaoException(
					"El estado suspendido no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que suspende el proyecto no existe en la base de datos");
		}
		proyecto.setDtAdtfecha(new Date());
		proyecto.setVrAdtusuario(usuarioModifica);
		proyecto.setTbPryEstados(estado);
		proyecto.setVrJustificacionsuspencion(justificacion);
		List<TbPryActividades> actividades = tbPryActividadesService
				.findActividadesByProyecto(proyectoIdn);
		for (TbPryActividades actividad : actividades) {
			try {
				tbPryActividadesService.suspenderActividad(usuarioModifica,
						actividad.getNbIdn(), justificacion);
			} catch (DaoException e) {
			}
		}
		proyecto = tbPryProyectosDAO.update(proyecto);
		StringBuilder message = new StringBuilder();
		message.append("El proyecto: ").append(proyecto.getNbIdn());
		message.append(" ").append(proyecto.getVrNombreproyecto());
		message.append(" ha sido suspendido");
		logger.info(message.toString());
		return proyecto;
	}

	/**
	 * Método que permite finalizar un proyecto.
	 * 
	 * @param usuarioModifica
	 *            login del usuario que finaliza el proyecto.
	 * @param proyectoIdn
	 *            el id del proyecto que se desea finalizar.
	 * @param calificacion
	 *            la calificacion del proyecto
	 * @param reconocimientos
	 *            los reconocimientos del proyecto
	 * @return el proyecto actualizado
	 * */
	public TbPryProyectos finalizarProyecto(String usuarioModifica,
			Integer proyectoIdn, String calificacion, String reconocimientos)
			throws DaoException {
		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que finaliza el proyecto no puede ser nulo");
		}
		if (Validaciones.isTextoVacio(calificacion)) {
			throw new DaoException(
					"La calificacion del proyecto no puede ser nula o vacia");
		}

		if (!"aprobo".equals(calificacion) && !"desaprobo".equals(calificacion)) {
			if (!calificacion
					.matches("[0-4]([.][0-9]?[0-9]?)?|[5]([.][0]?[0]?)?")) {
				throw new DaoException(
						"La calificacion del proyecto es invalida");
			}
		}
		if (Validaciones.isTextoVacio(reconocimientos)) {
			throw new DaoException(
					"Los reconocimientos del proyecto no pueden ser nulos o vacios");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El codigo del proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosDAO.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException("El proyecto no existe en la base de datos");
		}
		TbPryEstados estadoEnProceso = tbPryEstadosService.getEstadoEnProceso();
		TbPryEstados estadoVencido = tbPryEstadosService.getEstadoVencido();
		if (!estadoEnProceso.getNbIdn().equals(
				proyecto.getTbPryEstados().getNbIdn())
				&& !estadoVencido.getNbIdn().equals(
						proyecto.getTbPryEstados().getNbIdn())) {
			throw new DaoException(
					"Solo se pueden finalizar proyectos en proceso o vencidos");
		}
		TbPryEstados estado = tbPryEstadosService.getEstadoFinalizado();
		if (estado == null) {
			throw new DaoException(
					"El estado finalizado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que finaliza el proyecto no existe en la base de datos");
		}
		Double porcentajeAvance = getPorcentajeAvance(proyectoIdn);
		Integer porcentaje = (int) Math.round(porcentajeAvance);
		if (porcentaje != 100) {
			throw new DaoException(
					"No se permite finalizar proyectos que no hayan avanzado hasta el 100%");
		}
		proyecto.setVrAdtusuario(usuarioModifica);
		proyecto.setTbPryEstados(estado);
		proyecto.setDtAdtfecha(new Date());
		proyecto.setVrCalificacion(calificacion);
		proyecto.setVrReconocimiento(reconocimientos);
		proyecto = tbPryProyectosDAO.update(proyecto);
		StringBuilder message = new StringBuilder();
		message.append("El proyecto: ").append(proyecto.getNbIdn());
		message.append(" ").append(proyecto.getVrNombreproyecto());
		message.append(" ha sido finalizado");
		logger.info(message.toString());
		return proyecto;
	}

	/**
	 * Metodo que permite reanudar un proyecto.
	 * 
	 * @param usuarioModifica
	 *            el login del usuario que reanuda el proyecto.
	 * @param fechaInicial
	 *            la nueva fecha inicial del proyecto
	 * @param fechaFinal
	 *            la nueva fecha final del proyecto
	 * @param proyectoIdn
	 *            el id del proyecto que se desea reanudar
	 * @return el proyecto actualizado
	 * */
	public TbPryProyectos reanudarProyecto(String usuarioModifica,
			Date fechaInicial, Date fechaFinal, Integer proyectoIdn)
			throws DaoException {
		if (fechaInicial == null) {
			throw new DaoException("La fecha inicial no puede ser nula");
		}
		if (fechaFinal == null) {
			throw new DaoException("La fecha final no puede ser nula");
		}
		if (Validaciones.isTextoVacio(usuarioModifica)) {
			throw new DaoException(
					"El usuario que finaliza el proyecto no puede ser nulo");
		}
		Date current = new Date();
		if (fechaInicial.compareTo(current) <= 0) {
			throw new DaoException(
					"La fecha inicial debe ser mayor a la fecha de creación del proyecto");
		}
		if (fechaFinal.compareTo(fechaInicial) <= 0) {
			throw new DaoException(
					"La fecha final debe ser mayor a la fecha final del proyecto");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioModifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que crea el proyecto no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosDAO.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException("El proyecto no existe en la base de datos");
		}
		TbPryEstados estadoFinalizado = tbPryEstadosService
				.getEstadoFinalizado();
		TbPryEstados estadoCancelado = tbPryEstadosService.getEstadoCancelado();
		if (estadoFinalizado.getNbIdn().equals(
				proyecto.getTbPryEstados().getNbIdn())) {
			throw new DaoException(
					"No se puede reanudar un proyecto finalizado");
		}
		if (estadoCancelado.getNbIdn().equals(
				proyecto.getTbPryEstados().getNbIdn())) {
			throw new DaoException("No se puede reanudar un proyecto cancelado");
		}
		TbPryEstados estado = tbPryEstadosService.getEstadoReanudado();
		if (estado == null) {
			throw new DaoException(
					"El estado reanudado no existe en la base de datos");
		}
		
		proyecto.setDtAdtfecha(current);
		proyecto.setDtFechafinal(fechaFinal);
		proyecto.setDtFechainicial(fechaInicial);
		proyecto.setTbPryEstados(estado);
		proyecto.setVrAdtusuario(usuarioModifica);
		proyecto = tbPryProyectosDAO.update(proyecto);
		StringBuilder message = new StringBuilder();
		message.append("El proyecto: ").append(proyecto.getNbIdn());
		message.append(" ").append(proyecto.getVrNombreproyecto());
		message.append(" ha sido finalizado");
		logger.info(message.toString());
		return proyecto;
	}

	/**
	 * Metodo usado para actualizar el estado de un proyecto de acuerdo con las
	 * fechas en las que se encuentra.
	 * 
	 * @param proyecto
	 *            el proyecto que se desea actualizar
	 * @param usuarioModifica
	 *            el login del usuario que modifica el proyecto.
	 * */
	protected void updateProyecto(TbPryProyectos proyecto,
			String usuarioModifica) throws DaoException {
		TbPryEstados estadoAbierto = tbPryEstadosService.getEstadoAbierto();
		TbPryEstados estadoReanudado = tbPryEstadosService.getEstadoReanudado();
		TbPryEstados estadoEnProceso = tbPryEstadosService.getEstadoEnProceso();
		TbPryEstados estadoVencido = tbPryEstadosService.getEstadoVencido();
		Date current = new Date();
		if (proyecto.getDtFechainicial().compareTo(current) < 0
				&& (estadoAbierto.getNbIdn().equals(
						proyecto.getTbPryEstados().getNbIdn()) || estadoReanudado
						.getNbIdn().equals(
								proyecto.getTbPryEstados().getNbIdn()))) {
			boolean valid = true;
			List<TbPryObjetivosespecificos> objetivos = tbPryObjetivosespecificosService
					.findByProyecto(proyecto.getNbIdn());
			for (TbPryObjetivosespecificos objetivo : objetivos) {
				Long porcentaje = tbPryObjetivosespecificosService
						.getPorcentaje(objetivo.getNbIdn());
				if (porcentaje == null || porcentaje != 100l) {
					valid = false;
					break;
				}
			}
			if (valid) {
				proyecto.setTbPryEstados(estadoEnProceso);
				tbPryProyectosDAO.update(proyecto);
			}
		}
		if (proyecto.getDtFechafinal().compareTo(current) < 0
				&& estadoEnProceso.getNbIdn().equals(
						proyecto.getTbPryEstados().getNbIdn())) {
			proyecto.setTbPryEstados(estadoVencido);
			tbPryProyectosDAO.update(proyecto);
			tbNtfNtfsxusuarioService.notificarVencimientoProyecto(
					usuarioModifica, proyecto.getNbIdn());
		}
		if (proyecto.getTbPryEstados().getNbIdn()
				.equals(estadoEnProceso.getNbIdn())) {
			boolean valid = false;
			List<TbPryObjetivosespecificos> objetivos = tbPryObjetivosespecificosService
					.findByProyecto(proyecto.getNbIdn());
			for (TbPryObjetivosespecificos objetivo : objetivos) {
				Long porcentaje = tbPryObjetivosespecificosService
						.getPorcentaje(objetivo.getNbIdn());
				if (porcentaje == null || porcentaje != 100l) {
					valid = true;
					break;
				}
			}
			if (valid) {
				proyecto.setTbPryEstados(estadoAbierto);
				tbPryProyectosDAO.update(proyecto);
			}
		}
	}

	/**
	 * Permite actualizar el estado de los proyectos de acuerdo con la fecha
	 * actual
	 * 
	 * @param usuarioModifica
	 *            login del usuario que modifica
	 * @throws DaoException
	 */
	public void updateEstadoProyectos(String usuarioModifica)
			throws DaoException {
		List<TbPryProyectos> proyectos = findAll();
		for (TbPryProyectos proyecto : proyectos) {
			updateProyecto(proyecto, usuarioModifica);
		}
	}

	/**
	 * Permite obtener el porcentaje de avance de un proyecto.
	 * 
	 * @param proyectoIdn
	 *            el id del proyecto en la base de datos.
	 * @return el porcentaje de avance del proyecto, calculado como el
	 *         porcentaje acumulado de todas las actividades que han sido
	 *         verificadas por el responsable o asesor del proyecto ingresado
	 *         como argumento.
	 * */
	public Double getPorcentajeAvance(Integer proyectoIdn) throws DaoException {
		List<TbPryObjetivosespecificos> objetivos = tbPryObjetivosespecificosService
				.findByProyecto(proyectoIdn);
		Double porcentaje = 0.0;
		TbPryEstadosactividad estadoVerificado = tbPryEstadosactividadService
				.getEstadoVerificado();
		for (TbPryObjetivosespecificos objetivo : objetivos) {
			List<TbPryActividades> actividades = tbPryActividadesService
					.findActividadesByObjetivo(objetivo.getNbIdn());
			Long porcentajeObjetivo = objetivo.getNbPorcentajesobreproyecto();
			for (TbPryActividades actividad : actividades) {
				if (actividad.getTbPryEstadosactividad().getNbIdn()
						.equals(estadoVerificado.getNbIdn())) {
					porcentaje += actividad.getNbPorcentajesobreactividad()
							* porcentajeObjetivo;
				}
			}
		}
		return porcentaje / 100;
	}

	/**
	 * Metodo usado para obtener los proyectos asociados a un usuario con un
	 * estado especifico.
	 * 
	 * @param estadoIdn
	 *            el id del estado del proyecto en la base de datos.
	 * @param usuarioIdn
	 *            el id del usuario en la base de datos.
	 * @return la lista de de los proyectos con el estado especificado como
	 *         argumento que tienen al usuario ingresado como argumento como su
	 *         asesor, su responsable o su participante. En caso de que el usuario 
	 *         sea superusuario retorna todos los proyectos. 
	 * */
	public List<TbPryProyectos> findproyectosByEstado(Integer estadoIdn,
			Integer usuarioIdn) throws DaoException {
		if (estadoIdn == null) {
			throw new DaoException(
					"El estado del proyecto no puede ser nulo o vacio");
		}
		if (usuarioIdn == null) {
			throw new DaoException("El usuario que actualiza no puede ser nulo");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService.get(usuarioIdn);
		if (usuario == null) {
			throw new DaoException("El usuario no existe en la base de datos");
		}
		TbAdmRoles rolSuperUsuario = tbAdmRolesService.getRolSuperUsuario();
		Integer rolSuperUsuarioIdn = null;
		if(rolSuperUsuario != null)
		{
			rolSuperUsuarioIdn = rolSuperUsuario.getNbIdn();
		}
		Integer rolUsuarioIdn = usuario.getTbAdmRoles().getNbIdn();
		return tbPryProyectosDAO.findProyectosByEstado(estadoIdn, usuarioIdn, rolSuperUsuarioIdn, rolUsuarioIdn);
	}
	/**
	 * Indica si el proyecto ingresado es editable
	 * @param proyectoIdn id del proyecto
	 * @return true si el proyecto es editable, false en caso contrario
	 * @throws DaoException
	 */
	protected Boolean isEditable(Integer proyectoIdn) throws DaoException {
		if(proyectoIdn == null)
		{
			throw new DaoException("El id del proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosDAO.get(proyectoIdn);
		if(proyecto == null)
		{
			throw new DaoException("El proyecto no existe en la base de datos");
		}
		Integer estadoCanceladoIdn = tbPryEstadosService.getEstadoCancelado()
				.getNbIdn();
		Integer estadoSuspendidoIdn = tbPryEstadosService.getEstadoSuspendido()
				.getNbIdn();
		Integer estadoVencidoIdn = tbPryEstadosService.getEstadoVencido()
				.getNbIdn();
		Integer estadoFinalizadoIdn = tbPryEstadosService.getEstadoFinalizado()
				.getNbIdn();
		if (proyecto.getTbPryEstados().getNbIdn().equals(estadoCanceladoIdn)
				|| proyecto.getTbPryEstados().getNbIdn()
						.equals(estadoSuspendidoIdn)
				|| proyecto.getTbPryEstados().getNbIdn()
						.equals(estadoVencidoIdn)
				|| proyecto.getTbPryEstados().getNbIdn()
						.equals(estadoFinalizadoIdn)) {
			return false;
		}
		return true;
	}
}
