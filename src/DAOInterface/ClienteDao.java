package DAOInterface;

import model.Cliente;

public interface ClienteDao {
	public Cliente buscar(int id);
	public void insere(Cliente cliente);
	public void deleta(int id);
	public void atualizar();
}
