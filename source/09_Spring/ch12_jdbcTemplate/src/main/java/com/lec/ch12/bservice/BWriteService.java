package com.lec.ch12.bservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch12.bservice.Service;
import com.lec.ch12.dao.BoardDao;
import com.lec.ch12.dto.BoardDto;

public class BWriteService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BoardDto bDto = (BoardDto)map.get("bDto");	//bName, bTitle, bContent
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		bDto.setbIp(request.getRemoteAddr());
		BoardDao boardDao = BoardDao.getInstance();
		model.addAttribute("writeResult", boardDao.write(bDto));
	}

}
