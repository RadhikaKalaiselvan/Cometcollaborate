package com.example.radhikakalaiselvan.cometcollaborate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by radhikakalaiselvan on 11/09/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="CC.DB";
    public static final int DB_VERSION=1;
    public static final String USER_TABLE="users";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_PASS="password";
    public static final String TAG=DBHelper.class.getSimpleName();


    public static final String CREATE_TABLE_USERS = "CREATE TABLE "+ USER_TABLE +" ( "+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "+ COLUMN_EMAIL +" TEXT,"+" "+ COLUMN_PASS + " TEXT )";
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    public DBHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);

            SQLiteDatabase db=this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(CREATE_TABLE_USERS);
        addDummyData();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS "+USER_TABLE);
        onCreate(db);

    }

    public boolean getUser(String email, String pass) {
        SQLiteDatabase db=this.getReadableDatabase();
        String select_query="select * from "+USER_TABLE+" where "+COLUMN_EMAIL+"="+"'"+email+"'"+" and "+COLUMN_PASS+"='"+pass+"'";
        Log.d(TAG," Get User Query "+select_query);
        Cursor cursor=db.rawQuery(select_query,null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    public void addDummyData(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(CREATE_TABLE_USERS);
        ContentValues values=new ContentValues();
        values.put(COLUMN_EMAIL,"info2radhu@gmail.com");
        values.put(COLUMN_PASS,"Rad10");
        long id=db.insert(USER_TABLE,null,values);
        ContentValues values1=new ContentValues();
        values.put(COLUMN_EMAIL,"rxk162030@utdallas.edu");
        values.put(COLUMN_PASS,"Rad10");
        long id1=db.insert(USER_TABLE,null,values1);
        ContentValues values2=new ContentValues();
        values.put(COLUMN_EMAIL,"test@gmail.com");
        values.put(COLUMN_PASS,"test123");
        long id2=db.insert(USER_TABLE,null,values2);

        db.close();
        Log.d(TAG," user inserted "+id);
    }

    /*
    public String[] getProfessorDetails(String snamemail, String pname) {
        SQLiteDatabase db=this.getReadableDatabase();
        String[] result=new String[2];
        String select_query="select * from "+PROFESSORDETAILS+" where "+NAME+"="+"'"+pname+"'"+" and "+SCHOOLNAME+"='"+sname+"'";
        Cursor cursor=db.rawQuery(select_query,null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }*/
}
