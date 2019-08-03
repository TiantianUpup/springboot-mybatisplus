package com.h2t.study.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.h2t.study.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hetiantian
 * @since 2019-08-02
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
