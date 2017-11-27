package com.xfdmao.fcat.user.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.common.constant.CommonConstant;
import com.xfdmao.fcat.common.service.impl.BaseServiceImpl;
import com.xfdmao.fcat.user.entity.TUser;
import com.xfdmao.fcat.user.entity.TUserGroup;
import com.xfdmao.fcat.user.mapper.TUserGroupMapper;
import com.xfdmao.fcat.user.service.TUserGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiangfei on 2017/10/17.
 */
@Service
public class TUserGroupServiceImpl extends BaseServiceImpl<TUserGroupMapper,TUserGroup> implements TUserGroupService {

    @Override
    @Transactional
    public Boolean saveGroupRelateUsers(Integer groupId, JSONObject param) {
        try{
            JSONArray leaderUserIds = param.getJSONArray("leaderUserIds");
            JSONArray memberUserIds = param.getJSONArray("memberUserIds");
            mapper.deleteByGroupId(groupId);
            for(int i=0;i<leaderUserIds.size();i++){
                Integer userId =leaderUserIds.getInteger(i);
                TUserGroup tUserGroup = new TUserGroup();
                tUserGroup.setUserId(userId);
                tUserGroup.setType(CommonConstant.GROUP_USER_TYPE_LEADER);
                tUserGroup.setGroupId(groupId);
                mapper.insert(tUserGroup);
            }
            for(int i=0;i<memberUserIds.size();i++){
                Integer userId =memberUserIds.getInteger(i);
                TUserGroup tUserGroup = new TUserGroup();
                tUserGroup.setUserId(userId);
                tUserGroup.setType(CommonConstant.GROUP_USER_TYPE_MEMBER);
                tUserGroup.setGroupId(groupId);
                mapper.insert(tUserGroup);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Boolean addByUserIdAndGroupId(TUserGroup tUserGroup) {
        TUserGroup tUserGroup1 = mapper.getByUserIdAndGroupId(tUserGroup);
        if(tUserGroup1==null){
            mapper.insert(tUserGroup);
        }else{
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteByUserIdAndGroupId(TUserGroup tUserGroup) {
        return mapper.deleteByUserIdAndGroupId(tUserGroup);
    }
}
