package multi.android.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerExam extends AppCompatActivity {
    TextView textView;
    Button button;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_exam);
        textView = findViewById(R.id.numview);
        //button = findViewById(R.id.btn);

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if(msg.what==1){
                    int val = msg.arg1;
                    textView.setText("진행진행 : "+val);
                }
            }
        };
    }
    public void Handler(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<=10;i++){
                    Message msg = new Message();
                    msg.what=1;
                    msg.arg1=i;
                    handler.sendMessage(msg);
                    SystemClock.sleep(500);
                }
            }
        }).start();
    }
}
