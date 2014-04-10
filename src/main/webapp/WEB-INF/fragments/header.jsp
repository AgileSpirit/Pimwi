<%@ page session="false" %>

<div id="header" class="navbar navbar-default navbar-fixed-top" role="navigation">
    <!-- Fixed navbar -->
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="news">Eh Coco !</a>
                </div>
                <div class="navbar-collapse collapse">
                    <div class="col-lg-6 search-bar">
                        <form class="navbar-form navbar-left search-form" role="search" method="GET" action="search">
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search" name="query" >
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="news" data-toggle="tooltip" title="Go to your news feed" data-placement="bottom" data-container="body"><span class="glyphicon glyphicon-home"></span></a></li>
                        <li><a href="friends" data-toggle="tooltip" title="Manage your friends" data-placement="bottom" data-container="body"><span class="glyphicon glyphicon-user"></span></a></li>
                        <li><a href="messages" data-toggle="tooltip" title="Manage your message box" data-placement="bottom" data-container="body"><span class="glyphicon glyphicon-envelope"></span></a></li>
                        <li></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-cog"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="settings">Profile</a></li>
                                <li class="divider"></li>
                                <li><a href="logout">Log out</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>
</div><!-- End header -->

