package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.request.AddressRequest;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.blockengine.ftcloudmessage.mapper.UserAddressesMapper;
import cn.blockengine.ftcloudmessage.entity.UserAddresses;

import java.util.List;

public interface UserAddressesService{

    List<UserAddresses> usAddress(HttpServletRequest request);

    Boolean insertAddress(AddressRequest request);

    Boolean updateAddress(AddressRequest request);

    Boolean deleteAddress(Long id);

    UserAddresses getAddressDetail(Long id);

    Boolean updateDefaultAddress(Long id);

    UserAddresses getCurrentUserDefaultAddress();
}
