package uiwidget.com.uiexample2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    CalendarView cv;
    Context con;
    DatePicker dp ;
    Button btn;
    Date dob=null;
    TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv=(CalendarView)findViewById(R.id.myCalView);
        con=this;
        btn =(Button)findViewById(R.id.btn);
        tp =(TimePicker)findViewById(R.id.myTP);
        tp.setIs24HourView(true);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(con,tp.getCurrentHour()+":"+tp.getCurrentMinute(),Toast.LENGTH_LONG).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dp = new DatePickerDialog(con);
                dp.show();
            }
        });
       // dp =(DatePicker)findViewById(R.id.myDatePicker);
//        dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
//            Toast.makeText(con,datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear(),Toast.LENGTH_LONG).show();
//            }
//        });
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

               // SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                try {
                //    Date d = sdf.parse(calendarView.getDate() + "");
                    Date d = new Date(calendarView.getDate());
                    int month =d.getMonth();
                    int day =d.getDay();
                    int year =d.getYear();
                    Toast.makeText(con,d.toString(), Toast.LENGTH_LONG).show();


                }catch (Exception ee)
                {

                }
            }
        });


    }
}
