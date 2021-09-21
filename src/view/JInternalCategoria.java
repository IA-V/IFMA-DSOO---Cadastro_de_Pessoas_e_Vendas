package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import objectCreator.ObjectCreator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInternalCategoria extends JInternalFrame {
	private JTextField id;
	private JTextField nome;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalCategoria frame = new JInternalCategoria();
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
	public JInternalCategoria() {
		setTitle("Categoria");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow 25][grow][]", "[][][][][][][][][]"));
		
		JLabel lblId = new JLabel("ID:");
		getContentPane().add(lblId, "cell 0 2,alignx trailing");
		
		id = new JTextField();
		getContentPane().add(id, "cell 1 2,growx");
		id.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		getContentPane().add(lblNome, "cell 0 3,alignx trailing");
		
		nome = new JTextField();
		getContentPane().add(nome, "cell 1 3,growx");
		nome.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastraCategoria(id.getText(), nome.getText());
			}
		});
		getContentPane().add(btnCadastrar, "cell 2 8");

	}
	
	private void cadastraCategoria(String id, String nome) {
		int idCateg = Integer.parseInt(id);
		ObjectCreator.registraCategoria(idCateg, nome);
	}

}
