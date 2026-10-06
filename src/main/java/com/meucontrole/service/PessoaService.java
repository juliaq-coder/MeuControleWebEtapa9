package com.meucontrole.service;

import com.meucontrole.model.Pessoa;
import com.meucontrole.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    public Pessoa salvar(Pessoa pessoa) {

        if (pessoa.getNome() == null ||
                pessoa.getNome().trim().length() < 2) {

            throw new IllegalArgumentException(
                    "O nome da pessoa deve ter pelo menos 2 caracteres."
            );
        }

        pessoa.setNome(pessoa.getNome().trim());

        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPorId(Integer id) {

        return pessoaRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Pessoa não encontrada."
                        )
                );
    }

    public void excluir(Integer id) {

        if (!pessoaRepository.existsById(id)) {

            throw new IllegalArgumentException(
                    "Pessoa não encontrada."
            );
        }

        pessoaRepository.deleteById(id);
    }

    public long contar() {
        return pessoaRepository.count();
    }
}