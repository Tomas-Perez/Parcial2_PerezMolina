package struct.impl.Exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException() {
        super("Object not found");
    }
}
