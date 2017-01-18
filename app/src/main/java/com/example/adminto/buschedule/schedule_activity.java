package com.example.adminto.buschedule;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class schedule_activity extends ActionBarActivity{
    TextView CurrentDate;
    Calendar dateAndTime=Calendar.getInstance();
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_schedule_activity);
        CurrentDate =(TextView)findViewById(R.id.CurrentDate);
        setInitialDateTime();
    }

    // отображаем диалоговое окно для выбора даты
    public void setDate(View v) {
        new DatePickerDialog(schedule_activity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    // установка начальных даты и времени
    private void setInitialDateTime() {

        CurrentDate .setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_NUMERIC_DATE| DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_ABBREV_ALL));
    }

    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };

}
