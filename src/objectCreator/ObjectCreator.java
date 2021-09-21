package objectCreator;
import model.Categoria;
import model.Cliente;
import model.Contato;
import dao.DAOCategoria;
import dao.DAOCliente;
import dao.DAOContato;
import model.Funcionario;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import dao.DAOFuncionario;
import dao.DAOItemVenda;
import dao.DAOProduto;
import dao.DAOVenda;

public class ObjectCreator {
	public static void registraCliente(int id, String nome, String dtNasc, String mae, String cpf) {
		DAOCliente c = new DAOCliente();
		c.insere(new Cliente(id, nome, mae, dtNasc, cpf));
	}
	
	public static void registraFuncionario(int id, String nome, String dtNasc, String cpf, String senha) {
		DAOFuncionario f = new DAOFuncionario();
		f.insere(new Funcionario(id, nome, senha, dtNasc, cpf));
	}
	
	public static void registraProduto(int id, int idCategoria, String nome, double preco, int quant) {
		DAOProduto p = new DAOProduto();
		p.insere(new Produto(id, nome, idCategoria, preco, quant));
	}

	public static void registraCategoria(int idCateg, String nome) {
		DAOCategoria c = new DAOCategoria();
		c.insere(new Categoria(idCateg, nome));
	}

	public static void registraContato(int id, int func, int telefone) {
		DAOContato c = new DAOContato();
		c.insere(new Contato(func, telefone, id));
	}

	public static void registraVenda(int idVenda, String data, int funcionario) {
		DAOVenda v = new DAOVenda();
		v.insere(new Venda(idVenda, data, funcionario));
	}

	public static void registraItemVenda(int idItemVenda, int venda, int produto, int quantidade) {
		DAOItemVenda iv = new DAOItemVenda();
		iv.insere(new ItemVenda(venda, produto, quantidade, idItemVenda));
	}
}
