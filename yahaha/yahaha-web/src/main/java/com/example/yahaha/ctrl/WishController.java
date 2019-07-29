package com.example.yahaha.ctrl;

import com.example.system.base.BaseController;
import com.example.yahaha.entity.Wish;
import com.example.yahaha.entity.vo.WishQueryVo;
import com.example.yahaha.service.WishService;
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
public class WishController extends BaseController {

    @Autowired
    private WishService wishService;

    @PostMapping
    public ResultEx add(@Validated Wish record){
        record.setUserId(getSysUser().getId());
        return wishService.add(record);
    }

    @DeleteMapping("{id}")
    public ResultEx del(@PathVariable Integer id){
        return wishService.del(id);
    }

    @GetMapping
    public ResultEx page(WishQueryVo page){
        page.setUserId(getSysUser().getId());
        return wishService.queryPage(page);
    }

    @GetMapping("/discount")
    public ResultEx queryDiscount(WishQueryVo page){
        page.setUserId(getSysUser().getId());
        return wishService.queryDiscount(page);
    }
}
