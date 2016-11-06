package maximedelange.mygame.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import maximedelange.mygame.R;

public class ArmoryScreen extends AppCompatActivity {

    // GUI components variables
    private TextView attack;
    private TextView armor;
    private TextView defence;
    private ImageView characterPicture;
    private ImageView swordlvl1;
    private ImageView swordlvl2;
    private ImageView swordlvl3;
    private ImageView shieldlvl1;
    private ImageView shieldlvl2;
    private ImageView shieldlvl3;
    private ImageView armorredlvl1;
    private ImageView armorredlvl2;
    private ImageView armorredlvl3;
    private ImageView armorbluelvl1;
    private ImageView armorbluelvl2;
    private ImageView armorbluelvl3;

    // Variables
    private String hasPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armory_screen);

        setupArmoryInformation();
        setupCharacterInformation();
    }

    public void setupArmoryInformation(){
        // Retrieving information about character picture
        Intent retrieveFrom = getIntent();
        hasPicture = retrieveFrom.getStringExtra("characterPicture");

        // Create GUI variables
        attack = (TextView)findViewById(R.id.lblAttackShow);
        armor = (TextView)findViewById(R.id.lblArmorShow);
        defence = (TextView)findViewById(R.id.lblDefenceShow);
        swordlvl1 = (ImageView)findViewById(R.id.asSwordlvl1);
        swordlvl2 = (ImageView)findViewById(R.id.asSwordlvl2);
        swordlvl3 = (ImageView)findViewById(R.id.asSwordlvl3);
        shieldlvl1 = (ImageView)findViewById(R.id.asShield1);
        shieldlvl2 = (ImageView)findViewById(R.id.asShield2);
        shieldlvl3 = (ImageView)findViewById(R.id.asShield3);
        // If the chosen character is character1
        armorbluelvl1 = (ImageView)findViewById(R.id.asArmor1);
        armorbluelvl2 = (ImageView)findViewById(R.id.asArmor2);
        armorbluelvl3 = (ImageView)findViewById(R.id.asArmor3);

        // If the chosen character is character2
        armorredlvl1 = (ImageView)findViewById(R.id.asArmor1);
        armorredlvl2 = (ImageView)findViewById(R.id.asArmor2);
        armorredlvl3 = (ImageView)findViewById(R.id.asArmor3);

        // Assign values to the GUI variables
        attack.setText("attack");
        attack.setTextSize(16);
        armor.setText("armor");
        armor.setTextSize(16);
        defence.setText("defence");
        defence.setTextSize(16);
        swordlvl1.setImageResource(R.mipmap.swordlvl1);
        swordlvl2.setImageResource(R.mipmap.swordlvl2);
        swordlvl3.setImageResource(R.mipmap.swordlvl3);
        shieldlvl1.setImageResource(R.mipmap.shieldlvl1);
        shieldlvl2.setImageResource(R.mipmap.shieldlvl2);
        shieldlvl3.setImageResource(R.mipmap.shieldlvl3);

        if(hasPicture.equals("a")){
            // If the chosen character is character2
            armorredlvl1.setImageResource(R.mipmap.armorredlvl1);
            armorredlvl2.setImageResource(R.mipmap.armorredlvl2);
            armorredlvl3.setImageResource(R.mipmap.armorredlvl3);
        }else{
            armorbluelvl1.setImageResource(R.mipmap.armorbluelvl1);
            armorbluelvl2.setImageResource(R.mipmap.armorbluelvl2);
            armorbluelvl3.setImageResource(R.mipmap.armorbluelvl3);
        }


    }

    public void setupCharacterInformation(){
        // Retrieving information from character screen
        characterPicture = (ImageView)findViewById(R.id.asCharacterPicture);
        Intent retrieveFrom = getIntent();
        hasPicture = retrieveFrom.getStringExtra("characterPicture");

        // If there is a profile picture available, then the correct profile picture
        // is being stored and send to the character screen.
        if(hasPicture != null){
            if(hasPicture.equals("a")) {
                characterPicture.setImageResource(R.mipmap.character2);
            }
            else{
                characterPicture.setImageResource(R.mipmap.character1);
            }
        }else{
            System.out.println("Profile picture is: " + hasPicture);
        }
    }
}