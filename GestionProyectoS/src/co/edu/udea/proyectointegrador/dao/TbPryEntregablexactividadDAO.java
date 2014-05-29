package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.edu.udea.proyectointegrador.dto.TbPryEntregablexactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;

public class TbPryEntregablexactividadDAO extends AbstractFacadeDAO<TbPryEntregablexactividad>{
	
	public TbPryEntregablexactividadDAO()
	{
		super(TbPryEntregablexactividad.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<TbPryEntregablexactividad> findByActividad(Integer actividadIdn)
			throws DaoException {
		List<TbPryEntregablexactividad> entregables = new ArrayList<TbPryEntregablexactividad>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("from TbPryEntregablexactividad p where "
					+ "p.tbPryActividades.nbIdn='" + actividadIdn + "'");
			entregables = (List<TbPryEntregablexactividad>) query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return entregables;
	}
}
