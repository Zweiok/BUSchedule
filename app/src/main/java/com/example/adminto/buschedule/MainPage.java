package com.example.adminto.buschedule;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;


public class MainPage extends AppCompatActivity {

    public void setLoginPass(View v) {

        new CustomDialogFragment().show(getSupportFragmentManager(),
                "login");
    }
    public void openScheduleForm(View v)
    {
        Intent intObj = new Intent(this, schedule_activity.class);
        startActivity(intObj);
    }

    String[] data = {"групи", "кабінету", "викладача"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TextView TextView5 = (TextView) findViewById(R.id.textView5);
        final TextView TextView3 = (TextView) findViewById(R.id.textView3);
        final EditText EditText2 = (EditText) findViewById(R.id.editText2);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Title");
        spinner.setSelection(2);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position == 0)
                {
                    TextView5.setText("  групи");
                    TextView5.setTextSize(18);
                    EditText2.setHint("Номер групи");
                    TextView3.setText("Приклад: 101-ФКБ");
                }
                if(position == 1)
                {
                    TextView5.setText("  кабінету");
                    TextView5.setTextSize(18);
                    EditText2.setHint("Номер кабінету");
                    TextView3.setText("Приклад: 111");
                }
                if(position == 2)
                {
                    TextView5.setText("  викладача");
                    TextView5.setTextSize(18);
                    EditText2.setHint("Ім'я викладача");
                    TextView3.setText("Приклад: Іванов І В");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

}
