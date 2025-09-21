import com.group.cliente.Pessoa;
import com.group.jogos.Jogo;
import com.group.jogos.StreetFighter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoaLogada = null;

        List<Jogo> jogos = new ArrayList<>();
        jogos.add(new StreetFighter());
        jogos.add(new Jogo("Minecraft", "Sandbox", "Jogo de blocos e sobrevivência", 2011, 15));
        jogos.add(new Jogo("FIFA 25", "Esporte", "Simulador de futebol", 2025, 20));

        while (continuar) {
            System.out.println("===========MENU=============");
            System.out.println(" 1 - Cadastrar Pessoa");
            System.out.println(" 2 - Logar Pessoa");
            System.out.println(" 3 - Escolher jogo");
            System.out.println(" 4 - Recarregar créditos");
            System.out.println(" 5 - Ver dados da Pessoa logada");
            System.out.println(" 6 - Sair");
            System.out.println("============================");

            String opcao = scan.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Digite seu nome:");
                    String nome = scan.nextLine();

                    System.out.println("Digite seu gênero:");
                    String genero = scan.nextLine();

                    System.out.println("Digite sua idade:");
                    int idade = Integer.parseInt(scan.nextLine());

                    Pessoa novaPessoa = new Pessoa(nome, genero, idade);
                    pessoas.add(novaPessoa);
                    System.out.println("Cadastrado com sucesso!");
                    break;

                case "2":
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada!");
                        break;
                    }
                    System.out.println("===== Pessoas Cadastradas =====");
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println((i + 1) + " - " + pessoas.get(i).getNome());
                    }
                    System.out.println("Escolha o número da pessoa para logar:");
                    int escolhaPessoa = Integer.parseInt(scan.nextLine());

                    if (escolhaPessoa >= 1 && escolhaPessoa <= pessoas.size()) {
                        pessoaLogada = pessoas.get(escolhaPessoa - 1);
                        System.out.println("Pessoa logada: " + pessoaLogada.getNome());
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case "3":
                    if (pessoaLogada == null) {
                        System.out.println("Nenhuma pessoa logada! Faça login primeiro.");
                        break;
                    }
                    System.out.println("===== Lista de Jogos =====");
                    for (int i = 0; i < jogos.size(); i++) {
                        System.out.println((i + 1) + " - " + jogos.get(i).getNome() + " (Custo: " + jogos.get(i).getCusto() + ")");
                    }
                    System.out.println("Escolha o número do jogo:");
                    int escolhaJogo = Integer.parseInt(scan.nextLine());

                    if (escolhaJogo >= 1 && escolhaJogo <= jogos.size()) {
                        Jogo jogoEscolhido = jogos.get(escolhaJogo - 1);
                        jogoEscolhido.jogar(pessoaLogada);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case "4":
                    if (pessoaLogada == null) {
                        System.out.println("Nenhuma pessoa logada! Faça login primeiro.");
                        break;
                    }
                    System.out.println("Digite a quantidade de créditos para adicionar:");
                    int creditos = Integer.parseInt(scan.nextLine());
                    pessoaLogada.comprarCredito(creditos);
                    break;

                case "5":
                    if (pessoaLogada != null) {
                        System.out.println("===== Dados da Pessoa =====");
                        System.out.println("Nome: " + pessoaLogada.getNome());
                        System.out.println("Gênero: " + pessoaLogada.getGenero());
                        System.out.println("Idade: " + pessoaLogada.getIdade());
                        System.out.println("Créditos: " + pessoaLogada.getCreditos());
                    } else {
                        System.out.println("Nenhuma pessoa logada no momento.");
                    }
                    break;

                case "6":
                    continuar = false;
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scan.close();
    }
}


