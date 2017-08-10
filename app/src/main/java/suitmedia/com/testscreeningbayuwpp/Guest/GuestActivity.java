package suitmedia.com.testscreeningbayuwpp.Guest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import suitmedia.com.testscreeningbayuwpp.CacheSqlLite;
import suitmedia.com.testscreeningbayuwpp.R;
import suitmedia.com.testscreeningbayuwpp.ServiceApi;

public class GuestActivity extends AppCompatActivity {
    private RecyclerView recyclerViewGuest;
    GuestAdapter adapter;
    ArrayList<Guest> guests;
    ServiceApi serviceApi;
    private SwipeRefreshLayout swipe;
    CacheSqlLite dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        guests = new ArrayList<>();
        serviceApi = ServiceApi.factory.create();
        adapter = new GuestAdapter(guests, GuestActivity.this);
        dbHelper = new CacheSqlLite(GuestActivity.this);
        initView();
        setDataFromCache();
        recyclerViewGuest.setLayoutManager(new GridLayoutManager(GuestActivity.this, 2));
        recyclerViewGuest.setHasFixedSize(true);
        recyclerViewGuest.setAdapter(adapter);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setDataFromApi();
            }
        });
    }

    private void setDataFromCache() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM guest", null);
        if (cursor.moveToFirst()) {
            do {
                Guest guest = new Guest(
                        cursor.getInt(0),
                        cursor.getString(1).toString(),
                        cursor.getString(2).toString()
                );
                guests.add(guest);
            } while (cursor.moveToNext());
        } else {
            setDataFromApi();
        }
    }

    private void setDataFromApi() {
        swipe.setRefreshing(true);
        Call<List<Guest>> getGuests = serviceApi.getEventPublic();
        getGuests.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                swipe.setRefreshing(false);
                for (int i = 0; i < response.body().size(); i++) {
                    guests.add(new Guest(response.body().get(i).getId(), response.body().get(i).getName(), response.body().get(i).getBirthdate()));
                    db.execSQL("delete from guest where id='" + response.body().get(i).getId() + "'");
                    db.execSQL("INSERT INTO guest(id, name, birthdate) VALUES ('" + response.body().get(i).getId() + "','" + response.body().get(i).getName() + "','" + response.body().get(i).getBirthdate() + "');");
                    try {
                        date = format.parse(guests.get(i).getBirthdate());
                        int month = Integer.parseInt((String) DateFormat.format("MM", date));
                        Log.e("Guest", "isPrime month:" + adapter.isPrimeMonth(month));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Log.e("Guest", "ResponseFailed " + t.getMessage());
                swipe.setRefreshing(false);
            }
        });
    }

    private void initView() {
        swipe = (SwipeRefreshLayout) findViewById(R.id.event_swipe_guestlist);
        recyclerViewGuest = (RecyclerView) findViewById(R.id.guest_recyclerview_guestlist);
    }
}
