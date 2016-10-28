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
        setupPlayerInformation();
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
        final TextView hasUserName;hasUserName = (TextView)findViewById(R.id.lblUserName);
        ImageButton btnGotoScreen = (ImageButton)findViewById(R.id.btnCharacter);
        btnGotoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Making a new intent. Intent goes to the character screen
                Intent intent = new Intent(v.getContext(), CharacterScreen.class);
                String hasName = hasUserName.getText().toString();

                // Retrieving information from character screen
                Intent intent2 = getIntent();
                hasProfilePicture = intent2.getStringExtra("profilePic");

                // If there is a profile picture available, then the correct profile picture
                // is being stored and send to the character screen.
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

                // Pass the name value to the character screen
                intent.putExtra("hasName", hasName);
                // Starting the activity
                startActivity(intent);
            }
        });
    }

    // Go to Armory screen
    public void gotoArmory(){
        ImageButton btnGotoScreen = (ImageButton)findViewById(R.id.btnArmory);
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
        ImageButton btnGotoScreen = (ImageButton)findViewById(R.id.btnCombat);
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
        ImageButton btnGotoScreen = (ImageButton)findViewById(R.id.btnSettings);
        btnGotoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SettingsScreen.class);
                startActivity(intent);
            }
        });
    }

    // Retrieving the data for the character. It retrieves the picture from the character
    // screen and it sets up the player information, such as name.
    public void setupPlayerInformation(){
        ImageView characterPicture = (ImageView)findViewById(R.id.gsCharacterPicture);
        int image = getIntent().getIntExtra("characterPicture", R.mipmap.ic_launcher);
        characterPicture.setImageResource(image);

        // Retrieving the content from the character screen
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

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
}
