package com.example.nitza.mahshevon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b,b22;
    EditText editText;
    EditText editText1;
    double a1;
    double a2;
    Toast to;
    RadioButton r1, r2;
    int rad ;
    Intent t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText1 = (EditText) findViewById(R.id.editText1);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        b = (Button) findViewById(R.id.b);
        b22 = (Button) findViewById(R.id.b22);
    }

    public void radio(View view) {
        if (r1.isChecked())
            rad = 1;
        if (r2.isChecked())
            rad = 2;
    }





    public void go(View view) {
        String dp = editText.getText().toString();
        a1 = Double.parseDouble(dp);
        String dp1 = editText1.getText().toString();
        a2 = Double.parseDouble(dp1);
        if ((editText.getText().toString().equals(""))||(editText.getText().toString().equals(".-"))||((editText.getText().toString().equals("."))||(editText.getText().toString().equals("-"))||(editText.getText().toString().equals("-.")))||
                ((editText1.getText().toString().equals("")) ||(editText1.getText().toString().equals(".-"))||((editText1.getText().toString().equals("."))||(editText1.getText().toString().equals("-"))||(editText1.getText().toString().equals("-."))))){
            t = new Intent(this, Main2Activity.class);
            if (rad != 0)  {
                t.putExtra("radio", rad);
                t.putExtra("x", a1);
                t.putExtra("d", a2);
                startActivityForResult(t,1);
            } else {
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void go3(View view) {
        Intent a = new Intent(this, Main4Activity.class);
        startActivity(a);
    }
}

