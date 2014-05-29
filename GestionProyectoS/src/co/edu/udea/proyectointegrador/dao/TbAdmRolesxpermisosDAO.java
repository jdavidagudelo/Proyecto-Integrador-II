package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbAdmRolesxpermisos;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * Clase utilizada para acceder a la tabla de roles x permisos de la base de
 * datos.
 * */
public class TbAdmRolesxpermisosDAO extends
		AbstractFacadeDAO<TbAdmRolesxpermisos> {
	public TbAdmRolesxpermisosDAO() {
		super(TbAdmRolesxpermisos.class);
	}

	/**
	 * Metodo usado para obtener la lista de permisos asociados con un rol.
	 * 
	 * @param rolId
	 *            id del rol para el que se desean buscar los permisos
	 * @return lista de permisos asociados con un rol
	 * */
	public List<TbAdmRolesxpermisos> findById(Integer rolId)
			throws DaoException {
		List<TbAdmRolesxpermisos> clientes = new ArrayList<TbAdmRolesxpermisos>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbAdmRolesxpermisos r where r.tbAdmRoles.nbIdn ="
							+ rolId + "");
			@SuppressWarnings("unchecked")
			List<TbAdmRolesxpermisos> list = query.list();
			clientes = list;
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return clientes;
	}

	/**
	 * Permite obtener el rol x permiso con el rolId y permisoId ingresados como
	 * argumento
	 * 
	 * @param rolId
	 *            id del rol
	 * @param permisoIdn
	 *            id del permiso
	 * @return el rol x permiso asociado con el rol y permiso
	 * @throws DaoException
	 */
	public TbAdmRolesxpermisos findByForeignKey(Integer rolId,
			Integer permisoIdn) throws DaoException {
		TbAdmRolesxpermisos permiso = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbAdmRolesxpermisos r where r.tbAdmRoles.nbIdn ='"
							+ rolId
							+ "'"
							+ " and r.tbAdmPermisos.nbIdn='"
							+ permisoIdn + "'");
			permiso = (TbAdmRolesxpermisos) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return permiso;
	}
}
