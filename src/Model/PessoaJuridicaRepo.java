package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PessoaJuridicaRepo {
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    public void inserir(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(PessoaJuridica pessoaJuridica,PessoaJuridica novaPessoa) {
        int index = getIndexById(pessoaJuridica.getId());
        if (index != -1) {
            pessoasJuridicas.set(index, novaPessoa);
        }
    }

    public void excluir(int id) {
        int index = getIndexById(id);
        if (index != -1) {
            pessoasJuridicas.remove(index);
        }
    }

    public PessoaJuridica obter(int id) {
        int index = getIndexById(id);

        if (index != -1) {
            //pessoasJuridicas.get(index).exibir();
            return pessoasJuridicas.get(index);
        } else {
            //System.out.println("Pessoa Jurídica com o ID " + id + " não foi encontrada.");
            return null;
        }
    }

    public List<PessoaJuridica> obterTodos() {
        return new ArrayList<>(pessoasJuridicas);
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasJuridicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasJuridicas = (List<PessoaJuridica>) inputStream.readObject();
        }
    }

    private int getIndexById(int id) {
        return IntStream.range(0, pessoasJuridicas.size())
                .filter(i -> pessoasJuridicas.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }
}