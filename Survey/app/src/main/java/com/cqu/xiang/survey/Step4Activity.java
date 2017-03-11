package com.cqu.xiang.survey;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Step4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        Transition slide = TransitionInflater.from(this).inflateTransition(R.transition.slide);
        Transition slide_inverse = TransitionInflater.from(this).inflateTransition(R.transition.slide_inverse);
        getWindow().setEnterTransition(slide_inverse);
        getWindow().setReenterTransition(slide);
        setContentView(R.layout.activity_step4);
        ((RadioGroup)findViewById(R.id.rgGender4)).setOnCheckedChangeListener(listener);
    }
    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            ((Button)findViewById(R.id.btnS4)).setText("Next");
        }
    };

    public void btnS4(View v) {
        String txt = ((Button)v).getText().toString();
        if(!txt.equals("Next"))
            return;
        RadioButton rb = (RadioButton)findViewById(((RadioGroup)findViewById(R.id.rgGender4)).getCheckedRadioButtonId());
        MainActivity.fileDatas.set(3, rb.getText().toString());
        startActivity(new Intent(this, Step5Activity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
