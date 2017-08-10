package suitmedia.com.testscreeningbayuwpp.Guest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import suitmedia.com.testscreeningbayuwpp.R;

/**
 * Created by Bayu WPP on 8/8/2017.
 */

public class GuestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Guest> guests;
    private static Context context;
    private static Activity activity;

    public GuestAdapter(ArrayList<Guest> guests, Context context) {
        this.context = context;
        this.activity = (Activity) context;
        this.guests = guests;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new GuestHolder(inflater.inflate(R.layout.adapter_guest, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GuestHolder) holder).bindData(guests.get(position));
    }

    @Override
    public int getItemCount() {
        return guests.size();
    }

    private class GuestHolder extends RecyclerView.ViewHolder {
        TextView textViewName;

        public GuestHolder(View inflate) {
            super(inflate);
            textViewName = (TextView) inflate.findViewById(R.id.adapterguest_textview_guestname);
            inflate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("guestName", guests.get(getAdapterPosition()).getName());
                    activity.setResult(Activity.RESULT_OK, intent);

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        date = format.parse(guests.get(getAdapterPosition()).getBirthdate());
                        int day = Integer.parseInt((String) DateFormat.format("dd", date));
                        int month = Integer.parseInt((String) DateFormat.format("MM", date));

                        if ((day % 2 == 0) && (day % 3 == 0)) {
                            Toast.makeText(context.getApplicationContext(), "iOS", Toast.LENGTH_SHORT).show();
                        } else if (day % 2 == 0) {
                            Toast.makeText(context.getApplicationContext(), "blackberry", Toast.LENGTH_SHORT).show();
                        } else if (day % 3 == 0) {
                            Toast.makeText(context.getApplicationContext(), "android", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context.getApplicationContext(), "feature phone", Toast.LENGTH_SHORT).show();
                        }

                        if(isPrimeMonth(month)){
                            Toast.makeText(context.getApplicationContext(), "Month is prime", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context.getApplicationContext(), "Month is not prime", Toast.LENGTH_SHORT).show();
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    activity.finish();

                }
            });
        }

        public void bindData(Guest guest) {
            textViewName.setText(guest.getName());
        }
    }

    public boolean isPrimeMonth(int month) {
        for (int i = 2; i < month; i++) {
            if (month % i == 0)
                return false;
        }
        return true;
    }
}
