package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbNtfNtfsxusuarioDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbNtfMediosntf;
import co.edu.udea.proyectointegrador.dto.TbNtfMediostipontf;
import co.edu.udea.proyectointegrador.dto.TbNtfNotificaciones;
import co.edu.udea.proyectointegrador.dto.TbNtfNtfsxusuario;
import co.edu.udea.proyectointegrador.dto.TbNtfTipontfs;
import co.edu.udea.proyectointegrador.dto.TbNtfUsrtpntfmedios;
import co.edu.udea.proyectointegrador.dto.TbNtfUsuariostipontf;
import co.edu.udea.proyectointegrador.dto.TbNtfsTipontfsroles;
import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.dto.TbPryArchivoxentregable;
import co.edu.udea.proyectointegrador.dto.TbPryAsesorxproyecto;
import co.edu.udea.proyectointegrador.dto.TbPryEntregables;
import co.edu.udea.proyectointegrador.dto.TbPryParticipantexactividad;
import co.edu.udea.proyectointegrador.dto.TbPryParticipantexproyecto;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.service.email.Notificador;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * Clase que se encarga de enviar las notificaciones a los usuarios del sistema
 * 
 * @author juan
 * 
 */
public class TbNtfNtfsxusuarioService {
	private TbNtfNtfsxusuarioDAO tbNtfNtfsxusuarioDAO;
	private TbPryAsesorxproyectoService tbPryAsesorxproyectoService;
	private TbPryParticipantexproyectoService tbPryParticipantexproyectoService;
	private TbPryProyectosService tbPryProyectosService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	private TbNtfsTipontfsrolesService tbNtfsTipontfsrolesService;
	private TbNtfTipontfsService tbNtfTipontfsService;
	private TbNtfUsuariostipontfService tbNtfUsuariostipontfService;
	private TbNtfMediosntfService tbNtfMediosntfService;
	private TbNtfUsrtpntfmediosService tbNtfUsrtpntfmediosService;
	private TbNtfNotificacionesService tbNtfNotificacionesService;
	private TbNtfMediostipontfService tbNtfMediostipontfService;
	private TbPryActividadesService tbPryActividadesService;
	private TbPryParticipantexactividadService tbPryParticipantexactividadService;
	private TbPryEntregablesService tbPryEntregablesService;
	private TbPryArchivoxentregableService tbPryArchivoxentregableService;
	
	public TbPryArchivoxentregableService getTbPryArchivoxentregableService() {
		return tbPryArchivoxentregableService;
	}

	public void setTbPryArchivoxentregableService(
			TbPryArchivoxentregableService tbPryArchivoxentregableService) {
		this.tbPryArchivoxentregableService = tbPryArchivoxentregableService;
	}

	public List<TbNtfNtfsxusuario> findNotificacionesByUsuario(
			Integer usuarioIdn) throws DaoException {
		return tbNtfNtfsxusuarioDAO.findNotificacionesByUsuario(usuarioIdn);
	}

	public TbPryEntregablesService getTbPryEntregablesService() {
		return tbPryEntregablesService;
	}

	public void setTbPryEntregablesService(
			TbPryEntregablesService tbPryEntregablesService) {
		this.tbPryEntregablesService = tbPryEntregablesService;
	}

	public TbPryParticipantexactividadService getTbPryParticipantexactividadService() {
		return tbPryParticipantexactividadService;
	}

	public void setTbPryParticipantexactividadService(
			TbPryParticipantexactividadService tbPryParticipantexactividadService) {
		this.tbPryParticipantexactividadService = tbPryParticipantexactividadService;
	}

	public TbPryActividadesService getTbPryActividadesService() {
		return tbPryActividadesService;
	}

	public void setTbPryActividadesService(
			TbPryActividadesService tbPryActividadesService) {
		this.tbPryActividadesService = tbPryActividadesService;
	}

	public TbNtfMediostipontfService getTbNtfMediostipontfService() {
		return tbNtfMediostipontfService;
	}

	public void setTbNtfMediostipontfService(
			TbNtfMediostipontfService tbNtfMediostipontfService) {
		this.tbNtfMediostipontfService = tbNtfMediostipontfService;
	}

	public TbNtfNotificacionesService getTbNtfNotificacionesService() {
		return tbNtfNotificacionesService;
	}

	public void setTbNtfNotificacionesService(
			TbNtfNotificacionesService tbNtfNotificacionesService) {
		this.tbNtfNotificacionesService = tbNtfNotificacionesService;
	}

	public TbNtfUsrtpntfmediosService getTbNtfUsrtpntfmediosService() {
		return tbNtfUsrtpntfmediosService;
	}

	public void setTbNtfUsrtpntfmediosService(
			TbNtfUsrtpntfmediosService tbNtfUsrtpntfmediosService) {
		this.tbNtfUsrtpntfmediosService = tbNtfUsrtpntfmediosService;
	}

	public TbNtfMediosntfService getTbNtfMediosntfService() {
		return tbNtfMediosntfService;
	}

	public void setTbNtfMediosntfService(
			TbNtfMediosntfService tbNtfMediosntfService) {
		this.tbNtfMediosntfService = tbNtfMediosntfService;
	}

	public void setTbNtfUsuariostipontfService(
			TbNtfUsuariostipontfService tbNtfUsuariostipontfService) {
		this.tbNtfUsuariostipontfService = tbNtfUsuariostipontfService;
	}

	public TbNtfUsuariostipontfService getTbNtfUsuariostipontfService() {
		return tbNtfUsuariostipontfService;
	}

	public void setTbNtfUsuariostbAdmUsuariostipontfService(
			TbNtfUsuariostipontfService tbNtfUsuariostipontfService) {
		this.tbNtfUsuariostipontfService = tbNtfUsuariostipontfService;
	}

	public TbNtfTipontfsService getTbNtfTipontfsService() {
		return tbNtfTipontfsService;
	}

	public void setTbNtfTipontfsService(
			TbNtfTipontfsService tbNtfTipontfsService) {
		this.tbNtfTipontfsService = tbNtfTipontfsService;
	}

	public TbNtfsTipontfsrolesService getTbNtfsTipontfsrolesService() {
		return tbNtfsTipontfsrolesService;
	}

	public void setTbNtfsTipontfsrolesService(
			TbNtfsTipontfsrolesService tbNtfsTipontfsrolesService) {
		this.tbNtfsTipontfsrolesService = tbNtfsTipontfsrolesService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	public TbPryProyectosService getTbPryProyectosService() {
		return tbPryProyectosService;
	}

	public void setTbPryProyectosService(
			TbPryProyectosService tbPryProyectosService) {
		this.tbPryProyectosService = tbPryProyectosService;
	}

	public TbPryParticipantexproyectoService getTbPryParticipantexproyectoService() {
		return tbPryParticipantexproyectoService;
	}

	public void setTbPryParticipantexproyectoService(
			TbPryParticipantexproyectoService tbPryParticipantexproyectoService) {
		this.tbPryParticipantexproyectoService = tbPryParticipantexproyectoService;
	}

	public TbPryAsesorxproyectoService getTbPryAsesorxproyectoService() {
		return tbPryAsesorxproyectoService;
	}

	public void setTbPryAsesorxproyectoService(
			TbPryAsesorxproyectoService tbPryAsesorxproyectoService) {
		this.tbPryAsesorxproyectoService = tbPryAsesorxproyectoService;
	}

	public TbNtfNtfsxusuarioDAO getTbNtfNtfsxusuarioDAO() {
		return tbNtfNtfsxusuarioDAO;
	}

	public void setTbNtfNtfsxusuarioDAO(
			TbNtfNtfsxusuarioDAO tbNtfNtfsxusuarioDAO) {
		this.tbNtfNtfsxusuarioDAO = tbNtfNtfsxusuarioDAO;
	}

	/**
	 * Metodo que permite enviar un email.
	 * 
	 * @param email
	 *            la direccion de email de destino.
	 * @param asunto
	 *            el asunto del email
	 * @param mensaje
	 *            el mensaje del email
	 * @throws DaoException
	 */
	public void enviarCorreo(String email, String asunto, String mensaje)
			throws DaoException {

		if (Validaciones.isTextoVacio(asunto)) {
			throw new NullPointerException(
					"El asunto del correo no puede ser nulo o una cadena de caracteres vacia");
		}
		if (Validaciones.isTextoVacio(mensaje)) {
			throw new NullPointerException(
					"El mensaje del correio no puede ser nulo o una cadena de caracteres vacia");
		}

		// inicia el hilo que ejecuta el procedimiento para enviar el email.
		Notificador notificador = new Notificador(email, asunto, mensaje);
		notificador.start();
	}

	/**
	 * Mensaje de notificacion de finalizacion de proyecto a un participante
	 * 
	 * @param proyectoNombre
	 *            nombre del proyecto
	 * @return
	 */
	public String getMensajeNotificacionFinalizacionProyectoParticipante(
			String proyectoNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("El proyecto ").append(proyectoNombre)
				.append(" ha sido finalizado.");
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @return
	 */
	public String getMensajeNotificacionReanudacionProyectoParticipante(
			String proyectoNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("El proyecto ").append(proyectoNombre)
				.append(" ha sido reanudado.");
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @return
	 */
	private String getMensajeNotificacionCreacionProyectoAsesor(
			String proyectoNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("Usted ha sido asignado para asesorar el proyecto ").append(
				proyectoNombre);
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @return
	 */
	private String getMensajeNotificacionCreacionProyectoParticipante(
			String proyectoNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("Usted ha sido matriculado en el proyecto ").append(
				proyectoNombre);
		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionCreacionProyecto() {
		return "Notificación de creación de proyecto";
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionFinalizacionActividad() {
		return "Notificación de seguimiento de actividad";
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionActualizacionProyecto() {
		return "Notificación de actualizacion de Proyecto";
	}

	/**
	 * 
	 * @return
	 */

	private String getAsuntoNotificacionFinalizacionProyecto() {
		return "Notificacion de finalizacion de proyecto";
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionSuspencionProyecto() {
		return "Notificacion de suspencion de proyecto";
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionCancelacionProyecto() {
		return "Notificacion de cancelacion de proyecto";
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionCreacionActividad() {
		return "Notificacion de creacion de actividad";
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionActualizacionActividad() {
		return "Notificacion de actualizacion de actividad";
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionCancelacionActividad() {
		return "Notificacion de cancelacion de actividad";
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionReanudacionActividad() {
		return "Notificacion de reanudacion de actividad";
	}
	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionVencimientoActividad() {
		// TODO Auto-generated method stub
		return "Notificacion de vencimiento de actividad";
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param actividadNombre
	 * @return
	 */
	private String getMensajeNotificacionVencimientoActividad(
			String proyectoNombre, String actividadNombre) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("La actividad ");
		sb.append(actividadNombre).append(" del proyecto ");
		sb.append(proyectoNombre).append(" se ha vencido.");
		return sb.toString();
	}
	/**
	 * 
	 * @param proyectoNombre
	 * @param justificacion
	 * @return
	 */
	private String getMensajeNotificacionSuspencionProyectoAsesor(
			String proyectoNombre, String justificacion) {
		StringBuilder sb = new StringBuilder();
		sb.append("El proyecto ").append(proyectoNombre)
				.append(" ha sido suspendido.")
				.append("\nLa justificación fue: ").append(justificacion);
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param actividadNombre
	 * @return
	 */
	private String getMensajeNotificacionFinalizacionActividadParticipante(
			String proyectoNombre, String actividadNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("La actividad ").append(actividadNombre)
				.append(" del proyecto ").append(proyectoNombre)
				.append(" ha sido revisada por el responsable.");
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @return
	 */
	private String getMensajeNotificacionReanudacionProyectoAsesor(
			String proyectoNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("El proyecto ").append(proyectoNombre)
				.append(" ha sido reanudado.");
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @return
	 */
	private String getMensajeNotificacionActualizacionProyectoAsesor(
			String proyectoNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("El proyecto ").append(proyectoNombre)
				.append(" ha sido modificado.");
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @return
	 */
	private String getMensajeNotificacionActualizacionProyectoParticipante(
			String proyectoNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("El proyecto ").append(proyectoNombre)
				.append(" ha sido modificado.");
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param justificacion
	 * @return
	 */
	private String getMensajeNotificacionSuspencionProyectoParticipante(
			String proyectoNombre, String justificacion) {
		StringBuilder sb = new StringBuilder();
		sb.append("El proyecto ").append(proyectoNombre)
				.append(" ha sido suspendido.")
				.append("\nLa justificación fue: ").append(justificacion);
		;
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param actividadNombre
	 * @param justificacion
	 * @return
	 */
	private String getMensajeNotificacionCancelacionActividadParticipante(
			String proyectoNombre, String actividadNombre, String justificacion) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("La actividad ").append(actividadNombre)
				.append(" del proyecto ").append(proyectoNombre)
				.append(" ha sido cancelada.")
				.append("\nLa justificación fue: ").append(justificacion);
		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionSuspencionActividad() {
		// TODO Auto-generated method stub
		return "Notificación de suspención de actividad";
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param justificacion
	 * @return
	 */
	private String getMensajeNotificacionCancelacionProyectoAsesor(
			String proyectoNombre, String justificacion) {
		StringBuilder sb = new StringBuilder();
		sb.append("El proyecto ").append(proyectoNombre)
				.append(" ha sido cancelado.")
				.append("\nLa justificación fue: ").append(justificacion);
		;
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param justificacion
	 * @return
	 */
	private String getMensajeNotificacionCancelacionProyectoParticipante(
			String proyectoNombre, String justificacion) {
		StringBuilder sb = new StringBuilder();
		sb.append("El proyecto ").append(proyectoNombre)
				.append(" ha sido cancelado.")
				.append("\nLa justificación fue: ").append(justificacion);
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param actividadNombre
	 * @return
	 */
	private String getMensajeNotificacionActualizacionActividadParticipante(
			String proyectoNombre, String actividadNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("La actividad ").append(actividadNombre)
				.append(" del proyecto ").append(proyectoNombre)
				.append(" ha sido actualizada.");
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param actividadNombre
	 * @return
	 */
	private String getMensajeNotificacionReanudacionActividadParticipante(
			String proyectoNombre, String actividadNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("La actividad ").append(actividadNombre)
				.append(" del proyecto ").append(proyectoNombre)
				.append(" ha sido reanudada.");
		return sb.toString();
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param actividadNombre
	 * @return
	 */
	private String getMensajeNotificacionCreacionActividadParticipante(
			String proyectoNombre, String actividadNombre) {
		StringBuilder sb = new StringBuilder();
		sb.append("Se le ha asignado la actividad ").append(actividadNombre)
				.append(" del proyecto ").append(proyectoNombre);
		return sb.toString();
	}

	/**
	 * Metodo que permite realizar una notificacion teniendo en cuenta los
	 * medios permitidos para efectuarla
	 * 
	 * @param permiso
	 *            contiene el rol y el tipo de notificacion
	 * @param usuarioActual
	 *            el usuario al que se le envia la notificacion
	 * @param notificacion
	 *            la notificacion que sera enviada
	 * @param usuarioNotifica
	 *            el login del usuario que realiza la notificacion
	 * @param mensaje
	 *            el mensaje de la notificacion
	 * @param asunto
	 *            el asunto de la notificacion
	 * @param tipoNotificacion
	 *            el tipo de notificacion
	 * @throws DaoException
	 */
	private void realizarNotificacion(TbNtfsTipontfsroles permiso,
			TbAdmUsuarios usuarioActual, TbNtfNotificaciones notificacion,
			String usuarioNotifica, String mensaje, String asunto,
			TbNtfTipontfs tipoNotificacion) throws DaoException {
		TbNtfMediosntf email = tbNtfMediosntfService.getMedioEmail();
		TbNtfMediostipontf medioActual = tbNtfMediostipontfService
				.findByForeignKey(email.getNbIdn(), tipoNotificacion.getNbIdn());

		if (medioActual == null) {
			throw new DaoException(
					"No se permite enviar notificaciones de suspencion de actividades via email");
		}
		TbNtfUsuariostipontf usuarioTipoNotificacion = tbNtfUsuariostipontfService
				.findByForeignKey(permiso.getNbIdn(), usuarioActual.getNbIdn());
		if (usuarioTipoNotificacion != null) {
			if (usuarioTipoNotificacion.isBlNotificar()) {
				TbNtfNtfsxusuario notificacionUsuario = new TbNtfNtfsxusuario();
				notificacionUsuario.setDtAdtfecha(new Date());
				notificacionUsuario.setTbAdmUsuarios(usuarioActual);
				notificacionUsuario.setTbNtfNotificaciones(notificacion);
				notificacionUsuario.setVrAdtusuario(usuarioNotifica);
				notificacionUsuario.setBlNotificada(true);
				tbNtfNtfsxusuarioDAO.save(notificacionUsuario);
				StringBuilder sb = new StringBuilder("Estimado ");
				sb.append(usuarioActual.getVrNombres()).append(" ")
						.append(usuarioActual.getVrApellidos());
				sb.append(" ").append(mensaje);
				TbNtfUsrtpntfmedios usuarioMediosEmail = tbNtfUsrtpntfmediosService
						.findByForeignKey(medioActual.getNbIdn(),
								usuarioTipoNotificacion.getNbIdn());
				if (usuarioMediosEmail != null) {
					if (usuarioMediosEmail.isBlNotificar()) {
						enviarCorreo(usuarioActual.getVrCorreo(), asunto,
								sb.toString());
					}
				}

			}
		}
	}
	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @param actividadIdn
	 * @param entregableIdn
	 * @throws DaoException
	 */
	public void notificarRealizacionEntregableActividad(String usuarioNotifica,
			Integer proyectoIdn, Integer actividadIdn, Integer entregableIdn)
			throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (entregableIdn == null) {
			throw new DaoException("El codigo del entregable no puede ser nulo");
		}
		TbPryArchivoxentregable entregable = tbPryArchivoxentregableService
				.get(entregableIdn);
		if (entregable == null) {
			throw new DaoException(
					"El entregable no existe en la base de datos");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionRealizarEntregable();
		List<TbPryAsesorxproyecto> asesores = tbPryAsesorxproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionRealizacionEntregable();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		StringBuilder actividadNombre = new StringBuilder(
				actividad.getVrNombreactividad());
		String mensaje = getMensajeNotificacionRealizacionEntregable(
				entregable.getVrNombre(), proyectoNombre.toString(),
				actividadNombre.toString());
		TbNtfNotificaciones notificacionAsesor = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryAsesorxproyecto asesor : asesores) {
			TbAdmUsuarios usuarioActual = asesor.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionAsesor, usuarioNotifica, mensaje, asunto,
						tipoNotificacion);
			}
		}

	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @param actividadIdn
	 * @param entregableIdn
	 * @throws DaoException
	 */
	public void notificarRealizacionEntregable(String usuarioNotifica,
			Integer proyectoIdn, Integer actividadIdn, Integer entregableIdn)
			throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (entregableIdn == null) {
			throw new DaoException("El codigo del entregable no puede ser nulo");
		}
		TbPryEntregables entregable = tbPryEntregablesService
				.get(entregableIdn);
		if (entregable == null) {
			throw new DaoException(
					"El entregable no existe en la base de datos");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionRealizarEntregable();
		List<TbPryAsesorxproyecto> asesores = tbPryAsesorxproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionRealizacionEntregable();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		StringBuilder actividadNombre = new StringBuilder(
				actividad.getVrNombreactividad());
		String mensaje = getMensajeNotificacionRealizacionEntregable(
				entregable.getVrNombre(), proyectoNombre.toString(),
				actividadNombre.toString());
		TbNtfNotificaciones notificacionAsesor = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryAsesorxproyecto asesor : asesores) {
			TbAdmUsuarios usuarioActual = asesor.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionAsesor, usuarioNotifica, mensaje, asunto,
						tipoNotificacion);
			}
		}

	}

	/**
	 * 
	 * @param entregableNombre
	 * @param proyectoNombre
	 * @param actividadNombre
	 * @return
	 */
	private String getMensajeNotificacionRealizacionEntregable(
			String entregableNombre, String proyectoNombre,
			String actividadNombre) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		sb.append("Se ha desarrollado el entregable ").append(entregableNombre)
				.append(" de ");
		sb.append("la actividad ").append(actividadNombre)
				.append(" del proyecto ").append(proyectoNombre);
		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionRealizacionEntregable() {
		// TODO Auto-generated method stub
		return "Notificacion de realizacion de entregable";
	}

	/**
	 * 
	 */
	public void notificarCancelacionActividadEmail(String usuarioNotifica,
			Integer proyectoIdn, Integer actividadIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionCancelarActividad();
		List<TbPryParticipantexactividad> participantes = tbPryParticipantexactividadService
				.findByActividad(actividadIdn);

		String asunto = getAsuntoNotificacionCancelacionActividad();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		StringBuilder actividadNombre = new StringBuilder(
				actividad.getVrNombreactividad());
		String mensaje = getMensajeNotificacionCancelacionActividadParticipante(
				proyectoNombre.toString(), actividadNombre.toString(),
				actividad.getVrJustificacioncancelacion());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexactividad participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @param actividadIdn
	 * @throws DaoException
	 */
	public void notificarSuspencionActividadEmail(String usuarioNotifica,
			Integer proyectoIdn, Integer actividadIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionSuspenderActividad();
		List<TbPryParticipantexactividad> participantes = tbPryParticipantexactividadService
				.findByActividad(actividadIdn);

		TbNtfMediosntf email = tbNtfMediosntfService.getMedioEmail();
		TbNtfMediostipontf medioActual = tbNtfMediostipontfService
				.findByForeignKey(email.getNbIdn(), tipoNotificacion.getNbIdn());
		if (medioActual == null) {
			throw new DaoException(
					"No se permite enviar notificaciones de suspencion de actividades via email");
		}
		String asunto = getAsuntoNotificacionSuspencionActividad();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		StringBuilder actividadNombre = new StringBuilder(
				actividad.getVrNombreactividad());
		String mensaje = getMensajeNotificacionSuspencionActividadParticipante(
				proyectoNombre.toString(), actividadNombre.toString(),
				actividad.getVrJustificacionsuspencion());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexactividad participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @param actividadNombre
	 * @param justificacion
	 * @return
	 */
	private String getMensajeNotificacionSuspencionActividadParticipante(
			String proyectoNombre, String actividadNombre, String justificacion) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("La actividad ").append(actividadNombre)
				.append(" del proyecto ").append(proyectoNombre)
				.append(" ha sido suspendida.")
				.append("\nLa justificación fue: ").append(justificacion);
		return sb.toString();
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @param actividadIdn
	 * @throws DaoException
	 */
	public void notificarActualizacionActividadEmail(String usuarioNotifica,
			Integer proyectoIdn, Integer actividadIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionSuspenderActividad();
		List<TbPryParticipantexactividad> participantes = tbPryParticipantexactividadService
				.findByActividad(actividadIdn);

		String asunto = getAsuntoNotificacionActualizacionActividad();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		StringBuilder actividadNombre = new StringBuilder(
				actividad.getVrNombreactividad());
		String mensaje = getMensajeNotificacionActualizacionActividadParticipante(
				proyectoNombre.toString(), actividadNombre.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexactividad participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @param actividadIdn
	 * @throws DaoException
	 */
	public void notificarFinalizacionActividadEmail(String usuarioNotifica,
			Integer proyectoIdn, Integer actividadIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionFinalizarActividad();
		List<TbPryParticipantexactividad> participantes = tbPryParticipantexactividadService
				.findByActividad(actividadIdn);

		String asunto = getAsuntoNotificacionFinalizacionActividad();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		StringBuilder actividadNombre = new StringBuilder(
				actividad.getVrNombreactividad());
		String mensaje = getMensajeNotificacionFinalizacionActividadParticipante(
				proyectoNombre.toString(), actividadNombre.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexactividad participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @param actividadIdn
	 * @throws DaoException
	 */
	public void notificarReanudacionActividadEmail(String usuarioNotifica,
			Integer proyectoIdn, Integer actividadIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionReanudarActividad();
		List<TbPryParticipantexactividad> participantes = tbPryParticipantexactividadService
				.findByActividad(actividadIdn);

		String asunto = getAsuntoNotificacionReanudacionActividad();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		StringBuilder actividadNombre = new StringBuilder(
				actividad.getVrNombreactividad());
		String mensaje = getMensajeNotificacionReanudacionActividadParticipante(
				proyectoNombre.toString(), actividadNombre.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexactividad participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @param actividadIdn
	 * @throws DaoException
	 */
	public void notificarCreacionActividadEmail(String usuarioNotifica,
			Integer proyectoIdn, Integer actividadIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionCrearActividad();
		List<TbPryParticipantexactividad> participantes = tbPryParticipantexactividadService
				.findByActividad(actividadIdn);

		String asunto = getAsuntoNotificacionCreacionActividad();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		StringBuilder actividadNombre = new StringBuilder(
				actividad.getVrNombreactividad());
		String mensaje = getMensajeNotificacionCreacionActividadParticipante(
				proyectoNombre.toString(), actividadNombre.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexactividad participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarCancelacionProyectoParticipanteEmail(
			String usuarioNotifica, Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionCancelarProyecto();
		List<TbPryParticipantexproyecto> participantes = tbPryParticipantexproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionCancelacionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionCancelacionProyectoParticipante(
				proyectoNombre.toString(),
				proyecto.getVrJustificacioncancelacion());
		TbNtfNotificaciones notificacionAsesor = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexproyecto participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionAsesor, usuarioNotifica, mensaje, asunto,
						tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarCancelacionProyectoAsesorEmail(String usuarioNotifica,
			Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionCancelarProyecto();
		List<TbPryAsesorxproyecto> asesores = tbPryAsesorxproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionCancelacionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionCancelacionProyectoAsesor(
				proyectoNombre.toString(),
				proyecto.getVrJustificacioncancelacion());
		TbNtfNotificaciones notificacionAsesor = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryAsesorxproyecto asesor : asesores) {
			TbAdmUsuarios usuarioActual = asesor.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionAsesor, usuarioNotifica, mensaje, asunto,
						tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarSuspencionProyectoParticipanteEmail(
			String usuarioNotifica, Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionSuspenderProyecto();
		List<TbPryParticipantexproyecto> participantes = tbPryParticipantexproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionSuspencionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionSuspencionProyectoParticipante(
				proyectoNombre.toString(),
				proyecto.getVrJustificacionsuspencion());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());

		for (TbPryParticipantexproyecto participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}

		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarSuspencionProyectoAsesorEmail(String usuarioNotifica,
			Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionSuspenderProyecto();
		List<TbPryAsesorxproyecto> asesores = tbPryAsesorxproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionSuspencionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionSuspencionProyectoAsesor(
				proyectoNombre.toString(),
				proyecto.getVrJustificacionsuspencion());
		TbNtfNotificaciones notificacionAsesor = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryAsesorxproyecto asesor : asesores) {
			TbAdmUsuarios usuarioActual = asesor.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionAsesor, usuarioNotifica, mensaje, asunto,
						tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarModificacionProyectoParticipanteEmail(
			String usuarioNotifica, Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionActualizarProyecto();
		List<TbPryParticipantexproyecto> participantes = tbPryParticipantexproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionActualizacionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionActualizacionProyectoParticipante(proyectoNombre
				.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());

		for (TbPryParticipantexproyecto participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}

		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarModificacionProyectoAsesorEmail(
			String usuarioNotifica, Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionActualizarProyecto();
		List<TbPryAsesorxproyecto> asesores = tbPryAsesorxproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionActualizacionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionActualizacionProyectoAsesor(proyectoNombre
				.toString());
		TbNtfNotificaciones notificacionAsesor = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryAsesorxproyecto asesor : asesores) {
			TbAdmUsuarios usuarioActual = asesor.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionAsesor, usuarioNotifica, mensaje, asunto,
						tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarReanudacionProyectoParticipanteEmail(
			String usuarioNotifica, Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionReanudarProyecto();
		List<TbPryParticipantexproyecto> participantes = tbPryParticipantexproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionReanudacionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionReanudacionProyectoParticipante(proyectoNombre
				.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexproyecto participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarCreacionProyectoParticipanteEmail(
			String usuarioNotifica, Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionCrearProyecto();
		List<TbPryParticipantexproyecto> participantes = tbPryParticipantexproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionCreacionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionCreacionProyectoParticipante(proyectoNombre
				.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexproyecto participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarReanudacionProyectoAsesorEmail(String usuarioNotifica,
			Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionReanudarProyecto();
		List<TbPryAsesorxproyecto> asesores = tbPryAsesorxproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionReanudacionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionReanudacionProyectoAsesor(proyectoNombre
				.toString());
		TbNtfNotificaciones notificacionAsesor = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryAsesorxproyecto asesor : asesores) {
			TbAdmUsuarios usuarioActual = asesor.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionAsesor, usuarioNotifica, mensaje, asunto,
						tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionReanudacionProyecto() {
		// TODO Auto-generated method stub
		return "Notificación de reanudacion de proyecto";
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarCreacionProyectoAsesorEmail(String usuarioNotifica,
			Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionCrearProyecto();
		List<TbPryAsesorxproyecto> asesores = tbPryAsesorxproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionCreacionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionCreacionProyectoAsesor(proyectoNombre
				.toString());
		TbNtfNotificaciones notificacionAsesor = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryAsesorxproyecto asesor : asesores) {
			TbAdmUsuarios usuarioActual = asesor.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionAsesor, usuarioNotifica, mensaje, asunto,
						tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarFinalizacionProyectoParticipanteEmail(
			String usuarioNotifica, Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionFinalizarProyecto();
		List<TbPryParticipantexproyecto> participantes = tbPryParticipantexproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionFinalizacionProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionFinalizacionProyectoParticipante(proyectoNombre
				.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexproyecto participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}

		}
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @throws DaoException
	 */
	public void notificarVencimientoProyecto(String usuarioNotifica,
			Integer proyectoIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionVencimientoProyecto();
		List<TbPryParticipantexproyecto> participantes = tbPryParticipantexproyectoService
				.findByProyecto(proyectoIdn);

		String asunto = getAsuntoNotificacionVencimientoProyecto();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		String mensaje = getMensajeNotificacionVencimientoProyecto(proyectoNombre
				.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexproyecto participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}

	/**
	 * 
	 * @param proyectoNombre
	 * @return
	 */
	private String getMensajeNotificacionVencimientoProyecto(
			String proyectoNombre) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("El proyecto ");
		sb.append(proyectoNombre).append(" se ha vencido.");
		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	private String getAsuntoNotificacionVencimientoProyecto() {
		// TODO Auto-generated method stub
		return "Notificacion de vencimiento de proyecto";
	}

	/**
	 * 
	 * @param usuarioNotifica
	 * @param proyectoIdn
	 * @param actividadIdn
	 * @throws DaoException
	 */
	public void notificarVencimientoActividad(String usuarioNotifica,
			Integer proyectoIdn, Integer actividadIdn) throws DaoException {
		if (Validaciones.isTextoVacio(usuarioNotifica)) {
			throw new DaoException(
					"El usuario que notifica no puede ser nulo o vacio");
		}
		if (actividadIdn == null) {
			throw new DaoException(
					"El codigo de la actividad no puede ser nulo");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El proyecto no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if (actividad == null) {
			throw new DaoException("La actividad no existe en la base de datos");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto especificado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioNotifica);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que notifica no existe en la base de datos");
		}
		TbNtfTipontfs tipoNotificacion = tbNtfTipontfsService
				.getTipoNotificacionVencimientoActividad();
		List<TbPryParticipantexactividad> participantes = tbPryParticipantexactividadService
				.findByActividad(actividadIdn);

		String asunto = getAsuntoNotificacionVencimientoActividad();
		StringBuilder proyectoNombre = new StringBuilder(proyecto.getNbIdn()
				.toString());
		proyectoNombre.append(" ").append(proyecto.getVrNombreproyecto());
		StringBuilder actividadNombre = new StringBuilder(
				actividad.getVrNombreactividad());
		String mensaje = getMensajeNotificacionVencimientoActividad(
				proyectoNombre.toString(), actividadNombre.toString());
		TbNtfNotificaciones notificacionParticipante = tbNtfNotificacionesService
				.insert(usuarioNotifica, asunto, mensaje,
						tipoNotificacion.getNbIdn());
		for (TbPryParticipantexactividad participante : participantes) {
			TbAdmUsuarios usuarioActual = participante.getTbAdmUsuarios();
			TbNtfsTipontfsroles permiso = tbNtfsTipontfsrolesService
					.findByForeignKey(usuarioActual.getTbAdmRoles().getNbIdn(),
							tipoNotificacion.getNbIdn());
			if (permiso != null) {
				realizarNotificacion(permiso, usuarioActual,
						notificacionParticipante, usuarioNotifica, mensaje,
						asunto, tipoNotificacion);
			}
		}
	}



	/**
	 * 
	 * @param nbIdn
	 * @throws DaoException
	 */
	public void delete(Integer nbIdn) throws DaoException {
		TbNtfNtfsxusuario deleted = tbNtfNtfsxusuarioDAO.get(nbIdn);
		if (deleted != null) {
			tbNtfNtfsxusuarioDAO.delete(deleted);
		}
	}
}
