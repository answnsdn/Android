package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img01;
    ImageView img02;
    int index; //초기값을 준다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img01 = findViewById(R.id.img01);

        img02 = findViewById(R.id.img02);
    }


    public void myclick(View v){
        //버튼이 클릭될 때 호출되는 메소드
        imageChange();
    }
    public void imageChange(){
        //버튼을 선택할 때마다 이미지가 교체되어 보이도록 구현하기
        if(index==0){//0번에 해당하는 이미지를 화면에 출력하도록 설정
            img01.setVisibility(View.VISIBLE);
            //액티비티에서 img01이 invisible로 설정되어 있으므로
            //0번일 때 img01은 화면에 보이지 않도록 설정
            img02.setVisibility(View.INVISIBLE);
            Log.d("value","현재index값 => "+index);
            index=1;//버튼을 클릭하면 1번 이미지(img02)를 출력한다.
        }else if(index==1){
            img02.setVisibility(View.VISIBLE);
            img01.setVisibility(View.INVISIBLE);
            Log.d("value","현재index값 => "+index);
            index=0;//버튼을 클릭하면 0번 이미지(img01)를 출력한다.
        }
    }
}
