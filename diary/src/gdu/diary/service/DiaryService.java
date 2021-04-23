package gdu.diary.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DiaryService {
	//달력
	public Map<String, Object> getDiary(String targetYear, String targetMonth){
		//타겟 년, 월, 일(날짜)
		//타겟 달의 1일(이번주의 몇번째?)
		//타겟 달의 마지막 일의 숫자->endDay
		
		//전체 셀의 갯수(마지막일의 숫자보다는 크고 7로 나누어 떨어져야한다.)" StartBlank + endDay + endBlank(0~6)
		//앞의 빈셀의 갯수 -> startBlank : 1일의 위치값보다 1개 작다
		//이번달 숫자가 나와야 할 셀의 갯수(1~마지막날짜)
		//뒤의 빈셀의 갯수 -> endBlank: (startBlank+endDay)%7 != 0 이면 (7-(startBlank+endDay)%7)
		
		//여러가지 값을 넣어줄 것이므로 HashMap 사용 - Object를 사용하면 여러가지 타입을 담을 수 있음(상속 관계에서 가장 상위에 있어서: 다향성)
		Map<String, Object> map = new HashMap<String, Object>();
		//Calendar 클래스 사용
		//diary에서 날짜 변경을 할 경우 calendar의 날짜를 바꿔주지만 아닌경우 그냥 현재 날짜를 씀
		Calendar target = Calendar.getInstance();
		if(targetYear != null) {
			target.set(Calendar.YEAR,  Integer.parseInt(targetYear));
			//calendar 년도 셋팅
		}
		
		if(targetMonth != null) {
			//두번째 인수값 -1이면 target이 년을 -1하고 월은 11(12월) 값이 들어간다.
			//두번째 인수값이 12이면 target의 년을 +1하고 월은 0(1월) 값이 들어간다.
			target.set(Calendar.MONTH,  Integer.parseInt(targetMonth));
			//calendar 월 셋팅
		}
		/*
		 * int numTargetMonth = 0;
		int numTargetYear = 0;

		if(targetMonth != null && targetYear != null) {
			numTargetYear = Integer.parseInt(targetYear);
			numTargetMonth = Integer.parseInt(targetMonth);
			
			if(numTargetMonth == 0) {
				numTargetYear = numTargetYear - 1;
				numTargetMonth = 12;
			} else if(numTargetMonth == 13) {
				numTargetYear = numTargetYear + 1;
				numTargetMonth = 1;
			}
			
			target.set(Calendar.YEAR, numTargetYear);
			target.set(Calendar.MONTH, numTargetMonth - 1);
		}
		*/
			
		//날짜는 무조건 바꿈(넘어오지도 않음)
		target.set(Calendar.DATE, 1);
		
		//target월의 1일 앞의 와야할 빈셀의 갯수 - 빈셀의 개수는 시작일(시작일이 주의 몇번째인지)의 -1
		int startBlank = target.get(Calendar.DAY_OF_WEEK)-1;
		//target월의 마지막 날짜 : ActualMaximum : 가장 큰 숫자
		int endDay = target.getActualMaximum(Calendar.DATE);
		int endBlank = 0;
		//뒤의 빈 셀의 갯수
		if((startBlank+endDay)%7 != 0) {
			endBlank = 7-((startBlank+endDay)%7);
		}
		//int totalCell = startBlank + endDay + endBlank;
		map.put("currentMonth", target.get(Calendar.MONTH));
		map.put("currentYear", target.get(Calendar.YEAR));
		map.put("startBlank", startBlank);
		map.put("endDay", endDay);
		map.put("endBlank", endBlank);
		
		return map;
	}

}
