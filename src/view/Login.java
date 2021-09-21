package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import criptografia.Encryption;
import dao.DAOFuncionario;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField cpf;
	private JTextField senha;
	private DAOFuncionario df = new DAOFuncionario();
	private CadastroInterface ci;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("Login");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow][grow][158.00][grow][grow]", "[][][][][]"));
		{
			JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
			contentPanel.add(lblUsurio, "cell 2 2,alignx trailing");
		}
		{
			cpf = new JTextField();
			contentPanel.add(cpf, "cell 3 2,growx");
			cpf.setColumns(10);
		}
		{
			JLabel lblSenha = new JLabel("Senha:");
			contentPanel.add(lblSenha, "cell 2 3,alignx trailing");
		}
		{
			senha = new JTextField();
			contentPanel.add(senha, "cell 3 3,growx");
			senha.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(verificaDados(cpf.getText(), Encryption.passwordEncryption(senha.getText()))){
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public boolean verificaDados(String cpf, String s){
		System.out.println(s);
		if(df.login(cpf, s)) {
			if(this.ci == null) {
				JOptionPane.showMessageDialog(null, "Logado!", "Login", 1);
				this.ci = new CadastroInterface();
			}
			return true;
		}else{
			return false;
		}
	}

}
