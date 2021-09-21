package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.DAOContato;
import dao.DAOFuncionario;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInternalFuncionarioList extends JInternalFrame {
	private JTextField nomeFuncionario;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalFuncionarioList frame = new JInternalFuncionarioList();
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
	public JInternalFuncionarioList() {
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setTitle("Funcionários");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[grow 25][grow][]", "[][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Funcionario:");
		getContentPane().add(lblNewLabel, "cell 0 0,alignx trailing");
		
		nomeFuncionario = new JTextField();
		getContentPane().add(nomeFuncionario, "cell 1 0,growx");
		nomeFuncionario.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtraTabela(nomeFuncionario.getText());
			}
		});
		getContentPane().add(btnBuscar, "cell 2 0");
		
		table = new JTable();
		getContentPane().add(table, "cell 1 2,grow");
		
		DAOFuncionario df = new DAOFuncionario();
		try {
			table.setModel(df.defaultTableModelEmployeeList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void filtraTabela(String filtro) {
		DAOFuncionario df = new DAOFuncionario();
		table.setModel(df.filtra(filtro));
	}
}
