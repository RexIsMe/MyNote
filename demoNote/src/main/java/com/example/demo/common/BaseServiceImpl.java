package com.example.demo.common;

import com.example.demo.framework.Page;
import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public abstract class BaseServiceImpl<T, Mapper extends BaseMapper<T>> implements BaseService<T> {

    protected Logger logger = LogManager.getLogger(this.getClass());

    protected abstract Mapper getMapper();

    @Transactional
    @Override
    public int insert(T record) {
        return getMapper().insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(T record) {
        return getMapper().insertSelective(record);
    }

    @Transactional
    @Override
    public int insertList(List<T> recordList) {
        return getMapper().insertList(recordList);
    }

    @Transactional
    @Override
    public int insertOrUpdate(T record) {
        T t = this.selectByPrimaryKey(record);
        return t != null ? this.updateByPrimaryKey(record) : this.insert(record);
    }

    @Transactional
    @Override
    public int insertOrUpdateSelective(T record) {
        T t = this.selectByPrimaryKey(record);
        return t != null ? this.updateByPrimaryKeySelective(record) : this.insertSelective(record);
    }

    @Transactional
    @Override
    public int delete(T record) {
        return getMapper().delete(record);
    }

    @Transactional
    @Override
    public int deleteByPrimaryKey(Object key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    @Transactional
    @Override
    public int deleteByExample(Example example) {
        return getMapper().deleteByExample(example);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(T record) {
        return getMapper().updateByPrimaryKey(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByExample(T record, Example example) {
        return getMapper().updateByExample(record, example);
    }

    @Transactional
    @Override
    public int updateByExampleSelective(T entity, Example example) {
        return getMapper().updateByExampleSelective(entity, example);
    }

    @Override
    public final T selectByPrimaryKey(Object key) {
        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public final T get(T record) {
        return getMapper().selectOne(record);
    }

    @Override
    public final T getByExample(Example example) {
        return getMapper().selectOneByExample(example);
    }

    @Override
    public final int selectCount(T record) {
        return getMapper().selectCount(record);
    }

    @Override
    public final int selectCountByExample(Example example) {
        return getMapper().selectCountByExample(example);
    }

    @Override
    public final List<T> select(T record) {
        return getMapper().select(record);
    }

    @Override
    public final List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public final List<T> selectByExample(Example example) {
        return getMapper().selectByExample(example);
    }

    @Override
    public final Page<T> page(T record, Page<T> page) {
        page.setList(getMapper().selectByRowBounds(record,
                new RowBounds((page.getPageNo() - 1) * page.getPageSize(), page.getPageSize())));
        page.setTotal(selectCount(record), page.getPageNo());
        return page;
    }

    @Override
    public final Page<T> pageByExample(Example example, Page<T> page) {
        page.setList(getMapper().selectByExampleAndRowBounds(example,
                new RowBounds((page.getPageNo() - 1) * page.getPageSize(), page.getPageSize())));
        page.setTotal(selectCountByExample(example), page.getPageNo());
        return page;
    }

}