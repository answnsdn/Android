package multi.android.intent;

import android.os.Parcel;
import android.os.Parcelable;

//안드로이드에서 Intent에 객체를 공유하고 싶은 경우 Parcelable를 implement 해야한다.
public class User implements Parcelable {
    String name;
    String telNum;

    public User() {

    }

    public User(String name, String telNum) {
        this.name = name;
        this.telNum = telNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    protected User(Parcel in) {
        name = in.readString();
        telNum = in.readString();
    }
    //안드OS가 객체를 복원할 때(intent에서 꺼낼 때) Creator타입의 변수 CREATOR를
    //찾아서 CREATOR의 createFromParcel를 호출한 후 반환되는 값을 이용해서 사용
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }//안 만져도 되는 메소드

    //객체를 Intent에 담을 때 자동으로 호출되는 메소드
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(telNum);
    }
}
