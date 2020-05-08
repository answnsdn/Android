package multi.android.map_location_pro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;


public class LocationMapExam extends AppCompatActivity implements OnMapReadyCallback {
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
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            requestPermissions(permission_list,1000);
        }else{
            init();
        }
    }

    //퍼미션 체크 메소드
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int result:grantResults){
            if(result== PackageManager.PERMISSION_DENIED){
                return;
            }
        }
        init();
    }
    //맵정보 추출
    public void init(){
        FragmentManager manager = getSupportFragmentManager();
        SupportMapFragment mapFragment =
                (SupportMapFragment)manager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //지도가 준비되면 자동으로 호출되는 메소드
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if(map!=null){
            getMyLocation();
        }
    }
    //현재 나의 위치정보 추출
    public void getMyLocation(){
        locationManager =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){//버전이 마시멜로우 버전 이상일 때
            for(String permission:permission_list){
                if(checkSelfPermission(permission)==PackageManager.PERMISSION_DENIED){
                    return;
                }
            }
        }
        //1. 이전 측정값 가져오기 - 새로운 측정값 시간이 오래 걸릴 수 있으므로
        Location gps_loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Location network_loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if(gps_loc!=null){
            setMyLocation(gps_loc);
        }else{
            if(network_loc!=null){
                setMyLocation(network_loc);
            }
        }
        Log.d("myloc","=================");
        //2. 현재 측정값 가져오기
        MyLocationListener locationListener = new MyLocationListener();
        //현재 활성화되어 있는 Provider(GPS/NETWORK)를 체크
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    3000,10,locationListener);
        }
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        3000,10,locationListener);
        }

    }
    //현재 위치정보를 지도에 세팅하는 메소드
    public void setMyLocation(Location location){
        Log.d("myloc","위도:"+location.getLatitude());
        Log.d("myloc","경도:"+location.getLongitude());
        LatLng myloc = new LatLng(location.getLatitude(),location.getLongitude());
        CameraUpdate cameraupdate = CameraUpdateFactory.newLatLngZoom(myloc,15);
        map.moveCamera(cameraupdate);
        map.setMyLocationEnabled(true);
    }
    //현재 위치가 변경되거나 Provider에 변화가 있을 때 반응할 수 있도록 설정
    class MyLocationListener implements LocationListener {

        @Override
        //위치가 변경되면 호출되는 메소드
        public void onLocationChanged(Location location) {
            setMyLocation(location);
            //리스너 연결 해제
            locationManager.removeUpdates(this);
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
    }
}
