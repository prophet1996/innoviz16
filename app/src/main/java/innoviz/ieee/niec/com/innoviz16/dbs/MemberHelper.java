package innoviz.ieee.niec.com.innoviz16.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PROPHET on 13-02-2016.
 */
public class MemberHelper extends SQLiteOpenHelper {
    /******************DATABASE STUFF**************************/
    private static final  String DATAABASE_NAME="innoviz.ieee.niec.com.innoviz16.member.db";
    private static final  int DATAABASE_VERSION=1;
    public static final  String TABLE_NAME= "innoviz/ieee/niec/com/innoviz16/member";

    /**********************COLUMNS******************************/
    public static final String MEMBER_ID="id";
    public static final String MEMBER_NAME="mem_name";
    public final static String MEMBER_EMAIL="mem_email";
    public  final static String MEMBER_CONTACT="mem_contact";
    public final static String MEMBER_CREATION_DATE="mem_created";
    public final static String[] MEMBER_COLUMNS={MEMBER_ID,MEMBER_NAME,MEMBER_EMAIL,MEMBER_CONTACT,MEMBER_CREATION_DATE};

    /************************COMMANDS****************************/
    private static final String CREATE_MEMBER="CREATE TABLE " +
            TABLE_NAME + " (" + MEMBER_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MEMBER_NAME + " TEXT, " +
            MEMBER_EMAIL + " TEXT, " +
            MEMBER_CONTACT + " TEXT, " +
            MEMBER_CREATION_DATE + " TEXT default CURRENT_TIMESTAMP);";
    /*************************CONSTRUCTOR************************/
    public MemberHelper(Context context){
        super(context,DATAABASE_NAME,null,DATAABASE_VERSION);
    }


    /**********************overrides*****************************/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MEMBER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
