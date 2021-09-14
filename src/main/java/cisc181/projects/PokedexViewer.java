/**
 * Will Gunter
 * Section 80
 * Class that creates the PokedexViewer and implements
 * the filtering and moving forward and backward
 * buttons
 */
package cisc181.projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that creates the PokedexViewer and implements
 * the filtering and moving forward and backward
 * buttons
 */
public class PokedexViewer extends JPanel {
    private int showType = 0;
    private int sortBy = 0;
    public ArrayList<Pokemon> pokedex;
    public ArrayList<Pokemon> sortedPokedex = new ArrayList<>();
    static int current = 0;
    public JPanel pokePanel;

    /**
     * Takes in an ArrayList of Pokemon and allows the user
     * to scroll through them and see information about them
     * @param pokeList ArrayList of Pokemon
     */
    PokedexViewer(ArrayList<Pokemon> pokeList) {
        this.pokedex = pokeList;
        sortedPokedex = (ArrayList<Pokemon>)pokedex.clone();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Add Show Type:
        JPanel showTypePanel = new JPanel();
        showTypePanel.setLayout(new BorderLayout());
        JLabel showTypeLabel = new JLabel(" Show Type: ");
        showTypePanel.add(showTypeLabel, BorderLayout.WEST);

        //Create Drop Down List for Show Type:
        String[] typeList = {"---All---", "Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water"};
        JComboBox typeListDropDown = new JComboBox(typeList);
        typeListDropDown.addItemListener(new ChangeFilterListener());
        showTypePanel.add(typeListDropDown, BorderLayout.EAST);

        //Add Show Type panel to PokedexViewert
        this.add(showTypePanel);

        //Add Sort By:
        JPanel sortByPanel = new JPanel();
        sortByPanel.setLayout(new BorderLayout());
        JLabel sortByLabel = new JLabel(" Sort By:");
        sortByPanel.add(sortByLabel, BorderLayout.WEST);

        //Create Drop Down List for Sort By:
        String[] sortList = {"--", "HP", "Attack", "Defense", "Special Attack", "Special Defense", "Speed", "Species"};
        JComboBox sortListDropDown = new JComboBox(sortList);
        sortListDropDown.addItemListener(new ChangeSortingListener());
        sortByPanel.add(sortListDropDown, BorderLayout.EAST);
        this.add(sortByPanel);

        //Show the first pokemon
        pokePanel = new JPanel();
        PokemonViewer pokeViewer = new PokemonViewer(sortedPokedex.get(current));
        pokePanel.add(pokeViewer);
        this.add(pokePanel);

        //Buttons on the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JButton prevPoke = new JButton("Previous Pokemon");
        prevPoke.setActionCommand("PREV");
        JButton nextPoke = new JButton("Next Pokemon");
        nextPoke.setActionCommand("NEXT");
        prevPoke.addActionListener(new ChangePokemonListener());
        nextPoke.addActionListener(new ChangePokemonListener());
        buttonPanel.add(prevPoke, BorderLayout.WEST);
        buttonPanel.add(nextPoke, BorderLayout.EAST);
        this.add(buttonPanel);
    }

    /**
     * Helper method that replaces the current Pokemon in the GUI
     * with the pokemon at the index "current" in the "sortedPokedex"
     * ArrayList.
     */
    public void changePokemon() {
        pokePanel.removeAll();
        PokemonViewer pokeViewer = new PokemonViewer(sortedPokedex.get(current));
        pokePanel.add(pokeViewer);
        repaint();
        revalidate();
    }

    /**
     * Class that implements the ActionListener that goes to the next
     * pokemon or the previous pokemon depending on if there are any pokemon
     * in the direction you want to go and which button is clicked.
     */
    class ChangePokemonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("PREV")) {
                if (current > 0) {
                    pokePanel.removeAll();
                    current = current -1;
                    changePokemon();
                }
            }
            else if (e.getActionCommand().equals("NEXT")) {
                if (current < sortedPokedex.size()-1) {
                    pokePanel.removeAll();
                    current = current + 1;
                    changePokemon();
                }
            }
        }
    }

    /**
     * Class that implements ItemListener that sorts the Pokedex
     * in order of the stat selected. If nothing selected, it is
     * sorted in order of the pokedex.
     */
    class ChangeSortingListener implements ItemListener {
        PokemonHpComparator hpComparator = new PokemonHpComparator();
        PokemonAttackComparator attackComparator = new PokemonAttackComparator();
        PokemonDefenseComparator defenseComparator = new PokemonDefenseComparator();
        PokemonSpecialAttackComparator specialAttackComparator = new PokemonSpecialAttackComparator();
        PokemonSpecialDefenseComparator specialDefenseComparator = new PokemonSpecialDefenseComparator();
        PokemonSpeedComparator speedComparator = new PokemonSpeedComparator();
        PokemonSpeciesComparator speciesComparator = new PokemonSpeciesComparator();

        /**
         * Method that changes the Pokemon / sorts the ArrayList of
         * Pokemon depending on the sorting type selected
         * @param e ItemEvent, fires when a type of sort is selected
         */
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                switch (e.getItem().toString()) {
                    case "HP":
                        Collections.sort(sortedPokedex, hpComparator);
                        if (sortedPokedex.size() == 0) {
                            System.out.println("No much Pokemon that meet all filters.");
                            sortedPokedex = (ArrayList<Pokemon>) pokedex.clone();
                            current = 0;
                            changePokemon();
                            break;
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Attack":
                        Collections.sort(sortedPokedex, attackComparator);
                        if (sortedPokedex.size() == 0) {
                            System.out.println("No much Pokemon that meet all filters.");
                            sortedPokedex = (ArrayList<Pokemon>) pokedex.clone();
                            current = 0;
                            changePokemon();
                            break;
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Defense":
                        Collections.sort(sortedPokedex, defenseComparator);
                        if (sortedPokedex.size() == 0) {
                            System.out.println("No much Pokemon that meet all filters.");
                            sortedPokedex = (ArrayList<Pokemon>) pokedex.clone();
                            current = 0;
                            changePokemon();
                            break;
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Special Attack":
                        Collections.sort(sortedPokedex, specialAttackComparator);
                        if (sortedPokedex.size() == 0) {
                            System.out.println("No much Pokemon that meet all filters.");
                            sortedPokedex = (ArrayList<Pokemon>) pokedex.clone();
                            current = 0;
                            changePokemon();
                            break;
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Special Defense":
                        Collections.sort(sortedPokedex, specialDefenseComparator);
                        if (sortedPokedex.size() == 0) {
                            System.out.println("No much Pokemon that meet all filters.");
                            sortedPokedex = (ArrayList<Pokemon>) pokedex.clone();
                            current = 0;
                            changePokemon();
                            break;
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Speed":
                        Collections.sort(sortedPokedex, speedComparator);
                        if (sortedPokedex.size() == 0) {
                            System.out.println("No much Pokemon that meet all filters.");
                            sortedPokedex = (ArrayList<Pokemon>) pokedex.clone();
                            current = 0;
                            changePokemon();
                            break;
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Species":
                        Collections.sort(sortedPokedex, speciesComparator);
                        if (sortedPokedex.size() == 0) {
                            System.out.println("No much Pokemon that meet all filters.");
                            sortedPokedex = (ArrayList<Pokemon>) pokedex.clone();
                            current = 0;
                            changePokemon();
                            break;
                        }
                        current = 0;
                        changePokemon();
                        break;
                    default:
                        sortedPokedex = (ArrayList<Pokemon>) pokedex.clone();
                        current = 0;
                        changePokemon();
                        break;
                }
            }
        }
    }

    /**
     * Class that implements ItemListener that trims the pokedex
     * to only contain the pokemon of the selected type. If no
     * type is selected, it reverts back to the original pokedex.
     */
    class ChangeFilterListener implements ItemListener {
        SameTypesPredicate bugPredicate = new SameTypesPredicate("bug");
        SameTypesPredicate darkPredicate = new SameTypesPredicate("dark");
        SameTypesPredicate dragonPredicate = new SameTypesPredicate("dragon");
        SameTypesPredicate electricPredicate = new SameTypesPredicate("electric");
        SameTypesPredicate fairyPredicate = new SameTypesPredicate("fairy");
        SameTypesPredicate fightingPredicate = new SameTypesPredicate("fighting");
        SameTypesPredicate firePredicate = new SameTypesPredicate("fire");
        SameTypesPredicate flyingPredicate = new SameTypesPredicate("flying");
        SameTypesPredicate ghostPredicate = new SameTypesPredicate("ghost");
        SameTypesPredicate grassPredicate = new SameTypesPredicate("grass");
        SameTypesPredicate groundPredicate = new SameTypesPredicate("ground");
        SameTypesPredicate icePredicate = new SameTypesPredicate("ice");
        SameTypesPredicate normalPredicate = new SameTypesPredicate("normal");
        SameTypesPredicate poisonPredicate = new SameTypesPredicate("poison");
        SameTypesPredicate psychicPredicate = new SameTypesPredicate("psychic");
        SameTypesPredicate rockPredicate = new SameTypesPredicate("rock");
        SameTypesPredicate steelPredicate = new SameTypesPredicate("steel");
        SameTypesPredicate waterPredicate = new SameTypesPredicate("water");

        /**
         * Method that changes the pokemon / trims the pokedex
         * to only contain pokemon of a certain type.
         * @param ie ItemEvent, fires when something is selected
         */
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                switch (ie.getItem().toString()) {
                    case "Bug":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(bugPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Dark":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(darkPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Dragon":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(dragonPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Electric":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(electricPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Fairy":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(fairyPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Fighting":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(fightingPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Fire":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(firePredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Flying":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(flyingPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Ghost":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(ghostPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Grass":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(grassPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Ice":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(icePredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Normal":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(normalPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Poison":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(poisonPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Psychic":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(psychicPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Rock":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(rockPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Steel":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(steelPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Water":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(waterPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    case "Ground":
                        sortedPokedex.clear();
                        for (int i = 0; i < pokedex.size(); i++) {
                            if(groundPredicate.test(pokedex.get(i))) {
                                sortedPokedex.add(pokedex.get(i));
                            }
                        }
                        current = 0;
                        changePokemon();
                        break;
                    default:
                        sortedPokedex.clear();
                        sortedPokedex = (ArrayList<Pokemon>) pokedex.clone();
                        current = 0;
                        changePokemon();
                        break;
                }
            }
        }

    }

}
