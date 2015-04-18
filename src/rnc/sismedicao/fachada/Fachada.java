package rnc.sismedicao.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.PessoaController;
import rnc.sismedicao.controller.UnidadeDeMedicaoController;
import rnc.sismedicao.controller.UsuarioController;
import rnc.sismedicao.controller.ItemController;
import rnc.sismedicao.controller.ItemMedicaoController;
import rnc.sismedicao.controller.exception.ItemMedicaoNaoEncontradoException;
import rnc.sismedicao.controller.exception.ItemNaoEncontradoException;
import rnc.sismedicao.controller.exception.PessoaJaCadastradaException;
import rnc.sismedicao.controller.exception.PessoaNaoEncontradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.SenhaInvalidaException;
import rnc.sismedicao.controller.exception.UnidadeDeMedicaoNaoEncontradaException;
import rnc.sismedicao.controller.exception.UsuarioNaoEncontradoException;
import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.ItemMedicao;
public class Fachada {

	private static Fachada instance = null;
	private UsuarioController controladorUsuario;
	private PessoaController controladorPessoa;
	private UnidadeDeMedicaoController controladorUnidadeMedicao;
	private ItemController controladorItem;
	private ItemMedicaoController controladorItemMedicao;

	Fachada() throws Exception {
		this.controladorUsuario = new UsuarioController();
		this.controladorPessoa = new PessoaController();
		this.controladorUnidadeMedicao = new UnidadeDeMedicaoController();
		this.controladorItem = new ItemController();
		this.controladorItemMedicao = new ItemMedicaoController();
	}

	public static Fachada getInstance() throws Exception {
		if (Fachada.instance == null) {
			try {
				Fachada.instance = new Fachada();
			} catch (Exception e) {
				throw new Exception("Erro => " + e.getMessage());
			}
		}
		return Fachada.instance;
	}
	
	//-------------------------------------
	// METODO DE CADASTROS
	//-------------------------------------
	public <E> void cadastrar(E element) throws Exception,
			PessoaJaCadastradaException {
		if (element instanceof Usuario)
			this.controladorUsuario.cadastrar((Usuario) element);
		else if (element instanceof Pessoa)
			this.controladorPessoa.cadastrar((Pessoa) element);
		else if (element instanceof UnidadeDeMedicao)
			this.controladorUnidadeMedicao.cadastrar((UnidadeDeMedicao) element);
		else if (element instanceof Item)
			this.controladorItem.cadastrar((Item) element);
		else if (element instanceof ItemMedicao)
			this.controladorItemMedicao.cadastrar((ItemMedicao) element);
	}
 

	

	//-------------------------------------
	// METODOS PESSOA
	//-------------------------------------
	public void pessoaRemover(int codPessoa) throws RepositorioException,
			SQLException {
		this.controladorPessoa.remover(codPessoa);
	}
	
	public void atualizar(Pessoa pessoa) {

	}
	
	public ArrayList<Pessoa> pessoaPesquisaAvancada(String atributo,
			String pesquisa) throws SQLException, RepositorioException {

		return this.controladorPessoa.pesquisaAvancada(atributo, pesquisa);
	}	
	
	public Pessoa pessoaProcurar(int codPessoa)
			throws PessoaNaoEncontradaException, RepositorioException,
			SQLException {
		return this.controladorPessoa.procurar(codPessoa);
	}
	
	//-------------------------------------
	// METODOS USUARIO
	//-------------------------------------
	public boolean usuarioLogin(String usuario, String senha)
			throws RepositorioException, SQLException, SenhaInvalidaException {
		return controladorUsuario.login(usuario, senha);
	}

	public ArrayList<Usuario> usuarioPesquisaAvancada(String atributo,
			String pesquisa) throws SQLException, RepositorioException {

		return this.controladorUsuario.pesquisaAvancada(atributo, pesquisa);
	}

	public void usuarioRemover(int codPessoa) throws RepositorioException,
			SQLException {
		this.controladorUsuario.remover(codPessoa);

	}

	public Usuario usuarioProcurar(int codPessoa)
			throws UsuarioNaoEncontradoException, RepositorioException,
			SQLException {
		return this.controladorUsuario.procurar(codPessoa);
	}

	//-------------------------------------
    // METODOS UNIDADE DE MEDICAO
	//-------------------------------------
	public ArrayList<UnidadeDeMedicao> unidadeDeMedicaoPesquisaAvancada(String atributo, String pesquisa)
			throws SQLException, RepositorioException {
		return this.controladorUnidadeMedicao.pesquisaAvancada(atributo, pesquisa);
	}

	public UnidadeDeMedicao unidadeProcurar(String codUnidade) throws RepositorioException,
			SQLException, UnidadeDeMedicaoNaoEncontradaException {
		return this.controladorUnidadeMedicao.procurar(codUnidade);	
	}
	
	public ArrayList<UnidadeDeMedicao> listarUnidadeMedicao() throws SQLException, RepositorioException {
		
		return this.controladorUnidadeMedicao.listarUnidadeMedicao();
	}
	
	//-------------------------------------
    // METODOS ITEM
	//-------------------------------------
	
	public Item itemProcurar (int codItem) throws RepositorioException, SQLException,
			ItemNaoEncontradoException {
				return this.controladorItem.procurar(codItem);
		
	}

	public ArrayList<Item> listarItem()  throws SQLException, RepositorioException {
		return this.controladorItem.listarItem();
	}
	
	public int consultarUltimoCodigoItem() throws Exception{
		return this.controladorItem.consultarUltimoCodigoItem();
	}
	
	public ArrayList<Item> itemPesquisaAvancada(String atributo,
			String pesquisa) throws SQLException, RepositorioException {
		return this.controladorItem.pesquisaAvancada(atributo, pesquisa);
	}
	
	//-------------------------------------
    // METODOS ITEM MEDICAO
	//-------------------------------------

	
	//Este metodo retorna um arraylist 
	public ArrayList<ItemMedicao> itemMedicaoProcurar (int codItem) throws Exception {
		ArrayList<ItemMedicao> itensMedicao = new ArrayList<ItemMedicao>();	
		itensMedicao = controladorItemMedicao.procurar(codItem);
		return itensMedicao;
		 

}

	
}
