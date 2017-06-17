package com.su.service;

import com.su.entity.FrontMenu;

import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/10/26.
 */

public interface FrontMenuService extends BaseService<FrontMenu>{


    List<FrontMenu> queryAllese(Map<String, Object> maps);

}
