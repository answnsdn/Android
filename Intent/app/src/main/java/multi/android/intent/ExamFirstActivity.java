package multi.android.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ExamFirstActivity extends AppCompatActivity {
    public static final int DATA_INTENT = 1001;
    public static final int OBJECT_INTENT = 1002;
    TextView result;
    TextView name;
    TextView pass;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstexam);
        final Button putbtn = findViewById(R.id.Button01);
        name = findViewById((R.id.EditText01));
        pass = findViewById(R.id.EditText02);
        btn2 = findViewById(R.id.Button02);
        result = findViewById(R.id.first_return);



        putbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //명시적 Intent
                Intent intent = new Intent(ExamFirstActivity.this,
                        ExamSecondActivity.class);
                //putExtra는 getText객체를 반환하지 못한다.
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("pass",pass.getText().toString());
                startActivityForResult(intent,DATA_INTENT);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamFirstActivity.this,
                        ExamSecondActivity.class);
                User dto = new User(name.getText().toString(),pass.getText().toString());
                intent.putExtra("dto",dto);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode==DATA_INTENT){
            if(resultCode==RESULT_OK){
                boolean state = intent.getBooleanExtra("chkVal",false);
                if(state){
                    result.setText("우수회원설정");
                }else{
                    result.setText("일반회원설정");
                }
            }
        }
    }
}
