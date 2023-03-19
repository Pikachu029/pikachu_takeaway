package com.pikachu.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pikachu.takeaway.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {

}
