package app.despesas;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Despesa {
    private String descricao;
    private Categoria categoria;
    private Double valor;
    
    public Despesa(String descricao, Categoria categoria, Double valor) {
        this.setDescricao(descricao);
        this.setCategoria(categoria);
        this.setValor(valor);
    }

	public String getDescricao() {
		return this.descricao;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void salvar() {
        try {
            FileWriter fw = new FileWriter("./despesas_12_20.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this.descricao + ";" + this.categoria.getDescricao() + ";" + this.categoria.getSubcategoria().getDescricao() + ";" + this.valor);
            pw.close();
            fw.close();

            JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso!");

        } catch(IOException err) {
            System.out.println("\nErro de cadastro" + err);
        } 
    }
}
