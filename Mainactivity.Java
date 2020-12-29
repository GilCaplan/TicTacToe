package com.example.crosscircle_gilcaplan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonrestart;
    private Button[] button= new Button[9];
    private Controller myC = new Controller();
    private int x;
    private int WINNER=0;
    private String tag= "Gil", winner="";
    private TextView tvplayer, tvmessage;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonrestart = (Button) findViewById(R.id.buttonrestart);
        for(int i=0;i<button.length;i++){
            int resID= getResources().getIdentifier("button"+i,"id", getPackageName());
            button[i]=findViewById(resID);
            button[i].setOnClickListener(this);
        }


        buttonrestart.setOnClickListener(this);
        TextView tvplayer= findViewById(R.id.tvplayer);


    }

    @Override
    public void onClick(View v) {
        TextView tvplayer = findViewById(R.id.tvplayer);
        if (v.getId() == R.id.buttonrestart) {
            myC.start();
            tvplayer.setText("");
            for(int i=0;i<button.length;i++){
                button[i].setText("");
            }
            flag = false;

        }
        String turn;
        int cnt=0;
        while(v.getId() != button[cnt].getId() && cnt<8) {
            cnt++;
        }
            if (v.getId() ==button[cnt].getId()) {
                if (flag == false) {
                    if (!myC.checkspottey(cnt).equals("filled")) {
                        turn = myC.turn();
                        myC.filler(turn, cnt);
                        if (myC.checkspottey(cnt) == "x") {
                            button[cnt].setText("x");
                        } else if (myC.checkspottey(cnt) == "0") {
                            button[cnt].setText("0");
                        }
                        winner1();
                    }
                }
            }
        }

    public void winner1(){
        Intent intent= new Intent(this, SecondActivity.class);
        tvplayer=findViewById(R.id.tvplayer);
        Log.d("Gil", "checking winner");
        if(myC.checkwinner().equals("x")){
             tvplayer.setText("player x won");
             WINNER=1;
            Log.d("Gil", "winner1: x won");
            flag=true;
        }
        else if (myC.checkwinner().equals("tie")) {
            tvplayer.setText("TIE");
            WINNER=-1;
            Log.d("Gil", "TIE");
            flag=true;
        }
        else if (myC.checkwinner().equals("0")) {
            tvplayer.setText("player 0 won");
            WINNER=0;
            Log.d("Gil", "winner1: 0 won");
            flag=true;

        }
        if(flag==true){
            intent.putExtra("winner",WINNER);
            startActivityForResult(intent, 10);
            }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10&& resultCode==RESULT_OK){
            finish();
            startActivity(getIntent());
        }
    }
}
