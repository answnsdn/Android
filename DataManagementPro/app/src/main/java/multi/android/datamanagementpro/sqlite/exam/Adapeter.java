package multi.android.datamanagementpro.sqlite.exam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import multi.android.datamanagementpro.R;


public class Adapeter extends ArrayAdapter<User> {
    private Context context;
    private int resId;
    private ArrayList<User> datalist;

    public Adapeter(Context context, int resId, ArrayList<User> datalist) {
        super(context, resId, datalist);
        this.context = context;
        this.resId = resId;
        this.datalist = datalist;
    }
    //리스트 개수를 반환
    @Override
    public int getCount() {
        return datalist.size();
    }
    //매개변수로 전달받은 순서에 있는 리스트 항목을 반환
    @Override
    public User getItem(int position) {
        return datalist.get(position);
    }
    //리스트의 한 항목을 만들 때 호출되는 메소드 - 항목이 100개면 100번 호출
    //position : 리스트 순서
    //convertView : 한 항목에 대한 뷰
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        //뷰를 생성(위에서 정의한 resId)
        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(resId,null);

        //ArrayList에서 리턴된 리스트 항목의 번호와 동일한 데이터를 구하기
        User user = datalist.get(position);
        //위에서 생성한 뷰와 각 요소에 데이터를 연결
        TextView textView = convertView.findViewById(R.id.list);
        textView.setText(user.index);
        textView.setText(user.name);
        textView.setText(user.price);

        return convertView;
    }
}