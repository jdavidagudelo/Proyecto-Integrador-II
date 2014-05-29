package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryActividadesxactividades;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryActividadesxactividadesDAO extends
		AbstractFacadeDAO<TbPryActividadesxactividades> {

	/**
	 * 
	 */
	public TbPryActividadesxactividadesDAO() {
		super(TbPryActividadesxactividades.class);
	}

	/**
	 * 
	 * @param actividadIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryActividadesxactividades> findActividadesPrevias(
			Integer actividadIdn) throws DaoException {

		List<TbPryActividadesxactividades> actividades = new ArrayList<TbPryActividadesxactividades>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryActividadesxactividades a where a.tbPryActividadSiguiente.nbIdn ='"
							+ actividadIdn + "'");
			actividades = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return actividades;
	}

	/**
	 * 
	 * @param actividadPreviaIdn
	 * @param actividadSiguienteIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryActividadesxactividades findByForeignKey(
			Integer actividadPreviaIdn, Integer actividadSiguienteIdn)
			throws DaoException {
		TbPryActividadesxactividades actividad = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryActividadesxactividades a where "
							+ "a.tbPryActividadSiguiente.nbIdn ='"
							+ actividadSiguienteIdn
							+ "' and a.tbPryActividadPrevia.nbIdn='"
							+ actividadPreviaIdn + "'");
			actividad = (TbPryActividadesxactividades) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return actividad;
	}
}
