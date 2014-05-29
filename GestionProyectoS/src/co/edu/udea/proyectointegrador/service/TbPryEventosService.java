package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryEventosDAO;
import co.edu.udea.proyectointegrador.dto.TbPryEventos;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.exception.DaoException;

public class TbPryEventosService {
	private TbPryProyectosService tbPryProyectosService;
	private TbPryEventosDAO tbPryEventosDAO;

	public TbPryProyectosService getTbPryProyectosService() {
		return tbPryProyectosService;
	}

	public void setTbPryProyectosService(
			TbPryProyectosService tbPryProyectosService) {
		this.tbPryProyectosService = tbPryProyectosService;
	}

	public TbPryEventosDAO getTbPryEventosDAO() {
		return tbPryEventosDAO;
	}

	public void setTbPryEventosDAO(TbPryEventosDAO tbPryEventosDAO) {
		this.tbPryEventosDAO = tbPryEventosDAO;
	}

	public TbPryEventos get(Integer id) throws DaoException {
		return tbPryEventosDAO.get(id);
	}

	public List<TbPryEventos> findByProyecto(Integer proyectoIdn)
			throws DaoException {
		return tbPryEventosDAO.findEventosByProyecto(proyectoIdn);
	}

	public TbPryEventos insert(String usuarioCrea, String nombre,
			String descripcion, Date fechaInicial, Date fechaFinal,
			Integer proyectoIdn) throws DaoException {
		if (nombre == null) {
			nombre = "";
		}
		if (descripcion == null) {
			descripcion = "";
		}
		TbPryEventos evento = new TbPryEventos();
		evento.setDtAdtfecha(new Date());
		evento.setVrAdtusuario(usuarioCrea);
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		evento.setTbPryProyectos(proyecto);
		evento.setDtFechafinal(fechaFinal);
		evento.setDtFechainicial(fechaInicial);
		evento.setVrDescripcion(descripcion);
		evento.setVrNombre(nombre);
		evento = tbPryEventosDAO.save(evento);
		return evento;
	}

	public TbPryEventos update(String usuarioCrea, String nombre,
			String descripcion, Date fechaInicial, Date fechaFinal,
			Integer proyectoIdn, Integer eventoIdn) throws DaoException {
		if (nombre == null) {
			nombre = "";
		}
		if (descripcion == null) {
			descripcion = "";
		}
		TbPryEventos evento = tbPryEventosDAO.get(eventoIdn);
		evento.setDtAdtfecha(new Date());
		evento.setVrAdtusuario(usuarioCrea);
		TbPryProyectos proyecto = tbPryProyectosService.get(proyectoIdn);
		evento.setTbPryProyectos(proyecto);
		evento.setDtFechafinal(fechaFinal);
		evento.setDtFechainicial(fechaInicial);
		evento.setVrDescripcion(descripcion);
		evento.setVrNombre(nombre);
		evento = tbPryEventosDAO.update(evento);
		return evento;
	}

	public void delete(Integer eventoIdn) throws DaoException {
		TbPryEventos evento = tbPryEventosDAO.get(eventoIdn);
		if (evento != null) {
			tbPryEventosDAO.delete(evento);
		}
	}
}
