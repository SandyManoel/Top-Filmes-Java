import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class Projeto {
    public static void main(String[] args) throws Exception {

        // pegar dados dos top 250 filmes, fazer conexão http
        // titulo, poster, classificacao
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
    
        var parse = new Classe();
        List<Map<String, String>> listaDeFilmes = parse.parse(body);
        //exibir dados
        for(Map<String,String> filme: listaDeFilmes){
         System.out.println(filme.get("title"));
         System.out.println(filme.get("image"));
         System.out.println(filme.get("i"));
        }
    }
}