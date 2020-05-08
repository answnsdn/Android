# Permission

종류 : 일반권한, 위험권한

#### 위험권한

액티비티를 실행하거나 버튼을 누르거나 어떤 기능을 사용할 때 권한에 대한 처리를 할 수 있도록 구현

1. 사용 메소드

   ```
   checkSelfPermission : 권한의 현재 상태를 확인하는 메소드
   		|_PackageManager.PERMISSION_DENIED : 권한이 부여되지 않은 상태
   		|_PackageManager.PERMISSION_GRANTED : 권한이 부여된 상태
   		
   requestPermissions : 권한이 체크되어 있지 않은 경우에 권한을 요청하는 메세지를 표시
   	|_checkSelfPermission의 리턴 값이 PERMISSION_DENIED인 경우 사용한다.
   onRequestPermissionsResult : requestPermissions의 결과로 호출되는 메소드
   	|_ 권한 설정 정보를 매개변수로 넘긴다.
   	|_ requestCode : 권한 요청할 때 넘긴 요청코드
   	|_ permissions : 요청권한 목록
   	|_ grantResults : 권한 설정 성공 결과
   ```

2. 처리순서

   - 현재 사용하려고 하는 권한이 설정되어 있는지 체크
   - 1번에서 리턴값이 PERMISSION_DENIED인 경우 사용자가 권한을 설정할 수 있도록 메세지를 표시
   - 요청 처리 후 자동으로 호출되는 메소드를 통해 다음에 어떤 처리를 할 것인지 정의
     - 권한 성공 => 기능이 실행
     - 권한 실패 => Preference를 통해 설정할 수 있도록 액티비티를 이용하거나 안내 메세지 출력