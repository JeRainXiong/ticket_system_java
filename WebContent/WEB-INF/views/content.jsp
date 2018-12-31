 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="common/head.jsp" %>
</head>
<body>
 <%@ include file="common/nav.jsp" %>



<div class="show-detail-page" concert_id = '${concertId}'>
    <div class="breadcrumb">
        <ul class="container">
            <li><a href="/">首页<span>&gt;</span></a></li>
            <li><a href="/list?type=1">演唱会<span>&gt;</span></a></li>
            <li class="active">${concert.concertName}</li>
        </ul>
    </div>
    <div class="content-ticket">
        <div class="container">
            <div class="show-container">
                <div class="show-ticket">
                    <div class="show-poster">
                        <a href="${concert.concertImg}" target="_blank">
                            
                            <div class="discount">
                                <div class="ie9-discount-bg">
                                6.
                                <span class="small-number">1</span>
                                <div class="unit">折起</div>
                                </div>
                            </div>
                            
                            <img class="" src="${concert.concertImg}" data-src="${concert.concertImg}" alt="${concert.concertName}">
                        </a>
                        <div class="show-count">
                            <i class="icon icon-scan"></i>27530人浏览
                            <i class="icon icon-like"></i><span id="favourNum">193</span>人想看
                        </div>
                    </div>
                    <div class="show-calendar">
                        <div class="show-title">
                                <span class="show-name">${concert.concertName}</span>
                                <div class="show-tag-container">
                                    
                                    <!-- <div class="show-tag seat-selectable"></div> -->
                                    
                                    <div class="show-tag electric-ticket">电子票</div>
                                <!-- <div class="show-tag coupon"></div> -->

                                </div>
                            </div>
                            <div class="show-info">
                                ${concert.concertTime}&nbsp;&nbsp;&nbsp;&nbsp;${concert.concertAddr}
                                
                                
                                
                                
                                
                            </div>
                        
                        <div class="innercontainer">
                            <div class="list-box" id="calendarBox">
                                <h4>
                                    <p>选择日期</p>
                                </h4>
                                <div class="list list-normal">
                                    <div class="datepickerBox" id="datepickerBox">
                                        <div class="control">
                                            <button class="lastyear" style="display: none;">&lt;&lt;</button>
                                            <button class="lastmonth">
                                                &lt;
                                            </button>
                                            <div class="title">
                                                <label class="currentyear"></label>
                                                <label class="currentmonth"></label>
                                            </div>    
                                            <button class="nextmonth">
                                                &gt;
                                            </button>
                                            <button class="nextyear" style="display: none;">&gt;&gt;</button>
                                        </div>
                                        <div class="week">
                                            <ul>
                                                <li class="date-title">
                                                    <label>一</label>
                                                    <label>二</label>
                                                    <label>三</label>
                                                    <label>四</label>
                                                    <label>五</label>
                                                    <label>六</label>
                                                    <label>日</label>
                                                </li>
                                                <li class="dinamicDom">
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="list-box">
                                <h4>
                                    <p>选择场次</p>
                                </h4>
                                <div class="list list-normal" id="session-container">
    
    <ul>
        
        <li>
            <div class="normal-list-item list-one active" data-id="" data-time="${concertTime}">
                <p>${concertTime}</p>
                <!--<i class="icon icon-express-corner"></i>-->
            </div>
        </li>
        
    </ul>
    
</div>
                            </div>
                            <div class="list-box seatPlan">
                                <h4>
                                    <p>选择票面</p>
                                </h4>
                                <div class="list list-normal overflow-visible">
                                    <div class="list list-normal overflow-visible" id="sessionPar-container">
    
    <ul class="seatPlan-txt">
    
    	<c:forEach items="${ticketTypeList}" var="${ticketType}">
        <li class="relative ">
            
            <div class="ticket normal-list-item list-one" data-id="${ticketType.ticketTypeId}" data-price="${ticketType.unitPrice}">
                
                <span class="price">${ticketType.unitPrice}票面</span>
                
                <!--<i class="icon icon-express-corner"></i>-->
            </div>
        </li>


        </c:forEach>
    </ul>
    
</div>
                                </div>
                            </div>
                            <div class="list-box">
                                <h4>
                                    <p>选择数量</p>
                                </h4>
                                <div class="book_row_num">
                                    <div class="number-input-wrapper">
                                        <span id="reduce-one">-</span>
                                        <input value="1" class="buy-num" readonly="">
                                        <span id="add-one">+</span>
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="list-box money-row">
                                <h4 class="summation-label">
                                    <p>合计</p>
                                </h4>
                                <div class="list list-normal money">
                                    <span class="red">0</span>
                                    <span class="unit">元</span>
                                    <span id="unit-price" class="unit-price">0元/张</span>
                                </div>
                            </div>
                            <div class="list-box">
                                <div class="">
                                    

                                    
                                    <button class="buyticket-top" id="js-preorder-btn" type="button">立即购票</button>
                                    
                                    
                                </div>
                            </div>
                        </div>                    

                        
                        
                        <div class="ticket-tip-button">
                        
                        
                        
                        </div>
                    </div>
                </div>
                <div class="show-middle"></div>
            </div>
        </div>
    </div>
    
    <div class="content-intro normal">
        <ul class="show_tab">
            <li class="active" data="intro_panel">
                <a href="javascript:;" onclick="">演出介绍</a>
                <div class="border-line"></div>
            </li>
            <li data="flow_panel">
                <a href="javascript:;">购买流程</a>
                <div class="border-line"></div>
            </li>
            <li data="tips_panel">
                <a href="javascript:;">购票提示</a>
                <div class="border-line"></div>
            </li>
	    </ul>
    	<div class="content">
	        <div class="normal container content-container">
	            <div class="center-content">
	                <div class="intro-main" id="intro_panel">
	                    <div class="intro-main-row">
                            <a name="intro_panel"></a>
	                        <h3 class="intro-main-row-title">演出介绍</h3>
	                        <div class="intro-main-row-txt">
	                            <ul class="content_txt">
	                                ${concert.concertDecription}
	                            </ul>
	                        </div>
	                    </div>
	                </div>
                    <div class="intro-main" id="flow_panel" style="display: none">
                        <div class="intro-main-row">
                            <a name="flow_panel"></a>
                            <ul class="" style="font-size: 17px"></ul>
                            <ul class="" style="font-size: 17px;font">
                                <li>网上订购流程</li>
                                <br>
                                <li class=""><p>选择演出→确认订单信息→选择支付方式→完成购票</p></li>

                            </ul>
                        </div>
                    </div>	                
                    <div class="intro-main" id="tips_panel" style="display: none">
                        <div class="intro-main-row">
                            <a name="tips_panel"></a>
                            <ul class="intro-main-row-title">购票提示</ul>
                            <ul class="intro-main-row-txt text-left">
                                <p>1、演出详情仅供参考，具体信息以主办方公布信息及现场为准，请准时到场以免错过演出。</p>
                                <p>2、本票务网站的仅用于模拟购票流程，不提供实际演唱会门票!</p>
                            </ul>
                        </div>
                    </div>
	            </div>
	            <div class="right-content">
                    <div class="appointment-title">相关演出</div>
                    <div class="appointment">
                        <div class="appoint-list">
                              
                            <div class="appoint-list-row active">
                                <a href="#" target="_blank">
                                    <img src="/concertimg/XczKeYFPw8.jpg"  width="56" height="72">
                                    <span class="appoint-info">
                                        <span class="desc">【上海站】【万有音乐系】麦斯米兰 “Sea of Silence” 寂静如海 2018巡回演唱会</span>
                                        <span class="time">2018.04.18</span>
                                        <span class="addr">上海商城剧院</span>
                                    </span>
                                    <span class="list-icon-placeholder"><i class="icon icon-list-arrow"></i></span>
                                    <span class="show-name">
                                        【上海站】【万有音乐系】麦斯米兰 “Sea of Silence” 寂静如海 2018巡回演唱会
                                    </span>
                                </a>
                            </div>
                              
                            <div class="appoint-list-row active">
                                <a href="#" target="_blank">
                                    <img src="/concertimg/H8h3SSZERY.jpg" alt="【上海站】《不忘初心》——海之花中外红歌演唱会" width="56" height="72">
                                    <span class="appoint-info">
                                        <span class="desc">【上海站】《不忘初心》——海之花中外红歌演唱会</span>
                                        <span class="time">2018.03.03</span>
                                        <span class="addr">人民大舞台</span>
                                    </span>
                                    <span class="list-icon-placeholder"><i class="icon icon-list-arrow"></i></span>
                                    <span class="show-name">
                                        【上海站】《不忘初心》——海之花中外红歌演唱会
                                    </span>
                                </a>
                            </div>
                              
                            <div class="appoint-list-row active">
                                <a href="#" target="_blank">
                                    <img src="/concertimg/i6KzHXNMep.jpg"  alt="【上海站】《我心永恒》——海之花影视金曲一起来" width="56" height="72">
                                    <span class="appoint-info">
                                        <span class="desc">【上海站】《我心永恒》——海之花影视金曲一起来</span>
                                        <span class="time">2018.02.18</span>
                                        <span class="addr">人民大舞台</span>
                                    </span>
                                    <span class="list-icon-placeholder"><i class="icon icon-list-arrow"></i></span>
                                    <span class="show-name">
                                        【上海站】《我心永恒》——海之花影视金曲一起来
                                    </span>
                                </a>
                            </div>
                            
                            <!--<div class="appoint-more"><a href="/list">更多 <sup>…</sup></a></div>-->
                        </div>
                    </div>
                </div>
	        </div>
        </div>
    </div>
    <div class="error_tip"></div>


    </div>
    <%@ include file="common/login.jsp" %>

    </body>

<script type="text/javascript" src="js/common/page.js"></script>
    </html>
