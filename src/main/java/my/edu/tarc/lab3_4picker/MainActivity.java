package my.edu.tarc.lab3_4picker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView textViewAge;
    private Button buttonSelectDate;
    private EditText editTextAccountBalance;
    private TextView textViewEligibleAmount;
    private int ageOfUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAge = findViewById(R.id.textViewAge);
        buttonSelectDate = findViewById(R.id.buttonSelectDate);
        editTextAccountBalance = findViewById(R.id.editTextAccountBalance);
        textViewEligibleAmount = findViewById(R.id.textViewEligibleAmount);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);

        Toast.makeText(this, getString(R.string.date) + dateMessage,
                Toast.LENGTH_SHORT).show();

        final Calendar c = Calendar.getInstance();
        ageOfUser = c.get(Calendar.YEAR) - year;

        buttonSelectDate.setText(dateMessage);
        textViewAge.setText("Age : " + ageOfUser);
    }

    public void CalculateAmount(View view){
        float amount;
        String amountTemp = editTextAccountBalance.getText().toString();

        amount = Float.parseFloat(amountTemp);

        if(ageOfUser >= 16 && ageOfUser <= 20){
            if(amount >= 5000){
                textViewEligibleAmount.setText("Eligible Amount : " + amount * 0.3);
            }
        }
        else if(ageOfUser >= 21 && ageOfUser <= 25){
            if(amount >= 14000){
                textViewEligibleAmount.setText("Eligible Amount : " + amount * 0.3);
            }
        }
        else if(ageOfUser >= 26 && ageOfUser <= 30){
            if(amount >= 29000){
                textViewEligibleAmount.setText("Eligible Amount : " + amount * 0.3);
            }
        }
        else if(ageOfUser >= 31 && ageOfUser <= 35){
            if(amount >= 50000){
                textViewEligibleAmount.setText("Eligible Amount : " + amount * 0.3);
            }
        }
        else if(ageOfUser >= 36 && ageOfUser <= 40){
            if(amount >= 78000){
                textViewEligibleAmount.setText("Eligible Amount : " + amount * 0.3);
            }
        }
        else if(ageOfUser >= 41 && ageOfUser <= 45){
            if(amount >= 116000){
                textViewEligibleAmount.setText("Eligible Amount : " + amount * 0.3);
            }
        }
        else if(ageOfUser >= 46 && ageOfUser <= 50){
            if(amount >= 165000){
                textViewEligibleAmount.setText("Eligible Amount : " + amount * 0.3);
            }
        }
        else if(ageOfUser >= 51 && ageOfUser <= 55){
            if(amount >= 228000){
                textViewEligibleAmount.setText("Eligible Amount : " + amount * 0.3);
            }
        }
        else{
            textViewEligibleAmount.setText("You are not eligible for investment.");
        }
    }

    public void ResetPage(View view) {
        editTextAccountBalance.setText(null);
        buttonSelectDate.setText(R.string.select_date_of_birth);
        textViewAge.setText(R.string.age);
        textViewEligibleAmount.setText(R.string.eligible_amount);
    }
}
