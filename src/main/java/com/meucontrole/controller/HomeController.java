package com.meucontrole.controller;

import com.meucontrole.service.CategoriaService;
import com.meucontrole.service.ContaService;
import com.meucontrole.service.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ContaService contaService;
    private final PessoaService pessoaService;
    private final CategoriaService categoriaService;

    public HomeController(
            ContaService contaService,
            PessoaService pessoaService,
            CategoriaService categoriaService) {

        this.contaService = contaService;
        this.pessoaService = pessoaService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public String inicio(Model model) {

        model.addAttribute(
                "quantidadeContas",
                contaService.contar()
        );

        model.addAttribute(
                "quantidadePessoas",
                pessoaService.contar()
        );

        model.addAttribute(
                "quantidadeCategorias",
                categoriaService.contar()
        );

        model.addAttribute(
                "contas",
                contaService.listarTodas()
        );

        return "index";
    }
}