package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quiz_app.model.Questionmodel;

import java.util.ArrayList;
import java.util.List;

public class Quizes extends AppCompatActivity {
private TextView question,noIndicator;
private LinearLayout options;
private int count = 0;
private Button nextbtn;
private List<Questionmodel> list;
private int score = 0;

private int position = 0;
//FirebaseDatabase database = FirebaseDatabase.getInstance();
//DatabaseReference myrf = database.getReference("questions");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizes);


        question = findViewById(R.id.question);
        noIndicator = findViewById(R.id.textview2);
        nextbtn = findViewById(R.id.button5);
        options = findViewById(R.id.linearlay2);






   list = new ArrayList<>();
list.add(new Questionmodel("What is the capital of pakistan" ,"isl"," karachil","lah","q","isl"));
list.add(new Questionmodel("What is the capital of pakistan","isl"," karachil","lah","q","karachil"));
            list.add(new Questionmodel("What is the capital of pakistan","isl"," karachil","lah","q","lah"));
            list.add(new Questionmodel("What is the capital of pakistan","isl"," karachil","lah","q","q"));
            list.add(new Questionmodel("What is the capital of pakistan","isl"," karachil","lah","q","isl"));

        for (int i = 0; i < 4 ; i++ ){
            options.getChildAt(i).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {//here we fetchd the data of the right option which user's clicked
                    checkAnswer((Button) v);
                }
                });
            }
        playAnim(question, 0, list.get(position).getMajorq());

            nextbtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    nextbtn.setEnabled(false);
                    nextbtn.setAlpha(0.7f);
                    enableoption(true);
                    position ++;
                    if (position == list.size()){
                        //scoreActivity activity
                        Intent scoreIntent= new Intent(Quizes.this, scoreActivity.class);
                        scoreIntent.putExtra("score", score);
                        scoreIntent.putExtra("total",list.size());
                        startActivity(scoreIntent);
                        finish();
                        return;

                    }
                    count = 0;

                    playAnim(question, 0, list.get(position).getMajorq());

                }

            });
        }


//calling first question by default



private void playAnim(final View view, final int value, final String data){

       view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
       .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
           @Override
           public void onAnimationStart(Animator animation) {
//animation starts from here
if (value == 0 && count < 4) {
    String option = "";

    if (count == 0) {
        option = list.get(position).getQuestion1();
    } else if (count == 1){
    option = list.get(position).getQuestion2();
    }
    else if ( count == 2) {
        option = list.get(position).getQuestion3();

    }
    else if ( count == 3) {
        option = list.get(position).getQuestion4();

    }
    playAnim(options.getChildAt(count),0,option);
    count++;
    }

    }
           @Override
           public void onAnimationEnd(Animator animation) {
//questions and option were change here
if (value ==0){
    try {
        ((TextView)view).setText(data);
        noIndicator.setText(position+1+ "/"+list.size());
    }catch (ClassCastException ex) {
        ((Button)view).setText(data);
    }
    view.setTag(data);
    playAnim(view, 1,data); //data change
}
           }

           @Override
           public void onAnimationCancel(Animator animation) {

           }

           @Override
           public void onAnimationRepeat(Animator animation) {

           }
       });
    }

    private void checkAnswer(Button selectoption){
        enableoption(false);
        nextbtn.setEnabled(true);
        nextbtn.setAlpha(1);

        if (selectoption.getText().toString().equals(list.get(position).getCorrectans())){
            //correct

                selectoption.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));

            score++;
        }else {
            //incorrect
            //here we show the corrct options to the user
            Button correctopt = (Button) options.findViewWithTag(list.get(position).getCorrectans());

                selectoption.setBackgroundTintList(ColorStateList.valueOf(Color.RED));



            //   correctopt.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));

        }


    }

    private void enableoption(boolean enable){
        for (int i = 0; i <4 ; i++ ){
            options.getChildAt(i).setEnabled(enable);
            if (enable){
                    options.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));


            }
            }
    }
}
