package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import objectCreator.ObjectCreator;
import validação.ValidaCPF;
import validação.ValidaData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;



import criptografia.Encryption;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFuncionario extends JInternalFrame {
	private JTextField id;
	private JTextField nome;
	private JTextField dtNasc;
	private JTextField cpf;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CadastroFuncionario() {
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cadastrar funcionário");
		getContentPane().setLayout(new MigLayout("", "[][grow][grow][62.00,grow]", "[][][][][][][][][][]"));
		
		JLabel lblId = new JLabel("ID:");
		getContentPane().add(lblId, "cell 1 2,alignx trailing");
		
		id = new JTextField();
		getContentPane().add(id, "cell 2 2,growx");
		id.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		getContentPane().add(lblNome, "cell 1 3,alignx trailing");
		
		nome = new JTextField();
		getContentPane().add(nome, "cell 2 3,growx");
		nome.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		getContentPane().add(lblDataDeNascimento, "cell 1 4,alignx trailing");
		
		dtNasc = new JTextField();
		getContentPane().add(dtNasc, "cell 2 4,growx");
		dtNasc.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		getContentPane().add(lblCpf, "cell 1 5,alignx trailing");
		
		cpf = new JTextField();
		getContentPane().add(cpf, "cell 2 5,growx");
		cpf.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		getContentPane().add(lblSenha, "cell 1 6,alignx trailing");
		
		senha = new JTextField();
		getContentPane().add(senha, "cell 2 6,growx");
		senha.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvaDadosFuncionario(id.getText(), nome.getText(), dtNasc.getText(), cpf.getText(), senha.getText());
			}
		});
		getContentPane().add(btnSalvar, "cell 3 9,alignx right,growy");
	}
	
	public void salvaDadosFuncionario(String id, String nome, String dataNasc, String cpf, String senha) {
		int novoId = Integer.parseInt(id);
		if(ValidaCPF.isCPF(cpf)) {
			if(ValidaData.calculaIdade(dataNasc) < 18) {
				JOptionPane.showMessageDialog(null, "Voce é menor de idade!", "Erro", 0);
			}else {
				ObjectCreator.registraFuncionario(novoId, nome, dataNasc, cpf, senha);
			}
		}else {
			JOptionPane.showMessageDialog(null, "CPF inválido!", "Erro", 0);
		}
	}
}
