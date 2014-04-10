<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false" %>

<jsp:include page="../fragments/html-top.jsp"/>

<jsp:include page="../fragments/header.jsp"/>

<div id="body">
    <div class="container">

        <div class="row">

            <div class="col-md-6 col-md-offset-3" role="main">
                <div class="friends">
                    <div class="panel panel-default">
                        <div class="panel-heading">Friends</div>
                        <div class="panel-body app-list">
                            <!-- Friend list -->
                            <c:forEach items="${friends}" var="friend">
                                <div class="app-list-item friend">
                                    <div class="pull-left">
                                        <img class="profile-picture" src="${friend.picture}">
                                    </div>
                                    <div class="actions pull-right">
                                        <button class="btn btn-default">Message</button>
                                        <button class="btn btn-danger" onclick="window.location='friends/remove/${friend.id}'">Remove</button>
                                    </div>
                                    <strong><a href="#">${friend.fullName}</a></strong>
                                    <div class="clearfix"></div>
                                </div>
                            </c:forEach>
                        </div>

                        <!--
                        <div class="panel-footer text-center">
                            <button type="button" class="btn btn-default">Load more</button>
                        </div>
                        -->
                    </div>
                </div>
            </div>

        </div>

    </div> <!-- /container -->
</div><!-- End body -->

<jsp:include page="../fragments/footer.jsp"/>

<jsp:include page="../fragments/html-bottom.jsp"/>
