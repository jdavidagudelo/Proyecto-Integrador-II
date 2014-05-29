package co.edu.udea.proyectointegrador.properties;

import java.util.ResourceBundle;

/**
 * 
 * @author juan
 *
 */
public class Properties {

	private Properties()
	{
		
	}
	private static final Properties INSTANCE = new Properties();
	public static Properties getInstance()
	{
		return INSTANCE;
	}
	/**
	 * 
	 */
	public static final ResourceBundle CONFIGURATION_RESOURCES = ResourceBundle
			.getBundle("co.edu.udea.proyectointegrador.properties.configuration");

	/**
	 * 
	 * @return
	 */
	public String reportesTemporalFileName() {
		return CONFIGURATION_RESOURCES.getString("reportesTemporalFileName");
	}

	/**
	 * 
	 * @return
	 */
	public String databaseUrl() {
		return CONFIGURATION_RESOURCES.getString("databaseUrl");
	}

	/**
	 * 
	 * @return
	 */
	public String databasePassword() {
		return CONFIGURATION_RESOURCES.getString("databasePassword");
	}

	/**
	 * 
	 * @return
	 */
	public String databaseDriver() {
		return CONFIGURATION_RESOURCES.getString("databaseDriver");
	}

	/**
	 * 
	 * @return
	 */
	public String reporteProyectosGeneralJasperFilePath() {
		return CONFIGURATION_RESOURCES
				.getString("reporteProyectosGeneralJasperFilePath");
	}

	/**
	 * 
	 * @return
	 */
	public String databaseUser() {
		return CONFIGURATION_RESOURCES.getString("databaseUser");
	}

	/**
	 * 
	 * @return
	 */
	public String reporteActividadesProyectoJasperFilePath() {
		return CONFIGURATION_RESOURCES
				.getString("reporteActividadesProyectoJasperFilePath");
	}

	/**
	 * 
	 * @return
	 */
	public String reporteActividadesProyectoProyectoIdParam() {
		return CONFIGURATION_RESOURCES
				.getString("reporteActividadesProyectoProyectoIdParam");
	}

	/**
	 * 
	 * @return
	 */
	public String rtfFormatExtension() {
		return CONFIGURATION_RESOURCES.getString("rtfFormatExtension");
	}

	/**
	 * 
	 * @return
	 */
	public String pdfFormatExtension() {
		return CONFIGURATION_RESOURCES.getString("pdfFormatExtension");
	}

	/**
	 * 
	 * @return
	 */
	public String docxFormatExtension() {
		return CONFIGURATION_RESOURCES.getString("docxFormatExtension");
	}

	/**
	 * 
	 * @return
	 */
	public String odtFormatExtension() {
		return CONFIGURATION_RESOURCES.getString("odtFormatExtension");
	}

	/**
	 * 
	 * @return
	 */
	public String xslFormatExtension() {
		return CONFIGURATION_RESOURCES.getString("xslFormatExtension");
	}

	/**
	 * 
	 * @return
	 */
	public String htmlFormatExtension() {
		return CONFIGURATION_RESOURCES.getString("htmlFormatExtension");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisoCrearProyecto() {
		return CONFIGURATION_RESOURCES.getString("permisos.crearproyecto");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisoListarTipoNotificacion() {
		return CONFIGURATION_RESOURCES
				.getString("permisos.listartiponotificacion");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisoEspecificarNotificaciones() {
		return CONFIGURATION_RESOURCES
				.getString("permisos.especificarnotificaciones");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisoPermisosProyectos() {
		return CONFIGURATION_RESOURCES.getString("permisos.permisosproyectos");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisoPermisosActividades() {
		return CONFIGURATION_RESOURCES
				.getString("permisos.permisosactividades");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisoCrearUsuario() {
		return CONFIGURATION_RESOURCES.getString("permisos.crearusuario");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisoListarProyectos() {
		return CONFIGURATION_RESOURCES.getString("permisos.listarproyectos");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisoModificarUsuario() {
		return CONFIGURATION_RESOURCES.getString("permisos.modificarusuario");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisoListarNotificaciones() {
		return CONFIGURATION_RESOURCES
				.getString("permisos.listarnotificaciones");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisosListarReportes() {

		return CONFIGURATION_RESOURCES.getString("permisos.listarreportes");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisosListarPermisos() {

		return CONFIGURATION_RESOURCES.getString("permisos.listarpermisos");
	}

	/**
	 * 
	 * @return
	 */
	public String getPermisosListarRoles() {
		return CONFIGURATION_RESOURCES.getString("permisos.listarroles");
	}

	/**
	 * 
	 * @return
	 */
	public String reporteCantidadProyectosJasperFilePath() {
		return CONFIGURATION_RESOURCES
				.getString("reporteCantidadProyectosJasperFilePath");
	}

	/**
	 * 
	 * @return
	 */
	public String reporteCantidadActividadesJasperFilePath() {
		return CONFIGURATION_RESOURCES
				.getString("reporteCantidadActividadesJasperFilePath");
	}

	/**
	 * 
	 * @return
	 */
	public String reporteProyectosParticipanteJasperFilePath() {
		return CONFIGURATION_RESOURCES
				.getString("reporteProyectosParticipanteJasperFilePath");
	}

	/**
	 * 
	 * @return
	 */
	public String reporteActividadesProyectoProyectoNombreParam() {
		return CONFIGURATION_RESOURCES
				.getString("reporteActividadesProyectoProyectoNombreParam");
	}

	/**
	 * 
	 * @return
	 */
	public String reporteProyectosParticipanteIdParam() {
		return CONFIGURATION_RESOURCES
				.getString("reporteProyectosParticipanteIdParam");
	}
	
	public String reporteCantidadActividadesProyectoJasperFilePath()
	{
		return CONFIGURATION_RESOURCES.getString("reporteCantidadActividadesProyectoJasperFilePath");
	}
	public String reporteCantidadActividadesProyectoProyectoIdParam()
	{
		return CONFIGURATION_RESOURCES.getString("reporteCantidadActividadesProyectoProyectoIdParam");
	}
	public String reporteCantidadActividadesProyectoProyectoNombreParam()
	{
		return CONFIGURATION_RESOURCES.getString("reporteCantidadActividadesProyectoProyectoNombreParam");
	}
	public String getPermisoSuperUsuario()
	{
		return CONFIGURATION_RESOURCES.getString("permisos.superusuario");
	}
	public String getRolAsesor()
	{
		return CONFIGURATION_RESOURCES.getString("rol.asesor");
	}
	public String getRolParticipante()
	{
		return CONFIGURATION_RESOURCES.getString("rol.participante");
	}
	public String getRolResponsable()
	{
		return CONFIGURATION_RESOURCES.getString("rol.responsable");
	}
	public String getRolSuperUsuario()
	{
		return CONFIGURATION_RESOURCES.getString("rol.superusuario");
	}
	public String getPermisoTipoProyecto()
	{
		return CONFIGURATION_RESOURCES.getString("permiso.tipo.proyecto");
	}
	public String getPermisoTipoActividad()
	{
		return CONFIGURATION_RESOURCES.getString("permiso.tipo.actividad");
	}
	public String getPermisoTipoGeneral()
	{
		return CONFIGURATION_RESOURCES.getString("permiso.tipo.general");
	}
	public String getMedioNotificacionEmail()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.medio.email");
	}
	public String getMedioNotificacionSms()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.medio.sms");
	}
	public String getTipoNotificacionCreacionProyecto()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.creacionproyecto");
	}
	public String getTipoNotificacionActualizacionProyecto()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.actualizacionproyecto");
	}
	public String getTipoNotificacionRealizacionEntregable()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.realizacionentregable");
	}
	public String getTipoNotificacionFinalizacionProyecto()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.finalizacionproyecto");
	}
	public String getTipoNotificacionCreacionActividad()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.creacionactividad");
	}
	public String getTipoNotificacionSuspencionProyecto()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.suspencionproyecto");
	}
	public String getTipoNotificacionCancelacionProyecto()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.cancelacionproyecto");
	}
	public String getTipoNotificacionActualizacionActividad()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.actualizacionactividad");
	}
	public String getTipoNotificacionSuspencionActividad()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.suspencionactividad");
	}
	public String getTipoNotificacionCancelacionActividad()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.cancelacionactividad");
	}
	public String getTipoNotificacionReanudacionProyecto()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.reanudacionproyecto");
	}
	public String getTipoNotificacionFinalizacionActividad()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.finalizacionactividad");
	}
	public String getTipoNotificacionReanudacionActividad()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.reanudacionactividad");
	}
	public String getTipoNotificacionVencimientoProyecto()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.vencimientoproyecto");
	}
	public String getTipoNotificacionVencimientoActividad()
	{
		return CONFIGURATION_RESOURCES.getString("notificacion.tipo.vencimientoactividad");
	}
	public String getEstadoProyectoAbierto()
	{
		return CONFIGURATION_RESOURCES.getString("proyecto.estado.abierto");
	}
	public String getEstadoProyectoEnProceso()
	{
		return CONFIGURATION_RESOURCES.getString("proyecto.estado.enproceso");
	}
	public String getEstadoProyectoCancelado()
	{

		return CONFIGURATION_RESOURCES.getString("proyecto.estado.cancelado");
	}
	public String getEstadoProyectoSuspendido()
	{

		return CONFIGURATION_RESOURCES.getString("proyecto.estado.suspendido");
	}
	public String getEstadoProyectoVencido()
	{
		return CONFIGURATION_RESOURCES.getString("proyecto.estado.vencido");
	}
	public String getEstadoProyectoReanudado()
	{

		return CONFIGURATION_RESOURCES.getString("proyecto.estado.reanudado");
	}
	public String getEstadoProyectoFinalizado()
	{

		return CONFIGURATION_RESOURCES.getString("proyecto.estado.finalizado");
	}
	public String getEstadoActividadAbierto()
	{
		return CONFIGURATION_RESOURCES.getString("proyecto.estado.abierto");
	}
	public String getEstadoActividadEnProceso()
	{
		return CONFIGURATION_RESOURCES.getString("proyecto.estado.enproceso");
	}
	public String getEstadoActividadCancelado()
	{

		return CONFIGURATION_RESOURCES.getString("proyecto.estado.cancelado");
	}
	public String getEstadoActividadSuspendido()
	{

		return CONFIGURATION_RESOURCES.getString("proyecto.estado.suspendido");
	}
	public String getEstadoActividadVencido()
	{
		return CONFIGURATION_RESOURCES.getString("proyecto.estado.vencido");
	}
	public String getEstadoActividadReanudado()
	{

		return CONFIGURATION_RESOURCES.getString("proyecto.estado.reanudado");
	}
	public String getEstadoActividadFinalizado()
	{

		return CONFIGURATION_RESOURCES.getString("proyecto.estado.finalizado");
	}
	public String getEstadoActividadVerificado()
	{

		return CONFIGURATION_RESOURCES.getString("actividad.estado.verificado");
	}
}
