package exam.day03.view.selectview.view.adapter;
//row에 출력할 데이터 정보를 담는 객체
public class ActorItem {
    int ExamImg;
    String Name;
    String Date;
    String chkInfo;

    public ActorItem(int examImg, String name, String date, String chkInfo) {
        ExamImg = examImg;
        Name = name;
        Date = date;
        this.chkInfo = chkInfo;
    }

    @Override
    public String toString() {
        return "ActorItem{" +
                "ExamImg=" + ExamImg +
                ", Name='" + Name + '\'' +
                ", Date='" + Date + '\'' +
                ", chkInfo='" + chkInfo + '\'' +
                '}';
    }
}
