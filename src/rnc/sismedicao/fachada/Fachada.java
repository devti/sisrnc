package rnc.sismedicao.fachada;


public class Fachada {

	private static Fachada instance = null;

	public Fachada() {

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
}
