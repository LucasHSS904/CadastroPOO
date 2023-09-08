package Testes;

import Model.PessoaFisica;
import Model.PessoaFisicaRepo;

import java.io.IOException;

public class TestePessoaFisicaRepo {
    public static void main(String[] args) {
        PessoaFisicaRepo repositorio = new PessoaFisicaRepo();
        PessoaFisica pessoa = new PessoaFisica();
        PessoaFisica pessoa1 = new PessoaFisica();
        PessoaFisica pessoa2 = new PessoaFisica();
        PessoaFisica pessoa3 = new PessoaFisica();
        pessoa.setNome("João");
        pessoa.setId(10);
        pessoa.setIdade(22);
        pessoa.setCpf("123456789");
        pessoa1.setNome("Pedro");
        pessoa1.setId(11);
        pessoa1.setIdade(23);
        pessoa1.setCpf("987654321");
        pessoa2.setNome("Maria");
        pessoa2.setId(12);
        pessoa2.setIdade(24);
        pessoa2.setCpf("123456");
        pessoa3.setNome("Marcos");
        pessoa3.setId(3);
        pessoa3.setIdade(40);
        pessoa3.setCpf("654321");
        repositorio.inserir(pessoa);
        repositorio.inserir(pessoa1);
        repositorio.inserir(pessoa2);
        repositorio.inserir(pessoa3);
        repositorio.alterar(pessoa,pessoa1);
        repositorio.excluir(12);
        repositorio.obter(3);

        try {
            System.out.println("Salvo com sucesso");
            repositorio.persistir("pessoasFisicas.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            repositorio.recuperar("pessoasFisicas.bin");
            System.out.println("Pessoas Físicas recuperadas:");
            repositorio.obterTodos().forEach(PessoaFisica::exibir);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}