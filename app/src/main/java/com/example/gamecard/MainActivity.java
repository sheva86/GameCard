package com.example.gamecard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button mBtnShowResult;
    TextView mTvResult;
    ArrayList<String> mListQuotation = new ArrayList<>();
    Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnShowResult = findViewById(R.id.btnShowResult);
        mTvResult = findViewById(R.id.tvResult);

        mListQuotation.add("Tình yêu chân chính không bị mài mòn bởi thời gian, cũng không thể đổi thay bởi hoàn cảnh.");
        mListQuotation.add("Tình yêu chân thật tràn đầy lòng nhiệt tình, " +
                "bởi trong trí tưởng tượng luôn tồn tại bóng hình hoàn mỹ dù là thực hay hư.");
        mListQuotation.add("Tình yêu và lý tưởng, hôn nhân và thực tế. " +
                "Sự lẫn lộn giữa hiện thực và lý tưởng sẽ không tránh khỏi sự trừng phạt.");
        mListQuotation.add("Yêu, không phải là sự hưởng thụ mà không bỏ bao công sức, yêu là một nghệ thuật, cần có tri thức và sự nỗ lực");


    }

    public void showQuotation(View v) {
        if (v.getId() == R.id.btnShowResult) {
            //mBtnShowResult.setEnabled(false);
            mBtnShowResult.setVisibility(View.INVISIBLE); //cho button biến mất
             CountDownTimer countDownTimer = new CountDownTimer(10000,2000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTvResult.setTextSize(mRandom.nextInt(20)+20);
                    mTvResult.setTextColor(Color.rgb(mRandom.nextInt(265),mRandom.nextInt(265),mRandom.nextInt(265)));
                    switch (mRandom.nextInt(3)) {
                        case 0:
                            mTvResult.setGravity(Gravity.CENTER);
                            break;
                        case 1:
                            mTvResult.setGravity(Gravity.LEFT);
                            break;
                        case 2:
                            mTvResult.setGravity(Gravity.RIGHT);
                            break;
                    }
                    mTvResult.setText(mListQuotation.get(mRandom.nextInt(mListQuotation.size())) + "");

                }

                @Override
                public void onFinish() {
                     mBtnShowResult.setEnabled(true);
                     mBtnShowResult.setVisibility(View.VISIBLE); // hiện lại nút button
                }
            };
            countDownTimer.start();
        }
    }
    public void  showTost (String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
