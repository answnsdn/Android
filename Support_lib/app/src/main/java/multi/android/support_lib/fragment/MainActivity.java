package multi.android.support_lib.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;


public class MainActivity extends AppCompatActivity {
    //화면에 연결할 프레그먼트 객체를 생성
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnFirst = findViewById(R.id.btnAddFrag);
        Button btnRemove = findViewById(R.id.btnRemoveFrag);
        Button btnSecond = findViewById(R.id.btnSecondFrag);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("first");
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("remove");
            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("second");
            }
        });

    }
    public void setFragment(String name){
        //fragment객체를 관리하는 관리자 객체를 가져온다.
        FragmentManager fragmentManager = getSupportFragmentManager();
        //fragment작업을 시작하기 위한 트랜젝션객체를 구한다.
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (name){
            case "first":
                //지정한 fragment로 특정영역을 교체하는 작업
                transaction.replace(R.id.container,firstFragment);
                break;
            case "remove":
                //remove : firstFragment를 안 보이도록 작업
                // <=> detach()를 사용하면 다시 replace 못함.
                transaction.remove(firstFragment);
                break;
            case "second":
                transaction.replace(R.id.container,secondFragment);

        }
        //transaction.commitNow(); - 지금 당장 처리 요청
        transaction.commit(); //스케줄 고려해서 적당한 시기에 변경 요청을 의뢰
    }
  
}
