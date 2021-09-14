/**
 * Will Gunter
 * Section 80
 * Creates the PokeapiException which gets passed instead of other exceptions
 * when creating Pokemon objects.
 */

package cisc181.projects;

/**
 * Creates the PokeapiException which gets passed instead of other exceptions
 * when creating Pokemon objects. Extends exception. Allows exception chaining.
 */
public class PokeapiException extends Exception{
    public PokeapiException(String errorMessage) {
        super(errorMessage);
    }
    public PokeapiException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
