package com.example.rock_paper_scissor_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Objects;

public class Game_Activity extends AppCompatActivity {

    String PlayerName;
    Toolbar toolbar;

    Button GameActivityRestartButton;
    /* --------------Quit_DialogBox--------------- */

    Button QuitButton;
    ImageButton QuitCloseIV;

    TextView QuitNameDialogBoxTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /* --------------Previous Activity Pass the Name Through the intent--------------- */

        PlayerName = getIntent().getStringExtra("PlayerName");

        /* --------------DialogBox Creation--------------- */

        Dialog QuitDialog = new Dialog(this);
        QuitDialog.setContentView(R.layout.quit_dialog_box);

        /*---------------Hooks Game Activity--------------->*/

        toolbar = findViewById(R.id.Game_Activity_Toolbar);

        GameActivityRestartButton = findViewById(R.id.Game_Activity_Restart_Button);
        /*---------------Hooks Quit DialogBox--------------->*/

        QuitButton = QuitDialog.findViewById(R.id.Quit_Button);
        QuitCloseIV = QuitDialog.findViewById(R.id.Quit_Close_IV);
        QuitNameDialogBoxTV = QuitDialog.findViewById(R.id.Quit_Name_DialogBox_TV);

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        startActivity(new Intent(Game_Activity.this, Main_Activity.class));
        finish();
        return true;
    }
}