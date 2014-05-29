package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbAdmPermisos;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * Clase utilizada para acceder a la tabla de permisos de la base de datos.
 * */
public class TbAdmPermisosDAO extends AbstractFacadeDAO<TbAdmPermisos> {
	public TbAdmPermisosDAO() {
		super(TbAdmPermisos.class);
	}

	/**
	 * Metodo usado para obtener los permisos de un tipo especifico.
	 * 
	 * @param tipo
	 *            el tipo de permiso que se desea obtener de la base de datos
	 * @return la lista de permisos de la base de datos
	 * */
	@SuppressWarnings("unchecked")
	public List<TbAdmPermisos> findPermisosByTipo(String tipo)
			throws DaoException {
		List<TbAdmPermisos> permisos = new ArrayList<TbAdmPermisos>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbAdmPermisos p where p.vrTipo ='"
							+ tipo + "'");
			permisos = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return permisos;
	}
}
