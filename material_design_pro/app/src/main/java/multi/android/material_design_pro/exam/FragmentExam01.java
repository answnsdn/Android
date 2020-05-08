package multi.android.material_design_pro.exam;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;

public class FragmentExam01 extends AppCompatActivity {
    ArrayList<Fragment> viewlist = new ArrayList<Fragment>();
    ArrayList<String> tablist = new ArrayList<String>();
    TabLayout tabLayout;
    ViewPager examPager;
    ViewFragment1 viewFragment1;
    ViewFragment2 viewFragment2;
    ViewFragment3 viewFragment3;
    //1. ViewPager에 표시할 뷰를 저장할 list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        examPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setTabTextColors(Color.BLACK,Color.GRAY);


        //viewPager에 담을 프레그먼트 객체 생성
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ViewFragment2();
        viewFragment3 = new ViewFragment3();

        //viewPager에 연결
        viewlist.add(viewFragment1);
        viewlist.add(viewFragment2);
        viewlist.add(viewFragment3);

        for(int i=1;i<=viewlist.size();i++){
            tablist.add(i+"번째 탭");
        }



        FragAdapter adapter =
                new FragAdapter(getSupportFragmentManager(),viewlist.size());
        examPager.setAdapter(adapter);
        examPager.addOnPageChangeListener(new PageListener());

        tabLayout.setupWithViewPager(examPager);


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

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tablist.get(position);
        }
    }
    class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을 때
            Toast.makeText(FragmentExam01.this,
                    "페이지가 전환",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
