package co.edu.udea.proyectointegrador.util.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase para validaciones en general del sistema.
 * 
 * @author Juan David Agudelo jdaa2009@gmail.com
 */
public class Validaciones {

	/**
	 * Valida que el correo electr�nico establecido como par�metro sea un correo
	 * electr�nico con formato v�lido
	 * 
	 * @param correo
	 *            texto con el correo electr�nico a validar
	 * @return true si el texto tiene un formato de correo electr�nico v�lido,
	 *         de lo contrario retorna false
	 */
	public static boolean isEmail(String correo) {
		Pattern pat = null;
		Matcher mat = null;

		pat = Pattern
				.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

		if (isTextoVacio(correo))
			return false;

		mat = pat.matcher(correo);
		if (mat.find()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Valida que el texto ingresado sea un texto considerado vacio, para ser
	 * considerado vacio debe ser nulo o una cadena de caracteres vacia
	 * 
	 * @param texto
	 *            texto a validar
	 * @return true, si el texto ingresado es nulo o vacio, de lo contrario
	 *         false
	 */
	public static boolean isTextoVacio(String texto) {
		if (null == texto)
			return true;
		texto = texto.trim();
		if ("".equals(texto)) {
			return true;
		}
		return false;
	}

	/**
	 * Permite comprobar si dos strings ingresados como argumento corresponden
	 * al mismo correo electronico.
	 * 
	 * @param correo1
	 *            un correo electronico que se desea comparar.
	 * @param correo2
	 *            un correo electronico.
	 * @return True si los correos electronicos son iguales, false en caso
	 *         contrario
	 * */
	public static Boolean confirmarCorreoElectronico(String correo1,
			String correo2) {
		Boolean confirmacion = Validaciones.isEmail(correo1)
				&& Validaciones.isEmail(correo2) && correo1.equals(correo2);
		return confirmacion;
	}

	public static Boolean isValidObjetivoGeneralProyecto(String objetivoGeneral) {
		if (objetivoGeneral == null || objetivoGeneral.isEmpty()) {
			return Boolean.FALSE;
		}
		if (objetivoGeneral.length() > 256) {
			return Boolean.FALSE;
		}
		if (!objetivoGeneral
				.matches("[a-zA-ZáÁéÉíÍóÓúÚñÑ][a-zA-Z0-9áÁéÉíÍóÓúÚñÑ .,;:\n]*")) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public static Boolean isValidCalificacionProyecto(String calificacion) {
		if (calificacion == null || calificacion.isEmpty()) {
			return Boolean.FALSE;
		}
		if (calificacion.length() > 16) {
			return Boolean.FALSE;
		}
		if (!"aprobo".equals(calificacion) && !"desaprobo".equals(calificacion)) {
			if (!calificacion
					.matches("[0-4]([.][0-9]?[0-9]?)?|[5]([.][0]?[0]?)?")) {

				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
	public static Boolean isValidJustificacionSuspencionProyecto(String justificacionSuspencion) {
		if (justificacionSuspencion == null || justificacionSuspencion.isEmpty()) {
			return Boolean.FALSE;
		}
		if (justificacionSuspencion.length() > 128) {
			return Boolean.FALSE;
		}
		if (!justificacionSuspencion
				.matches("[a-zA-ZáÁéÉíÍóÓúÚñÑ][a-zA-Z0-9áÁéÉíÍóÓúÚñÑ .,;:\n]*")) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	public static Boolean isValidReconocimientoProyecto(String reconocimiento) {
		if (reconocimiento == null || reconocimiento.isEmpty()) {
			return Boolean.FALSE;
		}
		if (reconocimiento.length() > 128) {
			return Boolean.FALSE;
		}
		if (!reconocimiento
				.matches("[a-zA-ZáÁéÉíÍóÓúÚñÑ][a-zA-Z0-9áÁéÉíÍóÓúÚñÑ .,;:\n]*")) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	public static Boolean isValidJustificacionCancelacionProyecto(String justificacionCancelacion) {
		if (justificacionCancelacion == null || justificacionCancelacion.isEmpty()) {
			return Boolean.FALSE;
		}
		if (justificacionCancelacion.length() > 128) {
			return Boolean.FALSE;
		}
		if (!justificacionCancelacion
				.matches("[a-zA-ZáÁéÉíÍóÓúÚñÑ][a-zA-Z0-9áÁéÉíÍóÓúÚñÑ .,;:\n]*")) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	public static Boolean isValidNombreProyecto(String nombreProyecto) {
		if (nombreProyecto == null || nombreProyecto.isEmpty()) {
			return Boolean.FALSE;
		}
		if (nombreProyecto.length() > 128) {
			return Boolean.FALSE;
		}
		if (!nombreProyecto
				.matches("[a-zA-ZáÁéÉíÍóÓúÚñÑ][a-zA-Z0-9áÁéÉíÍóÓúÚñÑ .,;:]*")) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
