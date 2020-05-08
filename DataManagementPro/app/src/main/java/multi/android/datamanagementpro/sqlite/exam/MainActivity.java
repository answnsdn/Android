package multi.android.datamanagementpro.sqlite.exam;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.datamanagementpro.R;

public class MainActivity extends
		AppCompatActivity implements AdapterView.OnItemClickListener,OnClickListener {
	DBHandler handler;
	EditText edtName;
	EditText edtSu;
	EditText edtPrice;
	ListView listview;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		handler = new DBHandler();
		handler.open(this);

		findViewById(R.id.btnIns).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				handler.insert(edtName,edtPrice,edtSu);
				Toast.makeText(MainActivity.this,"삽입성공",Toast.LENGTH_LONG).show();
			}
		});
		findViewById(R.id.btnResult).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				handler.select(listview);
			}
		});
		findViewById(R.id.btnResult2).setOnClickListener(this);
		findViewById(R.id.btnSearch).setOnClickListener(this);
		listview = findViewById(R.id.list);
		listview.setOnItemClickListener(this);

		edtName = (EditText)findViewById(R.id.edtName);
		edtSu = (EditText)findViewById(R.id.edtSu);
		edtPrice = (EditText)findViewById(R.id.edtPrice);



	}


	@Override
	public void onClick(View v) {

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	}
}



















