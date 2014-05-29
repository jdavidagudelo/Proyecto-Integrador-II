package co.edu.udea.proyectointegrador.service;

import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbNtfTipontfsDAO;
import co.edu.udea.proyectointegrador.dto.TbNtfTipontfs;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.properties.Properties;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfTipontfsService {
	private TbNtfTipontfsDAO tbNtfTipontfsDAO;
	private static final Properties properties = Properties.getInstance();
	public TbNtfTipontfsDAO getTbNtfTipontfsDAO() {
		return tbNtfTipontfsDAO;
	}

	public void setTbNtfTipontfsDAO(TbNtfTipontfsDAO tbNtfTipontfsDAO) {
		this.tbNtfTipontfsDAO = tbNtfTipontfsDAO;
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionCrearProyecto() throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionCreacionProyecto());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionActualizarProyecto()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionActualizacionProyecto());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionFinalizarProyecto()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionFinalizacionProyecto());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionCrearActividad()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionCreacionActividad());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionSuspenderProyecto()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionSuspencionProyecto());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionCancelarProyecto()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionCancelacionProyecto());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionActualizarActividad()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionActualizacionActividad());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionSuspenderActividad()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionSuspencionActividad());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionCancelarActividad()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionCancelacionActividad());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionReanudarProyecto()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionReanudacionProyecto());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionRealizarEntregable()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionRealizacionEntregable());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionFinalizarActividad()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionFinalizacionActividad());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionReanudarActividad()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionReanudacionActividad());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionVencimientoActividad()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionVencimientoActividad());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs getTipoNotificacionVencimientoProyecto()
			throws DaoException {
		return tbNtfTipontfsDAO
				.findTipoByNombre(properties.getTipoNotificacionVencimientoProyecto());
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfTipontfs> findAll() throws DaoException {
		return tbNtfTipontfsDAO.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbNtfTipontfs get(Integer id) throws DaoException {
		return tbNtfTipontfsDAO.get(id);
	}
}
