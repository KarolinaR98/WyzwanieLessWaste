package com.example.wyzwanielesswaste;

import android.content.ContentValues;
import android.database.sqlite.SQLiteAbortException;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class MyDBHandler extends SQLiteOpenHelper{

    public static final int DB_VERSION = 3;
    private static final String DB_NAME = "DATABASE.db";
    private static final String DB_PATH = "/data/data/com.example.wyzwanielesswaste/databases/";
    SQLiteDatabase myDataBase;
    private static Context mContext;


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private boolean checkDatabase(){
        try{
            final String mPath = DB_PATH + DB_NAME;
            final File file = new File(mPath);
            if(file.exists()){
                return true;
            }
            else {
                return false;
            }
        }catch (SQLiteException e){
            e.printStackTrace();
            return false;
        }

    }

    private void copyDatabase() throws IOException{
        try{
            InputStream mInputStream = mContext.getAssets().open(DB_NAME);
            String outFileName = DB_PATH + DB_NAME;
            OutputStream mOutputStream = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int length;
            while((length = mInputStream.read(buffer)) > 0){
                mOutputStream.write(buffer, 0, length);
            }
            mOutputStream.flush();
            mOutputStream.close();
            mInputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createDatabase() throws IOException{
        boolean mDatabaseExist = checkDatabase();
        if(!mDatabaseExist){
            this.getReadableDatabase();
            this.close();
            try{
                copyDatabase();

            }catch(IOException mIOException){
                mIOException.printStackTrace();
                throw new Error("Error copying DB ");
            }finally {
                this.close();
            }
        }
    }

    @Override
    public synchronized void close(){
        if(myDataBase != null){
            myDataBase.close();
        }
        SQLiteDatabase.releaseMemory();
        super.close();
    }

    public String loadHandlerTitle(int id){
        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Notifications WHERE id ='"+id+"'", null);

        while (c.moveToNext()){
            String result_Title = c.getString(1);
            result += result_Title;
        }
        c.close();
        db.close();

        return result;

    }

    public String loadHandlerText(int id){
        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Notifications WHERE id ='"+id+"'", null);

        while (c.moveToNext()){
            String result_Text = c.getString(2);
            result += result_Text;
        }
        c.close();
        db.close();

        return result;
    }

    public String loadChallengeTitle(int id){
        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Levels WHERE id = '"+id+"'", null);

        while (c.moveToNext()){
            String result_Text = c.getString(1);
            result += result_Text;
        }
        c.close();
        db.close();

        return result;
    }

    public String loadChallengeContent(int id){
        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Levels WHERE id = '"+id+"'", null);

        while (c.moveToNext()){
            String result_Text = c.getString(2);
            result += result_Text;
        }
        c.close();
        db.close();

        return result;
    }

    public String loadChallenge(int id){
        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Levels WHERE id = '"+id+"'", null);

        while (c.moveToNext()){
            String result_Text = c.getString(3);
            result += result_Text;
        }
        c.close();
        db.close();

        return result;
    }

    public String loadChallengeNotificationRow1(int id){
        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM ChallengeForWeek WHERE id = '"+id+"'", null);

        while (c.moveToNext()){
            String result_Text = c.getString(1);
            result += result_Text;
        }
        c.close();
        db.close();

        return result;
    }

    public String loadChallengeNotificationRow2(int id){
        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM ChallengeForWeek WHERE id = '"+id+"'", null);

        while (c.moveToNext()){
            String result_Text = c.getString(2);
            result += result_Text;
        }
        c.close();
        db.close();

        return result;
    }

    public boolean updateScore(float score, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Score", score);
        long result = db.update("Scores", contentValues, "id = ?", new String[] {String.valueOf(id)});
        db.close();
        return result > 0;
    }



    public float loadChallengeScore(int id){
        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        float result = 0 ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Scores WHERE id = '"+id+"'", null);

        while (c.moveToNext()){
            float result_Float = c.getFloat(2);
            result = result_Float;
        }
        c.close();
        db.close();

        return result;
    }
}
