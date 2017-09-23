//package ru.webmarket.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ru.webmarket.dao.RoleDao;
//import ru.webmarket.dao.UserDao;
//import ru.webmarket.entity.User;
//
//import javax.transaction.Transactional;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private UserDao userDao;
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Override
//    @org.springframework.transaction.annotation.Transactional
//    public void add(User user) {
//        this.userDao.add(user);
//    }
//
//    @Override
//    @org.springframework.transaction.annotation.Transactional
//    public User getUserById(Long id) {
//        return this.userDao.getUserById(id);
//    }
//
//    @Override
//    @org.springframework.transaction.annotation.Transactional
//    public void update(User user) {
//        this.userDao.update(user);
//    }
//
//    @Override
//    @org.springframework.transaction.annotation.Transactional
//    public void delete(Long id) {
//        this.userDao.delete(id);
//    }
//}
