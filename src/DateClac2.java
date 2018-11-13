import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClac2 {



    public static void main(String[] arg) {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateTo = null;
        Date dateFrom = null;

        //日付をセット
        try {
            dateFrom = sdf.parse("2018/11/13 13:00:00");
            dateTo = sdf.parse("2018/11/13 15:00:00");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //日付をlong値に変換
        long longDateTo = dateTo.getTime();
        long longDateFrom = dateFrom.getTime();

        //差分を計算
        long dayDiff = (longDateTo - longDateFrom) / (1000 * 60 * 60);

        System.out.println(sdf.format(dateFrom));
        System.out.println(sdf.format(dateTo));

        System.out.println(sdf.format(longDateFrom));
        System.out.println(sdf.format(longDateTo));

        System.out.println(sdf.format(dayDiff));


    }

}
