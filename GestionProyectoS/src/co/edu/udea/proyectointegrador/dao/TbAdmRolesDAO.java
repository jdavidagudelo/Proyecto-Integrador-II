package co.edu.udea.proyectointegrador.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbAdmRoles;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * Clase utilizada para acceder a la tabla de Roles de la base de datos.
 * */
public class TbAdmRolesDAO extends AbstractFacadeDAO<TbAdmRoles> {
	public TbAdmRolesDAO() {
		super(TbAdmRoles.class);
	}
	public TbAdmRoles findRolByNombre(String nombre) throws DaoException
	{
		TbAdmRoles rol = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbAdmRoles r where r.vrNombre ='"
							+ nombre + "'");
			rol = (TbAdmRoles) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rol;
	}
}
