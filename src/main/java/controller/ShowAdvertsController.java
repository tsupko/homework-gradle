package controller;

import model.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AdvertService;

import java.util.List;

/**
 * @author Alexander Tsupko (tsupko.alexander@yandex.ru)
 *         Copyright (c) 2016. All rights reserved.
 */
@Controller
public class ShowAdvertsController {
    private AdvertService advertService;

    @Autowired
    public void setAdvertService(AdvertService advertService) {
        this.advertService = advertService;
    }

    @RequestMapping(value = "/showAdverts", method = RequestMethod.GET)
    public String show(Model model) {
        List<Advert> list = advertService.getAllAdverts();
        model.addAttribute("adverts", list);
        return "showAdverts";
    }
}
