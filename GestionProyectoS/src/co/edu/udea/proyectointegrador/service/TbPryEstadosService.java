package co.edu.udea.proyectointegrador.service;

import java.util.List;
import co.edu.udea.proyectointegrador.dao.TbPryEstadosDAO;
import co.edu.udea.proyectointegrador.dto.TbPryEstados;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.properties.Properties;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbPryEstadosService {
	private TbPryEstadosDAO tbPryEstadosDAO;
	private static final Properties properties = Properties.getInstance();
	public TbPryEstadosDAO getTbPryEstadosDAO() {
		return tbPryEstadosDAO;
	}

	public void setTbPryEstadosDAO(TbPryEstadosDAO tbPryEstadosDAO) {
		this.tbPryEstadosDAO = tbPryEstadosDAO;
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryEstados> findAll() throws DaoException {
		return tbPryEstadosDAO.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados get(Integer id) throws DaoException {
		return tbPryEstadosDAO.get(id);
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados getEstadoFinalizado() throws DaoException {
		return tbPryEstadosDAO
				.findEstadoByNombre(properties.getEstadoProyectoFinalizado());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados getEstadoReanudado() throws DaoException {
		return tbPryEstadosDAO
				.findEstadoByNombre(properties.getEstadoProyectoReanudado());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados getEstadoVencido() throws DaoException {
		return tbPryEstadosDAO
				.findEstadoByNombre(properties.getEstadoProyectoVencido());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados getEstadoCancelado() throws DaoException {
		return tbPryEstadosDAO
				.findEstadoByNombre(properties.getEstadoProyectoCancelado());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados getEstadoSuspendido() throws DaoException {
		return tbPryEstadosDAO
				.findEstadoByNombre(properties.getEstadoProyectoSuspendido());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados getEstadoEnProceso() throws DaoException {
		return tbPryEstadosDAO
				.findEstadoByNombre(properties.getEstadoProyectoEnProceso());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados getEstadoAbierto() throws DaoException {
		return tbPryEstadosDAO
				.findEstadoByNombre(properties.getEstadoProyectoAbierto());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados getEstadoInicialProyecto() throws DaoException {
		return tbPryEstadosDAO
				.findEstadoByNombre(properties.getEstadoProyectoAbierto());
	}

	/**
	 * 
	 * @param nombreEstado
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados findEstadoByNombre(String nombreEstado)
			throws DaoException {
		if (Validaciones.isTextoVacio(nombreEstado)) {
			throw new DaoException(
					"El nombre del estado no puede ser nulo o vacio");
		}
		return tbPryEstadosDAO.findEstadoByNombre(nombreEstado);
	}

}
