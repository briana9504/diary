package gdu.diary.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener//listener는 특정 이벤트(ex 톰캣 부팅, 세션생성)때 실행된다.
public class DBDriveListener implements ServletContextListener {
	//톰켓 부팅시 dbDrive를 켜준다.
    public void contextInitialized(ServletContextEvent sce)  { 
         try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println(this.getClass() + " DB Driver 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(" DB Driver 로딩 실패....");
			e.printStackTrace();
		}
    }
    //생성자
    public DBDriveListener() {
    }

    //톰캣 종료시
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	
}
