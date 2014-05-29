package co.edu.udea.proyectointegrador.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.properties.Properties;

/**
 * Clase utilizada para crear los reportes utilizados por la aplicacion
 * 
 * @author juan
 * 
 */
public class TbPryReportesService {
	private static final Properties properties = Properties.getInstance();
	private TbPryProyectosService tbPryProyectosService;

	public TbPryProyectosService getTbPryProyectosService() {
		return tbPryProyectosService;
	}

	public void setTbPryProyectosService(
			TbPryProyectosService tbPryProyectosService) {
		this.tbPryProyectosService = tbPryProyectosService;
	}

	/**
	 * Metodo usado para obtener el exportador asociado con el formato ingresado
	 * como argumento.
	 * 
	 * @param format
	 *            el formato del archivo.
	 * @return exportador para el formato ingresado como argumento
	 */
	public static JRAbstractExporter getExporterForFormat(String format) {
		if (properties.docxFormatExtension().equals(format)) {
			return new JRDocxExporter();
		}
		if (properties.rtfFormatExtension().equals(format)) {
			return new JRRtfExporter();
		}
		if (properties.xslFormatExtension().equals(format)) {
			return new JRXlsExporter();
		}
		if (properties.odtFormatExtension().equals(format)) {
			return new JROdtExporter();
		}
		if (properties.htmlFormatExtension().equals(format)) {
			return new JRHtmlExporter();
		}
		if (properties.pdfFormatExtension().equals(format)) {
			return new JRPdfExporter();
		}
		return null;
	}

	/**
	 * Metodo usado para obtener el reporte de proyectos
	 * 
	 * @param format
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JRException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosParticipante(String format)
			throws ClassNotFoundException, SQLException, JRException,
			FileNotFoundException, IOException, DaoException {
		Class.forName(properties.databaseDriver());
		Connection con = DriverManager.getConnection(properties.databaseUrl(),
				properties.databaseUser(), properties.databasePassword());
		HashMap<String, Object> params = new HashMap<String, Object>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				properties.reporteProyectosParticipanteJasperFilePath(),
				params, con);
		JRAbstractExporter exporter = getExporterForFormat(format);
		File temporal = new File(properties.reportesTemporalFileName());
		if (temporal.exists()) {
			temporal.delete();
		}
		temporal = new File(properties.reportesTemporalFileName());
		if (temporal.createNewFile()) {
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, temporal);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.exportReport();
			FileInputStream fis = new FileInputStream(temporal);
			byte[] data = new byte[(int) temporal.length()];
			fis.read(data);
			fis.close();
			return data;
		} else {
			throw new DaoException("Error al generar el reporte");
		}
	}

	/**
	 * 
	 * @param format
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JRException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividades(String format)
			throws ClassNotFoundException, SQLException, JRException,
			FileNotFoundException, IOException, DaoException {
		Class.forName(properties.databaseDriver());
		Connection con = DriverManager.getConnection(properties.databaseUrl(),
				properties.databaseUser(), properties.databasePassword());
		HashMap<String, Object> params = new HashMap<String, Object>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				properties.reporteCantidadActividadesJasperFilePath(), params,
				con);
		JRAbstractExporter exporter = getExporterForFormat(format);
		File temporal = new File(properties.reportesTemporalFileName());
		if (temporal.exists()) {
			temporal.delete();
		}
		temporal = new File(properties.reportesTemporalFileName());
		if (temporal.createNewFile()) {
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, temporal);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.exportReport();
			FileInputStream fis = new FileInputStream(temporal);
			byte[] data = new byte[(int) temporal.length()];
			fis.read(data);
			fis.close();
			return data;
		} else {
			throw new DaoException("Error al generar el reporte");
		}
	}

	/**
	 * 
	 * @param format
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JRException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadProyectos(String format)
			throws ClassNotFoundException, SQLException, JRException,
			FileNotFoundException, IOException, DaoException {
		Class.forName(properties.databaseDriver());
		Connection con = DriverManager.getConnection(properties.databaseUrl(),
				properties.databaseUser(), properties.databasePassword());
		HashMap<String, Object> params = new HashMap<String, Object>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				properties.reporteCantidadProyectosJasperFilePath(), params,
				con);
		JRAbstractExporter exporter = getExporterForFormat(format);
		File temporal = new File(properties.reportesTemporalFileName());
		if (temporal.exists()) {
			temporal.delete();
		}
		temporal = new File(properties.reportesTemporalFileName());
		if (temporal.createNewFile()) {
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, temporal);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.exportReport();
			FileInputStream fis = new FileInputStream(temporal);
			byte[] data = new byte[(int) temporal.length()];
			fis.read(data);
			fis.close();
			return data;
		} else {
			throw new DaoException("Error al generar el reporte");
		}
	}
	/**
	 * 
	 * @param format
	 * @param proyectoIdn
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesProyecto(String format,
			Integer proyectoIdn) throws SQLException, ClassNotFoundException,
			JRException, IOException, DaoException {
		Class.forName(properties.databaseDriver());
		Connection con = DriverManager.getConnection(properties.databaseUrl(),
				properties.databaseUser(), properties.databasePassword());
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put(properties.reporteCantidadActividadesProyectoProyectoIdParam(),
				proyectoIdn);
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		params.put(properties.reporteCantidadActividadesProyectoProyectoNombreParam(),
				proyecto.getVrNombreproyecto());
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				properties.reporteCantidadActividadesProyectoJasperFilePath(), params,
				con);
		JRAbstractExporter exporter = getExporterForFormat(format);
		File temporal = new File(properties.reportesTemporalFileName());
		if (temporal.exists()) {
			temporal.delete();
		}
		temporal = new File(properties.reportesTemporalFileName());
		if (temporal.createNewFile()) {
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, temporal);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.exportReport();
			FileInputStream fis = new FileInputStream(temporal);
			byte[] data = new byte[(int) temporal.length()];
			fis.read(data);
			fis.close();
			return data;
		} else {
			throw new DaoException("Error al generar el reporte");
		}
	}

	/**
	 * 
	 * @param format
	 * @param proyectoIdn
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarActividadesProyecto(String format,
			Integer proyectoIdn) throws SQLException, ClassNotFoundException,
			JRException, IOException, DaoException {
		Class.forName(properties.databaseDriver());
		Connection con = DriverManager.getConnection(properties.databaseUrl(),
				properties.databaseUser(), properties.databasePassword());
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put(properties.reporteActividadesProyectoProyectoIdParam(),
				proyectoIdn);
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		params.put(properties.reporteActividadesProyectoProyectoNombreParam(),
				proyecto.getVrNombreproyecto());
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				properties.reporteActividadesProyectoJasperFilePath(), params,
				con);
		JRAbstractExporter exporter = getExporterForFormat(format);
		File temporal = new File(properties.reportesTemporalFileName());
		if (temporal.exists()) {
			temporal.delete();
		}
		temporal = new File(properties.reportesTemporalFileName());
		if (temporal.createNewFile()) {
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, temporal);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.exportReport();
			FileInputStream fis = new FileInputStream(temporal);
			byte[] data = new byte[(int) temporal.length()];
			fis.read(data);
			fis.close();
			return data;
		} else {
			throw new DaoException("Error al generar el reporte");
		}
	}

	/**
	 * 
	 * @param format
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectos(String format) throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		Class.forName(properties.databaseDriver());
		Connection con = DriverManager.getConnection(properties.databaseUrl(),
				properties.databaseUser(), properties.databasePassword());
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				properties.reporteProyectosGeneralJasperFilePath(),
				new HashMap<String, Object>(), con);
		JRAbstractExporter exporter = getExporterForFormat(format);
		File temporal = new File(properties.reportesTemporalFileName());
		if (temporal.exists()) {
			temporal.delete();
		}
		temporal = new File(properties.reportesTemporalFileName());
		if (temporal.createNewFile()) {
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, temporal);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.exportReport();
			FileInputStream fis = new FileInputStream(temporal);
			byte[] data = new byte[(int) temporal.length()];
			fis.read(data);
			fis.close();
			return data;
		} else {
			throw new DaoException("Error al generar el reporte");
		}
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosParticipantePDF()
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarProyectosParticipante(properties
				.pdfFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosParticipanteRTF()
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarProyectosParticipante(properties
				.rtfFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosParticipanteODT()
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarProyectosParticipante(properties
				.odtFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosParticipanteDOCX()
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarProyectosParticipante(properties
				.docxFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosParticipanteHTML()
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarProyectosParticipante(properties
				.htmlFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosParticipanteXSL()
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarProyectosParticipante(properties
				.xslFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesProyectoPDF(Integer proyectoIdn) throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadActividadesProyecto(properties
				.pdfFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesProyectoRTF(Integer proyectoIdn) throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadActividadesProyecto(properties
				.rtfFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesProyectoODT(Integer proyectoIdn) throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadActividadesProyecto(properties
				.odtFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesProyectoDOCX(Integer proyectoIdn)
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarCantidadActividadesProyecto(properties
				.docxFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesProyectoHTML(Integer proyectoIdn)
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarCantidadActividadesProyecto(properties
				.htmlFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesProyectoXSL(Integer proyectoIdn) throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadActividadesProyecto(properties
				.xslFormatExtension(), proyectoIdn);
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesPDF() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadActividades(properties
				.pdfFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesRTF() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadActividades(properties
				.rtfFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesODT() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadActividades(properties
				.odtFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesDOCX()
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarCantidadActividades(properties
				.docxFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesHTML()
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarCantidadActividades(properties
				.htmlFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadActividadesXSL() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadActividades(properties
				.xslFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadProyectosPDF() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadProyectos(properties
				.pdfFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadProyectosRTF() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadProyectos(properties
				.rtfFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadProyectosODT() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadProyectos(properties
				.odtFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadProyectosDOCX() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadProyectos(properties
				.docxFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadProyectosHTML() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadProyectos(properties
				.htmlFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarCantidadProyectosXSL() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarCantidadProyectos(properties
				.xslFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosPDF() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarProyectos(properties.pdfFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosRTF() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarProyectos(properties.rtfFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosODT() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarProyectos(properties.odtFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosDOCX() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {

		return getReporteListarProyectos(properties.docxFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosHTML() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {
		return getReporteListarProyectos(properties.htmlFormatExtension());
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarProyectosXSL() throws SQLException,
			ClassNotFoundException, JRException, IOException, DaoException {

		return getReporteListarProyectos(properties.xslFormatExtension());
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarActividadesProyectoPDF(Integer proyectoIdn)
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarActividadesProyecto(
				properties.pdfFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarActividadesProyectoRTF(Integer proyectoIdn)
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarActividadesProyecto(
				properties.rtfFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarActividadesProyectoODT(Integer proyectoIdn)
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarActividadesProyecto(
				properties.odtFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarActividadesProyectoDOCX(Integer proyectoIdn)
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarActividadesProyecto(
				properties.docxFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarActividadesProyectoHTML(Integer proyectoIdn)
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarActividadesProyecto(
				properties.htmlFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JRException
	 * @throws IOException
	 * @throws DaoException
	 */
	public byte[] getReporteListarActividadesProyectoXSL(Integer proyectoIdn)
			throws SQLException, ClassNotFoundException, JRException,
			IOException, DaoException {
		return getReporteListarActividadesProyecto(
				properties.xslFormatExtension(), proyectoIdn);
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getFormatos() {
		List<String> formatos = new ArrayList<String>();
		formatos.add(properties.pdfFormatExtension());
		formatos.add(properties.rtfFormatExtension());
		formatos.add(properties.htmlFormatExtension());
		formatos.add(properties.docxFormatExtension());
		formatos.add(properties.xslFormatExtension());
		formatos.add(properties.odtFormatExtension());
		return formatos;
	}
}
