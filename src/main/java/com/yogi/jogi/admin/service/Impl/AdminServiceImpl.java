package com.yogi.jogi.admin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.admin.dao.AdminDao;
import com.yogi.jogi.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao dao;
}
