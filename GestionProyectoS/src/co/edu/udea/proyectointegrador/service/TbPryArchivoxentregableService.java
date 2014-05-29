package co.edu.udea.proyectointegrador.service;

import java.util.Date;
import java.util.List;

import co.edu.udea.proyectointegrador.dao.TbPryArchivoxentregableDAO;
import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.dto.TbPryArchivoxentregable;
import co.edu.udea.proyectointegrador.dto.TbPryEntregablexactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.util.validations.Validaciones;

public class TbPryArchivoxentregableService {
	private TbPryArchivoxentregableDAO tbPryArchivoxentregableDAO;
	private TbPryEntregablexactividadService tbPryEntregablexactividadService;
	private TbAdmUsuariosService tbAdmUsuariosService;
	
	public TbAdmUsuariosService getTbAdmUsuariosService() {
		return tbAdmUsuariosService;
	}
	public void setTbAdmUsuariosService(TbAdmUsuariosService tbAdmUsuariosService) {
		this.tbAdmUsuariosService = tbAdmUsuariosService;
	}
	public TbPryArchivoxentregableDAO getTbPryArchivoxentregableDAO() {
		return tbPryArchivoxentregableDAO;
	}
	public void setTbPryArchivoxentregableDAO(
			TbPryArchivoxentregableDAO tbPryArchivoxentregableDAO) {
		this.tbPryArchivoxentregableDAO = tbPryArchivoxentregableDAO;
	}
	public TbPryEntregablexactividadService getTbPryEntregablexactividadService() {
		return tbPryEntregablexactividadService;
	}
	public void setTbPryEntregablexactividadService(
			TbPryEntregablexactividadService tbPryEntregablexactividadService) {
		this.tbPryEntregablexactividadService = tbPryEntregablexactividadService;
	}
	public TbPryArchivoxentregable get(Integer id) throws DaoException
	{
		return tbPryArchivoxentregableDAO.get(id);
	}
	public List<TbPryArchivoxentregable> findByEntregable(Integer entregableIdn) throws DaoException
	{
		return tbPryArchivoxentregableDAO.findByEntregable(entregableIdn);
	}
	public TbPryArchivoxentregable insert(String usuarioCrea, String nombre,
			String comentarioParticipante, byte[] archivoAdjunto,
			Integer entregableIdn) throws DaoException
	{
		if(Validaciones.isTextoVacio(usuarioCrea))
		{
			throw new DaoException("El usuario que crea el archivo no puede ser nulo o vacio");
		}
		if(Validaciones.isTextoVacio(comentarioParticipante))
		{
			throw new DaoException("El comentario del participante no puede nulo o vacio");
		}
		if(Validaciones.isTextoVacio(nombre))
		{
			throw new DaoException("El nombre del archivo entregable no puede ser nulo o vacio");
		}
		if(entregableIdn == null)
		{
			throw new DaoException("El codigo del entregable no puede ser nulo");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService.findUsuarioByLogin(usuarioCrea);
		if(usuario == null)
		{
			throw new DaoException("El usuario que crea el archivo no existe en la base de datos");
		}
		TbPryEntregablexactividad entregable = tbPryEntregablexactividadService.get(entregableIdn);
		if(entregable == null)
		{
			throw new DaoException("El entregable asociado con el archivo creado no existe en la base de datos");
		}
		TbPryArchivoxentregable archivo = new TbPryArchivoxentregable();
		archivo.setBlobAdjunto(archivoAdjunto);
		archivo.setDtAdtfecha(new Date());
		archivo.setTbPryEntregablexactividad(entregable);
		archivo.setVrAdtusuario(usuarioCrea);
		archivo.setVrComentarioparticipante(comentarioParticipante);
		archivo.setVrNombre(nombre);
		archivo = tbPryArchivoxentregableDAO.save(archivo);
		return archivo;
	}
	public TbPryArchivoxentregable update(String usuarioCrea, String nombre,
			String comentarioParticipante, byte[] archivoAdjunto,
			Integer entregableIdn, Integer archivoIdn) throws DaoException
	{

		if(Validaciones.isTextoVacio(usuarioCrea))
		{
			throw new DaoException("El usuario que crea el archivo no puede ser nulo o vacio");
		}
		if(Validaciones.isTextoVacio(comentarioParticipante))
		{
			throw new DaoException("El comentario del participante no puede nulo o vacio");
		}
		if(Validaciones.isTextoVacio(nombre))
		{
			throw new DaoException("El nombre del archivo entregable no puede ser nulo o vacio");
		}
		if(entregableIdn == null)
		{
			throw new DaoException("El codigo del entregable no puede ser nulo");
		}
		TbAdmUsuarios usuario = tbAdmUsuariosService.findUsuarioByLogin(usuarioCrea);
		if(usuario == null)
		{
			throw new DaoException("El usuario que crea el archivo no existe en la base de datos");
		}
		TbPryEntregablexactividad entregable = tbPryEntregablexactividadService.get(entregableIdn);
		if(entregable == null)
		{
			throw new DaoException("El entregable asociado con el archivo creado no existe en la base de datos");
		}
		TbPryArchivoxentregable archivo = tbPryArchivoxentregableDAO.get(archivoIdn);
		if(archivo == null)
		{
			throw new DaoException("El archivo entregable no existe en la base de datos");
		}
		archivo.setBlobAdjunto(archivoAdjunto);
		archivo.setDtAdtfecha(new Date());
		archivo.setTbPryEntregablexactividad(entregable);
		archivo.setVrAdtusuario(usuarioCrea);
		archivo.setVrComentarioparticipante(comentarioParticipante);
		archivo.setVrNombre(nombre);
		archivo = tbPryArchivoxentregableDAO.update(archivo);
		return archivo;
	}
	public TbPryArchivoxentregable realizarSeguimiento(String usuarioCrea, String comentarioAsesor, Integer archivoIdn) throws DaoException
	{
		if(Validaciones.isTextoVacio(usuarioCrea))
		{
			throw new DaoException("El usuario que crea el archivo no puede ser nulo o vacio");
		}
		if(Validaciones.isTextoVacio(comentarioAsesor))
		{
			throw new DaoException("El comentario del asesor no puede nulo o vacio");
		}
		if(archivoIdn == null)
		{
			throw new DaoException("El codigo del archivo no puede ser nulo");
		}
		TbPryArchivoxentregable archivo = tbPryArchivoxentregableDAO.get(archivoIdn);
		if(archivo == null)
		{
			throw new DaoException("El archivo entregable no existe en la base de datos");
		}
		archivo.setVrComentarioasesor(comentarioAsesor);
		archivo.setDtAdtfecha(new Date());
		archivo.setVrAdtusuario(usuarioCrea);
		archivo = tbPryArchivoxentregableDAO.update(archivo);
		return archivo;
	}
	public void delete(Integer archivoIdn) throws DaoException
	{
		TbPryArchivoxentregable archivo = tbPryArchivoxentregableDAO.get(archivoIdn);
		if(archivo != null)
		{
			tbPryArchivoxentregableDAO.delete(archivo);
		}
	}
}
