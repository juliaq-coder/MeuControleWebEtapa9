package com.meucontrole.controller;

import com.meucontrole.model.Categoria;
import com.meucontrole.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(
            CategoriaService categoriaService) {

        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "categoria",
                new Categoria()
        );

        model.addAttribute(
                "categorias",
                categoriaService.listarTodas()
        );

        return "categorias";
    }

    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute Categoria categoria,
            Model model) {

        try {

            categoriaService.salvar(categoria);

            return "redirect:/categorias?sucesso";

        } catch (IllegalArgumentException e) {

            model.addAttribute(
                    "erro",
                    e.getMessage()
            );

            model.addAttribute(
                    "categoria",
                    categoria
            );

            model.addAttribute(
                    "categorias",
                    categoriaService.listarTodas()
            );

            return "categorias";
        }
    }

    @PostMapping("/excluir/{id}")
    public String excluir(
            @PathVariable Integer id) {

        categoriaService.excluir(id);

        return "redirect:/categorias?excluido";
    }
}