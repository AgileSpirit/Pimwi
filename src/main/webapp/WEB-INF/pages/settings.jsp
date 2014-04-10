<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false" %>

<jsp:include page="../fragments/html-top.jsp"/>

<jsp:include page="../fragments/header.jsp"/>

<div id="body">
    <div class="container">

        <div class="row">

            <div class="col-md-6 col-md-offset-3" role="main">
                <div class="settings">
                    <div class="panel panel-default">
                        <div class="panel-heading">Settings</div>
                        <div class="panel-body">
                            <form:form class="form-horizontal" method="POST" action="settings" modelAttribute="settings" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="picture" class="col-sm-4 control-label">Picture : </label>
                                    <div class="col-sm-4">
                                        <img src="${settings.picture}">
                                        <form:input type="file" id="picture" path="file"></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="login" class="col-sm-4 control-label">Login : </label>
                                    <div class="col-sm-4">
                                        <form:input type="text" class="form-control" id="login" path="login" disabled="true"></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-4 control-label">Password : </label>
                                    <div class="col-sm-4">
                                        <form:input type="text" class="form-control" id="password" path="password" disabled="true"></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="firstName" class="col-sm-4 control-label">First name : </label>
                                    <div class="col-sm-4">
                                        <form:input type="text" class="form-control" id="firstName" path="firstName"></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastName" class="col-sm-4 control-label">Last name : </label>
                                    <div class="col-sm-4">
                                        <form:input type="text" class="form-control" id="lastName" path="lastName"></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="col-sm-4 control-label">Email : </label>
                                    <div class="col-sm-4">
                                        <form:input type="text" class="form-control" id="email" path="email"></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="phoneNumber" class="col-sm-4 control-label">Phone number : </label>
                                    <div class="col-sm-4">
                                        <form:input type="text" class="form-control" id="phoneNumber" path="phoneNumber"></form:input>
                                    </div>
                                </div>
                                <hr>
                                <div class="actions text-center">
                                    <button type="button" class="btn btn-default" onclick="window.location='news'">Cancel</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div> <!-- /container -->
</div><!-- End body -->

<jsp:include page="../fragments/footer.jsp"/>

<jsp:include page="../fragments/html-bottom.jsp"/>
