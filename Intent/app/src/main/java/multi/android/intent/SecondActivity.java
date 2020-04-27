package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Button bt2 = findViewById(R.id.bt2);
        //Intent 객체 추출
        Intent intent = getIntent();
        //Intent 객체에서 공유된 값을 꺼내기
        String msg = intent.getStringExtra("info");
        int data = intent.getIntExtra("num",0);
        Toast.makeText(this,"추출값"+msg+","+data,Toast.LENGTH_LONG).show();
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//액티비티 종료
            }
        });
    }
}
