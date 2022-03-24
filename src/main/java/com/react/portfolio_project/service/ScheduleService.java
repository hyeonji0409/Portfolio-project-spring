package com.react.portfolio_project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.react.portfolio_project.dao.IScheduleDAO;
import com.react.portfolio_project.model.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService implements IScheduleService {
	
	// MyBatis 사용하는 경우
	@Autowired
	@Qualifier("IScheduleDAO")
	IScheduleDAO dao;

	@Override
	public ArrayList<ScheduleVO> scheduleList() {
		return dao.ScheduleList();
	}

	@Override
	public void insertSchedule(ScheduleVO scd) {
		dao.insertSchedule(scd);
	}

	@Override
	public void updateSchedule(ScheduleVO scd) {
		dao.updateSchedule(scd);
	}

	@Override
	public void deleteSchedule(String NO) {
		dao.deleteSchedule(NO);
	}

	@Override
	public ScheduleVO ScheduleDetailView(String NO) {
		return dao.ScheduleDeailView(NO);
	}

	
	//@Override
//	public ArrayList<ScheduleVO> ScheduleSearch(String type, String keyword){
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("type", type);
//		map.put("keyword", keyword);
//		return dao.ScheduleSearch(map);
//	}
	
	@Override
	public ArrayList<ScheduleVO> ScheduleSearch(HashMap<String, Object> map){
		return dao.ScheduleSearch(map);
	}

}
