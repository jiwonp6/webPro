package com.lec.ch11.bservice;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;

public class BModifyReplyViewService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bId = (Integer)map.get("bId");
		BoardDao boardDao = BoardDao.getInstance();
		model.addAttribute("bDto", boardDao.modifyView_replyView(bId));
	}

}
