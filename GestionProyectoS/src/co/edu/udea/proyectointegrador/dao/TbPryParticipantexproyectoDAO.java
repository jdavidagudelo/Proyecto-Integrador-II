package co.edu.udea.proyectointegrador.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.proyectointegrador.dto.TbPryParticipantexproyecto;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * 
 * @author juan
 * 
 */
public class TbPryParticipantexproyectoDAO extends
		AbstractFacadeDAO<TbPryParticipantexproyecto> {

	/**
	 * 
	 */
	public TbPryParticipantexproyectoDAO() {
		super(TbPryParticipantexproyecto.class);
	}

	/**
	 * 
	 * @param proyectoIdn
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<TbPryParticipantexproyecto> findByProyecto(Integer proyectoIdn)
			throws DaoException {

		List<TbPryParticipantexproyecto> participantes = new ArrayList<TbPryParticipantexproyecto>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryParticipantexproyecto p where "
							+ "p.tbPryProyectos.nbIdn='" + proyectoIdn + "'");
			participantes = (List<TbPryParticipantexproyecto>) query.list();
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
	 * @param proyectoIdn
	 * @param participanteIdn
	 * @return
	 * @throws DaoException
	 */
	public TbPryParticipantexproyecto findByForeignKey(Integer proyectoIdn,
			Integer participanteIdn) throws DaoException {
		TbPryParticipantexproyecto participante = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session
					.createQuery("from TbPryParticipantexproyecto p where "
							+ "p.tbAdmUsuarios.nbIdn ='" + participanteIdn
							+ "' and p.tbPryProyectos.nbIdn='" + proyectoIdn
							+ "'");
			participante = (TbPryParticipantexproyecto) query.uniqueResult();
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
