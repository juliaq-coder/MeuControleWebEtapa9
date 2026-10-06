package com.meucontrole.controller;

import com.meucontrole.model.Pessoa;
import com.meucontrole.service.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("pessoa", new Pessoa());
        model.addAttribute("pessoas", pessoaService.listarTodas());

        return "pessoas";
    }

    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute Pessoa pessoa,
            Model model) {

        try {

            pessoaService.salvar(pessoa);

            return "redirect:/pessoas?sucesso";

        } catch (IllegalArgumentException e) {

            model.addAttribute("erro", e.getMessage());
            model.addAttribute("pessoa", pessoa);
            model.addAttribute(
                    "pessoas",
                    pessoaService.listarTodas()
            );

            return "pessoas";
        }
    }

    @PostMapping("/excluir/{id}")
    public String excluir(
            @PathVariable Integer id) {

        pessoaService.excluir(id);

        return "redirect:/pessoas?excluido";
    }
}