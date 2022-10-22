package utility.errors;
import utility.Position;

abstract public class error extends RuntimeException {
    private Position pos;
    private String message;

    public error(String msg, Position pos) {
        this.pos = pos;
        this.message = msg;
    }
    public void tell() {System.err.println("<COMPILER ERROR OCCURED>: " +message+" at row&col:");
        System.err.println(pos.get_row());
        System.err.println(pos.get_col());
    }
}
