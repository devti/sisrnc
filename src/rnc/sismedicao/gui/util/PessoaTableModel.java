package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.Pessoa;

public class PessoaTableModel extends AbstractTableModel{
	
private static final long SerialVersionUID = 1L;
	
	private ArrayList<Pessoa> pessoas;
	private String[] nomeColunas = {"CODPESSOA", "NOME", "CPF", "EMAIL", "TELEFONE"};
	
	public PessoaTableModel() {
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public  PessoaTableModel(final ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	@Override
	public int getColumnCount() {
		return nomeColunas.length;
	}
	
	public String getColumnName(final int column) {
		switch (column) {
		case 0:
			return "CODPESSOA";
		case 1:
			return "NOME";
		case 2:
			return "CPF";
		case 3:
			return "EMAIL";
		case 4:
			return "TELEFONE";
		}
		return "?";
		
	}
	
	@Override
	public int getRowCount() {
		return pessoas.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pessoa pessoa = pessoas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return pessoa.getCodPessoa();
		case 1:
			return pessoa.getNome();
		case 2:
			return pessoa.getCpf();
		case 3:
			return pessoa.getEmail();
		case 4:
			return pessoa.getTelefone();
		default:
			return null;
		}
	}
	
	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		return false;
	}
	
	public String[] getNomeColunas() {
		return nomeColunas;
	}

}
