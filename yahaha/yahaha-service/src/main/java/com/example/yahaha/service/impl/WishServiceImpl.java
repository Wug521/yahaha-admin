package com.example.yahaha.service.impl;

import com.example.yahaha.dao.IGameDao;
import com.example.yahaha.dao.IWishDao;
import com.example.yahaha.entity.Wish;
import com.example.yahaha.entity.vo.GameVo;
import com.example.yahaha.entity.vo.WishQueryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * yahaha
 *
 * @author create by yangb in 2019/7/29
 */
@Service
public class WishServiceImpl implements com.example.yahaha.service.WishService {

    @Autowired
    private IWishDao dao;
    @Autowired
    private IGameDao gameDao;
    @Override
    public ResultEx add(Wish record) {
        record.setFlagTime(new Date());
        dao.insert(record);
        return new ResultEx().makeSuccessResult();
    }

    @Override
    public ResultEx del(Integer id) {
        dao.deleteByPrimaryKey(id);
        return new ResultEx().makeSuccessResult();
    }

    @Override
    public ObjectResultEx<PageInfo<GameVo>> queryPage(WishQueryVo page){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<GameVo> games = dao.querWishGame(page.getUserId());
        PageInfo<GameVo> pageinfo = new PageInfo<>(games);
        return new ObjectResultEx<PageInfo<GameVo>>().makeSuccessResult(pageinfo);
    }

    public ObjectResultEx<PageInfo<GameVo>> queryDiscount(WishQueryVo page){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<GameVo> games = dao.queryDiscountGame(page.getUserId());
        PageInfo<GameVo> pageinfo = new PageInfo<>(games);
        return new ObjectResultEx<PageInfo<GameVo>>().makeSuccessResult(pageinfo);
    }

}
