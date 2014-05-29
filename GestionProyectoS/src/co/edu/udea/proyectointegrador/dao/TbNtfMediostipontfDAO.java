package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbNtfMediostipontf;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfMediostipontfDAO extends
		AbstractFacadeDAO<TbNtfMediostipontf> {
	public TbNtfMediostipontfDAO() {
		super(TbNtfMediostipontf.class);
	}

	/**
	 * Metodo que permite obtener los medios asociados con el tipo de
	 * notificacion ingresado como argumento.
	 * 
	 * @param tipoIdn
	 *            id del tipo de notificacion
	 * @return lista de los medios x tipo de notificacion cuyo medio es el
	 *         ingresado como argumento
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbNtfMediostipontf> findMediosByTipoNotificacion(Integer tipoIdn)
			throws DaoException {
		List<TbNtfMediostipontf> tipoMedios = new ArrayList<TbNtfMediostipontf>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfMediostipontf p where p.tbNtfTipontfs.nbIdn ='"
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
	 * Permite obtener el medio x tipo de notificacion con los ids ingresados
	 * 
	 * @param medioIdn
	 *            id del medio
	 * @param tipoIdn
	 *            id del tipo de notificacion
	 * @return medio x tipo de notificacion
	 * @throws DaoException
	 */
	public TbNtfMediostipontf findByForeignKey(Integer medioIdn, Integer tipoIdn)
			throws DaoException {
		TbNtfMediostipontf medio = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfMediostipontf t where "
							+ "t.tbNtfTipontfs.nbIdn ='" + tipoIdn
							+ "' and t.tbNtfMediosntf.nbIdn='" + medioIdn + "'");
			medio = (TbNtfMediostipontf) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return medio;
	}
}
