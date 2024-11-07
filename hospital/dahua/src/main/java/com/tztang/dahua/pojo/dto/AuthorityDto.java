package com.tztang.dahua.pojo.dto;


import java.util.List;

/**
 * Created by 32514 on 2019-07-08.
 */
public class AuthorityDto {
    private List<String> types;//报警类型列表，null代表全部，空代表没有

    private List<String> nodeCodes;//设备或通道，null代表全部，空代表没有

    private List<String> orgs;//组织编码，null代表全部，空代表没有

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getNodeCodes() {
        return nodeCodes;
    }

    public void setNodeCodes(List<String> nodeCodes) {
        this.nodeCodes = nodeCodes;
    }

    public List<String> getOrgs() {
        return orgs;
    }

    public void setOrgs(List<String> orgs) {
        this.orgs = orgs;
    }
}
