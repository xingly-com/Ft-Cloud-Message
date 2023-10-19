package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.request.ContactsRequest;
import cn.blockengine.ftcloudmessage.response.ContactsResponse;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/19 11:49
 */
public interface ContactsService {

    List<ContactsResponse> contactsList(ContactsRequest contacts);

    ContactsResponse detail(Long id);

    Boolean add(ContactsRequest contacts);

    Boolean update(ContactsRequest contacts);

    Boolean delete(Long id);
}
