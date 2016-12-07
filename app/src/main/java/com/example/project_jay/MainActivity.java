package com.example.project_jay;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CalendarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity { //달력이 보이는 액티비티
    ActionBar actionBar;
    SharedPreferences setting;
    private MyDBHelper helper;
    private ContactsAdapter adapter1;
    ArrayList<Contact> contacts1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setting = getSharedPreferences("SaveOption",MODE_PRIVATE);
        CalendarView calendar = (CalendarView)findViewById(R.id.calendarmonth);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth){

            }
        });

        setTitle("JAY Calendar");
     }



    public boolean onOptionsItemSelected(MenuItem item) { //선택된 item이 무엇인지 아는 곳
        SharedPreferences.Editor editor = setting.edit();  //저장하기 위해서는 edit객체를 얻어야함

        switch (item.getItemId()) {
            case R.id.month_button:
                FragmentManager fragmentManagerM = getFragmentManager();
                fragmentManagerM.beginTransaction().replace(R.id.activity_main, new Monthfragment()).addToBackStack(null).commit();
                editor.putString("option", "month_button");
                break;


            case R.id.week_button:
                FragmentManager fragmentManagerW = getFragmentManager();
                fragmentManagerW.beginTransaction().replace(R.id.activity_main, new WeekFragment()).addToBackStack(null).commit();
                editor.putString("option", "week_button");
            break;

            case R.id.day_button:
                FragmentManager fragmentManagerD = getFragmentManager();
                fragmentManagerD.beginTransaction().replace(R.id.activity_main, new Dayfragment()).addToBackStack(null).commit();
                editor.putString("option", "day_button");
                break;

            case R.id.additem:
                Intent intent = new Intent(this, DBMake.class);
                startActivity(intent);
                break;

            case R.id.deleteitem:
                Intent intent2 = new Intent(this, DailyActivity.class);
                startActivity(intent2);
                break;

        }
        item.setChecked(true);  //체크박스
        editor.commit();
        return super.onOptionsItemSelected(item);
    }


    public boolean onCreateOptionsMenu(Menu menu) { //체크박스
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);


        String option=setting.getString("option", "");  //key값, key값이 없을때 무엇을 리턴할지

        if(option.equals("month_button"))  // findItem의 첫번째 파라미터는 메뉴아이템 리소스 아이디
            menu.findItem(R.id.month_button).setChecked(true);
        else if(option.equals("week_button"))
            menu.findItem(R.id.week_button).setChecked(true);
        else if(option.equals("day_button"))
            menu.findItem(R.id.day_button).setChecked(true);


        return true;
    }

}
