/**
 * Will Gunter
 * Section 80
 * Creates the comparator that compares the special attack values of the pokemon passed in
 */
package cisc181.projects;

import java.util.Comparator;

/**
 * Class that creates a comparator that compares the special attack values of the pokemon passed in
 */
public class PokemonSpecialAttackComparator implements Comparator<Pokemon> {

    /**
     * Creates compare method that compares two special attack values of two pokemon
     * @param poke1 First Pokemon
     * @param poke2 Second Pokemon
     * @return -1, 0, or 1 depending on the values of each Pokemon's special attack stat
     */
    @Override
    public int compare(Pokemon poke1, Pokemon poke2) {
        return Integer.compare(poke1.special_attack, poke2.special_attack);
    }
}
