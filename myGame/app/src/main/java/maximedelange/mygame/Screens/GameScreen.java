package maximedelange.mygame.Screens;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import maximedelange.mygame.Domain.Player;
import maximedelange.mygame.R;

public class GameScreen extends AppCompatActivity {

    private Player playerstats;
    private ImageButton btnGotoScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        getUserName();
        playerSetupInformation();
        appSetupInformation();

        // Game screens
        gotoCharacter();
        gotoArmory();
        gotoCombat();
        gotoSettings();
    }

    public void getUserName(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView displayName = (TextView)findViewById(R.id.lblUserName);
        displayName.setTextSize(26);
        displayName.setText(name);
    }

    public void playerSetupInformation(){
        playerstats = new Player("Test", 3, 1, 100, null);
        // Create textview variables
        TextView levelShow = (TextView)findViewById(R.id.lblLevelShow);
        TextView level = (TextView)findViewById(R.id.lblLevel);
        TextView moneyShow = (TextView)findViewById(R.id.lblMoneyShow);
        TextView money = (TextView)findViewById(R.id.lblMoney);

        // Assign values to variables
        levelShow.setText("level:");
        level.setText(String.valueOf(playerstats.getLevel()));
        moneyShow.setText("money:");
        money.setText(String.valueOf(playerstats.getMoney()));
    }

    public void appSetupInformation(){
        // Create textview variables
        TextView character = (TextView)findViewById(R.id.lblCharacter);
        TextView armory = (TextView)findViewById(R.id.lblArmory);
        TextView combat = (TextView)findViewById(R.id.lblCombat);
        TextView settings = (TextView)findViewById(R.id.lblSettings);

        // Assign values to variables
        character.setText("character");
        armory.setText("armory");
        combat.setText("combat");
        settings.setText("settings");
    }

    // Go to Character screen
    public void gotoCharacter(){
        btnGotoScreen = (ImageButton)findViewById(R.id.btnCharacter);
        btnGotoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CharacterScreen.class);
                startActivity(intent);
            }
        });
    }

    // Go to Armory screen
    public void gotoArmory(){
        btnGotoScreen = (ImageButton)findViewById(R.id.btnArmory);
        btnGotoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ArmoryScreen.class);
                startActivity(intent);
            }
        });
    }

    // Go to Combat screen
    public void gotoCombat(){
        btnGotoScreen = (ImageButton)findViewById(R.id.btnCombat);
        btnGotoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CombatScreen.class);
                startActivity(intent);
            }
        });
    }

    // Go to Settings screen
    public void gotoSettings(){
        btnGotoScreen = (ImageButton)findViewById(R.id.btnSettings);
        btnGotoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SettingsScreen.class);
                startActivity(intent);
            }
        });
    }
}
