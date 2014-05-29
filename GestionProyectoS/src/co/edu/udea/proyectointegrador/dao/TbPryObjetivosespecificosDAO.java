package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryObjetivosespecificos;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryObjetivosespecificosDAO extends
		AbstractFacadeDAO<TbPryObjetivosespecificos> {

	/**
	 * 
	 */
	public TbPryObjetivosespecificosDAO() {
		super(TbPryObjetivosespecificos.class);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryObjetivosespecificos> findByProyecto(Integer proyectoIdn)
			throws DaoException {
		List<TbPryObjetivosespecificos> objetivos = new ArrayList<TbPryObjetivosespecificos>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryObjetivosespecificos p where "
							+ "p.tbPryProyectos.nbIdn='" + proyectoIdn + "'");
			objetivos = (List<TbPryObjetivosespecificos>) query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return objetivos;
	}

	/**
	 * 
	 * @param objetivoIdn
	 * @param estadoCanceladoIdn
	 * @return
	 * @throws DaoException
	 */
	public Long getPorcentaje(Integer objetivoIdn, Integer estadoCanceladoIdn)
			throws DaoException {
		Long porcentaje = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("select sum(a.nbPorcentajesobreactividad) "
							+ "from TbPryActividades a where "
							+ "a.tbPryObjetivosespecificos.nbIdn='"
							+ objetivoIdn + "' and "
							+ "a.tbPryEstadosactividad.nbIdn<>'"
							+ estadoCanceladoIdn + "'");
			porcentaje = (Long) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return porcentaje;
	}

}
