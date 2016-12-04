package dao;

import model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alexander Tsupko (tsupko.alexander@yandex.ru)
 *         Copyright (c) 2016. All rights reserved.
 */
@Repository
public class AuthorDAOImpl implements DAO<Author> {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Author entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    public void delete(Author entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public void delete(Long id) {
        Author author = getById(id);
        if (author != null) {
            sessionFactory.getCurrentSession().delete(author);
        }
    }

    @Override
    public void update(Author entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Author> list = session.createQuery("SELECT a FROM Author a").list();
        return list;
    }

    @Override
    public Author getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Author author = session.load(Author.class, id);
        return author;
    }
}
