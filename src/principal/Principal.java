package principal;

import java.util.Scanner;
import model.*;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== CADASTRO =====");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir por ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Salvar");
            System.out.println("7 - Recuperar");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:

                    System.out.println("F - Pessoa Física");
                    System.out.println("J - Pessoa Jurídica");
                    String tipo = sc.nextLine().toUpperCase();

                    if (tipo.equals("F")) {

                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();

                        System.out.print("Idade: ");
                        int idade = Integer.parseInt(sc.nextLine());

                        repoPF.inserir(
                                new PessoaFisica(
                                        id,
                                        nome,
                                        cpf,
                                        idade));

                    } else {

                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("CNPJ: ");
                        String cnpj = sc.nextLine();

                        repoPJ.inserir(
                                new PessoaJuridica(
                                        id,
                                        nome,
                                        cnpj));
                    }

                    break;

                case 2:

                    System.out.println("F - Pessoa Física");
                    System.out.println("J - Pessoa Jurídica");
                    tipo = sc.nextLine().toUpperCase();

                    System.out.print("ID: ");
                    int idAlterar = Integer.parseInt(sc.nextLine());

                    if (tipo.equals("F")) {

                        PessoaFisica pf = repoPF.obter(idAlterar);

                        if (pf != null) {

                            pf.exibir();

                            System.out.print("Novo Nome: ");
                            String nome = sc.nextLine();

                            System.out.print("Novo CPF: ");
                            String cpf = sc.nextLine();

                            System.out.print("Nova Idade: ");
                            int idade = Integer.parseInt(sc.nextLine());

                            repoPF.alterar(
                                    new PessoaFisica(
                                            idAlterar,
                                            nome,
                                            cpf,
                                            idade));
                        }

                    } else {

                        PessoaJuridica pj = repoPJ.obter(idAlterar);

                        if (pj != null) {

                            pj.exibir();

                            System.out.print("Novo Nome: ");
                            String nome = sc.nextLine();

                            System.out.print("Novo CNPJ: ");
                            String cnpj = sc.nextLine();

                            repoPJ.alterar(
                                    new PessoaJuridica(
                                            idAlterar,
                                            nome,
                                            cnpj));
                        }
                    }

                    break;

                case 3:

                    System.out.println("F - Pessoa Física");
                    System.out.println("J - Pessoa Jurídica");
                    tipo = sc.nextLine().toUpperCase();

                    System.out.print("ID: ");
                    int idExcluir = Integer.parseInt(sc.nextLine());

                    if (tipo.equals("F")) {
                        repoPF.excluir(idExcluir);
                    } else {
                        repoPJ.excluir(idExcluir);
                    }

                    break;

                case 4:

                    System.out.println("F - Pessoa Física");
                    System.out.println("J - Pessoa Jurídica");
                    tipo = sc.nextLine().toUpperCase();

                    System.out.print("ID: ");
                    int idBuscar = Integer.parseInt(sc.nextLine());

                    if (tipo.equals("F")) {

                        PessoaFisica pf = repoPF.obter(idBuscar);

                        if (pf != null) {
                            pf.exibir();
                        }

                    } else {

                        PessoaJuridica pj = repoPJ.obter(idBuscar);

                        if (pj != null) {
                            pj.exibir();
                        }
                    }

                    break;

                case 5:

                    System.out.println("F - Pessoa Física");
                    System.out.println("J - Pessoa Jurídica");
                    tipo = sc.nextLine().toUpperCase();

                    if (tipo.equals("F")) {

                        for (PessoaFisica pf : repoPF.obterTodos()) {
                            pf.exibir();
                        }

                    } else {

                        for (PessoaJuridica pj : repoPJ.obterTodos()) {
                            pj.exibir();
                        }
                    }

                    break;

                case 6:

                    try {

                        System.out.print("Prefixo: ");
                        String prefixo = sc.nextLine();

                        repoPF.persistir(prefixo + ".fisica.bin");
                        repoPJ.persistir(prefixo + ".juridica.bin");

                        System.out.println("Dados salvos.");

                    } catch (Exception e) {

                        System.out.println("Erro ao salvar.");
                        e.printStackTrace();
                    }

                    break;

                case 7:

                    try {

                        System.out.print("Prefixo: ");
                        String prefixo = sc.nextLine();

                        repoPF.recuperar(prefixo + ".fisica.bin");
                        repoPJ.recuperar(prefixo + ".juridica.bin");

                        System.out.println("Dados recuperados.");

                    } catch (Exception e) {

                        System.out.println("Erro ao recuperar.");
                        e.printStackTrace();
                    }

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}