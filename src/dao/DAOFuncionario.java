package dao;

import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAOInterface.FuncionarioDao;
import model.Cliente;
import model.Funcionario;
import criptografia.Encryption;

public class DAOFuncionario implements FuncionarioDao{
	
	private Connection con;
	private Statement comando;
	private final String URL = "jdbc:mysql://localhost/CadastroDeVendasEPessoas",  
	         NOME = "root", SENHA = "";
	 
	//Montagem do Jtable
	   public DefaultTableModel defaultTableModelEmployeeList() throws Exception {
		   DefaultTableModel dtm = new  DefaultTableModel(){
	           public boolean isCellEditable(int row, int column) {
	               return true;
	           }
	       };
		   
	       ResultSet rs; 
	       conectar(); 
	        try {  
		   	    rs = comando.executeQuery("SELECT * FROM funcionario;");  
		   	    
				dtm.addColumn("id");
				dtm.addColumn("nome");
				dtm.addColumn("dtNasc");
				dtm.addColumn("senha");
				dtm.addColumn("cpf");
				dtm.addRow(new String[] {"ID", "Nome", "Data de Nascimento", "Senha", "CPF"});
				while (rs.next()) {  
					dtm.addRow(new String[] {rs.getString("id"), rs.getString("nome"),rs.getString("dtNasc"), rs.getString("senha"), rs.getString("cpf")});
	   	    
	   	    //resultados.add(cli);  
				}  
	   	         //return resultados;  
				return dtm;
	   	    } catch (SQLException e) {  
	   	         imprimeErro("Erro ao buscar funcionário", e.getMessage());  
	   	        return null;  
	   	    }
	       
	        //return dtm;
	   }
	   
	   public DefaultTableModel filtra(String filtro) {
		   if(filtro == null) {
			   return null;
		   }
		   DefaultTableModel dtm = new DefaultTableModel(){
	           public boolean isCellEditable(int row, int column) {
	               return true;
	           }
	       };
		   
		   conectar();  
		   ResultSet rs;
		   for(int i = 1; i <= dtm.getColumnCount()-1; i++) {
			   dtm.removeRow(i);
		   }
		   try {  
			   rs = comando.executeQuery("SELECT * FROM funcionario WHERE nome LIKE '%" + filtro + "%';");
			   
			   dtm.addColumn("id");
				dtm.addColumn("nome");
				dtm.addColumn("dtNasc");
				dtm.addColumn("senha");
				dtm.addColumn("cpf");
				dtm.addRow(new String[] {"ID", "Nome", "Data de Nascimento", "Senha", "CPF"});
				while (rs.next()) {  
					dtm.addRow(new String[] {rs.getString("id"), rs.getString("nome"),rs.getString("dtNasc"), rs.getString("senha"), rs.getString("cpf")});
			    }
			    return dtm;
			}catch (SQLException e) {
				imprimeErro("Erro ao filtrar", e.getMessage());
				return null;
			}finally {
				fechar();
			}
	   }
	
	public Funcionario buscar(int id) {  
		  this.conectar();  
		  Funcionario func = new Funcionario();  
		  ResultSet rs;  
		  try {  
		    rs = comando.executeQuery("SELECT * FROM funcionario WHERE id = " + id + ";");
		    while (rs.next()) {
		    	  func =  new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("senha"), rs.getString("dataNasc"), rs.getString("cpf"));  
		    }
		    return func;
		  } catch (SQLException e) {  
		    imprimeErro("Erro ao buscar funcionário!", e.getMessage());  
		    return null;  
		  }
	   }
	
	public void insere(Funcionario funcionario){  
	      this.conectar();
	      String encryptedPassword = Encryption.passwordEncryption(funcionario.getSenha());
	      try {  
	         comando.executeUpdate("INSERT INTO funcionario VALUES('" + funcionario.getId()
	         + "', '" + funcionario.getNome() + "', '" + funcionario.getDataNasc() + "', '" + funcionario.getCpf() + "', '" + encryptedPassword + "')");  
	         JOptionPane.showMessageDialog(null, "Inserido!");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao inserir funcionário", e.getMessage());  
	      } finally {  
	         fechar();  
	      }  
	   }
	
	public boolean login(String cpf, String senha) {
		this.conectar();
		ResultSet rs;
		Funcionario f = new Funcionario();
		try {
			rs = this.comando.executeQuery("SELECT * FROM funcionario WHERE cpf = " + cpf + ";");
			while(rs.next()) {
				f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("senha"), rs.getString("dtNasc"), rs.getString("cpf"));
			}
			if(!f.getSenha().equals(senha)){
				JOptionPane.showMessageDialog(null, "Senha incorreta!", "Erro", 0);
				return false;
			}else {
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!", "Erro", 0);
			System.out.println(n.getMessage());
			return false;
		}
	}
	
	/*private void conectar() {
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/CadastroPessoas", "root", "");
			this.comando = con.createStatement();
			System.out.println("Conectado!");
		}catch(SQLException e) {
			imprimeErro("Erro ao conectar", e.getMessage());
		}
	}*/
	
	 private void conectar() {
	      try {  
	         con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.MYSQL);  
	         comando = con.createStatement();  
	         System.out.println("Conectado!");  
	      } catch (ClassNotFoundException e) {  
	         imprimeErro("Erro ao carregar o driver", e.getMessage());  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao conectar", e.getMessage());  
	      }  
	   }
	
	private void imprimeErro(String msg, String msgErro) {
		JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);  
	     System.err.println(msg);  
	     System.out.println(msgErro);  
	     System.exit(0);
	}
	
	private void fechar() {
		try {
			this.comando.close();
			this.con.close();
			System.out.println("Conexão fechada!");
		}catch(SQLException e) {
			imprimeErro("Erro ao fechar conexão!", e.getMessage());
		}
	}
}
