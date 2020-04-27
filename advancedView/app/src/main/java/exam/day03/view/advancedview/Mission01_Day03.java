package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Mission01_Day03 extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission01__day03);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
    }

    public void upclick(View v){
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.INVISIBLE);
    }
    public void downclick(View v){
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.VISIBLE);
    }

}
