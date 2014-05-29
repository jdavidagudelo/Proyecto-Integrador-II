package co.edu.udea.proyectointegrador.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.edu.udea.proyectointegrador.dto.TbPryEstadosactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryEstadosactividadDAO extends
		AbstractFacadeDAO<TbPryEstadosactividad> {

	/**
	 * 
	 */
	public TbPryEstadosactividadDAO() {
		super(TbPryEstadosactividad.class);
	}

	/**
	 * 
	 * @param nombreEstado
	 * @return
	 * @throws DaoException
	 */
	public TbPryEstadosactividad findEstadoByNombre(String nombreEstado)
			throws DaoException {
		TbPryEstadosactividad estado = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryEstadosactividad e where e.vrNombre ='"
							+ nombreEstado + "'");
			estado = (TbPryEstadosactividad) query.uniqueResult();
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
