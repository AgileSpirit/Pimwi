<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false" %>

<jsp:include page="../fragments/html-top.jsp"/>

<jsp:include page="../fragments/header.jsp"/>

<div id="body">
    <div class="container">

        <div class="row">

            <div class="col-md-6 col-md-offset-3" role="main">
                <div class="newsfeed">
                    <div class="panel panel-default">
                        <div class="panel-heading">News Feed</div>
                        <div class="panel-body app-list">
                            <!-- News list -->
                            <c:forEach items="${newsList}" var="news">
                                <div class="app-list-item news">
                                    <div class="pull-left">
                                        <img class="profile-picture" src="${news.publisherPicture}">
                                    </div>
                                    <strong><a href="#">${news.publisherName}</a></strong>
                                    <p>${news.content}</p>
                                    <div class="clearfix"></div>
                                </div>
                            </c:forEach>
                        </div>

                        <div class="panel-footer text-center">
                            <button type="button" class="btn btn-default">Load more</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div> <!-- /container -->
</div><!-- End body -->

<jsp:include page="../fragments/footer.jsp"/>

<jsp:include page="../fragments/html-bottom.jsp"/>
