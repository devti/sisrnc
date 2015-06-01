package rnc.sismedicao.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.*;
import rnc.sismedicao.controller.exception.*;
import rnc.sismedicao.model.beans.*;


public class Fachada {

	private static Fachada instance = null;
	private UsuarioController controladorUsuario;
	private PessoaController controladorPessoa;
	private UnidadeDeMedicaoController controladorUnidadeMedicao;
	private ItemController controladorItem;
	private ItemMedicaoController controladorItemMedicao;
	private EquipamentoController controladorEquipamento;
	private GrupoTecnicoController controladorGrupoTecnico;
	private GrupoTecnicoUsuarioController controladorGrupoTecnicoUsuario;
	private PlanoDeMedicaoController controladorPlanoDeMedicao;
	private OrdemServicoController controladorOrdemServico;


	Fachada() throws Exception {
		this.controladorUsuario = new UsuarioController();
		this.controladorPessoa = new PessoaController();
		this.controladorUnidadeMedicao = new UnidadeDeMedicaoController();
		this.controladorItem = new ItemController();
		this.controladorItemMedicao = new ItemMedicaoController();
		this.controladorEquipamento = new EquipamentoController();
		this.controladorGrupoTecnico = new GrupoTecnicoController();
		this.controladorGrupoTecnicoUsuario = new GrupoTecnicoUsuarioController();
		this.controladorPlanoDeMedicao = new PlanoDeMedicaoController();
		this.controladorOrdemServico = new OrdemServicoController();
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

	// -------------------------------------
	// METODO DE CADASTROS
	// -------------------------------------
	public <E> void cadastrar(E element) throws Exception,
			PessoaJaCadastradaException {
		if (element instanceof Usuario)
			this.controladorUsuario.cadastrar((Usuario) element);
		else if (element instanceof Pessoa)
			this.controladorPessoa.cadastrar((Pessoa) element);
		else if (element instanceof UnidadeDeMedicao)
			this.controladorUnidadeMedicao
					.cadastrar((UnidadeDeMedicao) element);
		else if (element instanceof Item)
			this.controladorItem.cadastrar((Item) element);
		else if (element instanceof ItemMedicao)
			this.controladorItemMedicao.cadastrar((ItemMedicao) element);
		else if (element instanceof Equipamento)
			this.controladorEquipamento.cadastrar((Equipamento) element);
		else if (element instanceof GrupoTecnico)
			this.controladorGrupoTecnico.cadastrar((GrupoTecnico) element);
		else if (element instanceof PlanoDeMedicao)
			this.controladorPlanoDeMedicao.inserir((PlanoDeMedicao) element);
		else if (element instanceof OrdemServico)
			this.controladorOrdemServico.inserir((OrdemServico) element);
	}

	// -------------------------------------
	// METODOS PESSOA
	// -------------------------------------
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

	// -------------------------------------
	// METODOS USUARIO
	// -------------------------------------
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

	// -------------------------------------
	// METODOS UNIDADE DE MEDICAO
	// -------------------------------------
	public ArrayList<UnidadeDeMedicao> unidadeDeMedicaoPesquisaAvancada(
			String atributo, String pesquisa) throws SQLException,
			RepositorioException {
		return this.controladorUnidadeMedicao.pesquisaAvancada(atributo,
				pesquisa);
	}

	public UnidadeDeMedicao unidadeProcurar(String codUnidade)
			throws RepositorioException, SQLException,
			UnidadeDeMedicaoNaoEncontradaException {
		return this.controladorUnidadeMedicao.procurar(codUnidade);
	}

	public ArrayList<UnidadeDeMedicao> listarUnidadeMedicao()
			throws SQLException, RepositorioException {

		return this.controladorUnidadeMedicao.listarUnidadeMedicao();
	}

	// -------------------------------------
	// METODOS ITEM
	// -------------------------------------

	public Item itemProcurar(int codItem) throws RepositorioException,
			SQLException, ItemNaoEncontradoException {
		return this.controladorItem.procurar(codItem);
	}

	public void atualizarItem(Item item) throws Exception {
		this.controladorItem.atualizar(item);
	}

	public ArrayList<Item> listarItem() throws SQLException,
			RepositorioException {
		return this.controladorItem.listarItem();
	}

	public int consultarUltimoCodigoItem() throws Exception {
		return this.controladorItem.consultarUltimoCodigoItem();
	}

	public ArrayList<Item> itemPesquisaAvancada(String atributo, String pesquisa)
			throws SQLException, RepositorioException {
		return this.controladorItem.pesquisaAvancada(atributo, pesquisa);
	}

	public void removerItem(int codItem) throws Exception {
		controladorItem.removerItem(codItem);
	}
	
	public void removerItemEquipamento(int codItem) throws Exception {
		controladorItem.removerItemEquipamento(codItem);
	}

	// -------------------------------------
	// METODOS ITEM MEDICAO
	// -------------------------------------

	// Este metodo retorna um arraylist
	public ArrayList<ItemMedicao> itemMedicaoProcurar(int codItem)
			throws Exception {
		ArrayList<ItemMedicao> itensMedicao = new ArrayList<ItemMedicao>();
		itensMedicao = controladorItemMedicao.procurar(codItem);
		return itensMedicao;
	}

	// Este metodo remove o Item de Medicao do Banco de Dados
	public void removerItemDeMedicao(int codItemMedicao) throws Exception {
		controladorItemMedicao.remover(codItemMedicao);
	}

	// Este metodo atualiza o Item de Medicao do Banco de Dados
	public void alterarItemDeMedicao(ItemMedicao itemMedicao) throws Exception {
		controladorItemMedicao.alterar(itemMedicao);
	}

	// Este metodo remove todos os item de medicao com base no codigo do Item
	public void removerAllItemDeMedicao(int codItem) throws Exception {
		controladorItemMedicao.removerAll(codItem);
	}

	// -------------------------------------
	// METODOS EQUIPAMENTO
	// -------------------------------------

	public ArrayList<Equipamento> equipamentoPesquisaAvancada(String atributo,
			String pesquisa) throws SQLException, RepositorioException {

		return this.controladorEquipamento.pesquisaAvancada(atributo, pesquisa);
	}

	public Equipamento equipamentoProcurar(int codEquipamento)
			throws RepositorioException, SQLException,
			EquipamentoNaoEncontrandoException {
		return this.controladorEquipamento.procurar(codEquipamento);
	}

	public ArrayList<Item> procurarEquipamentoItem(int codEquipamento)
			throws Exception {
		ArrayList<Item> itens = new ArrayList<Item>();
		itens = controladorItem.procurarEquipamentoItem(codEquipamento);
		return itens;
	}
	
	public void equipamentoItemRemover(int codigoEquipamento) throws Exception {
		controladorEquipamento.removerEquipamentoItem(codigoEquipamento);
	}

	public int consultarUltimoCodigoEquipamento() throws Exception {
		return this.controladorEquipamento.consultarUltimoCodigoEquipamento();
	}

	public void cadastraEquipamentoItem(Equipamento e) throws Exception {
		this.controladorEquipamento.cadastrarEquipamentoItem(e);
	}

	public void equipamentoRemover(int codigoEquipamento) throws Exception {
		controladorEquipamento.removerEquipamento(codigoEquipamento);

	}
	
	public void atualizarEquipamento(Equipamento equipamento) {
		controladorEquipamento.atualizarEquipamento(equipamento);		
	}

	/**
	 * METODOS GRUPO TECNICO
	 */

	public int consultarUltimoCodigoGrupoTecnico() throws Exception {
		return controladorGrupoTecnico.consultarUltimoCodigoGrupoTecnico();
	}

	public void alterarGrupoTecnico(GrupoTecnico grupoTecnico) throws Exception {
		controladorGrupoTecnico.alterar(grupoTecnico);
	}

	public void removerGrupoTecnico(int codigoGrupoTecnico) throws Exception {
		controladorGrupoTecnico.remover(codigoGrupoTecnico);
	}

	public ArrayList<GrupoTecnico> GrupoTecnicoPesquisaAvancada(
			String atributo, String pesquisa) throws SQLException,
			RepositorioException {
		return this.controladorGrupoTecnico
				.pesquisaAvancada(atributo, pesquisa);
	}

	public GrupoTecnico grupoTecnicoPesquisar(int codigoGrupoTecnico)
			throws SQLException, GrupoTecnicoNaoEncontradoException,
			RepositorioException {
		return this.controladorGrupoTecnico.pesquisa(codigoGrupoTecnico);
	}

	/**
	 * METORDOS GRUPO TECNICO USUAIROS
	 */
	public void cadastraGrupoTecnicoUsuario(int codigoGrupoTecnico,
			int codigoUsuario) throws Exception {
		controladorGrupoTecnicoUsuario.cadastrar(codigoGrupoTecnico,
				codigoUsuario);
	}

	public ArrayList<Usuario> pesquisaGrupoTecnicoUsuarios(
			int codigoGrupoTecnico) throws SQLException {
		return controladorGrupoTecnicoUsuario
				.procurarGrupoTecnicoUsuarios(codigoGrupoTecnico);
	}

	public void removerAllGrupoTecnicoUsuarios(int codigoGrupoTecnico)
			throws Exception {
		controladorGrupoTecnicoUsuario.removerAll(codigoGrupoTecnico);

	}

	public void removerGrupoTecnicoUsuario(int codigoUsuario) throws Exception {
		controladorGrupoTecnicoUsuario.remover(codigoUsuario);
	}
	
	
	/**
	 * METODOS PLANO DE MEDICAO
	 */
	public int consultarUltimoCodigoPlanoMedicao() throws Exception{
		return controladorPlanoDeMedicao.consultarUltimoCodigoPlanoMedicao();
	}
	public ArrayList<PlanoDeMedicao> planoDeMedicaoPesquisaAvancada(
			String atributo, String pesquisa) throws SQLException,
			RepositorioException {
		return this.controladorPlanoDeMedicao
				.pesquisaAvancada(atributo, pesquisa);
	}

	public PlanoDeMedicao planoDeMedicaoProcurar(int codigo)
			throws RepositorioException, SQLException {
		return this.controladorPlanoDeMedicao.procurar(codigo);
	}

	public void removerPlanoDeMedicao(int codigo) throws Exception{
		controladorPlanoDeMedicao.removerPlanoDeMedicao(codigo);
	}
	/**
	 * METODOS PARA ORDEM DE SERVICO
	 */
	public void removerOrdemServico(int codigoPlanoDeMedicao) throws Exception{
		controladorOrdemServico.removerOrdemServico(codigoPlanoDeMedicao);
	}

	public ArrayList<OrdemServico> listarOS() throws SQLException,
		RepositorioException {
		return this.controladorOrdemServico.listarOS();
	}
	
}
