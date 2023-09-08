package Testes;

import Model.Pessoa;

public class TestePessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João");
        pessoa.setId(123);
        pessoa.exibir();
    }
}
