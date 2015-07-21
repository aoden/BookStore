<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../head.jsp"></jsp:include>
<body>
<jsp:include page="../nav.jsp"></jsp:include>
<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-md-3">
            <p class="lead">Online Bookstore</p>
        </div>
        <div class="col-md-9">
            <a href="add_product" class="btn btn-primary">Add</a>
            <table class="table table-bordered">
                <thead>
                <th>Id</th>
                <th>Title</th>
                <th></th>
                </thead>
                <tbody>
                <c:forEach var="i" items="${products}">
                    <tr>
                        <td>${i.id}</td>
                        <td><c:out value="${i.name}"></c:out></td>
                        <td><a href="edit_product?id=${i.id}" class="btn btn-primary">Edit</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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
