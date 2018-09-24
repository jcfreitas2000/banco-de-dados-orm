package br.com.ppgcc.bancoDeDados.orm.controller;

import br.com.ppgcc.bancoDeDados.orm.model.Aluno;
import br.com.ppgcc.bancoDeDados.orm.service.AlunosService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    Autor     : José Carlos de Freitas
    Criado em : 24/09/2018, 18:17:55
    Documento : AlunosController
 */
@Controller
@RequestMapping("alunos")
public class AlunosController {

    @Autowired
    private AlunosService alunosService;

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("alunos/gerenciar")
                .addObject("alunos", alunosService.findAll());
    }

    @GetMapping("pesquisar")
    public ModelAndView pesquisar(String nome) {
        if (nome.isEmpty()) {
            return new ModelAndView("redirect:/alunos");
        }

        return new ModelAndView("alunos/pesquisar")
                .addObject("nome", nome)
                .addObject("alunos", alunosService.findAllByNome(nome));
    }

    @GetMapping("novo")
    public ModelAndView novo(Aluno aluno) {
        return new ModelAndView("alunos/novo")
                .addObject("alunos", alunosService.findAll());
    }

    @PostMapping("novo")
    public ModelAndView salvar(Aluno aluno) {
        alunosService.salvar(aluno);

        return new ModelAndView("redirect:/alunos");
    }

    @GetMapping("{id}/editar")
    public ModelAndView editar(Aluno aluno) {
        return new ModelAndView("alunos/editar")
                .addObject("alunos", alunosService.findAll())
                .addObject("aluno", alunosService.find(aluno));
    }

    @PostMapping("{id}/editar")
    public ModelAndView atualizar(Aluno aluno) {
        alunosService.editar(aluno);

        return new ModelAndView("redirect:/alunos/" + aluno.getId() + "/editar");
    }

    @PostMapping("{id}/remover")
    public String remover(Aluno aluno, HttpServletRequest request) {
        alunosService.remover(aluno);

        return "redirect:" + request.getHeader("Referer");
    }
}
