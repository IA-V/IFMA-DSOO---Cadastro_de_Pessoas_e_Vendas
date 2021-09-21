package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.DAOFuncionario;
import dao.DAOVenda;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInternalVendaList extends JInternalFrame {
	private JTextField nomeVendedor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalVendaList frame = new JInternalVendaList();
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
	public JInternalVendaList() {
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setTitle("Vendas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[grow 25][grow][]", "[][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Venda:");
		getContentPane().add(lblNewLabel, "cell 0 0,alignx trailing");
		
		nomeVendedor = new JTextField();
		getContentPane().add(nomeVendedor, "cell 1 0,growx");
		nomeVendedor.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtraTabela(nomeVendedor.getText());
			}
		});
		getContentPane().add(btnNewButton, "cell 2 0");
		
		table = new JTable();
		getContentPane().add(table, "cell 1 2,grow");
		
		DAOVenda dv = new DAOVenda();
		try {
			table.setModel(dv.defaultTableModelSaleList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void filtraTabela(String filtro) {
		DAOVenda dv = new DAOVenda();
		table.setModel(dv.filtra(filtro));
	}
}
