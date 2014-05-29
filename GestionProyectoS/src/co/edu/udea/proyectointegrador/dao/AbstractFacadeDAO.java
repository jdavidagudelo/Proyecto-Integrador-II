package co.edu.udea.proyectointegrador.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import co.edu.udea.proyectointegrador.exception.DaoException;

/**
 * Clase que permite utilizar el patrón facade para simplificar el acceso a la
 * base de datos. Esta clase permite un medio generico de acceso a la base de
 * datos, las subclases solo deben especificar el tipo de entidad concreta que
 * se desea manipular.
 * 
 * @author Juan David Agudelo jdaaa2009@gmail.com
 * @version 1.0
 * */
public abstract class AbstractFacadeDAO<T> extends HibernateDaoSupport {

	protected Class<T> entityClass;

	/**
	 * Constructor que recibe como argumento la clase de entidad que usará una
	 * clase heredada.
	 * 
	 * @param entityClass
	 *            Objeto de tipo Class que especifica el tipo de entidades que
	 *            serán usadas por esta clase.
	 * */
	public AbstractFacadeDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Método usado para obtener la lista de todos los registros de la entidad
	 * en la tabla correspondiente de la base de datos.
	 * 
	 * @return Lista con todos los registros de la entidad en la tabla
	 *         correspondiente de la base de datos.
	 * @throws DaoException
	 *             en caso de error en el acceso a la base de datos.
	 * */
	public List<T> findAll() throws DaoException {

		List<T> clientes = new ArrayList<T>();
		Session sesion = null;
		try {
			sesion = getSessionFactory().openSession();
			Transaction t = sesion.beginTransaction();
			@SuppressWarnings("unchecked")
			List<T> list = sesion.createCriteria(entityClass).list();
			clientes = list;
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return clientes;
	}

	/**
	 * Método usado para obtener un registro de la tabla de la base de datos
	 * teniendo en cuenta el id ingresado como argumento.
	 * 
	 * @param id
	 *            Identificador unico dentro de la tabla asociada con la entidad
	 *            dentro de la base de datos.
	 * @return el registro de la base de datos cuya clave primaria corresponde
	 *         al argumento ingresado.
	 * @throws DaoException
	 *             en caso de error en el acceso a la base de datos.
	 * */
	@SuppressWarnings("unchecked")
	public T get(Serializable id) throws DaoException {
		Session sesion = null;
		T data = null;
		try {
			sesion = getSessionFactory().openSession();
			Transaction t = sesion.beginTransaction();
			data = (T) sesion.get(entityClass, id);
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return data;
	}

	/**
	 * Metodo usado para insertar un nuevo registro en la tabla asociada con la
	 * entidad especifica.
	 * 
	 * @param inserted
	 *            el registro que se desea insertar en la base de datos.
	 * @return El mismo registro insertado.
	 * @throws DaoException
	 *             en caso de error en el acceso a la base de datos.
	 * */
	public T save(T inserted) throws DaoException {
		Session sesion = null;
		try {
			sesion = getSessionFactory().openSession();
			Transaction t = sesion.beginTransaction();
			sesion.save(inserted);
			t.commit();

		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return inserted;
	}

	/**
	 * Metodo usado para actualizar un registro existente en la base de datos.
	 * 
	 * @param updated
	 *            el registro que se desea modificar.
	 * @return el registro modificado.
	 * 
	 * */
	public T update(T updated) throws DaoException {
		Session sesion = null;
		try {
			sesion = getSessionFactory().openSession();
			Transaction t = sesion.beginTransaction();
			sesion.update(updated);
			t.commit();

		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return updated;
	}

	public void delete(T deleted) throws DaoException {
		Session sesion = null;
		try {
			sesion = getSessionFactory().openSession();
			Transaction t = sesion.beginTransaction();
			sesion.delete(deleted);
			t.commit();
		} catch (HibernateException e) {
			throw new DaoException(e);
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}

	}
}
