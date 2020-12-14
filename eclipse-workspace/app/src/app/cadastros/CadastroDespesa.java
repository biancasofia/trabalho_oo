package app.cadastros;

import javax.swing.JOptionPane;

import app.despesas.*;
import app.excecoes.*;

public class CadastroDespesa {

	private String descricaoDespesa;
	private String descricaoSubcategoria;
    private String descricaoCategoria;
    private String valorStr;
    private double valor;
 
	public void cadastro() throws CategoriaNaoInformadaException, DescricaoNaoInformadaException, ValorNaoInformadoException {
       
        descricaoDespesa = JOptionPane.showInputDialog("\nDescri��o: ");
        
		if(descricaoDespesa.equals("")) {
            throw new DescricaoNaoInformadaException("Descri��o de despesa n�o informada");
        }
		       
        descricaoCategoria = JOptionPane.showInputDialog("\nCategoria: ");

      	if(descricaoCategoria.equals("")) {
            throw new CategoriaNaoInformadaException("Categoria n�o informada");
        }
      	
        descricaoSubcategoria = JOptionPane.showInputDialog("\nSubcategoria: ");

        valorStr =JOptionPane.showInputDialog ("\nValor: ");
        if(valorStr.equals("")) {           	
            throw new ValorNaoInformadoException("Valor n�o informado");
        }
             
        valor = Double.parseDouble(valorStr);
                       
        Subcategoria novaSubcategoria = new Subcategoria(descricaoSubcategoria);
        Categoria novaCategoria = new Categoria(descricaoCategoria,novaSubcategoria );
        Despesa novaDespesa= new Despesa(descricaoDespesa,novaCategoria, valor);
        
        novaDespesa.salvar();
    }
}