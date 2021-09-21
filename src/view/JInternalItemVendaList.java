package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.DAOCategoria;
import dao.DAOItemVenda;

import javax.swing.JButton;
import javax.swing.JTable;

public class JInternalItemVendaList extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalItemVendaList frame = new JInternalItemVendaList();
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
	public JInternalItemVendaList() {
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setTitle("ItemVenda");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[grow 25][grow][]", "[][][grow]"));
		
		JLabel lblNewLabel = new JLabel("ItemVenda(ID):");
		getContentPane().add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		getContentPane().add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		getContentPane().add(btnBuscar, "cell 2 0");
		
		table = new JTable();
		getContentPane().add(table, "cell 1 2,grow");
		
		DAOItemVenda div = new DAOItemVenda();
		try {
			table.setModel(div.defaultTableModelItemSaleList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void filtraTabela(String filtro) {
		DAOItemVenda dc = new DAOItemVenda();
		table.setModel(dc.filtra(Integer.parseInt(filtro)));
	}
}
