package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryActividades;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryActividadesDAO extends AbstractFacadeDAO<TbPryActividades> {

	/**
	 * 
	 */
	public TbPryActividadesDAO() {
		super(TbPryActividades.class);
	}

	/**
	 * 
	 * @param estadoEnProcesoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryActividades> findActividadesVencidas(
			Integer estadoEnProcesoIdn) throws DaoException {
		List<TbPryActividades> actividades = new ArrayList<TbPryActividades>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryActividades a where a.tbPryEstadosactividad.nbIdn ='"
							+ estadoEnProcesoIdn
							+ "'"
							+ " and a.dtFechafinal < CURRENT_DATE()");
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
	 * @param estadoAbiertoIdn
	 * @param estadoReanudadoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryActividades> findActividadesEnProceso(
			Integer estadoAbiertoIdn, Integer estadoReanudadoIdn)
			throws DaoException {
		List<TbPryActividades> actividades = new ArrayList<TbPryActividades>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryActividades a where (a.tbPryEstadosactividad.nbIdn ='"
							+ estadoAbiertoIdn
							+ "' or "
							+ "a.tbPryEstadosactividad.nbIdn ='"
							+ estadoReanudadoIdn
							+ "')"
							+ " and a.dtFechainicial < CURRENT_DATE()");
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
	 * @param proyectoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryActividades> findActividadesByProyecto(Integer proyectoIdn)
			throws DaoException {

		List<TbPryActividades> actividades = new ArrayList<TbPryActividades>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryActividades a where a.tbPryObjetivosespecificos.tbPryProyectos.nbIdn ='"
							+ proyectoIdn + "'");

			actividades = (List<TbPryActividades>) query.list();
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
	 * @param estadoIdn
	 * @param proyectoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryActividades> findActividadesByEstado(Integer estadoIdn,
			Integer proyectoIdn) throws DaoException {

		List<TbPryActividades> actividades = new ArrayList<TbPryActividades>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryActividades a where a.tbPryEstadosactividad.nbIdn ='"
							+ estadoIdn
							+ "' and "
							+ "a.tbPryObjetivosespecificos.tbPryProyectos.nbIdn ='"
							+ proyectoIdn + "'");
			actividades = (List<TbPryActividades>) query.list();
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
	 * @param proyectoIdn
	 * @param estadoCanceladoIdn
	 * @param estadoSuspendidoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryActividades> findActividadesRealizadas(
			Integer proyectoIdn, Integer estadoCanceladoIdn,
			Integer estadoSuspendidoIdn) throws DaoException {

		List<TbPryActividades> actividades = new ArrayList<TbPryActividades>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryActividades a where (a.tbPryEstadosactividad.nbIdn <>'"
							+ estadoSuspendidoIdn
							+ "' and a.tbPryEstadosactividad.nbIdn <>'"
							+ estadoCanceladoIdn
							+ "') and "
							+ "a.tbPryObjetivosespecificos.tbPryProyectos.nbIdn ='"
							+ proyectoIdn + "'");
			actividades = (List<TbPryActividades>) query.list();
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
	 * @param proyectoIdn
	 * @param estadoAbiertoIdn
	 * @param estadoEnProcesoIdn
	 * @param estadoReanudadoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryActividades> findActividadesActivas(Integer proyectoIdn,
			Integer estadoAbiertoIdn, Integer estadoEnProcesoIdn,
			Integer estadoReanudadoIdn) throws DaoException {

		List<TbPryActividades> actividades = new ArrayList<TbPryActividades>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryActividades a where (a.tbPryEstadosactividad.nbIdn ='"
							+ estadoAbiertoIdn
							+ "' or a.tbPryEstadosactividad.nbIdn ='"
							+ estadoEnProcesoIdn
							+ "' or a.tbPryEstadosactividad.nbIdn ='"
							+ estadoReanudadoIdn
							+ "') and "
							+ "a.tbPryObjetivosespecificos.tbPryProyectos.nbIdn ='"
							+ proyectoIdn + "'");
			actividades = (List<TbPryActividades>) query.list();
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
	 * @param objetivoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryActividades> findActividadesByObjetivo(Integer objetivoIdn)
			throws DaoException {

		List<TbPryActividades> actividades = new ArrayList<TbPryActividades>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryActividades a where a.tbPryObjetivosespecificos.nbIdn ='"
							+ objetivoIdn + "'");
			actividades = (List<TbPryActividades>) query.list();
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
}
