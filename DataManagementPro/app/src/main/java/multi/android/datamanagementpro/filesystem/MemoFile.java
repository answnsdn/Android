package multi.android.datamanagementpro.filesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.security.spec.EncodedKeySpec;

import multi.android.datamanagementpro.R;

public class MemoFile extends AppCompatActivity {
    boolean permission_state;
    EditText Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_file);

        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};
        for (int i=0;i<permissions.length;i++){
            if(ContextCompat.checkSelfPermission(this,permissions[i])
                    == PackageManager.PERMISSION_GRANTED){
                permission_state = true;
            }else{
                permission_state = false;
                ActivityCompat.requestPermissions(this,permissions,1000);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1000 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                permission_state = true;
                Toast.makeText(this,"권한설정완료",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"권한설정거부",Toast.LENGTH_LONG).show();
            }
        }
    }
    public void ReadFile(View v){
        Text = findViewById(R.id.Text);
        if(permission_state){
            String state = Environment.getExternalStorageState();
            if(state.equals(Environment.MEDIA_MOUNTED)){
                Toast.makeText(this,"읽기권한 설정완료",Toast.LENGTH_LONG).show();
                File external = Environment.getExternalStorageDirectory();
                String dirPath = external+"/mynote";
                File dir = new File(dirPath);
                FileReader fr = null;
                try {
                    fr = new FileReader(dir+"20200410_memo.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    while((s=br.readLine())!=null){
                        s = s+br.readLine();
                    }
                    Text.setText(s);
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    try {
                        if(fr!=null){
                            fr.close();
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            Toast.makeText(this,"읽어오기 완료",Toast.LENGTH_LONG).show();
        }
    }

    public void SaveFile(View v){
        Text = findViewById(R.id.Text);
        if(permission_state){
            String state = Environment.getExternalStorageState();
            if(state.equals(Environment.MEDIA_MOUNTED)){
                Toast.makeText(this,"저장권한 설정완료",Toast.LENGTH_LONG).show();
                File external = Environment.getExternalStorageDirectory();
                String dirPath = external.getAbsolutePath()+"/mynote";
                File dir = new File(dirPath);
                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir+"20200410_memo.txt");
                    fw.write(Text.getText().toString());

                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    try {
                        if(fw!=null){
                            fw.close();
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            Toast.makeText(this,"저장하기 완료",Toast.LENGTH_LONG).show();

        }
    }
    public void Reset(View v){
        Text = findViewById(R.id.Text);
        Text.setText("");
    }
}
