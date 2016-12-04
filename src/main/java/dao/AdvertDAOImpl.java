package dao;

import model.Advert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alexander Tsupko (tsupko.alexander@yandex.ru)
 *         Copyright (c) 2016. All rights reserved.
 */
@Repository
public class AdvertDAOImpl implements DAO<Advert> {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Advert entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    public void delete(Advert entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public void delete(Long id) {
        Advert advert = getById(id);
        if (advert != null) {
            sessionFactory.getCurrentSession().delete(advert);
        }
    }

    @Override
    public void update(Advert entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Advert> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Advert> list = session.createQuery("SELECT a FROM Advert a").list();
        return list;
    }

    @Override
    public Advert getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Advert advert = session.load(Advert.class, id);
        return advert;
    }
}
