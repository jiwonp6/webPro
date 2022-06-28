package com.lec.mybag.item.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.mybag.dao.ItemBoardDao;
import com.lec.mybag.dto.ItemBoardDto;
import com.lec.mybag.service.Service;

public class ItemBoardReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("1");
		int iId = Integer.parseInt(request.getParameter("iId"));
		System.out.println(iId);
		ItemBoardDao iDao = ItemBoardDao.getInstance();
		ItemBoardDto originItemBoard = iDao.modifyView_replyView(iId);
		request.setAttribute("originItemBoard", originItemBoard);
	}

}
