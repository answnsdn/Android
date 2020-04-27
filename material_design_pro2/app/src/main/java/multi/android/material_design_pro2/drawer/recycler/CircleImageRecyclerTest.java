package multi.android.material_design_pro2.drawer.recycler;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_exam);
        list = findViewById(R.id.list);

        //1. Recycler에 출력할 데이터 준비
        List<CircleItem> recycler_data = new ArrayList<CircleItem>();
        CircleItem[] item = new CircleItem[5];
        item[0] = new CircleItem(R.drawable.gong);
        item[1] = new CircleItem(R.drawable.lee);
        item[2] = new CircleItem(R.drawable.jang);
        item[3] = new CircleItem(R.drawable.jung);
        item[4] = new CircleItem(R.drawable.so);
        for(int i=0;i<item.length;i++){
            Log.d("thihjjhjh", "onCreate: "+item[i]);
            recycler_data.add(item[i]);
        }




        //2. Adapter생성
        RecyclerCircleAdapter adapter =
                new RecyclerCircleAdapter(this,R.layout.circle_item,recycler_data);
        //3. Recycler에 레이아웃을 설정 : RecyclerView에 설정할 레이아웃객체 생성
        /*LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);*/
        //GridLayout활용하기
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);
        //list.setHasFixedSize(true);
        list.setLayoutManager(manager);
        //4. Recycler와 adapter를 연결
        list.setAdapter(adapter);
        //5. 추가적인 요소들을 적용할 수 있다. - 꾸미기, 애니메이션
    }
}
