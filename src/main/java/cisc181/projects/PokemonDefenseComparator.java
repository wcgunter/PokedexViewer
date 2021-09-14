/**
 * Will Gunter
 * Section 80
 * Creates the comparator that compares the defense values of the pokemon passed in
 */
package cisc181.projects;

import java.util.Comparator;

/**
 * Class that creates a comparator that compares the defense values of the pokemon passed in
 */
public class PokemonDefenseComparator implements Comparator<Pokemon> {

    /**
     * Creates compare method that compares two defense values of two pokemon
     * @param poke1 First Pokemon
     * @param poke2 Second Pokemon
     * @return -1, 0, or 1 depending on the values of each Pokemon's defense stat
     */
    @Override
    public int compare(Pokemon poke1, Pokemon poke2) {
        return Integer.compare(poke1.defense, poke2.defense);
    }
}
