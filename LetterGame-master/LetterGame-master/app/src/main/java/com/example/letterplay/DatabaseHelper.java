package com.example.letterplay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "test_results";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_RESULTS = "results";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_QUESTIONS = "questions";
    public static final String COLUMN_SELECTIONS = "selections";
    public static final String COLUMN_CORRECT_ANSWERS = "correct_answers";
    public static final String COLUMN_SCORE = "score";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_RESULTS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUESTIONS + " TEXT, " +
                COLUMN_SELECTIONS + " TEXT, " +
                COLUMN_CORRECT_ANSWERS + " TEXT, " +
                COLUMN_SCORE + " INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESULTS);
        onCreate(db);
    }

    public void addTestResult(String questions, String selections, String correctAnswers, int score) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTIONS, questions);
        values.put(COLUMN_SELECTIONS, selections);
        values.put(COLUMN_CORRECT_ANSWERS, correctAnswers);
        values.put(COLUMN_SCORE, score);
        db.insert(TABLE_RESULTS, null, values);
        db.close();
    }

    public Cursor getAllResults() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_RESULTS, null);
    }
}
