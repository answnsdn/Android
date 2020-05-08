package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextTestActivity extends AppCompatActivity {
    //layout페이지에서 사용할 뷰에 대한 리소스를 가져와야 하므로 변수 선언
    EditText inputtxt;
    TextView labletxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_test);
        labletxt = findViewById(R.id.myinfo);
        inputtxt = findViewById(R.id.mytext);

        Button btngetter = findViewById(R.id.btnget);
        Button btnsetter = findViewById(R.id.btnset);
        btngetter.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String msg = inputtxt.getText()+"";
            labletxt.setText(msg);
        }
    });
        btnsetter.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            inputtxt.setText("가져온 문자열:작업완료");
        }
    });
}
}
