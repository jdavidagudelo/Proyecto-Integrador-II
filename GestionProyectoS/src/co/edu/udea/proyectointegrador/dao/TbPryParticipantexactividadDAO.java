package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryParticipantexactividad;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryParticipantexactividadDAO extends
		AbstractFacadeDAO<TbPryParticipantexactividad> {

	/**
	 * 
	 */
	public TbPryParticipantexactividadDAO() {
		super(TbPryParticipantexactividad.class);
	}

	/**
	 * 
	 * @param actividadIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryParticipantexactividad> findByActividad(
			Integer actividadIdn) throws DaoException {

		List<TbPryParticipantexactividad> participantes = new ArrayList<TbPryParticipantexactividad>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryParticipantexactividad p where "
							+ "p.tbPryActividades.nbIdn='" + actividadIdn + "'");
			participantes = (List<TbPryParticipantexactividad>) query.list();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return participantes;
	}

	/**
	 * 
	 * @param actividadIdn
	 * @param participanteIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryParticipantexactividad findByForeignKey(Integer actividadIdn,
			Integer participanteIdn) throws DaoException {
		TbPryParticipantexactividad participante = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryParticipantexactividad p where "
							+ "p.tbAdmUsuarios.nbIdn ='" + participanteIdn
							+ "' and p.tbPryActividades.nbIdn='" + actividadIdn
							+ "'");
			participante = (TbPryParticipantexactividad) query.uniqueResult();
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return participante;
	}
}
