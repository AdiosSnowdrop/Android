package com.cqu.xiang.survey;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.cqu.xiang.survey.MainActivity.fileDatas;

public class Step8Activity extends AppCompatActivity {

    private rvAdapter myAdapter;
    private List<String> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        Transition slide = TransitionInflater.from(this).inflateTransition(R.transition.slide);
        Transition slide_inverse = TransitionInflater.from(this).inflateTransition(R.transition.slide_inverse);
        getWindow().setEnterTransition(slide_inverse);
        getWindow().setReenterTransition(slide);
        setContentView(R.layout.activity_step8);
        initData();
        RecyclerView rvCause = (RecyclerView) findViewById(R.id.rvCause);
        rvCause.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new rvAdapter(mDatas);
        rvCause.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new rvAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(Step8Activity.this, data, Toast.LENGTH_SHORT).show();
                ((Button)findViewById(R.id.btnS8)).setText("Next");
                fileDatas.set(7, data);
            }
        });
    }

    public void initData(){
        mDatas = new ArrayList<String>();
        mDatas.add("There is abundant spare time, play game to kill time.");
        mDatas.add("Friends and classmates are playing as well.");
        mDatas.add("Study pressure is too heavy, just relax yourself after class.");
        mDatas.add("Lacking of self-control ability.");
        mDatas.add("It is boring that surfing online only.");
        mDatas.add("Feeling lonely, then regard network games as spiritual sustenance.");
        mDatas.add("Others");
    }

    public void btnS8(View v) {
        String txt = ((Button)v).getText().toString();
        if(!txt.equals("Next"))
            return;
        startActivity(new Intent(this, Step9Activity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

}
