package multi.android.support_lib.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import multi.android.support_lib.R;

public class FragmentTestMain2 extends AppCompatActivity {
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test_main2);
        Log.d("lifecycle","Activity****의 onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","Activity****의 onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","Activity****의 onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","Activity****의 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","Activity****의 onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","Activity****의 onDestroy");
    }

    public void first_click(View v){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,firstFragment);
        //프레그먼트는 액티비티의 lifecycle에 종속적이나 액티비티처럼 동작할 수 있도록
        //backstack에 등록할 수 있다.
        transaction.addToBackStack("first");
        transaction.commit();
    }
    //1. add 메소드를 이용하면 프레그먼트 객체를 생성한다.
    // => 똑같은 객체는 한 개만 생성할 수 있다.
    // => LinearLayout에 추가하면 레이아웃의 특성상 영역 바깥으로 추가되어 보이지 않는다.
    //2. replace는 있으면 있는 객체를 연결, 없으면 새로 생성해서 연결
    public void second_click(View v){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,secondFragment);
        transaction.addToBackStack("second");
        transaction.commit();

    }
}
