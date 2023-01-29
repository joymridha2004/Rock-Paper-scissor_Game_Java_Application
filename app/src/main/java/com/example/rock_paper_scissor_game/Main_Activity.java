package com.example.rock_paper_scissor_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main_Activity extends AppCompatActivity {
    Button MainActivityStartGameButton;

    EditText MainActivityPlayerNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*---------------Hooks--------------->*/

        MainActivityStartGameButton = findViewById(R.id.Main_Activity_Start_Game_Button);
        MainActivityPlayerNameEditText = findViewById(R.id.Main_Activity_Player_Name_Edit_Text);
        /*---------------On Click Listener On Start Game Button--------------->*/

        MainActivityStartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*---------------Conditions--------------->*/

                if (!MainActivityPlayerNameEditText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), " Hi   " + MainActivityPlayerNameEditText.getText().toString(), Toast.LENGTH_SHORT).show();

                    /*---------------Save the name --------------->*/

                    String Player1stName = MainActivityPlayerNameEditText.getText().toString();

                    /*---------------Pass the Name through The Intent --------------->*/

                    Intent intent = new Intent(Main_Activity.this, Game_Activity.class);

                    intent.putExtra("PlayerName", Player1stName);

                    startActivity(intent);

                    /*---------------After start Activity Status --------------->*/

                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter Details", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}