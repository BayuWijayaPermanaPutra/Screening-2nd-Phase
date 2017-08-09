package suitmedia.com.testscreeningbayuwpp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestActivity extends AppCompatActivity {
    private RecyclerView recyclerViewGuest;
    GuestAdapter adapter;
    ArrayList<Guest> guests;
    ServiceApi serviceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        guests = new ArrayList<>();
        serviceApi = ServiceApi.factory.create();
        adapter = new GuestAdapter(guests, GuestActivity.this);
        initView();
        setDataFromApi();
        recyclerViewGuest.setLayoutManager(new GridLayoutManager(GuestActivity.this, 2));
        recyclerViewGuest.setHasFixedSize(true);
        recyclerViewGuest.setAdapter(adapter);
    }

    private void setDataFromApi() {
        Call<List<Guest>> getGuests = serviceApi.getEventPublic();
        getGuests.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    guests.add(new Guest(response.body().get(i).getName(), response.body().get(i).getBirthdate()));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Log.e("Guest", "ResponseFailed " + t.getMessage());
            }
        });
    }

    private void initView() {
        recyclerViewGuest = (RecyclerView) findViewById(R.id.guest_recyclerview_guestlist);
    }

}
