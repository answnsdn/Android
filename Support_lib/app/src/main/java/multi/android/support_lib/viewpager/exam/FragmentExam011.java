package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;

public class FragmentExam011 extends AppCompatActivity {
    ArrayList<Fragment> viewlist = new ArrayList<Fragment>();
    ViewPager examPager;
    ViewFragment1 viewFragment1;
    //ViewFragment2 viewFragment2;
    ListTestFragment viewFragment2;
    ViewFragment3 viewFragment3;
    MapFragment viewFragment4;
    //1. ViewPager에 표시할 뷰를 저장할 list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        examPager = findViewById(R.id.viewPager);

        //viewPager에 담을 프레그먼트 객체 생성
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();
        viewFragment4 = new MapFragment();
        //viewPager에 연결
        viewlist.add(viewFragment1);
        viewlist.add(viewFragment2);
        viewlist.add(viewFragment3);
        viewlist.add(viewFragment4);

        FragAdapter adapter =
                new FragAdapter(getSupportFragmentManager(),viewlist.size());
        examPager.setAdapter(adapter);
        examPager.addOnPageChangeListener(new PageListener());


    }
    public void btn_click(View v){
        examPager.setCurrentItem(Integer.parseInt(v.getTag().toString()));
    }
    class FragAdapter extends FragmentStatePagerAdapter {


        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return viewlist.get(position);
        }

        @Override
        public int getCount() {
            return viewlist.size();
        }
    }
    class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을 때
            Toast.makeText(FragmentExam011.this,
                    "페이지가 전환",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
