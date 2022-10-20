package utility.errors;
import utility.Position;

abstract public class error extends RuntimeException {
    private Position pos;
    private String message;

    public error(String msg, Position pos) {
        this.pos = pos;
        this.message = msg;
    }
    public void tell() {System.err.println("<compiler ERROR>: " + message);}
}
