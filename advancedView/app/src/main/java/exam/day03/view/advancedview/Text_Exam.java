package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Text_Exam extends AppCompatActivity {
    EditText inserttxt;
    TextView viewtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text__exam);
        inserttxt = findViewById(R.id.edittxt);
        viewtxt = findViewById(R.id.textexam);
        Button insertbtn = findViewById(R.id.insertbtn);
        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = inserttxt.getText()+"\n";
                viewtxt.append(msg);
                inserttxt.setText("");
            }
        });
        //EditText에서 데이터를 입력할 때 이벤트 발생
        watcherListener listener = new watcherListener();
        inserttxt.addTextChangedListener(listener);
    }
    //TextChanged이벤트를 처리하는 리스너 작성
    class watcherListener implements TextWatcher{
        //1. 문자값이 변경되기 전에 호출
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        //2. 문자값이 변경되었을 때 호출
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            viewtxt.setText("문자열이 변경되고 있습니다."+s);
        }
        //3. 문자값이 변경된 후에 호출
        @Override
        public void afterTextChanged(Editable s) {

        }
    }

}


