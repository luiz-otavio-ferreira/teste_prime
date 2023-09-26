package Service;

import classes.Pessoa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArquivoService {
    public List<Pessoa> leituraInicialArquivo(){
        List<Pessoa> pessoas = new ArrayList<>();
        ClassLoader classLoader = PessoaService.class.getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream("database.csv");

        try (BufferedReader arquivo = new BufferedReader(new InputStreamReader(inputStream))) {
            String linha = arquivo.readLine();

            while ((linha = arquivo.readLine()) != null) {

                String[] info = splitCSVLine(linha);

                String nome = info[0].trim();
                String sobrenome = info[1].trim();
                String ocupacao = info[2].trim();
                String empresa = info[3].trim();
                String veiculo = info[4].trim();
                Double peso = Double.parseDouble(info[5].trim());
                Integer altura = Integer.parseInt(info[6].trim());
                String CEP = (info.length == 8) ? info[7].trim() : null;

                Pessoa pessoa = new Pessoa(nome, sobrenome, ocupacao, empresa, veiculo, peso, altura, CEP);
                pessoas.add(pessoa);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public static String[] splitCSVLine(String line) {
        List<String> campos = new ArrayList<>();

        line = line.replaceAll("\"\"","\"");
        if (line.startsWith("\"")) {
            line = line.substring(1);
        }
        if (line.endsWith("\"")) {
            line = line.substring(0, line.length() - 1);
        }

        String[] partes = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

        for (int i = 0; i < partes.length; i++) {
            partes[i] = partes[i].replaceAll("^\"|\"$", "");
            campos.add(partes[i].trim());
        }

        return campos.toArray(new String[0]);
    }


}
