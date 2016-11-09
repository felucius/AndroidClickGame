package maximedelange.mygame.Domain;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by M on 10/22/2016.
 */

public class Player {
    // Fields
    private String name;
    private int health;
    private int level = 1;
    private int money = 0;
    private int attack;
    private int defence;
    private int armor;
    private int amountOfUpgrades;
    private int sprite;
    private int experience;

    // Constructor
    public Player(String name, int sprite){
        // Initializing a new player with static values
        this.name = name;
        this.health = 3;
        this.level = 1;
        this.money = 0;
        this.attack = 1;
        this.defence = 0;
        this.amountOfUpgrades = 0;
        this.armor = 0;
        this.sprite = sprite;
        this.experience = 0;
    }

    // Methods
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public void setSprite(int sprite){
        this.sprite = sprite;
    }

    public int getSprite(){
        return this.sprite;
    }

    public int getLevel(){
        return this.level;
    }

    public int getMoney(){
        return this.money;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getAttack(){
        return this.attack;
    }

    public void setDefence(int defence){
        this.defence = defence;
    }

    public int getDefence(){
        return this.defence;
    }

    public void setUpgrades(int upgrades){
        this.amountOfUpgrades = upgrades;
    }

    public int getAmountOfUpgrades(){
        return this.amountOfUpgrades;
    }

    public void setArmor(int armor){
        this.armor = armor;
    }

    public int getArmor(){
        return this.armor;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    public int getExperience(){
        return this.experience;
    }
}
