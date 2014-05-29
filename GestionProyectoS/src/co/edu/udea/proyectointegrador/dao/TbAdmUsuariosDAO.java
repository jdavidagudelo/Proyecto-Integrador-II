package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbAdmUsuarios;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * Esta clase permite el acceso a la tabla de usuarios de la base de datos.
 * 
 * @see AbstractFacadeDAO
 * @author Juan David Agudelo jdaaa2009@gmail.com
 * @version 1.0
 * */
public class TbAdmUsuariosDAO extends AbstractFacadeDAO<TbAdmUsuarios> {
	public TbAdmUsuariosDAO() {
		super(TbAdmUsuarios.class);
	}

	/**
	 * Metodo usado para obtener la lista de usuarios con rol de responsable de
	 * la base de datos.
	 * 
	 * @return Lista de usuarios con rol de responsable de la base de datos.
	 * */
	public List<TbAdmUsuarios> getResponsables(String responsableNombre) throws DaoException {

		List<TbAdmUsuarios> clientes = new ArrayList<TbAdmUsuarios>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbAdmUsuarios u where u.tbAdmRoles.vrNombre ='"+responsableNombre+"'");
			@SuppressWarnings("unchecked")
			List<TbAdmUsuarios> list = query.list();
			clientes = list;
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return clientes;
	}

	/**
	 * Metodo usado para obtener la lista de usuarios con rol de participante de
	 * la base de datos.
	 * 
	 * @return Lista de usuarios con rol de participante de la base de datos.
	 * */
	public List<TbAdmUsuarios> getParticipantes(String participanteNombre) throws DaoException {
		List<TbAdmUsuarios> clientes = new ArrayList<TbAdmUsuarios>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbAdmUsuarios u where u.tbAdmRoles.vrNombre ='"+participanteNombre+"'");
			@SuppressWarnings("unchecked")
			List<TbAdmUsuarios> list = query.list();
			clientes = list;
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return clientes;
	}

	/**
	 * Metodo usado para obtener la lista de usuarios con rol de asesor de la
	 * base de datos.
	 * 
	 * @return Lista de usuarios con rol de asesor de la base de datos.
	 * */
	public List<TbAdmUsuarios> getAsesores(String asesorNombre) throws DaoException {

		List<TbAdmUsuarios> clientes = new ArrayList<TbAdmUsuarios>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbAdmUsuarios u where u.tbAdmRoles.vrNombre ='"+asesorNombre+"'");
			@SuppressWarnings("unchecked")
			List<TbAdmUsuarios> list = query.list();
			clientes = list;
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return clientes;
	}

	/**
	 * Método que permite obtener el usuario con el login ingresado como
	 * argumento.
	 * 
	 * @param login
	 *            el login del usuario
	 * @return el usuario con el login ingresado como argumento
	 * */
	public TbAdmUsuarios findUsuarioByLogin(String login) throws DaoException {

		TbAdmUsuarios usuario = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbAdmUsuarios u where u.vrUsuario ='"
							+ login + "'");
			usuario = (TbAdmUsuarios) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return usuario;
	}
}
