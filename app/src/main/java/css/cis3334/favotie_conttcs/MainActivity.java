package css.cis3334.favotie_conttcs;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1Call, btn2Call, btn3Call, btn1Text, btn2Text, btn3Text;
    Spinner messageSpinner;
    TextView textViewStatus, textViewContact1, textViewContact2, textViewContact3;
    String messageSelection = "ERROR_SENDING_MESSAGE";
    String phone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] contactsArray = getResources().getStringArray(R.array.contacts_array);
        //String[] messageArray = getResources().getStringArray(R.array.message_array);   // Not Needed Here, used in activity_main.

        textViewContact1 = (TextView) findViewById(R.id.textViewContact1);
        textViewContact2 = (TextView) findViewById(R.id.textViewContact2);
        textViewContact3 = (TextView) findViewById(R.id.textViewContact3);

        textViewContact1.setText(contactsArray[0]);
        textViewContact2.setText(contactsArray[1]);
        textViewContact3.setText(contactsArray[2]);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        setupButtonClickEvents();

    }

    @SuppressWarnings({"MissingPermission"})
    private void setupButtonClickEvents() {

        final String[] numberArray = getResources().getStringArray(R.array.number_array);

        btn1Call = (Button) findViewById(R.id.button1Call);
        btn1Call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                phone = numberArray[0];
                textViewStatus.setText("Call 1 Executed");
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone));
                startActivity(callIntent);
            }
        });

        btn2Call = (Button) findViewById(R.id.button2Call);
        btn2Call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                phone = numberArray[1];
                textViewStatus.setText("Call 2 Executed");
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phone));
                if (callIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(callIntent);
            }
        });

        btn3Call = (Button) findViewById(R.id.button3Call);
        btn3Call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                phone = numberArray[2];
                textViewStatus.setText("Call 3 Executed");
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phone));
                //noinspection ResourceType
                startActivity(callIntent);
            }
        });

        messageSpinner = (Spinner) findViewById(R.id.spinnerMessage);
        messageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                messageSelection = parent.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btn1Text = (Button) findViewById(R.id.buttonText1);
        btn1Text.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                textViewStatus.setText("Text 1 Executed");
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:2182903397"));
                sendIntent.putExtra("sms_body", messageSelection);
                startActivity(sendIntent);
            }
        });

        btn2Text = (Button) findViewById(R.id.buttonText2);
        btn2Text.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                textViewStatus.setText("Text 2 Executed");
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:5678912340"));
                sendIntent.putExtra("sms_body", messageSelection);
                startActivity(sendIntent);
            }
        });

        btn3Text = (Button) findViewById(R.id.buttonText3);
        btn3Text.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                textViewStatus.setText("Text 3 Executed");
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:9012345678"));
                sendIntent.putExtra("sms_body", messageSelection);
                startActivity(sendIntent);
            }
        });



    }
}
