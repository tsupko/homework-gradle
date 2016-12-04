package service;

import dao.DAO;
import model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Alexander Tsupko (tsupko.alexander@yandex.ru)
 *         Copyright (c) 2016. All rights reserved.
 */
@Service
public class AuthorService {
    private DAO<Author> authorDAO;

    @Autowired
    public void setAuthorDAO(DAO<Author> authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Transactional
    public void insertOrUpdate(Author author) {
        if (author.getId() == null) {
            authorDAO.insert(author);
        } else {
            authorDAO.update(author);
        }
    }

    @Transactional
    public Author getAuthorById(Long id) {
        return authorDAO.getById(id);
    }

    @Transactional
    public List<Author> getAllAuthors() {
        return authorDAO.getAll();
    }

    @Transactional
    public void deleteAuthor(Author author) {
        authorDAO.delete(author);
    }

    @Transactional
    public void deleteAuthorById(Long id) {
        authorDAO.delete(id);
    }
}
