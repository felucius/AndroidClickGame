package maximedelange.mygame.Screens;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import maximedelange.mygame.Domain.Player;
import maximedelange.mygame.R;

public class ArmoryScreen extends AppCompatActivity {

    // GUI components variables
    private TextView attack;
    private TextView armor;
    private TextView defence;
    private TextView currentAttack;
    private TextView currentArmor;
    private TextView currentDefence;
    private TextView currentStats;
    private TextView newStats;
    private TextView newAttack;
    private TextView newArmor;
    private TextView newDefence;
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
    private Button btnPurchaseUpgrade;

    // Variables
    private String hasPicture;
    private String hasName;
    private Player player;
    private boolean upgradePurchased = false;
    private boolean isEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armory_screen);
        btnPurchaseUpgrade = (Button)findViewById(R.id.btnPurchase);
        btnPurchaseUpgrade.setVisibility(View.INVISIBLE);

        setupArmoryInformation();
        setupCharacterInformation();
        checkNewItemForCharacter();
        purchaseUpgrade();
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
        Intent retrieveFrom = getIntent();
        hasName = retrieveFrom.getStringExtra("name");
        // Create player object with created name
        player = new Player(hasName, null);

        loadStatisticsGuiComponents();

        characterPicture = (ImageView)findViewById(R.id.asCharacterPicture);
        hasPicture = retrieveFrom.getStringExtra("characterPicture");

        // If there is a profile picture available, then the correct profile picture
        // is being stored and send to the character screen.
        if(hasPicture != null){
            if(hasPicture.equals("a")) {
                characterPicture.setImageResource(R.mipmap.character2);
                checkUpgradesStatus();
            }
            else{
                characterPicture.setImageResource(R.mipmap.character1);
                checkUpgradesStatus();
            }
        }else{
            System.out.println("Profile picture is: " + hasPicture);
        }
    }

    public void checkUpgradesStatus(){
        Intent retrieveFrom = getIntent();
        hasPicture = retrieveFrom.getStringExtra("characterPicture");
        hasName = retrieveFrom.getStringExtra("name");

        // Temporary position of variable
        loadItemPictures();

        if(hasPicture.equals("a")){
            player = new Player(hasName, null);
            if(player.getAmountOfUpgrades() > 1){

            }
            else{
                loadItemPictures();
            }
        }
        else{
            // DO SOMETHING
        }
    }

    public void checkNewItemForCharacter(){
        // Retrieve character picture information
        Intent retrieveFrom = getIntent();
        hasPicture = retrieveFrom.getStringExtra("characterPicture");
        // Assign variable value to the ImageView
        characterPicture = (ImageView)findViewById(R.id.asCharacterPicture);

        // Shows the sword on the character
        swordlvl1 = (ImageView)findViewById(R.id.asSwordlvl1);
        swordlvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!upgradePurchased){
                    btnPurchaseUpgrade = (Button)findViewById(R.id.btnPurchase);
                    isEnabled = true;
                    if(hasPicture.equals("a")){
                        characterPicture.setImageResource(R.mipmap.level1swordchar2);
                        loadStatisticsGuiComponents();
                        newAttack.setText("att: " + String.valueOf(player.getAttack() + 2));
                        if(isEnabled){
                            btnPurchaseUpgrade.setVisibility(View.VISIBLE);
                        }
                    }
                    else{
                        characterPicture.setImageResource(R.mipmap.level1sword);
                        loadStatisticsGuiComponents();
                        newAttack.setText("att: " + String.valueOf(player.getAttack() + 2));
                        if(isEnabled){
                            btnPurchaseUpgrade.setVisibility(View.VISIBLE);
                            isEnabled = false;
                        }
                    }
                    shieldlvl1.setEnabled(false);
                    armorredlvl1.setEnabled(false);
                    upgradePurchased = true;
                }
                else{
                    if(hasPicture.equals("a")){
                        btnPurchaseUpgrade = (Button)findViewById(R.id.btnPurchase);
                        isEnabled = true;
                        loadStatisticsGuiComponents();
                        characterPicture.setImageResource(R.mipmap.character2);
                        if(isEnabled){
                            btnPurchaseUpgrade.setVisibility(View.VISIBLE);
                            isEnabled = false;
                        }
                    }
                    else{
                        loadStatisticsGuiComponents();
                        characterPicture.setImageResource(R.mipmap.character1);
                    }
                    if(!isEnabled){
                        btnPurchaseUpgrade.setVisibility(View.INVISIBLE);
                    }
                    shieldlvl1.setEnabled(true);
                    armorredlvl1.setEnabled(true);
                    upgradePurchased = false;
                }
            }
        });

        // Shows the armor on the character.
        armorbluelvl1 = (ImageView)findViewById(R.id.asArmor1);
        armorbluelvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!upgradePurchased){
                    btnPurchaseUpgrade = (Button)findViewById(R.id.btnPurchase);
                    isEnabled = true;
                    if(hasPicture.equals("a")){
                        characterPicture.setImageResource(R.mipmap.level1redarmorequipped);
                        loadStatisticsGuiComponents();
                        newArmor.setText("arm: " + String.valueOf(player.getArmor() + 2));
                        if(isEnabled){
                            btnPurchaseUpgrade.setVisibility(View.VISIBLE);
                            isEnabled = false;
                        }
                    }
                    else{
                        characterPicture.setImageResource(R.mipmap.level1armorequipped);
                        loadStatisticsGuiComponents();
                        newArmor.setText("arm: " + String.valueOf(player.getArmor() + 2));
                        if(isEnabled){
                            btnPurchaseUpgrade.setVisibility(View.VISIBLE);
                            isEnabled = false;
                        }
                    }
                    swordlvl1.setEnabled(false);
                    shieldlvl1.setEnabled(false);
                    upgradePurchased = true;
                }
                else{
                    if(hasPicture.equals("a")){
                        characterPicture.setImageResource(R.mipmap.character2);
                        loadStatisticsGuiComponents();
                    }
                    else{
                        characterPicture.setImageResource(R.mipmap.character1);
                        loadStatisticsGuiComponents();
                    }
                    if(!isEnabled){
                        btnPurchaseUpgrade.setVisibility(View.INVISIBLE);
                    }
                    swordlvl1.setEnabled(true);
                    shieldlvl1.setEnabled(true);
                    upgradePurchased = false;
                }
            }
        });

        // Shows the shield on the character
        shieldlvl1 = (ImageView)findViewById(R.id.asShield1);
        shieldlvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!upgradePurchased){
                    btnPurchaseUpgrade = (Button)findViewById(R.id.btnPurchase);
                    isEnabled = true;
                    if(hasPicture.equals("a")){
                        characterPicture.setImageResource(R.mipmap.level1shieldchar2);
                        loadStatisticsGuiComponents();
                        newDefence.setText("def: " + String.valueOf(player.getDefence() + 2));
                        if(isEnabled){
                            btnPurchaseUpgrade.setVisibility(View.VISIBLE);
                            isEnabled = false;
                        }
                    }
                    else{
                        characterPicture.setImageResource(R.mipmap.level1shield);
                        loadStatisticsGuiComponents();
                        newDefence.setText("def: " + String.valueOf(player.getDefence() + 2));
                        if(isEnabled){
                            btnPurchaseUpgrade.setVisibility(View.VISIBLE);
                            isEnabled = false;
                        }
                    }
                    swordlvl1.setEnabled(false);
                    armorredlvl1.setEnabled(false);
                    upgradePurchased = true;
                }
                else{
                    if(hasPicture.equals("a")){
                        characterPicture.setImageResource(R.mipmap.character2);
                        loadStatisticsGuiComponents();
                    }
                    else{
                        characterPicture.setImageResource(R.mipmap.character1);
                        loadStatisticsGuiComponents();
                    }
                    if(!isEnabled){
                        btnPurchaseUpgrade.setVisibility(View.INVISIBLE);
                    }
                    swordlvl1.setEnabled(true);
                    armorredlvl1.setEnabled(true);
                    upgradePurchased = false;
                }
            }
        });
    }

    public void loadItemPictures(){
        // Retrieve character picture information
        Intent retrieveFrom = getIntent();
        hasPicture = retrieveFrom.getStringExtra("characterPicture");

        // Assign variables to GUI components
        swordlvl2 = (ImageView)findViewById(R.id.asSwordlvl2);
        swordlvl3 = (ImageView)findViewById(R.id.asSwordlvl3);
        armorbluelvl2 = (ImageView)findViewById(R.id.asArmor2);
        armorbluelvl3 = (ImageView)findViewById(R.id.asArmor3);
        shieldlvl2 = (ImageView)findViewById(R.id.asShield2);
        shieldlvl3 = (ImageView)findViewById(R.id.asShield3);

        // Assign variables to imageviews
        // If the character is character1
        if(hasPicture.equals("a")){
            swordlvl2.setImageResource(R.mipmap.level2swordno);
            swordlvl3.setImageResource(R.mipmap.level3swordno);
            armorredlvl2.setImageResource(R.mipmap.level2redarmorno);
            armorredlvl3.setImageResource(R.mipmap.level3redarmorno);
            shieldlvl2.setImageResource(R.mipmap.level2shieldno);
            shieldlvl3.setImageResource(R.mipmap.level3shieldno);
        }
        else{
            swordlvl2.setImageResource(R.mipmap.level2swordno);
            swordlvl3.setImageResource(R.mipmap.level3swordno);
            armorbluelvl2.setImageResource(R.mipmap.level2bluearmorno);
            armorbluelvl3.setImageResource(R.mipmap.level3bluearmorno);
            shieldlvl2.setImageResource(R.mipmap.level2shieldno);
            shieldlvl3.setImageResource(R.mipmap.level3shieldno);
        }

    }

    public void loadStatisticsGuiComponents(){
        // Assign variables to GUI components
        currentAttack = (TextView)findViewById(R.id.lblCurrentAttack);
        currentArmor = (TextView)findViewById(R.id.lblCurrentArmor);
        currentDefence = (TextView)findViewById(R.id.lblCurrentDefence);
        currentStats = (TextView)findViewById(R.id.lblCurrentStats);
        newStats = (TextView)findViewById(R.id.lblNewStats);
        newAttack = (TextView)findViewById(R.id.lblNewAttack);
        newArmor = (TextView)findViewById(R.id.lblNewArmor);
        newDefence = (TextView)findViewById(R.id.lblNewDefence);

        // Assign values to new statistic components.
        currentAttack.setText("att: " + String.valueOf(player.getAttack()));
        currentArmor.setText("arm: " + String.valueOf(player.getArmor()));
        currentDefence.setText("def: " + String.valueOf(player.getDefence()));
        currentStats.setText("current");
        newStats.setText("new");
        newAttack.setText("att: " +String.valueOf(0));
        newArmor.setText("arm: " + String.valueOf(0));
        newDefence.setText("def: " + String.valueOf(0));
    }

    public void purchaseUpgrade(){
        // Retrieving name data from different intent
        Intent retrieveFrom = getIntent();
        hasName = retrieveFrom.getStringExtra("name");
        player = new Player(hasName, null);
        btnPurchaseUpgrade = (Button)findViewById(R.id.btnPurchase);
        btnPurchaseUpgrade.setText("buy");
        btnPurchaseUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the player has enough money. He can purchase an upgrade
                int money = player.getMoney();
                if(money >= 100){// Anders formuleren bijv. money >= player.currentMoney
                    System.out.println("Upgrade purchased");
                    isEnabled = false;
                    if(!isEnabled){
                        btnPurchaseUpgrade.setVisibility(View.INVISIBLE);
                    }
                }
                else{
                    System.out.println("Not enough money");
                }
            }
        });
    }
}