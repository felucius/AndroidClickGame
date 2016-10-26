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
    private ImageView sprite;

    // Constructor
    public Player(String name, ImageView sprite){
        this.name = name;
        this.health = 3;
        this.level = 1;
        this.money = 0;
        this.attack = 1;
        this.defence = 0;
        this.sprite = sprite;
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

    public void setSprite(ImageView sprite){
        this.sprite = sprite;
    }

    public ImageView getSprite(){
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
}
