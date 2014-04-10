<%@ page session="false" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../fragments/html-top.jsp"/>

<style>
    body {
        background-color: white;
    }
</style>

<div id="body">
    <div class="container">

        <div class="row">
            <div class="col-md-4 col-md-offset-4 panel panel-default">
                <div class="panel-body">
                    <form:form role="form" action="login" method="post" commandName="loginForm">
                        <h2 class="">Please sign in</h2>
                        <div class="form-group">
                            <form:input path="login" type="text" class="form-control" placeholder="Login" required="true" autofocus="true" />
                        </div>
                        <div class="form-group">
                            <form:input path="password" type="password" class="form-control" placeholder="Password" required="true" />
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    </form:form>
                </div>
            </div>
        </div>

    </div> <!-- /container -->
</div><!-- End body -->

<jsp:include page="../fragments/html-bottom.jsp"/>
