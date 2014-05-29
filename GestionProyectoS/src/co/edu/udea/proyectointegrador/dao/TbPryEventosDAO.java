package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryEventos;
import co.edu.udea.proyectointegrador.exception.DaoException;

public class TbPryEventosDAO extends AbstractFacadeDAO<TbPryEventos> {
	public TbPryEventosDAO()
	{
		super(TbPryEventos.class);
	}
	@SuppressWarnings("unchecked")
	public List<TbPryEventos> findEventosByProyecto(Integer proyectoIdn) throws DaoException
	{
		List<TbPryEventos> eventos = new ArrayList<TbPryEventos>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryEventos e where e.tbPryProyectos.nbIdn ='"
							+ proyectoIdn
							+ "'");
			eventos = query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return eventos;
	}
}
