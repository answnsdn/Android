package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Binder;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FrameTestActivity extends AppCompatActivity {
    LinearLayout loginview;
    LinearLayout joinview;
           LinearLayout detailview;
           @Override
           protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_frame_test);
               loginview = findViewById(R.id.login);
               joinview = findViewById(R.id.join);
               detailview = findViewById(R.id.detail);

           }
           //버튼이 많으므로 클릭할 때 호출되는 메소드를 만들어준다.
           public void myclick(View v){
            if(v.getId()==R.id.loginbtn){
                loginview.setVisibility(View.VISIBLE);
                joinview.setVisibility(View.INVISIBLE);
                detailview.setVisibility(View.INVISIBLE);
            }else if(v.getId()==R.id.joinbtn){
            loginview.setVisibility(View.INVISIBLE);
            joinview.setVisibility(View.VISIBLE);
            detailview.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.detailbtn){
            loginview.setVisibility(View.INVISIBLE);
            joinview.setVisibility(View.INVISIBLE);
            detailview.setVisibility(View.VISIBLE);
        }

    }
}
