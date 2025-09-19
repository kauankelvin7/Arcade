package com.group.jogos;

import com.group.cliente.Pessoa;

public class Jogo {
    public String nome;
    public String categoria;
    public String descricao;
    int custo;
    int anoLancamento;

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Jogo(String nome, String categoria, String descricao, int anoLancamento, int custo) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
        this.custo = custo;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Descrição: " + descricao);
        System.out.println("Ano de lançamento: " + anoLancamento);
    }

    public void jogar(Pessoa pessoa) {
        if (pessoa.getCreditos() >= custo) {
            System.out.println("Jogando...");
            pessoa.descontar(custo);
        } else {
            System.out.println("Créditos insuficientes para jogar.");
        }
    }


}
