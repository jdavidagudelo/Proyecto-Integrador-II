package co.edu.udea.proyectointegrador.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbNtfMediosntf;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfMediosntfDAO extends AbstractFacadeDAO<TbNtfMediosntf> {
	public TbNtfMediosntfDAO() {
		super(TbNtfMediosntf.class);
	}

	/**
	 * Metodo que permite obtener el medio con el nombre ingresado como
	 * argumento
	 * 
	 * @param nombreMedio
	 *            nombre del medio
	 * @return el medio con el nombre ingresado como argumento
	 * @throws DaoException
	 */
	public TbNtfMediosntf findMedioByNombre(String nombreMedio)
			throws DaoException {
		TbNtfMediosntf medio = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfMediosntf m where m.vrNombre ='"
							+ nombreMedio + "'");
			medio = (TbNtfMediosntf) query.uniqueResult();
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