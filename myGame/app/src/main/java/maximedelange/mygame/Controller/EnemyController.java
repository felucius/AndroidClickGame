package maximedelange.mygame.Controller;

import java.util.ArrayList;

import maximedelange.mygame.Domain.Enemy;
import maximedelange.mygame.R;

/**
 * Created by M on 11/9/2016.
 */

public class EnemyController {
    // Fields
    private ArrayList<Enemy> enemyList;

    public EnemyController(){
        createEnemies();
    }

    public ArrayList<Enemy> createEnemies(){
        enemyList = new ArrayList<>();

        enemyList.add(new Enemy("goblin", 1, 3, 0, 0, R.mipmap.goblin));
        enemyList.add(new Enemy("ogre", 1, 2, 0, 0, R.mipmap.ogre));
        enemyList.add(new Enemy("hobgoblin", 2, 3, 0, 1, R.mipmap.hobgoblin));
        enemyList.add(new Enemy("skeleton", 2, 2, 0, 0, R.mipmap.skeleton));
        enemyList.add(new Enemy("zombie", 2, 1, 0, 0, R.mipmap.zombie));
        enemyList.add(new Enemy("troll", 2, 3, 0, 0, R.mipmap.troll));
        enemyList.add(new Enemy("devil", 2, 2, 0, 0, R.mipmap.devil));
        enemyList.add(new Enemy("minotaur", 2, 2, 0, 1, R.mipmap.minotaur));

        return this.enemyList;
    }
}
