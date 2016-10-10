package epetryshyn.unitconverterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputValue;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperature_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        inputValue = (EditText)findViewById(R.id.editText);

        result = (TextView)findViewById(R.id.textView4);

        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Spinner spinner = (Spinner) findViewById(R.id.spinner);
                Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

                if(spinner.getSelectedItem().toString().equals("Fahrenheit") && spinner2.getSelectedItem().toString().equals("Celsius")) {

                    if(inputValue.getText().toString().trim().length() == 0){

                        result.setText("Null");
                        Toast toast = Toast.makeText(getApplicationContext(),"Please Enter a Value!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else {

                        String value = inputValue.getText().toString();
                        Double fah = Double.valueOf(value);
                        Double cel = (fah - 32) * 5 / 9;
                        result.setText(cel.toString());
                    }
                }
                else if(spinner.getSelectedItem().toString().equals("Celsius") && spinner2.getSelectedItem().toString().equals("Fahrenheit")){

                    if(inputValue.getText().toString().trim().length() == 0){

                        result.setText("Null");
                        Toast toast = Toast.makeText(getApplicationContext(),"Please Enter a Value!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else {

                        String value = inputValue.getText().toString();
                        Double cel = Double.valueOf(value);
                        Double fah = (cel * 9 / 5) + 32;
                        result.setText(fah.toString());
                    }
                }
                else{

                    result.setText(inputValue.getText().toString());
                    Toast toast = Toast.makeText(getApplicationContext(),"No Conversion Needed!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

}
