package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DAOCategoria;
import dao.DAOProduto;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInternalCategoriaList extends JInternalFrame {
	private JTextField nomeCategoria;
	private JTable table;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalCategoriaList frame = new JInternalCategoriaList();
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
	public JInternalCategoriaList() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setTitle("Categorias");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[43.00,grow 25][grow][]", "[][grow][]"));
		
		JLabel lblCategoria = new JLabel("Categoria:");
		getContentPane().add(lblCategoria, "cell 0 0,alignx trailing");
		
		nomeCategoria = new JTextField();
		getContentPane().add(nomeCategoria, "cell 1 0,growx");
		nomeCategoria.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtraTabela(nomeCategoria.getText());
			}
		});
		getContentPane().add(btnBuscar, "cell 2 0");
		
		DAOCategoria dc = new DAOCategoria();
		try {
			dtm = dc.defaultTableModelCategoryList();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			
			table = new JTable();
			table.setCellSelectionEnabled(true);
			getContentPane().add(table, "cell 1 1,grow");
			table.setModel(this.dtm);
			
			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salvaAlteracoes(dtm);
				}
			});
			getContentPane().add(btnSalvar, "cell 2 2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void filtraTabela(String filtro) {
		DAOCategoria dc = new DAOCategoria();
		table.setModel(dc.filtra(filtro));
	}
	
	private void salvaAlteracoes(DefaultTableModel dtm) {
		System.out.println(dtm.getValueAt(1, 0));
	}
}
