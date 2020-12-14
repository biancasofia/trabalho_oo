package app.relatorios;

import java.util.ArrayList;
import app.pessoas.Pessoa;
import app.despesas.*;
import javax.swing.JOptionPane;


public class CalculoPagamento {
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Despesa> despesas;
    
    public void proporcional() {
        LeituraDados dados = new LeituraDados();
        
        dados.setPessoas();
        pessoas = dados.getPessoas();

        dados.setDespesas();
        despesas = dados.getDespesas();

        Double somaDespesas = 0.0;
        Double somaRendimentos = 0.0;
        Double valorPagamento = 0.0;
        String mensagem = "";

        for (int i = 0; i < despesas.size(); i++) {
            somaDespesas += despesas.get(i).getValor();
        }

        for (int i = 0; i < pessoas.size(); i++) {
            somaRendimentos += pessoas.get(i).getRendimento();
        }

        for (int i = 0; i < pessoas.size(); i++) {
            valorPagamento = somaDespesas * pessoas.get(i).getRendimento() / somaRendimentos;

            mensagem = mensagem +
                "Nome: " + pessoas.get(i).getNome() + "\n" +
                "Valor a pagar: " + String.format("%.2f", valorPagamento) + " reais." + "\n\n";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }

    public void igualitario() {
        LeituraDados dados = new LeituraDados();
        
        dados.setPessoas();
        pessoas = dados.getPessoas();

        dados.setDespesas();
        despesas = dados.getDespesas();

        Double somaDespesas = 0.0;
        int quantPessoas = pessoas.size();
        Double valorPagamento = 0.0;
        String mensagem = "";


        for (int i = 0; i < despesas.size(); i++) {
            somaDespesas += despesas.get(i).getValor();
        }

        valorPagamento = somaDespesas / quantPessoas;

        mensagem = "Valor a ser pago por cada pessoa: " + String.format("%.2f", valorPagamento) + " reais.";

        JOptionPane.showMessageDialog(null, mensagem);
    } 
}
