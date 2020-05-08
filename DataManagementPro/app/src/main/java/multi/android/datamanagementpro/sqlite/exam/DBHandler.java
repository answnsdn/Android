package multi.android.datamanagementpro.sqlite.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

import multi.android.datamanagementpro.R;
import multi.android.datamanagementpro.sqlite.DBHelper;

public class DBHandler {

    ExamDBHelper examDBHelper;
    SQLiteDatabase examdb;

    public void open(Context context) {
        examDBHelper = new ExamDBHelper(context);
        examdb = examDBHelper.getWritableDatabase();
    }


    public void insert(EditText edtName, EditText edtSu, EditText edtPrice){
        Integer totPrice = Integer.parseInt(edtPrice.getText().toString()) *
                Integer.parseInt(edtPrice.getText().toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",edtName.getText().toString());
        contentValues.put("price",edtPrice.getText().toString());
        contentValues.put("su",edtSu.getText().toString());
        contentValues.put("totPrice",totPrice);

        examdb.insert("product",null,contentValues);
    }

    public void select(){

        Cursor cursor = examdb.query("product",null,null,
                                null,null,null,null,null);
            while(cursor.moveToNext()){
                int index = cursor.getInt(0);
                String name = cursor.getString(1);
                int price = cursor.getInt(2);
            }

        }

    }

