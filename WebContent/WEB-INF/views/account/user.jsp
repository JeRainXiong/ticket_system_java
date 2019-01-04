 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="../common/head.jsp" %>
</head>
<body>
 <%@ include file="../common/nav.jsp" %>
 
<div style="background: #fff;min-height: 600px;">
  <div class="ctrl clearfix">
    <div class="clearfix" style="width:1160px;margin: 0 auto;">
        <div class="center-breadcrumb"><a href="/">首页</a>&nbsp;&gt;&nbsp;用户中心&nbsp;&gt;&nbsp;<span id="curPathName">我的信息</span></div>

        <!--订单中心导航栏-->
        <ul class="order_nav" id="order_nav_container">
            <li>
              <a href="/account/order">
                我的订单
                <br><i class="icon-c  icon-c-myorder "></i>
                <br>
              </a>
            </li>
            
            <li class="active">
              <a href="/account/user" class="active">
                我的信息
                <br><i class="icon-c icon-c-myaddress-hover "></i>
                <br><b></b>
              </a>
            </li>
        </ul>

      <div style="width:919px;float: right;margin-left: 20px;background: #fff;min-height: 600px;">
          <!--订单列表    -->


    <!-- 分页-->
    

   </ul>          
          <div>
            <!--订单状态切换tag-->
            <div class="order_statusBar" id="order_statusBar_container">
              <ul style="width:620px;height:40px;border-bottom:2px solid #eee;display:inline-block;">
                <li class="order_tag_act" data-tagval=""><label class="label-tab">我的信息</label><i class="triDown"></i></li>
<!--                 <li data-tagval="1"><label class="label-tab" style="position: relative">等待支付<span id="toPayCountBar"></span></label><i class="triDown"></i></li> -->
              </ul>        
            </div>
           <!--修改个人信息-->
        <div class= "taketicket ">
           <ul>
           <label for="" style="margin-right:18px;color: #58585A;">昵&nbsp;&nbsp;&nbsp;&nbsp;称&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <label style="margin-left:18px;color: #58585A;">${user.username }</label>
           </ul>
           
           <ul class="box-item-left">
           <label for="" style="margin-right:18px;color: #58585A;"> 姓&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <input class="shipment-name  placeholder" placeholder="真实名" name="realname" value="${user.userRealname}">
           </ul>
           
           <ul  class="box-item-left">
           <label for="" style="margin-right:18px;color: #58585A;"> 身份证&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <input class=" placeholder" placeholder="身份证号" name="IDcard" value="${user.userIdCard}">
           </ul>
           
           <ul class="box-item-left">
           <label for="" style="margin-right:18px;color: #58585A;"> 手机号&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <input class=" placeholder" placeholder="手机号" name="IDcard" value="${user.tel}">
           </ul>
           
           <div class="fr" id="submit_user_info">
                    
                    <span class="btn btn-main adress_save"><a class="" style="display:block;">保 存</a></span>
           </div>
        </div>
    <HR  width="98%" color=#f2efef SIZE=1>
    <!--修改密码--> 
         <div class = "taketicket">
         <div class= "box-item-left">
           <label for="" style="margin-right:18px;color: #58585A;">原密码&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <input type="password" class="name placeholder" placeholder="请输入原密码" name="OldPassword" >
           </div>
           
            <div class= "box-item-left">
           <label for="" style="margin-right:18px;color: #58585A;">新密码&nbsp;&nbsp;&nbsp;&nbsp;</label>
           <input  type="password" class="name placeholder" placeholder="请输入新密码" name="NewPassward" >
           </div>
           
           <div class= "box-item-left">
           <label for="" style="margin-right:18px;color: #58585A;">确认密码</label>
           <input  type="password" class="name placeholder" placeholder="请再次输入新密码" name="AgainNewPassward" >
           </div>
           
           <div class="fr" id="submit_password">                    
                    <span class="btn btn-main adress_save"><a class="" style="display:block;">保 存</a></span>
           </div>
           
         </div>
        
         </div>
               
                  
      </div>
    </div>

     

  </div>
    </div>
  
 <%@ include file="../common/login.jsp" %>

<script type="text/javascript" src="js/common/page.js"></script>
</body>
</html>