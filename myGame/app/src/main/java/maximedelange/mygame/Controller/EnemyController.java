package maximedelange.mygame.Controller;

import java.util.ArrayList;

import maximedelange.mygame.Domain.Enemy;
import maximedelange.mygame.R;

/**
 * Created by M on 11/9/2016.
 */

public class EnemyController {
    // Fields
    //private Enemy enemy;
    private ArrayList<Enemy> enemyList;

    public EnemyController(){
        createEnemies();
    }

    public ArrayList<Enemy> createEnemies(){
        enemyList = new ArrayList<>();

        enemyList.add(new Enemy("goblin", R.mipmap.ic_launcher));
        enemyList.add(new Enemy("ogre", R.mipmap.ic_launcher));
        enemyList.add(new Enemy("hobgoblin", R.mipmap.ic_launcher));
        enemyList.add(new Enemy("skeleton", R.mipmap.ic_launcher));
        enemyList.add(new Enemy("zombie", R.mipmap.ic_launcher));

        return this.enemyList;
    }
}
