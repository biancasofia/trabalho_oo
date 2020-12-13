package app.pessoas;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Pessoa {
    
    private double rendimento;
    private String email;
    private String nome;

    public Pessoa(String nome,String email, double rendimento ) {
        this.setEmail(email);
        this.setNome(nome);
        this.setRendimento(rendimento);
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void salvar() {
        try {
            FileWriter fw = new FileWriter("./alunos.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this.nome + ";" + this.email + ";" + this.rendimento);
            pw.close();
            fw.close();

            JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");

        } catch(IOException err) {
            System.out.println("\nErro de cadastro." + err);
        }
        
    }
	 
}
