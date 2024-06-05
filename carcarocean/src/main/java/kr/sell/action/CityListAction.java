package kr.sell.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;

public class CityListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> mapAjax = new HashMap<String,Object>();
		request.setCharacterEncoding("utf-8");
		String city = request.getParameter("city");
		List<String> cityList = new ArrayList<>();
		if(city!=null && !city.equals("")) {
			if(city.equals("서울특별시")) {
				cityList = new ArrayList<>(Arrays.asList("강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"));
			} else if(city.equals("부산광역시")) {
				cityList = new ArrayList<>(Arrays.asList("강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구"));
			} else if(city.equals("대구광역시")) {
				cityList = new ArrayList<>(Arrays.asList("달서구", "달성군", "동구", "남구", "북구", "서구", "수성구", "중구"));
			} else if(city.equals("인천광역시")) {
				cityList = new ArrayList<>(Arrays.asList("강화군", "계양구", "남동구", "동구", "미추홀구", "부평구", "서구", "연수구", "옹진군", "중구"));
			} else if(city.equals("광주광역시")) {
				cityList = new ArrayList<>(Arrays.asList("광산구", "남구", "동구", "북구", "서구"));
			} else if(city.equals("대전광역시")) {
				cityList = new ArrayList<>(Arrays.asList("대덕구", "동구", "서구", "유성구", "중구"));
			} else if(city.equals("울산광역시")) {
				cityList = new ArrayList<>(Arrays.asList("동구", "북구", "남구", "울주군", "중구"));
			} else if(city.equals("세종특별자치시")) {
				cityList = new ArrayList<>(Arrays.asList(" "));
			} else if(city.equals("경기도")) {
				cityList = new ArrayList<>(Arrays.asList("가평군", "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "연천군", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"));
			} else if(city.equals("강원도")) {
				cityList = new ArrayList<>(Arrays.asList("강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시", "인제군", "정선군", "철원군", "춘천시", "태백시", "평창군", "홍천군", "화천군", "횡성군"));
			} else if(city.equals("충청북도")) {
				cityList = new ArrayList<>(Arrays.asList("괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "제천시", "증평군", "진천군", "청주시", "충주시"));
			} else if(city.equals("충청남도")) {
				cityList = new ArrayList<>(Arrays.asList("계룡시", "공주시", "금산군", "논산시", "당진시", "보령시", "부여군", "서산시", "서천군", "천안시", "청양군", "태안군", "홍성군", "예산군", "아산시"));
			} else if(city.equals("전라북도")) {
				cityList = new ArrayList<>(Arrays.asList("고창군", "군산시", "김제시", "남원시", "무주군", "부안군", "순창군", "완주군", "익산시", "임실군", "장수군", "전주시", "정읍시", "진안군"));
			} else if(city.equals("전라남도")) {
				cityList = new ArrayList<>(Arrays.asList("강진군", "고흥군", "곡성군", "광양시", "구례군", "나주시", "담양군", "목포시", "무안군", "보성군", "순천시", "신안군", "여수시", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"));
			} else if(city.equals("경상북도")) {
				cityList = new ArrayList<>(Arrays.asList("경산시", "경주시", "고령군", "구미시", "군위군", "김천시", "문경시", "봉화군", "상주시", "성주군", "안동시", "영덕군", "영양군", "영주시", "영천시", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군", "포항시"));
			} else if(city.equals("경상남도")) {
				cityList = new ArrayList<>(Arrays.asList("거제시", "거창군", "고성군", "김해시", "남해군", "밀양시", "사천시", "산청군", "양산시", "의령군", "진주시", "창녕군", "창원시", "통영시", "하동군", "함안군", "함양군", "합천군"));
			} else if(city.equals("제주특별자치도")) {
				cityList = new ArrayList<>(Arrays.asList("서귀포시","제주시"));
			}
			mapAjax.put("cityList",cityList);
		}
		mapAjax.put("result", "success");
		ObjectMapper mapper = new ObjectMapper();
		String ajaxData = mapper.writeValueAsString(mapAjax);
		request.setAttribute("ajaxData", ajaxData);
		return "/WEB-INF/views/common/ajax_view.jsp";
	}
	
}
