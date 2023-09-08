package Model;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair\n ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipo = scanner.nextInt();
                    if (tipo == 1) {
                        System.out.println("Digite o ID: ");
                        int id = scanner.nextInt();
                        System.out.println("Digite o Nome: ");
                        String nome = scanner.next();
                        System.out.println("Difite o CPF: ");
                        String cpf = scanner.next();
                        System.out.println("Difite a Idade: ");
                        int idade = scanner.nextInt();

                        PessoaFisica pessoaFisica = new PessoaFisica(nome, id, cpf, idade);
                        pessoaFisicaRepo.inserir(pessoaFisica);
                        System.out.println("Pessoa Física cadastrada com sucesso!\n");

                    } else if (tipo == 2) {
                        System.out.println("Digite o ID:");
                        int id = scanner.nextInt();
                        System.out.println("Digite o nome da empresa:");
                        String nomeEmpresa = scanner.next();
                        System.out.println("Digite o CNPJ:");
                        String cnpj = scanner.next();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(nomeEmpresa, id, cnpj);
                        pessoaJuridicaRepo.inserir(pessoaJuridica);
                        System.out.println("Pessoa Jurídica cadastrada com sucesso!\n");
                    } else {
                        System.out.println("Tipo inválido.\n");
                    }
                    break;
                case 2:
                    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int alterar = scanner.nextInt();
                    if (alterar == 1) {
                        System.out.println("Digite o ID da Pessoa Física que deseja alterar:");
                        int idPessoaFisicaAlterar = scanner.nextInt();

                        PessoaFisica pessoaFisicaExistente = pessoaFisicaRepo.obter(idPessoaFisicaAlterar);

                        if (pessoaFisicaExistente != null) {
                            System.out.println("Dados atuais da Pessoa Física:");
                            pessoaFisicaExistente.exibir();
                            System.out.println("Digite o novo nome:");
                            String novoNomePF = scanner.next();
                            System.out.println("Digite o novo CPF:");
                            String novoCpf = scanner.next();
                            System.out.println("Digite a nova idade:");
                            int novaIdade = scanner.nextInt();

                            PessoaFisica pessoaFisicaAtualizada = new PessoaFisica(novoNomePF, idPessoaFisicaAlterar, novoCpf, novaIdade);
                            pessoaFisicaRepo.alterar(pessoaFisicaExistente,pessoaFisicaAtualizada);

                            System.out.println("Pessoa Física alterada com sucesso!\n");
                        } else {
                            System.out.println("Pessoa Física com o id"+ idPessoaFisicaAlterar + " não encontrada.");
                        }

                    } else if (alterar == 2) {
                        System.out.println("Digite o ID da Pessoa Jurídica que deseja alterar:");
                        int idPessoaJuridicaAlterar = scanner.nextInt();

                        PessoaJuridica pessoaJuridicaExistente = pessoaJuridicaRepo.obter(idPessoaJuridicaAlterar);

                        if (pessoaJuridicaExistente != null) {
                           System.out.println("Dados atuais da Pessoa Jurídica: ");
                           pessoaJuridicaExistente.exibir();
                           System.out.println("Digite o novo nome da Empresa: ");
                           String novoNomePJ = scanner.next();
                           System.out.println("Digite o novo CNPJ: ");
                           String novoCNPJ = scanner.next();

                            PessoaJuridica pessoaJuridicaAtualizada = new PessoaJuridica(novoNomePJ, idPessoaJuridicaAlterar, novoCNPJ);
                            pessoaJuridicaRepo.alterar(pessoaJuridicaExistente,pessoaJuridicaAtualizada);

                            System.out.println("Pessoa Juridica alterada com sucesso!\n");

                        } else {
                            System.out.println("Pessoa Física com o id"+ idPessoaJuridicaAlterar + " não encontrada.\n");
                        }

                    } else {
                           System.out.println("Tipo inválido.\n");
                        }
                    break;
                case 3:
                        System.out.println("Escolha (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipoExluir = scanner.nextInt();
                    if (tipoExluir == 1) {
                        System.out.println("Digite o ID da Pessoa Física que deseja excluir:");
                    int idPessoaFisicaExcluir = scanner.nextInt();

                    PessoaFisica pessoaFisicaExistente = pessoaFisicaRepo.obter(idPessoaFisicaExcluir);

                        if (pessoaFisicaExistente != null) {
                        System.out.println("Dados da Pessoa Física a ser excluída:");
                        pessoaFisicaExistente.exibir();

                        System.out.println("Tem certeza de que deseja excluir esta Pessoa Física? (S/N)");
                        String confirmacaoPessoaFisica = scanner.next();

                            if (confirmacaoPessoaFisica.equalsIgnoreCase("S")) {
                                pessoaFisicaRepo.excluir(idPessoaFisicaExcluir);
                                System.out.println("Pessoa Física excluída com sucesso!\n");
                                    } else {
                                        System.out.println("Exclusão cancelada.");
                                    }
                                } else {
                                    System.out.println("Pessoa Física com o ID especificado não encontrada.\n");
                                }
                            }
                    else if (tipoExluir == 2) {
                        System.out.println("Digite o ID da Pessoa Jurídica que deseja excluir:");
                        int idPessoaJuridicaExcluir = scanner.nextInt();

                        PessoaJuridica pessoaJuridicaExistente = pessoaJuridicaRepo.obter(idPessoaJuridicaExcluir);

                        if (pessoaJuridicaExistente != null) {
                            System.out.println("Dados da Pessoa Jurídica a ser excluída:");
                            pessoaJuridicaExistente.exibir();

                            System.out.println("Tem certeza de que deseja excluir esta Pessoa Jurídica? (S/N)");
                            String confirmacaoPessoaJuridica = scanner.next();

                            if (confirmacaoPessoaJuridica.equalsIgnoreCase("S")) {
                                pessoaJuridicaRepo.excluir(idPessoaJuridicaExcluir);
                                System.out.println("Pessoa Jurídica excluída com sucesso!\n");
                            } else {
                                System.out.println("Exclusão cancelada.\n");
                            }
                        } else {
                            System.out.println("Pessoa Jurídica com o ID especificado não encontrada.\n");
                        }
                    } else {
                        System.out.println("Tipo inválido.\n");
                    }
                    break;
                case 4:
                    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipoObter = scanner.nextInt();
                    if (tipoObter == 1) {
                        System.out.println("Digite o ID da Pessoa Física que deseja obter:");
                        int idOterPessoaFisica = scanner.nextInt();

                        PessoaFisica pessoaFisicaExistente = pessoaFisicaRepo.obter(idOterPessoaFisica);

                        if (pessoaFisicaExistente != null) {
                            System.out.println("Dados da Pessoa Física obtida:");
                            pessoaFisicaExistente.exibir();
                        } else {
                            System.out.println("Pessoa Física com o ID especificado não encontrada.");
                        }
                    } else if (tipoObter == 2) {
                        System.out.println("Digite o ID da Pessoa Física que deseja obter:");
                        int idOterPessoaJuridica = scanner.nextInt();

                        PessoaJuridica pessoaJuridicaExiste = pessoaJuridicaRepo.obter(idOterPessoaJuridica);

                        if (pessoaJuridicaExiste != null) {
                            System.out.println("Dados da Pessoa Jurídica obtida:");
                            pessoaJuridicaExiste.exibir();
                        }
                    } else {
                        System.out.println("Tipo inválido.\n");
                    }
                    break;
                    case 5:
                        System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                        int tipoExibirTodos = scanner.nextInt();
                        if (tipoExibirTodos == 1) {
                            List<PessoaFisica> pessoasFisicas = pessoaFisicaRepo.obterTodos();
                            if (!pessoasFisicas.isEmpty()) {
                                System.out.println("Lista de todas as Pessoas Físicas:");
                                for (PessoaFisica pessoaFisica : pessoasFisicas) {
                                    pessoaFisica.exibir();
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Nenhuma Pessoa Física encontrada.\n");
                            }
                        } else if (tipoExibirTodos == 2) {
                            List<PessoaJuridica> pessoaJuridicas = pessoaJuridicaRepo.obterTodos();
                            if (!pessoaJuridicas.isEmpty()) {
                                System.out.println("Lista de todas as Pessoas Jurídicas:");
                                for (PessoaJuridica pessoaJuridica : pessoaJuridicas) {
                                    pessoaJuridica.exibir();
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Nenhuma Pessoa Jurídica encontrada.\n");
                            }
                        } else {
                            System.out.println("Tipo inválido.\n");
                        }
                    break;
                    case 6:
                        System.out.println("Digite o prefixo dos arquivos: ");
                        String prefixoSalvar = scanner.next();
                        try {
                            pessoaFisicaRepo.persistir(prefixoSalvar + ".fisica.bin");
                            pessoaJuridicaRepo.persistir(prefixoSalvar + ".juridica.bin");
                            System.out.println("Dados salvos com sucesso.\n");
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar dados:" + e.getMessage());
                        }
                    break;
                    case 7:
                        System.out.println("Digite o prefixo dos arquivos: ");
                        String prefixoRecuperar = scanner.next();
                        try {
                            pessoaFisicaRepo.recuperar(prefixoRecuperar + ".fisica.bin");
                            pessoaJuridicaRepo.recuperar(prefixoRecuperar + ".juridica.bin");
                            System.out.println("Dados recuperados com sucesso.\n");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar dados: " + e.getMessage());
                        }
                    break;
                    case 0:
                        scanner.close();
                        System.exit(0);
                    break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        }
    }
}