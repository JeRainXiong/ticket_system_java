 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="common/head.jsp" %>
</head>
<body>
 <%@ include file="common/nav.jsp" %>

 

    <div class="list-page-content" style="background:#fff;">
        <div class="container clearfix clear-aside-border">
            <div class="sort-order">
                <div class="sort-item-container">
                    <a class="active" sort="sorting=weight&amp;seq=desc">所有结果</a>
                </div>

            </div>
            <div class="shows-container">
<c:choose> 
	<c:when test="${concertList!=null}"> 
		<c:forEach items="${concertList }" var="concert">
 

                <a class="show-items sa_entrance" target="_blank" href="/content/c?concert=${concert.concertId }" data-sectionname="搜索列表" data-showname="${concert.concertName }" data-showoid="${concert.concertId }" data-showtype="1" data-showtypedisplayname="演唱会">
                    <div class="show-inner">
                        <div class="row-wrapper">
                        <div class="show-poster">
                            <img src="${concert.concertImg }" data-src="${concert.concertImg }">
                            
                        </div>
                        <div class="show-detail">
                            <div class="show-name" title="${concert.concertName }">${concert.concertName }</div>
                            <div class="show-desc"></div>
                            <div class="tags">
                                
                                
                                
                                <span class="tag prebuy">预售</span>
                                
                                
                                
                            </div>
                            <div class="row-wrapper bottom-align">
                                <div class="show-time">${concert.concertTime}</div>
                                <div class="show-addr">${concert.concertAddr}</div>
                                <div class="show-price">
                                    
                                        ${concert.concertLowerPrice}<span class="price-unit">元起</span>
                                    
                                    <!--<span class="fr"><i class="icon-c icon-c-list-favourite"></i></span>-->
                                </div>
                            </div>
                        </div>
                        </div>
<!--                         <div class="bottom-info">
                            <div class="info-one"><i class="icon icon-scan"></i>&nbsp;3186365人浏览</div>
                            <div class="info-one"><i class="icon icon-like"></i>&nbsp;404人想看</div>
                        </div> -->
                    </div>
                </a>

		</c:forEach>
	</c:when>  
    <c:otherwise>

            <div class="list_row" style="display:block;padding:0 0 100px 0" > 
                <div style="text-align: center;padding: 10px 0;font-size: 16px;color: #010000"><div class="icon icon-no-data"></div></div> 
            </div>
	</c:otherwise>
</c:choose> 
             <div style="display: inline-block;padding-left:100%;">
            </div>
            <div class="page-component">
                <ul class="pagination-sm pagination fr">
                    
                        <li class="pagination-page deactive">
                            <div class="icon icon-page-pre"></div>
                        </li>

                        <li class="pagination-page active"><a pagination="offset=0&amp;length=10">1</a></li>
                        <li class="pagination-page deactive">
                            <div class="icon icon-page-next"></div>
                        </li>
                    
                </ul>
            </div>
            </div>
        </div>
    </div>

<%@ include file="common/login.jsp" %>

<script type="text/javascript" src="js/common/page.js"></script>
</body>
</html>

