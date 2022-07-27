package sg.edu.rp.c346.id21015463.demol09;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "playlist.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_SONG = "song";
    private static final String COLUMN_SONG_ID = "_id";
    private static final String COLUMN_SONG_TITLE = "song_title";
    private static final String COLUMN_SONG_SINGER = "song_singers";
    private static final int COLUMN_SONG_YEAR = Integer.parseInt("song_year");
    private static final int COLUMN_SONG_RATING = Integer.parseInt("song_rating");


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_SONG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SONG_TITLE + " TEXT ,"+ COLUMN_SONG_SINGER + " TEXT ,"
                + COLUMN_SONG_YEAR + "INT , "+ COLUMN_SONG_RATING +" INT) ";
        db.execSQL(createNoteTableSql);
        Log.i("info", "created tables");

        //Dummy records, to be inserted when the database is created
        for (int i = 0; i< 4; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_SONG_TITLE, "Song Title: " + i);
            db.insert(TABLE_SONG, null, values);
        }
        Log.i("info", "dummy records inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        db.execSQL("ALTER TABLE " + TABLE_SONG + " ADD COLUMN  module_name TEXT ");
        //onCreate(db);
    }

    public long insertSong(String songTitle, String songSinger
            , int songYear, int songStars) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SONG_TITLE, songTitle);
        values.put(COLUMN_SONG_SINGER, songSinger);
        values.put(String.valueOf(COLUMN_SONG_YEAR), songYear);
        values.put(String.valueOf(COLUMN_SONG_RATING), songStars);
        long result = db.insert(TABLE_SONG, null, values);
        db.close();
        Log.d("SQL Insert","Result"+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Song> getAllSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns= {COLUMN_SONG_ID, COLUMN_SONG_TITLE, COLUMN_SONG_SINGER, String.valueOf(COLUMN_SONG_YEAR), String.valueOf(COLUMN_SONG_RATING)};
        Cursor cursor = db.query(TABLE_SONG, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String songTitle = cursor.getString(1);
                String songSinger = cursor.getString(2);
                int songYear = cursor.getInt(3);
                int songStars = cursor.getInt(4);
                Song x = new Song(id, songTitle, songSinger, songYear, songStars);
                songs.add(x);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }
}
