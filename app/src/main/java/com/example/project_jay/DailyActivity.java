package com.example.project_jay;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DailyActivity extends AppCompatActivity {
    final static String TAG = "DailyActivity";
    private MyDBHelper helper;
    int eid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        setTitle("Find Calendar");
        helper = MyDBHelper.getInstance(this);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable drawable = getDrawable(R.drawable.ic_chevron_left_black_24dp);
            if (drawable != null) {
                drawable.setTint(Color.BLACK);
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }


        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TextView date = (TextView) findViewById(R.id.date);
                TextView monthresult = (TextView) findViewById(R.id.monthresult);
                TextView slash = (TextView) findViewById(R.id.slash);
                TextView dayresult = (TextView) findViewById(R.id.dayresult);
                TextView daytext = (TextView) findViewById(R.id.daytext);
                TextView textresult = (TextView) findViewById(R.id.textresult);
                TextView starttext = (TextView) findViewById(R.id.starttext);
                TextView finishtext = (TextView) findViewById(R.id.finishtext);
                TextView startresult1 = (TextView) findViewById(R.id.startresult1);
                TextView startresult2 = (TextView) findViewById(R.id.startresult2);
                TextView finishresult1 = (TextView) findViewById(R.id.finishresult1);
                TextView finishresult2 = (TextView) findViewById(R.id.finishresult2);
                EditText dmonth = (EditText) findViewById(R.id.dmonth);
                EditText dday = (EditText) findViewById(R.id.dday);


                String dsql = String.format("SELECT * FROM schedulev WHERE month1 IN(%s) AND day1 IN(%s)", dmonth.getText(), dday.getText());
                Cursor dcursor = helper.getReadableDatabase().rawQuery(dsql, null);
                StringBuffer buffer = new StringBuffer();

                while (dcursor.moveToNext()) {
                    buffer.append(dcursor.getString(2) + "/");
                    buffer.append(dcursor.getString(3) + ":");
                    buffer.append(dcursor.getString(1) + "\n");
                    buffer.append(dcursor.getString(4) + "\t");
                    buffer.append(dcursor.getString(5) + "\t");
                    buffer.append(dcursor.getString(6) + "\t");
                    buffer.append(dcursor.getString(7) + "\t");

                    eid = dcursor.getInt(0);
                    String month = dcursor.getString(2);
                    String day = dcursor.getString(3);
                    String text = dcursor.getString(1);
                    String starthour = dcursor.getString(4) + ":";
                    String startminute = dcursor.getString(5);
                    String finishhour = dcursor.getString(6) + ":";
                    String finishminute = dcursor.getString(7);

                    date.setText("날짜 : ");
                    monthresult.setText(month);
                    slash.setText(" / ");
                    dayresult.setText(day);
                    daytext.setText("일정내용 : ");
                    textresult.setText(text);
                    starttext.setText("시작시간 : ");
                    startresult1.setText(starthour);
                    startresult2.setText(startminute);
                    finishtext.setText("종료시간 : ");
                    finishresult1.setText(finishhour);
                    finishresult2.setText(finishminute);
                }

            }
        });
    }

      /*  Button dedit = (Button) findViewById(R.id.dedit);
        dedit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditText dmonth = (EditText) findViewById(R.id.dmonth);
                EditText dday = (EditText) findViewById(R.id.dday);

                String month = dmonth.getText().toString().trim();
                String day = dday.getText().toString().trim();
                Intent editintent = new Intent(getApplicationContext(), EditActivity.class);
                editintent.putExtra("editmonth", month);
                editintent.putExtra("editday", day);
                startActivity(editintent);
            }
        });
        }
*/
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.daily_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }


    public boolean onOptionsItemSelected(MenuItem item) { //선택된 item이 무엇인지 아는 곳


        switch (item.getItemId()) {
            case R.id.edit_button:
                EditText dmonth = (EditText) findViewById(R.id.dmonth);
                EditText dday = (EditText) findViewById(R.id.dday);
                String month = dmonth.getText().toString().trim();
                String day = dday.getText().toString().trim();
                Intent editintent = new Intent(getApplicationContext(), EditActivity.class);
                editintent.putExtra("editmonth", month);
                editintent.putExtra("editday", day);
                startActivity(editintent);
                break;

            case R.id.delete_button:
                AlertDialog.Builder builder = new AlertDialog.Builder(DailyActivity.this);
                builder.setTitle("삭제");
                builder.setMessage("정말 삭제 하시겠습니까?");
                //builder.setIcon(R.drawable.);
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        TextView date = (TextView)findViewById(R.id.date);
                        TextView monthresult = (TextView)findViewById(R.id.monthresult);
                        TextView slash = (TextView)findViewById(R.id.slash);
                        TextView dayresult = (TextView)findViewById(R.id.dayresult);
                        TextView daytext = (TextView)findViewById(R.id.daytext);
                        TextView textresult = (TextView)findViewById(R.id.textresult);
                        TextView starttext = (TextView) findViewById(R.id.starttext);
                        TextView finishtext = (TextView) findViewById(R.id.finishtext);
                        TextView startresult1 = (TextView) findViewById(R.id.startresult1);
                        TextView startresult2 = (TextView) findViewById(R.id.startresult2);
                        TextView finishresult1 = (TextView) findViewById(R.id.finishresult1);
                        TextView finishresult2 = (TextView) findViewById(R.id.finishresult2);
                        EditText dmonth = (EditText) findViewById(R.id.dmonth);
                        EditText dday = (EditText) findViewById(R.id.dday);


                        Toast dtoast = Toast.makeText(DailyActivity.this, "삭제되었습니다!", Toast.LENGTH_LONG);
                        dtoast.show();
                        date.setText(" ");
                        monthresult.setText(" ");
                        slash.setText(" ");
                        dayresult.setText(" ");
                        daytext.setText(" ");
                        textresult.setText(" ");
                        startresult1.setText(" ");
                        starttext.setText(" ");
                        finishtext.setText(" ");
                        startresult2.setText(" ");
                        finishresult1.setText(" ");
                        finishresult2.setText(" ");

                        String dsql = String.format (
                                "DELETE FROM schedulev\n"+
                                        "WHERE _id = '%s'", eid);
                        helper.getWritableDatabase().execSQL(dsql);


                    }

                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                    }

                });

                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }




}
