package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryEntregables;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryEntregablesDAO extends AbstractFacadeDAO<TbPryEntregables> {

	/**
	 * 
	 */
	public TbPryEntregablesDAO() {
		super(TbPryEntregables.class);
	}

	/**
	 * 
	 * @param actividadIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryEntregables> findByActividad(Integer actividadIdn)
			throws DaoException {

		List<TbPryEntregables> entregables = new ArrayList<TbPryEntregables>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("from TbPryEntregables p where "
					+ "p.tbPryActividades.nbIdn='" + actividadIdn + "'");
			entregables = (List<TbPryEntregables>) query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return entregables;
	}
}
