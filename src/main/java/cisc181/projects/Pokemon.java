/**
 * Will Gunter
 * Section 80
 * Pokemon class that contains the constructor for the Pokemon object
 */

package cisc181.projects;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

/**
 * Pokemon class that contains the constructor and fields for the Pokemon object
 */
public class Pokemon {

    //Declaring fields
    public String species;
    public int hp;
    public int attack;
    public int defense;
    public int special_attack;
    public int special_defense;
    public int speed;
    public BufferedImage sprite = null;
    public ArrayList<String> types;

    /**
     * Constructor for Pokemon object
     * @param json JsonObject that contains information about the Pokemon from PokeAPI
     * @throws PokeapiException
     */
    Pokemon(JsonObject json) throws PokeapiException{
        //Get the stats from the json file (not the image or arraylist)
        this.species = json.getString(PokemonFields.species);
        JsonArray stats = (JsonArray) json.get("stats");
        JsonObject statsHp = (JsonObject) stats.get(0);
        this.hp = statsHp.getInteger(PokemonFields.hp);
        JsonObject statsAttack = (JsonObject) stats.get(1);
        this.attack = statsAttack.getInteger(PokemonFields.attack);
        JsonObject statsDefense = (JsonObject) stats.get(2);
        this.defense = statsDefense.getInteger(PokemonFields.defense);
        JsonObject statsSpecialAttack = (JsonObject) stats.get(3);
        this.special_attack = statsSpecialAttack.getInteger(PokemonFields.special_attack);
        JsonObject statsSpecialDefense = (JsonObject) stats.get(4);
        this.special_defense = statsSpecialDefense.getInteger(PokemonFields.special_defense);
        JsonObject statsSpeed = (JsonObject) stats.get(5);
        this.speed = statsSpeed.getInteger(PokemonFields.speed);

        //Create and set BufferedImage
        JsonObject spritesObj = (JsonObject) json.get("sprites");
        JsonObject spritesObjOther = (JsonObject) spritesObj.get("other");
        JsonObject spritesOfficialArtwork = (JsonObject) spritesObjOther.get("official-artwork");
        String spriteURL = spritesOfficialArtwork.getString(PokemonFields.sprite);
        try {
            URL spriteUrl = new URL(spriteURL);
            this.sprite = ImageIO.read(spriteUrl);
        } catch (java.net.MalformedURLException e) {
            throw new PokeapiException("Error with URL formatting: " + spriteURL, e);
        } catch (java.io.IOException e) {
            throw new PokeapiException("Error with getting sprite data from URL: " + spriteURL, e);
        }

        //Get types
        JsonArray typesArray = (JsonArray) json.get("types");
        ArrayList<String> pokeTypes = new ArrayList<>();
        for (int i = 0; i < typesArray.size(); i++) {
            JsonObject tempobj = (JsonObject) typesArray.get(i);
            JsonObject typeObj = (JsonObject) tempobj.get("type");
            String type = typeObj.getString(PokemonFields.types);
            pokeTypes.add(type);
        }
        this.types = pokeTypes;
    }

}
