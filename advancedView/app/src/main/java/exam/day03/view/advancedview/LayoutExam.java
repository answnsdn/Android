package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//이벤트가 발생했을 때 처리할 객체 생성 - 이벤트 ex) Button을 클릭했을 때
    //1. 이벤트에 반응하는 클래스를 상속받는다.
//2. 메소드를 오버라이딩한다.
// EX] 버튼을 클릭했을 때
//      실행될 리스너 -> View.OnClickListener의 onClick메소드가 호출
    public class LayoutExam extends AppCompatActivity implements View.OnClickListener {
        ImageView first;
        ImageView second;
        Button btnfirst;
        Button btnsecond;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_layout_exam);
            first = findViewById(R.id.firstimg);
            second = findViewById(R.id.secondimg);
            btnfirst = findViewById(R.id.btnup);
            btnsecond = findViewById(R.id.btndown);
            //setOnClickListener 메소드를 이용해서 이벤트가 발생했을 때
            //처리하는 기능이 구현된 리스너객체가 어떤 것인지 등록
            btnfirst.setOnClickListener(this);
            btnsecond.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        Log.d("myevent","이벤트가 발생됨. 처리");
        if(v.getId()==R.id.btnup){
            imageUp();
        }else if(v.getId()==R.id.btndown){
            imageDown();
        }
    }

    public void imageDown(){
            //ImageView에 이미지리소스 추가
            second.setImageResource(R.drawable.beach);
            first.setImageResource(0);
            //setImageResource메소드를 이용해서 이미지를 변경했다 하더라도
            //화면 갱신이 자동으로 되지 않기 때문에 변경되지 않는다.
            //애니메이션을 적용하는 경우는 실시간 반영이 되어야 하므로 갱신해야한다.
            second.invalidate();
            first.invalidate();
    }
    public void imageUp(){
        //ImageView에 이미지리소스 추가
        first.setImageResource(R.drawable.beach);
        second.setImageResource(0);
        //setImageResource메소드를 이용해서 이미지를 변경했다 하더라도
        //화면 갱신이 자동으로 되지 않기 때문에 변경되지 않는다.
        //애니메이션을 적용하는 경우는 실시간 반영이 되어야 하므로 갱신해야한다.
        second.invalidate();
        first.invalidate();
    }

}
