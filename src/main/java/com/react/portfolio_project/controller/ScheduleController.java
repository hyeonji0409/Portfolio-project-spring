package com.react.portfolio_project.controller;

import java.util.HashMap;

import com.react.portfolio_project.model.ScheduleVO;
import com.react.portfolio_project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*") // http://127.0.0.1 또는 localhost 다 사용하도록
@RestController
public class ScheduleController {
	@Autowired
	ScheduleService service;
	
	//전제 스케줄 조회
	@RequestMapping("/schedule/scheduleList")
	public HashMap<String, Object> viewscheduleList() {	
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("scdList",  service.scheduleList());
		System.out.println(map);
		return map; //스케줄 리스트 
	}
	
	
	// ArrayList로 반환해도 됨
	// HashMap을 사용하면 다른 값도 같이 반환할 수 있음 
	// 예 : 페이지 카운트 수
	
	//스케줄 상세 정보 반환
	@RequestMapping("/schedule/detailView/{NO}")
	public ScheduleVO detailVewschedule(@PathVariable  String NO) {
		return service.ScheduleDetailView(NO);//스케줄 상세 정보 
	}
	
	//스케줄 등록
		@RequestMapping(value="/schedule/insert")
		public void insertschedule(ScheduleVO scd) {	
			System.out.println(scd.getID());
			System.out.println(scd.getNOW());
			service.insertSchedule(scd);	 
		}
		
		//스케줄 수정
		@RequestMapping(value="/schedule/update")
		public void updateschedule(ScheduleVO scd) {		
			service.updateSchedule(scd);	 
		}
		
		//스케줄 정보 삭제
		@RequestMapping(value="/schedule/delete/{NO}")
		public void  deleteschedule(@PathVariable String NO) {				
			service.deleteSchedule(NO);			
		}

	
}
