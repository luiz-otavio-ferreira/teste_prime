package Service;

import classes.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaService {

    public Double calcularIMC(Pessoa pessoa) {
        return pessoa.getPeso() / (converterAlturaMetros((double) pessoa.getAltura()) * converterAlturaMetros((double) pessoa.getAltura()));
    }

    public Double converterAlturaMetros(Double alturaCm){
        return (alturaCm/100);
    }

    public String categoriaIMC(Pessoa pessoa) {
        double imc = calcularIMC(pessoa);
        if (imc < 18.5) {
            return "MAGREZA";
        } else if (imc < 25.0) {
            return "NORMAL";
        } else if (imc < 30.0) {
            return "SOBREPESO";
        } else if (imc < 40.0) {
            return "OBESIDADE";
        } else {
            return "OBESIDADE GRAVE";
        }
    }


    private static int contarFuncoes(List<Pessoa> pessoas, String funcao) {
        int contagem = 0;
        for (Pessoa pessoa : pessoas) {
            if (funcao.equals(pessoa.getFuncao())) {
                contagem++;
            }
        }
        return contagem;
    }

    public void pessoaMaiorPeso(List<Pessoa> pessoas){
        List<Pessoa> pessoasComMaiorPeso = new ArrayList<>();
        double pesoMaximo = 0;

        for (Pessoa pessoa : pessoas) {
            double peso = pessoa.getPeso();

            if (peso > pesoMaximo) {
                pessoasComMaiorPeso.clear();
                pesoMaximo = peso;
            }

            if (peso == pesoMaximo) {
                pessoasComMaiorPeso.add(pessoa);
            }
        }

        if (!pessoasComMaiorPeso.isEmpty()) {
            System.out.println("Pessoas com o maior peso:");
            for (Pessoa pessoa : pessoasComMaiorPeso) {
                System.out.println("Nome: " + pessoa.getNome() + " " + pessoa.getSobrenome() + ", Peso: " + pessoa.getPeso());
            }
        } else {
            System.out.println("Não foram encontradas pessoas com o maior peso.");
        }
    }

    public void retornarQuantidadePessoasPorIMC(List<Pessoa> pessoas) {
        int magreza = 0;
        int normal = 0;
        int sobrepeso = 0;
        int obesidade = 0;
        int obesidadeGrave = 0;

        for (Pessoa pessoa: pessoas) {
            if("MAGREZA".equals(categoriaIMC(pessoa))){
                magreza++;

            }
            if("NORMAL".equals(categoriaIMC(pessoa))){
                normal++;
            }
            if("SOBREPESO".equals(categoriaIMC(pessoa))){
                sobrepeso++;
            }
            if("OBESIDADE".equals(categoriaIMC(pessoa))){
                obesidade++;
            }
            if("OBESIDADE GRAVE".equals(categoriaIMC(pessoa))){
                obesidadeGrave++;
            }
        }
        System.out.println("Pessoas por Faixa de peso: \nMagreza: "+ magreza + "\nNormal: " + normal + "\nSobrepeso: "+
                sobrepeso + "\nObesidade: " + obesidade +"\nObesidade grave: "+ obesidadeGrave);
    }

    public void listarPessoasObesas(List<Pessoa> pessoas) {
        List<Pessoa> listaObesos = new ArrayList<>();
        int contador = 0;
        for (Pessoa pessoa : pessoas) {
            if ("OBESIDADE".equals(categoriaIMC(pessoa)) || "OBESIDADE GRAVE".equals(categoriaIMC(pessoa))) {
                listaObesos.add(pessoa);
            }
        }
        int tamanho = listaObesos.size();

        for (Pessoa pessoa : listaObesos) {
            System.out.print("Nome: " + pessoa.getNome() + " " + pessoa.getSobrenome());

            if (contador < tamanho - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
            contador++;
        }
    }

    public void listarFuncoesMaisComuns(List<Pessoa> pessoas) {
        List<String> funcoesMaisEncontradas = new ArrayList<>();
        int maxContagem = 0;

        for (Pessoa pessoa : pessoas) {
            String funcao = pessoa.getFuncao();
            int contagem = contarFuncoes(pessoas, funcao);

            if (contagem > maxContagem) {
                maxContagem = contagem;
                funcoesMaisEncontradas.clear();
                funcoesMaisEncontradas.add(funcao);
            } else if (contagem == maxContagem && !funcoesMaisEncontradas.contains(funcao)) {
                funcoesMaisEncontradas.add(funcao);
            }
        }

        if (!funcoesMaisEncontradas.isEmpty()) {
            System.out.println("Funções mais encontradas:");
            for (String funcao : funcoesMaisEncontradas) {
                System.out.println(funcao + ": " + maxContagem + " vezes");
            }
        } else {
            System.out.println("Não foram encontradas funções.");
        }
    }
}
