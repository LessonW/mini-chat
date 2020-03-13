package com.foodguide.controller;

import com.foodguide.pojo.*;
import com.foodguide.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class MainController {
    private static  final Log log= LogFactory.getLog(MainController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private SortService sortService;
    @Autowired
    private StarService starService;
    @Autowired
    private RelationService relationService;
    @Autowired
    private WeChatService weChatService;

    /**
    * 获取微信用户的openid并插入数据库
    */
    @RequestMapping("/getAllUserinfo")
    public  User getAllinfo(@RequestParam(value = "code")String  code,
                     @RequestParam(value = "avatar")String  avatar,
                     @RequestParam(value = "nickName")String  nickName){
        log.warn(code);
        log.warn(avatar);
        log.warn(nickName);
        String openid=weChatService.codetoopenid(code);
        User user=new User();

        if(userService.selectByopenid(openid)==null){
            user.setAvater(avatar);
            user.setOpenid(openid);
            user.setNickname(nickName);
            //插入数据库
            userService.addUser(user);

        }
        else {
            log.error("用户已插入数据库");
            log.warn("user 全部信息"+userService.selectByopenid(openid).getId());
        }
        return userService.selectByopenid(openid);

    }


    /**
     * 用户表相关接口
     */
    //查询所有用户
    @RequestMapping("/findall")
    public List<User2> getAllUser() {
        return userService.findAll();
    }

    //添加用户
    @RequestMapping("/adduser")
    public User addUser(User user) {
        userService.addUser(user);
        return user;
    }

    /**
     * 分类表相关接口
     * */
    @RequestMapping("/selectallsort")
    public List<Map<String, Object>> selectAllsort(){
        return sortService.selectAllsort();
    }

    @RequestMapping("/selectByid/{id}")
    public List<Menu> findByid(@PathVariable long id){
        return sortService.findByid(id);
    }



    /**
     * 收藏表相关接口
     */
    //菜谱id查询被收藏
    @RequestMapping("/fav/menuid/{id}")
    public List<Favorite> selectfavBymenuid(int id){
        return favoriteService.selectfavBymenuid(id);
    }
    //查询用户收藏的菜谱
    @RequestMapping("/fav/userid/{id}")
    List<Favorite> selectfavByuserid(int id){
        return favoriteService.selectfavByuserid(id);
    }
    //添加收藏
    @RequestMapping("/addfav")
    int addFav(int menuid,int userid){
        favoriteService.addFav(menuid,userid);
        return menuid;
    }
    //取消收藏
    @RequestMapping("/delfav")
    int delFav(int menuid,int userid){
        favoriteService.delFav(menuid,userid);
        return menuid;
    }

    /**
     * 点赞表相关接口
     */
    //菜谱id查询被点赞
    @RequestMapping("/star/menuid/{id}")
    public List<Star> selectStarBymenuid(int id){
        return starService.selectStarBymenuid(id);
    }
    //查询用户点赞的菜谱
    @RequestMapping("/star/userid/{id}")
    List<Star> selectStarByuserid(int id){
        return starService.selectStarByuserid(id);
    }

    //点赞
    @RequestMapping("/addstar")
    int addstaa(int menuid,int userid){
        starService.addstar(menuid,userid);
        return menuid;
    }
    //取消点赞
    @RequestMapping("/delstar")
    int delstar(int menuid,int userid){
        starService.delstar(menuid,userid);
        return menuid;
    }



    /**
     * 关系表（粉丝表）相关接口
     */
    //查询用户粉丝
    @RequestMapping("/rela?fansid={id}")
    List<Relation> selectRelByfansid(int id){
        return relationService.selectRelByfansid(id);
    }
    //查询用户关注
    @RequestMapping("/rela?userid={id}")
    List<Relation> selectRelByuserid(int id){
        return relationService.selectRelByuserid(id);
    }
    //添加关注
    @RequestMapping("/addrela")
    String addfans(int userid,int fansid){
        relationService.addfans(userid,fansid);
        return  "添加了"+userid;
    }
    //取消关注
    @RequestMapping("/delrela")
    String  delfans(int  userid,int fansid){
        relationService.delfans(userid,fansid);
        return "取消了对"+userid+"关注";
    }


    /**
     * 菜谱表相关接口
     */
    @RequestMapping("/onemenu/{id}")
    public Menu selectOneMenu(@PathVariable  long id) {
        return menuService.selectOneMenu(id);
    }

        //首页菜谱列表
    @RequestMapping("/menulist")
    public List<Menu> getAllMenu() {
        return menuService.selectMenu();
    }

    //菜谱关键词搜索
    @RequestMapping("/search/title/{title}")
    public List<Menu> getMenuBytitle(@PathVariable String title) {
        return menuService.selectMenuBytitle(title);
    }

    //按用户查询菜谱
    @RequestMapping("/search/userid/{id}")
    public List<Menu> selectMenuByuserid(int id) {
        return menuService.selectMenuByuserid(id);
    }

    //按分类查询菜谱
    @RequestMapping("/search/sortid/{id}")
    public List<Menu> selectMenuBysortid(int id) {
        return menuService.selectMenuBysortid(id);
    }

    //发表菜谱
    @RequestMapping(value = "/addmenu",method = { RequestMethod.POST})
    public int insertMenu(@RequestBody Menu menu) {
        log.warn("111");
        menuService.insertMenu(menu);
//        log.warn(menu.getTitle());
        return (int) menu.getId();
//        return 1;
    }

    //删除菜谱
    @RequestMapping("/delmenu")
    public int delMenu(int id) {
        menuService.delMenu(id);
        return id;
    }

    //热门标签
    @RequestMapping("/tip")
    List<HashMap<String,Object>> tip(){
        return menuService.tip();
    }
}