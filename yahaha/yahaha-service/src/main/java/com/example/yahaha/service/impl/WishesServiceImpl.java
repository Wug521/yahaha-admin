package com.example.yahaha.service.impl;

import com.example.yahaha.dao.IGameDao;
import com.example.yahaha.dao.IWishesDao;
import com.example.yahaha.entity.Wishes;
import com.example.yahaha.entity.vo.GameVo;
import com.example.yahaha.entity.vo.WishQueryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * yahaha
 *
 * @author create by yangb in 2019/7/29
 */
@Service
public class WishesServiceImpl implements com.example.yahaha.service.WishesService {

    @Autowired
    private IWishesDao dao;
    @Autowired
    private IGameDao gameDao;
    @Override
    public ResultEx add(Wishes record) {
        List<Wishes> wishes = dao.select(record);
        record.setCreateTime(new Date());
        record.setChangeTime(new Date());
        if (wishes == null || wishes.size() == 0) {
            dao.insert(record);
        }
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
        games.forEach(gameVo -> gameVo.setNewDiscount(gameVo.getSpiderTime().getTime() > gameVo.getCreateTime().getTime()));
        PageInfo<GameVo> pageinfo = new PageInfo<>(games);
        return new ObjectResultEx<PageInfo<GameVo>>().makeSuccessResult(pageinfo);
    }

    public ObjectResultEx<PageInfo<GameVo>> queryDiscount(WishQueryVo page){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<GameVo> games = dao.queryDiscountGame(page.getUserId());
        if(games != null && games.size() > 0){
            List<Long> ids = new ArrayList<>(games.size());
            for (GameVo game : games) {
                ids.add(game.getWishId());
            }
            Example example = new Example(Wishes.class);
            example.createCriteria().andIn("id", ids);
            Wishes wishes = new Wishes();
            wishes.setChangeTime(new Date());
            dao.updateByExampleSelective(wishes, example);
        }
        PageInfo<GameVo> pageinfo = new PageInfo<>(games);
        return new ObjectResultEx<PageInfo<GameVo>>().makeSuccessResult(pageinfo);
    }

}
