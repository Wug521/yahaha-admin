package com.example.yahaha.ctrl;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.Wishes;
import com.example.yahaha.entity.vo.WishQueryVo;
import com.example.yahaha.service.WishesService;
import com.zjapl.common.result.ResultEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * yahaha
 *
 * @author create by yangb in 2019/7/29
 */
@RestController
@RequestMapping("/wish")
public class WishesController extends BaseController {

    @Autowired
    private WishesService wishesService;

    @PostMapping
    public ResultEx add(@Validated Wishes record){
        record.setUserId(getSysUser().getId());
        return wishesService.add(record);
    }

    @DeleteMapping("{id}")
    public ResultEx del(@PathVariable Integer id){
        return wishesService.del(id);
    }

    @GetMapping
    public ResultEx page(WishQueryVo page){
        page.setUserId(getSysUser().getId());
        return wishesService.queryPage(page);
    }

    @GetMapping("/discount")
    public ResultEx queryDiscount(WishQueryVo page){
        page.setUserId(getSysUser().getId());
        return wishesService.queryDiscount(page);
    }
}
