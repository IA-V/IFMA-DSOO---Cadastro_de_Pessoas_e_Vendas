package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Categoria;
import model.Produto;

public class DAOProduto {
	private final String URL = "jdbc:mysql://localhost/CadastroDeVendasEPessoas",  
	         NOME = "root", SENHA = "";  
	  
	   private Connection con;  
	   private Statement comando;
	   
	 //Montagem do Jtable
	   public DefaultTableModel defaultTableModelProductList() throws Exception {
		   DefaultTableModel dtm = new  DefaultTableModel(){
	           public boolean isCellEditable(int row, int column) {
	               return true;
	           }
	       };
		   
	       ResultSet rs; 
	       conectar(); 
	        try {  
		   	    rs = comando.executeQuery("SELECT * FROM produto;");  
		   	    
				dtm.addColumn("id");
				dtm.addColumn("nome");
				dtm.addColumn("categoria");
				dtm.addColumn("preço");
				dtm.addColumn("quantidade");
				dtm.addRow(new String[] {"ID", "Nome", "Categoria", "Preço", "Quantidade"});
			while (rs.next()) {  
				dtm.addRow(new String[] {rs.getString("id"), rs.getString("nome"),rs.getString("categoria"), rs.getString("preco"), rs.getString("quantidade")});
	   	    
	   	    //resultados.add(cli);  
	   	    }  
	   	         //return resultados;  
				return dtm;
	   	    } catch (SQLException e) {  
	   	         imprimeErro("Erro ao buscar produto", e.getMessage());  
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
			   rs = comando.executeQuery("SELECT * FROM produto WHERE nome LIKE '%" + filtro + "%';");
			   
			    dtm.addColumn("id");
				dtm.addColumn("nome");
				dtm.addColumn("categoria");
				dtm.addColumn("preço");
				dtm.addColumn("quantidade");
				dtm.addRow(new String[] {"ID", "Nome", "Categoria", "Preço", "Quantidade"});
			    while (rs.next()) {
				    dtm.addRow(new String[] {rs.getString("id"), rs.getString("nome"), rs.getString("categoria"), rs.getString("preco"), rs.getString("quantidade")});
			    }
			    return dtm;
			}catch (SQLException e) {
				imprimeErro("Erro ao filtrar", e.getMessage());
				return null;
			}finally {
				fechar();
			}
	   }
	  
	   public Produto buscar(int id) {  
		  conectar();  
		  Produto p = new Produto();  
		  ResultSet rs;  
		  try {  
		    rs = comando.executeQuery("SELECT * FROM produto WHERE id = " + id + ";");  
		    while (rs.next()) {
		    	  p =  new Produto(rs.getInt("id"), rs.getString("nome"), rs.getInt("categoria"), rs.getDouble("preco"), rs.getInt("quantidade"));  
		    }
		    return p;
		  } catch (SQLException e) {
		    imprimeErro("Erro ao buscar produto", e.getMessage());  
		    return null;  
		  }
	   }
	   
	   public int comparaNome(String nomeComboBox) {
		   conectar();  
			  Categoria c = new Categoria();  
			  ResultSet rs;  
			  try {  
				  rs = comando.executeQuery("SELECT * FROM categoria WHERE nome = '" + nomeComboBox + "';");  
				    while (rs.next()) {
				    	  c =  new Categoria(rs.getInt("id"), rs.getString("nome"));  
				    }
			    return c.getId();
			  } catch (SQLException e) {
			    imprimeErro("Erro ao buscar produto", e.getMessage());  
			    return 0;  
			  }
	   }
	  
	   public void insere(Produto p){  
	      conectar();  
	      try {  
	         comando.executeUpdate("INSERT INTO produto VALUES('" + p.getId()
	         + "', '" + p.getNome() + "', '" + p.getCategoria() + "', '" + p.getPreco() + "', '" + p.getQuantidade() + "')");  
	         System.out.println("Inserido!");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao inserir produto", e.getMessage());  
	      } finally {  
	         fechar();  
	      }  
	   }
	   
	   public void deleta(int id){
		   conectar();
		   try{
			   comando.executeUpdate("DELETE FROM produto WHERE id =" + id + ";");
			   System.out.println("Excluido!");  
		   } catch(SQLException e){
			   imprimeErro("Erro ao excluir produto", e.getMessage());
		   }finally {  
			   fechar();  
		   }
	   }
	   
	   /*public void atualizar(){
		   conectar();
		   try{
			   int i;
			   String s;
			   do {
				   System.out.println("O que você deseja atualizar? 1 - Nome, 2 - Setor, 3 - Data de Nascimento, 4 - Sair?");
				   Scanner sc = new Scanner(System.in);
				   while(!sc.hasNextInt()) {
					   String st = sc.next();
					   System.out.println("O que você deseja atualizar? 1 - Nome, 2 - Setor, 3 - Data de Nascimento, 4 - Sair?");
				   }
				   i = sc.nextInt();
				   switch(i){
				   case 1:
					   System.out.println("Digite o id do cliente: ");
					   while(!sc.hasNextInt()) {
						   String g = sc.next();
						   System.out.println("ID inválido!");
						   System.out.println("Digite o id do cliente: ");
					   }
					   i = sc.nextInt();
					   System.out.println("Digite o novo nome dele: ");
					   s = sc.next();				   
					   comando.executeUpdate("UPDATE cliente SET nome = '" + s + "' WHERE id = " + i + ";"); 
					   System.out.println("Atualizado!");
					   break;
				   case 2:
					   System.out.println("Digite o id do cliente: ");
					   while(!sc.hasNextInt()) {
						   String g = sc.next();
						   System.out.println("ID inválido!");
						   System.out.println("Digite o id do cliente: ");
					   }
					   i = sc.nextInt();
					   System.out.println("Digite o novo setor dele: ");
					   s = sc.next();
					   comando.executeUpdate("UPDATE cliente SET nome = '" + s + "' WHERE id = " + i + ";");
					   System.out.println("Atualizado!");  
					   break;
				   case 3:
					   System.out.println("Digite o id do cliente: ");
					   while(!sc.hasNextInt()) {
						   String g = sc.next();
						   System.out.println("ID inválido!");
						   System.out.println("Digite o id do cliente: ");
					   }
					   i = sc.nextInt();
					   System.out.println("Digite a nova data de nascimento dele (DD/MM/YYYY): ");
					   s = sc.next();
					   comando.executeUpdate("UPDATE cliente SET nome = '" + s + "' WHERE id = " + i + ";");
					   System.out.println("Atualizado!"); 
					   break;
				   case 4:
					   break;
					default: 
						System.out.println("Opção inválida!");
						break;
		   			}
			   }while(i != 4);
		   } catch(SQLException e){
			   imprimeErro("Erro ao atualizar o cliente", e.getMessage());
		   }finally {  
			   fechar();  
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
	  
	   private void fechar() {  
	      try {  
	         comando.close();
	         con.close();  
	         System.out.println("Conexão Fechada!");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao fechar conexão", e.getMessage());  
	      }  
	   }  
	  
	   private void imprimeErro(String msg, String msgErro) {  
	      JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);  
	      System.err.println(msg);  
	      System.out.println(msgErro);  
	      System.exit(0);  
	   }  
}
