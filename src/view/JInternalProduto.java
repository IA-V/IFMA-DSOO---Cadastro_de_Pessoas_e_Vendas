package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import objectCreator.ObjectCreator;

import javax.swing.JLabel;
import javax.swing.JTextField;


import dao.DAOCategoria;
import dao.DAOProduto;
import model.Categoria;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class JInternalProduto extends JInternalFrame {
	private JTextField id;
	private JTextField nome;
	private JTextField preco;
	private JTextField quantidade;
	
	private ObjectCreator oc;
	private DAOCategoria cat;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalProduto frame = new JInternalProduto();
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
	public JInternalProduto() {
		setTitle("Produto");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[100.00,grow][125.00][100,grow]", "[][][][][][][][][][]"));
		setVisible(true);
		
		JLabel lblId = new JLabel("ID:");
		getContentPane().add(lblId, "cell 0 1,alignx trailing");
		
		id = new JTextField();
		getContentPane().add(id, "cell 1 1,growx");
		id.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		getContentPane().add(lblCategoria, "cell 0 2,alignx trailing");
		
		JComboBox categoria = new JComboBox();
		categoria.setModel(new DefaultComboBoxModel(new String[] {"Limpeza", "Lazer"}));
		getContentPane().add(categoria, "cell 1 2,growx");
		
		JLabel lblNome = new JLabel("Nome:");
		getContentPane().add(lblNome, "cell 0 3,alignx trailing");
		
		nome = new JTextField();
		getContentPane().add(nome, "cell 1 3,growx");
		nome.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		getContentPane().add(lblPreo, "cell 0 4,alignx trailing");
		
		preco = new JTextField();
		getContentPane().add(preco, "cell 1 4,growx");
		preco.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		getContentPane().add(lblQuantidade, "cell 0 5,alignx trailing");
		
		quantidade = new JTextField();
		getContentPane().add(quantidade, "cell 1 5,growx");
		quantidade.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastraProduto(id.getText(), categoria.getSelectedItem().toString(), nome.getText(), preco.getText(), quantidade.getText());
			}
		});
		getContentPane().add(btnNewButton, "cell 2 9,alignx center");
	}
	
	private void cadastraProduto(String id, String categ, String nome, String preco, String quant) {
		int idProduto = Integer.parseInt(id);
		double p = Double.parseDouble(preco);
		int q = Integer.parseInt(quant);
		DAOProduto dp = new DAOProduto();
		ObjectCreator.registraProduto(idProduto, dp.comparaNome(categ), nome, p, q);
	}
}
