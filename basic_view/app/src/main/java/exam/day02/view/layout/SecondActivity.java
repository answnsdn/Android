package exam.day02.view.layout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//Activity가 실행될 때 TextView의 문자열을 변경
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //뷰를 무조건 먼저 호출해야한다.
        TextView txt = findViewById(R.id.second_txtView);
        txt.setText("안녕");

    }
}
