package com.react.portfolio_project.dao;

import com.react.portfolio_project.model.ScheduleVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface IScheduleDAO {
	 ArrayList<ScheduleVO> ScheduleList(); //전체 스케줄 조회
	 void insertSchedule(ScheduleVO scd); //스케줄 등록
	 ScheduleVO ScheduleDeailView(String NO); //스케줄 상세 정보 조회
	 void updateSchedule(ScheduleVO scd); //스케줄 정보 수정
	 void deleteSchedule(String NO); //스케줄 정보 삭제
	 ArrayList<ScheduleVO> ScheduleSearch(HashMap<String, Object> map); //스케줄 검색
	// ArrayList<DogVO> ScheduleSearch(HashMap<String, Object> map); 
}

