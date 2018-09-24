package br.com.ppgcc.bancoDeDados.orm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    Autor     : José Carlos de Freitas
    Criado em : 24/09/2018, 16:57:57
    Documento : IndexController
 */

@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping
    public ModelAndView indexPage() {
        return new ModelAndView("index");
    }
}
