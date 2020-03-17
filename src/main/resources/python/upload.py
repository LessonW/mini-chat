# -*- coding: utf-8 -*-
# flake8: noqa
import json
import qiniu
from qiniu import Auth
from qiniu import BucketManager

access_key = 'GOuhUINKN0-LhA6ANW2cj_d-aJ-KEk6VUz_bQmCp'
secret_key = '99Fwz7a_u1DKue2hqVRGx_ct174_pAUiXOIk9nOi'

bucket_name = 'miniprogram-w'

q = Auth(access_key, secret_key)

bucket = BucketManager(q)

url = 'https://i8.meishichina.com/attachment/recipe/2020/02/26/20200226158271507447921710541710.JPG?x-oss-process=style/p800'

key = '99.jpg'

ret, info = bucket.fetch(url, bucket_name, key)
print(info.text_body)
ss= json.loads(info.text_body)
# print(type(ss))s
print(ss["key"])
assert ret['key'] == key
