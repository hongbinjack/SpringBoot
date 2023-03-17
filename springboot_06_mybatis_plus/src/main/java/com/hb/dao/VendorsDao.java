package com.hb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hb.domain.Vendors;
import org.apache.ibatis.annotations.*;

@Mapper
//用了extendsBase Mapper<Vendors>把泛型传进去下面的所有都可以不用写了，可以与模块springboot_05_mybatis对比即可
public interface VendorsDao extends BaseMapper<Vendors> {






    /**
     *   用extends BaseMapper<Vendors>代表了
     *   //前期此处的查询语句设置成了id与表中的vend_id不匹配，导致一直报错clause错误
     *   @Select("select * from vendors where vend_id = #{id}")
     *   public Vendors getVendorById(Integer id);
     *
     */


   /*

    @Select("select * from vendors where vend_id = #{id}")
    public Vendors getVendorById(Integer id);

//将用户id为1001的vend_state设置为MMI
@Update("update vendors set vend_state = 'up' where vend_id = #{id}")
    public void updateById(Integer id);

//新增一列数据
    @Insert("insert into vendors(vend_id,vend_name,vend_address,vend_city,vend_state,vend_zip,vend_country) value(1009,'jack','bei','hai','me','zip','China')")
    public void insertData();

//删除上面的新增数据
   @Delete("delete from vendors where vend_id = #{id}")
    public void deleteData(Integer id);

   */
}
