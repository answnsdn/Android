package multi.android.datamanagementpro.sqlite.exam;
//row에 출력할 데이터 정보를 담는 객체
public class User {
    int index;
    String name;
    int price;

    public User(int index, String name, int price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "User{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
