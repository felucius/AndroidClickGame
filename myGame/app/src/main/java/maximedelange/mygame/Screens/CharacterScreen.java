package maximedelange.mygame.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import maximedelange.mygame.Domain.Player;
import maximedelange.mygame.R;

public class CharacterScreen extends AppCompatActivity {

    private boolean isSwitching;
    private boolean isDisabled = true;
    private ImageView characterImage;
    private Button btnSave;
    private EditText characterName;
    private Button leftChoice;
    private Button rightChoice;
    private Player player;
    TextView changeCharacter;
    TextView characterText;
    private String profilePictureValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);
        characterImage = (ImageView)findViewById(R.id.characterPicture);
        characterImage.setImageResource(R.mipmap.character1);

        setupGameScreen();
        changeCharacter();

        Intent intent = getIntent();
        String hasOldName = intent.getStringExtra("hasName");

        if(hasOldName.equals("...")){
            isDisabled = true;
        }
        else{
            isDisabled = false;
        }

        saveInformation();
        setupCharacterInformation(hasOldName);
    }

    public void setupGameScreen(){
        characterText = (TextView)findViewById(R.id.lblChooseCharacter);
        changeCharacter = (TextView)findViewById(R.id.lblSwitchCharacter);
        characterText.setText("choose character");
        changeCharacter.setText("player name:");
    }

    public void changeCharacter(){
        leftChoice = (Button)findViewById(R.id.btnLeft);
        leftChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characterImage.setImageResource(R.mipmap.character1);
                isSwitching = false;
            }
        });

        rightChoice = (Button)findViewById(R.id.btnRight);
        rightChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characterImage.setImageResource(R.mipmap.character2);
                isSwitching = true;
            }
        });
    }

    public void setupCharacterInformation(String name){
        player = new Player(name, null);

        // Create textview variables
        TextView levelShow = (TextView)findViewById(R.id.lblchLevelShow);
        TextView level = (TextView)findViewById(R.id.lblchLevel);
        TextView moneyShow = (TextView)findViewById(R.id.lblchMoneyShow);
        TextView money = (TextView)findViewById(R.id.lblchMoney);
        //TextView characterName = (TextView)findViewById(R.id.lblchUserName);
        TextView attackShow = (TextView)findViewById(R.id.lblchAttackShow);
        TextView attack = (TextView)findViewById(R.id.lblchAttack);
        TextView defenceShow = (TextView)findViewById(R.id.lblchDefenceShow);
        TextView defence = (TextView)findViewById(R.id.lblchDefence);
        TextView healthShow = (TextView)findViewById(R.id.lblchHealthShow);
        TextView health = (TextView)findViewById(R.id.lblchHealth);
        TextView experiencebarShow = (TextView)findViewById(R.id.lblchExperienceShow);
        ProgressBar progressExperience = (ProgressBar)findViewById(R.id.pbExperience);
        ImageView characterPicture = (ImageView)findViewById(R.id.characterPicture);
        changeCharacter = (TextView)findViewById(R.id.lblSwitchCharacter);
        characterName = (EditText)findViewById(R.id.editName);
        characterText = (TextView)findViewById(R.id.lblChooseCharacter);

        if(name.equals("...")){
            levelShow.setVisibility(View.INVISIBLE);
            level.setVisibility(View.INVISIBLE);
            moneyShow.setVisibility(View.INVISIBLE);
            money.setVisibility(View.INVISIBLE);
            attackShow.setVisibility(View.INVISIBLE);
            attack.setVisibility(View.INVISIBLE);
            defenceShow.setVisibility(View.INVISIBLE);
            defence.setVisibility(View.INVISIBLE);
            healthShow.setVisibility(View.INVISIBLE);
            health.setVisibility(View.INVISIBLE);
            progressExperience.setVisibility(View.INVISIBLE);
            experiencebarShow.setVisibility(View.INVISIBLE);


        }
        else {
            levelShow.setVisibility(View.VISIBLE);
            level.setVisibility(View.VISIBLE);
            moneyShow.setVisibility(View.VISIBLE);
            money.setVisibility(View.VISIBLE);
            attackShow.setVisibility(View.VISIBLE);
            attack.setVisibility(View.VISIBLE);
            defenceShow.setVisibility(View.VISIBLE);
            defence.setVisibility(View.VISIBLE);
            healthShow.setVisibility(View.VISIBLE);
            health.setVisibility(View.VISIBLE);
            progressExperience.setVisibility(View.VISIBLE);
            experiencebarShow.setVisibility(View.VISIBLE);
            characterName.setVisibility(View.INVISIBLE);
            leftChoice.setVisibility(View.INVISIBLE);
            rightChoice.setVisibility(View.INVISIBLE);
            characterText.setVisibility(View.INVISIBLE);

            int image = getIntent().getIntExtra("hasCharacterPicture", R.mipmap.ic_launcher);
            characterPicture.setImageResource(image);

            System.out.println("Image value putextra: " + image);
            System.out.println("Image value char1:" + R.mipmap.character1);
            System.out.println("Image value char2:" + R.mipmap.character2);
            System.out.println("Image value ic_launch:" + R.mipmap.ic_launcher);

            levelShow.setText("level:");
            level.setText(String.valueOf(player.getLevel()));
            moneyShow.setText("money:");
            money.setText(String.valueOf(player.getMoney()));
            attackShow.setText("attack:");
            attack.setText(String.valueOf(player.getAttack()));
            defenceShow.setText("defence:");
            defence.setText(String.valueOf(player.getDefence()));
            healthShow.setText("health:");
            health.setText(String.valueOf(player.getHealth()));
            changeCharacter.setText(name);
            progressExperience.setProgress(10);
            experiencebarShow.setText("experience:");

            // Changing text size
            levelShow.setTextSize(16);
            level.setTextSize(16);
            moneyShow.setTextSize(16);
            money.setTextSize(16);
            attackShow.setTextSize(16);
            attack.setTextSize(16);
            defenceShow.setTextSize(16);
            defence.setTextSize(16);
            healthShow.setTextSize(16);
            health.setTextSize(16);
            experiencebarShow.setTextSize(16);
            changeCharacter.setTextSize(16);
        }
    }

    public void saveInformation(){
        btnSave = (Button)findViewById(R.id.btnSave);
        if(isDisabled){
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), GameScreen.class);
                    if(isSwitching){
                        profilePictureValue = "a";
                        intent.putExtra("characterPicture", R.mipmap.character2);
                        intent.putExtra("profilePic", profilePictureValue);
                        characterName = (EditText)findViewById(R.id.editName);
                        String newName = characterName.getText().toString();
                        if(characterName.getText().toString().equals("")){
                            characterName.setText("Enter a name");
                        }
                        else if (characterName.getText().toString().equals("Enter a name")){
                            characterName.setText("Enter a name");
                        }
                        else{
                            intent.putExtra("name", newName);
                            startActivity(intent);
                        }
                    }
                    else{
                        profilePictureValue = "b";
                        intent.putExtra("characterPicture", R.mipmap.character1);
                        intent.putExtra("profilePic", profilePictureValue);
                        characterName = (EditText)findViewById(R.id.editName);
                        String newName = characterName.getText().toString();
                        if(characterName.getText().toString().equals("")){
                            characterName.setText("Enter a name");
                        }
                        else if (characterName.getText().toString().equals("Enter a name")){
                            characterName.setText("Enter a name");
                        }
                        else{
                            intent.putExtra("name", newName);
                            startActivity(intent);
                        }
                    }
                }
            });
            isDisabled = false;

        }else{
            btnSave.setVisibility(View.INVISIBLE);
        }
    }
}
