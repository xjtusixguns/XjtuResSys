### 系统的主要工作环境
这个系统产生的环境是：西安交大SixGuns软件小组在东南门外恰饭。  
该店老板娘受累于频繁使用书面记订单之苦，在得知我们是计算机系学生之后，她请我们为她本人开发一个手机软件，专门用来给她电子记账。
为了展现交大学子的伟大情操和理想，我们义务为她开发了这款安卓软件。

### 这个系统的环境
基于android api25开发。老板娘手机是Pixel 3，于是我们基于Pixel 3开发。

### 这个系统的工作方式
首先打开软件。软件在安装之后第一次打开会建立数据库，含User和Orders表单。
界面有三个：菜单、预备、我。预备栏相当于购物车。
在菜单中点击菜品，预备栏中将会出现对应的菜品。然后选好之后，点击预备栏中的确认键。
接下来就会提示登录或者注册用户。
因为第一次使用，那我们就先进入“我”界面来注册。
在桌号和密码栏填入账号信息，点击注册即可注册成果。记得桌号不可重复，否则会覆盖账号。
注册成功之后点击登录即可登录。
然后回到“预备”栏，再次点击提交即可在“我”界面展示订单信息。