package suitmedia.com.testscreeningbayuwpp.Event;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import suitmedia.com.testscreeningbayuwpp.R;

/**
 * Created by Bayu WPP on 8/10/2017.
 */

public class EventPagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Event> events;
    private LayoutInflater inflater;

    public EventPagerAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView;
        TextView textView;

        final View itemView = inflater.inflate(R.layout.adapter_eventimage, container, false);

        imageView = (ImageView) itemView.findViewById(R.id.adaptereventimage_imageview_eventimage);
        textView = (TextView) itemView.findViewById(R.id.adaptereventimage_textview_eventname);

        imageView.setBackgroundResource(events.get(position).getImage());
        textView.setText(events.get(position).getName());
        container.addView(itemView);
        return itemView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = ((View) object);
        container.removeView(view);
    }
}
