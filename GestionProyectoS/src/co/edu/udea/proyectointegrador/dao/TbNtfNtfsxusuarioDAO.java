package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbNtfNtfsxusuario;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbNtfNtfsxusuarioDAO extends AbstractFacadeDAO<TbNtfNtfsxusuario> {
	public TbNtfNtfsxusuarioDAO() {
		super(TbNtfNtfsxusuario.class);
	}

	/**
	 * Metodo usado para obtener la notificaciones recibidas por el usuario
	 * ingresado como argumento.
	 * 
	 * @param usuarioIdn
	 *            id del usuario
	 * @return lista de las notificaciones recibidas por el usuario con el id
	 *         ingresado como argumento
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbNtfNtfsxusuario> findNotificacionesByUsuario(
			Integer usuarioIdn) throws DaoException {
		List<TbNtfNtfsxusuario> notificaciones = new ArrayList<TbNtfNtfsxusuario>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbNtfNtfsxusuario u where u.tbAdmUsuarios.nbIdn ='"
							+ usuarioIdn + "'");
			notificaciones = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return notificaciones;
	}
}
