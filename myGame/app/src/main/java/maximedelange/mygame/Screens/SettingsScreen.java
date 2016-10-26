package maximedelange.mygame.Screens;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import maximedelange.mygame.R;

public class SettingsScreen extends AppCompatActivity {

    private Button btnSave;
    private String content;
    //private File file = new File("maximetest");
    private FileWriter writer;
    private FileReader reader;
    private Context context = this;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        test();
    }

    public void test(){
        btnSave = (Button)findViewById(R.id.btnSaveGame);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file = writeFile(file);
                readtest(file);
            }
        });
    }

    public File writeFile(File file){
        File path = context.getFilesDir();
        file = new File(path, "maximeGame.txt");

        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write("This is all test".getBytes());
            stream.close();
        }
        catch(IOException IOE){
            System.out.println("Error: " + IOE.getLocalizedMessage());
        }

        return file;
    }

    public void readtest(File file){
        int length = (int)file.length();
        byte[] bytes = new byte[length];

        try {
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            System.out.println("Read info: " + bytes);
            in.close();
        }
        catch(IOException IOE){
            System.out.println("Error: " + IOE.getLocalizedMessage());
        }
    }
}
