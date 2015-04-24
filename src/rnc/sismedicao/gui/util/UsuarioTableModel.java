package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.Usuario;
import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

public class UsuarioTableModel extends AbstractTableModel {
	
	private static final long SerialVersionUID = 1L;
	
	private ArrayList<Usuario> usuarios;
	private String[] nomeColunas = {"CODPESSOA","CODUSUARIO", "LOGIN", "NOME"};
	
	public UsuarioTableModel() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public UsuarioTableModel(final ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int getColumnCount() {
		return  nomeColunas.length;
	}
	
	public String getColumnName(final int column) {
		switch (column) {
		case 0:
			return "CODPESSOA";
		case 1:
			return "CODUSUARIO";
		case 2:
			return "LOGIN";
		case 3:
			return "NOME";
		}
		return "?";
	}

	@Override
	public int getRowCount() {
		
		return usuarios.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario usuario = usuarios.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return usuario.getCodPessoa();
		case 1:
			return usuario.getCodUsuario();
		case 2:
			return usuario.getLogin();
		case 3:
			return usuario.getNome();
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
