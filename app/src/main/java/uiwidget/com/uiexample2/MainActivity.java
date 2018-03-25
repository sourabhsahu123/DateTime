package uiwidget.com.uiexample2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.RatingBar;
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
    RatingBar rateUs;
    TimePicker tp;
    ProgressDialog pd;
    int count =10;
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv=(CalendarView)findViewById(R.id.myCalView);
        con=this;
        btn =(Button)findViewById(R.id.btn);
        tp =(TimePicker)findViewById(R.id.myTP);
        tp.setIs24HourView(true);
        pd = new ProgressDialog(con);
        pd.setTitle(R.string.progresstitle);

        pd.setMessage(getResources().getString(R.string.progressmessage));
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setProgress(50);

        pd.setMax(100);
        pd.show();
        pd.dismiss();

        AlertDialog.Builder ab = new AlertDialog.Builder(con);
        ab.setTitle("Do you want to save ??");
        ab.setMessage("This will save your details to our database");
        ab.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(con,"Saving your data",Toast.LENGTH_LONG).show();
            }
        });
        ab.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(con,"will not Save your data",Toast.LENGTH_LONG).show();
            }
        });
        ab.setIcon(getDrawable(R.mipmap.ic_infi));
        ab.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(con,"You have canceled the operation",Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog ad = ab.create();
        ad.show();
        ad.dismiss();

        AlertDialog.Builder ab2 = new AlertDialog.Builder(con);
        ab2.setView(R.layout.custom_alert);
        AlertDialog ad2 = ab2.create();
        ad2.show();
        ad2.setCancelable(false);
        ad2.dismiss();

        myDialog = new Dialog(con);
        myDialog.setContentView(R.layout.custom_alert);

       // LayoutInflater li=LayoutInflater.from(con);
      //  View v =li.inflate(R.layout.custom_alert,null);
     //   ViewGroup.LayoutParams lp =v.getLayoutParams();

        Button adultBtn =(Button)myDialog.findViewById(R.id.adultBtn);
        adultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(con,"You are an adult",Toast.LENGTH_LONG).show();
            }
        });

        myDialog.show();

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<count;i++){
//                pd.setMessage("*");
//                try
//                {
//                Thread.sleep(1000);
//            }
//            catch (Exception ee)
//            {
//                Log.e("In MAIN ACTIVITY",ee.toString());
//            }}
//            }
//
//        });
                rateUs = (RatingBar) findViewById(R.id.rateUs);
        rateUs.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(con,"Thanks for rating us with "+ratingBar.getRating(),Toast.LENGTH_LONG).show();
            }
        });
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
