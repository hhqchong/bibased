package com.jmu.bibasedmanage.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.jmu.bibasedmanage.consts.CommonConst;
import com.jmu.bibasedmanage.dao.BmStudentDao;
import com.jmu.bibasedmanage.pojo.BmStudent;
import com.jmu.bibasedmanage.pojo.BmTopic;
import com.jmu.bibasedmanage.service.StudentService;
import com.jmu.bibasedmanage.service.TopicService;
import com.jmu.bibasedmanage.util.UUIDUtils;
import com.jmu.bibasedmanage.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

/**
 * Created by ljc on 2017/12/18.
 */
@Transactional
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private BmStudentDao bmStudentDao;
    @Resource
    private TopicService topicService;

    public Page<BmStudent> list(Map map, Page<BmStudent> page) {
        PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
        List<BmStudent> students = bmStudentDao.selectByPage(pageBounds);
        page.setResult(students);
        page.setTotalCountByPageList((PageList) students);
        return page;
    }

    public String add(BmStudent bmStudent) {
        String id = UUIDUtils.generator();
        bmStudent.setId(id);
        bmStudent.setCreateTime(new Date());
        bmStudentDao.insert(bmStudent);
        return id;
    }

    public void update(BmStudent bmStudent) {
        bmStudent.setUpdateTime(new Date());
        bmStudentDao.updateByPrimaryKeySelective(bmStudent);
    }

    public void delete(String id) {
        BmStudent bmStudent = new BmStudent();
        bmStudent.setId(id);
        bmStudent.setRecordStatus(CommonConst.RECORD_STATUS_DELETED);
        bmStudentDao.updateByPrimaryKeySelective(bmStudent);
    }

	@Override
	 public BmStudent getById(String id) {
        return bmStudentDao.selectByPrimaryKey(id);
    }

}
