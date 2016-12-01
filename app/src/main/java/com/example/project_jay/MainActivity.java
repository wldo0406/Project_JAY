package com.example.project_jay;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences setting;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting = getSharedPreferences("SaveOption", MODE_PRIVATE);
        CalendarView calendar = (CalendarView) findViewById(R.id.calendarmonth);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //선택된 item이 무엇인지 아는 곳
        SharedPreferences.Editor editor = setting.edit();  //저장하기 위해서는 edit객체를 얻어야함

        switch (item.getItemId()) {
            case R.id.month_button:
                getFragmentManager().beginTransaction().replace(R.id.activity_main, new Monthfragment()).addToBackStack(null).commit();
                editor.putString("option", "month_button");
                break;

            case R.id.week_button:
                getFragmentManager().beginTransaction().replace(R.id.activity_main, new Weekfragment()).addToBackStack(null).commit();
                editor.putString("option", "week_button");
                break;

            case R.id.day_button:
                getFragmentManager().beginTransaction().replace(R.id.activity_main, new Dayfragment()).addToBackStack(null).commit();
                editor.putString("option", "day_button");
                break;

            case R.id.additem:
                Intent intent1 = new Intent(this, DBMake.class);
                startActivity(intent1);
                break;
            case R.id.deleteitem:

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
