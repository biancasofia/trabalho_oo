package app.relatorios;

import java.util.ArrayList;
import app.pessoas.Pessoa;
import app.despesas.*;
import javax.swing.JOptionPane;

public class ImprimeDados {
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Despesa> despesas;
    
    public void pessoas() {
        LeituraDados dados = new LeituraDados();
    
        dados.setPessoas();
        pessoas = dados.getPessoas();

        String mensagem = "";

        for (int i = 0; i < pessoas.size(); i++) {
            mensagem = mensagem +
                "Nome: " + pessoas.get(i).getNome() + "\n" +
                "Email: " + pessoas.get(i).getEmail() + "\n" +
                "Rendimentos: " + pessoas.get(i).getRendimento() + " reais.\n\n";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }

    public void despesas() {
        LeituraDados dados = new LeituraDados();
    
        dados.setDespesas();
        despesas = dados.getDespesas();

        String mensagem = "";

        for (int i = 0; i < despesas.size(); i++) {
            mensagem = mensagem +
                "Descrição: " + despesas.get(i).getDescricao() + "\n" +
                "Categoria: " + despesas.get(i).getCategoria().getDescricao() + "\n" +
                "Subcategoria: " + despesas.get(i).getCategoria().getSubcategoria().getDescricao() + "\n" +
                "Valor: " + despesas.get(i).getValor() + " reais.\n\n";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }
}

