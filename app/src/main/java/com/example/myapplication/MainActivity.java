package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    Button gobtn;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int location;
    TextView restv;
    int score=0;
    int qus=0;
    TextView marks;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    TextView text;
    Button playagain;
    TextView timertv;
    ConstraintLayout constr;
    public void choseans(View view){
      if(Integer.toString(location).equals(view.getTag().toString())) {
          restv.setText("CORRECT");
          score++;
      } else{
          restv.setText("INCORECT");

          }
      qus++;
      marks.setText(Integer.toString(score)+"/"+Integer.toString(qus));
      newquestion();



    }
    public void start(View view){
        gobtn.setVisibility(View.INVISIBLE);
        constr.setVisibility(View.VISIBLE);
        playagain(findViewById(R.id.timertv));

    }
    public void playagain(View view){
        score=0;
        qus=0;
        timertv.setText("30s");
        marks.setText(Integer.toString(score)+"/"+Integer.toString(qus));
        newquestion();
        playagain.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
                timertv.setText(String.valueOf(l/1000)+"s");

            }

            @Override
            public void onFinish() {
                restv.setText("HEY WE ARE DONE BABY");
                playagain.setVisibility(View.VISIBLE);
            }
        }.start();



    }
    public void newquestion(){
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        text.setText(Integer.toString(a)+ "+"+Integer.toString(b));
        answers.clear();

        location=rand.nextInt(4);
        for(int i=1;  i<=4; i++){
            if(i == location){
                answers.add(a+b);


            }else{
                int wronng=rand.nextInt(40);
                while(wronng==a+b){
                    answers.add(rand.nextInt(40));
                }
                answers.add(wronng);

            }


        } btn1.setText(answers.get(1));
        btn2.setText(answers.get(2));
        btn3.setText(answers.get(3));
        btn4.setText(answers.get(4));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button gobtn=findViewById(R.id.gobtn);

         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         text=findViewById(R.id.sumtext);

         btn1=findViewById(R.id.button1);
         btn2=findViewById(R.id.button2);
         btn3=findViewById(R.id.button3);
         btn4=findViewById(R.id.button4);
         restv=findViewById(R.id.textView6);
         marks=findViewById(R.id.restv);
         playagain=findViewById(R.id.pgbtn);
          timertv=findViewById(R.id.timertv);
          constr=findViewById(R.id.constraint);
          gobtn.setVisibility(View.VISIBLE);
          constr.setVisibility(View.INVISIBLE);

         new CountDownTimer(30100, 1000) {
             @Override
             public void onTick(long l) {
                 timertv.setText(String.valueOf(l/1000)+"s");

             }

             @Override
             public void onFinish() {
             restv.setText("HEY WE ARE DONE BABY");
             playagain.setVisibility(View.VISIBLE);
             }
         }.start();
    }
}
