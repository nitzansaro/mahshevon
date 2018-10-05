package com.example.nitza.mahshevon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
        Intent r ;
        TextView t1, t2, t3, t4;
        ListView lv;
        int  n,rad1;
        double s,x1,d1;
        String[] list = new String[20];


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            lv=(ListView) findViewById(R.id.lv);
            t1=(TextView) findViewById(R.id.t1);
            t2=(TextView) findViewById(R.id.t2);
            t3=(TextView) findViewById(R.id.t3);
            t4=(TextView) findViewById(R.id.t4);
            if (getIntent()!= null){
                r= getIntent();
            rad1 = r.getExtras().getInt("radio", 10);
            x1 = r.getExtras().getDouble("x", 9.1);
            d1 = r.getExtras().getDouble("d", 9.0);
            t1.setText(Double.toString(x1));
            t2.setText(Double.toString(d1));
            list [0]=Double.toString(rad1);
                  if (rad1==1) {
                      for (int i = 1; i < 20; i++){
                       list[i] = Double.toString(Double.parseDouble(list[i - 1]) + d1);}

                  }else{
                          for (int i = 1; i < 20; i++){
                              list[i] = Double.toString(Double.parseDouble(list[i - 1]) * d1);}}


            lv.setOnItemClickListener(this);
            lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            ArrayAdapter adp = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
            lv.setAdapter(adp); }}


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        n = i + 1;
        t3.setText(Double.toString(n));
        if (rad1 == 2) {
            if (d1 == 1) {
                s = x1 * n;
            } else {
                s = ((x1 * ((Math.pow(d1, n)) - 1)) / (d1 - 1));
                }
            t4.setText(Double.toString(s));
        }
        if (rad1 == 1)
            s = ((n * ((2 * x1) + d1 * (n - 1))) / 2);
            t4.setText(Double.toString(s));
        }




    public void go2(View view) {
            Intent b=new Intent(this,MainActivity.class);
            startActivity(b);
        }
    }
