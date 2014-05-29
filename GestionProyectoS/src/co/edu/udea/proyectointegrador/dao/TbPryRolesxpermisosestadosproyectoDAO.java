package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryRolesxpermisosestadosproyecto;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryRolesxpermisosestadosproyectoDAO extends
		AbstractFacadeDAO<TbPryRolesxpermisosestadosproyecto> {

	/**
	 * 
	 */
	public TbPryRolesxpermisosestadosproyectoDAO() {
		super(TbPryRolesxpermisosestadosproyecto.class);
	}

	/**
	 * 
	 * @param rolIdn
	 * @param permisoEstadoIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryRolesxpermisosestadosproyecto findPermisoEstadoByForeignKey(
			Integer rolIdn, Integer permisoEstadoIdn) throws DaoException {
		TbPryRolesxpermisosestadosproyecto permiso = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryRolesxpermisosestadosproyecto r where r.tbAdmRoles.nbIdn ="
							+ rolIdn
							+ ""
							+ " and "
							+ "r.tbPryPermisosxestados.nbIdn ="
							+ permisoEstadoIdn);

			permiso = (TbPryRolesxpermisosestadosproyecto) query.uniqueResult();
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
	 * @param permisoEstadoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryRolesxpermisosestadosproyecto> findByForeignKey(
			Integer permisoEstadoIdn) throws DaoException {
		List<TbPryRolesxpermisosestadosproyecto> permisos = new ArrayList<TbPryRolesxpermisosestadosproyecto>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryRolesxpermisosestadosproyecto r where "
							+ "r.tbPryPermisosxestados.nbIdn ="
							+ permisoEstadoIdn);
			@SuppressWarnings("unchecked")
			List<TbPryRolesxpermisosestadosproyecto> list = query.list();
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
		TbPryRolesxpermisosestadosproyecto permiso = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryRolesxpermisosestadosproyecto r where r.tbAdmRoles.nbIdn ="
							+ rolIdn
							+ ""
							+ " and "
							+ "r.tbPryPermisosxestados.tbAdmPermisos.vrNombre ='"
							+ permisoNombre
							+ "' and r.tbPryPermisosxestados.tbPryEstados.nbIdn="
							+ estadoIdn);

			permiso = (TbPryRolesxpermisosestadosproyecto) query.uniqueResult();
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

	/**
	 * 
	 * @param rolIdn
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	public List<TbPryRolesxpermisosestadosproyecto> findByForeignKey(
			Integer rolIdn, Integer estadoIdn) throws DaoException {
		List<TbPryRolesxpermisosestadosproyecto> permisos = new ArrayList<TbPryRolesxpermisosestadosproyecto>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryRolesxpermisosestadosproyecto r where "
							+ "r.tbPryPermisosxestados.tbPryEstados.nbIdn ="
							+ estadoIdn + " and r.tbAdmRoles.nbIdn=" + rolIdn);
			@SuppressWarnings("unchecked")
			List<TbPryRolesxpermisosestadosproyecto> list = query.list();
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

}
