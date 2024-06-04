/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consultacep;

public class Endereco {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(EnderecoRec endereco){
        this.cep= endereco.cep();
        this.rua=endereco.logradouro();
        this.bairro= endereco.bairro();
        this.cidade= endereco.localidade();
        this.estado=endereco.uf();
    }

    @Override
    public String toString() {
        return " cep= " + cep + '\n' +
                " rua= " + rua + '\n' +
                " bairro= " + bairro + '\n' +
                " cidade= " + cidade + '\n' +
                " estado= " + estado ;
    }
}
