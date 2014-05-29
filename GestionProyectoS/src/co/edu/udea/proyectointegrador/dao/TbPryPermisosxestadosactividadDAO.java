package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryPermisosxestadosactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryPermisosxestadosactividadDAO extends
		AbstractFacadeDAO<TbPryPermisosxestadosactividad> {

	/**
	 * 
	 */
	public TbPryPermisosxestadosactividadDAO() {
		// TODO Auto-generated constructor stub
		super(TbPryPermisosxestadosactividad.class);
	}

	/**
	 * 
	 * @param estadoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryPermisosxestadosactividad> findPermisosByEstado(
			Integer estadoIdn) throws DaoException {
		List<TbPryPermisosxestadosactividad> permisos = new ArrayList<TbPryPermisosxestadosactividad>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryPermisosxestadosactividad p where p.tbPryEstadosactividad.nbIdn ='"
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
	public TbPryPermisosxestadosactividad findByForeignKey(Integer permisoIdn,
			Integer estadoIdn) throws DaoException {
		TbPryPermisosxestadosactividad permiso = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryPermisosxestadosactividad p where "
							+ "p.tbAdmPermisos.nbIdn ='" + permisoIdn
							+ "' and p.tbPryEstadosactividad.nbIdn='"
							+ estadoIdn + "'");
			permiso = (TbPryPermisosxestadosactividad) query.uniqueResult();
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
