package suitmedia.com.testscreeningbayuwpp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Bayu WPP on 8/9/2017.
 */

public class CacheSqlLite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_screeningapp.db";
    private static final int DATABASE_VERSION = 1;

    public CacheSqlLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE guest(id integer primary key, name text null, birthdate text null);";
        Log.e("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
