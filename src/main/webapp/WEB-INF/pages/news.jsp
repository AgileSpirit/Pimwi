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

                        <!-- Composer area -->
                        <form:form class="composer" role="composer" method="POST" action="news" commandName="news">
                            <div class="form-group">
                                <form:textarea path="content" class="form-control" rows="3" placeholder="What's on your mind?"></form:textarea>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary pull-right">Post</button>
                            </div>
                            <div class="clearfix"></div>
                        </form:form>

                        <div class="panel-body app-list news-list">
                            <!-- News list -->
                            <c:forEach items="${newsList}" var="news">
                                <div class="news">
                                    <div class="row news-body">
                                        <div class="col-md-2 news-publisher">
                                            <img class="profile-picture" src="${news.publisherPicture}">
                                        </div>
                                        <div class="col-md-10">
                                            <div class="news-content">
                                                <strong><a href="#">${news.publisherName}</a></strong>
                                                <p>${news.content}</p>
                                            </div>
                                            <div class="news-actions">
                                                <a href="#">Like</a>&nbsp;&middot;&nbsp;
                                                <a href="#">Comment</a>&nbsp;&middot;&nbsp;
                                                <a href="#">Share</a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--
                                    <div class="row news-comments">
                                        <div class="comment">
                                            <div class="col-md-2"></div>
                                            <div class="col-md-10">
                                                <p>Lorem ipsum dolor sit amet.</p>
                                            </div>
                                        </div>
                                        <div class="comment">
                                            <div class="col-md-2"></div>
                                            <div class="col-md-10">
                                                <p>Lorem ipsum dolor sit amet.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row news-answer">
                                        <div class="col-md-10 col-md-offset-2">
                                            <input type="text" class="form-control" placeholder="Answer...">
                                        </div>
                                    </div>
                                    -->
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
