/**
 * Will Gunter
 * Section 80
 * Contains the class and methods for PokemonViewer which
 * displays the sprite, name, and information about
 * the Pokemon.
 */
package cisc181.projects;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Contains the class and methods for PokemonViewer which
 * displays the sprite, name, and information about
 * the Pokemon.
 */
public class PokemonViewer extends JPanel {
    private int hp, attack, defense, sattack, sdefense, speed;
    private String name;
    private BufferedImage sprite;
    private ArrayList<String> types;

    /**
     * Takes in a pokemon and displays information about it
     * @param pokemon Pokemon to be analyzed
     */
    PokemonViewer(Pokemon pokemon) {
        this.hp = pokemon.hp;
        this.attack = pokemon.attack;
        this.defense = pokemon.defense;
        this.sattack = pokemon.special_attack;
        this.sdefense = pokemon.special_defense;
        this.speed = pokemon.speed;
        this.name = pokemon.species;
        this.sprite = pokemon.sprite;
        this.types = pokemon.types;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //First row: Species name with first letter capitalized, larger font
        JPanel pokeName = new JPanel();
        pokeName.setLayout(new BorderLayout());
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        JLabel nameLabel = new JLabel(this.name);
        nameLabel.setFont(new Font(nameLabel.getFont().getName(), Font.PLAIN, 28));
        pokeName.add(nameLabel, BorderLayout.WEST);
        this.add(pokeName);

        //Second Row: Sprite (far left), types (far right)
        JPanel row2 = new JPanel();
        row2.setLayout(new BorderLayout());

        JLabel labelSprite = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(this.sprite).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        labelSprite.setIcon(imageIcon);
        row2.add(labelSprite, BorderLayout.WEST);

        //Creating all of the labels for all of the types, not going to use all of them
        JPanel typesPanel = new JPanel();
        typesPanel.setLayout(new BorderLayout());

        Border border = BorderFactory.createRaisedBevelBorder();

        JLabel typeLabel = new JLabel("Type: ");
        typesPanel.add(typeLabel, BorderLayout.WEST);

        JLabel bug = new JLabel("bug");
        bug.setBackground(Color.decode("0xa8b820"));
        bug.setOpaque(true);
        bug.setBorder(border);

        JLabel dark = new JLabel("flying");
        dark.setBackground(Color.decode("0x705848"));
        dark.setOpaque(true);
        dark.setBorder(border);

        JLabel dragon = new JLabel("dragon");
        dragon.setBackground(Color.decode("0x7038f8"));
        dragon.setOpaque(true);
        dragon.setBorder(border);

        JLabel electric = new JLabel("electric");
        electric.setBackground(Color.decode("0xf8d030"));
        electric.setOpaque(true);
        electric.setBorder(border);

        JLabel fairy = new JLabel("fairy");
        fairy.setBackground(Color.decode("0xF98CFF"));
        fairy.setOpaque(true);
        fairy.setBorder(border);

        JLabel fighting = new JLabel("fighting");
        fighting.setBackground(Color.decode("0xc03028"));
        fighting.setOpaque(true);
        fighting.setBorder(border);

        JLabel fire = new JLabel("fire");
        fire.setBackground(Color.decode("0xf08030"));
        fire.setOpaque(true);
        fire.setBorder(border);

        JLabel flying = new JLabel("flying");
        flying.setBackground(Color.decode("0xa890f0"));
        flying.setOpaque(true);
        flying.setBorder(border);

        JLabel ghost = new JLabel("ghost");
        ghost.setBackground(Color.decode("0x705898"));
        ghost.setOpaque(true);
        ghost.setBorder(border);

        JLabel grass = new JLabel("grass");
        grass.setBackground(Color.decode("0x78c850"));
        grass.setOpaque(true);
        grass.setBorder(border);

        JLabel ground = new JLabel("ground");
        ground.setBackground(Color.decode("0xe0c068"));
        ground.setOpaque(true);
        ground.setBorder(border);

        JLabel ice = new JLabel("ice");
        ice.setBackground(Color.decode("0x98d8d8"));
        ice.setOpaque(true);
        ice.setBorder(border);

        JLabel normal = new JLabel("normal");
        normal.setBackground(Color.decode("0xa8a878"));
        normal.setOpaque(true);
        normal.setBorder(border);

        JLabel poison = new JLabel("poison");
        poison.setBackground(Color.decode("0xa040a0"));
        poison.setOpaque(true);
        poison.setBorder(border);

        JLabel psychic = new JLabel("psychic");
        psychic.setBackground(Color.decode("0xf85888"));
        psychic.setOpaque(true);
        psychic.setBorder(border);

        JLabel rock = new JLabel("rock");
        rock.setBackground(Color.decode("0xb8a038"));
        rock.setOpaque(true);
        rock.setBorder(border);

        JLabel steel = new JLabel("steel");
        steel.setBackground(Color.decode("0xb8b8d0"));
        steel.setOpaque(true);
        steel.setBorder(border);

        JLabel water = new JLabel("water");
        water.setBackground(Color.decode("0x6890f0"));
        water.setOpaque(true);
        water.setBorder(border);

        JPanel typesLabelPanel = new JPanel();
        typesLabelPanel.setLayout(new GridBagLayout());

        for (int i = 0; i < types.size(); i++) {
            switch(types.get(i)) {
                case "bug":
                    typesLabelPanel.add(bug);
                    break;
                case "dark":
                    typesLabelPanel.add(dark);
                    break;
                case "dragon":
                    typesLabelPanel.add(dragon);
                    break;
                case "electric":
                    typesLabelPanel.add(electric);
                    break;
                case "fairy":
                    typesLabelPanel.add(fairy);
                    break;
                case "fighting":
                    typesLabelPanel.add(fighting);
                    break;
                case "fire":
                    typesLabelPanel.add(fire);
                    break;
                case "flying":
                    typesLabelPanel.add(flying);
                    break;
                case "ghost":
                    typesLabelPanel.add(ghost);
                    break;
                case "grass":
                    typesLabelPanel.add(grass);
                    break;
                case "ground":
                    typesLabelPanel.add(ground);
                    break;
                case "ice":
                    typesLabelPanel.add(ice);
                    break;
                case "normal":
                    typesLabelPanel.add(normal);
                    break;
                case "poison":
                    typesLabelPanel.add(poison);
                    break;
                case "psychic":
                    typesLabelPanel.add(psychic);
                    break;
                case "rock":
                    typesLabelPanel.add(rock);
                    break;
                case "steel":
                    typesLabelPanel.add(steel);
                    break;
                case "water":
                    typesLabelPanel.add(water);
                    break;
            }
        }
        typesPanel.add(typesLabelPanel, BorderLayout.EAST);
        row2.add(typesPanel, BorderLayout.EAST);
        this.add(row2);

        //Add all of the stats!
        StatPanel hpPanel = new StatPanel(" HP:", this.hp);
        this.add(hpPanel);

        StatPanel attackPanel = new StatPanel(" Attack:", this.attack);
        this.add(attackPanel);

        StatPanel defensePanel = new StatPanel(" Defense:", this.defense);
        this.add(defensePanel);

        StatPanel specAttackPanel = new StatPanel(" Special Attack:", this.sattack);
        this.add(specAttackPanel);

        StatPanel specDefensePanel = new StatPanel(" Special Defense:", this.sdefense);
        this.add(specDefensePanel);

        StatPanel speedPanel = new StatPanel(" Speed:", this.speed);
        this.add(speedPanel);

    }

    /**
     * Sub-class that displays all of the stats
     * of the Pokemon
     */
    private static class StatPanel extends JPanel {

        private String name;
        private int value;

        /**
         * Takes in a stat's name and its value
         * and displays it using a percentage bar
         * @param name
         * @param value
         */
        StatPanel(String name, int value) {
            this.name = name;
            this.value = value;
            this.setLayout(new BorderLayout());

            JLabel statTextLabel = new JLabel(name);
            JProgressBar statBar = new JProgressBar(0,255);
            statBar.setValue(value);
            statBar.setString(String.valueOf(value));
            statBar.setStringPainted(true);
            this.add(statTextLabel, BorderLayout.WEST);
            this.add(statBar, BorderLayout.EAST);
        }
    }
}
