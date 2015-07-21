<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../head.jsp"></jsp:include>
<body>../
<jsp:include page="../nav.jsp"></jsp:include>
<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-md-3">
            <p class="lead">Online Bookstore</p>
        </div>
        <div class="col-md-9">
            <form method="post" action="login">
                <p><label for="userName">ID: </label></p>

                <p>
                    <input name="id" id="userName">
                </p>

                <p><label for="password">Password: </label></p>

                <p>
                    <input id="password" name="password" type="password">
                </p>

                <p><input type="submit" value="Login" class="btn btn-primary"></p>
            </form>
        </div>
    </div>

</div>
<!-- /.container -->

<div class="container">

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>

</html>
