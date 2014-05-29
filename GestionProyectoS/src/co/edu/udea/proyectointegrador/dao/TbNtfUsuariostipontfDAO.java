package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbNtfUsuariostipontf;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfUsuariostipontfDAO extends
		AbstractFacadeDAO<TbNtfUsuariostipontf> {

	/**
	 * 
	 */
	public TbNtfUsuariostipontfDAO() {
		super(TbNtfUsuariostipontf.class);
	}

	/**
	 * 
	 * @param tipoRolIdn
	 * @param usuarioIdn
	 * @return
	 * @throws DaoException
	 */
	public TbNtfUsuariostipontf findByForeignKey(Integer tipoRolIdn,
			Integer usuarioIdn) throws DaoException {
		TbNtfUsuariostipontf usuario = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfUsuariostipontf t where "
							+ "t.tbNtfsTipontfsroles.nbIdn ='" + tipoRolIdn
							+ "' and t.tbAdmUsuarios.nbIdn='" + usuarioIdn
							+ "'");
			usuario = (TbNtfUsuariostipontf) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return usuario;
	}

	/**
	 * 
	 * @param usuarioIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbNtfUsuariostipontf> findTipoNotificacionByUsuario(
			Integer usuarioIdn) throws DaoException {
		List<TbNtfUsuariostipontf> tiposUsuario = new ArrayList<TbNtfUsuariostipontf>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfUsuariostipontf u where u.tbAdmUsuarios.nbIdn ='"
							+ usuarioIdn + "'");
			tiposUsuario = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return tiposUsuario;
	}

	/**
	 * 
	 * @param tipoNotificacionIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbNtfUsuariostipontf> findTipoNotificacionByTipoNotificacion(
			Integer tipoNotificacionIdn) throws DaoException {
		List<TbNtfUsuariostipontf> tiposUsuario = new ArrayList<TbNtfUsuariostipontf>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfUsuariostipontf u where u.tbNtfsTipontfsroles.nbIdn ='"
							+ tipoNotificacionIdn + "'");
			tiposUsuario = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return tiposUsuario;
	}
}
