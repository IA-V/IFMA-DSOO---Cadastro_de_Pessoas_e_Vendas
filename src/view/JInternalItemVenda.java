package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import objectCreator.ObjectCreator;

import javax.swing.JLabel;
import javax.swing.JTextField;


import dao.DAOItemVenda;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class JInternalItemVenda extends JInternalFrame {
	private JTextField id;
	private JTextField quantidade;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalItemVenda frame = new JInternalItemVenda();
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
	public JInternalItemVenda() {
		setBounds(100, 100, 450, 300);
		setTitle("ItemVenda");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][grow 25][grow][]", "[][][][][][][][][][]"));
		
		JLabel lblId = new JLabel("ID:");
		getContentPane().add(lblId, "cell 1 1,alignx trailing");
		
		id = new JTextField();
		getContentPane().add(id, "cell 2 1,growx");
		id.setColumns(10);
		
		JLabel lblIdDaVenda = new JLabel("Venda:");
		getContentPane().add(lblIdDaVenda, "cell 1 2,alignx trailing");
		
		JComboBox venda = new JComboBox();
		venda.setModel(new DefaultComboBoxModel(new String[] {"1"}));
		getContentPane().add(venda, "cell 2 2,growx");
		
		JLabel lblProduto = new JLabel("Produto:");
		getContentPane().add(lblProduto, "cell 1 3,alignx trailing");
		
		JComboBox produto = new JComboBox();
		produto.setModel(new DefaultComboBoxModel(new String[] {"Sab\u00E3o"}));
		getContentPane().add(produto, "cell 2 3,growx");
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		getContentPane().add(lblQuantidade, "cell 1 4,alignx trailing");
		
		quantidade = new JTextField();
		getContentPane().add(quantidade, "cell 2 4,growx");
		quantidade.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraItemVenda(id.getText(), venda.getSelectedIndex()+1, produto.getSelectedItem().toString(), quantidade.getText());
			}
		});
		getContentPane().add(btnCadastrar, "cell 3 9");
	}

	private void cadastraItemVenda(String id, int venda, String produto, String quant) {
		int idItemVenda = Integer.parseInt(id);
		int quantidade = Integer.parseInt(quant);
		DAOItemVenda div = new DAOItemVenda();
		ObjectCreator.registraItemVenda(idItemVenda, div.comparaId(venda), div.comparaNome(produto), quantidade);
	}
}
