package suitmedia.com.testscreeningbayuwpp.Event;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import suitmedia.com.testscreeningbayuwpp.R;

public class EventActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        setupToolbar();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.event_frame_eventbody, new EventListFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_add_media :
                fragmentManager.beginTransaction().replace(R.id.event_frame_eventbody, new EventMapFragment()).commit();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("MESSAGE FROM COD");
    }
}
