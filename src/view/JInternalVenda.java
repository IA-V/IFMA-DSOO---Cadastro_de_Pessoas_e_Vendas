package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import objectCreator.ObjectCreator;

import javax.swing.JLabel;
import javax.swing.JTextField;


import dao.DAOVenda;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class JInternalVenda extends JInternalFrame {
	private JTextField id;
	private JTextField data;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalVenda frame = new JInternalVenda();
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
	public JInternalVenda() {
		setBounds(100, 100, 450, 300);
		setTitle("Venda");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][grow 25][grow][]", "[][][][][][][][][][]"));
		
		JLabel lblId = new JLabel("ID:");
		getContentPane().add(lblId, "cell 1 1,alignx trailing");
		
		id = new JTextField();
		getContentPane().add(id, "cell 2 1,growx");
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data:");
		getContentPane().add(lblNewLabel, "cell 1 2,alignx trailing");
		
		data = new JTextField();
		getContentPane().add(data, "cell 2 2,growx");
		data.setColumns(10);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		getContentPane().add(lblFuncionrio, "cell 1 3,alignx trailing");
		
		JComboBox funcionario = new JComboBox();
		funcionario.setModel(new DefaultComboBoxModel(new String[] {"Iago"}));
		getContentPane().add(funcionario, "cell 2 3,growx");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraVenda(id.getText(), data.getText(), funcionario.getSelectedItem().toString());
			}
		});
		getContentPane().add(btnCadastrar, "cell 3 9");
	}

	private void cadastraVenda(String id, String data, String funcionario) {
		int idVenda = Integer.parseInt(id);
		DAOVenda dv = new DAOVenda();
		ObjectCreator.registraVenda(idVenda, data, dv.comparaNome(funcionario));
	}
}
