package co.edu.udea.proyectointegrador.service;

import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryEstadosactividadDAO;
import co.edu.udea.proyectointegrador.dto.TbPryEstadosactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.properties.Properties;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbPryEstadosactividadService {

	private TbPryEstadosactividadDAO tbPryEstadosactividadDAO;
	private Properties properties = Properties.getInstance();
	public TbPryEstadosactividadDAO getTbPryEstadosactividadDAO() {
		return tbPryEstadosactividadDAO;
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad getEstadoVerificado() throws DaoException {
		return tbPryEstadosactividadDAO
				.findEstadoByNombre(properties.getEstadoActividadVerificado());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad getEstadoFinalizado() throws DaoException {
		return tbPryEstadosactividadDAO
				.findEstadoByNombre(properties.getEstadoActividadFinalizado());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad getEstadoReanudado() throws DaoException {
		return tbPryEstadosactividadDAO
				.findEstadoByNombre(properties.getEstadoActividadReanudado());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad getEstadoVencido() throws DaoException {
		return tbPryEstadosactividadDAO
				.findEstadoByNombre(properties.getEstadoActividadVencido());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad getEstadoCancelado() throws DaoException {
		return tbPryEstadosactividadDAO
				.findEstadoByNombre(properties.getEstadoActividadCancelado());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad getEstadoSuspendido() throws DaoException {
		return tbPryEstadosactividadDAO
				.findEstadoByNombre(properties.getEstadoActividadSuspendido());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad getEstadoEnProceso() throws DaoException {
		return tbPryEstadosactividadDAO
				.findEstadoByNombre(properties.getEstadoActividadEnProceso());
	}

	public TbPryEstadosactividad getEstadoAbierto() throws DaoException {
		return tbPryEstadosactividadDAO
				.findEstadoByNombre(properties.getEstadoActividadAbierto());
	}

	public void setTbPryEstadosactividadDAO(
			TbPryEstadosactividadDAO tbPryEstadosactividadDAO) {
		this.tbPryEstadosactividadDAO = tbPryEstadosactividadDAO;
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad getEstadoInicialActividad()
			throws DaoException {
		return tbPryEstadosactividadDAO
				.findEstadoByNombre(properties.getEstadoActividadAbierto());
	}

	/**
	 * 
	 * @param estado
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad findEstadoByNombre(String estado)
			throws DaoException {
		if (Validaciones.isTextoVacio(estado)) {
			throw new DaoException(
					"El estado de la actividad no puede ser nulo o vacio");
		}
		return tbPryEstadosactividadDAO.findEstadoByNombre(estado);
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryEstadosactividad> findAll() throws DaoException {
		return tbPryEstadosactividadDAO.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad get(Integer id) throws DaoException {
		return tbPryEstadosactividadDAO.get(id);
	}
}
