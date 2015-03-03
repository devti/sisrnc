package rnc.sismedicao.controller.exception;



public class RepositorioException extends Exception {

    private Exception exception;

    public RepositorioException(Exception exception) {
        super("Exce��o encapsulada");
        this.exception = exception;
        exception.printStackTrace();
    }

    public String getMessage() {
        return exception.getMessage();
    }

    public void printStackTrace() {
        exception.printStackTrace();
    }

}