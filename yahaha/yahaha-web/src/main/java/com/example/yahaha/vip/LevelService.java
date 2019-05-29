package com.example.yahaha.vip;

import com.example.yahaha.dao.IVipLevelDao;
import com.example.yahaha.entity.VipLevel;
import com.zjapl.common.result.ObjectResultEx;
import com.zjapl.common.result.ResultEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yahaha
 *
 * @author create by yangb in 2019/5/29
 */
@Service
public class LevelService {

    @Autowired
    private IVipLevelDao levelDao;

    public ResultEx add(VipLevel level){
        assert level != null;
        if (level.getId() == null) {
            levelDao.insert(level);
        } else {
            levelDao.updateByPrimaryKey(level);
        }
        return new ResultEx().makeSuccessResult();
    }

    public ResultEx delete(Integer id){
        assert id != null;
        levelDao.deleteByPrimaryKey(id);
        return new ResultEx().makeSuccessResult();
    }

    public ResultEx getList(){
        List<VipLevel> levels = levelDao.selectAll();
        return new ObjectResultEx<List<?>>().makeSuccessResult(levels);
    }

    public ResultEx getOne(Integer id){
        assert id != null;
        VipLevel level = levelDao.selectByPrimaryKey(id);
        return new ObjectResultEx<>().makeSuccessResult(level);
    }

    /**
     * 根据积分计算等级
     * @param integra 。
     * @return 。
     */
    public VipLevel checkLevel(int integra){
        List<VipLevel> levels = levelDao.selectAll();
        VipLevel level = null;
        if(levels != null && levels.size() > 0){
            for (VipLevel vipLevel : levels) {
                if(vipLevel.getIntegralPoint() > integra){
                    break;
                }else{
                    level = vipLevel;
                }
            }
        }
        return level;
    }
}
