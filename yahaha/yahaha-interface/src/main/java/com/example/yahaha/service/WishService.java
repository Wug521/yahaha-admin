package com.example.yahaha.service;

import com.example.yahaha.entity.Wish;
import com.example.yahaha.entity.vo.GameVo;
import com.example.yahaha.entity.vo.WishQueryVo;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;

/**
 * yahaha
 *
 * @author create by yangb in 2019/7/29
 */
public interface WishService {

    ResultEx add(Wish record);

    ResultEx del(Integer id);

    ObjectResultEx<PageInfo<GameVo>> queryPage(WishQueryVo page);

    ObjectResultEx<PageInfo<GameVo>> queryDiscount(WishQueryVo page);
}
