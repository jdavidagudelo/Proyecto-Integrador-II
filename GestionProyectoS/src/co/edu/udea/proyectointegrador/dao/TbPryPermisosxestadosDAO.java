package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryPermisosxestados;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryPermisosxestadosDAO extends
		AbstractFacadeDAO<TbPryPermisosxestados> {

	/**
	 * 
	 */
	public TbPryPermisosxestadosDAO() {
		super(TbPryPermisosxestados.class);
	}

	/**
	 * 
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryPermisosxestados> findPermisosByEstado(Integer estadoIdn)
			throws DaoException {
		List<TbPryPermisosxestados> permisos = new ArrayList<TbPryPermisosxestados>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryPermisosxestados p where p.tbPryEstados.nbIdn ='"
							+ estadoIdn + "'");
			permisos = query.list();
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
	 * @param permisoIdn
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryPermisosxestados findByForeignKey(Integer permisoIdn,
			Integer estadoIdn) throws DaoException {
		TbPryPermisosxestados permiso = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryPermisosxestados p where "
							+ "p.tbAdmPermisos.nbIdn ='" + permisoIdn
							+ "' and p.tbPryEstados.nbIdn='" + estadoIdn + "'");
			permiso = (TbPryPermisosxestados) query.uniqueResult();
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
}
