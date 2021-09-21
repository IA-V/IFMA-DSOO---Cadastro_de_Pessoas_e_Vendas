package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DAOProduto;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInternalProdutoList extends JInternalFrame {
	private JTextField nomeProduto;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalProdutoList frame = new JInternalProdutoList();
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
	public JInternalProdutoList() {
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Produtos");
		
		getContentPane().setLayout(new MigLayout("", "[grow 25][grow][]", "[][][grow]"));
		
		JLabel lblProduto = new JLabel("Produto:");
		getContentPane().add(lblProduto, "cell 0 0,alignx trailing");
		
		nomeProduto = new JTextField();
		getContentPane().add(nomeProduto, "cell 1 0,growx");
		nomeProduto.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtraTabela(nomeProduto.getText());
			}
		});
		getContentPane().add(btnBuscar, "cell 2 0");
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		getContentPane().add(table, "cell 1 2,grow");
		
		DAOProduto dp = new DAOProduto();
		
		try {
			table.setModel(dp.defaultTableModelProductList());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
		}
	}

	private void filtraTabela(String filtro) {
		DAOProduto dp = new DAOProduto();
		table.setModel(dp.filtra(filtro));

	}
	
	//private void 
}
