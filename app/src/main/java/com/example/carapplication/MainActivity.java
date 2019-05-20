package com.example.carapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] carTypeArray = new String[CarType.values().length];

        int counter = 0;
        for (CarType value : CarType.values()){
            carTypeArray[counter] = value.getName();

            counter++;
        }

        Spinner carSpinner = findViewById(R.id.carTypeSpinner);
        carSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, carTypeArray ));

        String[] driveTypeArray = new String[DriveType.values().length];

        counter = 0;
        for (DriveType value : DriveType.values()){
            driveTypeArray[counter] = value.getName();

            counter++;
        }

        Spinner driveSpinner = findViewById(R.id.driveTypeSpinner);
        driveSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, driveTypeArray ));

    }

    public void getMaintenanceSchedule(View v){
        Spinner carSpinner = findViewById(R.id.carTypeSpinner);
        Spinner driveSpinner = findViewById(R.id.driveTypeSpinner);
        EditText mileage = findViewById(R.id.mileage);

        TableLayout tableLayout = findViewById(R.id.tableLayout);
        int childCount = tableLayout.getChildCount();

        if (childCount > 5) {
            tableLayout.removeViews(5, childCount - 5);
        }


        CarType carType = CarType.getCarTypeFromName(carSpinner.getItemAtPosition(carSpinner.getSelectedItemPosition()).toString());
        DriveType driveType = DriveType.getDriveTypeFromName(driveSpinner.getItemAtPosition(driveSpinner.getSelectedItemPosition()).toString());

        Car car = new Car(carType,driveType , Integer.parseInt(mileage.getText().toString()));

        MaintenanceSchedule maintenanceSchedule = new MaintenanceSchedule(car);

        TextView headerText1 = new TextView(this);
        TextView headerText2 = new TextView(this);
        TableRow headerRow = new TableRow(this);
        headerText1.setText("Maintenance Item");
        headerText2.setText("Mileage at Next Change");
        headerRow.addView(headerText1);
        headerRow.addView(headerText2);
        tableLayout.addView(headerRow);

        for(String key : maintenanceSchedule.nextMaintenance.keySet()){

            TextView valueText = new TextView(this);
            TextView keyText = new TextView(this);
            TableRow tableRow = new TableRow(this);
            Button button = new Button(this);

            keyText.setText(key);
            valueText.setText(maintenanceSchedule.nextMaintenance.get(key).toString());

            tableRow.addView(keyText);
            tableRow.addView(valueText);
            tableRow.addView(button);

            tableLayout.addView(tableRow);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
