package DAOInterface;

import model.Funcionario;

public interface FuncionarioDao {
	public Funcionario buscar(int id);
	public void insere(Funcionario func);
	/*public void deleta(int id);
	public void atualizar();*/
}
