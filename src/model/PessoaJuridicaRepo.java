package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo implements Serializable {

    private ArrayList<PessoaJuridica> pessoas;

    public PessoaJuridicaRepo() {
        pessoas = new ArrayList<>();
    }

    // Inserir
    public void inserir(PessoaJuridica p) {
        pessoas.add(p);
    }

    // Alterar
    public void alterar(PessoaJuridica p) {
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
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica p : pessoas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Obter Todos
    public ArrayList<PessoaJuridica> obterTodos() {
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

        pessoas = (ArrayList<PessoaJuridica>) in.readObject();

        in.close();
    }
}