/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consultacep;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conect {
    private String endereco;
    public Conect(String endereco) {
        this.endereco="https://viacep.com.br/ws/"+endereco+"/json/";
    }

    public String conectApi()  {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Validador valida= new Validador();
            if(valida.validaErro(response.body())) {
                return response.body();
            }else{return "CEP NÃO ENCONTRADO";}
            
        } catch (IOException e) {
            return "ERRO "+e.getMessage();
        } catch (InterruptedException e) {
            return "ERRO2 "+e.getMessage();
         }
    }

    @Override
    public String toString() {
        return endereco;
    }
}
