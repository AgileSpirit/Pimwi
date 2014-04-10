<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false" %>

<jsp:include page="../fragments/html-top.jsp"/>

<jsp:include page="../fragments/header.jsp"/>

<div id="body">
    <div class="container">

        <div class="row">

            <div class="col-md-6 col-md-offset-3" role="main">
                <div class="search">
                    <div class="panel panel-default">
                        <div class="panel-heading">Search results</div>
                        <!-- Persons found -->
                        <div class="panel-body app-list">
                            <c:forEach items="${persons}" var="person">
                                <div class="app-list-item person">
                                    <div class="pull-left">
                                        <img class="profile-picture" src="${person.picture}">
                                    </div>
                                    <div class="actions pull-right">
                                        <button class="btn btn-default">Message</button>
                                        <button class="btn btn-success" onclick="window.location='friends/add/${person.id}'">Add Friend</button>
                                        <button class="btn btn-danger" onclick="window.location='friends/remove/${person.id}'">Remove</button>
                                    </div>
                                    <strong><a href="#">${person.fullName}</a></strong><br>
                                    (X mutual friends)
                                    <div class="clearfix">&nbsp;</div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div> <!-- /container -->
</div><!-- End body -->

<jsp:include page="../fragments/footer.jsp"/>

<jsp:include page="../fragments/html-bottom.jsp"/>
