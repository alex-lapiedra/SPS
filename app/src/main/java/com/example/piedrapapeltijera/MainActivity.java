package com.example.piedrapapeltijera;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView computerIcon;
    private ImageView playerIcon;
    private TextView resultText;
    Button stoneButton;
    Button scissorsButton;
    Button papelButton;
    Button lizardButton;
    Button spockButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        prepareViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void prepareViews() {
        stoneButton = findViewById(R.id.stoneButton);
        stoneButton.setOnClickListener(this);
        scissorsButton = findViewById(R.id.scissorsButton);
        scissorsButton.setOnClickListener(this);
        papelButton = findViewById(R.id.papelButton);
        papelButton.setOnClickListener(this);
        lizardButton = findViewById(R.id.lizardButton);
        lizardButton.setOnClickListener(this);
        spockButton = findViewById(R.id.spockButton);
        spockButton.setOnClickListener(this);

        computerIcon = findViewById(R.id.computerIcon);
        playerIcon = findViewById(R.id.playerIcon);
        resultText = findViewById(R.id.resultText);
    }

    @SuppressLint("DiscouragedApi")
    @Override
    public void onClick(View v) {
        Item computerItem = new Item();
        Item playerItem;

        Log.d("onClick","Has pulsado el botón " + v.getTag());
        if( v.getTag().toString().equals("stoneButton")) {
            playerItem = new Item(ItemType.STONE);
        }
        else if ( v.getTag().toString().equals("paperButton")) {
            playerItem = new Item(ItemType.PAPER);
        }
        else if ( v.getTag().toString().equals("scissorsButton")) {
            playerItem = new Item(ItemType.SCISSORS);
        }
        else if ( v.getTag().toString().equals("lizardButton")) {
            playerItem = new Item(ItemType.LIZARD);
        }
        else if ( v.getTag().toString().equals("spockButton")) {
            playerItem = new Item(ItemType.SPOCK);
        }
        else {
            playerItem = new Item(ItemType.STONE);
        }
        Result result = playerItem.winsTo(computerItem);
        switch(result) {
            case DRAW:
                Log.d("Result","La maquina ha elegido " + computerItem.toString() + ". Has empatado" );
                resultText.setText("Has empatado");
                playerIcon.setImageResource(playerItem.getResourceId(this, Result.DRAW));
                computerIcon.setImageResource(computerItem.getResourceId(this,Result.DRAW));
                break;
            case WIN:
                Log.d("Result","La maquina ha elegido " + computerItem.toString() + ". Has ganado" );
                resultText.setText("Has ganado");
                playerIcon.setImageResource(playerItem.getResourceId(this, Result.WIN));
                computerIcon.setImageResource(computerItem.getResourceId(this,Result.LOSE));
                break;
            case LOSE:
                Log.d("Result","La maquina ha elegido " + computerItem.toString() + ". Has perdido" );
                resultText.setText("Has perdido");
                playerIcon.setImageResource(playerItem.getResourceId(this,Result.LOSE));
                computerIcon.setImageResource(computerItem.getResourceId(this,Result.WIN));
                break;
        }
    }
}