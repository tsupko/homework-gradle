package service;

import dao.DAO;
import model.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Alexander Tsupko (tsupko.alexander@yandex.ru)
 *         Copyright (c) 2016. All rights reserved.
 */
@Service
public class AdvertService {
    private DAO<Advert> advertDAO;

    @Autowired
    public void setAdvertDAO(DAO<Advert> advertDAO) {
        this.advertDAO = advertDAO;
    }

    @Transactional
    public void insertOrUpdate(Advert advert) {
        if (advert.getId() == null) {
            advertDAO.insert(advert);
        } else {
            advertDAO.update(advert);
        }
    }

    @Transactional
    public Advert getAdvertById(Long id) {
        return advertDAO.getById(id);
    }

    @Transactional
    public List<Advert> getAllAdverts() {
        return advertDAO.getAll();
    }

    @Transactional
    public void deleteAdvert(Advert advert) {
        advertDAO.delete(advert);
    }

    @Transactional
    public void deleteAdvertById(Long id) {
        advertDAO.delete(id);
    }
}
