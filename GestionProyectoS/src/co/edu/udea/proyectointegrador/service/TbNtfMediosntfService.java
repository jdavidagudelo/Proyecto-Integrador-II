package co.edu.udea.proyectointegrador.service;

import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbNtfMediosntfDAO;
import co.edu.udea.proyectointegrador.dto.TbNtfMediosntf;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.properties.Properties;

/**
 * Clase usada para obtener los medios de comunicacion de las notificaciones
 * 
 * @author juan
 * 
 */
public class TbNtfMediosntfService {
	private TbNtfMediosntfDAO tbNtfMediosntfDAO;
	private static final Properties properties = Properties.getInstance();
	public TbNtfMediosntfDAO getTbNtfMediosntfDAO() {
		return tbNtfMediosntfDAO;
	}

	public void setTbNtfMediosntfDAO(TbNtfMediosntfDAO tbNtfMediosntfDAO) {
		this.tbNtfMediosntfDAO = tbNtfMediosntfDAO;
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbNtfMediosntf> findAll() throws DaoException {
		return tbNtfMediosntfDAO.findAll();
	}

	/**
	 * Metodo que permite obtener el medio con el id ingresado como argumento
	 * 
	 * @param id
	 *            id del medio
	 * @return el medio con el id ingresado como argumento
	 * @throws DaoException
	 */
	public TbNtfMediosntf get(Integer id) throws DaoException {
		if (id == null) {
			throw new DaoException("El id del medio no puede ser nulo");
		}
		TbNtfMediosntf medio = tbNtfMediosntfDAO.get(id);
		if (medio == null) {
			throw new DaoException("El medio no existe en la base de datos");
		}
		return medio;
	}

	/**
	 * Metodo que permite obtener el medio email
	 * 
	 * @return el medio de email
	 * @throws DaoException
	 */
	public TbNtfMediosntf getMedioEmail() throws DaoException {
		return tbNtfMediosntfDAO
				.findMedioByNombre(properties.getMedioNotificacionEmail());
	}

	/**
	 * Metodo que permite obtener el medio sms
	 * 
	 * @return el medio de sms
	 * @throws DaoException
	 */
	public TbNtfMediosntf getMedioSms() throws DaoException {
		return tbNtfMediosntfDAO
				.findMedioByNombre(properties.getMedioNotificacionSms());
	}
}
