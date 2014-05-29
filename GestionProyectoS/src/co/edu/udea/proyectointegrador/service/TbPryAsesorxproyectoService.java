package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryAsesorxproyectoDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryAsesorxproyecto;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.exception.AlreadyExistsException;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

/**
 * 
 * @author juan
 * 
 */
public class TbPryAsesorxproyectoService {
	private TbPryAsesorxproyectoDAO tbPryAsesorxproyectoDAO;
	private TbPryProyectosService tbPryProyectosService;
	private TbAdmUsuariosService tbAdmUsuariosService;

	public TbPryProyectosService getTbPryProyectosService() {
		return tbPryProyectosService;
	}

	public void setTbPryProyectosService(
			TbPryProyectosService tbPryProyectosService) {
		this.tbPryProyectosService = tbPryProyectosService;
	}

	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}

	public void setTbAdmUsuariosService(
			TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}

	/**
	 * 
	 * @param nbIdn
	 * @throws DaoException
	 */
	public void delete(Integer nbIdn) throws DaoException {
		TbPryAsesorxproyecto deleted = tbPryAsesorxproyectoDAO.get(nbIdn);
		if (deleted != null) {
			tbPryAsesorxproyectoDAO.delete(deleted);
		}
	}

	public TbPryAsesorxproyectoDAO getTbPryAsesorxproyectoDAO() {
		return tbPryAsesorxproyectoDAO;
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @param asesorIdn
	 * @throws DaoException
	 */
	public void delete(Integer proyectoIdn, Integer asesorIdn)
			throws DaoException {
		TbPryAsesorxproyecto deleted = tbPryAsesorxproyectoDAO
				.findByForeignKey(proyectoIdn, asesorIdn);
		if (deleted != null) {
			tbPryAsesorxproyectoDAO.delete(deleted);
		}
	}

	public void setTbPryAsesorxproyectoDAO(
			TbPryAsesorxproyectoDAO tbPryAsesorxproyectoDAO) {
		this.tbPryAsesorxproyectoDAO = tbPryAsesorxproyectoDAO;
	}

	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryAsesorxproyecto> findAll() throws DaoException {
		return tbPryAsesorxproyectoDAO.findAll();
	}

	/**
	 * 
	 * @param usuarioCrea
	 * @param proyectoIdn
	 * @param asesorIdn
	 * @return
	 * @throws DaoException
	 * @throws AlreadyExistsException
	 */
	public TbPryAsesorxproyecto insert(String usuarioCrea, Integer proyectoIdn,
			Integer asesorIdn) throws DaoException, AlreadyExistsException {
		if (Validaciones.isTextoVacio(usuarioCrea)) {
			throw new DaoException("El usuario no puede ser nulo o vacio");
		}
		if (proyectoIdn == null) {
			throw new DaoException("El codigo del proyecto no puede ser nulo");
		}
		if (asesorIdn == null) {
			throw new DaoException(
					"El codigo del asesor del proyecto no puede ser nulo");
		}
		TbPryAsesorxproyecto current = tbPryAsesorxproyectoDAO
				.findByForeignKey(proyectoIdn, asesorIdn);
		if (current != null) {
			throw new AlreadyExistsException(
					"El asesor ya fue asignado al proyecto.");
		}
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		if (proyecto == null) {
			throw new DaoException(
					"El proyecto con el codigo ingresado no existe en la base de datos");
		}
		TbAdmUsuarios asesor = tbAdmUsuariosService.get(asesorIdn);
		if (asesor == null) {
			throw new DaoException(
					"El asesor con el codigo ingresado no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService
				.findUsuarioByLogin(usuarioCrea);
		if (usuario == null) {
			throw new DaoException(
					"El usuario que agrega el asesor no existe en la base de datos");
		}
		TbPryAsesorxproyecto inserted = new TbPryAsesorxproyecto();
		inserted.setDtAdtfecha(new Date());
		inserted.setVrAdtusuario(usuarioCrea);
		inserted.setTbAdmUsuarios(asesor);
		inserted.setTbPryProyectos(proyecto);
		return tbPryAsesorxproyectoDAO.save(inserted);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryAsesorxproyecto> findByProyecto(Integer proyectoIdn)
			throws DaoException {
		return tbPryAsesorxproyectoDAO.findByProyecto(proyectoIdn);
	}
}
