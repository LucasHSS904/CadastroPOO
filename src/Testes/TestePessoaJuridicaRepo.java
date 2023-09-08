package Testes;

import Model.PessoaJuridica;
import Model.PessoaJuridicaRepo;

import java.io.IOException;

public class TestePessoaJuridicaRepo {
    public static void main(String[] args) {
        PessoaJuridicaRepo repositorio = new PessoaJuridicaRepo();
        PessoaJuridica pessoa = new PessoaJuridica();
        PessoaJuridica pessoa1 = new PessoaJuridica();
        PessoaJuridica pessoa2 = new PessoaJuridica();
        PessoaJuridica pessoa3 = new PessoaJuridica();
        pessoa.setNome("João");
        pessoa.setId(10);
        pessoa.setCnpj("123456");
        pessoa1.setNome("Pedro");
        pessoa1.setId(11);
        pessoa1.setCnpj("654321");
        pessoa2.setNome("Maria");
        pessoa2.setId(12);
        pessoa2.setCnpj("123456789");
        pessoa3.setNome("Marcos");
        pessoa3.setId(3);
        pessoa3.setCnpj("321456");
        repositorio.inserir(pessoa);
        repositorio.inserir(pessoa1);
        repositorio.inserir(pessoa2);
        repositorio.inserir(pessoa3);
        repositorio.alterar(pessoa,pessoa1);
        repositorio.excluir(12);
        repositorio.obter(3);

        try {
            System.out.println("Salvo com sucesso");
            repositorio.persistir("pessoasJuridicas.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            repositorio.recuperar("pessoasJuridicas.dat");
            System.out.println("Pessoas Jurídicas recuperadas:");
            repositorio.obterTodos().forEach(PessoaJuridica::exibir);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}