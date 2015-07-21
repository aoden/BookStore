package com.tdt.bookstore.dao;

import org.hibernate.*;
import org.hibernate.criterion.Projections;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class AbstractDao<T, K extends Serializable> implements PagingDao<T, K> {

    protected SessionFactory sessionFactory;

    public AbstractDao() {
    }

    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {

        return sessionFactory.openSession();
    }


    public abstract Class<T> getEntityClass();

    protected Map<String, Object> getParamsMap() {

        return new HashMap<String, Object>();
    }

    @Override
    public void merge(T entity) throws HibernateException {

        Session session = getSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(Serializable id) {

        return (T) sessionFactory.openSession().get(getEntityClass(), id);
    }


    @SuppressWarnings("unchecked")
    @Override
    public T load(Serializable id) throws HibernateException {

        return (T) sessionFactory.openSession().load(getEntityClass(), id);
    }


    @Override
    public void save(T entity) throws HibernateException {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(T entity) throws HibernateException {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(T entity) throws HibernateException {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }


    @Override
    public Object find(String queryString, Map<String, Object> params,
                       int begin, int end) throws HibernateException {

        Session session = getSession();

        Query query = session.createQuery(queryString);
        if (params != null)
            //iterate through the map and set query parameters
            for (Map.Entry<String, Object> entry : params.entrySet()) {

                query.setParameter(entry.getKey(), entry.getValue());
            }
        try {

            return query.uniqueResult();
        } catch (NonUniqueResultException e) {

            return query.setFirstResult(begin).setMaxResults(end).list();
        }

    }

    @Override
    public Long findTotalPages(Integer limit) throws HibernateException {

        try {

            if (limit < 0) return null;
            Session session = getSession();
            Criteria criteria = session.createCriteria(getEntityClass()).setProjection(Projections.rowCount());
            Long total = (Long) criteria.uniqueResult();

            return total % (long) limit == 0 ? total / (long) limit : total / (long) limit + 1;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

    }


    @Override
    public Long findTotalPages(Long recordCount, Integer limit) {

        return recordCount / (long) limit == 0 ? recordCount / (long) limit : recordCount / (long) limit + 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findList(String queryString, Map<String, Object> params,
                            int begin, int end) {

        Session session = getSession();
        Query query = session.createQuery(queryString);
        if (params != null)
            //iterate through the map and set query parameters
            for (Map.Entry<String, Object> entry : params.entrySet()) {

                query.setParameter(entry.getKey(), entry.getValue());
            }

        query.setFirstResult(begin).setMaxResults(end);
        return query.list();
    }


}
