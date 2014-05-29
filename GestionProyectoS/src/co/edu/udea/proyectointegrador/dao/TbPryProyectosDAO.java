package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.edu.udea.proyectointegrador.dto.TbPryProyectos;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryProyectosDAO extends AbstractFacadeDAO<TbPryProyectos> {

	/**
	 * 
	 */
	public TbPryProyectosDAO() {
		super(TbPryProyectos.class);
	}

	/**
	 * 
	 * @param estadoEnProcesoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryProyectos> findProyectosVencidos(Integer estadoEnProcesoIdn)
			throws DaoException {
		List<TbPryProyectos> proyectos = new ArrayList<TbPryProyectos>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryProyectos p where p.tbPryEstados.nbIdn ='"
							+ estadoEnProcesoIdn
							+ "'"
							+ " and p.dtFechafinal < CURRENT_DATE()");
			proyectos = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return proyectos;
	}

	/**
	 * 
	 * @param estadoAbiertoIdn
	 * @param estadoReanudadoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryProyectos> findProyectosEnProceso(
			Integer estadoAbiertoIdn, Integer estadoReanudadoIdn)
			throws DaoException {
		List<TbPryProyectos> proyectos = new ArrayList<TbPryProyectos>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryProyectos p where (p.tbPryEstados.nbIdn ='"
							+ estadoAbiertoIdn
							+ "'"
							+ " or p.tbPryEstados.nbIdn ='"
							+ estadoReanudadoIdn
							+ "')"
							+ " and p.dtFechainicial < CURRENT_DATE()");
			proyectos = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return proyectos;
	}

	/**
	 * 
	 * @param estadoIdn
	 * @param usuarioIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryProyectos> findProyectosByEstado(Integer estadoIdn,
			Integer usuarioIdn, Integer rolSuperUsuarioIdn, Integer rolUsuarioIdn) throws DaoException {
		List<TbPryProyectos> proyectos = new ArrayList<TbPryProyectos>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryProyectos p where p.tbPryEstados.nbIdn ='"
							+ estadoIdn
							+ "' and ('"+rolUsuarioIdn+"'='" +rolSuperUsuarioIdn
							+"' or exists(from TbPryParticipantexproyecto pp where "
							+ "p.nbIdn = pp.tbPryProyectos.nbIdn and pp.tbAdmUsuarios.nbIdn = '"
							+ usuarioIdn
							+ "') or exists(from TbPryAsesorxproyecto ap where "
							+ "p.nbIdn = ap.tbPryProyectos.nbIdn and ap.tbAdmUsuarios.nbIdn = '"
							+ usuarioIdn
							+ "') or p.tbAdmUsuarios.nbIdn = '"
							+ usuarioIdn + "')");
			proyectos = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return proyectos;
	}
}
