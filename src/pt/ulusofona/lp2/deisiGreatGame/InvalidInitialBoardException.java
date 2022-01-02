package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends Exception{
    private String message;
    private int id;
    private boolean isTool;

    InvalidInitialBoardException(String message, int id, boolean isTool){
        this.message = message;
        this.id = id;
        this.isTool = isTool;
    }

    public String getMessage() {
        return message;
    }

    public boolean isInvalidAbyss(){
        return !isTool;
    }

    public boolean isInvalidTool(){
        return isTool;
    }

    public int getTypeId(){
        return id;
    }
}
