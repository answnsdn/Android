package exam.day03.view.selectview.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

public class ViewHolder {
    ImageView ExamImg;
    TextView Name;
    TextView Date;
    TextView chkInfo;
    CheckBox checkBox;
    //객체가 생성될때 targetView(parentView)를 전달받는다.
 /*   public ViewHolder(View parentView) {
        this.ExamImg = parentView.findViewById(R.id.examimg);
        this.Name = parentView.findViewById(R.id.txt1);
        this.Date = parentView.findViewById(R.id.txt2);
        this.chkInfo = parentView.findViewById(R.id.chkinfo);
        this.checkBox = parentView.findViewById(R.id.chkbox);
    }*/
}
