

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	    //現在時刻をTimeStamp型で取得
	    Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
	    //Long型に変換
	    long longFromtimeStamp = timeStamp.getTime();
	    //Date型に変換
	    Date DateFromLong = new Date(longFromtimeStamp);

	    //日時計算にカレンダーを使用
	    //1年前の時間を取得
	    //カレンダーインスタンスに現在時刻をセット
        Calendar cal1 = Calendar.getInstance();
	    cal1.add(Calendar.YEAR, -1);
	    //CalendarをDATE型に変換
	    Date DateFromCalendarYear = cal1.getTime();

        //1ヶ月前の時間を取得
	    //カレンダーインスタンスに現在時刻をセット
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.MONTH, -1);
        //CalendarをDATE型に変換
        Date DateFromCalendarMonth = cal2.getTime();

        //1日前の時間を取得
        //カレンダーインスタンスに現在時刻をセット
        Calendar cal3 = Calendar.getInstance();
        cal3.add(Calendar.DAY_OF_MONTH, -1);
        //CalendarをDATE型に変換
        Date DateFromCalendarDay = cal3.getTime();

        //12時間前の時間を取得
        //カレンダーインスタンスに現在時刻をセット
        Calendar cal4 = Calendar.getInstance();
        cal4.add(Calendar.HOUR, -12);
        //CalendarをDATE型に変換
        Date DateFromCalendarHour12 = cal4.getTime();

        //1時間前の時間を取得
        //カレンダーインスタンスに現在時刻をセット
        Calendar cal5 = Calendar.getInstance();
        cal5.add(Calendar.HOUR, -1);
        //CalendarをDATE型に変換
        Date DateFromCalendarHour = cal5.getTime();

        //59分前の時間を取得
        //カレンダーインスタンスに現在時刻をセット
        Calendar cal6 = Calendar.getInstance();
        cal6.add(Calendar.HOUR, -1);
        //CalendarをDATE型に変換
        Date DateFromCalendarMinitues59 = cal6.getTime();

	    //表示フォーマット指定
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
	    //Dateの表示フォーマットを変更(String型に)

	   //時間の配列を定義し、代入する
	   String timeList[] = new String[6];
	   timeList[0] = sdf.format(DateFromCalendarYear);
	   timeList[1] = sdf.format(DateFromCalendarMonth);
	   timeList[2] = sdf.format(DateFromCalendarDay);
	   timeList[3] = sdf.format(DateFromCalendarHour12);
	   timeList[4] = sdf.format(DateFromCalendarHour);
	   timeList[5] = sdf.format(DateFromCalendarMinitues59);

	    //リクエストオブジェクトに格納
	   request.setAttribute("timeList", timeList);

	   //resutl.jspに遷移
	    RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
	    rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
