package multi.android.map_location_pro.location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import multi.android.map_location_pro.R;
//현재 위치정보를 가져와서 맵에 연결해서 출력 - avd, device 둘 다 체크
public class LocationMapExam extends AppCompatActivity implements LocationListener,
                                                            OnMapReadyCallback {
    GoogleMap map;
    LocationManager locationManager;
    String[] permission_list={
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_map_exam);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        FragmentManager manager = getSupportFragmentManager();
        SupportMapFragment mapFragment =
                (SupportMapFragment)manager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED | ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"권한이 없습니다.",Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this,"권한이 설정되었습니다.",Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    public void startLocationService(){
        locationManager =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //위치정보를 제공하는 제공자로부터 위치정보를 담고 있는 Location객체를
        //가져오기
        try {
            Location location =
                    locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location!=null){
                double latitude =  location.getLatitude();
                double longitude =  location.getLongitude();
                Log.d("msg",latitude+","+longitude);
            }else{
                Log.d("msg","location객체 실패");
            }
        }catch (SecurityException e){
            Log.d("msg",e.getMessage());
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        locationManager =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        try {
            Location location =
                    locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location!=null){
                double latitude =  location.getLatitude();
                double longitude =  location.getLongitude();
                if (map != null) {
                    LatLng myloc = new LatLng(latitude,longitude);
                    CameraPosition.Builder builder = new CameraPosition.Builder();
                    builder.target(myloc);
                    builder.zoom(15);
                    CameraPosition position = builder.build();
                    map.moveCamera(CameraUpdateFactory.newCameraPosition(position));
                }
            }else{
                Log.d("msg","location객체 실패");
            }
        }catch (SecurityException e){
            Log.d("msg",e.getMessage());
        }
    }
}
