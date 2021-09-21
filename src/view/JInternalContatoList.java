package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import dao.DAOCliente;
import dao.DAOContato;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInternalContatoList extends JInternalFrame {
	private JTextField nomeContato;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalContatoList frame = new JInternalContatoList();
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
	public JInternalContatoList() {
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setTitle("Contatos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[grow 25][grow][]", "[][][grow]"));
		
		JLabel lblContato = new JLabel("Contato:");
		getContentPane().add(lblContato, "cell 0 0,alignx trailing");
		
		nomeContato = new JTextField();
		getContentPane().add(nomeContato, "cell 1 0,growx");
		nomeContato.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtraTabela(nomeContato.getText());
			}
		});
		getContentPane().add(btnBuscar, "cell 2 0");
		
		table = new JTable();
		getContentPane().add(table, "cell 1 2,grow");
		
		DAOContato dc = new DAOContato();
		try {
			table.setModel(dc.defaultTableModelContactList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void filtraTabela(String filtro) {
		DAOContato dc = new DAOContato();
		table.setModel(dc.filtra(filtro));
	}
}
