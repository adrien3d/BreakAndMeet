package com.breakandmeet.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.InjectView;

/**
 * Created by adrien on 14/11/2015.
 */
public class CreateTableActivity extends AppCompatActivity {
    @InjectView(R.id.input_heure)
    EditText _heureText;

    @InjectView(R.id.gotoStep2)
    Button _goto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_table);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        addCalendar();
        System.out.println("lala");

        Button gotoButton= (Button)findViewById(R.id.gotoStep2);
        gotoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(this, CreateTable2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void addCalendar(){
        //todo : don't display keyboard
     /*   final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);

                _heureText.setText(sdf.format(myCalendar.getTime()));
            }

        };*/
/*
        _heureText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                DatePickerDialog dpd = new DatePickerDialog(CreateTableActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                myCalendar.setTime(new Date());
                myCalendar.add(Calendar.YEAR, -16);
                dpd.getDatePicker().setMaxDate(myCalendar.getTime().getTime());
                dpd.setTitle(getString(R.string.birthdate_picker_title));
                if (event.getAction() == MotionEvent.ACTION_DOWN) dpd.show();
                return false;
            }
        });*/
    }
}
