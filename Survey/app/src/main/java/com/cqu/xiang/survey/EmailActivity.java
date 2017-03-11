package com.cqu.xiang.survey;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.cqu.xiang.survey.MainActivity.fileDatas;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        Transition slide = TransitionInflater.from(this).inflateTransition(R.transition.slide);
        Transition slide_inverse = TransitionInflater.from(this).inflateTransition(R.transition.slide_inverse);
        getWindow().setEnterTransition(slide_inverse);
        getWindow().setReenterTransition(slide);
        setContentView(R.layout.activity_email);
    }

    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public void btnCancel(View v) {
        fileDatas.set(12, "null");
        startActivity(new Intent(this, EndActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void btnSubmit(View v) {
        String txt = (((EditText)findViewById(R.id.etEmail)).getText().toString());
        Log.d("emial", txt);
        if(!checkEmail(txt)) {
            Toast.makeText(this, "Mailbox format error", Toast.LENGTH_SHORT).show();
            return;
        }
        fileDatas.set(12, txt);
        startActivity(new Intent(this, EndActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
