package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryEntregablexactividadDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.dto.TbPryArchivoxentregable;
import co.edu.udea.proyectointegrador.dto.TbPryEntregablexactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

public class TbPryEntregablexactividadService {
	private TbPryEntregablexactividadDAO tbPryEntregablexactividadDAO;
	private TbPryActividadesService tbPryActividadesService;
	private TbPryArchivoxentregableService tbPryArchivoxentregableService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	
	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}
	public void setTbAdmUsuariosService(TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}
	public TbPryArchivoxentregableService getTbPryArchivoxentregableService() {
		return tbPryArchivoxentregableService;
	}
	public void setTbPryArchivoxentregableService(
			TbPryArchivoxentregableService tbPryArchivoxentregableService) {
		this.tbPryArchivoxentregableService = tbPryArchivoxentregableService;
	}
	public TbPryEntregablexactividadDAO getTbPryEntregablexactividadDAO() {
		return tbPryEntregablexactividadDAO;
	}
	public void setTbPryEntregablexactividadDAO(
			TbPryEntregablexactividadDAO tbPryEntregablexactividadDAO) {
		this.tbPryEntregablexactividadDAO = tbPryEntregablexactividadDAO;
	}
	public TbPryActividadesService getTbPryActividadesService() {
		return tbPryActividadesService;
	}
	public void setTbPryActividadesService(
			TbPryActividadesService tbPryActividadesService) {
		this.tbPryActividadesService = tbPryActividadesService;
	}
	public TbPryEntregablexactividad get(Integer id) throws DaoException
	{
		return tbPryEntregablexactividadDAO.get(id);
	}
	public List<TbPryEntregablexactividad> findByActividad(Integer actividadIdn) throws DaoException
	{
		return tbPryEntregablexactividadDAO.findByActividad(actividadIdn);
	}
	public TbPryEntregablexactividad insert(String usuarioCrea, String nombre, String descripcion, Integer actividadIdn) throws DaoException
	{
		if(Validaciones.isTextoVacio(usuarioCrea))
		{
			throw new DaoException("El usuario que crea el entregable no puede ser nulo o vacio");
		}
		if(Validaciones.isTextoVacio(descripcion))
		{
			throw new DaoException("La descripcion del entregable no puede ser nula o vacia");
		}
		if(Validaciones.isTextoVacio(nombre))
		{
			throw new DaoException("El nombre del entregable no puede ser nulo o vacio");
		}
		if(actividadIdn == null)
		{
			throw new DaoException("El codigo de la actividad no puede ser nulo o vacio");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if(actividad == null)
		{
			throw new DaoException("La actividad asociada con el entregable no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService.findUsuarioByLogin(usuarioCrea);
		if(usuario == null)
		{
			throw new DaoException("El usuario que crea el entregable no existe en la base de datos");
		}
		TbPryEntregablexactividad entregable = new TbPryEntregablexactividad();
		entregable.setDtAdtfecha(new Date());
		entregable.setVrAdtusuario(usuarioCrea);
		entregable.setVrDescripcion(descripcion);
		entregable.setVrNombre(nombre);
		entregable.setTbPryActividades(actividad);
		entregable = tbPryEntregablexactividadDAO.save(entregable);
		return entregable;
	}
	public TbPryEntregablexactividad update(String usuarioCrea, String nombre, String descripcion, Integer actividadIdn, Integer entregableIdn) throws DaoException
	{
		if(Validaciones.isTextoVacio(usuarioCrea))
		{
			throw new DaoException("El usuario que crea el entregable no puede ser nulo o vacio");
		}
		if(Validaciones.isTextoVacio(descripcion))
		{
			throw new DaoException("La descripcion del entregable no puede ser nula o vacia");
		}
		if(Validaciones.isTextoVacio(nombre))
		{
			throw new DaoException("El nombre del entregable no puede ser nulo o vacio");
		}
		if(actividadIdn == null)
		{
			throw new DaoException("El codigo de la actividad no puede ser nulo o vacio");
		}
		if(entregableIdn == null)
		{
			throw new DaoException("El codigo del entregable no puede ser nulo");
		}
		TbPryActividades actividad = tbPryActividadesService.get(actividadIdn);
		if(actividad == null)
		{
			throw new DaoException("La actividad asociada con el entregable no existe en la base de datos");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService.findUsuarioByLogin(usuarioCrea);
		if(usuario == null)
		{
			throw new DaoException("El usuario que crea el entregable no existe en la base de datos");
		}
		TbPryEntregablexactividad entregable = tbPryEntregablexactividadDAO.get(entregableIdn);
		if(entregable == null)
		{
			throw new DaoException("El entregable especificado no existe en la base de datos");
		}
		entregable.setDtAdtfecha(new Date());
		entregable.setVrAdtusuario(usuarioCrea);
		entregable.setVrDescripcion(descripcion);
		entregable.setVrNombre(nombre);
		entregable.setTbPryActividades(actividad);
		entregable = tbPryEntregablexactividadDAO.save(entregable);
		return entregable;
	}
	public void delete(Integer entregableIdn) throws DaoException
	{
		TbPryEntregablexactividad entregable  = tbPryEntregablexactividadDAO.get(entregableIdn);
		if(entregable != null)
		{
			for(TbPryArchivoxentregable archivo : tbPryArchivoxentregableService.findByEntregable(entregableIdn))
			{
				tbPryArchivoxentregableService.delete(archivo.getNbIdn());
			}
			tbPryEntregablexactividadDAO.delete(entregable);
		}
	}
}
