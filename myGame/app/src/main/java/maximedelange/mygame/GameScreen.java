package maximedelange.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

import maximedelange.mygame.Domain.Player;

public class GameScreen extends AppCompatActivity {

    private Player playerstats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        getUserName();
        playerSetupInformation();
        appSetupInformation();
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
}
