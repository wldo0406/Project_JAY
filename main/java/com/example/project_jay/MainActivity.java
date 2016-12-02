package com.example.project_jay;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendar = (CalendarView)findViewById(R.id.calendarmonth);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth){

            }
        });
     }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {
            case R.id.month_button:
                getFragmentManager().beginTransaction().replace(R.id.activity_main, new Monthfragment()).addToBackStack(null).commit();
                return true;
            case R.id.week_button:
                getFragmentManager().beginTransaction().replace(R.id.activity_main, new Weekfragment()).addToBackStack(null).commit();
                return true;
            case R.id.day_button:
                getFragmentManager().beginTransaction().replace(R.id.activity_main, new Dayfragment()).addToBackStack(null).commit();
                return true;

            case R.id.additem:
                Intent intent1 = new Intent(this,DBMake.class);
                startActivity(intent1);
                return true;
            case R.id.deleteitem:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
