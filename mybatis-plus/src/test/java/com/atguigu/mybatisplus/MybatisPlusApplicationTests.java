package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.media.jfxmedia.logging.Logger;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        List<User> users = this.userMapper.selectList(null);
        System.out.println("=====>>>>" + users);
    }

    @Test
    public void testInsert() {

        User user = new User();
//        user.setId(7L);
        user.setName("gggggggg");
        user.setAge(18);
        user.setEmail("5531733gg2ww@qq.com");

        int result = userMapper.insert(user);
        System.out.println(result); //影响的行数
        System.out.println(user); //id自动回填
    }


    @Test
    public void testUpdateById() {

        User user = new User();
        user.setId(1L);
        user.setAge(28);

        int result = userMapper.updateById(user);
        System.out.println(result);

    }

    /**
     * 2
     * 测试 乐观锁插件
     * 3
     */
    @Test
    public void testOptimisticLocker() {

        //查询
        User user = userMapper.selectById(1L);
        //修改数据
        user.setName("Helen YaoXXXjj");
        user.setEmail("helen@qq.com");
        //执行更新
        userMapper.updateById(user);
    }


    /**
     * 2
     * 测试乐观锁插件 失败
     * 3
     */
    @Test
    public void testOptimisticLockerFail() {

        //查询
        User user = userMapper.selectById(1L);
        //修改数据
        user.setName("Helen Yao4");
        user.setEmail("helen@qq.com1");

        //模拟取出数据后，数据库中version实际数据比取出的值大，即已被其它线程修改并更新了version
        user.setVersion(user.getVersion() - 1);

        //执行更新
        userMapper.updateById(user);
    }

    /**
     * 根据id查询
     */
    @Test
    public void testSelectByid() {
        User user = this.userMapper.selectById(1L);
        System.out.println(user);
    }

    /**
     * 通过多个id查询
     */
    @Test
    public void testIds() {
        List<User> users = this.userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    /**
     * 根据map封装条件查询
     */

    @Test
    public void testMap() {

        Map<String, Object> map = new HashMap<>();

        map.put("name", "Helen Yao4");
        List<User> users = this.userMapper.selectByMap(map);
        System.out.println(users);
    }

    /***
     * 分页查询
     */

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 2);

        IPage<User> selectPage = this.userMapper.selectPage(page, null);

        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());


    }


    @Test
    public void testPageMap() {
        Page<User> page = new Page<>(1, 2);

        IPage<Map<String, Object>> mapIPage = this.userMapper.selectMapsPage(page, null);
        mapIPage.getRecords().forEach(System.out::println);

        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());


    }

    /**
     * 测试 逻辑删除
     */
    @Test
    public void testLogicDelete() {
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }


    @Test
    public void testLogicDeleteSelect() {
        User user = new User();
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 2
     * 测试 性能分析插件
     * 3
     */
    @Test
    public void testPerformance() {
        User user = new User();
        user.setName("我是Helen");
        user.setEmail("helen@sina.com");
        user.setAge(18);
        userMapper.insert(user);
    }

    /***
     * 查询测试
     */

    @Test
    public void querybuilder() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.isNotNull("name")
                .eq("age", 18)
                .isNotNull("email");

        int delete = this.userMapper.delete(queryWrapper);
        System.out.println(delete);
    }

    @Test
    public void query01() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "Jack");
        User user = this.userMapper.selectOne(queryWrapper);
        System.out.println(user);

    }

    @Test
    public void query02() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.between("age", 20, 30);

        List<User> users = this.userMapper.selectList(userQueryWrapper);

        System.out.println(users);


    }

    @Test
    public void query03() {

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 2);
        hashMap.put("name", "Jack");
        hashMap.put("age", 20);

        userQueryWrapper.allEq(hashMap);

        List<User> users = this.userMapper.selectList(userQueryWrapper);
        System.out.println(users);

    }

    @Test
    public void test04() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.notLike("name", "e")
                .likeRight("email", "t");
        List<Map<String, Object>> maps = this.userMapper.selectMaps(userQueryWrapper);
        System.out.println(maps);
    }


}
