package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbNtfUsrtpntfmedios;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfUsrtpntfmediosDAO extends
		AbstractFacadeDAO<TbNtfUsrtpntfmedios> {

	/**
	 * 
	 */
	public TbNtfUsrtpntfmediosDAO() {
		super(TbNtfUsrtpntfmedios.class);
	}

	/**
	 * 
	 * @param tipoMedioIdn
	 * @param tipoUsuarioIdn
	 * @return
	 * @throws DaoException
	 */
	public TbNtfUsrtpntfmedios findByForeignKey(Integer tipoMedioIdn,
			Integer tipoUsuarioIdn) throws DaoException {
		TbNtfUsrtpntfmedios usuario = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfUsrtpntfmedios t where "
							+ "t.tbNtfMediostipontf.nbIdn ='" + tipoMedioIdn
							+ "' and t.tbNtfUsuariostipontf.nbIdn='"
							+ tipoUsuarioIdn + "'");
			usuario = (TbNtfUsrtpntfmedios) query.uniqueResult();
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
	 * @param usuarioTipoNotificacionIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbNtfUsrtpntfmedios> findMediosByUsuarioTipoNotificacion(
			Integer usuarioTipoNotificacionIdn) throws DaoException {
		List<TbNtfUsrtpntfmedios> tiposUsuario = new ArrayList<TbNtfUsrtpntfmedios>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfUsrtpntfmedios u where u.tbNtfUsuariostipontf.nbIdn ='"
							+ usuarioTipoNotificacionIdn + "'");
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
