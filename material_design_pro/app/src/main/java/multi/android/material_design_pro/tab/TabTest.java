package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;
import multi.android.material_design_pro.exam.ListTestFragment;
import multi.android.material_design_pro.exam.ViewFragment1;
import multi.android.material_design_pro.exam.ViewFragment3;

public class TabTest extends AppCompatActivity {
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    ViewPager examPager;
    ViewFragment1 viewFragment1;
    ListTestFragment viewFragment2;
    ViewFragment3 viewFragment3;
    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();

        tabLayout = findViewById(R.id.mytab);
        bottomNavigationView = findViewById(R.id.bottomNavi);

        //탭 추가
        tabLayout.addTab(tabLayout.newTab().setText("설정"));

        //처음 실행할 때 보여줄 프레그먼트 지정
        getSupportFragmentManager().beginTransaction().
                replace(R.id.content_container,viewFragment1).commit();

        //탭에 이벤트 연결하기
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment fragment = null;
                if(position==0){
                    fragment = viewFragment1;
                }else if(position==1){
                    fragment = viewFragment2;
                }else if(position==2){
                    fragment = viewFragment3;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //BottomNavigationView 이벤트 연결
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.bottom_item2){
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.content_container,viewFragment2).commit();
                }
                return false;
            }
        });

    }
}
