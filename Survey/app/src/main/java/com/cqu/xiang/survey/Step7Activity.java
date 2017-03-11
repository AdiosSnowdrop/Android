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
import android.widget.CheckBox;
import android.widget.RadioGroup;

import static com.cqu.xiang.survey.MainActivity.fileDatas;

public class Step7Activity extends AppCompatActivity {

    static int cbCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        Transition slide = TransitionInflater.from(this).inflateTransition(R.transition.slide);
        Transition slide_inverse = TransitionInflater.from(this).inflateTransition(R.transition.slide_inverse);
        getWindow().setEnterTransition(slide_inverse);
        getWindow().setReenterTransition(slide);
        setContentView(R.layout.activity_step7);
        cbCount = 0;
    }
    public void cbGroup1(View v) {
        if(((CheckBox)v).isChecked()) cbCount++;
        else cbCount--;
        Button b = (Button)findViewById(R.id.btnS7);
        if(cbCount == 0) b.setText("Step 7: Choose your favorite games");
        else b.setText("Next");
    }

    public void btnS7(View v) {
        String txt = ((Button)v).getText().toString();
        if(!txt.equals("Next"))
            return;
        String res = new String("");
        if(((CheckBox)findViewById(R.id.cbK1)).isChecked())
            res += ((CheckBox)findViewById(R.id.cbK1)).getText().toString() + "\n";
        if(((CheckBox)findViewById(R.id.cbK2)).isChecked())
            res += ((CheckBox)findViewById(R.id.cbK2)).getText().toString() + "\n";
        if(((CheckBox)findViewById(R.id.cbK3)).isChecked())
            res += ((CheckBox)findViewById(R.id.cbK3)).getText().toString() + "\n";
        if(((CheckBox)findViewById(R.id.cbK4)).isChecked())
            res += ((CheckBox)findViewById(R.id.cbK4)).getText().toString() + "\n";
        if(((CheckBox)findViewById(R.id.cbK5)).isChecked())
            res += ((CheckBox)findViewById(R.id.cbK5)).getText().toString() + "\n";
        fileDatas.set(6, res);
        startActivity(new Intent(this, Step8Activity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
