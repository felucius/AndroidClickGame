package maximedelange.mygame.Screens;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import maximedelange.mygame.Domain.Player;
import maximedelange.mygame.R;

public class GameScreen extends AppCompatActivity {

    private Player playerstats;
    private ImageButton btnGotoScreen;
    private TextView hasUserName;
    private String hasProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //playerSetupInformation();
        appSetupInformation();

        // Game screens
        gotoCharacter();
        gotoArmory();
        gotoCombat();
        gotoSettings();

        // Retrieving info from character screen
        collectCharacterData();
    }

    public void playerSetupInformation(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        playerstats = new Player(name, null);
        // Create textview variables
        TextView characterName = (TextView)findViewById(R.id.lblUserName);

        // Assign values to variables
        if(name == null){
            characterName.setTextSize(20);
            characterName.setText("...");
        }
        else{
            characterName.setTextSize(20);
            characterName.setText(name);
        }
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
        hasUserName = (TextView)findViewById(R.id.lblUserName);
        btnGotoScreen = (ImageButton)findViewById(R.id.btnCharacter);
        btnGotoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CharacterScreen.class);
                String hasName = hasUserName.getText().toString();

                // PROBLEEM MET PROFIEL FOTO LADEN
                Intent intent2 = getIntent();
                hasProfilePicture = intent2.getStringExtra("profilePic");

                if(hasProfilePicture != null){

                    if(hasProfilePicture.equals("a")) {
                        intent.putExtra("hasCharacterPicture", R.mipmap.character2);
                    }
                    else{
                        intent.putExtra("hasCharacterPicture", R.mipmap.character1);
                    }
                }else{
                    System.out.println("Profile picture is: " + hasProfilePicture);
                }

                intent.putExtra("hasName", hasName);
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

    public void collectCharacterData(){
        ImageView characterPicture = (ImageView)findViewById(R.id.gsCharacterPicture);
        int image = getIntent().getIntExtra("characterPicture", R.mipmap.ic_launcher);
        characterPicture.setImageResource(image);

        playerSetupInformation();
    }
}
