package com.cqu.xiang.survey;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

import static com.cqu.xiang.survey.MainActivity.fileDatas;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        int sz = fileDatas.size();
        for(String x : fileDatas) {
            Log.v("tag", x);
        }
        savePackageFile();
    }
    private void savePackageFile() {
        FileOutputStream outputStream;
        try {

            File filePath = new File(Environment.getDataDirectory() + "/data/com.cqu.xiang.survey/datas.txt");
            outputStream = new FileOutputStream(filePath);
            for(String x : fileDatas) {
                x += "\n";
                outputStream.write(x.getBytes());
            }
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
