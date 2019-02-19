package kz.github.igorz.mappers;

import org.apache.ibatis.annotations.Select;

/**
 * Created by Jtahun on 16.02.2019.
 */
public interface MsgMapper {
    @Select("SELECT MSG as msg FROM message WHERE id = #{id}")
    public String getMessage(int id);
}
