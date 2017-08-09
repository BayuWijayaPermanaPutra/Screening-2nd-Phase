package suitmedia.com.testscreeningbayuwpp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {
    private RecyclerView recyclerViewEvent;
    private EventAdapter adapter;
    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        events = new ArrayList<>();
        setDataDummy();
        initView();
        recyclerViewEvent.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEvent.setLayoutManager(linearLayoutManager);
        recyclerViewEvent.setItemAnimator(new DefaultItemAnimator());
        adapter = new EventAdapter(events, EventActivity.this);
        recyclerViewEvent.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setDataDummy() {
        events.add(new Event(R.drawable.dummy_image, "abc event", "11 Januari 2016"));
        events.add(new Event(R.drawable.dummy_image, "def event", "13 Januari 2016"));
        events.add(new Event(R.drawable.dummy_image, "ghi event", "15 Januari 2016"));
        events.add(new Event(R.drawable.dummy_image, "jkl event", "19 Januari 2016"));
    }

    private void initView() {
        recyclerViewEvent = (RecyclerView) findViewById(R.id.event_recyclerview_eventlist);
    }
}
