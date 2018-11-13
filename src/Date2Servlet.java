

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Date2Servlet")
public class Date2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Date2Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	    //時間のフォーマットを指定
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date型の時間を定義
        Date exampleTime = null;
        try {
            //時間をセット
            exampleTime = sdf.parse("2018/11/14 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Date型からTimestamp型に変換
        Timestamp ts = new Timestamp(exampleTime.getTime());

        //
        String result = DateCalc.dateCalc(ts);

        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("result2.jsp");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
