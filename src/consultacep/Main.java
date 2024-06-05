package consultacep;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//                .create();
        int opcao=0;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Type type = new TypeToken<EnderecoRec>(){}.getType();

        List<Endereco> enderecos = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        Validador valida = new Validador();
        String cep;

        do {
            System.out.println("""
                             =================================
                             Menu do Consulta CEP, o que deseja fazer hoje?
                             1 - Consulta um CEP
                             2 - Listar historico de enderecos
                             3 - sair
                            """);
            opcao= read.nextInt();
            System.out.println(" =================================");

            switch(opcao) {
                case 1:
                System.out.println("Informe o CEP que deseja buscar: ");
                cep = read.next();
                if (valida.validaCep(cep)) {
                    Conect conectar = new Conect(cep);
                    String json = conectar.conectApi();

                    if(valida.validaErro(json)) {
                        EnderecoRec enderecoRec = gson.fromJson(json, type);
                        Endereco endereco = new Endereco(enderecoRec);

                        enderecos.add(endereco);
                        System.out.println(endereco);
                    }else{System.out.println("CEP nao encontrado");}
                } else {
                    System.out.println("Cep invalido");
                }
                    break;

                case 2:
                    for(Endereco e:enderecos){
                        System.out.println(" =================================");
                        System.out.println(e);
                    }
                    break;
            }
        } while (opcao!=3);

        for(Endereco e:enderecos){
            System.out.println(" =================================");
            System.out.println(e);
        }

        FileWriter escrita = new FileWriter("enderecos.json");
        escrita.write(gson.toJson(enderecos));
        escrita.close();
        System.out.println("O programa finalizado!");

    }
}
