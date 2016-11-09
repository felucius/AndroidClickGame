package maximedelange.mygame.Domain;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by M on 11/9/2016.
 */

public class Enemy {
    // Fields
    private String name;
    private int health;
    private int defence;
    private int armor;
    private int sprite;

    // Constructor
    public Enemy(String name, int sprite){
        this.name = name;
        this.sprite = sprite;
        this.health = 1;
        this.defence = 0;
        this.armor = 0;
    }

    // Methods
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return this.health;
    }

    public void setDefence(int defence){
        this.defence = defence;
    }

    public int getDefence(){
        return this.defence;
    }

    public void setArmor(int armor){
        this.armor = armor;
    }

    public int getArmor(){
        return this.armor;
    }

    public void setSprite(int sprite){
        this.sprite = sprite;
    }

    public int getSprite(){
        return this.sprite;
    }
}
