package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.DAOCategoria;
import dao.DAOCliente;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInternalClienteList extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalClienteList frame = new JInternalClienteList();
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
	public JInternalClienteList() {
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setTitle("Clientes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[grow 25][grow][]", "[][][grow]"));
		
		JLabel lblCliente = new JLabel("Cliente:");
		getContentPane().add(lblCliente, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		getContentPane().add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtraTabela(textField.getText());
			}
		});
		getContentPane().add(btnBuscar, "cell 2 0");
		
		table = new JTable();
		getContentPane().add(table, "cell 1 2,grow");
		
		DAOCliente dc = new DAOCliente();
		try {
			table.setModel(dc.defaultTableModelClientList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void filtraTabela(String filtro) {
		DAOCliente dc = new DAOCliente();
		table.setModel(dc.filtra(filtro));
	}

}
