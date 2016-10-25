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
import android.widget.Switch;
import android.widget.TextView;

import maximedelange.mygame.R;

public class CharacterScreen extends AppCompatActivity {

    private boolean isSwitching;
    private ImageView characterImage;
    private Button btnSave;
    private EditText characterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);
        characterImage = (ImageView)findViewById(R.id.characterPicture);
        characterImage.setImageResource(R.mipmap.character1);

        setupGameScreen();
        changeCharacter();
        saveInformation();
    }

    public void setupGameScreen(){
        TextView characterText = (TextView)findViewById(R.id.lblChooseCharacter);
        TextView changeCharacter = (TextView)findViewById(R.id.lblSwitchCharacter);
        characterText.setText("choose character");
        changeCharacter.setText("switch character");
    }

    public void changeCharacter(){
        Switch switchChar = (Switch)findViewById(R.id.switchCharacter);
        characterImage = (ImageView)findViewById(R.id.characterPicture);
        switchChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicked switch");
                if(isSwitching){
                    characterImage.setImageResource(R.mipmap.character1);
                    isSwitching = false;
                }
                else{
                    characterImage.setImageResource(R.mipmap.character2);
                    isSwitching = true;
                }
            }
        });
    }

    public void saveInformation(){
        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GameScreen.class);
                if(isSwitching){
                    intent.putExtra("characterPicture", R.mipmap.character2);
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
                    intent.putExtra("characterPicture", R.mipmap.character1);
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
    }
}
