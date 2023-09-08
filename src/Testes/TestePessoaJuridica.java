package Testes;

import Model.PessoaJuridica;

public class TestePessoaJuridica {
    public static void main(String[] args) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNome("Mestre Kame");
        pessoaJuridica.setId(255);
        pessoaJuridica.setCnpj("21511248");
        pessoaJuridica.exibir();
    }
}
