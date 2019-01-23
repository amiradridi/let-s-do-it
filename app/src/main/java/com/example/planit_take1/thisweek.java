package com.example.planit_take1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class thisweek extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private BottomNavigationView bottomNav;
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.today:
                    Intent intent = new Intent(thisweek.this, today.class);
                    startActivity(intent);
                    break;
                case R.id.thisweek:
                    Intent intent1 = new Intent(thisweek.this, thisweek.class);
                    startActivity(intent1);
                    //bottomNav.setSelectedItemId(R.id.thisweek);
                    break;
                case R.id.feedback:
                    Intent intent2 = new Intent(thisweek.this, feedback.class);
                    startActivity(intent2);
                    break;
                case R.id.profil:
                    Intent intent3 = new Intent(thisweek.this, profil.class);
                    startActivity(intent3);
                    break;

            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thisweek);
        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);
        //bottomNav.setSelectedItemId(R.id.thisweek);
        bottomNav.getMenu().getItem(1).setChecked(false);


    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(this, "home", Toast.LENGTH_LONG).show();
                return true;
            case R.id.calendar:
                Toast.makeText(this, "calendar", Toast.LENGTH_LONG).show();
                DialogFragment datepicker = new DatePickerDialogFragment();
                datepicker.show(getSupportFragmentManager(), "datepicker");
                return true;
            case R.id.search:

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //calendar
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDatestring = DateFormat.getDateInstance().format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.texto);
        textView.setText(currentDatestring);

    }


}
