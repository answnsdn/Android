package multi.android.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    int progressVal;
    Handler handler1;
    Handler handler2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView2);

        //worker thread의 요청을 처리할 handler객체를 정의
        //handler의 하위객체를 익명으로 정의, 생성
        handler1 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                Log.d("mythread","handleMessage 요청");
                textView.setText("progressbar진행률 : "+progressVal+"%");
                progressBar.incrementProgressBy(1);
            }
        };

        handler2=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                //Log.d("mythread",msg.what+"");
                if(msg.what==1){
                    int val = msg.arg1;
                    textView.setText("progressbar진행률 : "+val+"%");
                    progressBar.incrementProgressBy(val);
                }
            }
        };

    }

    //화면을 변경하는 작업을 다른 메소드에서 처리
    //긴 시간동안 실행하며 View를 변경하려고 하는 경우 실행되는 동안 다른 작업 x
    //실행이 되는 동안 사용자의 이벤트 발생, 이벤트에 5초 동안 반응하지 않으면 os는
    //앱을 강제 종료한다. => ANR(Application Not Responding)
    //오랫동안 처리해야 하는 작업을 UI 쓰레드에 정의하면 안된다.
    //                             |_ 별도의 작업 쓰레드를 정의, 실행
    public void btnNoThread(){
        for(progressVal=1;progressVal<100;progressVal++){
            progressBar.setProgress(progressVal);
            SystemClock.sleep(1000);//1초동안 쉬게 만드는 작업
        }
    }
    //개발자가 만든 쓰레드 안에서 UI를 변경
    //  |_잠정적인 문제점을 갖고 있는 방법(UI의 변경은 UI쓰레드에서만 작업)
    public void useThread(View view){
        //Progress바에 진행상태가 출력되도록 설정
        //Progress바의 progress가 변경되는 것을 쓰레드로 만들어서 실행
        //개발자가 만든 쓰레드 - worker thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(progressVal=1;progressVal<100;progressVal++){
                    progressBar.setProgress(progressVal);
                    textView.setText("progressbar 진행률 : "+progressVal+"%");
                    SystemClock.sleep(1000);//1초동안 쉬게 만드는 작업
                }
            }
        }).start();
    }
    //작업쓰레드가 핸들러에게 View에 대한 변경을 요청
    //핸들러는 작업쓰레드로 부터 받은 요청정보를 꺼내서 뷰를 변경한다.
    public void useHandler(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(progressVal=1;progressVal<100;progressVal++){
                    //handler가 갖고 있는 Message객체를 매개변수로 전달하며
                    //작업을 의뢰하고 있다.
                    handler1.sendMessage(handler1.obtainMessage());
                    SystemClock.sleep(1000);//1초동안 쉬게 만드는 작업
                }
            }
        }).start();
    }

    //핸들러를 이용해서 UI변경 요청 - 작업쓰레드에서 값을 핸들러에게 넘기는 작업
    //핸들러에게 작업을 의뢰할 때 Message객체를 생성해서 전달
    public void useMessageHandler(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<100;i++){
                    //변경할 view의 정보나 Handler에게 전달한 데이터를
                    //Message객체로 생성한다.
                    Message msg = new Message();
                    //handler에게 작업을 의뢰한 쓰레드를 구분하기 위한 코드
                    msg.what=1;
                    msg.arg1 = i;//전달할 데이터
                    //Message객체를 전달하며 핸들러에게 작업을 의뢰
                    handler2.sendMessage(msg);
                    SystemClock.sleep(1000);//1초동안 쉬게 만드는 작업
                }
            }
        }).start();
    }
}
