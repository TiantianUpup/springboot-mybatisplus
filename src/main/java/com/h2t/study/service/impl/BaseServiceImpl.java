package com.h2t.study.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.h2t.study.service.BaseService;

import java.util.List;

/**
 * @Description: 基本业务实现类
 *
 * @Author: hetiantian
 * @Date:2019/8/3 11:54 
 * @Version: 1.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    /**
     * 添加
     *
     * @param obj
     * @return
     * */
    @Override
    public boolean save(T obj) {
        return this.insert(obj);
    }

    /**
     * 批量添加
     *
     * @param objList
     * @return
     * */
    @Override
    public boolean saveBatch(List<T> objList) {
        return this.insertBatch(objList);
    }


    /**
     * 根据id删除
     *

     * @param id
     */
    @Override
    public boolean removeById(Long id) {
        return this.deleteById(id);
    }

    /**
     * 根据传入参数条件进行删除
     *
     * @param obj
     * @return
     * */
    @Override
    public boolean remove(T obj) {
        Wrapper wrapper = new EntityWrapper<>(obj);
        return this.delete(wrapper);
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     * */
    @Override
    public boolean removeBatch(List<Long> idList) {
        return this.deleteBatchIds(idList);
    }

    /**
     * 根据id进行更新
     *
     * @param obj
     * @return
     * */
    @Override
    public boolean modifyById(T obj) {
        return this.updateById(obj);
    }

    /**
     * 根据id查找
     *

     * @param id
     */
    @Override
    public T getById(Long id) {
        return this.selectById(id);
    }

    /**
     * 根据条件进行查询
     *
     * @param obj
     * @return
     * */
    @Override
    public List<T> list(T obj) {
        Wrapper wrapper = new EntityWrapper<>(obj);
        return this.selectList(wrapper);
    }

    /**
     * 根据id批量查询
     *
     * @param idList
     * @return
     * */
    @Override
    public List<T> listById(List<Long> idList) {
        return this.selectBatchIds(idList);
    }
}
