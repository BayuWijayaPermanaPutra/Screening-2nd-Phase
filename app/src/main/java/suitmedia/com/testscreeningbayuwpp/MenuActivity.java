package suitmedia.com.testscreeningbayuwpp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private String valueName;
    private TextView textViewName;
    private Button buttonGuest;
    private Button buttonEvent;
    private static int REQUEST_EVENT = 1;
    private static int REQUEST_GUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();
        valueName = getIntent().getExtras().getString("name");
        textViewName.setText("Nama " + getString(R.string.tabulator) + getString(R.string.tabulator) + ": " + valueName);
        buttonEvent.setOnClickListener(this);
        buttonGuest.setOnClickListener(this);
    }

    private void initView() {
        textViewName = (TextView) findViewById(R.id.menu_textview_name);
        buttonGuest = (Button) findViewById(R.id.menu_button_guest);
        buttonEvent = (Button) findViewById(R.id.menu_button_event);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.menu_button_event:
                intent = new Intent(MenuActivity.this, EventActivity.class);
                startActivityForResult(intent, REQUEST_EVENT);
                break;
            case R.id.menu_button_guest:
                intent = new Intent(MenuActivity.this, GuestActivity.class);
                startActivityForResult(intent, REQUEST_GUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_EVENT) {
            if (resultCode == Activity.RESULT_OK) {
                buttonEvent.setText(data.getStringExtra("eventName"));
            }
        } else if (requestCode == REQUEST_GUEST) {
            if (resultCode == Activity.RESULT_OK) {
                buttonGuest.setText(data.getStringExtra("guestName"));
            }

        }


    }
}
