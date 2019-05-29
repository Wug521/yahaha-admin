package com.example.yahaha.vip;

import com.example.yahaha.entity.VipLevel;
import com.zjapl.common.result.ResultEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * yahaha
 *
 * @author create by yangb in 2019/5/29
 */
@RestController
@RequestMapping("/level")
public class LevelController {

    @Autowired
    private LevelService levelService;

    @PostMapping
    public ResultEx add(VipLevel level){
        return levelService.add(level);
    }

    @DeleteMapping("/{id}")
    public ResultEx delete(@PathVariable Integer id){
        return levelService.delete(id);
    }

    @GetMapping
    public ResultEx getList(){
        return levelService.getList();
    }

    @GetMapping("/{id}")
    public ResultEx getOne(@PathVariable Integer id){
        return levelService.getOne(id);
    }

}
