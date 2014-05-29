package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryAsesorxproyecto;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryAsesorxproyectoDAO extends
		AbstractFacadeDAO<TbPryAsesorxproyecto> {

	/**
	 * 
	 */
	public TbPryAsesorxproyectoDAO() {
		super(TbPryAsesorxproyecto.class);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryAsesorxproyecto> findByProyecto(Integer proyectoIdn)
			throws DaoException {

		List<TbPryAsesorxproyecto> asesores = new ArrayList<TbPryAsesorxproyecto>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryAsesorxproyecto p where "
							+ "p.tbPryProyectos.nbIdn='" + proyectoIdn + "'");
			asesores = (List<TbPryAsesorxproyecto>) query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return asesores;
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @param asesorIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryAsesorxproyecto findByForeignKey(Integer proyectoIdn,
			Integer asesorIdn) throws DaoException {
		TbPryAsesorxproyecto asesor = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryAsesorxproyecto p where "
							+ "p.tbAdmUsuarios.nbIdn ='" + asesorIdn
							+ "' and p.tbPryProyectos.nbIdn='" + proyectoIdn
							+ "'");
			asesor = (TbPryAsesorxproyecto) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return asesor;
	}
}
