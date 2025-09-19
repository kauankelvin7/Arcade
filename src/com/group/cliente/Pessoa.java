package com.group.cliente;

public class Pessoa {
    private String nome;
    private String genero;
    private int idade;
    private int creditos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Pessoa(String nome, String genero, int idade) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.creditos = 0;
    }

    public void comprarCredito(int credito) {
        try {
            if (credito > 0) {
                creditos += credito;
                System.out.println("Creditos adicionados com sucesso!\nCreditos: " + creditos);
            } else {
                System.out.println("Digite uma quantidade válida e tente novamente.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void descontar(int valor) {
        creditos -= valor;
        System.out.println("Creditos restantes: " + creditos);
    }
}


