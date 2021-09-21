package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import validação.ValidaCPF;
import validação.ValidaData;
import net.miginfocom.swing.MigLayout;
import objectCreator.ObjectCreator;

public class CadastroCliente extends JInternalFrame {
	private JTextField id;
	private JTextField nome;
	private JTextField dtNasc;
	private JTextField nomeMae;
	private JTextField cpf;
	/**
	 * Create the frame.
	 */
	public CadastroCliente() {
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		
		setTitle("Cadastrar cliente");
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[43.00,grow][41.00,grow][15.00][]", "[23px][][grow][grow][grow][grow][grow][][][]"));
		
		JLabel lblId = new JLabel("ID");
		getContentPane().add(lblId, "cell 0 2,alignx right,aligny center");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		
		id = new JTextField();
		getContentPane().add(id, "cell 1 2,growx,aligny top");
		id.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		getContentPane().add(lblNome, "flowx,cell 0 3,alignx right,aligny center");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		
		nome = new JTextField();
		getContentPane().add(nome, "cell 1 3,growx,aligny top");
		nome.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		getContentPane().add(lblDataDeNascimento, "cell 0 4,alignx right,aligny center");
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		
		dtNasc = new JTextField();
		getContentPane().add(dtNasc, "cell 1 4,growx,aligny top");
		dtNasc.setColumns(10);
		
		JLabel lblNomeDaMe = new JLabel("Nome da m\u00E3e");
		getContentPane().add(lblNomeDaMe, "cell 0 5,alignx right,aligny center");
		lblNomeDaMe.setHorizontalAlignment(SwingConstants.CENTER);
		
		nomeMae = new JTextField();
		getContentPane().add(nomeMae, "cell 1 5,growx,aligny top");
		nomeMae.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		getContentPane().add(lblCpf, "cell 0 6,alignx right,aligny center");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		
		cpf = new JTextField();
		getContentPane().add(cpf, "cell 1 6,growx,aligny top");
		cpf.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		getContentPane().add(btnSalvar, "cell 3 9,growx,aligny top");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvaDadosCliente(id.getText(), nome.getText(), dtNasc.getText(), nomeMae.getText(), cpf.getText());
			}
		});
		btnSalvar.setBackground(new Color(240, 240, 240));
	}
	
	private void salvaDadosCliente(String i, String n, String d, String nm, String c) {
		int idCliente = Integer.parseInt(i);
		if(ValidaCPF.isCPF(c)) {
			if(ValidaData.calculaIdade(d) < 18) {
				JOptionPane.showMessageDialog(null, "Você é menor de idade!", "Erro", 0);
			}else {
				ObjectCreator.registraCliente(idCliente, n, d, nm, c);
			}
		} else {
			JOptionPane.showMessageDialog(null, "CPF inválido!");
		}
	}
}
