package com.react.portfolio_project.service;

import com.react.portfolio_project.model.ScheduleVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface IScheduleService {
	ArrayList<ScheduleVO> scheduleList();
	void insertSchedule(ScheduleVO scd);
	void updateSchedule(ScheduleVO scd);
	void deleteSchedule(String NO);
	ScheduleVO ScheduleDetailView(String NO);
	ArrayList<ScheduleVO> ScheduleSearch(HashMap<String, Object> map); //상품 검색
}
