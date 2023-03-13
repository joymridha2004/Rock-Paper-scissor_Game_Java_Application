package com.example.rock_paper_scissor_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;

public class Game_Activity extends AppCompatActivity {

    int flag = 0;
    int computerInput = 0;
    int userInput = 0;
    int playerScore = 0, computerScore = 0;
    String PlayerName;
    Toolbar toolbar;
    Button GameActivityRestartButton;
    TextView GameActivityComputerChoiceTV, GameActivityGameStatusTV, GameActivityPlayerChoseItemTV, Player_Name, PlayerScore, ComputerScore;
    ImageView ComputerChoseImageIV;
    ImageView Game_Activity_github_link;
    TextView Game_Activity_Project_Link;
    /* --------------Quit_DialogBox--------------- */

    Button QuitButton;
    ImageButton QuitCloseIV;
    TextView QuitNameDialogBoxTV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        /*<------------Night mode disable--------->*/

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        /* --------------Previous Activity Pass the Name Through the intent--------------- */

        PlayerName = getIntent().getStringExtra("PlayerName");

        /* --------------DialogBox Creation--------------- */

        Dialog QuitDialog = new Dialog(this);
        QuitDialog.setContentView(R.layout.quit_dialog_box);

        /*---------------Hooks Game Activity--------------->*/

        GameActivityComputerChoiceTV = findViewById(R.id.Game_Activity_Computer_Choice_TV);
        GameActivityGameStatusTV = findViewById(R.id.Game_Activity_Game_Status_TV);
        GameActivityPlayerChoseItemTV = findViewById(R.id.Game_Activity_Player_Chose_Item_TV);
        Player_Name = findViewById(R.id.Player_Name);
        PlayerScore = findViewById(R.id.Player_Score);
        ComputerScore = findViewById(R.id.Computer_Score);
        GameActivityRestartButton = findViewById(R.id.Game_Activity_Restart_Button);
        ComputerChoseImageIV = findViewById(R.id.Computer_Chose_Image_IV);
        Game_Activity_github_link = findViewById(R.id.Game_Activity_github_link);
        Game_Activity_Project_Link = findViewById(R.id.Game_Activity_Project_Link);

        /*<------------Handle_Github_link_On_click_Listener--------->*/

        Game_Activity_github_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/joymridha2004"));
                startActivity(intent);
            }
        });

        /*<------------Handle_Github_Project_Link_On_click_Listener--------->*/

        Game_Activity_Project_Link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/joymridha2004/Rock-Paper-scissor_Game_Java_Application"));
                startActivity(intent);
            }
        });

        /*---------------Hooks Quit DialogBox--------------->*/

        QuitButton = QuitDialog.findViewById(R.id.Quit_Button);
        QuitCloseIV = QuitDialog.findViewById(R.id.Quit_Close_IV);
        QuitNameDialogBoxTV = QuitDialog.findViewById(R.id.Quit_Name_DialogBox_TV);

        /* --------------Handle onClicks on  Quit Button------------------- */

        GameActivityRestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*---------------Quit DialogBox Name Init --------------->*/

                QuitNameDialogBoxTV.setText(PlayerName);

                QuitDialog.show();
            }
        });
        /* --------------Handle onClicks on  dialogBox Quit Button------------------- */

        QuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Game_Activity.this, Main_Activity.class));
                finish();
            }
        });

        /* --------------Handle onClicks on  dialogBox Close Button------------------- */

        QuitCloseIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuitDialog.dismiss();
            }
        });

        /*---------------First look--------------->*/
        GameActivityComputerChoiceTV.setText("Computer Chose!");
        GameActivityGameStatusTV.setText(null);
        GameActivityPlayerChoseItemTV.setText("please chose item");
        Player_Name.setText(PlayerName);
        PlayerScore.setText("0");
        ComputerScore.setText("0");
    }

    public void check(View view) {
        if (flag == 0) {
            flag = 1;
            switch (view.getId()) {
                case R.id.Game_Player_Rock_TV: {

                    computerInput = new Random().nextInt(3);
                    userInput = 0;
                    GameActivityPlayerChoseItemTV.setText("You Pick Rock");
                    break;
                }
                case R.id.Game_Player_Paper_TV: {

                    computerInput = new Random().nextInt(3);
                    userInput = 1;
                    GameActivityPlayerChoseItemTV.setText("You Pick Paper");
                    break;
                }
                case R.id.Game_Player_Scissor_TV: {

                    computerInput = new Random().nextInt(3);
                    userInput = 2;
                    GameActivityPlayerChoseItemTV.setText("You Pick Scissor");
                    break;
                }
            }
            switch (computerInput) {
                case 0: {
                    ComputerChoseImageIV.setImageResource(R.drawable.rock);
                    GameActivityComputerChoiceTV.setText("Computer Pick Rock");
                    break;
                }
                case 1: {
                    ComputerChoseImageIV.setImageResource(R.drawable.paper);
                    GameActivityComputerChoiceTV.setText("Computer Pick Paper");
                    break;
                }
                case 2: {
                    ComputerChoseImageIV.setImageResource(R.drawable.scissor);
                    GameActivityComputerChoiceTV.setText("Computer Pick Scissor");
                    break;
                }
            }
            if (userInput == computerInput) {
                GameActivityGameStatusTV.setText("Draw");
            } else if (userInput == 0 && computerInput == 2 || userInput == 1 && computerInput == 0 || userInput == 2 && computerInput == 1) {
                GameActivityGameStatusTV.setText("Win!");
                playerScore++;
                PlayerScore.setText(playerScore + "");
            } else {
                GameActivityGameStatusTV.setText("Lose!");
                computerScore++;
                ComputerScore.setText(computerScore + "");
            }

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ComputerChoseImageIV.setImageResource(R.drawable.images);
                    GameActivityGameStatusTV.setText(null);
                    GameActivityComputerChoiceTV.setText("Computer Chose!");
                    GameActivityPlayerChoseItemTV.setText("please chose item");
                    flag = 0;
                }
            };
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(runnable, 2500);

        } else {
            Toast.makeText(getApplicationContext(), "Please wait for reset...", Toast.LENGTH_SHORT).show();
        }
    }
}