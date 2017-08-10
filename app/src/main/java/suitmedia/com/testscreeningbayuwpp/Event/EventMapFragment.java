package suitmedia.com.testscreeningbayuwpp.Event;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import suitmedia.com.testscreeningbayuwpp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventMapFragment extends Fragment implements OnMapReadyCallback {
    private Context context;
    private MapView mapView;
    private GoogleMap googleMap;
    private EventPagerAdapter adapter;
    private ArrayList<Event> events;
    ViewPager viewPager;

    public EventMapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.eventmap_mapview_map);
        viewPager = (ViewPager) view.findViewById(R.id.eventmap_viewpager_eventpager);

        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        events = new ArrayList<>();
        setDataDummy();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter = new EventPagerAdapter(view.getContext(),events);
        viewPager.setAdapter(adapter);
//        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        map.setBuildingsEnabled(true);
        final Marker addMarker;
        //map.setMyLocationEnabled(true);
        map.setTrafficEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-6.8868245,107.6131064),20));
        for (int i=0;i <events.size();i++) {
            Log.i("add marker",events.get(i).getName());
            googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(events.get(i).getLatitude(),events.get(i).getLongitude()))
                    .title(String.valueOf(i))
                    );
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(events.get(position).getLatitude(),events.get(position).getLongitude()))
                        .title(events.get(position).getName()).icon(BitmapDescriptorFactory.fromBitmap(changeBitmapColor(context.getResources().getColor(R.color.blue_transparent)))));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private Bitmap changeBitmapColor(int color) {
        Bitmap ob = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_pin_blue);
        Bitmap obm = Bitmap.createBitmap(ob.getWidth(), ob.getHeight(), Bitmap.Config.ARGB_8888);
        Bitmap overlay = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_pin_green);
        Bitmap overlaym = Bitmap.createBitmap(overlay.getWidth(), overlay.getHeight(), Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(overlaym);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(ob, 0f, 0f, paint);
        canvas.drawBitmap(overlay, 0f, 0f, null);
        return overlaym;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_event_map, container, false);
        context = rootView.getContext();
        return rootView;
    }

    public void setDataDummy() {
        events.add(new Event(R.drawable.dummy_image, "abc event", "Nov 9 2014","nutricia,highlight F3","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",-6.89148,107.6084704));
        events.add(new Event(R.drawable.dummy_image, "def event", "Oct 21 2014","nutricia","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",-6.8868245,107.6131064));
        events.add(new Event(R.drawable.dummy_image, "ghi event", "Jun 14 2014","nutricia,highlight F3,event","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",-6.88485,107.6078113));
        events.add(new Event(R.drawable.dummy_image, "jkl event", "Jun 14 2014","nutricia","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",-6.8844735,107.6049008));
    }

}
