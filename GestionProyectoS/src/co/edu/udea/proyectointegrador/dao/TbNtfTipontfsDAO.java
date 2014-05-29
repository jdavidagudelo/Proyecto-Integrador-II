package co.edu.udea.proyectointegrador.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbNtfTipontfs;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfTipontfsDAO extends AbstractFacadeDAO<TbNtfTipontfs> {

	/**
	 * 
	 */
	public TbNtfTipontfsDAO() {
		super(TbNtfTipontfs.class);
	}

	/**
	 * Permite obtener el tipo de notificacion con el nombre ingresado como
	 * argumento
	 * 
	 * @param nombreTipo
	 *            nombre del tipo de notificacion
	 * @return tipo de notificacion con el nombre ingresado como argumento
	 * @throws DaoException
	 */
	public TbNtfTipontfs findTipoByNombre(String nombreTipo)
			throws DaoException {
		TbNtfTipontfs tipo = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfTipontfs t where t.vrNombre ='"
							+ nombreTipo + "'");
			tipo = (TbNtfTipontfs) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return tipo;
	}
}
