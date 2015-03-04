package rnc.sismedicao.model.util;

import javax.swing.text.MaskFormatter;


public class VerificadoresEFormatadores {
	
	public static final int CPF_FORMAT = 1;
	public static final int CNPJ_FORMAT = 2;
	public static final int DATE_FORMAT = 3;
	public static final int FONE_FORMAT = 4;
	
	/**
	 * M�todo preenche com "0" a esquerda o valor passado no primeiro par�metro de acordo com a quantidade passada no segundo par�metro
	 * @author Charles Arruda
	 * @param valor
	 * @param ZeroFill Quantidade de "0"
	 * @return
	 */
	public static String zeroFillNumber(int valor, int ZeroFill) {
		return String.format("%05d", valor);
	}

	/**
	 * Formatador com formatos pr�-definidos passados por par�metro para ser usado na inicializa��o de JFormattedTextField.
	 * Ex.: JFormattedTextField Campo = new JFormattedTextField( setManualMaskFormat( "##/##/####" ));
	 * @author Charles Arruda
	 * @param mask
	 * @return
	 */
	
	public static MaskFormatter setManualMaskFormat(String mask){  
        
	       MaskFormatter maskFormatter = new MaskFormatter();  
	       try{  
	    	   maskFormatter.setMask(mask);  
	    	   maskFormatter.setPlaceholderCharacter(' ');   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return maskFormatter;  
	} 
	
	
	/**
	 * Formatador com formatos pr�-definidos passados por par�metro para ser usado na inicializa��o de JFormattedTextField.
	 * Ex.: JFormattedTextField Campo = new JFormattedTextField( setDefaultMaskFormat( VerificadoresEFormatadores.CPF_FORMAT ));
	 * Se for passado no par�metro algum formato n�o definido retornar� sem formato  
	 * @author Charles Arruda
	 * @param mask
	 * @return
	 */
	public static MaskFormatter setDefaultMaskFormat(int MASK_FORMAT){  
		String mascara = "";
		
		MaskFormatter maskFormatter = new MaskFormatter();  
	    try{
			switch (MASK_FORMAT) {
			case CPF_FORMAT:
				mascara = "###.###.###-##";
				break;
			case CNPJ_FORMAT:
				mascara = "##.###.###/####-#";
				break;
			case DATE_FORMAT:
				mascara = "##/##/####";
				break;
			case FONE_FORMAT:
				mascara = "(##)####-####";
				break;
			default:
				mascara = "";	
				break;
			}
			
			maskFormatter.setMask(mascara); 
			maskFormatter.setOverwriteMode(true);
			//maskFormatter.setValueContainsLiteralCharacters(true);
			maskFormatter.setValidCharacters("0123456789");
	    	maskFormatter.setPlaceholderCharacter(' ');    
	    }  
	    catch (Exception excecao) {  
	    	excecao.printStackTrace();  
	    }
	    
	    return maskFormatter;  
	} 
	
}
