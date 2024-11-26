package com.tztang.dahua.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.IccResponse;
import com.tztang.dahua.mapper.*;
import com.tztang.pojo.entity.EventSubscribe;
import com.tztang.page.PageUtil;
import com.tztang.page.PageVo;
import com.tztang.common.ApiResponse;
import com.tztang.dahua.enums.EventCategoryEnums;
import com.tztang.dahua.enums.TypeFireAlarmEnums;
import com.tztang.dahua.enums.TypeSecurityBusinessEnums;
import com.tztang.pojo.dto.EventSubscribeDto;
import com.tztang.pojo.dto.EventSubscribeQueryDto;
import com.tztang.pojo.dto.EventUnSubscribeDto;
import com.tztang.pojo.dto.PublicSubscribeDto;
import com.tztang.pojo.vo.EventSubscribeQueryVo;
import com.tztang.dahua.service.SubscribeService;
import com.tztang.dahua.util.EventSubscribeHelper;
import com.tztang.exception.DemoFrameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class SubscribeServiceImpl implements SubscribeService {

  @Resource
  private EventSubscribeMapper eventSubscribeMapper;
  @Resource
  private EventSubscribeOrgMapper eventSubscribeOrgMapper;
  @Resource
  private EventSubscribeTypeMapper eventSubscribeTypeMapper;
  @Resource
  private EventSubscribeGradeMapper eventSubscribeGradeMapper;
  @Resource
  private EventSubscribeNodeCodeMapper eventSubscribeNodeCodeMapperMapper;

  @Resource
  private EventSubscribeHelper eventSubscribeHelper;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public ApiResponse<String> eventSubscribe(EventSubscribeDto dto) throws ClientException {
    if (!addEventSubscribe(dto)) {
      return ApiResponse.error("事件订阅名称重复");
    }
    addEventSubscribe(dto);
    IccResponse res = eventSubscribeHelper.subscribeEvent(dto);
    log.info("自定义事件订阅:{}", res.toString());
    if (!"0".equals(res.getCode())) {
      return ApiResponse.error(res.getErrMsg());
    }
    return ApiResponse.ok(res.getResult());
  }

  @Override
  public ApiResponse<String> fireAlarmSubscribe(PublicSubscribeDto dto) throws ClientException {
    EventSubscribeDto eventSubscribeDto = new EventSubscribeDto();
    eventSubscribeDto.setReceiveIp(dto.getReceiveIp());
    eventSubscribeDto.setReceivePort(dto.getReceivePort());
    eventSubscribeDto.setCategory(EventCategoryEnums.alarm.code);
    eventSubscribeDto.setTypes(TypeFireAlarmEnums.getCodes());
    eventSubscribeDto.setName(dto.getName());
    eventSubscribeDto.setReceiveUri("/dahua/receive/api/eventMsg");
    if (!addEventSubscribe(eventSubscribeDto)) {
      return ApiResponse.error("事件订阅名称重复");
    }
    IccResponse res = eventSubscribeHelper.subscribeEvent(eventSubscribeDto);
    log.info("消防报警事件订阅:{}", res.toString());
    if (!"0".equals(res.getCode())) {
      return ApiResponse.error(res.getErrMsg());
    }
    return ApiResponse.ok(res.getResult());
  }

  @Override
  public ApiResponse<String> securityBusinessSubscribe(PublicSubscribeDto dto) throws ClientException {
    EventSubscribeDto eventSubscribeDto = new EventSubscribeDto();
    eventSubscribeDto.setReceiveIp(dto.getReceiveIp());
    eventSubscribeDto.setReceivePort(dto.getReceivePort());
    eventSubscribeDto.setCategory(EventCategoryEnums.business.code);
    eventSubscribeDto.setTypes(TypeSecurityBusinessEnums.getCodes());
    eventSubscribeDto.setName(dto.getName());
    eventSubscribeDto.setReceiveUri("/dahua/receive/api/businessMsg");
    if (!addEventSubscribe(eventSubscribeDto)) {
      return ApiResponse.error("事件订阅名称重复");
    }
    IccResponse res = eventSubscribeHelper.subscribeEvent(eventSubscribeDto);
    log.info("安检业务事件订阅:{}", res.toString());
    if (!"0".equals(res.getCode())) {
      return ApiResponse.error(res.getErrMsg());
    }
    return ApiResponse.ok(res.getResult());
  }

  @Override
  public ApiResponse<String> deviceStatusSubscribe(PublicSubscribeDto dto) throws ClientException {
    EventSubscribeDto eventSubscribeDto = new EventSubscribeDto();
    eventSubscribeDto.setReceiveIp(dto.getReceiveIp());
    eventSubscribeDto.setReceivePort(dto.getReceivePort());
    eventSubscribeDto.setCategory(EventCategoryEnums.state.code);
    eventSubscribeDto.setTypes(TypeSecurityBusinessEnums.getCodes());
    eventSubscribeDto.setName(dto.getName());
    eventSubscribeDto.setReceiveUri("/dahua/receive/api/deviceStatusMsg");
    if (!addEventSubscribe(eventSubscribeDto)) {
      return ApiResponse.error("事件订阅名称重复");
    }
    IccResponse res = eventSubscribeHelper.subscribeEvent(eventSubscribeDto);
    log.info("安检业务事件订阅:{}", res.toString());
    if (!"0".equals(res.getCode())) {
      return ApiResponse.error(res.getErrMsg());
    }
    return ApiResponse.ok(res.getResult());
  }

  @Override
  public ApiResponse<PageVo<EventSubscribeQueryVo>> eventSubscribeQuery(EventSubscribeQueryDto dto) {
    IPage<EventSubscribeQueryVo> iPage = eventSubscribeMapper.eventSubscribeQuery(PageUtil.getPageParams(dto), dto);
    return ApiResponse.ok(PageUtil.convertPage(iPage, eventSubscribeQueryVo -> eventSubscribeQueryVo));
  }

  @Override
  public ApiResponse<String> eventUnSubscribe(EventUnSubscribeDto dto) {
    List<EventSubscribe> EventSubscribes = eventSubscribeMapper.selectBatchIds(dto.getIds());
    EventSubscribes.forEach(eventSubscribe -> {
      try {
        IccResponse res = eventSubscribeHelper.eventUnSubscribe(eventSubscribe.getName());
        log.info("事件订阅取消:{}", res.toString());
        if (!"0".equals(res.getCode())) {
          throw new DemoFrameException(res.getCode(), "订阅名称:" + eventSubscribe.getName() + "   取消订阅异常:" + res.getErrMsg());
        }
        //更新状态为已取消订阅
        eventSubscribeMapper.update(
                null,
                Wrappers.<EventSubscribe>lambdaUpdate()
                        .eq(EventSubscribe::getId, eventSubscribe.getId())
                        .set(EventSubscribe::getStatus, 1));
      } catch (ClientException e) {
        e.printStackTrace();
      }
    });
    return ApiResponse.ok();
  }

  //新增事件订阅信息
  private boolean addEventSubscribe(EventSubscribeDto dto) {
    //名称是唯一的
    if (eventSubscribeMapper.exists(Wrappers.<EventSubscribe>lambdaQuery().eq(EventSubscribe::getName, dto.getName()))) {
      return false;
    }
    //插入事件订阅信息
    EventSubscribe eventSubscribe = new EventSubscribe();
    eventSubscribe.setIp(dto.getReceiveIp());
    eventSubscribe.setPort(dto.getReceivePort());
    eventSubscribe.setName(dto.getName());
    eventSubscribe.setCategory(dto.getCategory());
    eventSubscribe.setPlatform(dto.getPlatform());
    eventSubscribeMapper.insert(eventSubscribe);
    //插入事件订阅类型
    eventSubscribeTypeMapper.batchInsert(dto.getTypes());
    //插入事件订阅报警等级
    eventSubscribeGradeMapper.batchInsert(dto.getGrades());
    //插入事件订阅组织信息
    eventSubscribeOrgMapper.batchInsert(dto.getOrgs());
    //插入事件订阅设备和通道
    eventSubscribeNodeCodeMapperMapper.batchInsert(dto.getNodeCodes());
    return true;
  }

}
