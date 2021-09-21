package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Funcionario;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class DAOItemVenda {
	private final String URL = "jdbc:mysql://localhost/CadastroDeVendasEPessoas",  
	         NOME = "root", SENHA = "";  
	  
	   private Connection con;  
	   private Statement comando; 
	   
	 //Montagem do Jtable
	   public DefaultTableModel defaultTableModelItemSaleList() throws Exception {
		   DefaultTableModel dtm = new  DefaultTableModel(){
	           public boolean isCellEditable(int row, int column) {
	               return true;
	           }
	       };
		   
	       ResultSet rs; 
	       conectar(); 
	        try {  
		   	    rs = comando.executeQuery("SELECT * FROM itemvenda;");  
		   	    
				dtm.addColumn("idVenda");
				dtm.addColumn("idProduto");
				dtm.addColumn("quantidade");
				dtm.addColumn("id");
				dtm.addRow(new String[] {"ID da Venda", "ID do Produto", "Quantidade do Produto", "ID"});
				while (rs.next()) {  
					dtm.addRow(new String[] {rs.getString("idVenda"), rs.getString("idProduto"),rs.getString("quantidade"), rs.getString("id")});
	   	    
	   	    //resultados.add(cli);  
				}  
	   	         //return resultados;  
				return dtm;
	   	    } catch (SQLException e) {  
	   	         imprimeErro("Erro ao buscar itemvenda", e.getMessage());  
	   	        return null;  
	   	    }
	       
	        //return dtm;
	   }
	   
	   public DefaultTableModel filtra(int filtro) {
		   DefaultTableModel dtm = new DefaultTableModel(){
	           public boolean isCellEditable(int row, int column) {
	               return true;
	           }
	       };
		   conectar();  
		   ResultSet rs2;
		   for(int i = 1; i <= dtm.getColumnCount()-1; i++) {
			   dtm.removeRow(i);
		   }
		   try {  
			   rs2 = comando.executeQuery("SELECT * FROM itemvenda WHERE id = " + filtro + ";");
			   
			   dtm.addColumn("idVenda");
			   dtm.addColumn("idProduto");
			   dtm.addColumn("quantidade");
			   dtm.addColumn("id");
			   dtm.addRow(new String[] {"ID da Venda", "ID do Produto", "Quantidade do Produto", "ID"});
			   while (rs2.next()) {  
				   dtm.addRow(new String[] {rs2.getString("idVenda"), rs2.getString("idProduto"),rs2.getString("quantidade"), rs2.getString("id")});
			   }
			   return dtm;
			}catch (SQLException e) {
				imprimeErro("Erro ao filtrar", e.getMessage());
				return null;
			}finally {
				fechar();
			}
	   }
	  
	   public ItemVenda buscar(int id) {  
		  conectar();  
		  ItemVenda iv = new ItemVenda();  
		  ResultSet rs;  
		  try {  
		    rs = comando.executeQuery("SELECT * FROM itemvenda WHERE id = " + id + ";");  
		    while (rs.next()) {
		    	  iv =  new ItemVenda(rs.getInt("idVenda"), rs.getInt("idProduto"), rs.getInt("quantidade"), rs.getInt("id"));  
		    }
		    return iv;
		  } catch (SQLException e) {
		    imprimeErro("Erro ao buscar o 'ItemVenda'", e.getMessage());  
		    return null;  
		  }
	   }
	   
	   public int comparaNome(String nomeComboBox) {
		   conectar();  
			  Produto c = new Produto();  
			  ResultSet rs;  
			  try {  
				  rs = comando.executeQuery("SELECT * FROM produto WHERE nome = '" + nomeComboBox + "';");  
				  while (rs.next()) {
					  c =  new Produto(rs.getInt("id"), rs.getString("nome"), rs.getInt("categoria"), rs.getDouble("preco"), rs.getInt("quantidade"));    
			    }
			    return c.getId();
			  } catch (SQLException e) {
			    imprimeErro("Erro ao buscar produto", e.getMessage());  
			    return 0;  
			  }
	   }
	   
	   public int comparaId(int idComboBox) {
		   conectar();  
			  Venda c = new Venda();  
			  ResultSet rs;  
			  try {  
				  rs = comando.executeQuery("SELECT * FROM venda WHERE id = " + idComboBox + ";");  
				  while (rs.next()) {
					  c =  new Venda(rs.getInt("id"), rs.getString("data"), rs.getInt("idFuncionario"));    
			    }
			    return c.getId();
			  } catch (SQLException e) {
			    imprimeErro("Erro ao buscar produto", e.getMessage());  
			    return 0;  
			  }
	   }
	  
	   public void insere(ItemVenda iv){  
	      conectar();  
	      try {  
	         comando.executeUpdate("INSERT INTO itemvenda VALUES('" + iv.getIdVenda()
	         + "', '" + iv.getIdProduto() + "', '" + iv.getQuantidade() + "', '" + iv.getId() + "')");  
	         System.out.println("Inserido!");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao inserir o 'ItemVenda'", e.getMessage());  
	      } finally {  
	         fechar();  
	      }  
	   }
	   
	   public void deleta(int id){
		   conectar();
		   try{
			   comando.executeUpdate("DELETE FROM itemvenda WHERE id =" + id + ";");
			   System.out.println("Excluido!");  
		   } catch(SQLException e){
			   imprimeErro("Erro ao excluir o 'ItemVenda'", e.getMessage());
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
