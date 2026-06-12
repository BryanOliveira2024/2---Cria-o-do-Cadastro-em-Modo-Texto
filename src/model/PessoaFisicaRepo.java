package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo implements Serializable {

    private ArrayList<PessoaFisica> pessoas;

    public PessoaFisicaRepo() {
        pessoas = new ArrayList<>();
    }

    // Inserir
    public void inserir(PessoaFisica p) {
        pessoas.add(p);
    }

    // Alterar
    public void alterar(PessoaFisica p) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == p.getId()) {
                pessoas.set(i, p);
                return;
            }
        }
    }

    // Excluir
    public void excluir(int id) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == id) {
                pessoas.remove(i);
                return;
            }
        }
    }

    // Obter
    public PessoaFisica obter(int id) {
        for (PessoaFisica p : pessoas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Obter Todos
    public ArrayList<PessoaFisica> obterTodos() {
        return pessoas;
    }

    // Persistir
    public void persistir(String nomeArquivo) throws IOException {
        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream(nomeArquivo));

        out.writeObject(pessoas);
        out.close();
    }

    // Recuperar
    public void recuperar(String nomeArquivo)
            throws IOException, ClassNotFoundException {

        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream(nomeArquivo));

        pessoas = (ArrayList<PessoaFisica>) in.readObject();

        in.close();
    }
}