package com.tztang.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.mapper.PatrolPointMapper;
import com.tztang.pojo.entity.PatrolPoint;
import com.tztang.service.PatrolPointService;
import org.springframework.stereotype.Service;

@Service
public class PatrolPointServiceImpl extends ServiceImpl<PatrolPointMapper, PatrolPoint> implements PatrolPointService {



}
