/**
 * Will Gunter
 * Section 80
 * This class contains the base of Project2's application, including the
 * import of the first 150 pokemon of the Pokedex and creating the GUI.
 */
package cisc181.projects;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class contains the base of Project2's application, including the
 * import of the first 150 pokemon of the Pokedex and creating the GUI.
 */
public class App implements Runnable
{
    /**
     * "Main" function of the application, imports all Pokemon
     * and creates the GUI
     */
    public void run() {
        JFrame jframe = new JFrame("Pokedex Viewer");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Pokemon> pokedex= new ArrayList<>();
        for (int i = 1; i <= 150; i++) {
            try {
                URL pokeUrl = new URL("https://pokeapi.co/api/v2/pokemon/" + i);
                JsonObject pokeJson = (JsonObject) Jsoner.deserialize(new InputStreamReader(pokeUrl.openStream()));
                Pokemon pokemon = new Pokemon(pokeJson);
                pokedex.add(pokemon);
                if (i == 1) {
                    System.out.println("Starting import of Pokemon");
                }
                else if (i == 50) {
                    System.out.println("1/3 complete...");
                }
                else if (i == 100) {
                    System.out.println("2/3 complete...");
                }
                else if (i == 140) {
                    System.out.println("Almost there, finishing up");
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JsonException e) {
                e.printStackTrace();
            } catch (PokeapiException e) {
                e.printStackTrace();
            }
        }
        PokedexViewer tester = new PokedexViewer(pokedex);

        jframe.add(tester);
        jframe.pack();
        jframe.setVisible(true);
    }

    /**
     * Main function, sets up Application
     * @param args
     */
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new App());
    }

}
