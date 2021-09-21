package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import objectCreator.ObjectCreator;

import javax.swing.JLabel;
import javax.swing.JTextField;


import dao.DAOContato;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInternalContato extends JInternalFrame {
	private JTextField id;
	private JTextField telefone;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalContato frame = new JInternalContato();
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
	public JInternalContato() {
		setBounds(100, 100, 450, 300);
		setTitle("Contato");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][grow 25][grow][]", "[][][][][][][][][][]"));
		
		JLabel lblId = new JLabel("ID:");
		getContentPane().add(lblId, "cell 1 1,alignx trailing");
		
		id = new JTextField();
		getContentPane().add(id, "cell 2 1,growx");
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Funcion\u00E1rio:");
		getContentPane().add(lblNewLabel, "cell 1 2,alignx trailing");
		
		JComboBox funcionario = new JComboBox();
		funcionario.setModel(new DefaultComboBoxModel(new String[] {"Iago"}));
		getContentPane().add(funcionario, "cell 2 2,growx");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		getContentPane().add(lblTelefone, "cell 1 3,alignx trailing");
		
		telefone = new JTextField();
		getContentPane().add(telefone, "cell 2 3,growx");
		telefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraContato(id.getText(), funcionario.getSelectedItem().toString(), telefone.getText());
			}
		});
		getContentPane().add(btnCadastrar, "cell 3 9");
	}

	private void cadastraContato(String id, String func, String telefone) {
		int idContato = Integer.parseInt(id);
		int tel = Integer.parseInt(telefone);
		DAOContato df = new DAOContato();
		ObjectCreator.registraContato(idContato, df.comparaNome(func), tel);
	}
}
