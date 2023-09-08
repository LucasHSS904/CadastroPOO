package Testes;

import Model.PessoaFisica;

public class TestePessoaFisica {
    public static void main(String[] args) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome("Lucas");
        pessoaFisica.setId(20);
        pessoaFisica.setCpf("123487985");
        pessoaFisica.setIdade(26);
        pessoaFisica.exibir();
    }
}
