package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ExamSecondActivity extends AppCompatActivity {
    Button ok;
    TextView result;
    CheckBox memberState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_secondview);
        result = findViewById(R.id.exam_result_txt);
        ok = findViewById(R.id.exam_close);
        memberState = findViewById(R.id.member_state);

        final Intent intent = getIntent();
        String id = intent.getStringExtra("name");
        if(id==null){
            User dto = intent.getParcelableExtra("dto");
            result.setText(dto.name+","+dto.telNum);
        }else{
            String pass = intent.getStringExtra("pass");
            result.setText("입력한 id:"+id+"입력한 pass:"+pass);
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //isChecked()하면 First뷰에 Boolean값으로 넘어감
                intent.putExtra("chkVal",memberState.isChecked());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
