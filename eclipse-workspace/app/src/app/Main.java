package app;

import javax.swing.JOptionPane;
import app.cadastros.CadastroPessoa;
import app.cadastros.CadastroDespesa;

import app.relatorios.CalculoPagamento;
import app.relatorios.ImprimeDados;
import app.relatorios.LeituraDados;
import app.excecoes.*;

public class Main {
    public static void main(String[] args)  {

		CadastroPessoa cadastroPessoa = new CadastroPessoa();
		CadastroDespesa cadastroDespesa = new CadastroDespesa();
		CalculoPagamento calculoPagamento = new CalculoPagamento();
		ImprimeDados imprimeDados = new ImprimeDados();
		LeituraDados leituraDados = new LeituraDados();
        
        int operacao;
		operacao = 0;
		
        while (operacao != 8) {
        	
            operacao=Integer.parseInt(JOptionPane.showInputDialog("Escolha o n�mero da op��o desejada: \n"
            	+ "1 - Cadastrar uma pessoa\n"
            	+ "2 - Cadastrar uma despesa\n"
            	+ "3 - Calcular valor a ser pago igualitariamente\n"
            	+ "4 - Calcular valor a ser pago proporcionalmente\n"
				+ "5 - Listar todas as pessoas cadastradas\n"
				+ "6 - Lista todas as despesas cadastradas\n"
				+ "7 - Apaga todos os dados cadastrados\n"
            	+ "8 - Sair\n**************************************************************"));

            if (operacao == 1) {
				try {
					cadastroPessoa.cadastro();
				} catch (RendimentoInvalidoException e) {
					String msg= "exce��o capturada, cadastre esse morador(a) novamente digitando 1 no menu\n";
					msg+=e.getMessage()+"\n";
					JOptionPane.showMessageDialog(null,msg);
					e.printStackTrace();
				}
				catch(DadosPessoaisIncompletosException e) {
					String msg= "exce��o capturada!\nNome, email ou rendimento n�o informados, cadastre esse morador(a) novamente digitando 1 no menu\n";
					msg+=e.getMessage()+"\n";
					JOptionPane.showMessageDialog(null,msg);
					e.printStackTrace();
				}
            } else if (operacao == 2) {      	
            	try {
					try {
						cadastroDespesa.cadastro();
					} catch (ValorNaoInformadoException e) {
						String msg= "exce��o capturada!\nValor n�o informado, cadastre essa despesa novamente digitando 2 no menu\n";
						msg+=e.getMessage()+"\n";
						JOptionPane.showMessageDialog(null,msg);
						e.printStackTrace();
						e.printStackTrace();
					}
				} catch (CategoriaNaoInformadaException e) {
					
					String msg= "exce��oo capturada!\nCategoria n�o informada, cadastre essa despesa novamente digitando 2 no menu\n";
					msg+=e.getMessage()+"\n";
					JOptionPane.showMessageDialog(null,msg);
					e.printStackTrace();
					} catch (DescricaoNaoInformadaException e) {
					String msg= "exce��o capturada!\nDescri��o de despesa n�o informada, cadastre essa despesa novamente digitando 2 no menu\n";
					msg+=e.getMessage()+"\n";
					JOptionPane.showMessageDialog(null,msg);
					e.printStackTrace();
					
					e.printStackTrace();
				}

            } else if (operacao == 3) {
				calculoPagamento.igualitario();
             
            } else if (operacao == 4) {
				calculoPagamento.proporcional();

            } else if(operacao==5) {
				imprimeDados.pessoas();

			} else if (operacao == 6) {
				imprimeDados.despesas();

			} else if (operacao == 7) {
				leituraDados.apagarDados();
			}
			
        }
    } 
}



