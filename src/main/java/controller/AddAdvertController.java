package controller;

import model.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.AdvertService;

/**
 * @author Alexander Tsupko (tsupko.alexander@yandex.ru)
 *         Copyright (c) 2016. All rights reserved.
 */
@Controller
public class AddAdvertController {
    private AdvertService advertService;

    @Autowired
    public void setAdvertService(AdvertService advertService) {
        this.advertService = advertService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getPage() {
        return "addAdvert";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAdvert(@RequestParam(name = "title") String title, @RequestParam(name = "text") String text) {
        Advert advert = new Advert(title, text);
        advertService.insertOrUpdate(advert);
        return "redirect:/showAdverts";
    }
}
