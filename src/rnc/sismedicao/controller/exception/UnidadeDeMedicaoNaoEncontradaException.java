package rnc.sismedicao.controller.exception;

public class UnidadeDeMedicaoNaoEncontradaException extends Exception {

		private String codUnidade;
		
		public UnidadeDeMedicaoNaoEncontradaException(String codUnidade){
			super("Unidade n�o Encontrada!");
			this.codUnidade = codUnidade;
		}
		
		public String getCodUnidade(){
			return codUnidade;
		}
}
