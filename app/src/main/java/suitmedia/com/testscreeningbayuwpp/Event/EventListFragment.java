package suitmedia.com.testscreeningbayuwpp.Event;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import suitmedia.com.testscreeningbayuwpp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment {
    private RecyclerView recyclerViewEvent;
    private EventAdapter adapter;
    private ArrayList<Event> events;
    private View parentView;
    public EventListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        parentView = view;
        events = new ArrayList<>();
        setDataDummy();
        initView(view);
        recyclerViewEvent.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(parentView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEvent.setLayoutManager(linearLayoutManager);
        recyclerViewEvent.setItemAnimator(new DefaultItemAnimator());
        adapter = new EventAdapter(events, parentView.getContext());
        recyclerViewEvent.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }

    private void initView(View parentView) {
        recyclerViewEvent = (RecyclerView) parentView.findViewById(R.id.event_recyclerview_eventlist);
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
