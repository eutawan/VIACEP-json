package api;

import com.google.gson.Gson;
import model.Address;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class CepApiConsumer {

    public Address getAddress(String cep, String name) throws IOException, InterruptedException {
        // configura a url da api
        var url = "http://viacep.com.br/ws/".concat(cep).concat("/xml/");

        // cria o objeto responsável pela request
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        var httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
        // cria o objeto response da request
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        // biblioteca que converte o formato JSON em objeto Java
        var gson = new Gson();
        // converte o formato JSON para o objeto Address
        var address = gson.fromJson(response.body(), Address.class);
        address.setName(name);

        return address;
    }
}
// NewBuilder é uma convenção para criar um objeto em Java
