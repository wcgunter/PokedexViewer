/**
 * Will Gunter
 * Section 80
 * Contains the enum PokemonFields that returns the keys to get the
 * data from the JsonFiles passed into the Pokemon constructor.
 */

package cisc181.projects;

import com.github.cliftonlabs.json_simple.JsonKey;

/**
 * Creates an enum PokemonFields that is a JsonKey which
 * can be used to get data from the JsonObject passed into
 * the Pokemon constructor.
 */
public enum PokemonFields implements JsonKey {
    species, hp, attack, defense, special_attack, special_defense, speed, sprite, types;

    /**
     * Returns the string which represents the key to get
     * the correct data for each field.
     * @return the key for the corresponding data in the JsonObject
     */
    public String getKey() {
        switch (this) {
            case species:
                return "name";
            case hp:
                return "base_stat";
            case attack:
                return "base_stat";
            case defense:
                return "base_stat";
            case special_attack:
                return "base_stat";
            case special_defense:
                return "base_stat";
            case speed:
                return "base_stat";
            case sprite:
                return "front_default";
            case types:
                return "name";
        }
        return null;
    }

    /**
     * Function that is required for enum but not used
     * in this case. Returns null / bad information if
     * used. Returns "Not a field" if a field that does
     * not exist is passed in.
     * @return null / -1 / "Unknown" / "Not a field"
     */
    public Object getValue() {
        switch (this) {
            case species:
                return "Unknown";
            case hp:
                return -1;
            case attack:
                return -1;
            case defense:
                return -1;
            case special_attack:
                return -1;
            case special_defense:
                return -1;
            case speed:
                return -1;
            case sprite:
                return null;
            case types:
                return null;
        }
        return "Not a field";
    }
}
