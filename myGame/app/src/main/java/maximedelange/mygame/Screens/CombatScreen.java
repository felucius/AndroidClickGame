package maximedelange.mygame.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import maximedelange.mygame.Controller.EnemyController;
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
    private Button btnAttack;

    // Enemy variables
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

    // Controller variables
    private EnemyController enemyController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat_screen);

        enemyController = new EnemyController();
        setupPlayerInformation();
        setupGuiComponents();
        setupEnemyInformation();
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
        lblcharName = (TextView)findViewById(R.id.lblcsPlayerName);
        lblcharHealth = (TextView)findViewById(R.id.lblcsCharHealthShow);
        lblcharAttack = (TextView)findViewById(R.id.lblcsCharAttackShow);
        lblcharArmor = (TextView)findViewById(R.id.lblcsCharArmorShow);
        lblcharDefence = (TextView)findViewById(R.id.lblcsCharDefenceShow);
        charHealth = (TextView)findViewById(R.id.lblcsCharHealth);
        charAttack = (TextView)findViewById(R.id.lblcsCharAttack);
        charArmor = (TextView)findViewById(R.id.lblcsCharArmor);
        charDefence = (TextView)findViewById(R.id.lblcsCharDefence);

        // Assign values to variables
        //lblcharName.setText(playerName);
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
}
