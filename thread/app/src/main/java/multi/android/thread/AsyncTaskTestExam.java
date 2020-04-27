package multi.android.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AsyncTaskTestExam extends AppCompatActivity {
    TextView view1;
    ImageView view2;
    Button btn1;
    Button btn2;
    ProgressBar prg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);
        view1 = findViewById(R.id.textView);
        view2 = findViewById(R.id.imageView);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        prg = findViewById(R.id.progressBar);

    }
    public void ck_bt(View view){
        AsyncTaskExam asyncTaskExam = new AsyncTaskExam();
        asyncTaskExam.execute();
    }

    class AsyncTaskExam extends AsyncTask<Integer,Long,Integer>{
        @Override
        protected void onPreExecute() {
            btn1.setEnabled(false);
            btn2.setEnabled(true);//취소
            prg.setMax(50);
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int sum = 0;
            for(int i=0;i<=50;i++){
                sum = sum + i;
            }
            return sum;
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(Integer s) {
            super.onPostExecute(s);
        }
    }
   
}
