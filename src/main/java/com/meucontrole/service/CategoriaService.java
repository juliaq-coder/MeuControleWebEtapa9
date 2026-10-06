package com.meucontrole.service;

import com.meucontrole.model.Categoria;
import com.meucontrole.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria salvar(Categoria categoria) {

        if (categoria.getNome() == null ||
                categoria.getNome().trim().length() < 2) {

            throw new IllegalArgumentException(
                    "O nome da categoria deve ter pelo menos 2 caracteres."
            );
        }

        categoria.setNome(categoria.getNome().trim());

        return categoriaRepository.save(categoria);
    }

    public Categoria buscarPorId(Integer id) {

        return categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Categoria não encontrada."
                        )
                );
    }

    public void excluir(Integer id) {

        if (!categoriaRepository.existsById(id)) {

            throw new IllegalArgumentException(
                    "Categoria não encontrada."
            );
        }

        categoriaRepository.deleteById(id);
    }

    public long contar() {
        return categoriaRepository.count();
    }
}