package Main;

import Service.ArquivoService;
import Service.EnderecoService;
import Service.PessoaService;
import classes.Pessoa;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EnderecoService endereco = new EnderecoService();
        PessoaService pessoaService = new PessoaService();
        ArquivoService arquivoService = new ArquivoService();
        List<Pessoa> pessoas = arquivoService.leituraInicialArquivo();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Exibir a pessoa com maior peso");
            System.out.println("2. Calcular IMC e exibir quantas pessoas existem em cada faixa");
            System.out.println("3. Exibir nome e sobrenome de todas as pessoas obesas");
            System.out.println("4. Exibir função mais encontrada e quantidade");
            System.out.println("5. Exibir cidades e quantidade de pessoas");
            System.out.println("0. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    pessoaService.pessoaMaiorPeso(pessoas);
                    break;
                case 2:
                    pessoaService.retornarQuantidadePessoasPorIMC(pessoas);
                    break;
                case 3:
                    pessoaService.listarPessoasObesas(pessoas);
                    break;
                case 4:
                    pessoaService.listarFuncoesMaisComuns(pessoas);
                    break;
                case 5:
                    endereco.contarCidadesEHabitantes(pessoas);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
