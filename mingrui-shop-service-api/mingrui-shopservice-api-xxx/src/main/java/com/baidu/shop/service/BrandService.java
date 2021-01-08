package com.baidu.shop.service;

import com.baidu.shop.base.Result;
import com.baidu.shop.dto.BrandDTO;
import com.baidu.shop.entity.BrandEntity;
import com.baidu.shop.validate.group.MingruiOperation;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * @ClassName BrandService
 * @Description: TODO
 * @Author helianmingbo
 * @Date 2020/12/25
 * @Version V1.0
 **/
@Api(tags = "商品接口")
public interface BrandService {

    @ApiOperation(value = "查询商品列表")
    @GetMapping(value = "brand/list")
    Result<PageInfo<BrandEntity>> getBrandInfo(BrandDTO brandDTO);


    @ApiOperation(value = "新增品牌")
    @PostMapping(value = "brand/save")
    Result<JsonObject> saveBrandInfo(@Validated({MingruiOperation.Add.class}) @RequestBody BrandDTO brandDTO);

    @ApiOperation(value = "修改品牌")
    @PutMapping(value = "brand/save")
    Result<JsonObject> editBrandInfo(@Validated({MingruiOperation.Update.class}) @RequestBody BrandDTO brandDTO);

    @ApiOperation(value = "删除品牌")
    @DeleteMapping(value = "brand/delete")
    Result<JsonObject> deleteBrandInfo(Integer id);

    @GetMapping(value = "brand/getBrandInfoByCategoryId")
    @ApiOperation(value = "通过id分类查询品牌")
    Result<List<BrandEntity>> getBrandInfoByCategoryId(Integer cid);
}
