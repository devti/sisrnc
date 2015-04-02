package rnc.sismedicao.gui;

import java.util.ArrayList;

import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;
import rnc.sismedicao.model.beans.Usuario;

public class Teste {

	public static void main(String[] args) {
		UnidadeDeMedicao a = new UnidadeDeMedicao("TE", "TE");
		try{
		Fachada f = Fachada.getInstance();
		f.cadastrar(a);
		System.out.println("foi");
		//f.cadastrar(u);
		//f.cadastrar(p);
		//ArrayList<Usuario> lista = f.usuarioPesquisaAvancada("Login", "");
		//for(Usuario u : lista) {
			//System.out.println(u.getLogin());
		//}
		//} catch(Exception e){
		//	System.out.println(e.getMessage());
	//	}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
