package com.meucontrole.service;

import com.meucontrole.model.Conta;
import com.meucontrole.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> listarTodas() {
        return contaRepository.findAll();
    }

    public Conta salvar(Conta conta) {

        if (conta.getNome() == null ||
                conta.getNome().trim().length() < 3) {

            throw new IllegalArgumentException(
                    "O nome da conta deve ter pelo menos 3 caracteres."
            );
        }

        if (conta.getValor() == null ||
                conta.getValor().compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException(
                    "O valor da conta deve ser maior que zero."
            );
        }

        if (conta.getVencimento() == null) {

            throw new IllegalArgumentException(
                    "A data de vencimento é obrigatória."
            );
        }

        if (conta.getStatus() == null ||
                conta.getStatus().isBlank()) {

            throw new IllegalArgumentException(
                    "O status é obrigatório."
            );
        }

        if (conta.getPessoa() == null ||
                conta.getPessoa().isBlank()) {

            throw new IllegalArgumentException(
                    "Selecione uma pessoa."
            );
        }

        if (conta.getCategoria() == null ||
                conta.getCategoria().isBlank()) {

            throw new IllegalArgumentException(
                    "Selecione uma categoria."
            );
        }

        conta.setNome(conta.getNome().trim());
        conta.setPessoa(conta.getPessoa().trim());
        conta.setCategoria(conta.getCategoria().trim());

        return contaRepository.save(conta);
    }

    public Conta buscarPorId(Integer id) {

        return contaRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Conta não encontrada."
                        )
                );
    }

    public void excluir(Integer id) {

        if (!contaRepository.existsById(id)) {

            throw new IllegalArgumentException(
                    "Conta não encontrada."
            );
        }

        contaRepository.deleteById(id);
    }

    public long contar() {
        return contaRepository.count();
    }
}