package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbNtfsTipontfsroles;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfsTipontfsrolesDAO extends
		AbstractFacadeDAO<TbNtfsTipontfsroles> {
	public TbNtfsTipontfsrolesDAO() {
		super(TbNtfsTipontfsroles.class);
	}

	/**
	 * Permite obtener el tipo de notificacion x rol
	 * 
	 * @param rolIdn
	 *            el id del rol
	 * @param tipoNotificacionIdn
	 *            el id del tipo de notificacion
	 * @return tipo de notificacion x rol con los id ingresados como argumento
	 * @throws DaoException
	 */
	public TbNtfsTipontfsroles findByForeignKey(Integer rolIdn,
			Integer tipoNotificacionIdn) throws DaoException {
		TbNtfsTipontfsroles permission = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfsTipontfsroles t where "
							+ "t.tbNtfTipontfs.nbIdn ='" + tipoNotificacionIdn
							+ "' and t.tbAdmRoles.nbIdn='" + rolIdn + "'");
			permission = (TbNtfsTipontfsroles) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return permission;
	}

	/**
	 * Permite obtener los roles que pueden usar el tipo de notificacion
	 * ingresado como argumento.
	 * 
	 * @param tipoIdn
	 *            id del tipo de notificacion
	 * @return lista de tipos de notificacion x rol asociados al tipo de
	 *         notificacion ingresado como argumento
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbNtfsTipontfsroles> findRolesByTipoNotificacion(Integer tipoIdn)
			throws DaoException {
		List<TbNtfsTipontfsroles> tipoMedios = new ArrayList<TbNtfsTipontfsroles>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfsTipontfsroles r where r.tbNtfTipontfs.nbIdn ='"
							+ tipoIdn + "'");
			tipoMedios = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return tipoMedios;
	}

	/**
	 * Permite obtener los tipos de notificacion x rol asociados con el rol
	 * ingresados como argumento
	 * 
	 * @param rolIdn
	 *            el id del rol
	 * @return lista de tipos de notificacion x rol asociados con el rol
	 *         ingresado como argumento.
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbNtfsTipontfsroles> findTiposNotificacionByRol(Integer rolIdn)
			throws DaoException {
		List<TbNtfsTipontfsroles> tipoMedios = new ArrayList<TbNtfsTipontfsroles>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfsTipontfsroles r where r.tbAdmRoles.nbIdn ='"
							+ rolIdn + "'");
			tipoMedios = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return tipoMedios;
	}
}
