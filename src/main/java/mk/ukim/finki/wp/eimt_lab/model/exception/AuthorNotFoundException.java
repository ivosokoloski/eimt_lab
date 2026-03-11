package mk.ukim.finki.wp.eimt_lab.model.exception;

public class AuthorNotFoundException extends RuntimeException {
  public AuthorNotFoundException(String message) {
    super(message);
  }
}
