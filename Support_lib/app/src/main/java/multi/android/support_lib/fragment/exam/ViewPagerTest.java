package multi.android.support_lib.fragment.exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import multi.android.support_lib.R;
/*
*  화면 전환을 위해서 ViewPager를 사용하는 경우(ListView와 동일)
*   1. ViewPager에 담을 데이터 - View, Fragment
*   2. Adapter 커스트마이징
*   3. ViewPager에 Adapter
* */
public class ViewPagerTest extends AppCompatActivity {
    //1. ViewPager에 표시할 뷰를 저장할 List
    ArrayList<View> viewlist = new ArrayList<View>();
    ViewPager myPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_test);
        myPager = findViewById(R.id.mainpager);

        //ViewPager에 담을 View객체를 생성
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.view1,null);
        View view2 = inflater.inflate(R.layout.view2,null);
        View view3 = inflater.inflate(R.layout.view3,null);
        viewlist.add(view1);
        viewlist.add(view2);
        viewlist.add(view3);

        //3.ViewPager에 어댑터 연결하기
        MainPagerAdapter adapter = new MainPagerAdapter();
        myPager.setAdapter(adapter);
    }
    class MainPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return viewlist.size();
        }

        //ViewPager에 보여줄 뷰를 등록 (getView와 같은 역할)
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            myPager.addView(viewlist.get(position));
            //isViewFromObject 메소드가 리턴값을 받아서 증명한 뒤 넘겨줌.
            return viewlist.get(position);
        }
        //매개변수로 전달된 뷰들끼리 비교
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            myPager.removeView((View)object);
        }
    }
}
