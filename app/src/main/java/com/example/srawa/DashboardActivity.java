package com.example.srawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.Collections;
import java.util.List;

import static com.example.srawa.SplashActivity.list;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue = 20;
    RoundedHorizontalProgressBar progressBar;
    List<Modelclass> allQuestionsList;
    Modelclass modelclass;
    int index = 0;
    TextView card_question, optiona, optionb, optionc, optiond;
    CardView cardOA, cardOB, cardOC, cardOD;
    int correctCount = 0;
    int wrongCount = 0;
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            timerValue=timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this, R.style.Dialogue);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                dialog.findViewById(R.id.btn_tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashboardActivity.this, SplashActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();
        Hooks();


        allQuestionsList=list;
        Collections.shuffle(allQuestionsList);
        modelclass=list.get(index);

        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));


        nextBtn.setClickable(false);
        setAllData();

        progressBar.findViewById(R.id.quiz_timer);


    }

    private void setAllData() {
        card_question.setText(modelclass.getQuestion());
        optiona.setText(modelclass.getA());
        optionb.setText(modelclass.getB());
        optionc.setText(modelclass.getC());
        optiond.setText(modelclass.getD());
        timerValue = 20;
        countDownTimer.cancel();
        countDownTimer.start();

    }

    private void Hooks() {
        progressBar = findViewById(R.id.quiz_timer);
        card_question = findViewById(R.id.card_question);
        optiona=findViewById(R.id.card_optiona);
        optionb=findViewById(R.id.card_optionb);
        optionc=findViewById(R.id.card_optionc);
        optiond=findViewById(R.id.card_optiond);

        cardOA=findViewById(R.id.cardA);
        cardOB=findViewById(R.id.cardB);
        cardOC=findViewById(R.id.cardC);
        cardOD=findViewById(R.id.cardD);

        nextBtn = findViewById(R.id.nextBtn);

    }



    public void Correct(CardView cardView) {

        cardView.setBackgroundColor(getResources().getColor(R.color.green));

    nextBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            correctCount++;
            index++;
            modelclass = list.get(index);
            setAllData();
        }
    });

    }

    public void Wrong(CardView cardOA) {

        cardOA.setCardBackgroundColor(getResources().getColor(R.color.red));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if(index<list.size()-1)
                {
                    index++;
                    modelclass = list.get(index);
                    setAllData();
                }else {
                    GameWon();
                }
            }
        });
    }

    private void GameWon() {
        Intent intent = new Intent(DashboardActivity.this, WonActivity.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", wrongCount);
        startActivity(intent);
    }

    public void enableButton() {
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }
    public void disableButton() {
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }

    public void resetColor() {
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void OptionAClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelclass.getA().equals(modelclass.getAns())) {

            cardOA.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list.size()-1)
            {
                Correct(cardOA);
            }
            else {
                GameWon();
            }
        }else {
            Wrong(cardOA);
        }
    }

    public void OptionBClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelclass.getB().equals(modelclass.getAns())) {

            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list.size()-1)
            {
                Correct(cardOB);
            }
            else {
                GameWon();
            }
        }else {
            Wrong(cardOB);
        }
    }

    public void OptionCClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelclass.getC().equals(modelclass.getAns())) {

            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list.size()-1)
            {
                Correct(cardOC);
            }
            else {
                GameWon();
            }
        }else {
            Wrong(cardOC);
        }
    }

    public void OptionDClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelclass.getD().equals(modelclass.getAns())) {

            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list.size()-1)
            {
                Correct(cardOD);
            }
            else {
                GameWon();
            }
        }else {
            Wrong(cardOD);
        }
    }
}