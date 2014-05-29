package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.edu.udea.proyectointegrador.dto.TbPryArchivoxentregable;
import co.edu.udea.proyectointegrador.exception.DaoException;

public class TbPryArchivoxentregableDAO extends AbstractFacadeDAO<TbPryArchivoxentregable>{
	public TbPryArchivoxentregableDAO()
	{
		super(TbPryArchivoxentregable.class);
	}	
	/**
	 * 
	 * @param actividadIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryArchivoxentregable> findByEntregable(Integer entregableActividadIdn)
			throws DaoException {

		List<TbPryArchivoxentregable> entregables = new ArrayList<TbPryArchivoxentregable>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("from TbPryArchivoxentregable a where "
					+ "a.tbPryEntregablexactividad.nbIdn='" + entregableActividadIdn + "'");
			entregables = (List<TbPryArchivoxentregable>) query.list();
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
