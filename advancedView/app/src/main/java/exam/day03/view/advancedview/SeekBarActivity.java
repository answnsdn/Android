package exam.day03.view.advancedview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeekBarActivity extends AppCompatActivity
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    // 뷰의 주소 값을 담을 참조변수
    SeekBar seek1, seek2;
    TextView text1, text2;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_main);

        seek1 = (SeekBar)findViewById(R.id.seekbar1);
        seek2 = (SeekBar)findViewById(R.id.seekbar2);
        text1 = (TextView)findViewById(R.id.seektxt1);
        text2 = (TextView)findViewById(R.id.seektxt2);
        btn1 = findViewById(R.id.seekBtn1);
        btn2 = findViewById(R.id.seekBtn2);
        btn3 = findViewById(R.id.seekBtn3);
        btn4 = findViewById(R.id.seekBtn4);

        //리스너 연결(=클릭이벤트 연결) this을 이용해 implements된 OnClickListener를 가지고 온다.
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        seek1.setOnSeekBarChangeListener(this);
        seek2.setOnSeekBarChangeListener(this);
        //SeekBarListener listener = new SeekBarListener();
       
    }


    @Override
    //버튼 클릭 시, 자동으로 호출되는 메소드
    //매개변수로 연결되는 View가 이벤트를 발생시키는 소스객체
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.seekBtn1:
                //값 증가
                seek1.incrementProgressBy(1);
                seek2.incrementProgressBy(1);
                break;
            case R.id.seekBtn2:
                //값 감소
                seek1.incrementProgressBy(-1);
                seek2.incrementProgressBy(-1);
                break;
            case R.id.seekBtn3:
                //값 설정
                seek1.setProgress(5);
                seek2.setProgress(7);
                break;
            case R.id.seekBtn4:
                //값 불러오기
                int value1=seek1.getProgress();
                text1.setText("seek1 : "+value1);
                text2.setText(seek2.getProgress()+"");
                break;
        }
    }

    @Override
    //SeekBar의 값이 변경되었을 때 호출되는 메소드
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int id = seekBar.getId();
        switch (id){
            case R.id.seekbar1:
                text1.setText("첫 번째 seekbar:"+progress);
                break;
            case R.id.seekbar2:
                text1.setText("두 번째 seekbar:"+progress);
                break;
        }
        if(fromUser){
            text2.setText("사용자가 변경");
        }else{
            text2.setText("코드로 변경");
        }
    }

    @Override
    //값을 변경하기 위해 seekbar에 터치를 시작할 때
    public void onStartTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();
        switch (id){
            case R.id.seekbar1:
                text1.setText("첫 번째 seekbar 터치 시작");
                break;
            case R.id.seekbar2:
                text1.setText("두 번째 seekbar 터치 시작");
                break;
        }
    }

    @Override
    //값 변경을 끝내고 seekbar에 터치를 끝낼 때
    public void onStopTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();
        switch (id){
            case R.id.seekbar1:
                text1.setText("첫 번째 seekbar 터치 종료");
                break;
            case R.id.seekbar2:
                text1.setText("두 번째 seekbar 터치 종료");
                break;
        }
    }
}









