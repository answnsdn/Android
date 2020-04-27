package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Activity의 LifeCycle(실행순서) 이해하기

    //1. onCreate : Activity가 생성될 때 자동으로 호출된다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Oncreate 호출 ~~");
        Log.d("test","onCreate()호출");
        setContentView(R.layout.activity_main);
    }

    //실행1. Activity 실행 1단계 cf) pause상태에서 빠져나올 때는 onCreate실행 X, 1번으로 실행
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","onstart()호출");
    }

    //실행2. Activity 실행 2단계
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test","onResume()호출");
    }

    //정지1. Activity 일시정지 1단계
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause()호출");

    }
    //정지2. Activity 일시정지 2단계
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop()호출");
    }
    //종료1. Activity 종료
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","onDestroy()호출");
    }



    //버튼을 클릭했을 때 실행할 메소드 정의
    //메소드의 매개변수에 실행할 버튼을 정의
    //Button의 상위인 View타입으로 정의
    public void myclickMethod(View v) {
        Toast.makeText(this,
                "확인버튼이 눌려졌습니다.",
                Toast.LENGTH_LONG).show();
    }

    public void cancelMethod(View v){
        Toast.makeText(this,
                "취소버튼이 눌려졌습니다.",
                Toast.LENGTH_SHORT).show();
    }

    public void removeMethod(View v){
        Toast.makeText(this,
                "삭제버튼이 눌려졌습니다.",
                Toast.LENGTH_LONG).show();
    }

}
