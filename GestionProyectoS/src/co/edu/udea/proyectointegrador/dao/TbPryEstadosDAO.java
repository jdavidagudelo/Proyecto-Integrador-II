package co.edu.udea.proyectointegrador.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.edu.udea.proyectointegrador.dto.TbPryEstados;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryEstadosDAO extends AbstractFacadeDAO<TbPryEstados> {

	/**
	 * 
	 */
	public TbPryEstadosDAO() {
		super(TbPryEstados.class);
	}

	/**
	 * 
	 * @param nombreEstado
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstados findEstadoByNombre(String nombreEstado)
			throws DaoException {
		TbPryEstados estado = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryEstados e where e.vrNombre ='"
							+ nombreEstado + "'");
			estado = (TbPryEstados) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return estado;
	}

}
