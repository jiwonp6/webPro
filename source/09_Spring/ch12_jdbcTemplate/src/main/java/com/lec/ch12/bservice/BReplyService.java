package com.lec.ch12.bservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;
import com.lec.ch12.dto.BoardDto;

public class BReplyService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BoardDto bDto = (BoardDto)map.get("boardDto");
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		//bGroup, bStep, bIndent : 원글정보
		//bName, bTitle, bContent, bIp : 답변글 정보
		bDto.setbIp(request.getRemoteAddr());
		BoardDao boardDao = BoardDao.getInstance();
		model.addAttribute("replyResult", boardDao.reply(bDto));

	}

}
