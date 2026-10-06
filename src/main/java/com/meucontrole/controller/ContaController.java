package com.meucontrole.controller;

import com.meucontrole.model.Conta;
import com.meucontrole.service.CategoriaService;
import com.meucontrole.service.ContaService;
import com.meucontrole.service.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;
    private final PessoaService pessoaService;
    private final CategoriaService categoriaService;

    public ContaController(
            ContaService contaService,
            PessoaService pessoaService,
            CategoriaService categoriaService) {

        this.contaService = contaService;
        this.pessoaService = pessoaService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {

        prepararPagina(
                model,
                new Conta()
        );

        return "contas";
    }

    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute Conta conta,
            Model model) {

        try {

            contaService.salvar(conta);

            return "redirect:/contas?sucesso";

        } catch (IllegalArgumentException e) {

            model.addAttribute(
                    "erro",
                    e.getMessage()
            );

            prepararPagina(
                    model,
                    conta
            );

            return "contas";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Integer id,
            Model model) {

        Conta conta = contaService.buscarPorId(id);

        prepararPagina(
                model,
                conta
        );

        return "contas";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(
            @PathVariable Integer id) {

        contaService.excluir(id);

        return "redirect:/contas?excluido";
    }

    private void prepararPagina(
            Model model,
            Conta conta) {

        model.addAttribute(
                "conta",
                conta
        );

        model.addAttribute(
                "contas",
                contaService.listarTodas()
        );

        model.addAttribute(
                "pessoas",
                pessoaService.listarTodas()
        );

        model.addAttribute(
                "categorias",
                categoriaService.listarTodas()
        );
    }
}