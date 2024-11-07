package com.tztang.dahua.pojo.dto;


import java.util.List;
import java.util.Objects;

/**
 * Created by 32514 on 2019-06-17.
 */
public class EventDto {
    private String category;//事件大类:"alarm"为报警
    private List<AuthorityDto> authorities;//权限信息数组,不填就是所有

    private List<Integer> grades;//报警等级列表，1>2>3>4>5 0或者不填等级代表全部等级

    private final Integer subscribeAll = 1;

    private Integer domainSubscribe = 2;

    private Integer scheme = 0;

    private Integer eventType = 0;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<AuthorityDto> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityDto> authorities) {
        this.authorities = authorities;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public Integer getSubscribeAll() {
        return subscribeAll;
    }

    public void setSubscribeAll(Integer subscribeAll) {
//        this.subscribeAll = subscribeAll;
    }

    public Integer getDomainSubscribe() {
        return domainSubscribe;
    }

    public void setDomainSubscribe(Integer domainSubscribe) {
        this.domainSubscribe = domainSubscribe;
    }

    public Integer getScheme() {
        return scheme;
    }

    public void setScheme(Integer scheme) {
        this.scheme = scheme;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDto eventDto = (EventDto) o;
        return Objects.equals(category, eventDto.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(category);
    }
}
