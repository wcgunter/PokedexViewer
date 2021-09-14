/**
 * Will Gunter
 * Section 80
 */
package cisc181.projects;

import java.util.function.Predicate;

/**
 * Class that creates the SameTypesPredicate predicate which compares Pokemon types
 */
public class SameTypesPredicate implements Predicate<Pokemon> {
    String[] vals;

    /**
     * Constructor for SameTypesPredicate which uses varargs to allow
     * the user to input as many types as they want to test.
     * @param values String that represents a type, all lowercase (ex: "grass")
     */
    public SameTypesPredicate(String... values) {
        this.vals = values;
    }

    /**
     * test method that takes in a Pokemon and check to see that all
     * types passed in the constructor are types held by the pokemon.
     * @param poke Pokemon
     * @return True if all types are found in the Pokemon, false if not
     */
    @Override
    public boolean test(Pokemon poke) {
        int numOfStrs = this.vals.length;
        int numOfMatches = 0;
        for (int i = 0; i < poke.types.size(); i++) {
            for (int a = 0; a < numOfStrs; a++) {
                if(poke.types.get(i).equals(this.vals[a])) {
                    numOfMatches++;
                }
            }
        }
        if (numOfMatches == numOfStrs) {
            return true;
        }
        else {
            return false;
        }
    }
}
