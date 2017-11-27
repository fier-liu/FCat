package com.xfdmao.fcat.user.controller;

import com.xfdmao.fcat.common.controller.BaseController;
import com.xfdmao.fcat.user.entity.TGroupType;
import com.xfdmao.fcat.user.service.TGroupTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiangfei on 2017/10/17.
 */
@RestController
@RequestMapping("v1/tGroupType")
public class TGroupTypeController extends BaseController<TGroupTypeService,TGroupType,Integer>{

}
