package multi.android.support_lib.viewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;
import multi.android.support_lib.viewpager.exam.ViewFragment1;
import multi.android.support_lib.viewpager.exam.ViewFragment2;
import multi.android.support_lib.viewpager.exam.ViewFragment3;

/*
*  화면 전환을 위해서 ViewPager를 사용하는 경우(ListView와 동일)
*   1. ViewPager에 담을 데이터 - View, Fragment
*   2. Adapter 커스트마이징
*   3. ViewPager에 Adapter
* */
public class ViewPagerTest extends AppCompatActivity {
    //1. ViewPager에 표시할 뷰를 저장할 List
    ArrayList<Fragment> viewlist = new ArrayList<Fragment>();
    ViewPager examPager;
    ViewFragment1 viewFragment1;
    ViewFragment2 viewFragment2;
    ViewFragment3 viewFragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        examPager = findViewById(R.id.viewPager);

        //viewPager에 담을 프레그먼트 객체 생성
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ViewFragment2();
        viewFragment3 = new ViewFragment3();
        //viewPager에 연결
        viewlist.add(viewFragment1);
        viewlist.add(viewFragment2);
        viewlist.add(viewFragment3);

    }

}
