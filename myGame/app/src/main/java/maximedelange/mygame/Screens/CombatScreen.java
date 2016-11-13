package maximedelange.mygame.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import maximedelange.mygame.Controller.EnemyController;
import maximedelange.mygame.Domain.Enemy;
import maximedelange.mygame.Domain.Player;
import maximedelange.mygame.R;

public class CombatScreen extends AppCompatActivity {
    // Fields

    // GUI variables
    // Player varbiables
    private TextView lblcharName;
    private TextView lblcharHealth;
    private TextView lblcharAttack;
    private TextView lblcharArmor;
    private TextView lblcharDefence;
    private TextView charHealth;
    private TextView charAttack;
    private TextView charArmor;
    private TextView charDefence;
    private ImageView charPicture;
    private ImageView enemyPicture;
    private Button btnAttack;

    // Enemy variables
    private TextView lblenemyName;
    private TextView lblenemyHealth;
    private TextView lblenemyAttack;
    private TextView lblenemyArmor;
    private TextView lblenemyDefence;
    private TextView enemyName;
    private TextView enemyHealth;
    private TextView enemyAttack;
    private TextView enemyArmor;
    private TextView enemyDefence;

    // Variables
    private Intent retrieveFrom;
    private Intent passTo;
    private Player player;
    private String playerName;
    private int playerPicture;
    private Random random;

    // Controller variables
    private EnemyController enemyController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat_screen);

        random = new Random();
        enemyController = new EnemyController();
        setupPlayerInformation();
        setupGuiComponents();
        setupEnemyInformation();
        getRandomEnemy();
    }

    // Retrieving player information
    public void setupPlayerInformation(){
        lblcharName = (TextView)findViewById(R.id.lblcsPlayerName);
        charPicture = (ImageView)findViewById(R.id.csCharPicture);
        // Retrieving player information
        retrieveFrom = getIntent();
        // Retrieving player name and picture
        playerName = retrieveFrom.getStringExtra("csName");
        playerPicture = retrieveFrom.getIntExtra("csPicture", 0);

        charPicture.setImageResource(playerPicture);
        lblcharName.setText(playerName);
        player = new Player(playerName, Integer.valueOf(playerPicture));
    }

    // Retrieving enemy information
    public void setupEnemyInformation(){
        enemyController.createEnemies();
    }

    // Updates the player after each kill so the player does not have to save the game manually
    public void updatePlayerInformation(){
        passTo.putExtra("playerName", playerName);
        passTo.putExtra("getAttack", player.getAttack());
        passTo.putExtra("getHealth", player.getHealth());
        passTo.putExtra("getArmor", player.getArmor());
        passTo.putExtra("getLevel", player.getLevel());
        passTo.putExtra("getMoney", player.getMoney());
        passTo.putExtra("getExperience", player.getExperience());
    }

    // Assign variables to GUI components
    public void setupGuiComponents(){
        btnAttack = (Button)findViewById(R.id.btnAttack);

        // Player GUI components
        lblcharName = (TextView)findViewById(R.id.lblcsPlayerName);
        lblcharHealth = (TextView)findViewById(R.id.lblcsCharHealthShow);
        lblcharAttack = (TextView)findViewById(R.id.lblcsCharAttackShow);
        lblcharArmor = (TextView)findViewById(R.id.lblcsCharArmorShow);
        lblcharDefence = (TextView)findViewById(R.id.lblcsCharDefenceShow);
        charHealth = (TextView)findViewById(R.id.lblcsCharHealth);
        charAttack = (TextView)findViewById(R.id.lblcsCharAttack);
        charArmor = (TextView)findViewById(R.id.lblcsCharArmor);
        charDefence = (TextView)findViewById(R.id.lblcsCharDefence);

        // Enemy GUI components
        lblenemyName = (TextView)findViewById(R.id.lblcsEnemyName);
        lblenemyHealth = (TextView)findViewById(R.id.lblcsEnemyHealthShow);
        lblenemyAttack = (TextView)findViewById(R.id.lblcsEnemyAttackShow);
        lblenemyArmor = (TextView)findViewById(R.id.lblcsEnemyArmorShow);
        lblenemyDefence = (TextView)findViewById(R.id.lblcsEnemyDefenceShow);
        enemyHealth = (TextView)findViewById(R.id.lblcsEnemyHealth);
        enemyAttack = (TextView)findViewById(R.id.lblcsEnemyAttack);
        enemyArmor = (TextView)findViewById(R.id.lblcsEnemyArmor);
        enemyDefence = (TextView)findViewById(R.id.lblcsEnemyDefence);
        enemyPicture = (ImageView)findViewById(R.id.csEnemyPicture);

        // Assign player values to variables
        lblcharHealth.setText("hp: ");
        lblcharAttack.setText("att: ");
        lblcharArmor.setText("arm: ");
        lblcharDefence.setText("def: ");
        btnAttack.setText("attack");
        charHealth.setText(String.valueOf(player.getHealth()));
        charAttack.setText(String.valueOf(player.getAttack()));
        charArmor.setText(String.valueOf(player.getArmor()));
        charDefence.setText(String.valueOf(player.getDefence()));
    }

    public Enemy getRandomEnemy(){
        setupGuiComponents();

        int enemy = random.nextInt(enemyController.createEnemies().size());
        Enemy randomEnemy = enemyController.createEnemies().get(enemy);

        // Assign enemy values to variables
        lblenemyName.setText(randomEnemy.getName());
        lblenemyHealth.setText("hp: ");
        lblenemyAttack.setText("att: ");
        lblenemyArmor.setText("arm: ");
        lblenemyDefence.setText("def: ");
        enemyHealth.setText(String.valueOf(randomEnemy.getHealth()));
        enemyAttack.setText(String.valueOf(randomEnemy.getAttack()));
        enemyArmor.setText(String.valueOf(randomEnemy.getArmor()));
        enemyDefence.setText(String.valueOf(randomEnemy.getDefence()));
        enemyPicture.setImageResource(Integer.valueOf(randomEnemy.getSprite()));

        return randomEnemy;
    }
}
