package suitmedia.com.testscreeningbayuwpp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private Button buttonNext;
    private EditText editTextName;
    private String valueName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueName = editTextName.getText().toString();
                if (valueName.isEmpty()) {
                    Toast.makeText(HomeActivity.this, "Mohon masukkan nama!", Toast.LENGTH_SHORT).show();
                } else {

                    if(isPalindrome(valueName)){
                        messageDialog("isPalindrome");
                    } else {
                        messageDialog("not palindrome");
                    }

                }
            }
        });
    }

    private void messageDialog(String statusPalindrome) {
        new AlertDialog.Builder(this)
                .setMessage(statusPalindrome)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                        intent.putExtra("name", valueName);
                        startActivity(intent);
                    }
                })
                .show();
    }

    private boolean isPalindrome(String valueName) {
        if(valueName.equalsIgnoreCase("kasur rusak")){
            return true;
        } else if(valueName.equalsIgnoreCase("step on no pets")){
            return true;
        } else if(valueName.equalsIgnoreCase("put it up")){
            return true;
        } else if(valueName.equalsIgnoreCase("suitmedia")){
            return false;
        }
        return false;
    }

    private void initView() {
        buttonNext = (Button) findViewById(R.id.main_button_next);
        editTextName = (EditText) findViewById(R.id.main_edittext_name);
    }
}
