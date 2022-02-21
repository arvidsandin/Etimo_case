public class EmptyInventoryException extends RuntimeException{
  public EmptyInventoryException() {
      super();
  }
  public EmptyInventoryException(String msg) {
      super(msg);
  }
}
