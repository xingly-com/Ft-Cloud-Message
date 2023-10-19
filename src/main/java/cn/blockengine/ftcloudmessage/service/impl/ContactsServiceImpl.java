package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.mapper.ContactsMapper;
import cn.blockengine.ftcloudmessage.request.ContactsRequest;
import cn.blockengine.ftcloudmessage.response.ContactsResponse;
import cn.blockengine.ftcloudmessage.service.ContactsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/19 11:49
 */
@Service
@Slf4j
public class ContactsServiceImpl extends BaseService implements ContactsService {

    @Resource
    private ContactsMapper contactsMapper;

    @Override
    public List<ContactsResponse> contactsList(ContactsRequest contacts) {
        contacts.setUserId(getUserId());
        return contactsMapper.selectList(contacts);
    }

    @Override
    public ContactsResponse detail(Long id) {
        return contactsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean add(ContactsRequest contacts) {
        contacts.setUserId(getUserId());
        return contactsMapper.insertSelective(contacts) > 0;
    }

    @Override
    public Boolean update(ContactsRequest contacts) {
        return contactsMapper.updateByPrimaryKeySelective(contacts) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return contactsMapper.deleteByPrimaryKey(id) > 0;
    }
}
