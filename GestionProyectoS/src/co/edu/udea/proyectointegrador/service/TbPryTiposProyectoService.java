package co.edu.udea.proyectointegrador.service;

import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryTiposProyectoDAO;
import co.edu.udea.proyectointegrador.dto.TbPryTiposproyecto;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * Clase usada para acceder a la tabla de tipos de proyectos de la base de
 * datos.
 * 
 * @author juan
 * 
 */
public class TbPryTiposProyectoService {
	private TbPryTiposProyectoDAO tbPryTiposProyectoDAO;

	public TbPryTiposProyectoDAO getTbPryTiposProyectoDAO() {
		return tbPryTiposProyectoDAO;
	}

	public void setTbPryTiposProyectoDAO(
			TbPryTiposProyectoDAO tbPryTiposProyectoDAO) {
		this.tbPryTiposProyectoDAO = tbPryTiposProyectoDAO;
	}

	/**
	 * Metodo usado para obtener todos los tipos de proyectos de la base de
	 * datos
	 * 
	 * @return lista de tipos de proyectos
	 * @throws DaoException
	 */
	public List<TbPryTiposproyecto> findAll() throws DaoException {
		return tbPryTiposProyectoDAO.findAll();
	}

	/**
	 * Metodo que permite obtener el proyecto con el id ingresado como
	 * argumento.
	 * 
	 * @param id
	 *            el id del tipo de proyecto.
	 * @return tipo de proyecto con el id ingresado como argumento
	 * @throws DaoException
	 */
	public TbPryTiposproyecto get(Integer id) throws DaoException {
		if (id == null) {
			throw new DaoException(
					"El id del tipo de proyecto no puede ser nulo");
		}
		TbPryTiposproyecto tipoProyecto = tbPryTiposProyectoDAO.get(id);
		if (tipoProyecto == null) {
			throw new DaoException(
					"El tipo de proyecto no existe en la base de datos");
		}
		return tipoProyecto;
	}
}
