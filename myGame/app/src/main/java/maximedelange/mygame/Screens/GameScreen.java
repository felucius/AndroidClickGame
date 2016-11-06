package maximedelange.mygame.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import maximedelange.mygame.R;

public class GameScreen extends AppCompatActivity {

    // GUI components variables

    private TextView character;
    private TextView armory;
    private TextView combat;
    private TextView settings;
    private TextView characterName;
    private ImageButton btnGotoScreen;
    private ImageView characterPicture;

    // Variables
    private String hasProfilePicture;
    private String name;

    // Intents
    private Intent passTo;
    private Intent retrieveFrom;

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
        setupPlayerInformation();
    }

    public void appSetupInformation(){
        // Create textview variables
        character = (TextView)findViewById(R.id.lblCharacter);
        armory = (TextView)findViewById(R.id.lblArmory);
        combat = (TextView)findViewById(R.id.lblCombat);
        settings = (TextView)findViewById(R.id.lblSettings);

        // Assign values to variables
        character.setText("character");
        armory.setText("armory");
        combat.setText("combat");
        settings.setText("settings");
    }

    // Go to Character screen
    public void gotoCharacter(){
        final TextView hasUserName;hasUserName = (TextView)findViewById(R.id.lblUserName);
        ImageButton btnGotoScreen = (ImageButton)findViewById(R.id.btnCharacter);
        btnGotoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Making a new intent. Intent goes to the character screen
                passTo = new Intent(v.getContext(), CharacterScreen.class);
                String hasName = hasUserName.getText().toString();

                // Retrieving information from character screen
                retrieveFrom = getIntent();
                hasProfilePicture = retrieveFrom.getStringExtra("profilePic");

                // If there is a profile picture available, then the correct profile picture
                // is being stored and send to the character screen.
                if(hasProfilePicture != null){

                    if(hasProfilePicture.equals("a")) {
                        passTo.putExtra("hasCharacterPicture", R.mipmap.character2);
                    }
                    else{
                        passTo.putExtra("hasCharacterPicture", R.mipmap.character1);
                    }
                }else{
                    System.out.println("Profile picture is: " + hasProfilePicture);
                }

                // Pass the name value to the character screen
                passTo.putExtra("hasName", hasName);
                // Starting the activity
                startActivity(passTo);
            }
        });
    }

    // Go to Armory screen
    public void gotoArmory(){
        btnGotoScreen = (ImageButton)findViewById(R.id.btnArmory);
        passTo = getIntent();
        name = passTo.getStringExtra("name");
        if(name != null){
            btnGotoScreen.setVisibility(View.VISIBLE);
            armory.setVisibility(View.VISIBLE);
            btnGotoScreen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    retrieveFrom = getIntent();
                    hasProfilePicture = retrieveFrom.getStringExtra("profilePic");

                    Intent intent = new Intent(v.getContext(), ArmoryScreen.class);
                    intent.putExtra("characterPicture", hasProfilePicture);
                    startActivity(intent);
                }
            });
        }else{
            armory.setVisibility(View.INVISIBLE);
            btnGotoScreen.setVisibility(View.INVISIBLE);
        }

    }

    // Go to Combat screen
    public void gotoCombat(){
        btnGotoScreen = (ImageButton)findViewById(R.id.btnCombat);
        passTo = getIntent();
        name = passTo.getStringExtra("name");
        if(name != null){
            btnGotoScreen.setVisibility(View.VISIBLE);
            combat.setVisibility(View.VISIBLE);
            btnGotoScreen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), CombatScreen.class);
                    startActivity(intent);
                }
            });
        }
        else{
            combat.setVisibility(View.INVISIBLE);
            btnGotoScreen.setVisibility(View.INVISIBLE);
        }
    }

    // Go to Settings screen
    public void gotoSettings(){
        btnGotoScreen = (ImageButton)findViewById(R.id.btnSettings);
        passTo = getIntent();
        name = passTo.getStringExtra("name");
        if(name != null){
            btnGotoScreen.setVisibility(View.VISIBLE);
            settings.setVisibility(View.VISIBLE);
            btnGotoScreen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), SettingsScreen.class);
                    startActivity(intent);
                }
            });
        }
        else{
            settings.setVisibility(View.INVISIBLE);
            btnGotoScreen.setVisibility(View.INVISIBLE);
        }

    }

    // Retrieving the data for the character. It retrieves the picture from the character
    // screen and it sets up the player information, such as name.
    public void setupPlayerInformation(){
        // If name and picture is not available a.k.a. character is not created. Then the image will
        // not be displayed
        characterPicture = (ImageView)findViewById(R.id.gsCharacterPicture);
        int image = getIntent().getIntExtra("characterPicture", R.mipmap.ic_launcher);
        if(image != R.mipmap.ic_launcher){
            characterPicture.setVisibility(View.VISIBLE);
            characterPicture.setImageResource(image);
        }
        else{
            characterPicture.setVisibility(View.INVISIBLE);
        }

        // Retrieving the content from the character screen
        passTo = getIntent();
        name = passTo.getStringExtra("name");

        // Create textview variables
        characterName = (TextView)findViewById(R.id.lblUserName);

        // Assign values to variables
        if(name == null){
            // If name is not available a.k.a. character is not created. Then the name field will
            // not be displayed
            characterName.setVisibility(View.INVISIBLE);
            characterName.setTextSize(20);
            characterName.setText("...");
        }
        else{
            characterName.setVisibility(View.VISIBLE);
            characterName.setTextSize(20);
            characterName.setText(name);
        }
    }
}
