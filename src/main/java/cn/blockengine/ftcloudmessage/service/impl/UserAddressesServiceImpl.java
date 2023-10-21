package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.entity.UserAddresses;
import cn.blockengine.ftcloudmessage.exception.ServiceException;
import cn.blockengine.ftcloudmessage.mapper.UserAddressesMapper;
import cn.blockengine.ftcloudmessage.request.AddressRequest;
import cn.blockengine.ftcloudmessage.service.UserAddressesService;
import cn.blockengine.ftcloudmessage.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserAddressesServiceImpl extends BaseService implements UserAddressesService {

    @Resource
    private UserAddressesMapper addressMapper;

    @Override
    public List<UserAddresses> usAddress(HttpServletRequest request) {
        Long userId = getUserId();
        return addressMapper.selectListByUserId(userId);
    }

    @Override
    @Transactional
    public Boolean insertAddress(AddressRequest request) {
        log.info("insertAddress request[{}]", request);
        if (StringUtils.isEmpty(request.getType())) {
            Long userId = getUserId();
            request.setUserId(userId);
        }

        if (StringUtils.isEmpty(request.getUserName()) || StringUtils.isEmpty(request.getMobile())){
            throw new ServiceException("请输入姓名和手机号",1000);
        }

        //校验手机号
        if (StringUtils.isNotEmpty(request.getMobile()) && request.getMobile().length() > 11) {
            throw new ServiceException("请输入正确的手机号",1000);
        }

        if (StringUtils.isNotEmpty(request.getAddress()) && request.getAddress().contains("undefined"))
        {
            throw new ServiceException("请选择地址",1000);
        }
        boolean flag = addressMapper.insertSelective(request) > 0;
        //校验
        if (request.getIsDefault()!=null && request.getIsDefault()){
            checkDefaultAddress(request.getId());
        }
        return flag;
    }

    @Override
    @Transactional
    public Boolean updateAddress(AddressRequest request) {
        log.info("updateAddress request[{}]", request);
        //校验
        if (request.getIsDefault()!=null && request.getIsDefault()){
            checkDefaultAddress(request.getId());
        }
        return updateByPrimaryKeySelective(request) > 0;
    }

    @Override
    @Transactional
    public Boolean deleteAddress(Long id) {
        log.info("deleteAddress id[{}]", id);
        return addressMapper.deleteAddressById(id) > 0;
    }

    @Override
    public UserAddresses getAddressDetail(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Boolean updateDefaultAddress(Long id) {
        checkDefaultAddress(id);
        //更新用户·默认地址
//        userMapper.updateDefaultAddressById(getUserId(), id);
        return addressMapper.updateDefaultAddressById(id) > 0;
    }

    @Override
    public UserAddresses getCurrentUserDefaultAddress() {
        return addressMapper.selectDefaultAddressByUserId(getUserId());
    }

    public int updateByPrimaryKeySelective(UserAddresses record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    private void checkDefaultAddress(Long id) {
        List<UserAddresses> addresses = addressMapper.selectAddressesByUserId(getUserId());
        //修改其他为非默认地址
        addresses = addresses.stream().filter(address -> !address.getId().equals(id)).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(addresses)) {
            addressMapper.updateNoDefaultAddressByIds(addresses.stream().map(UserAddresses::getId).collect(Collectors.toList()));
        }
    }
}
