package consultacep;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        Scanner read= new Scanner(System.in);
        Validador valida= new Validador();
        String cep;
        
        System.out.println("Informe o CEP que deseja buscar: ");
        cep=read.next();
        if(valida.validaCep(cep)){
            System.out.println("Cep valido");
        Conect conectar= new Conect(cep);
        System.out.println(conectar.conectApi());
        EnderecoRec enderecoRec= gson.fromJson(conectar.conectApi(),EnderecoRec.class);
            System.out.println(enderecoRec);
            Endereco endereco= new Endereco(enderecoRec);
            System.out.println(endereco);
        }
        else{System.out.println("Cep invalido");}
        
    }
}
