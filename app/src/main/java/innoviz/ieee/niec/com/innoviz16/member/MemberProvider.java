package innoviz.ieee.niec.com.innoviz16.member;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import innoviz.ieee.niec.com.innoviz16.dbs.MemberHelper;

/**
 * Created by PROPHET on 13-02-2016.
 */
public class MemberProvider extends ContentProvider {
    /********************
     * CONTENT PROVIDER STUFF
     *************************/
    private static final String AUTHORITY = "com.niec.iee.innoviz";
    private static final String BASE_PATH = "innoviz/ieee/niec/com/innoviz16/member";

    public static final Uri CONTENT_URI=Uri.parse("content://"+ AUTHORITY + "/" + BASE_PATH);

    private static final int MEM=1;
    private static final int MEM_ID=2;

    private static final UriMatcher urimatcher= new UriMatcher(UriMatcher.NO_MATCH);

    static {
        urimatcher.addURI(AUTHORITY,BASE_PATH ,MEM);
        urimatcher.addURI(AUTHORITY,BASE_PATH + "/#" ,MEM_ID);

    }

public SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        MemberHelper helper= new MemberHelper(getContext());
        database=helper.getWritableDatabase();
        Log.d("DB CREATED :","BATABASE CREATION SUCCESFUL");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        return database.query(MemberHelper.TABLE_NAME,MemberHelper.MEMBER_COLUMNS
                ,selection,null,null,null,MemberHelper.MEMBER_CREATION_DATE + " DESC");

    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id=database.insert(MemberHelper.TABLE_NAME,null,values);
        return Uri.parse(BASE_PATH+ "/"+id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
     return database.delete(MemberHelper.TABLE_NAME,selection,selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return database.update(MemberHelper.TABLE_NAME,values,selection,selectionArgs);
    }
}
