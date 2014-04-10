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
            <div class="col-md-4 col-md-offset-4 text-center">
                <h1>Sorry !</h1>
                <p>An error occured. It might be your session that has been expired, a bug, hasrd, anything else. Whatever, don't be afraid. Just follow the link belowand... Try again !</p>
                <div>
                    <button class="btn btn-default" onclick="location.href='login'">Return to login page</button>
                </div>
            </div>
        </div>

    </div> <!-- /container -->
</div><!-- End body -->

<jsp:include page="../fragments/html-bottom.jsp"/>
