package app.cadastros;

import javax.swing.JOptionPane;

import app.pessoas.Pessoa;
import app.excecoes.*;

public class CadastroPessoa {

	private String nome;
    private String email;
    private String rendimentoStr;
	private double rendimento;
	
    public void cadastro() throws RendimentoInvalidoException, DadosPessoaisIncompletosException  {
		
		nome=  JOptionPane.showInputDialog("\nNome: ");
		if(nome.equals("")) {
			throw new  DadosPessoaisIncompletosException("dados incompletos\n");
		}
		
		email= JOptionPane.showInputDialog("\nEmail: ");
		if(email.equals("")) {
			throw new  DadosPessoaisIncompletosException("dados incompletos\n");
		}
		 
		rendimentoStr = JOptionPane.showInputDialog("\nRendimento: ");
		if(rendimentoStr.equals("")) {
			throw new  DadosPessoaisIncompletosException("dados incompletos\n");
		}	

		rendimento=Double.parseDouble(rendimentoStr); 
        if(rendimento < 0) {
            throw new RendimentoInvalidoException("rendimento inv�lido\n");
        }
        
        Pessoa novaPessoa = new Pessoa(nome, email, rendimento);
		
        novaPessoa.salvar();
    }
}
	
	