package co.edu.udea.proyectointegrador.service;

import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryModalidadesDAO;
import co.edu.udea.proyectointegrador.dto.TbPryModalidades;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryModalidadesService {
	private TbPryModalidadesDAO tbPryModalidadesDAO;

	public TbPryModalidadesDAO getTbPryModalidadesDAO() {
		return tbPryModalidadesDAO;
	}

	public void setTbPryModalidadesDAO(TbPryModalidadesDAO tbPryModalidadesDAO) {
		this.tbPryModalidadesDAO = tbPryModalidadesDAO;
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryModalidades> findAll() throws DaoException {
		return tbPryModalidadesDAO.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TbPryModalidades get(Integer id) throws DaoException {
		return tbPryModalidadesDAO.get(id);
	}
}
