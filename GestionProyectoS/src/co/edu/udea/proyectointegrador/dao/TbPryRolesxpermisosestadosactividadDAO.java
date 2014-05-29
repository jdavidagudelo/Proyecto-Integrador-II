package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryRolesxpermisosestadosactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryRolesxpermisosestadosactividadDAO extends
		AbstractFacadeDAO<TbPryRolesxpermisosestadosactividad> {

	/**
	 * 
	 */
	public TbPryRolesxpermisosestadosactividadDAO() {
		super(TbPryRolesxpermisosestadosactividad.class);
	}

	/**
	 * 
	 * @param rolIdn
	 * @param permisoEstadoIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryRolesxpermisosestadosactividad findPermisoEstadoByForeignKey(
			Integer rolIdn, Integer permisoEstadoIdn) throws DaoException {
		TbPryRolesxpermisosestadosactividad permiso = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryRolesxpermisosestadosactividad r where r.tbAdmRoles.nbIdn ="
							+ rolIdn
							+ ""
							+ " and "
							+ "r.tbPryPermisosxestadosactividad.nbIdn ="
							+ permisoEstadoIdn);
			permiso = (TbPryRolesxpermisosestadosactividad) query
					.uniqueResult();

			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return permiso;
	}

	/**
	 * 
	 * @param rolIdn
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryRolesxpermisosestadosactividad> findByForeignKey(
			Integer rolIdn, Integer estadoIdn) throws DaoException {
		List<TbPryRolesxpermisosestadosactividad> permisos = new ArrayList<TbPryRolesxpermisosestadosactividad>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryRolesxpermisosestadosactividad r where "
							+ "r.tbPryPermisosxestadosactividad.tbPryEstadosactividad.nbIdn ="
							+ estadoIdn + " and r.tbAdmRoles.nbIdn=" + rolIdn);
			@SuppressWarnings("unchecked")
			List<TbPryRolesxpermisosestadosactividad> list = query.list();
			permisos = list;
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return permisos;
	}

	/**
	 * 
	 * @param permisoEstadoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryRolesxpermisosestadosactividad> findByForeignKey(
			Integer permisoEstadoIdn) throws DaoException {
		List<TbPryRolesxpermisosestadosactividad> permisos = new ArrayList<TbPryRolesxpermisosestadosactividad>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryRolesxpermisosestadosactividad r where "
							+ "r.tbPryPermisosxestadosactividad.nbIdn ="
							+ permisoEstadoIdn);
			@SuppressWarnings("unchecked")
			List<TbPryRolesxpermisosestadosactividad> list = query.list();
			permisos = list;
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return permisos;
	}

	public Boolean validarPermiso(Integer estadoIdn, Integer rolIdn,
			String permisoNombre) throws DaoException {
		TbPryRolesxpermisosestadosactividad permiso = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryRolesxpermisosestadosactividad r where r.tbAdmRoles.nbIdn ="
							+ rolIdn
							+ ""
							+ " and "
							+ "r.tbPryPermisosxestadosactividad.tbAdmPermisos.vrNombre ='"
							+ permisoNombre
							+ "' and r.tbPryPermisosxestadosactividad.tbPryEstadosactividad.nbIdn="
							+ estadoIdn);

			permiso = (TbPryRolesxpermisosestadosactividad) query
					.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return permiso != null;
	}
}
