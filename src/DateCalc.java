import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCalc {

    //時間差によって返す文字列を変更するメソッド
    public static String dateCalc(Timestamp timestamp) {

        //Timestamp型をLong型に変換
        long longFromtimeStamp = timestamp.getTime();
        //日付表示のフォーマットを指定
        SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd日");

        //現在時刻をDate型で取得
        Date date = new Date();
        //Date型をLong型に変換
        Long longFromDate = date.getTime();
        //差分の時間を算出
        long timeDiff = (longFromDate - longFromtimeStamp) / (1000 * 60);

        if(timeDiff < 59) {
            //時間差が59以内ならnewを返す
            return "new";
        } else if(timeDiff <= 1440 && timeDiff >= 60) {
            //時間差が1時間以上24時間以内なら〜時間前を返す
            return (timeDiff / 60) + "時間前";
        } else {
            //それ以外ならyy年MM月dd日を返す
            return sdf.format(longFromtimeStamp);
        }


    }
}
