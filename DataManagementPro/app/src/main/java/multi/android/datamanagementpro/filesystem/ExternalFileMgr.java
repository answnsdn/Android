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
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class ExternalFileMgr extends AppCompatActivity {
    Button btn;
    boolean permission_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file_mgr);

                if(ContextCompat.checkSelfPermission(ExternalFileMgr.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    permission_state = true;
                    Toast.makeText(ExternalFileMgr.this,"권한 설정 완료.",Toast.LENGTH_LONG).show();
                }else{
                    permission_state = false;
                    Toast.makeText(ExternalFileMgr.this,"권한 설정하세요.",Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions(ExternalFileMgr.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1001);
                }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1001 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"권한 설정 완료",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"권한 설정이 필요합니다.",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void saveExternalFileSystem(View v){
        if(permission_state){
            Toast.makeText(this,"권한설정완료",Toast.LENGTH_LONG).show();
            //외부저장소를 사용할 수 있는지 state를 추출
            String state = Environment.getExternalStorageState();
            if(state.equals(Environment.MEDIA_MOUNTED)){//사용 가능한 환경일때
                Toast.makeText(this,"사용가능",Toast.LENGTH_LONG).show();
                File external = Environment.getExternalStorageDirectory();
                //외부저장소/임의디렉토리 생성 => 앱을 삭제해도 데이터는 남아있다.
                //String dirPath = external.getAbsolutePath()+"/myApp";
                String pkg = getPackageName();
                //외부저장소/android/data/앱의 패키지명으로 디렉토리 생성 => 앱을 삭제하면 데이터도 삭제
                String dirPath = external.getAbsolutePath();
                File dir = new File(dirPath+"/android/data/"+pkg);
                //디렉토리가 없으면 생성
                if(!dir.exists()){
                    dir.mkdir();
                }
                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir+"/test1.txt");
                    fw.write("외부저장소 테스트중");
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(fw!=null){
                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }else{
                Toast.makeText(this,"사용불가능",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"권한설정하세요",Toast.LENGTH_LONG).show();
        }
    }
}
