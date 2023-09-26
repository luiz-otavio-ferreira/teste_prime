package Service;

import classes.Endereco;
import classes.Pessoa;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnderecoService {

    public void contarCidadesEHabitantes(List<Pessoa> pessoas) {
        Map<String, Endereco> cidades = new HashMap<>();

        for (Pessoa pessoa : pessoas) {
            String cep = pessoa.getCEP();
            if (cep != null && !cep.isEmpty()) {
                Endereco endereco = obterCidadePorCEP(cep);

                if (endereco != null) {
                    String chave = endereco.getLocalidade() + " - " + endereco.getUf();
                    Endereco cidade = cidades.getOrDefault(chave, endereco);
                    cidade.incrementarMoradores();
                    cidades.put(chave, cidade);
                }
            }
        }

        if (!cidades.isEmpty()) {
            for (Endereco cidade : cidades.values()) {
                String plural = cidade.getMoradores() == 1 ? " pessoa" : " pessoas";
                System.out.println(cidade + plural);
            }
        } else {
            System.out.println("Nenhuma cidade encontrada.");
        }
}

    public static Endereco obterCidadePorCEP(String cep) {
        try {
            cep = cep.replace("-","").replace(".","");
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    response.append(line);
                }

                br.close();
                String json = response.toString();

                Gson gson = new Gson();
                Endereco endereco = gson.fromJson(json, Endereco.class);

                return endereco;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
