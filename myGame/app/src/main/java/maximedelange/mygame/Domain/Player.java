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
    private ImageView sprite;

    // Constructor
    public Player(String name, int health, int level, int money, ImageView sprite){
        this.name = name;
        this.health = health;
        this.level = level;
        this.money = money;
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
}
