# -*- coding: utf-8 -*-

import pymysql
import sys
import requests
from lxml import etree
import json
from qiniu import Auth
from qiniu import BucketManager
import random

list_url = "https://home.meishichina.com/recipe/zhou/page/"
sort_id=20
# 获取分类下的所有菜单 id
list_xpath="//div[@class='ui_newlist_1 get_num']//li/@data-id"
#获取标题
title_xpath="//a[@id='recipe_title']/text()"
#封面图
img_xpath="//a[@class='J_photo']/img/@src"

#获取作者
user_xpath="//span[@class='userName']/text()"
#获取步骤数
stepnum_xpath="//div[@class='recipeStep_num']/text()"
#获取步骤
step_xpath="//div[@class='recipeStep_word']/text()"
#小技巧
tip_xpath="//div[@class='recipeTip']/text()"
# 获取详情页下所有的菜谱原料-名称
lax_xpath="//span[@class='category_s1']//b/text()"
# 获取详情页下所有的菜谱原料-份量
lay_xpath="//span[@class='category_s2']/text()"
# 获取详情页下封面图片
# pic_xpath="//a[@class='J_photo']/img/@src"



def xmlDecode(url, s_xpath):
    ua = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36'
    with requests.request('GET', url, headers={'User-agent': ua}) as res:
        content = res.text.encode("raw_unicode_escape")        # print (ss)
        html = etree.HTML(content)  # 分析HTML，返回DOM根节点
        s = html.xpath(s_xpath)
        # print type(s)
        return s

def dbInsert(sql):
    db = pymysql.connect("localhost","root","root123456","FoodGuide" )
    # 使用cursor()方法获取操作游标
    cursor = db.cursor()
    # # SQL 插入语句
    # sql = "INSERT INTO menu(FIRST_NAME, LAST_NAME, AGE, SEX, INCOME)  VALUES ('%s', '%s', '%d', '%c', '%d' )" % ('Mac', 'Mohan', 20, 'M', 2000)
    try:
       # 执行sql语句
       cursor.execute(sql)
       # 执行sql语句
       db.commit()
       print("insert ok")
    except Exception as e:
        print ('Exception: ', e)
        db.rollback()
        db.close()

def upload(imgurl,imgname):
    access_key = 'GOuhUINKN0-LhA6ANW2cj_d-aJ-KEk6VUz_bQmCp'
    secret_key = '99Fwz7a_u1DKue2hqVRGx_ct174_pAUiXOIk9nOi'
    bucket_name = 'miniprogram-wl'
    q = Auth(access_key, secret_key)
    bucket = BucketManager(q)
    ret, info = bucket.fetch(imgurl, bucket_name, imgname)
    # print(info.text_body)
    ss= json.loads(info.text_body)
    s= "http://q6cr1rrud.bkt.clouddn.com/"+ss["key"]
    return s





if __name__ == '__main__':
    for i in range(0,4):
        inc_url= list_url+str(i+2)+"/"
        print(inc_url)

        data_id = xmlDecode(inc_url, list_xpath)
        for i in range(0, len(data_id)):
            url = "https://home.meishichina.com/recipe-" + str(data_id[i]) + ".html"
            title = xmlDecode(url,title_xpath)[0]
            # user = xmlDecode(url,user_xpath)[0]
            step = json.dumps(dict(zip(xmlDecode(url,stepnum_xpath),xmlDecode(url,step_xpath))),ensure_ascii=False)
            img=xmlDecode(url,img_xpath)[0]

            img_qiniu=upload(img,data_id[i])
            material =json.dumps(dict(zip(xmlDecode(url,lax_xpath),xmlDecode(url,lay_xpath))),ensure_ascii=False)

            # addUser_sql="insert IGNORE into user (username) values('%s')"%(user)

            addMenu_sql="insert into menu (title,userid,step,material,img,sortid,state) values('%s','%d','%s','%s','%s','%d','%d')" %(title,random.randint(1,100),step,material,img_qiniu,sort_id,0)

            # print(addMenu_sql)
            dbInsert(addMenu_sql)
            # dbInsert(addUser_sql)



        # addMenu ="INSERT INTO user2 (name) VALUES ('%s')" % (ss)
        # print (addMenu)
        # dbInsert(addMenu)






