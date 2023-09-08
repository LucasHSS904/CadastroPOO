package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PessoaFisicaRepo {
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();

    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }

    public void alterar(PessoaFisica pessoaFisica,PessoaFisica novaPessoa) {
        int index = getIndexById(pessoaFisica.getId());
        if (index != -1) {
            pessoasFisicas.set(index, novaPessoa);
        }
    }

    public void excluir(int id) {
        int index = getIndexById(id);
        if (index != -1) {
            pessoasFisicas.remove(index);
        }
    }

    public PessoaFisica obter(int id) {
        int index = getIndexById(id);

        if (index != -1) {
            //pessoasFisicas.get(index).exibir();
            return pessoasFisicas.get(index);
        } else {
            //System.out.println("Pessoa Física com o ID " + id + " não foi encontrada.");
            return null;
        }
    }

    public List<PessoaFisica> obterTodos() {
        return new ArrayList<>(pessoasFisicas);
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasFisicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (List<PessoaFisica>) inputStream.readObject();
        }
    }

    private int getIndexById(int id) {
        return IntStream.range(0, pessoasFisicas.size())
                .filter(i -> pessoasFisicas.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }
}