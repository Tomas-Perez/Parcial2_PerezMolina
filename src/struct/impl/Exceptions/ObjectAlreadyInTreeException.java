package struct.impl.Exceptions;

public class ObjectAlreadyInTreeException extends RuntimeException {
    public ObjectAlreadyInTreeException(){
        super("The object is already in the tree");
    }
}
