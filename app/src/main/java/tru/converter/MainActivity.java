package tru.converter;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.content.Context;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    final String DEGREE  = "\u00b0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spin1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        final EditText num1 = (EditText) findViewById(R.id.num1);
        final Button button = (Button) findViewById(R.id.button1);
        final TextView result = (TextView) findViewById(R.id.result);

        // Code
        button.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               String from = spin1.getSelectedItem().toString();
               String to = spin2.getSelectedItem().toString();
               String strnum = num1.getText().toString();
               double value_to_convert;
               double value;
               String type;

               if(!strnum.isEmpty()) {
                   if (from.equals(to)) {
                       // Toast
                       Context context = getApplicationContext();
                       CharSequence text = "Convert options must be different";
                       int duration = Toast.LENGTH_SHORT;

                       Toast.makeText(context, text, duration).show();
                   } else {
                       // Convert
                       value_to_convert = Double.parseDouble(strnum);

                       if (from.equals("Celsius")) {
                           // Convert to Fahrenheugtrhigoghtr
                           value = (value_to_convert * 9 / 5) + 32;
                           type = DEGREE + 'F';
                       } else {
                           // Convert to Celsius
                           value = (value_to_convert - 32) * 5 / 9;
                           type = DEGREE + 'C';
                       }

                       String resultText = String.format(Locale.CANADA,"%.2f", value) + type;
                       result.setText(resultText);
                   }
               } else {
                   Context context = getApplicationContext();
                   CharSequence text = "Please enter a value";
                   int duration = Toast.LENGTH_SHORT;

                   Toast.makeText(context, text, duration).show();
                   // Test
               }
           }
        });
    }
}
