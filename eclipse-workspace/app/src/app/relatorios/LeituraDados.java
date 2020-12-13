package app.relatorios;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import javax.swing.JOptionPane;

import app.pessoas.Pessoa;
import app.despesas.*;

public class LeituraDados {

    private ArrayList<Pessoa> pessoas= new ArrayList<Pessoa>();

    private ArrayList<Despesa> despesas= new ArrayList<Despesa>();

    public void setPessoas() {
        String nome;
        String email;
        Double rendimento;

        String linha;
        String dados[] = new String[3];

        try {
            FileReader fr = new FileReader("alunos.txt");
            BufferedReader br = new BufferedReader(fr);

            linha = br.readLine();
            
            while (linha != null) {
                dados = linha.split(";");
                
                nome = dados[0];
                email = dados[1];
                rendimento = Double.parseDouble(dados[2]);
                
                Pessoa novaPessoa = new Pessoa(nome, email, rendimento);
                
                pessoas.add(novaPessoa);
                
                linha = br.readLine();
            }

            br.close();
            fr.close();

        } catch(IOException err) {
            System.out.println("Erro na leitura " + err.getMessage());

        }
    }

    public void setDespesas() {
        String descricaoDespesa;
        String descricaoSubcategoria;
        String descricaoCategoria;
        double valor;

        String linha;
        String dados[] = new String[4];

        try {
            FileReader fr = new FileReader("despesas_12_20.txt");
            BufferedReader br = new BufferedReader(fr);

            linha = br.readLine();
            
            while (linha != null) {
                dados = linha.split(";");
                
                descricaoDespesa = dados[0];
                descricaoCategoria = dados[1];
                descricaoSubcategoria = dados[2];
                valor = Double.parseDouble(dados[3]);
                
                Subcategoria novaSubcategoria = new Subcategoria(descricaoSubcategoria);
                Categoria novaCategoria = new Categoria(descricaoCategoria,novaSubcategoria );
                Despesa novaDespesa= new Despesa(descricaoDespesa,novaCategoria, valor);
                
                despesas.add(novaDespesa);

                linha = br.readLine();
            }

            br.close();
            fr.close();

        } catch(IOException err) {
            System.out.println("Erro na leitura " + err.getMessage());
        }
        
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public ArrayList<Despesa> getDespesas() {
        return despesas;
    }

    public void apagarDados() {
        File filePessoas = new File( "alunos.txt" ); 
        filePessoas.delete();

        File fileDespesas = new File( "despesas_12_20.txt" ); 
        fileDespesas.delete();

        JOptionPane.showMessageDialog(null, "Dados apagados com sucesso!");

    }
}
